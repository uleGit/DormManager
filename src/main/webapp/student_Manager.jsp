<%@ page language="java" import="java.util.*,entity.Student,dao.StudentDao" contentType="text/html; charset=UTF-8"%>
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
<h2>学生信息</h2>
<table id="hor-minimalist-b" summary="Employee Pay Sheet">
    <thead>
    <tr>
        <td>ID</td>
        <td>学号</td>
        <td>姓名</td>
        <td>楼栋号</td>
        <td>宿舍号</td>
        <td>床位号</td>
        <td>班级号</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    </thead>
    	<%
    		ArrayList<Student> stus = new ArrayList<Student>();
    		
    		stus = (ArrayList<Student>)session.getAttribute("stus");
    		if(stus!=null&&stus.size()>0){
    			for(Student stu:stus){
    	%>
    <tbody>	
    <tr>
    	<td><%=stu.getId() %></td>
        <td><%=stu.getSno() %></td>
        <td><%=stu.getSname() %></td>
        <td><%=stu.getBudno() %></td>
        <td><%=stu.getDor() %></td>
        <td><%=stu.getBed() %></td>
        <td><%=stu.getCno() %></td>
        <td><a href="/updStudent.jsp">修改</a><td>
        <td><a href="/delStudent.jsp">删除</a></td>
    </tr>
    </tbody>
    		<% 
    			}
    		}
    		%>

   
</table>



</body>
</html>