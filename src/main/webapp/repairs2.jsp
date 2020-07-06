<%@ page language="java" import="java.util.*,entity.Repairs,dao.RepairsDao" contentType="text/html; charset=UTF-8"%>
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
<h2>报修信息</h2>
<table id="hor-minimalist-b" summary="Employee Pay Sheet">
    <thead>
    <tr>
        <td>ID</td>
        <td>楼号</td>
        <td>宿舍号</td>
        <td>详情</td>
        <td>处理人</td>
        <td>结果</td>
        <td>Time</td>
        <td></td>
    </tr>
    </thead>
    	<%
    		ArrayList<Repairs> res = new ArrayList<Repairs>();
    		
    		res = (ArrayList<Repairs>)session.getAttribute("res");
    		if(res!=null&&res.size()>0){
    			for(Repairs re:res){
    	%>
    <tbody>	
    <tr>
        <td><%=re.getId() %></td>
        <td><%=re.getBudno() %></td>
        <td><%=re.getDor() %></td>
        <td onmouseover="overShow(this,event)" onmouseout="outHide()"><%=re.getDetail() %></td>
        <td><%=re.getHandler() %></td>
        <td><%=re.getResult() %></td>
        <td><%=re.getTime() %></td>
        <td><a href="<%=path %>/updRepairsJsptoServlet?id=<%=re.getId() %>">修改状态</a></td>
    </tr>
    </tbody>
    		<% 
    			}
    		}
    		%>

   
</table>

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