package com.cognizant.truyum.dao;
import java.util.*;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long,Cart> userCart;
	
	ArrayList<MenuItem>menuItemList=new ArrayList<MenuItem>();
	public CartDaoCollectionImpl()
   {
       if(userCart==null)
       {
	        userCart=new HashMap<Long,Cart>();
       }
   }
	public static HashMap<Long, Cart> getUserCart() {
		return userCart;
	}
	public static void setUserCart(HashMap<Long, Cart> userCart) {
		CartDaoCollectionImpl.userCart = userCart;
	}
	public void addCartItem(long userId, long menuItemId)
	{	
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem menuItem =menuItemDao.getMenuItem(menuItemId);
		
		if(userCart.containsKey(userId))
		{
			
			menuItemList=(ArrayList<MenuItem>) userCart.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		}
		else
		{
			ArrayList<MenuItem>menuItemList=new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			Cart cart=new Cart(menuItemList,0);
			cart.setMenuItemList(menuItemList);
			userCart.put(userId,cart);
		}
	}
	
	@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem>menuItemList=new ArrayList<MenuItem>();
		 try
		 {
			 menuItemList=userCart.get(userId).getMenuItemList();
		 }
		 catch(NullPointerException e)
		 {
			 
		 }
		
		 if(menuItemList.isEmpty())
		{
			throw new CartEmptyException("Cart is empty");
		
		}
		 float sum=0.0f;
			
			for(MenuItem x:menuItemList)
			{
				sum=sum+x.getPrice();
				
			}
			userCart.get(userId).setTotal(sum);
			return menuItemList;
		
	}
	public double getTotal(long userId) {
		return 	userCart.get(userId).getTotal();
	}
	
	
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		 ArrayList<MenuItem>menuItemList=(ArrayList<MenuItem>) userCart.get(userId).getMenuItemList();
		double total = userCart.get(userId).getTotal();
		 for(MenuItem x:menuItemList)
		{
			if(x.getId()==menuItemId)
			{
		        menuItemList.remove(menuItemList.indexOf(x));
		        total = total - x.getPrice();
		        break;
			}
			userCart.get(userId).setMenuItemList(menuItemList);
			userCart.get(userId).setTotal(total);
			
			
		}
		
	}
}
