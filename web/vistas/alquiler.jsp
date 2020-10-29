<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Juego"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.JuegoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Juegos</title>
    </head>
    <body>
        <div class="container">
            <h1>Seleccione el juego a alquilar</h1>

            <a class="btn btn-info" href="index.jsp">Inicio</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">TECNOLOGIA</th>
                        <th class="text-center">CANTIDAD</th>
                        <th class="text-center">Precio ALQUILER</th>
                    </tr>
                </thead>
                <%
                    JuegoDAO daoj=new JuegoDAO();
                    List<Juego>list=daoj.listar();
                    Iterator<Juego>iter=list.iterator();
                    Juego per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getNombre()%></td>
                        <td class="text-center"><%= per.getTecnologia()%></td>
                        <td class="text-center"><%= per.getCantidad()%></td>
                        <td class="text-center"><%= per.getPrecioAlquiler()%></td>
            
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=cliente&id=<%= per.getId()%>">Alquilar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
