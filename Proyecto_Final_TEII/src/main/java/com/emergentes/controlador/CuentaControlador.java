//CONTROLADOR DEL CLIENTE
package com.emergentes.controlador;
import com.emergentes.dao.CuentasDAO;
import com.emergentes.dao.CuentasDAOimpl;
import com.emergentes.modelo.Cuentas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "CuentaControlador", urlPatterns = {"/CuentaControlador"})
public class CuentaControlador extends HttpServlet {
    @Override
    //PARA ENTENDERLO MEJOR VE EL CLIENTECONTROLADOR PRIMERO
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //accedemos a los datos de la sesion
        HttpSession ses = request.getSession();
        //validamos que el Cliente se haya logeado correctamente
        if (ses.getAttribute("login")!="OK") {
            response.sendRedirect("index.jsp");
        }else{
            //siempre dentro de un try-catch
            try {
                //creacion de objetos de acceso y el DAO
                Cuentas cts = new Cuentas();
                CuentasDAO dao = new CuentasDAOimpl();
                //Obtenemos el ID mediante transformaciones hasta que sea int
                Integer aux = (Integer) ses.getAttribute("us_id");
                int aid = aux.intValue();
                System.out.println("ID RECUPERADO: " + aid);
                //Integer auxs = (Integer) ses.getAttribute("saldo");
                //int as = auxs.intValue();
                //System.out.println("ID RECUPERADO: " + as);
                //acciones de siempre, algunas no serán usadas asi que puedes quitar las que no usaremos
                String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
                switch (action) {
                    case "add":
                        //Falta
                        break;
                    case "edit":
                        
                        break;
                    case "delete":
                        break;
                    case "view":
                        //Para observar los datos en el Sistema.
                        //la funcion GetAll(id) para ver todas las filas de datos del Cliente
                        List<Cuentas> lista = dao.getAll(aid);
                        request.setAttribute("cuentas", lista);
                        System.out.println(lista);
                        request.getRequestDispatcher("cuenta.jsp").forward(request, response);
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
        //la parte de Insercion de Datos falta.
    }
}
