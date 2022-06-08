package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long order_Id;
	private Long fk_Id;

	public Order(Long fk_Id) {
		this.setFk_Id(fk_Id);
	}

	public Order(Long order_Id, Long fk_Id) {
		this.setOrder_Id(order_Id);
		this.setFk_Id(fk_Id);
	}

	
	public Long getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(Long order_Id) {
		this.order_Id = order_Id;
	}

	public Long getFk_Id() {
		return fk_Id;
	}

	public void setFk_Id(Long fk_Id) {
		this.fk_Id = fk_Id;
	}

	

	@Override
	public String toString() {
		return "Order order_Id= " + order_Id + ", fk_Id= " + fk_Id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_Id, order_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(fk_Id, other.fk_Id) && Objects.equals(order_Id, other.order_Id);
	}

	

}
