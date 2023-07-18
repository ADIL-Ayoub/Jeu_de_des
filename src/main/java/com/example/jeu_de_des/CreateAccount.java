package com.example.jeu_de_des;

import com.example.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "creerCompte", value = "/creerCompte")
public class CreateAccount extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        System.out.println("in get from creerCompte");
        getServletContext().getRequestDispatcher("/CreerCompte.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String nom= (String)request.getParameter("nom");
        String prenom= (String)request.getParameter("prenom");
        String login= (String)request.getParameter("login");
        String pw= (String)request.getParameter("pw");
        Utilisateur user= new Utilisateur(nom,prenom,login,pw);
        ArrayList<Utilisateur> old_list= (ArrayList<Utilisateur>)getServletContext().getAttribute("users");
        ArrayList<Utilisateur> list;
        if(old_list!=null){
            list= new ArrayList<Utilisateur>(old_list);
            for(Utilisateur user1 : old_list)
                System.out.println(user1);
        }
        else list= new ArrayList<Utilisateur>();
        list.add(user);
        getServletContext().setAttribute("users",list);
        getServletContext().getRequestDispatcher("/").forward(request,response);
    }

}