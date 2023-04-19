package com.qsp.dto;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.qsp.Agriculture.Admin;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Query q=em.createQuery("select a from Admin a where a.email=?1 and a.pass=?2");
		
		q.setParameter(1, email);
		q.setParameter(2, pass);
		
		
		List<Admin> a=q.getResultList();
		if(a.size()>0)
		{
			
			RequestDispatcher rd = req.getRequestDispatcher("option.html") ;
			rd.include(req, resp);
		}
		else
		{
			PrintWriter pw = resp.getWriter() ;
			pw.write("invalid credentials");

			RequestDispatcher rd = req.getRequestDispatcher("login.html") ;
			rd.include(req, resp);
		}
		
	}

}
