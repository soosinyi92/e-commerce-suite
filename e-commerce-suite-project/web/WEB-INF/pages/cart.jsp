<%-- 
    Document   : catalog.jsp
    Created on : 12 déc. 2008, 19:19:58
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.dauphine.ecommerce.model.Cart" %>
<%@page import="fr.dauphine.ecommerce.model.CartItem" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
    </head>
    <body>
        <%
        Cart cart = (Cart)request.getAttribute("cart");
        int size = cart.getItems().size();
        String plural = (size > 1 ? "s" : "");
        %>
        
        <% if (size == 0) { %>
            <h1>Votre panier ne comprends aucun article</h1>
        <% } else { %>
            <h1>Votre panier comprends <%=size%> article<%=plural%></h1>
        <% } %>
        
        <% if (size > 0) { %>
            <table width="600px" border="0">
                <tr>
                    <th>*</th>
                    <th align="left">Ref.</th>
                    <th align="left">Album</th>
                    <th align="center">Quantité</th>
                    <th align="center">Quantité Stock</th>
                    <th align="center">Prix</th>
                </tr>
                
                <% for (CartItem article : cart.getItems().values()) { %>
                    <tr>
                        <td><a href="remove?ref=<%=article.getProduct().getId()%>">Remove</a></td>

                        <td><%=article.getProduct().getId()%></td>
                        <td><%=article.getProduct().getName()%></td>
                        <td align="center"><%=article.getQuantity()%></td>
                        <td align="center" style="color: gray"><%=article.getQuantityStock()%></td>
                        <td align="center"><%=article.getProduct().getPrice()%></td>
                    </tr>
                <%}%>

            </table>
        <% } else { %>
            <span>Panier vide</span>
        <% } %>
    </body>
</html>
