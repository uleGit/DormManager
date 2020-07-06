<%@ page language="java" import="java.util.*,entity.User,dao.UserDao" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/message.css">

</head>
<body>
<h2>用户信息</h2>
<table id="hor-minimalist-b" summary="Employee Pay Sheet">
    <thead>
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>帐号</td>
        <td>密码</td>
        <td>身份</td>
        <td></td>
        <!-- <td></td> -->
    </tr>
    </thead>
    	<%
    		ArrayList<User> users = new ArrayList<User>();
    		
    		users = (ArrayList<User>)session.getAttribute("users");
    		if(users!=null&&users.size()>0){
    			for(User user:users){
    	%>
    <tbody>	
    <tr>
    	<td><%=user.getId() %></td>
        <td><%=user.getUsername() %></td>
        <td><%=user.getUserNum() %></td>
        <td><%=user.getPassword() %></td>
        <td><%=user.getIdentity() %></td>
        <td><a href="<%=path %>/updUserJsptoServlet?userNum=<%=user.getUserNum() %>">修改</a></td>
      <!-- <td><a href="<%=path %>/delUserJsptoServlet?userNum=<%=user.getUserNum() %>">删除</a></td> -->
    </tr>
    </tbody>
    		<% 
    			}
    		}
    		%>

   
</table>



</body>
</html>

<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='no'){
   alert("删除成功!");
  }
</script>