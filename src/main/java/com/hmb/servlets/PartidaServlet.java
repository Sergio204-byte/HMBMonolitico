package com.hmb.servlets;

import com.hmb.models.Jugador;
import com.hmb.services.PartidaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/juego")
public class PartidaServlet extends HttpServlet {

    private PartidaService partidaService = new PartidaService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        
        if (sesion.getAttribute("jugadorLogueado") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int numeroSecreto = partidaService.generarNumeroHamburguesa(100);
        sesion.setAttribute("numeroSecreto", numeroSecreto);
        sesion.setAttribute("intentosTotales", 0);
        
        response.sendRedirect("partida.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        Jugador jugador = (Jugador) sesion.getAttribute("jugadorLogueado");
        
        if (jugador == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        if (sesion.getAttribute("numeroSecreto") == null) {
            doGet(request, response);
            return;
        }

        int numeroSecreto = (Integer) sesion.getAttribute("numeroSecreto");
        int intentos = (Integer) sesion.getAttribute("intentosTotales");
        
        int intentoJugador = Integer.parseInt(request.getParameter("intento"));
        intentos++; 
        sesion.setAttribute("intentosTotales", intentos);

        int resultado = partidaService.evaluarIntento(intentoJugador, numeroSecreto);

        if (resultado == 0) {
            // ¡VICTORIA!
            partidaService.registrarFinDePartida(jugador.getId(), intentos, true);
            
            sesion.removeAttribute("numeroSecreto");
            sesion.removeAttribute("intentosTotales");
            
            request.setAttribute("mensaje", "¡Felicidades! Adivinaste que eran " + numeroSecreto + " hamburguesas en " + intentos + " intentos. 🏆");
            request.getRequestDispatcher("partida.jsp").forward(request, response);
            
        } else if (resultado == -1) {
            request.setAttribute("mensaje", "Te pasaste... Hay MENOS de " + intentoJugador + " hamburguesas. (Llevas " + intentos + " intentos)");
            request.getRequestDispatcher("partida.jsp").forward(request, response);
            
        } else {
            request.setAttribute("mensaje", "Te faltó... Hay MÁS de " + intentoJugador + " hamburguesas. (Llevas " + intentos + " intentos)");
            request.getRequestDispatcher("partida.jsp").forward(request, response);
        }
    }
}