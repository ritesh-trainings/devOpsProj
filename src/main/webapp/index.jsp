<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>DevOps - Ritesh</title>
</head>
<body>
	<% String result= "",err = null;
double val1= 0, val2=0;
try{
	result=(String)request.getAttribute("result");
	err=(String)request.getAttribute("err");
	if (result==null)
		result="0.0";
	val1=Double.parseDouble(request.getParameter("value1"));
	val2=Double.parseDouble(request.getParameter("value2"));
}catch (Exception e){
}
%>
	<center>
		<h2>Welcome...!!!</h2>
		<br>
		<div>
			<form name="indexPage" action="CalcSumServlet" method="post"
				style="max-width: 80%">
				<br> <label>Number 1 :</label> <input type="text" name="value1"
					id="value1" placeholder="Number 1" value="<%=val1 %>">
					<br>
				<p>+</p>
				<label>Number 2 :</label> <input type="text" name="value2"
					id="value2" placeholder="Number 2" value=<%=val2 %>> <br> <br>
				<button type="submit">Calculate Sum</button>
			</form>
			<br> Result : 
			<em><%=result %></em>
			<br>
			<br>
			<%if (err != null){ %>
			<p style="color:red"><%=err %></p>
			<%} %>
		</div>
	</center>
</body>
</html>
