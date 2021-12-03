<!--Validacion similar a la de  los controladores-->
<%
    if (session.getAttribute("login")!="OK") {
            response.sendRedirect("index.jsp");
        }
%>
<!--Hay etiquetas por defecto, que permiten utilizar el estilo de bootstrap, 
ve el Cliente.jsp y le entenderas mejor-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="container">
            <!--Para conectarnos con el menu de navegacion y para saber en que pestaña estamos-->
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="cuenta"/>
            </jsp:include>
            <!--Boton para cerrar sesion-->
            <p><a href="Logout" class="btn btn-outline-danger"><i class="fas fa-window-close"></i> Cerrar Sesion</a>
            </p>
            <!--Tabla de visualizacion de datos-->
            <table class="table table-striped">
                <tr>
                    <th>ID REGISTRO</th>
                    <th>SALDO</th>
                    <th>FECHA</th>
                    <th>CODIGO CLIENTE</th>
                </tr>

                <c:forEach var="item" items="${cuentas}">
                    <tr>
                        <td>${item.id_registro}</td>
                        <td>${item.saldo}</td>
                        <td>${item.fecha}</td>
                        <td>${item.cod_cliente}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

