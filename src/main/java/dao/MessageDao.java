package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Message;
import jdbc.DBUtil;

public class MessageDao {
	
	//添加公示信息
	public void addMessage(Message mess) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "" + " insert into message "
						 + " (userNum,messno,outline,content,time) "
						 + " values(?,?,?,?,current_date());";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, mess.getUserNum());
			stmt.setInt(2, mess.getMessno());
			stmt.setString(3, mess.getOutline());
			stmt.setString(4, mess.getContent());
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
	//查询信息码
	public Integer query_messno(Integer m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = " select messno from message where messno=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, m);
			rs = stmt.executeQuery();
			int messno=0;
			while(rs.next()) {
				messno = rs.getInt("messno");
			}
			return messno;
		} catch(Exception ex) {
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
	
	//按照公示信息号修改公示信息
		public void updMessage(Message mess) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = DBUtil.getConnection();
				String sql = "" + " update message "
							 + " set userNum=?,messno=?,outline=?,content=?,time=current_time "
							 + " where messno=? ";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, mess.getUserNum());
				stmt.setInt(2, mess.getMessno());
				stmt.setString(3, mess.getOutline());
				stmt.setString(4, mess.getContent());
				stmt.setInt(5, mess.getMessno());
				
				stmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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

	//按照公示信息号查询公示信息
	public ArrayList<Message> queryMessages(Integer messno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Message> messes = new ArrayList<Message>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = " select * from message where messno=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, messno);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Message mess = new Message();
				mess.setId(rs.getInt("id"));
				mess.setUserNum(rs.getInt("userNum"));
				mess.setMessno(rs.getInt("messno"));
				mess.setOutline(rs.getString("outline"));
				mess.setContent(rs.getString("content"));
				mess.setTime(rs.getDate("time"));
				messes.add(mess);
			}
			return messes;
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
