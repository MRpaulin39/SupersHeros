package com.supersheros.controllers;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet(name = "Home", value = "/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //teste de l'appel API
//        String cityName = "Saint Malot";
//        System.out.println("Nom de la ville = " + cityName);
//
//        cityName = cityName.replace(" ", "%20");
//
//        System.out.println("Nom de la ville corrigé = " + cityName);
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest requestApi = HttpRequest.newBuilder().uri(URI.create("https://nominatim.openstreetmap.org/search?q=" + cityName + "%20france&format=json")).build();
//        client.sendAsync(requestApi, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenApply(Home::parse)
//                        .join();
//
//        //request.setAttribute("erreur", "Inscription ratée !");


        this.getServletContext().getRequestDispatcher("/WEB-INF/Pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    //ToDo Faire un model qui transforme les villes en coordonnées et inversement
//    public static String parse(String responsebody){
//        System.out.println(responsebody);
//
//
//        if (responsebody != null ){
//            JSONArray albums = new JSONArray(responsebody);
//            JSONObject album = albums.getJSONObject(0);
//            float lat = album.getFloat("lat");
//            float longitude = album.getFloat("lon");
//
//            System.out.println("Lat = " + lat + "     long = " + longitude);
//        } else {
//            System.out.println("Erreur, le nom de la ville n'est pas reconnu !");
//        }
//
//
//
//        return null;
//    }
}
