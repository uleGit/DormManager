<%@ page language="java" import="java.util.*,entity.Message,dao.MessageDao" contentType="text/html; charset=UTF-8"%>
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
<h2>公示栏</h2>
<table id="hor-minimalist-b" summary="Employee Pay Sheet">
    <thead>
    <tr>
        <td>ID</td>
        <td>工号</td>
        <td>信息码</td>
        <td>概要</td>
        <td>详情</td>
        <td>Time</td>
    </tr>
    </thead>
    	<%
    		int m = Integer.parseInt(session.getAttribute("messno").toString());
    		ArrayList<Message> messes = null;
    		MessageDao md = new MessageDao();
    		int messno = md.query_messno(m);
    		messes = md.queryMessages(messno);
    		if(messes!=null&&messes.size()>0){
    			for(Message mess:messes){
    	%>
    <tbody>	
    <tr>
        <td><%=mess.getId() %></td>
        <td><%=mess.getUserNum() %></td>
        <td><%=mess.getMessno() %></td>
        <td><%=mess.getOutline() %></td>
        <td onmouseover="overShow(this,event)" onmouseout="outHide()"><%=mess.getContent() %></td>
        <td><%=mess.getTime() %></td>
    </tr>
    </tbody>
    		<% 
    			}
    		}
    		%>

   
</table>
<a href="addMessage.jsp"> <input type="button" class="fabu" name="fabu" value="发布消息"/></a>
<div id="showDiv" style=" position: absolute;
    background-color: #8dfffc;
    border: 1px solid black;
    display: inline;
    border-radius: 10px;
    height: 100px;
    width: 200px">
</div>
<script>
    function overShow(obj, e) {
        var showDiv = document.getElementById('showDiv');
        var theEvent = window.event || e;
        showDiv.style.left = theEvent.clientX + "px";
        showDiv.style.top = theEvent.clientY + "px";
        showDiv.style.display = 'block';
        //alert(obj.innerHTML);
        showDiv.innerHTML = obj.innerHTML;
    }

    function outHide() {
        var showDiv = document.getElementById('showDiv');
        showDiv.style.display = 'none';
        showDiv.innerHTML = '';
    }

</script>


</body>
</html>