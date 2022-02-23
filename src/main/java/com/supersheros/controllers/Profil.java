package com.supersheros.controllers;

import com.supersheros.beans.ListIncidents;
import com.supersheros.dao.DaoException;
import com.supersheros.dao.DaoFactory;
import com.supersheros.dao.IncidentDao;
import com.supersheros.dao.ListIncidentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Profil", value = "/Profil")
public class Profil extends HttpServlet {
    private ListIncidentDao listIncidentDao;
    List<Integer> myListIncident = new ArrayList<Integer>();

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.listIncidentDao = daoFactory.getListIncidentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameHero = "";
        Cookie[] cookies = request.getCookies();
        //Si l'utilisateur est authentifié
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("NameHero") && !Objects.equals(cookie.getValue(), "")){
                    nameHero = cookie.getValue();


                }
            }

            if (!nameHero.isEmpty()){

                //Affichage de la liste des évènements que peux gérer le Hero
                try {
                    request.setAttribute("NameHero", nameHero);
                    request.setAttribute("listIncidentProfil", listIncidentDao.listerIncidentOfHero(nameHero));
                    request.setAttribute("listTypeIncident", listIncidentDao.lister());
                } catch (DaoException e) {
                    e.printStackTrace();
                }


            } else {
                //S'il n'est pas connecté, on redirige vers la page d'authentification
                //Renvoi vers la page d'accueil
                response.sendRedirect(request.getContextPath() + "/Login");
            }


        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/profil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Todo : Vérifier que le nombre d'incident est bien compris entre 1 et 3
        String nameHero = "";
        Cookie[] cookies = request.getCookies();
        //Si l'utilisateur est authentifié
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("NameHero") && !Objects.equals(cookie.getValue(), "")) {
                    nameHero = cookie.getValue();


                }
            }

            if (!nameHero.isEmpty()){
                try {
                    for(ListIncidents incident : listIncidentDao.lister()){
                        if (Objects.equals(request.getParameter("Cb" + incident.getId()), "on")){
                            myListIncident.add(incident.getId());
                        }

                    }

                    if(myListIncident.size() != 0 && myListIncident.size() <= 3){
                        //Supprimer les incidents d'un héro
                        if (listIncidentDao.deleteIncidentToHero(nameHero)){
                            //Ajouter les incidents à un héro
                            for(int id_incident : myListIncident){
                                listIncidentDao.addIncidentToHero(nameHero, id_incident);

                            }

                            request.setAttribute("succes", "Mise à jour réussit ! ");
                        } else {
                            request.setAttribute("erreur", "La suppression des incidents a été un echec");
                        }


                    }
                    else {
                        request.setAttribute("erreur", "Veuillez choisir entre 1 et 3 incidents ! (" + myListIncident.size() + ")");
                    }

                    //Récupération des informations pour la page
                    request.setAttribute("NameHero", nameHero);
                    request.setAttribute("listIncidentProfil", listIncidentDao.listerIncidentOfHero(nameHero));
                    request.setAttribute("listTypeIncident", listIncidentDao.lister());

                    //Réinitialisation de la liste
                    myListIncident.clear();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/profil.jsp").forward(request, response);
    }

}
