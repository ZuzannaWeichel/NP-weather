<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">	
	<script
	 src="https://code.jquery.com/jquery-3.3.1.min.js"
	 integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="css/site.css">
	
<title>National Park Geek</title>
</head>
	<body>
		 <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek logo" style="width: 50vw"/>
        </a>
    </header>
   <div >
    <nav class="navbar navbar-dark bg-dark">
       <div>
       	<ul class="navbar-nav">
            <li class="nav-item active"><a class="nav-link" href="${homePageHref}">Home</a></li>
            <li class="nav-item active"><a class="nav-link" href="survey">Survey</a></li>
            <li class="nav-item active"><a class="nav-link" href="favParks">Favorite Parks</a></li>  
        </ul> 
       </div>
    </nav>
  </div>
  
  <section class="main-body">