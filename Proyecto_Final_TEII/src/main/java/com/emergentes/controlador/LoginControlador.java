//EL CONTROLADOR QUE PERMITIRA LA CONEXION AL SISTEMA
package com.emergentes.controlador;
import com.emergentes.utiles.ValidateLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {
    @Override
    //Primero redirecciona directamente la index (el login) esto podrias cambiarlo y revisarlo con un archivo xml
    //yo por ahora solo dejo que se ejecute el index primero
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
    @Override
    //Luego aqui recibe los datos del index
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Guardar los datos en variables
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("password");
        //Esto es para probar si son los datos correctos si quieres eliminalo
        System.out.println("DATOS: "+usuario+"  "+contraseña);
        //Creamos un objeto para acceder al ValidateLogin
        ValidateLogin val = new ValidateLogin();
        //y hacemos la validacion mediante esa funcion.
        if (val.checkUser(usuario, contraseña)) {
            System.out.println("Los datos introducidos fueron validados exitosamente");
            //guardamos el ID del cliente con la funcion que yo creé
            int id = val.Id(usuario, contraseña);
            int saldo = val.Saldo(id);
            //int saldo = val.Saldo(id);
            HttpSession ses = request.getSession();
            //y guardamos datos de tipo session
            //este primero debe estar porque va a permitir controlar el acceso al sistema por las urls
            ses.setAttribute("login", "OK");
            //y este es donde subimos el ID del cliente.
            ses.setAttribute("us_id",id);
            //ses.setAttribute("us_id",saldo);
            ses.setAttribute("saldo_actual", saldo);
            //redirigimos y ya
            response.sendRedirect("CuentaControlador");
        }else{
            System.out.println("Los datos introducidos no son los correctos");
            //si los datos son incorrectos te redirige al login otra vez
            response.sendRedirect("index.jsp");
        }
        
    }
}
