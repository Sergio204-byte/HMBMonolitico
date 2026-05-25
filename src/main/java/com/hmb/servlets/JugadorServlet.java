package com.hmb.servlets;

import com.hmb.models.Jugador;
import com.hmb.services.JugadorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jugador")
public class JugadorServlet extends HttpServlet {
    
    private JugadorService jugadorService = new JugadorService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion"); // Saber si presionó "Login" o "Registro"
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        if ("registrar".equals(accion)) {
            procesarRegistro(usuario, contrasena, request, response);
        } else if ("login".equals(accion)) {
            procesarLogin(usuario, contrasena, request, response);
        }
    }

    private void procesarRegistro(String usuario, String contrasena, 
                                  HttpServletRequest request, HttpServletResponse response) 
                                  throws ServletException, IOException {
        
        boolean registrado = jugadorService.registrarNuevoJugador(usuario, contrasena);
        
        if (registrado) {
            request.setAttribute("mensajeExito", "¡Registro exitoso! Ahora inicia sesión.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error al registrar. Verifica tus datos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void procesarLogin(String usuario, String contrasena, 
                               HttpServletRequest request, HttpServletResponse response) 
                               throws ServletException, IOException {
        
        Jugador jugador = jugadorService.iniciarSesion(usuario, contrasena);
        
        if (jugador != null) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("jugadorLogueado", jugador);
            
            response.sendRedirect("partida.jsp");
        } else {
            request.setAttribute("error", "Credenciales incorrectas.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}