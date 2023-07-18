package com.example.jeu_de_des;

import com.example.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Login", value = "/")
public class Login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        ArrayList<Utilisateur> users= (ArrayList<Utilisateur>) getServletContext().getAttribute("users");
        if(users!=null){
            String login=(String)request.getParameter("llogin");
            String pw=(String)request.getParameter("pwd");
            for(Utilisateur user :users){
                if(user.getLogin().equals(login) && user.getPassword().equals(pw)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("current_user",user);
                    if(getServletContext().getAttribute("bestScore")==null){
                        getServletContext().setAttribute("bestScore",0);
                    }
                    Integer bestScore=(Integer) getServletContext().getAttribute("bestScore");
                    System.out.println("Best score: "+bestScore);
                    getServletContext().getRequestDispatcher("/LancerPartie.jsp").forward(request,response);
                }
            }
            request.setAttribute("error","Login ou mot de passe érroné!");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
        }else {
            System.out.println("null");
            request.setAttribute("error","Pas d'utilisateurs!");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
        }
    }
}