package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddToCartServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id =Long.parseLong( request.getParameter("id"));
		MenuItemDao  menuItemdao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemdao.getMenuItem(id);
	    CartDao cartDao = new CartDaoCollectionImpl();
	    long userId = 1;
	    MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		ArrayList<MenuItem> menuItemlist = null;
		menuItemlist = menuItemDao.getMenuItemListCustomer();
	    cartDao.addCartItem(userId, id);
	    boolean addCartStatus = true;
	    request.setAttribute("carts",addCartStatus);
	    request.setAttribute("x", menuItemlist);
	    RequestDispatcher rd = request.getRequestDispatcher("/menu-item-list-customer.jsp");
		rd.forward(request,response);
	}

}
