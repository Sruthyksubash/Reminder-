<%@page import="model.addremod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.addreservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background: #e6e6e6;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Reminder</title>
<style>
	.form-bdy{
	    background: #afc8d6;
    width: 50%;
    margin: 15% 28% 30%;
	}
	.tab-col{
	    width: 0%;
    padding: 5%;
    margin-left: 18%;
    background: #afb9d4;
	}
	</style>
</head>
<body>
	<%
		addreservice asv = new addreservice();
		ArrayList<addremod> arr1 = asv.selectAllRegistration();
	%>

	<form class="form-bdy"  action="addreservlet" method="post">
		<%
			int Id = Integer.parseInt(request.getParameter("id"));
			addreservice rs = new addreservice();
			addremod rm = rs.selectByid(Id);
		%>
		<table width="50%" border="0">

			<tr>
				<td width="32%">Title</td>
				<td><input type="text" name="title" value="<%=rm.getTitle()%>"></td>
			</tr>
			<tr>
				<td width="32%">description</td>
				<td><textarea name="description" cols="30" rows="5"
						id="description"><%=rm.getDesc()%></textarea></td>
			</tr>
			<tr>
				<td>Remind me Date&Time</td>
				<td><input type="text" id="date" name="date"
					value="<%=rm.getDate()%>"></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td>
					<%%> <label><input type="hidden" name="id" value="<%=Id%>" />
						<input type="submit" name="operation" id="button2" value="Update">
				</label>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>