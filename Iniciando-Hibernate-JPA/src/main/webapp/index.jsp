<html>
<link rel="stylesheet" type="text/css" href="http://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function () {
          
                var btn = $('#carga').val();
                $.post('ServeleteControler',{// esto es la parte del ajax


                }, function(respose){
                let datos = JSON.parse(respose);
               // console.log(datos);

               var tablaDatos=document.getElementById('tablaDatos');

                for(let item of datos){

                	tablaDatos.innerHTML +=`
                    <tr>
                    <td> ${item.id}</td>
                    <td> ${item.nombreProducto}</td>
                    <td> ${item.precioProducto}</td>
                    <td> ${item.cantidadProducto}</td>
                    <td> ${item.totalProducto}</td>
                    <td>
                    <a href="ServeleteControler?btn=ELIMINAR&Id=${item.id}" class="btn btn-warning">ELIMINAR</a>
                    <a href="funciones.jsp?idBus=${item.id}&Npr=${item.nombreProducto}&Preciopr=${item.precioProducto}&Cpr=${item.cantidadProducto}&Totalpr=${item.totalProducto}" class="btn btn-danger">ACTUALIZAR</a></td>
                    




                     </tr>
                	`
                	}



          	});
          

		// body...
	});


</script>
<body>



<a href="funciones.jsp" class="btn btn-info ">Envio de datos</a>

<table class="table table-dark" id="tablaDatos">
	<thead>
		<th>ID</th>
		<th>NOMBRE</th>
		<th>PRECIO</th>
		<TH>CANTIDAD</TH>
		<th>TOTAL</th>
		<th>OPCIONES</th>

	</thead>

<tbody>
	

</tbody>


</table>



</body>
</html>
