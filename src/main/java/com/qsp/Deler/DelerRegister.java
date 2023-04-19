package com.qsp.Deler;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.Agriculture.Dealer;
@WebServlet("/DelerReg")
public class DelerRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String location=req.getParameter("location");
		String crop=req.getParameter("crop");
		String rate=req.getParameter("rate");
		
		Dealer d=new Dealer();
		d.setId(Integer.parseInt(id));
		d.setName(name);
		d.setLocation(location);
		d.setCrop(crop);
		d.setRate(Integer.parseInt(rate));
		
		et.begin();
		em.persist(d);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("DealerAfter.html");
		rd.forward(req, resp);
	}

}
