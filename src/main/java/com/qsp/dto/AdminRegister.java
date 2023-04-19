package com.qsp.dto;

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

import com.qsp.Agriculture.Admin;
@WebServlet("/register")
public class AdminRegister extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Admin a=new Admin();
		a.setId(Integer.parseInt(id));
		a.setName(name);
		a.setEmail(email);
		a.setPass(pass);
		
		et.begin();
		em.persist(a);
		et.commit();
		
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		
		
	}

}
