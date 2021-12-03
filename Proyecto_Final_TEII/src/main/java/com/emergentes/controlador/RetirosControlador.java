package com.emergentes.controlador;

import com.emergentes.dao.RetirosDAO;
import com.emergentes.dao.RetirosDAOimpl;
import com.emergentes.modelo.Retiros;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RetirosControlador", urlPatterns = {"/RetirosControlador"})
public class RetirosControlador extends HttpServlet {
    
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
                Retiros dep = new Retiros();
                RetirosDAO dao = new RetirosDAOimpl();
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
                        request.setAttribute("retiros", dep);
                        request.getRequestDispatcher("Retiros.jsp").forward(request, response);
                        break;
                    case "edit":
                        //y aqui está como se envia al DAO y luego se redirigé al formulario
                        //Hay varias lineas de codigo que probé puedes borrarlas solo las que no estan comentadas funcionaron.
                        dep = dao.getById(aid);
                        request.setAttribute("Retiros", dep);
                        request.getRequestDispatcher("Retiros.jsp").forward(request, response);
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
        int monto = Integer.parseInt(request.getParameter("monto"));
        Retiros dep = new Retiros();
        dep.setMonto(monto);
        dep.setCod_cli(aid);
        RetirosDAO dao = new RetirosDAOimpl();
        try {
            dao.insert(dep);
        } catch (Exception ex) {
            System.out.println("Error al Actualizar" + ex.getMessage());
        }
        response.sendRedirect("CuentaControlador");
    }
}
