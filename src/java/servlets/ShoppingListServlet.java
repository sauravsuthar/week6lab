/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 808735
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/ShoppingList"})
public class ShoppingListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String action = "";
		// default action = register
		if (request.getParameter("action") == null) {
			action = "register";
		} else {
			action = request.getParameter("action");
		}
		
		if (action.equals("logout")) {
			request.getSession().invalidate();
			response.sendRedirect("?action=register");
			return;
		}
		

		if (request.getSession().getAttribute("username") != null) {
			System.out.println(request.getSession().getAttribute("list"));
			this.getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
		}
		// if not user specified
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String action = "";
		
		if (request.getParameter("action") == null) {
			response.sendRedirect("ShoppingList");
			return;
		} else {
			action = request.getParameter("action");
		}
		
		if (action.equals("register") && request.getParameter("name") != null) {
			request.getSession().setAttribute("username", request.getParameter("name"));
			ArrayList<String> list = new ArrayList<>();
			request.getSession().setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
			return;
                        
                        
		} else if (action.equals("add") && request.getParameter("item") != null) {
			ArrayList<String> list = (ArrayList<String>) request.getSession().getAttribute("list");
			list.add(request.getParameter("item"));
			request.getSession().setAttribute("list", list);
			response.sendRedirect("ShoppingList");
			return;
                        
                        
		} else if (action.equals("delete") && request.getParameter("deleteIndex") != null) {
			System.out.println("DELETE");
			ArrayList<String> list = (ArrayList<String>) request.getSession().getAttribute("list");
			try {
				list.remove(Integer.parseInt(request.getParameter("deleteIndex")));
			} catch (NumberFormatException e) {
				
			}
			request.getSession().setAttribute("list", list);
			response.sendRedirect("ShoppingList");
			return;
		}
		
		response.sendRedirect("ShoppingList");
	}
}
