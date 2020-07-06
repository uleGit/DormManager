package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Student;
import jdbc.DBUtil;

public class StudentDao {

	//增加学生
	public void addStudent(Student s) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + "insert into student "
					  + " (sno,sname,cno,budno,dor,bed) "
					  + " values(?,?,?,?,?,?); ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, s.getSno());
		stmt.setString(2, s.getSname());
		stmt.setInt(3, s.getCno());
		stmt.setInt(4, s.getBudno());
		stmt.setInt(5, s.getDor());
		stmt.setInt(6, s.getBed());
		
		stmt.execute();
	}	
	
	//删除学生
	public void delStudent(Integer sno) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + " delete from student "
					  + "where sno like ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, "%"+sno+"%");//按学号like删除
		
		stmt.execute();
	}
	//按照宿舍号删除学生
	public void delStudent_dor(Integer dor) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + " delete from student "
					  + "where dor like ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, "%"+dor+"%");//按学号like删除
		
		stmt.execute();
	}
	//按照班级号删除学生
	public void delStudent_cno(Integer cno) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + " delete from student "
					  + "where cno like ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, "%"+cno+"%");//按学号like删除
		
		stmt.execute();
	}
	//修改学生
	public void updStudent(Student s) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + " update student "
					  + "set sno=?,sname=?,cno=?,budno=?,dor=?,bed=? "
					  + "where id=? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, s.getSno());
		stmt.setString(2, s.getSname());
		stmt.setInt(3, s.getCno());
		stmt.setInt(4, s.getBudno());
		stmt.setInt(5, s.getDor());
		stmt.setInt(6, s.getBed());
		stmt.setInt(7, s.getId());
		
		stmt.execute();
	}
	
	//查询学号
    public Integer query_sno(Integer sno)throws Exception {
    	Connection conn = DBUtil.getConnection();
        String sql = "select sno from student where sno=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ""+sno+"");
        ResultSet rs = stmt.executeQuery();
        Integer i = 0;
        while(rs.next()) {
            i = rs.getInt("sno");
        }
        return i;
    }
    
    //查询宿舍号
    public Integer query_dor(Integer dor)throws Exception {
    	Connection conn = DBUtil.getConnection();
        String sql = "select dor from student where dor=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ""+dor+"");
        ResultSet rs = stmt.executeQuery();
        Integer i = 0;
        while(rs.next()) {
            i = rs.getInt("dor");
        }
        return i;
    }
    
    //查询班级号
    public Integer query_cno(Integer cno)throws Exception {
    	Connection conn = DBUtil.getConnection();
        String sql = "select cno from student where cno=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ""+cno+"");
        ResultSet rs = stmt.executeQuery();
        Integer i = 0;
        while(rs.next()) {
            i = rs.getInt("cno");
        }
        return i;
    }
    //查询姓名
    public String query_sname(String sname)throws Exception {
    	Connection conn = DBUtil.getConnection();
        String sql = "select sname from student where sname=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, sname);
        ResultSet rs = stmt.executeQuery();
        String s = null;
        while(rs.next()) {
            s = rs.getString("sname");
        }
        return s;
    }
    
	//查询所有学生的学号，姓名，宿舍号,楼栋号信息
	public ArrayList<Student> query() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stus = new ArrayList<Student>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select sno,sname,dor,budno from student ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setDor(rs.getInt("dor"));
				stu.setBudno(rs.getInt("budno"));
				stus.add(stu);
			}
			return stus;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
	//按照学号具体查询
	public Student querysno(Integer sno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Student stu = new Student();
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select id,sno,sname,cno,dor,bed,budno from student where sno = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sno);
			rs = stmt.executeQuery();
			while(rs.next()) {
				stu.setId(rs.getInt("id"));
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setCno(rs.getInt("cno"));
				stu.setDor(rs.getInt("dor"));
				stu.setBed(rs.getInt("bed"));
				stu.setBudno(rs.getInt("budno"));
			}
			return stu;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
	//按照学号模糊查询
	public ArrayList<Student> querySno(Integer sno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stus = new ArrayList<Student>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select id,sno,sname,cno,dor,bed,budno from student where sno like ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+sno+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setCno(rs.getInt("cno"));
				stu.setDor(rs.getInt("dor"));
				stu.setBed(rs.getInt("bed"));
				stu.setBudno(rs.getInt("budno"));
				stus.add(stu);
			}
			return stus;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
	//按照姓名查询
	public ArrayList<Student> querySname(String sname) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stus = new ArrayList<Student>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select id,sno,sname,cno,dor,bed,budno from student where sname like ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+sname+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setCno(rs.getInt("cno"));
				stu.setDor(rs.getInt("dor"));
				stu.setBed(rs.getInt("bed"));
				stu.setBudno(rs.getInt("budno"));
				stus.add(stu);
			}
			return stus;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
	//按照班级号查询
	public ArrayList<Student> queryCno(Integer cno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stus = new ArrayList<Student>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select id,sno,sname,cno,dor,bed,budno from student where cno like ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+cno+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setCno(rs.getInt("cno"));
				stu.setDor(rs.getInt("dor"));
				stu.setBed(rs.getInt("bed"));
				stu.setBudno(rs.getInt("budno"));
				stus.add(stu);
			}
			return stus;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
	//按照宿舍号查询
	public ArrayList<Student> queryDor(Integer dor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> stus = new ArrayList<Student>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " select id,sno,sname,cno,dor,bed,budno from student where dor like ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+dor+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setCno(rs.getInt("cno"));
				stu.setDor(rs.getInt("dor"));
				stu.setBed(rs.getInt("bed"));
				stu.setBudno(rs.getInt("budno"));
				stus.add(stu);
			}
			return stus;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally{
			//释放数据集
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			//释放数据对象
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
			}
		}
	}
	
}
