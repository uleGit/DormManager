<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
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
    <form action="servlet/addStudentServlet" method="post" class="basic-grey">
        <h1>添加学生信息
        	<span>Please fill in the following information!</span>
        </h1>
        <label>
            <span>学号：</span>
            <input id="sno" type="text" name="sno" placeholder="请输入你的学号（必填）" />
        </label>
        <label>
            <span>姓名 :</span>
            <input id="sname" type="text" name="sname" placeholder="请输入你的姓名（必填）" />
        </label>
        
         <label>
            <span>宿舍楼号：</span>
            <input id="dor" type="text" name="budno" placeholder="请输入你的宿舍楼号（必填）" />
        </label>
        <label>
            <span>宿舍号：</span>
            <input id="budno" type="text" name="dor" placeholder="请输入你的宿舍号（必填）" />
        </label>
        <label>
            <span>床位号：</span>
            <input id="usernum" type="text" name="bed" placeholder="请输入你的床位号（必填）" />
        </label>
        <label>
            <span>班级代号：</span>
            <input id="cno" type="text" name="cno" placeholder="请输入你的班级代号（必填）" />
        </label>
        <label>
            <span></span>
            <input type="submit" class="button" value="确认添加" />
        </label>
    </form>


</div>



</body>
</html>
<script> 

//取出传回来的参数submit并与yes比较
  var submiti ='<%=request.getParameter("error")%>';
  if(submiti=='yes'){
  	alert("添加成功!");
  } else if(submiti=='no'){
  	alert("已有该学生信息，添加失败!");
  }else if(submiti=='sno'){
  	alert("学号格式错误，添加失败!");
  }else if(submiti=='budno'){
  	alert("宿舍楼号格式错误，添加失败!");
  }else if(submiti=='dor'){
  	alert("宿舍号格式错误，添加失败!");
  }else if(submiti=='bed'){
  	alert("床位号格式错误，添加失败!");
  }else if(submiti=='cno'){
  	alert("班级号格式错误，添加失败!");
  }else if(submiti=='allnull'){
  	alert("必填信息为空，添加失败!");
  }
</script>