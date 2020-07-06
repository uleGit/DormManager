package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Message;
import entity.Repairs;
import jdbc.DBUtil;
public class RepairsDao {
	
	//添加报修信息
	public void addRepair(Repairs r) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + "insert into repairs "
					  + " (budno,dor,detail,result,time) "
					  + " values(?,?,?,?,current_date()); ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, r.getBudno());
		stmt.setInt(2, r.getDor());
		stmt.setString(3, r.getDetail());
		stmt.setString(4, r.getResult());
		
		stmt.execute();
		
	}
	//更新报修状态
	public void updRepair(Repairs r) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + 
				 " update repairs " + 
				 " set handler=?,result=? " + 
				 " where id=? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, r.getHandler());
		stmt.setString(2, r.getResult());
		stmt.setInt(3, r.getId());
		
		stmt.execute();
	}
	//查找报修信息楼号
	public Integer querybud(Integer budno) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select budno from repairs where budno=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, budno);
		ResultSet rs = ptmt.executeQuery();
		Integer i = 0;
        while(rs.next()) {
            i = rs.getInt("budno");
        }
        return i;
	}
	//查找报修信息楼号
	public Integer querydor(Integer dor) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select dor from repairs where dor=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, dor);
		ResultSet rs = ptmt.executeQuery();
		Integer i = 0;
        while(rs.next()) {
            i = rs.getInt("dor");
        }
        return i;
	}

	//按照楼栋号查询报修信息
	public ArrayList<Repairs> queryRepairs(Integer budno){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Repairs> repairs = new ArrayList<Repairs>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = " select id,dor,budno,detail,handler,result,time from repairs where budno=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, budno);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Repairs repair = new Repairs();
				repair.setId(rs.getInt("id"));
				repair.setDor(rs.getInt("dor"));
				repair.setBudno(rs.getInt("budno"));
				repair.setDetail(rs.getString("detail"));
				repair.setHandler(rs.getString("handler"));
				repair.setResult(rs.getString("result"));
				repair.setTime(rs.getDate("time"));
				repairs.add(repair);
			}
			return repairs;
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
	//按照楼栋号+宿舍号查询报修信息
		public ArrayList<Repairs> queryRepairs(Integer budno,Integer dorno){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Repairs> repairs = new ArrayList<Repairs>();
			
			try {
				conn = DBUtil.getConnection();
				String sql = " select dor,budno,detail,handler,result,time from repairs where budno=? and dor=?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, budno);
				stmt.setInt(2, dorno);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Repairs repair = new Repairs();
					repair.setDor(rs.getInt("dor"));
					repair.setBudno(rs.getInt("budno"));
					repair.setDetail(rs.getString("detail"));
					repair.setHandler(rs.getString("handler"));
					repair.setResult(rs.getString("result"));
					repair.setTime(rs.getDate("time"));
					repairs.add(repair);
				}
				return repairs;
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
		
		//按照id查找具体报修信息
		public Repairs queryRepair(Integer id){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Repairs repair = new Repairs();
			try {
				conn = DBUtil.getConnection();
				String sql = " select id,dor,budno,detail,handler,result,time from repairs where id=? ";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				while(rs.next()) {
					repair.setId(rs.getInt("id"));
					repair.setDor(rs.getInt("dor"));
					repair.setBudno(rs.getInt("budno"));
					repair.setDetail(rs.getString("detail"));
					repair.setHandler(rs.getString("handler"));
					repair.setResult(rs.getString("result"));
					repair.setTime(rs.getDate("time"));
				}
				return repair;
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
