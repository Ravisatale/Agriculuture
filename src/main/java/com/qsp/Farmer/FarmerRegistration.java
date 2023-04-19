package com.qsp.Farmer;

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

import com.qsp.Agriculture.Farmer;
@WebServlet("/FarmerReg")
public class FarmerRegistration extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prasad");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String location=req.getParameter("location");
		String mbn=req.getParameter("mbn");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Farmer f=new Farmer();
		f.setId(Integer.parseInt(id));
		f.setName(name);
		f.setLocation(location);
		f.setMbn(Integer.parseInt(mbn));
		f.setEmail(email);
		f.setPass(pass);
		
		et.begin();
		em.persist(f);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Farmerlogin.html");
		rd.forward(req, resp);
		
		
	}

}
