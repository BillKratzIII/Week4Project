package com.footballservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.football.DAO;
import com.football.FantasyPlayer;
import com.football.StatLine;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FantasyPlayer playerToAdd = new FantasyPlayer();
		StatLine sl = new StatLine();
		
		
		playerToAdd.setFirstName(request.getParameter("firstName"));
		playerToAdd.setLastName(request.getParameter("lastName"));
		playerToAdd.setPosition(request.getParameter("position"));
		playerToAdd.setNflTeam(request.getParameter("nflTeam"));
		System.out.println(playerToAdd.toString());
		DAO.writeToDB(playerToAdd);
		sl.setPlayerID(DAO.getNewPlayerID());
		sl.setLabel("2015 Stats");
		sl.setPassingYards(Integer.parseInt(request.getParameter("paYds")));
		sl.setPassingTDs(Integer.parseInt(request.getParameter("paTds")));
		sl.setPassingINTs(Integer.parseInt(request.getParameter("paInts")));
		sl.setRuYards(Integer.parseInt(request.getParameter("ruYds")));
		sl.setRuTDs(Integer.parseInt(request.getParameter("ruTds")));
		sl.setReceptions(Integer.parseInt(request.getParameter("receptions")));
		sl.setRecYards(Integer.parseInt(request.getParameter("recYds")));
		sl.setRecTDs(Integer.parseInt(request.getParameter("recTds")));
		sl.setRetTDs(Integer.parseInt(request.getParameter("retTds")));
		sl.setTwoPtConv(Integer.parseInt(request.getParameter("twoPtConv")));
		sl.setFumbLost(Integer.parseInt(request.getParameter("fumbLost")));
		DAO.addStats(sl);
	}

}
