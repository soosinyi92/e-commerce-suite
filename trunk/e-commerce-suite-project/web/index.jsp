<%-- 
    Document   : index
    Created on : 4 déc. 2008, 15:27:09
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>Site d'achats en Ligne des albums</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <frameset cols="250px, *" border="2px">
      <frame src="menu.jsp" noresize scrolling="no" name="menu" />
      <frameset rows="80px, *" border="2px">
          <frame src="top.jsp" name="top" noresize scrolling="no" />
          <frame src="home.jsp" name="main" />
      </frameset>
  </frameset>
</html>

