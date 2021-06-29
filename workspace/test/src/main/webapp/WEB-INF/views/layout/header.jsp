<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>환영합니다</title>
	<link rel="stylesheet" href="resources/assets/css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" referrerpolicy="no-referrer" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	
	<div class="container">
		<header>
			<!-- 로고 -->
			<div class="logo">
				<img src="resources/assets/images/logo.jpg" alt="logo">
			</div>
			<!-- 로그인 및 회원가입 -->
			<div class="info">
				<a href="">로그인</a>
				<a href="">회원가입</a>
			</div>
			<!-- 메뉴 -->
			<div class="menu">
				<nav>
					<ul class="nav">
						<li><a href="">게시판</a>
							<ul class="sub">
								<li><a href="">서브1</a>
								<li><a href="">서브2</a>
								<li><a href="">서브3</a>
							</ul>
						</li>
						<li><a href="">메뉴1</a>
							<ul class="sub">
								<li><a href="">서브1</a>
								<li><a href="">서브2</a>
								<li><a href="">서브3</a>
							</ul>
						</li>
						<li><a href="">메뉴2</a>
							<ul class="sub">
								<li><a href="">서브1</a>
								<li><a href="">서브2</a>
							</ul>
						</li>
						<li><a href="">메뉴3</a>
							<ul class="sub">
								<li><a href="">서브1</a>
								<li><a href="">서브2</a>
								<li><a href="">서브3</a>
								<li><a href="">서브4</a>
								<li><a href="">서브5</a>
							</ul>
						</li>
						<li><a href="">메뉴4</a>
							<ul class="sub">
								<li><a href="">서브1</a>
								<li><a href="">서브2</a>
								<li><a href="">서브3</a>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</header>
		
		<section>
			<!-- 이미지(슬라이드) -->
			<div id="images">
				<div class="imgslide">
					<ul>
						<li><img src="resources/assets/images/slide(1).jpg" alt="no"></li>
						<li><img src="resources/assets/images/slide(2).jpg" alt="no"></li>
						<li><img src="resources/assets/images/slide(3).jpg" alt="no"></li>
						<li><img src="resources/assets/images/slide(1).jpg" alt="no"></li>
					</ul>
					<!-- 이미지 텍스트 -->
					<div class="imgtext">
						<h2><span>Wedding Planner</span></h2>
					</div>
					<!-- 이미지 버튼 -->
					<div class="imgslide_btn">
				      <a href="#" class="slide_btn_prev off">이전</a>
				      <a href="#" class="slide_btn_next">다음</a>
				    </div>
				</div>
			</div>
			
			<!-- 내용 -->
			<div id="contents">
				<!-- 게시판 미리보기 -->
				<div class="board">
			    	<h2>게시판</h2>
			        <table class="table">
			          
			        </table>
			    </div>
			    <!-- 파트너(팝업) -->
			    <div class="partner">
			    	
			    </div>
			</div>
			
			<!-- 아이콘 -->
			<div id="icons">
				<div class="icon_btn">
					
				</div>
			</div>

