<%@page import="model.addremod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.addreservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background: #e6e6e6;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Reminders</title>
</head>
<body>
 <%addreservice rr=new addreservice();
	   ArrayList<addremod>arr1=rr.selectAllRegistration();
	   %>
<table width="700" align="center" border="1">
<tr >
<td bgcolor="#6699ff"><div align="center"><strong>ID</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>Title</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>description</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>date</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>edit</strong></div></td>
</tr>
</tr>
<%
for(addremod rm:arr1)
{
%>
<tr style="background: #fff;">
<td><%=rm.getId()%></td>
<td><%=rm.getTitle()%></td>
<td><%=rm.getDesc()%></td>
<td><%=rm.getDate()%></td>


<form method="post"action="addreservlet">
<td><a href="edit.jsp?id=<%=rm.getId()%>">Edit</a></td>

<%int id=rm.getId(); 
%>
<td><input type="hidden" name="edit_id" value="<%=id %>"/><div align="center"><label><input type="submit"name="operation"id="button2"value="Delete"tabindex="7"/></label>
</div>


	   
            

</label>
</div>

</td>
</form>
</tr>
<%} %>
<td><a href="index.jsp">add new reminder</a></td>
</table>
</tr>
</td>
 </tr> 
</table>
</body>
</html>