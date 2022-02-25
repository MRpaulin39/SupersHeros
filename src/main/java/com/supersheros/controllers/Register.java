package com.supersheros.controllers;

import com.supersheros.beans.BeanException;
import com.supersheros.beans.Heros;
import com.supersheros.beans.ListIncidents;
import com.supersheros.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IncidentDao incidentDao;
    private RegisterDao registerDao;
    private ListIncidentDao listIncidentDao;
    List<Integer> myListIncident = new ArrayList<Integer>();

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.incidentDao = daoFactory.getIncidentDao();
        this.registerDao = daoFactory.getRegisterDao();
        this.listIncidentDao = daoFactory.getListIncidentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("CookieNameHero") && !Objects.equals(cookie.getValue(), "")){

                    //Renvoi vers la page d'accueil
                    response.sendRedirect(request.getContextPath());
                }

            }

        }

        try {
            request.setAttribute("listTypeIncident", listIncidentDao.lister());
        } catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/register.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Heros heros = new Heros();
        try {
            for(ListIncidents incident : listIncidentDao.lister()){
                if (Objects.equals(request.getParameter("Cb" + incident.getId()), "on")){
                    myListIncident.add(incident.getId());
                }

            }

            if(myListIncident.size() != 0 && myListIncident.size() <= 3){
                heros.setName(request.getParameter("NameHero"));
                heros.setPhone(request.getParameter("PhoneHero"));
                heros.setCity(request.getParameter("CityHero"));
                heros.setCityLat(Float.parseFloat(request.getParameter("CityHeroLat")));
                heros.setCityLong(Float.parseFloat(request.getParameter("CityHeroLong")));
                heros.setPassword(request.getParameter("PasswordHero"));
                heros.setPasswordCheck(request.getParameter("PasswordCheckHero"));

                if(registerDao.AddHeros(heros)){
                    //Ajout des incidents au hero
                    for(int id_incident : myListIncident){
                        listIncidentDao.addIncidentToHero(heros.getName(), id_incident);

                    }

                    //Ajout de l'utilisateur au cookie
                    response.addCookie(new Cookie("NameHero", heros.getName()));

                    //Renvoi vers la page d'accueil
                    response.sendRedirect(request.getContextPath());

                } else {
                    request.setAttribute("erreur", "Inscription ratée !");

                }

                //On préremplie le formulaire
                request.setAttribute("NameHero", request.getParameter("NameHero"));

            } else {
                request.setAttribute("erreur", "Veuillez choisir entre 1 et 3 incident(s) que vous pouvez gérer !");
            }

            request.setAttribute("listTypeIncident", listIncidentDao.lister());

            //Réinitialisation de la liste
            myListIncident.clear();

        } catch (BeanException | DaoException e) {
            request.setAttribute("erreur", e.getMessage());
            request.setAttribute("NameHero", request.getParameter("NameHero"));
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/register.jsp").forward(request, response);

    }
}
