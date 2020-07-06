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
    <form action="servlet/addMessageServlet" method="post" class="basic-grey">
        <h1>发布公示信息
            <span>Please fill in the following information!</span>
        </h1>
        <label>
            <span>工号：</span>
            <input id="usernum" type="text" name="usernum" placeholder="请输入你的工号(必填)" />
        </label>
        <label>
            <span>信息码 :</span>
            <input id="messno" type="text" name="messno" placeholder="请输入你所需的信息码(必填)" />
        </label>
        <label>
            <span>概要:</span>
            <input id="outline" type="text" name="outline" placeholder="请输入概要信息(必填)" />
        </label>
        <label>
            <span>详情:</span>
            <textarea id="content" name="content" placeholder="请输入公示详情(必填)"></textarea>
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="发布" />
        </label>
    </form>


</div>



</body>
</html>
<script> 

//取出传回来的参数error并与yes比较
  var submiti ='<%=request.getParameter("submit")%>';
  if(submiti=='yes'){
  	alert("发布成功!");
  }else if(submiti=='userNum'){
  alert("发布失败，请检查工号是否正确！");
  }else if(submiti=='messNo'){
  alert("发布失败，请检查信息码是否有非数字！");
  }else if(submiti=='no'){
  alert("发布失败，必填信息为空！");
  }
</script>