package com.supersheros.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Home", value = "/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //teste de l'appel API
//        System.out.println("Résultat = " + request.getContextPath());
        String nameHero = "";
        Cookie[] cookies = request.getCookies();
        //Si l'utilisateur est authentifié
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("CookieNameHero") && !Objects.equals(cookie.getValue(), "")){
                    nameHero = cookie.getValue();

                }
            }

            request.setAttribute("CookieNameHero", nameHero);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
