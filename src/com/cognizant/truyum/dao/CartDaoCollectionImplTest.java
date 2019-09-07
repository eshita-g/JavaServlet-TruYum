package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	CartDao cartDao;
	
	void testAddCartItem() throws CartEmptyException
	{
		cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1);
		cartDao.getAllCartItems(1);
		ArrayList<MenuItem> menuItemList=cartDao.getAllCartItems(1);
		for(MenuItem x:menuItemList)
		{
			System.out.println(x);
		}
	}
	void testGetAllCartItems() throws CartEmptyException
	{
		cartDao=new CartDaoCollectionImpl();
		cartDao.getAllCartItems(1);
		ArrayList<MenuItem> menuItemList=cartDao.getAllCartItems(1);
		for(MenuItem x:menuItemList)
		{
			System.out.println(x);
		}
	}
	void testRemoveCartItem() throws CartEmptyException
	{
		cartDao=new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 1);
		ArrayList<MenuItem> menuItemList=cartDao.getAllCartItems(1);
		for(MenuItem x:menuItemList)
		{
			System.out.println(x);
		}
		
	}
	
	public static void main(String[] args)  {
	CartDaoCollectionImplTest cart=new CartDaoCollectionImplTest();
	try {
		cart.testAddCartItem();
		cart.testGetAllCartItems();
		} catch (CartEmptyException e) {
		System.out.println(e);
	}
	
}
}
