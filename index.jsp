<!DOCTYPE html>
<html style="background: #e6e6e6;">
<head>
	<title>Reminder</title>
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
		<form class="form-bdy"  action="addreservlet" method="post">
		<table width="60%" border="0" class="tab-col">
					
				  <tr>
					<td width="32%">Title</td>
					<td><input type="text" name="title" ></td>
				  </tr>
				  <tr>
					<td>Description</td>
					<td><textarea name="description" cols="30" rows="5" id="description"></textarea></td>
					</tr>
				  <tr>
					<td>Remind me Date&Time</td>
					<td><input id="date" type="datetime-local" name="date" ></td>
					
					</tr>
				  <tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="SaveReminder" name="operation" /></td>
				  </tr>
				</table>
	</form>
</body>
</html>