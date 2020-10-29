<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
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
              PersonaDAO dao=new PersonaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Persona p=(Persona)dao.list(id);
              %>
            <h1>Actualizar cliente</h1>
            <form action="Controlador">
                Nombres:<br>
                <input class="form-control" type="text" name="txtnom" value="<%= p.getNombre()%>"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtape" value="<%= p.getApellidos()%>"><br>
                Direccion: <br>
                <input class="form-control" type="text" name="txtdire" value="<%= p.getDireccion()%>"><br>
                Telefono: <br>
                <input class="form-control" type="number" name="txttel" value="<%= p.getTelefono()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
