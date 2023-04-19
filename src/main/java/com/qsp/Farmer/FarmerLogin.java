package com.qsp.Farmer;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.Agriculture.Farmer;
@WebServlet("/Farmerlogin")
public class FarmerLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Query q=em.createQuery("select f from Farmer f where f.email=?1 and f.pass=?2");
		q.setParameter(1, email);
		q.setParameter(2, pass);
		
		List<Farmer> f=q.getResultList();
		if(f.size()>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("FarmerAfter.html");
			rd.forward(req, resp);
		}
		else
		{
			System.out.println("data not present");
			//RequestDispatcher rd=req.getRequestDispatcher("FarmerAfter.html");
			//rd.forward(req, resp);
		}
	}

}
