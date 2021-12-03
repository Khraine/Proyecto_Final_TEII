//VER CLIENTECONTROLADOR y CUENTACONTROLADOR para entender mejor
package com.emergentes.controlador;
import com.emergentes.dao.MovimientosDAO;
import com.emergentes.dao.MovimientosDAOimpl;
import com.emergentes.modelo.Movimientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MovimientosControlador", urlPatterns = {"/MovimientosControlador"})
public class MovimientosControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //acceso al objeto sesion
        HttpSession ses = request.getSession();
        //validacion de acceos al sistema
        if (ses.getAttribute("login") != "OK") {
            response.sendRedirect("index.jsp");
        }else{
            //siempre en try-catch
            try {
                //creacion de objetos de acceso y del DAO
                Movimientos mov = new Movimientos();
                MovimientosDAO dao = new MovimientosDAOimpl();
                //desencapsulacion del objeto ID guardado en la sesion
                Integer aux = (Integer) ses.getAttribute("us_id");
                int aid = aux.intValue();
                System.out.println("ID RECUPERADO: " + aid);
                //switch de accion
                String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
                switch (action) {
                    case "add":
                        break;
                    case "edit":
                        break;
                    case "delete":
                        break;
                    case "view":
                        //LISTA DE DATOS QUE SE VERAN EN EL SISTEMA. las lineas de codigo que funcionaron no estan entre comentarios
                        // HttpSession ses = request.getSession();
                        //String us =(String)ses.getAttribute("usuario");
                        //String pws =(String)ses.getAttribute("password");
                        //Uso de la funcion GETALL como en CUENTACONTROLADOR
                        List<Movimientos> lista = dao.getAll(aid);
                        request.setAttribute("movimientos", lista);
                        request.getRequestDispatcher("movimiento.jsp").forward(request, response);
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            } 
        }

        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //falta la recepcion de datos del formulario para Insertarlos
    }
}
