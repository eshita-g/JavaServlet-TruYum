package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;
import com.cognizant.truyum.util.Dateutil;

import java.util.*;

public class MenuItemDaoCollectionImplTest {
	
	void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem>menuItemList=menuItemDao.getMenuItemListAdmin();
		for(MenuItem x:menuItemList)
		System.out.println(x);
	}
	void testGetMenuItemListCustomer() 
	{
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem>menuItemList=menuItemDao.getMenuItemListCustomer();
		for(MenuItem x:menuItemList)
		System.out.println(x);
	}
	void testModifyMenuItem()
	{
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem menuItem=new MenuItem(1,"Sandwitch","Snacks",(float)50.00,true,true,Dateutil.convertToDate("15/03/2017"));
		menuItemDao.modifyMenuItem(menuItem);
		menuItemDao.getMenuItem(menuItem.getId());
		System.out.println("Item Modified");
	}
	public static void main(String[] args) {
	
	
		MenuItemDaoCollectionImplTest test=new MenuItemDaoCollectionImplTest();
		//test.testGetMenuItemListAdmin();
	    test.testGetMenuItemListCustomer();
		/*try {
			test.testModifyMenuItem();
			System.out.println("Customer's List");
			test.testGetMenuItemListCustomer();
		} catch (Exception e) {
			System.out.println(e);
		}*/
	}

}
