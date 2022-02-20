package com.supersheros.controllers;

import com.supersheros.beans.BeanException;
import com.supersheros.beans.Heros;
import com.supersheros.dao.DaoException;
import com.supersheros.dao.DaoFactory;
import com.supersheros.dao.LoginDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

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
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("NameHero") && !Objects.equals(cookie.getValue(), "")){
                    //Renvoi vers la page d'accueil
                    response.sendRedirect(request.getContextPath());
                }

            }

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Heros heros = new Heros();
        try {
            heros.setName(request.getParameter("NameHero"));
            heros.setPassword(request.getParameter("PasswordHero"));

            if(loginDao.checkAuthentification(heros)){
                request.setAttribute("erreur", "Authentification réussi !");

                response.addCookie(new Cookie("NameHero", heros.getName()));

                //Renvoi vers la page d'accueil
                response.sendRedirect(request.getContextPath());

            } else {
                request.setAttribute("erreur", "Authentification ratée !");
                request.setAttribute("NameHero", request.getParameter("NameHero"));
            }

        } catch (BeanException | DaoException e) {
            request.setAttribute("erreur", e.getMessage());
            request.setAttribute("NameHero", request.getParameter("NameHero"));
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
    }
}
