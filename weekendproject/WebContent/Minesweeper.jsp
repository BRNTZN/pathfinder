<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="External.css">
<link rel="stylesheet" type="text/css" href="Minesweeper.css">
<title>Minesweeper</title>

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
		<h1>Minesweeper</h1>
		<br>
		<button type="submit" class="minebutton" id="sweep"></button>
		<button type="submit" class="minebutton" id="flag"></button>
		<button type="submit" class="minebutton" id="sweep"></button>
		<button type="submit" class="minebutton" id="flag"></button>
	</div>
</body>
</html>