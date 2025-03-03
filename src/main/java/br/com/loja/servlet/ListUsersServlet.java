package br.com.loja.servlet;

import br.com.loja.dao.UsuariosDao;
import br.com.loja.model.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/gerenciarusersADM"})
public class ListUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Usuarios> users = new UsuariosDao().findAllUsers();

        req.setAttribute("users", users);

        req.getRequestDispatcher("gerenciarusersADM.jsp").forward(req, resp);

    }
}
