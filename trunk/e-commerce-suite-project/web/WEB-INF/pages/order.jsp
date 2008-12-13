<%-- 
    Document   : order
    Created on : 13 déc. 2008, 00:16:16
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.dauphine.ecommerce.model.Order" %>
<%@page import="fr.dauphine.ecommerce.model.OrderItem" %>
<%@page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commande</title>
    </head>
    <body>
        <%
        Order order = (Order)request.getAttribute("order");
        int size = order.getItems().size();
        String plural = (size > 1 ? "s" : "");
        %>

        <h1>Valider votre commande contenant <%=size%> article<%=plural%></h1>
        
        <% if (size > 0) { %>
            <table width="600px" border="0">
                <tr>
                    <th align="left">Ref.</th>
                    <th align="left">Album</th>
                    <th align="center">Quantité</th>
                    <!--
                    <th align="center">Quantité Stock</th>
                    -->
                    <th align="center">Prix Unitaire</th>
                    <th align="center">Prix</th>
                </tr>
                
                <% for (OrderItem article : order.getItems()) { %>
                    <tr>
                        <td><%=article.getProduct().getId()%></td>
                        <td><%=article.getProduct().getName()%></td>
                        <td align="center"><%=article.getQuantity()%></td>
                        <!--
                        <td align="center" style="color: gray"><%/*=article.getQuantityStock()*/%></td>
                        -->
                        <td align="center"><%=article.getProduct().getPrice()%></td>
                        <td align="center"><%=article.getTotalPrice()%></td>
                    </tr>
                <%}%>
                
            </table>
        <% } else { %>
            <span>Panier vide</span>
        <% } %>
        <br/>

        <span>Prix Total : <%=order.getTotalPrice()%></span>
        <br/>
        <span>Commander</span>
        <br/>
    </body>
</html>
