<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="style.css" />
    <title>Guess My Number!</title>
</head>
<body>
	<header>
      <h1>Guess My Number!</h1>
      <p class="between">(Between 1 and 20)</p>
      <form action="guessurl" method="get">
      <button class="btn again">Again!</button>
      </form>
      ${secretDisplay }
    </header>
    <main>
      <section class="left">
      	<form action="guessurl" method="post">
        <input type="number" class="guess" name="guessednum" value="${guessedNumber }"/>
        <!-- <button onclick="window.location.href = 'FirstPage.html';">HOME</button> -->
        <button class="btn check">Check!</button>
        </form>
      </section>
      <section class="right">
        <p class="message">${message }</p>
        <p class="label-score">
          💯 Score:
          <span class="score">${score }</span>
        </p>
        <p class="label-highscore">
          🥇 Highscore: <span class="highscore">${highScore }</span>
        </p>
      </section>
    </main>
</body>
</html>