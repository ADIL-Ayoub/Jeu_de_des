package com.example.jeu_de_des;

import com.example.bo.Utilisateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jdk.jshell.execution.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

@WebServlet(name = "LancerPartie", value = "/LancerPartie")
public class LancerPartie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in get from LancerPartie");
        getServletContext().getRequestDispatcher("/LancerPartie.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in post from LancerPartie");
        String num= (String)request.getParameter("num_de");
        Random random= new Random();
        int val_de= random.nextInt(6)+1;
        System.out.println(val_de);
        int num_de =Integer.parseInt(num);
        Utilisateur user =(Utilisateur) request.getSession().getAttribute("current_user");
        int score=0;
        HashMap<Integer,Integer> map;
        if(num_de>3 || num_de< 0){
            score=-1;
            request.setAttribute("score",score);
            getServletContext().getRequestDispatcher("/Resultat.jsp").forward(request,response);
        }
        else{
            if(request.getSession().getAttribute("map")==null){
                map= new HashMap<Integer,Integer>();
            }else {
                map=(HashMap<Integer,Integer>)request.getSession().getAttribute("map");
            }
            if(map.containsKey(num_de)){
                score=0;
                request.setAttribute("score",score);
                user.setBestScore(0);
                request.getSession().removeAttribute("map");
                request.setAttribute("bestScore",(Integer)getServletContext().getAttribute("bestScore"));
                getServletContext().getRequestDispatcher("/Resultat.jsp").forward(request,response);
            }
            else{
                map.put(num_de,val_de);
                request.getSession().setAttribute("map",map);
                System.out.println(map);
            }
            if(map.size()==2){
                if(map.get(1)== map.get(2) || map.get(2)==map.get(3) || map.get(1) == map.get(3)){
                    score=0;
                    request.setAttribute("score",score);
                    //user.setBestScore(0);
                    request.getSession().removeAttribute("map");
                    request.setAttribute("bestScore",(Integer)getServletContext().getAttribute("bestScore"));
                    getServletContext().getRequestDispatcher("/Resultat.jsp").forward(request,response);
                }
            }
            if(map.size()==3){
                if(map.get(1)< map.get(2) && map.get(2)<map.get(3)){
                    score=map.get(1)+ map.get(2) + map.get(3);
                }
                else if(map.get(1)> map.get(2) && map.get(2)> map.get(3)){
                    score=map.get(1)* map.get(2) * map.get(3);
                }
                if(score>user.getBestScore()) user.setBestScore(score);
                request.getSession().removeAttribute("map");
                request.setAttribute("score",score);
                Integer bestScore= (Integer) getServletContext().getAttribute("bestScore");
                if(user.getBestScore()>bestScore)
                    getServletContext().setAttribute("bestScore",user.getBestScore());
                request.setAttribute("bestScore",(Integer)getServletContext().getAttribute("bestScore"));
                getServletContext().getRequestDispatcher("/Resultat.jsp").forward(request,response);
            }
            if(map.size()<3){
                getServletContext().getRequestDispatcher("/LancerPartie.jsp").forward(request,response);
            }
        }
    }
}
