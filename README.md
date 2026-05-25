# 🍔 How Many Burger - Minijuego Web

**How Many Burger** es una aplicación web monolítica desarrollada en Java que implementa el clásico juego de adivinanza numérica con una temática de hamburguesas. El sistema cuenta con gestión de usuarios, registro de historial de partidas y un salón de la fama (Leaderboard) con conexión a base de datos.

## Tecnologías y Arquitectura

Este proyecto fue construido utilizando el patrón de diseño **MVC (Modelo-Vista-Controlador)** y una arquitectura de capas puras para separar la lógica de negocio del acceso a datos.

* **Backend:** Java (Servlets, JSP).
* **Frontend:** HTML5, CSS3 puro y JavaScript (Validaciones de cliente).
* **Base de Datos:** MySQL (Conexión vía JDBC).
* **Servidor Web:** Apache Tomcat.
* **Librerías de terceros:** `mysql-connector-j-8.3.0.jar`

##  Estructura del Proyecto

* `com.hmb.config`: Configuración y puente de conexión a MySQL.
* `com.hmb.dao`: Objetos de Acceso a Datos (Consultas SQL nativas).
* `com.hmb.models`: Clases POJO que mapean las tablas de la base de datos.
* `com.hmb.services`: Reglas de negocio y lógica matemática del minijuego.
* `com.hmb.servlets`: Controladores de tráfico HTTP y gestión de Sesiones.
* `com.hmb.filters`: Filtro `EncodingFilter` para forzar la codificación UTF-8.
* `webapp`: Vistas dinámicas (JSP) y recursos estáticos (CSS/JS).

##  Guía de Instalación y Despliegue

Para ejecutar este proyecto en un entorno local, sigue estos pasos:

### 1. Base de Datos
1. Abre tu gestor de base de datos MySQL (ej. DBeaver, MySQL Workbench).
2. Localiza la carpeta `BD` en la raíz de este repositorio.
3. Ejecuta el script **`HMB_SQL.sql`** para generar automáticamente la base de datos `HMB` y sus respectivas tablas (`jugadores`, `partidas`, `ganadores`).

### 2. Configuración del Proyecto en Eclipse
1. Clona este repositorio en tu espacio de trabajo local.
2. Abre el archivo `src/main/java/com/hmb/config/DatabaseConfig.java`.
3. Actualiza la variable `PASSWORD` con la contraseña de tu instalación local de MySQL:
   ```java
   private static final String PASSWORD = "tu_contraseña_aqui";
