<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="boardStyle.css">
<title>Middle Earth Game</title>
<!-- Google CDN for JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
				<div id="7"></div>

			</div>
			<div class="tile" style="background: url('images/tiles/mordor.jpg');">
				<span>Mordor</span>
				<div id="8"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/galmirror.jpg');">
				<span>The Mirror</span>
				<div id="9"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/isengard.jpg');">
				<span>Isengard</span>
				<div id="10"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/thedeadmarshes.jpg');">
				<span>Dead Marshes</span>
				<div id="11"></div>
			</div>
		</div>
		<div class="row">
			<div class="side">
				<div class="tile" style="background: url('images/tiles/orcs.jpg');">
					<span>Orcs Camp</span>
					<div id="6"></div>
				</div>
				<div class="tile" style="background: url('images/tiles/rohan.jpg');">
					<span>Rohan</span>
					<div id="5"></div>
				</div>
			</div>

			<script>
				console.log(
			<%=request.getParameter("numberOfPlayers")%>
				)
			</script>

			<div id="center">
				<div>Player's Bank Accounts:</div>
				<%
					int players;

					if (request.getParameter("numberOfPlayers") != null) {
						players = Integer.parseInt(request.getParameter("numberOfPlayers"));
					} else {
						players = 1;
					}
				%>
				
				<%@ page import="com.usaa.MiddleEarth.GameController, java.util.ArrayList"  %>
				
				<%
				
					int width = (100 - (players * 2)) / players;
					for (int i = 0; i < players; i++ ) {
						

						out.println("<div id=\"" + i + "player\" class='tokens' style='width: " + width + "%; margin: 1%'>"
								+ "<span class=\"name\"></span>" + "<br>" + "<img src=''/><span class=\"money\"></span>" +

						"</div>");
					}
				%>

			</div>

			<div class="side">
				<div class="tile"
					style="background: url('images/tiles/theprancingpony.jpg');">
					<span>Prancing Pony</span>
					<div id="12"></div>
				</div>
				<div class="tile"
					style="background: url('images/tiles/minastirith.jpg');">
					<span>Minas Tirith</span>
					<div id="13"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="tile"
				style="background: url('images/tiles/rivendell.jpg');">
				<span>Rivendell</span>
				<div id="4"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/galmirror.jpg');">
				<span>The Mirror</span>
				<div id="3"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/breeland.jpg');">
				<span>Breeland</span>
				<div id="2"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/theshire.jpg');">
				<span>The Shire</span>
				<div id="1"></div>
			</div>
			<div class="tile"
				style="background: url('images/tiles/middle_earth.jpg');">
				<span>Go</span>
				<div id="0">
				</div>
			</div>
		</div>
	</div>
	<script>
		var tid = setInterval(mycode, 2);
		
		initBoard();
		
		function initBoard() {
			var numberOfPlayers = <%= request.getParameter("numberOfPlayers") %>;
			$.get("BoardStatusServlet?action=start&pNum=" + numberOfPlayers, function(data) {
				var initData = $.parseJSON(data);
				console.log(initData);
				
				for(var player in initData) {
					console.log($("#" + initData[player]["0"]["name"]));
					
					playerColor = initData[player]["0"]["color"];
					playerImg = initData[player]["0"]["image"];
					playerName = initData[player]["0"]["name"];
					
					$("#0").append("<div class=\"player\" id=\"" + playerName + "\" ></div>");
					
					$("#" + player + "player").css("background-color",playerColor);
					$("#" + initData[player]["0"]["name"]).css("background-color",playerColor);
					$("#" + player + "player img").attr("src",playerImg);
					$("#" + player + "player span.name").html(playerName);
				}
				
			});
		}
		
		function mycode() {
			console.log("Tick");
			$.get("BoardStatusServlet?action=roll", function(data) {
				var players = $.parseJSON(data);
				
				//console.log(moves);

				for(var player in players) {
					movePlayer(players[player]["0"]["name"], (parseInt(players[player]["0"]["rolled"]) + parseInt($("#" + players[player]["0"]["name"]).parent().attr("id"))) % 14);
					$("#" + player + "player span.money").html("<br>$" + players[player]["0"]["money"]);
				}
					

			});
		}
		//stops the timer if called
		function abortTimer() {
			clearInterval(tid);
		}

		function movePlayer(name, spacesToMove) {
			$("#" + name).appendTo("#" + spacesToMove);
		}
	</script>

</body>
</html>