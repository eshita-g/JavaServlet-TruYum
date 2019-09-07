package com.cognizant.truyum.dao;
import com.cognizant.truyum.model.*;

import java.util.ArrayList;
import java.util.List;

public interface MenuItemDao {
public ArrayList<MenuItem> getMenuItemListCustomer();
public ArrayList<MenuItem> getMenuItemListAdmin();
public void modifyMenuItem(MenuItem menuItem);
public MenuItem getMenuItem(long menuItemId);
}