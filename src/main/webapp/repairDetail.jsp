<%@ page language="java" import="java.util.*,entity.Repairs,dao.RepairsDao" contentType="text/html; charset=UTF-8"%>
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
            text-align: left;
            padding-right: 10px;
            margin-top: 10px;
            color: #888;
            
        }
        .basic-grey label>p>span {
            float: left;
            width: 50%;
            text-align: left;
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
		Repairs re = new Repairs();
		RepairsDao ud = new RepairsDao();
		re = (Repairs)request.getSession().getAttribute("updRe");
		
		
	%>
    <form action="servlet/updateRepairsServlet" method="post" class="basic-grey">
          <h1>修改报修状态
        	<span>Please fill in the following information!</span>
        </h1>
        
        <label>
            <span>楼号 :</span>
            <span><%=re.getBudno() %></span>
        </label>
        <br/>
        <label>
        	<br/>
            <span>宿舍号 :</span>
            <span><%=re.getDor() %></span>
        </label>
        <br/>
        <label>
        <br/>
            <span>详情 :</span>
            <span style='width:70%'><%=re.getDetail() %></span>
        </label>
        <br/>
        <label>
        	<br/>
            <span>处理人 :</span>
            <input id="" type="text" name="handler" value="<%=re.getHandler() %>" />
        </label>
        <label>
            <span>状态 :</span>
            <select name="result" size="1">
            	<option selected="selected" disabled="disabled"  style='display: none' value=''><%=re.getResult() %></option>
            	<option value="待修理">待修理</option>
            	<option value="已修理">已修理</option>
            </select>
        </label>
        <label>
            <span>时间 :</span>
            <span style='width:70%'><%=re.getTime() %></span>
            <br/>
        </label>
        <br/>
        <label>
            <span></span>
            <input type="submit" class="button" value="确认修改" />
        </label>
        
    </form>


</div>



</body>
</html>

<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='no'){
   alert("修改成功!");
  }else if(errori=='yes'){
   alert("修改失败!");
  }
</script>