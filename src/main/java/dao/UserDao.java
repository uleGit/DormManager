package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Student;
import entity.User;
import jdbc.DBUtil;

public class UserDao {

	// 查询帐号
	public Integer queryUser(Integer usernum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select userNum from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, usernum);
		ResultSet rs = ptmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt("userNum");
		}
		return i;

	}

	// 查询密码
	public String queryPassword(Integer usernum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select password from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, usernum);
		ResultSet rs = ptmt.executeQuery();
		String s = null;
		while (rs.next()) {
			s = rs.getString("password");
		}
		return s;

	}

	// 查询身份
	public String queryIdentity(Integer usernum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select identity from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, usernum);
		ResultSet rs = ptmt.executeQuery();
		String s = null;
		while (rs.next()) {
			s = rs.getString("identity");
		}
		return s;

	}

	// 查询用户名
	public String queryUsername(Integer userNum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select username from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, userNum);
		ResultSet rs = ptmt.executeQuery();
		String s = null;
		while (rs.next()) {
			s = rs.getString("username");
		}
		return s;

	}
	//查找单个用户
	public User queruser(Integer userNum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, userNum);
		ResultSet rs = ptmt.executeQuery();
		User user = new User();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setUserNum(rs.getInt("userNum"));
			user.setPassword(rs.getString("password"));
			user.setIdentity(rs.getString("identity"));
			user.setUsername(rs.getString("username"));
		}
		return user;
	}
	// 按照帐号查询用户信息
	public ArrayList<User> queruser1(Integer userNum) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where userNum=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, userNum);
		ResultSet rs = ptmt.executeQuery();
		User user = new User();
		ArrayList<User> users = new ArrayList<User>();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setUserNum(rs.getInt("userNum"));
			user.setPassword(rs.getString("password"));
			user.setIdentity(rs.getString("identity"));
			user.setUsername(rs.getString("username"));
			users.add(user);
		}
		return users;
	}

	// 按照身份查询用户信息
	public ArrayList<User> queruser2(String identity) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from user where identity=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, identity);
		ResultSet rs = ptmt.executeQuery();
		ArrayList<User> users = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserNum(rs.getInt("userNum"));
			user.setPassword(rs.getString("password"));
			user.setIdentity(rs.getString("identity"));
			user.setUsername(rs.getString("username"));
			users.add(user);
		}
		return users;
	}

	// 修改密码
	public void updPassword(User u) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " update user " + "set password=? " + "where userNum=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, u.getPassword());
		ptmt.setInt(2, u.getUserNum());

		ptmt.execute();

	}

	// 增加用户
	public void addUser(User u) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into user " + " (userNum,username,password,identity) " + " values(?,?,?,?); ";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, u.getUserNum());
		stmt.setString(2, u.getUsername());
		stmt.setString(3, u.getPassword());
		stmt.setString(4, u.getIdentity());

		stmt.execute();
	}
	//更新用户
	public void updUser(User u) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "" + 
				 " update user " + 
				 " set userNum=?,username=?,password=?,identity=? " + 
				 " where id=? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, u.getUserNum());
		stmt.setString(2, u.getUsername());
		stmt.setString(3, u.getPassword());
		stmt.setString(4, u.getIdentity());
		stmt.setInt(5, u.getId());
		
		stmt.execute();
	}
	//删除用户
	public void delUser(Integer userNum) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql =  "" + " delete from User "
					  + "where userNum = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, userNum);//按学号like删除
		
		stmt.execute();
	}
}
