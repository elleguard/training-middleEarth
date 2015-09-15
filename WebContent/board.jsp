<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="boardStyle.css">
<title>Middle Earth Game</title>
</head>
<body>

	<div id="board">
		<div id="title">
			<h1>Middle Earth</h1>
			<hr>
		</div>

		<div class="row">
			<div class="tile" style="background: url('images/tiles/gondor.jpg');">
				<span>Gondor</span>
			</div>
			<div class="tile" style="background: url('images/tiles/mordor.jpg');">
				<span>Mordor</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/galmirror.jpg');">
				<span>The Mirror</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/isengard.jpg');">
				<span>Isengard</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/thedeadmarshes.jpg');">
				<span>Dead Marshes</span>
			</div>
		</div>
		<div class="row">
			<div class="side">
				<div class="tile" style="background: url('images/tiles/orcs.jpg');">
					<span>Orcs Camp</span>
				</div>
				<div class="tile" style="background: url('images/tiles/rohan.jpg');">
					<span>Rohan</span>
				</div>
			</div>

			<script>console.log(<%= request.getParameter("numberOfPlayers") %>)</script>

			<div id="center">
				<div>Player's Bank Accounts:</div>
				<% int players = Integer.parseInt(request.getParameter("numberOfPlayers")); %>
				
				<%
				for(int i = 0; i < players; i++ ){
					out.println("<div class='tokens' style='width: 31.3%; background-color:#2F2F73; margin: 1%'>"
					+ "<span>Aragorn</span>" +
					"<br>" +
					"<img src='images/tokens/aragorn.jpg'/>" +
					
				"</div>"); } %>
					
<!-- 					<div class="tokens" style="width: 31.3%; background-color:#863333; margin: 1%"> -->
<!-- 						<span>Frodo</span> -->
<!-- 						<br> -->
<!-- 						<img src="images/tokens/frodo.jpg" /> -->
<!-- 					</div> -->
<!-- 					<div class="tokens" style="width: 31.3%; background-color:#314613; margin: 1%"> -->
<!-- 						<span>Gandalf</span> -->
<!-- 						<br> -->
<!-- 						<img src="images/tokens/gandalf.jpg" /> -->
<!-- 					</div> -->
					
			</div>

			<div class="side">
				<div class="tile"
					style="background: url('images/tiles/theprancingpony.jpg');">
					<span>Prancing Pony</span>
				</div>
				<div class="tile"
					style="background: url('images/tiles/minastirith.jpg');">
					<span>Minas Tirith</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="tile"
				style="background: url('images/tiles/rivendell.jpg');">
				<span>Rivendell</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/galmirror.jpg');">
				<span>The Mirror</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/breeland.jpg');">
				<span>Breeland</span>
			</div>
			<div class="tile"
				style="background: url('images/tiles/theshire.jpg');">
				<span>The Shire</span>
			</div>
			<div class="tile">
				<span>Go</span>
			</div>
		</div>
	</div>
</body>
</html>