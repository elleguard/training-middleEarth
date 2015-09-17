<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Middle Earth</title>
<link rel="stylesheet" type="text/css" href="style.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<div id="main">
		<h1>Middle Earth</h1>
		<hr>
		<br>
		<p>Welcome to Middle Earth, fill out the information below</p>
		<form method="post" action="board.jsp">
			<label>Number of Players: </label><br>
			<br>
			<select name="numberOfPlayers">
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<br>
			<br>
			<input type="submit" value="Play"/>
		</form>
		<br>
		<hr>
		<p class="footer">&copy; Mike &amp; Elle 2015 all rights reserved.</p>
	</div>
	
<audio src="http://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3" style="display: none" autoplay loop>

</body>
</html>
