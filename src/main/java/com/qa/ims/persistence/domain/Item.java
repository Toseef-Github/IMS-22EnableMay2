package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private long itemId;
	private String itemName;
	private double price;
	
	public Item(String itemName, double price) {
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public Item(Long itemId, String itemName, double price) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "itemId= " + itemId + ", itemName= " + itemName + ", price= " + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId && Objects.equals(itemName, other.itemName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	

}
