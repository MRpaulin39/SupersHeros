package com.supersheros.controllers;

import com.supersheros.beans.Incidents;
import com.supersheros.dao.DaoException;
import com.supersheros.dao.DaoFactory;
import com.supersheros.dao.IncidentDao;
import com.supersheros.dao.ListIncidentDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

@WebServlet(name = "CreateIncident", value = "/CreateIncident")
public class CreateIncident extends HttpServlet {
    private ListIncidentDao listIncidentDao;
    private IncidentDao incidents;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.listIncidentDao = daoFactory.getListIncidentDao();
        this.incidents = daoFactory.getIncidentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("listTypeIncident", listIncidentDao.lister());
        } catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/createincident.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Todo : Récupération de la liste des héro à 50km de l'incident

        try {
            if (request.getParameter("CityHeroLat").isEmpty() || request.getParameter("CityHeroLong").isEmpty()){
                request.setAttribute("erreur", "Veuillez inscrire une ville !");
                request.setAttribute("listTypeIncident", listIncidentDao.lister());

            }else if(Objects.equals(request.getParameter("IdIncident"), "0")){
                request.setAttribute("erreur", "Veuillez choisir un type d'incident");
                request.setAttribute("listTypeIncident", listIncidentDao.lister());
            }
            else{
                Float CityHeroLat = Float.parseFloat(request.getParameter("CityHeroLat"));
                Float CityHeroLong = Float.parseFloat(request.getParameter("CityHeroLong"));
                int IdIncident = Integer.parseInt(request.getParameter("IdIncident"));

                //Vérifie si la liste renvoyé est vide, si c'est le cas, on envoi le message d'erreur
                if(incidents.lister(CityHeroLat,CityHeroLong,IdIncident).isEmpty()){
                    request.setAttribute("erreur", "Aucun héro n'est assez proche pour résoudre cette incident :'(");
                }
                else{
                    request.setAttribute("listHeroIncident", incidents.lister(CityHeroLat,CityHeroLong,IdIncident));
                }
            }





        } catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/createincident.jsp").forward(request, response);
    }
}
