package com.emergentes.controlador;

import com.emergentes.dao.ClientesDAO;
import com.emergentes.dao.ClientesDAOimpl;
import com.emergentes.dao.CuentasDAO;
import com.emergentes.dao.CuentasDAOimpl;
import com.emergentes.dao.RegCuentasDAO;
import com.emergentes.dao.RegCuentasDAOimpl;
import com.emergentes.modelo.Clientes;
import com.emergentes.modelo.Cuentas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistraControlador", urlPatterns = {"/RegistraControlador"})
public class RegistraControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Clientes cli = new Clientes();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("cliente", cli);
                request.getRequestDispatcher("clientereg.jsp").forward(request, response);
                break;
            case "view":
                response.sendRedirect("LoginControlador");
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String cedula_identidad = request.getParameter("cedula_identidad");
        String sexo = request.getParameter("sexo");
        String direccion = request.getParameter("direccion");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        int saldo = Integer.parseInt(request.getParameter("saldo"));
        Clientes cli = new Clientes();
        Cuentas cts = new Cuentas();
        ClientesDAO cltdao = new ClientesDAOimpl();
        CuentasDAO ctndao = new CuentasDAOimpl();
        RegCuentasDAO reg = new RegCuentasDAOimpl();        
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setCedula_identidad(cedula_identidad);
        cli.setSexo(sexo);
        cli.setDireccion(direccion);
        cli.setCelular(celular);
        cli.setCorreo(correo);
        cts.setSaldo(saldo);
        try {
            cltdao.insert(cli);
            id=reg.obtenerId(cedula_identidad);
            cts.setCod_cliente(id);
            ctndao.insert(cts);
        } catch (Exception ex) {
            System.out.println("Error al Actualizar" + ex.getMessage());
        }
        response.sendRedirect("RegistraControlador");
          
    }
}
