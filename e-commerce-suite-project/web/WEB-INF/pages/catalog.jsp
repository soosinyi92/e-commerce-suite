<%-- 
    Document   : catalog.jsp
    Created on : 12 déc. 2008, 19:19:58
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.dauphine.ecommerce.model.ProductStock" %>
<%@page import="java.util.List" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
        <%
        List<ProductStock> articles = (List<ProductStock>)request.getAttribute("articles");
        int size = articles.size();
        String plural = (size > 1 ? "s" : "");
        %>
        
        <% if (size == 0) { %>
            <h1>Notre catalogue ne comprends aucun article</h1>;
        <% } else { %>
            <h1>Notre catalogue comprends <%=size%> article<%=plural%></h1>
        <% } %>
        
        <% if (size > 0) { %>
            <table width='600px' border='0'>
                <tr>
                    <th align='center'><th>
                    <th align='left'>Ref.<th>
                    <th align='left'>Album<th>
                    <th align='center'>QuantitÃ©<th>
                    <th align='center'>Prix<th>
                </tr>
                
                <% for (ProductStock article : articles) { %>
                    <tr>

                        <% if (article.getQuantity() > 0) { %>
                            <td><a href='ajouter?ref=<%=article.getProduct().getId()%>'><img border='0' src='boutons/caddie-ad.gif' /></a><td>
                        <% } else { %>
                            <td>
                                <img border="0" src="boutons/caddie-ad.gif" style="filter:alpha(opacity=50); opacity: 0.5; -moz-opacity:0.5;" />
                            <td>
                        <% } %>

                        <td><%=article.getProduct().getId()%><td>
                        <td><%=article.getProduct().getName()%><td>
                        <td align='center'><%=article.getQuantity()%><td>
                        <td align='center'><%=article.getProduct().getPrice()%><td>
                    </tr>
                <%}%>

            </table>
        <% } %>
    </body>
</html>
