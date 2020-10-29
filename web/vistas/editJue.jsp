<%@page import="Modelo.Juego"%>
<%@page import="ModeloDAO.JuegoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              JuegoDAO dao=new JuegoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Juego p=(Juego)dao.list(id);
              %>
            <h1>Actualizar Juego</h1>
            <form action="Controlador">
                Nombre:<br>
                <input class="form-control" type="text" name="txtnom" value="<%= p.getNombre()%>"><br>
                Año: <br>
                <input class="form-control" type="number" name="txtanho" value="<%= p.getAnho()%>"><br>
                Protagonista: <br>
                <input class="form-control" type="text" name="txtprot" value="<%= p.getProtagonista()%>"><br>
                Director: <br>
                <input class="form-control" type="text" name="txtdir" value="<%= p.getDirector()%>"><br>
                Productor: <br>
                <input class="form-control" type="text" name="txtprod" value="<%= p.getProductor()%>"><br>
                Tecnologia: <br>
                <input class="form-control" type="text" name="txttec" value="<%= p.getTecnologia()%>"><br>
                Cantidad: <br>
                <input class="form-control" type="number" name="txtcan" value="<%= p.getCantidad()%>"><br>
                Precio de venta: <br>
                <input class="form-control" type="number" name="txtpreV" value="<%= p.getPreciVenta()%>"><br>
                Precio de alquiler: <br>
                <input class="form-control" type="numer" name="txtpreA" value="<%= p.getPrecioAlquiler()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="actualizarJue"> 
                <a href="Controlador?accion=listarJue">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
