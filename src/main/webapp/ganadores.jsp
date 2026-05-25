<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hmb.models.Ganador" %>
<%@ page import="com.hmb.dao.GanadorDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Salón de la Fama - How Many Burger</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>🏆 Salón de la Fama 🏆</h1>
        <p>Los mejores jugadores de la historia</p>
        
        <table border="1" style="width:100%; text-align:center; border-collapse: collapse; margin-top: 20px;">
            <tr style="background-color: #e67e22; color: white;">
                <th style="padding: 10px;">ID Victoria</th>
                <th style="padding: 10px;">ID Jugador</th>
                <th style="padding: 10px;">Fecha y Hora</th>
            </tr>
            <%
                // Instanciamos el DAO y pedimos la lista de ganadores
                GanadorDAO dao = new GanadorDAO();
                List<Ganador> ganadores = dao.obtenerTodosLosGanadores();
                
                if(ganadores != null && !ganadores.isEmpty()) {
                    // Bucle For-Each para imprimir cada fila de la tabla
                    for(Ganador g : ganadores) {
            %>
            <tr>
                <td style="padding: 8px;"><%= g.getId() %></td>
                <td style="padding: 8px;">Jugador #<%= g.getJugadorId() %></td>
                <td style="padding: 8px;"><%= g.getFechaIngreso() %></td>
            </tr>
            <%      }
                } else {
            %>
            <tr>
                <td colspan="3" style="padding: 15px; color: #7f8c8d;">Aún no hay ganadores. ¡Sé el primero en adivinar!</td>
            </tr>
            <%  } %>
        </table>
        
        <br><br>
        <a href="partida.jsp" style="color: #e67e22; font-weight: bold; text-decoration: none;">⬅ Volver al Juego</a>
    </div>
</body>
</html>