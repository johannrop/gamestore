<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Registrar Juego</h1>
                <form action="Controlador">
                    NOMBRE: <br>
                    <input class="form-control" type="text" name="txtnom"><br>
                    AÑO:<br>
                    <input class="form-control" type="text" name="txtanho"><br>
                    PROTAGONISTA: <br>
                    <input class="form-control" type="text" name="txtprot"><br>
                    DIRECTOR: <br>
                    <input class="form-control" type="text" name="txtdir"><br>
                    PRODUCTOR: <br>
                    <input class="form-control" type="text" name="txtprod"><br>
                    TECNOLOGIA: <br>
                    <input class="form-control" type="text" name="txttec"><br>
                    CANTIDAD: <br>
                    <input class="form-control" type="text" name="txtcan"><br>
                    PRECIO DE VENTA: <br>
                    <input class="form-control" type="text" name="txtpreV"><br>
                    PRECIO DE ALQUILER: <br>
                    <input class="form-control" type="text" name="txtpreA"><br>
                    
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="AgregarJue">
                    <a href="Controlador?accion=listarJue">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>

