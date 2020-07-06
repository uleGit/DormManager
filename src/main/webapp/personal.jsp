<%@ page language="java" import="java.util.*,entity.User,entity.Student,dao.UserDao,dao.StudentDao" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <style>
        .div1{
            margin-right: 400px;
        }
        .basic-grey {
            margin-left:auto;
            margin-right:auto;
            max-width: 500px;
            background: #F7F7F7;
            padding: 25px 15px 25px 10px;
            font: 12px Georgia, "Times New Roman", Times, serif;
            color: bisque;
            text-shadow: 1px 1px 1px #FFF;
            border:1px solid #E4E4E4;
        }
        .basic-grey h1 {
            font-size: 25px;
            padding: 0px 0px 10px 40px;
            display: block;
            border-bottom:1px solid #E4E4E4;
            margin: -10px -15px 30px -10px;;
            color: #888;
        }
        .basic-grey h1>span {
            display: block;
            font-size: 11px;
            
        }
        .basic-grey label {
            display: block;
            margin: 0px;
            display:block;
        }
        .basic-grey label>span {
            float: left;
            width: 20%;
            text-align: right;
            padding-right: 10px;
            margin-top: 10px;
            color: #888;
            
        }
        .basic-grey input[type="text"], .basic-grey input[type="messno"], .basic-grey textarea, .basic-grey select {
            border: 1px solid #DADADA;
            color: #888;
            height: 30px;
            margin-bottom: 16px;
            margin-right: 6px;
            margin-top: 2px;
            outline: 0 none;
            padding: 3px 3px 3px 5px;
            width: 70%;
            font-size: 12px;
            line-height:15px;
            box-shadow: inset 0px 1px 4px #ECECEC;
            -moz-box-shadow: inset 0px 1px 4px #ECECEC;
            -webkit-box-shadow: inset 0px 1px 4px #ECECEC;
        }
        .basic-grey textarea{
            padding: 5px 3px 3px 5px;
        }
        .basic-grey select {
            background: #FFF ;
            background: #FFF ;
            appearance:none;
            -webkit-appearance:none;
            -moz-appearance: none;
            text-indent: 0.01px;
            text-overflow: '';
            width: 70%;
            height: 35px;
            line-height: 25px;
        }
        .basic-grey textarea{
            height:100px;
        }
        .basic-grey .button {
            background: #E27575;
            border: none;
            padding: 5px 15px 5px 15px;
            color: #FFF;
            box-shadow: 1px 1px 5px #B6B6B6;
            border-radius: 3px;
            text-shadow: 1px 1px 1px #9E3F3F;
            cursor: pointer;
        }
        .basic-grey .button:hover {
            background: #CF7A7A
        }
		
    </style>
</head>
<body>
<div class="div1" >
	<% 
		Integer userNum = Integer.parseInt(session.getAttribute("userNum").toString());
		User user = new User();
		UserDao ud = new UserDao();
		user = ud.queruser(userNum);
		
		Student stu = new Student();
		StudentDao stud = new StudentDao();
		stu = stud.querysno(userNum);
	%>
    <form action="" method="post" class="basic-grey">
          <h1 align="center">个人信息表</h1>
        <label>
            <span>账号 :</span>
            <span><%=user.getUserNum() %></span>
        </label>
        <br/>
        <label>
        	<br/>
            <span>用户名 :</span>
            <span><%=user.getUsername() %></span>
        </label>
        <br/>
        <label>
        	<br/>
            <span>身份 :</span>
            <span><%=user.getIdentity() %></span>
        </label>
        <br/>
        <label>
        	<br/>
        	<br/>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <a href="changePassword.jsp?"><input type="button" class="button" value="修改" /></a>
        </label>
    </form>


</div>



</body>
</html>
