package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;

import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.Dateutil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
private static ArrayList<MenuItem> menuItemList;
public MenuItemDaoCollectionImpl()
{
	if(menuItemList==null)
	{
		ArrayList<MenuItem> al=new ArrayList<MenuItem>();
		try{
		MenuItem e = new MenuItem(1,"Sandwich","Main Course",99f,true,false,Dateutil.convertToDate("15/03/2017"));
		al.add(e);
		MenuItem e1 = new MenuItem(2,"Burger","Main Course",129f,false,false,Dateutil.convertToDate("23/12/2017"));
		al.add(e1);
		MenuItem e2 = new MenuItem(3,"Pizza","Main Course",149f,true,false,Dateutil.convertToDate("21/08/2018"));
		al.add(e2);
		MenuItem e3 = new MenuItem(4,"French Fries","Startes",57f,false,true,Dateutil.convertToDate("02/07/2017"));
		al.add(e3);
		MenuItem e4 = new MenuItem(5,"Chocolate Brownie","Deserts",32f,true,true,Dateutil.convertToDate("02/11/2022"));
		al.add(e4);
		menuItemList=al;
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

public ArrayList<MenuItem> getMenuItemListCustomer()  {
	ArrayList<MenuItem> m= new ArrayList<MenuItem>();
	
	
	Dateutil d=new Dateutil();
	Dateutil du=new Dateutil();
		for(MenuItem x:menuItemList)
			{
				if(x.getActive()==true && (x.getDateOflaunch().before(d.convertToDate("19/08/2019"))))
				{
					m.add(x);
				}
			}
			   
	return m;
}
public void modifyMenuItem(MenuItem menuItem) {
ArrayList<MenuItem> m=new ArrayList<MenuItem>();

	for(MenuItem x:menuItemList)
	{
		if(x.getId()==(menuItem.getId()))
		{
			x.setId(menuItem.getId());
			x.setName(menuItem.getName());
			x.setCategory(menuItem.getCategory());
			x.setPrice(menuItem.getPrice());
			x.setActive(menuItem.getActive());
			x.setDateOflaunch(menuItem.getDateOflaunch());
		}
	}

}
@Override
public MenuItem getMenuItem(long menuItemId) {
	MenuItem x1 = null;
	for(MenuItem x:menuItemList)
	{
		if(x.getId()==menuItemId)
		{
			x1=x;
			break;
		}
	}
	return x1;
}

@Override
public ArrayList<MenuItem> getMenuItemListAdmin() {
	
	return menuItemList;
}


}