<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hmb.models.Jugador" %>
<%
    // PROTECCIÓN DE RUTA: Validamos que exista la sesión
    Jugador jugador = (Jugador) session.getAttribute("jugadorLogueado");
    if (jugador == null) {
        response.sendRedirect("index.jsp");
        return; // Detiene la carga de la página
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Partida - How Many Burger</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="js/validacion.js"></script>
</head>
<body>
    <div class="container">
        <h1>🍔 ¡Adivina las Hamburguesas! 🍔</h1>
        <p>Bienvenido al reto, <strong><%= jugador.getUsuario() %></strong>.</p>
        
        <% if(request.getAttribute("mensaje") != null) { %>
            <div class="alerta pista">
                <%= request.getAttribute("mensaje") %>
            </div>
        <% } %>

        <hr style="width: 80%; border: 1px solid #eee;">

        <form action="juego" method="POST" onsubmit="return validarIntento()">
            <label><strong>¿Cuántas hamburguesas crees que hay ocultas? (1 - 100)</strong></label><br>
            <input type="number" id="intento" name="intento" required min="1" max="100" placeholder="Ej. 42">
            <br><br>
            <button type="submit">Adivinar</button>
        </form>
        
        <br><br>
        <a href="ganadores.jsp" style="color: #e67e22; font-weight: bold; text-decoration: none;">🏆 Ver Salón de la Fama</a> 
        <br><br>
        <a href="index.jsp" style="color: #7f8c8d; text-decoration: none; font-size: 14px;">Cerrar Sesión</a>
    </div>
</body>
</html>