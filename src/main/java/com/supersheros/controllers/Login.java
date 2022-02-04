package com.supersheros.controllers;

import com.supersheros.beans.Heros;
import com.supersheros.dao.DaoException;
import com.supersheros.dao.DaoFactory;
import com.supersheros.dao.ListIncidentDao;
import com.supersheros.dao.LoginDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.loginDao = daoFactory.getLoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            //Todo : Faire un truc + propre
            response.sendRedirect("/SupersHeros-1.0-SNAPSHOT/");

//            for(Cookie cookie : cookies){
//                if(cookie.getName().equals("NameHero")){
//                    request.setAttribute("NameHero", cookie.getValue());
//                }
//            }
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Heros heros = new Heros();
        heros.setName(request.getParameter("NameHero"));
        heros.setPassword(request.getParameter("PasswordHero"));

        try {
            if(loginDao.checkAuthentification(heros)){
                request.setAttribute("erreur", "Authentification réussi !");

                response.addCookie(new Cookie("NameHero", heros.getName()));

            } else {
                request.setAttribute("erreur", "Authentification ratée !");
            }
        } catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }

        request.setAttribute("NameHero", request.getParameter("NameHero"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
    }
}
