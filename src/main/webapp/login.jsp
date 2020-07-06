<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>宿舍管理系统</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
	
	<div class="container">
	    <img src="images/bc.jpg" alt="" />
	    <div class="panel">
	        <div class="content login">
	            <div class="switch">
	                <span id="login" class="active">宿舍管理系统</span>
	            </div>
	            <form action="servlet/Login" method="post">
	                <div class="input" ><input type="text" placeholder="UserNum" name="userNum" /></div>
	                <div class="input" ><input type="password" placeholder="Password" name="password" /></div>
	                <table>
	                	<tr>
	                		<td>
				                <input name="user" type="radio" value="Student" /><font size="0.5"> 学生</font>
				                <input name="user" type="radio" value="DorMan" /><font size="0.5"> 宿管</font>
				                <input name="user" type="radio" value="Instructor" /><font size="0.5"> 导员</font>
				                <input name="user" type="radio" value="Manager" /><font size="0.5"> 系统管理员</font>
				            </td>
				        </tr>
		                <tr>
		                    <td>
		                    <input type="submit" style="text-decoration:none;" value="登录"/> 
		                    <input type="reset" value="重置" />
		                    </td>
	                	</tr>
            		</table>
	            </form>
	        </div>
	    </div>
	</div>
	
	
</body>
</html>
<script> 

//取出传回来的参数error比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='userNumnull'){
  	alert("用户名为空!");
  } else if(errori=='userNum'){
  	alert("用户名错误!");
  }else if(errori=='passwordnull'){
  	alert("密码为空!");
  }else if(errori=='password'){
  	alert("密码错误!");
  }else if(errori=='usernull'){
  	alert("未选择身份!");
  }else if(errori=='user'){
  	alert("身份错误!");
  }
</script>