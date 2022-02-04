package com.supersheros.controllers;

import com.supersheros.dao.DaoException;
import com.supersheros.dao.DaoFactory;
import com.supersheros.dao.ListIncidentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ListIncidentDao listIncidentDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.listIncidentDao = daoFactory.getListIncidentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("listTypeIncident", listIncidentDao.lister());
        } catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
