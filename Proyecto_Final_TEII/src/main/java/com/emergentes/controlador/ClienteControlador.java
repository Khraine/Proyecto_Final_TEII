//Su nombre lo dice Controlador del Cliente
package com.emergentes.controlador;

import com.emergentes.dao.ClientesDAO;
import com.emergentes.dao.ClientesDAOimpl;
import com.emergentes.modelo.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtenemos la sesion
        HttpSession ses = request.getSession();
        //validar el acceso directo a estas paginas, mediante el atributo de login, si una persona no se logea correctamente no podra ingresar directamente.
        if (ses.getAttribute("login") != "OK") {
            response.sendRedirect("index.jsp");
        } else {
            //siempre dentro de un try y catch
            try {
                //aqui la parte de crear objetos de Acceso al Modelo, al DAO
                Clientes cli = new Clientes();
                ClientesDAO dao = new ClientesDAOimpl();
                //y obteniendo el ID del Cliente de la Sesion.Ojo la sintaxis asi tal cual
                Integer aux = (Integer) ses.getAttribute("us_id");
                //Guardamos este Id en una variabla primitiva int y recien podrá enviarse a las funciones del DAO
                int aid = aux.intValue();
                //Esto ya lo sabes tu
                String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
                //Una cosa mas. Creo que algunos casos estan de mas, recuerda que no realizaremos todas las acciones en algunos casos.
                //Eso velo tu si.
                switch (action) {
                    case "add":
                        request.setAttribute("cliente", cli);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        break;
                    case "edit":
                        //y aqui está como se envia al DAO y luego se redirigé al formulario
                        //Hay varias lineas de codigo que probé puedes borrarlas solo las que no estan comentadas funcionaron.
                        cli = dao.getById(aid);
                        request.setAttribute("cliente", cli);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                        //cli=dao.getByUspas(us, pws);
                        //request.setAttribute("cliente", cli);
                        //request.getRequestDispatcher("frmClientes.jsp").forward(request, response);
                        break;
                    case "delete":
                        break;
                    case "view":
                        //cli=dao.getByUspas(us, pws);
                        //request.setAttribute("clientes", cli);
                        //request.getRequestDispatcher("cuenta.jsp").forward(request, response);
                        //List<Clientes> lista = dao.getAll();
                        //cli=dao.getById(id);
                        //System.out.println(lista);
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
        //aqui falta la parte de añadir y recibir los datos del formulario
        //ACTUALIZACION 2/12/2021 TODO EL DOPOST para editar datos está completo
        HttpSession ses = request.getSession();
        Integer aux = (Integer) ses.getAttribute("us_id");
        int aid = aux.intValue();
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String cedula_identidad = request.getParameter("cedula_identidad");
        String sexo = request.getParameter("sexo");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        Clientes cli = new Clientes();
        cli.setId_cliente(aid);
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setCedula_identidad(cedula_identidad);
        cli.setSexo(sexo);
        cli.setDireccion(direccion);
        cli.setCelular(celular);
        cli.setCorreo(correo);
        ClientesDAO dao = new ClientesDAOimpl();
        try {
            dao.update(cli);
        } catch (Exception ex) {
            System.out.println("Error al Actualizar" + ex.getMessage());
        }
        response.sendRedirect("CuentaControlador");
    }
}
