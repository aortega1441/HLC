<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Departamento de Recursos Humanos - My Company</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">My Company</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="#">Inicio</a></li>            
            <li><a href="#">Administraci�n</a></li>                        
            <li><a href="#">Acerca</a></li>            
          </ul>
        </nav>
      </div>
      
      <!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->    
      <form method ="post" action="#" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
          
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>�ENCUENTRA TU TRABAJO IDEAL!</h2>
        <!--
        <h4>ESTAMOS CONTRATANDO</h4>
        -->
        <p class="lead text-justify">Bienvenido a My Company, aqu� podr�s encontrar ofertas de empleos 
          que sean adecuados a tu perfil, experiencia y ubicaci�n. 
          Es muy f�cil de usar, solo haz clic en una vacante, ingresa para ver los detalles y env�anos tu CV en formato 
          PDF o DOCX. Nosotros revisaremos tu CV y posteriormente te contactaremos.<br><br>

        <p><a class="btn btn-lg btn-success" href="#" role="button">Ver m�s Ofertas</a></p>                
      </div>

      <h1>Ofertas recientes</h1>

     <!-- Example row of columns -->
      <div class="row">
      
      <c:forEach items="${ultimas}" var="vacante" varStatus="status" >
      
      <div class="col-ig-4">
      
      <h3>Vacante: ${vacante.id}</h3>
      <p class="text-danger">${vacante.nombre}</p>
      <p class="text-justify">${vacante.descripcion}</p>
      <p><a class="btn btn-primary" href="vacante?action=ver&id=${vacante.id})" role="button">Ver detalles</a></p>      
      </div>
      
      </c:forEach>
      
       
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2016 My Company, Inc.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
