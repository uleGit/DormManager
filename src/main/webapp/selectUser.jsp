<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>学生宿舍管理系统</title>
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
            padding: 10px 25px 10px 25px;
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
    <form action="servlet/selectUserServlet" method="post" class="basic-grey">
        <h1>查询用户信息
        	<span>Please fill in the following information!</span>
        </h1>
        <label>
            <span>查询方式 :</span>
            <select name="selectType" size="1" onChange="cll(this.value)">
            	<option selected="selected" disabled="disabled"  style='display: none' value=''></option>
            	<option value="0">帐号</option>
            	<option value="1">身份</option>
            </select>
        </label>
        <div id="div1" style="display: none" onMouseout="hidden();">
        <label>
            <span>帐号 :</span>
            <input id="usernum" type="text" name="usernum" placeholder="请输入你所查询的帐号" />
        </label>
        </div>
        <div id="div2" style="display: none" onMouseout="hidden();">
        <label>
            <span>身份 :</span>
            <select name="selectIdentity" size="1">
            	<option value="Student">学生</option>
            	<option value="DorMan">宿管</option>
            	<option value="Instructor">导员</option>
            	<option value="Manager">系统管理员</option>
            </select>
        </label>
        </div>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="查询" />
        </label>
    </form>
</div>
</body>
</html>
<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='no'){
   alert("查询不到该用户，请重新输入!");
  } else if(errori=='usernumnull'){
   alert("帐号不能为空，请输入帐号!");
  }
  function cll(id){ 
    if(id==0){ 
         eval("div1.style.display=\"\";"); 
         eval("div2.style.display=\"none\";");} 
   else{ 
         eval("div2.style.display=\"\";"); 
         eval("div1.style.display=\"none\";");} 
  }
  function show(){
	document.getElementById("div").style.display="";
	//alert(document.getElementById("div").style.display)
  }
  function hidden(){
	document.getElementById("div").style.display="none";
	//alert(document.getElementById("div").style.display)
  }
</script>
