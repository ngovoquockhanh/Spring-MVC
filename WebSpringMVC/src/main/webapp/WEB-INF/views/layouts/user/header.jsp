<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="trangchu"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/logo.jpg" />"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4"></div>
		<div class="span4 alignR">
			<p>
				

				</span>
			</p>

		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
			<ul class="nav">
			  <li class="active"><a href="trangchu">Trang Chủ	</a></li>
			  <li class=""><a href="gio-hang">Giỏ Hàng</a></li>
			  <li class=""><a href="lienhe
			  ">Liên Hệ</a></li>
			</ul>
				<form action="#" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="search-query span2">

				</form>


				<ul class="nav pull-right">
				<c:if test="${empty LoginInfo }">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><span class="icon-lock"></span>
							Đăng Nhập <b class="caret"></b></a>
						<p style="margin-left: -35%; margin-top: -25%"></p>

						<div class="dropdown-menu">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<input type="text" class="span2" id="inputEmail"
										placeholder="Email">
								</div>
								<div class="control-group">
									<input type="password" class="span2" id="inputPassword"
										placeholder="Password">
								</div>
								<div class="control-group">
									<label class="checkbox"> <input type="checkbox">
										Remember me
									</label>
									<button type="submit" class="shopBtn btn-block">Sign
										in</button>
								</div>
							</form>
						</div></li>
						</c:if>
						<c:if test="${not empty  LoginInfo }">
						<li><a href="#">${LoginInfo.display_name }<b class="caret"></b></a>
						</li>
						</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>