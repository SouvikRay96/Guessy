package com.wipro.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuessNumberServlet
 */
@WebServlet(value="/guessurl",loadOnStartup = 1)
public class GuessNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int score;
	public int highScore = 0;
	private static int secretNumber;
	private String message;
	public void init() throws ServletException {
		score = 20;
		//highScore = 0;
		//message = "Start Guessing...";
		Random rand = new Random();
		secretNumber = rand.nextInt(20) + 1;
		System.out.println(secretNumber);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting the Content Type
		response.setContentType("text/html");
		//Generating a random Number
		
		//Retrieving The guessed number from the webpage
		int guessedNumber = Integer.parseInt(request.getParameter("guessednum"));
		String secretDisplay = null;
		//Checking the guessedNumber with the randomly Generated Number
		if(guessedNumber == secretNumber) {
			request.setAttribute("secretNumber", secretNumber);
			if(score > highScore)
				highScore = score;
			message = "Correct Number";
			secretDisplay = "<div class=\"number\">\r\n"
					+ secretNumber
					+ "      </div>"
					+"<script>document.querySelector('body').style.backgroundColor = '#60b347';\r\n"
					+ "document.querySelector('.number').style.width = '30rem';"
					+"</script>";
			
		}
		else {
			if(score > 1) {
				if(guessedNumber > secretNumber)
					message = "Number too High";
				else if(guessedNumber < secretNumber)
					message = "Number too Low";
			}
			else
				message = "Soory Dude !! You lost The Game"
						+"<script>document.querySelector('body').style.backgroundColor = '#FF4500';</script>";
			score--;
			secretDisplay = "<div class=\"number\">\r\n"
					+ "      	?\r\n"
					+ "      </div>";
			
		}
		request.setAttribute("secretDisplay", secretDisplay);
		request.setAttribute("highScore", highScore);
		request.setAttribute("score", score);
		request.setAttribute("guessedNumber", guessedNumber);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
		rd.forward(request, response);
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.init();
		String secretDisplay = null;
		secretDisplay = "<div class=\"number\">\r\n"
				+ "      	?\r\n"
				+ "      </div>"
				+"<script>document.querySelector('body').style.backgroundColor = '#222';\r\n"
				+ "document.querySelector('.number').style.width = '15rem';"
				+"</script>";
		message = "Start Guessing...";
		request.setAttribute("highScore", highScore);
		request.setAttribute("score", score);
		request.setAttribute("secretDisplay", secretDisplay);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
		rd.forward(request, response);
	}

}
