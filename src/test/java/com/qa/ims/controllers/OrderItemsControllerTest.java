package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemsControllerTest {
	

	@Mock
	private Utils utils;

	@Mock
	private OrderItemsDAO dao;

	@InjectMocks
	private OrderItemsController controller;

	@Test
	public void testCreate() {
		final Long itemQuantity = 2L;
		final Long fk_Order_Id = 1L;
		final Long fk_Item_Id = 1L;
		final OrderItems created = new OrderItems(itemQuantity, fk_Order_Id, fk_Item_Id);

		Mockito.when(utils.getLong()).thenReturn(itemQuantity);
		Mockito.when(utils.getLong()).thenReturn(fk_Order_Id);
		Mockito.when(utils.getLong()).thenReturn(fk_Item_Id);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderItems> OrderItems = new ArrayList<>();
		OrderItems.add(new OrderItems(2L, 1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(OrderItems);

		assertEquals(OrderItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItems updated = new OrderItems(1L, 2L, 1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getItem_Quantity());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getFk_Order_Id());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getFk_Item_Id());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
