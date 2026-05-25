<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>How Many Burger - Iniciar Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>🍔 How Many Burger 🍔</h1>
        <h2>¡Adivina la cantidad oculta!</h2>

        <% if(request.getAttribute("error") != null) { %>
            <div class="alerta error">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>
        
        <% if(request.getAttribute("mensajeExito") != null) { %>
            <div class="alerta exito">
                <%= request.getAttribute("mensajeExito") %>
            </div>
        <% } %>

        <hr style="width: 80%; border: 1px solid #eee;">

        <h3>Iniciar Sesión</h3>
        <form action="jugador" method="POST">
            <input type="hidden" name="accion" value="login">
            
            <label>Usuario:</label><br>
            <input type="text" name="usuario" required>
            <br>
            
            <label>Contraseña:</label><br>
            <input type="password" name="contrasena" required>
            <br>
            
            <button type="submit">Entrar al Juego</button>
        </form>

        <br><br>
        <hr style="width: 80%; border: 1px solid #eee;">

        <h3>¿Eres nuevo? Regístrate</h3>
        <form action="jugador" method="POST">
            <input type="hidden" name="accion" value="registrar">
            
            <label>Usuario:</label><br>
            <input type="text" name="usuario" required>
            <br>
            
            <label>Contraseña:</label><br>
            <input type="password" name="contrasena" required>
            <br>
            
            <button type="submit">Crear Cuenta</button>
        </form>
    </div>
</body>
</html>