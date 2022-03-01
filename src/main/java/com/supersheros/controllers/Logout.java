package com.supersheros.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                Cookie destroyCookie = new Cookie(cookie.getName(), "");
                destroyCookie.setMaxAge(0);
                response.addCookie(destroyCookie);

                if(cookie.getName().equals("CookieNameHero")){
                    request.setAttribute("CookieNameHero", cookie.getValue());
                }
            }
        }

        //Renvoi vers la page d'accueil
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
