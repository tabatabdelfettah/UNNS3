<%@page import="java.util.List"%>
<%@page import="com.mycompany.senior.commun.bean.CityBean"%>
<%@page import="com.mycompany.senior.bll.SeniorBLGateway"%>
<%@page import="com.lobashevski.Entity.City"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!SeniorBLGateway bll;%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Show Data</title>
  <link rel="stylesheet" href="./style.css">

</head>
<body>
    
<!-- partial:index.partial.html -->
<h1>My product ):</h1>

<table class="zigzag">
  <thead>
    <tr>
      <th class="header">Id</th>
      <th class="header">Name Ar</th>
      <th class="header">Name En</th>
      
    </tr>
  </thead>
  
      <% bll = new SeniorBLGateway();
      List<CityBean>Cities = bll.findCities();
      for (CityBean c : Cities) {
              
          
      %>
           
      
    
    <tr>
        
      <td> <%= c.getId()%></td>
      <td><%=c.getNameAr() %></td>
      <td><%=c.getNameEn()%></td>
     
    </tr>
    <%}%>
  
</table>
    <style>
        .GFG {
            background-color: white;
            border: 2px solid black;
            color: green;
            padding: 5px 10px;
            text-align: center;
            display: inline-block;
            font-size: 20px;
            margin: 10px 30px;
            cursor: pointer;
        }
    </style>
    <a href="AddProduct.jsp">
        <button class="GFG">
           Add Product
        </button>
    </a>
<!-- partial -->
  
</body>
</html>
