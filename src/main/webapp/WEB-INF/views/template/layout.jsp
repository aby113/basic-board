<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%String servletPath = request.getServletPath(); %>
<%String pageName = servletPath.substring(servletPath.lastIndexOf("/") + 1, servletPath.lastIndexOf("."));%>
<c:set var="contextPath" value="<%= pageName %>"/>
<!DOCTYPE html>
<html lang="ko">

<head>
  <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/board.css' />">
    <link rel="stylesheet" href="">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
  <div id="wrap">
    <header class="header">
        <nav>

            <a href="#">HOME</a>
            <a href="#">toyProject#board</a>
            <span id="loginBox">
              <input type="text" id="email" placeholder="email">
              <input type="text" name="" id="password" placeholder="비밀번호">
              <button id="loginBtn">로그인</button>
            </span>

        </nav>
    </header>
    <nav class="side">
        <div id="linkbox">
            <a href="#">회원게시판</a>
        </div>
    </nav>