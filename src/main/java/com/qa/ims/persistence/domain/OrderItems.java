package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {
	
	private Long order_Item_Id;
	private Long item_Quantity;
	private Long fk_Order_Id;
	private Long fk_Item_Id;

	public OrderItems(Long item_Quantity, Long fk_Order_Id, Long fk_Item_Id) {
		this.item_Quantity = item_Quantity;
		this.fk_Order_Id = fk_Order_Id;
		this.fk_Item_Id = fk_Item_Id;
	}
	
	public OrderItems(Long order_Item_Id, Long item_Quantity, Long fk_Order_Id, Long fk_Item_Id) {
		this.item_Quantity = item_Quantity;
		this.fk_Order_Id = fk_Order_Id;
		this.fk_Item_Id = fk_Item_Id;
		this.order_Item_Id = order_Item_Id;
	}

	public Long getOrder_Item_Id() {
		return order_Item_Id;
	}

	public void setOrder_Item_Id(Long order_Item_Id) {
		this.order_Item_Id = order_Item_Id;
	}

	public Long getItem_Quantity() {
		return item_Quantity;
	}

	public void setItem_Quantity(Long item_Quantity) {
		this.item_Quantity = item_Quantity;
	}

	public Long getFk_Order_Id() {
		return fk_Order_Id;
	}

	public void setFk_Order_Id(Long fk_Order_Id) {
		this.fk_Order_Id = fk_Order_Id;
	}

	public Long getFk_Item_Id() {
		return fk_Item_Id;
	}

	public void setFk_Item_Id(Long fk_Item_Id) {
		this.fk_Item_Id = fk_Item_Id;
	}

	@Override
	public String toString() {
		return "OrderItems order_Item_Id= " + order_Item_Id + ", item_Quantity= " + item_Quantity + ", fk_Order_Id= "
				+ fk_Order_Id + ", fk_Item_Id= " + fk_Item_Id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_Item_Id, fk_Order_Id, item_Quantity, order_Item_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(fk_Item_Id, other.fk_Item_Id) && Objects.equals(fk_Order_Id, other.fk_Order_Id)
				&& Objects.equals(item_Quantity, other.item_Quantity)
				&& Objects.equals(order_Item_Id, other.order_Item_Id);
	}

	

}
