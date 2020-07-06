<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生宿舍管理系统</title>
    <link rel="stylesheet" href="css/sidebar.css">
</head>
<body>
<div id="wrapper" style="left:0;">
    <!-- 侧边栏 -->
    <div class="sidebar">
        <div class="headSculpture">
            <img src="images/headSculpture.jpg" alt="">
            <%
  				String loginUser="";
  				if(session.getAttribute("userName")!=null) {
  					loginUser = session.getAttribute("userName").toString();
  				}
  			 %>
            <p><a href="personal.jsp" target="mainFrame" style="text-decoration:none;"><%=loginUser %></a></p>
        </div>
        <div class="option">
            <ul>
             
                <li><img src="images/home.png" alt="">
                    <p><a href="selectStudent.jsp" target="mainFrame" style="text-decoration:none;">查询学生信息</a></p>
                </li>
                <li><img src="images/collection.png" alt="">
                    <p><a href="selectMessage.jsp" target="mainFrame" style="text-decoration:none;">查看公示信息</a></p>
                </li>
                <li><img src="images/works.png" alt="">
                    <p><a href="addMessage.jsp" target="mainFrame" style="text-decoration:none;">发布公示信息</a></p>
                </li>
            </ul>
        </div>
    </div>
    <!-- 侧边栏按钮 -->
    <button></button>
    <!-- 内容区域 -->
    <div class="banner">
        <h2>学生宿舍管理系统</h2>
    </div>
    <iframe id="mainFrame" name="mainFrame" style="border: 0px;">
    </iframe>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/sidebar.js"></script>
</body>
</html>
