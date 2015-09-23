<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="External.css">
<title>Pathfinder</title>
</head>
<body>
	<br />
	<br />
	<div class="block">
		<form action="MAIN">
			<button type="submit" class="btn">HOME</button>
			<button type="submit" class="btn" name="projects">PROJECTS</button>
			<button type="submit" class="btn" name="about">ABOUT</button>
			<button type="submit" class="btn" name="brntzn">BRNTZN</button>
		</form>
	</div>
	<br />
	<br />
	<div class="block" id="bgdiv">
		<h1>Pathfinder</h1>
		<br>
		<c:if test="${phase==1 }">
			<div class="titlediv" id="one"><h3>Create your maze:</h3></div>
			<br /> <br /> <br />
			<form action="PathServlet">
				<button class="btn2" type="submit" name="meerX">+X</button>
				<button class="btn2" type="submit" name="meerY">+Y</button>
				<button class="btn2" type="submit" name="clear">Clear</button>
				<button class="btn2" type="submit" name="refresh">Refresh</button>
				<button class="btn2" type="submit" name="sbmt" id="maze">Submit</button>
				<br /> <br /> <br />
				<c:forEach var="row" items="${grid}" varStatus="length">
					<c:forEach var="int" items="${row}" varStatus="width">
						<c:if test="${int==0}">
							<input class="check" type="checkbox"
								name="${width.index }name${length.index }"
								id="${width.index }id${length.index }" checked="checked">
							<label class="check" for="${width.index }id${length.index }"></label>
						</c:if>
						<c:if test="${int>0 }">
							<input class="check" type="checkbox"
								name="${width.index }name${length.index }"
								id="${width.index }id${length.index }">
							<label class="check" for="${width.index }id${length.index }"></label>
						</c:if>
					</c:forEach>
					<br />
				</c:forEach>
			</form>
		</c:if>
		<c:if test="${phase==2 }">
			<div class="titlediv" id="two"><h3>Set your startpoint:</h3></div>
			<br /> <br /> <br />
			<form action="PathServlet">
				<button class="btn2" type="submit" name="back" id="maze">Back</button>
				<button class="btn2" type="submit" name="clear">Clear</button>
				<button class="btn2" type="submit" name="refresh">Refresh</button>
				<br /> <br /> <br />
				<c:forEach var="row" items="${grid}" varStatus="length">
					<c:forEach var="int" items="${row}" varStatus="width">
						<c:if test="${int==0}">
							<div class="square" id="wall"></div>
						</c:if>
						<c:if test="${int>0 }">
							<button class="buttonsquare" type="submit" name="start"
								value="${width.index }value${length.index }" id="start"></button>
						</c:if>
					</c:forEach>
					<br />
				</c:forEach>
			</form>
		</c:if>
		<c:if test="${phase==3 }">
			<div class="titlediv" id="three"><h3>Set your endpoint:</h3></div>
			<br /> <br /> <br />
			<form action="PathServlet">
				<button class="btn2" type="submit" name="back" id="start">Back</button>
				<button class="btn2" type="submit" name="clear">Clear</button>
				<button class="btn2" type="submit" name="refresh">Refresh</button>
				<br /> <br /> <br />
				<c:forEach var="row" items="${grid}" varStatus="length">
					<c:forEach var="int" items="${row}" varStatus="width">
						<c:if test="${int==0}">
							<div class="square" id="wall"></div>
						</c:if>
						<c:if test="${int==1 }">
							<button class="buttonsquare" type="submit" name="end"
								value="${width.index }value${length.index }" id="end"></button>
						</c:if>
						<c:if test="${int==2}">
							<div class="square" id="start"></div>
						</c:if>
						<c:if test="${int>2 }">
							<button class="buttonsquare" type="submit" name="end"
								value="${width.index }value${length.index }" id="end"></button>
						</c:if>
					</c:forEach>
					<br />
				</c:forEach>
			</form>
		</c:if>
		<c:if test="${phase==4 }">
			<div class="titlediv" id="four"><h3>Here's your path:</h3></div>
			<br /> <br /> <br />
			<form action="PathServlet">
				<button class="btn2" type="submit" name="back" id="end">Back</button>
				<button class="btn2" type="submit" name="refresh">Refresh</button>
				<br /> <br /> <br />
				<c:forEach var="row" items="${grid}" varStatus="length">
					<c:forEach var="int" items="${row}" varStatus="width">
						<c:if test="${int==4}">
							<div class="square" id="route"></div>
						</c:if>
						<c:if test="${int==3}">
							<div class="square" id="end"></div>
						</c:if>
						<c:if test="${int==2}">
							<div class="square" id="start"></div>
						</c:if>
						<c:if test="${int==1}">
							<div class="square" id="empty"></div>
						</c:if>
						<c:if test="${int==0 }">
							<div class="square" id="wall"></div>
						</c:if>
					</c:forEach>
					<br />
				</c:forEach>
			</form>
		</c:if>
	</div>
</body>
</html>