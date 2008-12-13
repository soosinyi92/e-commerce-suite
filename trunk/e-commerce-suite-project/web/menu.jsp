<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.dauphine.ecommerce.model.Cart" %>
<%@page import="fr.dauphine.ecommerce.model.CartItem" %>
<%@page import="fr.dauphine.ecommerce.servlet.Utils" %>
<%@page import="java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Menu</h2>
        <%
        Cart cart = Utils.getCart(session);
        %>
        
        <a href="home.jsp" target="main"><img border="0" src="boutons/accueil.gif" /></a>
        <br/><br/>
        
        <a href="catalog" target="main"><img border="0" src="boutons/catalog.gif" /></a>
        <br/><br/>
        
        <a href="panier" target="main"><img border="0" src="boutons/panier.gif" /></a>
        <br/><br/>

        AutoUpdated<br/>
        <% if (cart.isCanOrder()) { %>
            <a href="order" target="main"><img border="0" src="boutons/facturation.gif" /></a>
        <% } else { %>
            <img border="0" src="boutons/facturation.gif" style="filter:alpha(opacity=50); opacity: 0.5; -moz-opacity:0.5;" />
        <% } %>
        <br/><br/>
        
    </body>
</html>
