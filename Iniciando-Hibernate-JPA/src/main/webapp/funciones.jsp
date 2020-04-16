<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String idBus=request.getParameter("idBus");
String Npr=request.getParameter("Npr");
String Preciopr=request.getParameter("Preciopr");
String Cpr=request.getParameter("Cpr");
String Totalpr=request.getParameter("Totalpr");
 if(idBus==null){
	 idBus="";
	 Npr="";
	 Preciopr="";
	 Cpr="";
	 Totalpr="";
 }

%>
<body>
<h2>AGREGAR DATOS</h2>
<form action="ServeleteControler">
<table align="center">
<thead>

</thead>
<tbody>
<tr>
<td>

<p>id</p><input type="text" name="Id" id="idcarga" value="<%=idBus %>" >
<p>nombreProducto</p><input type="text" name="Nproductos" value="<%=Npr %>">
<p>precioProducto</p><input type="text" name="Pproductos"value="<%=Preciopr %>">
<p>cantidadProducto</p><input type="text" name="Ccantidad" value="<%=Cpr %>">
<p>totalProducto</p><input type="text" name="Tproductos" value="<%=Totalpr %>">
<br>
<br>

</td>
</tr>
</tbody>
</table>
<input type="submit" class="btn btn-info" value="GUARDAR" name= "btn">
<input type="submit" class="btn btn-info" value="ACTUALIZAR" name= "btn">
</form>
</body>
</html>