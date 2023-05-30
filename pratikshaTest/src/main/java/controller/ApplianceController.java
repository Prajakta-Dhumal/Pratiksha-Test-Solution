package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AppliancesModel;
@WebServlet("/shoplink")
public class ApplianceController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String appliancesCompany=req.getParameter("appliances");
		int quantity=Integer.parseInt(req.getParameter("quantites"));
		AppliancesModel model=new AppliancesModel();
		double bill=model.getBill(appliancesCompany, quantity);
		RequestDispatcher rd=req.getRequestDispatcher("getbill.jsp");
		req.setAttribute("finalbill",bill);
		rd.forward(req, resp);
		
	}

}
