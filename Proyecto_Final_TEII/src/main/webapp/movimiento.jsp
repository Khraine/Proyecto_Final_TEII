<!--Validacion de acceso-->
<%
    if (session.getAttribute("login")!="OK") {
            response.sendRedirect("index.jsp");
        }
%>
<!--SI YA VISTE LOS OTROS 2 JSP ENTONCES ESTE ES LO MISMO-->
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
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="movimientos"/>
            </jsp:include>
            <!--Incluye un par de botones, los que seran Depositos y Retiros
            Aun no estan configurados ni nada, habrá que talvez crear un servlet netamente para estas acciones
            o reutilizar el servlet que ya se tiene, pero eso tu lo verás-->
            <p><a href="DepositosControlador?action=add" 
                  class="btn btn-outline-success"><i class="far fa-plus-square"></i> Nuevo Deposito</a> 
                <a href="RetirosControlador?action=add"
                  class="btn btn-outline-warning"><i class="far fa-plus-square"></i> Nuevo Retiro</a> 
           
                <a href="Logout" class="btn btn-outline-danger"><i class="fas fa-window-close"></i> Cerrar Sesion</a>
                
            </p>
            <!--Visualizacion de la informacion-->
            <table class="table table-striped">
                <tr>
                    <th>ID REGISTRO</th>
                    <th>MONTO</th>
                    <th>FECHA</th>
                    <th>TIPO</th>
                    <th>CODIGO CLIENTE</th>
                </tr>

                <c:forEach var="item" items="${movimientos}">
                    <tr>
                        <td>${item.id_registro}</td>
                        <td>${item.monto}</td>
                        <td>${item.fecha}</td>
                        <td>${item.tipo}</td>
                        <td>${item.cod_cli}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>