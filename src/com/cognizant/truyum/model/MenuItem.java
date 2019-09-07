package com.cognizant.truyum.model;
import java.text.SimpleDateFormat;
import java.util.*;


import com.cognizant.truyum.util.Dateutil;
@SuppressWarnings("unused")
public class MenuItem {
	
	private long id;
	private String name,category;
	private float price;
	private boolean active;
	private boolean freeDelivery;
	private Date dateOflaunch;
	
	
	public MenuItem(long id, String name, String category, float price, boolean active, boolean freeDelivery,
			Date dateOflaunch) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.active = active;
		this.freeDelivery = freeDelivery;
		this.dateOflaunch=dateOflaunch;
	}

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean acitve) {
		this.active = active;
	}
	public boolean getFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public Date getDateOflaunch() {
		return this.dateOflaunch;
	}
	public void setDateOflaunch(Date dateOflaunch) {
		this.dateOflaunch = dateOflaunch;
	}
	boolean equals(MenuItem m)
	{
		if(m.id==this.id)
			return true;
		else
			return false;
	}
	@Override
	public String toString() {
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
		return String.format("%-25s$%-25s%-25s%-25s%-25s%-20s\n",getName(),getPrice(),getActive(),simple.format(getDateOflaunch()),getCategory(),getFreeDelivery());
	}

	

}