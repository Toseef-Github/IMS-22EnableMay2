package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

	/**
	 * Takes in item details for CRUD functionality
	 *
	 */
	public class OrderItemsController implements CrudController<OrderItems> {

		public static final Logger LOGGER = LogManager.getLogger();

		private OrderItemsDAO orderItemsDAO;
		private Utils utils;

		public OrderItemsController(OrderItemsDAO orderItemsDAO, Utils utils) {
			super();
			this.orderItemsDAO = orderItemsDAO;
			this.utils = utils;
		}

		/**
		 * Reads all order items to the logger
		 */
		@Override
		public List<OrderItems> readAll() {
			List<OrderItems> items = orderItemsDAO.readAll();
			for (OrderItems item : items) {
				LOGGER.info(item);
			}
			return items;
		}

		/**
		 * Creates an order item by taking in user input
		 */
		@Override
		public OrderItems create() {
			LOGGER.info("Please enter the quantity of your item(s)");
			Long item_Quantity = utils.getLong();
			LOGGER.info("Please enter the order id");
			Long fk_Order_Id = utils.getLong();
			LOGGER.info("Please enter the item id");
			Long fk_Item_Id = utils.getLong();
			OrderItems item = orderItemsDAO.create(new OrderItems(item_Quantity, fk_Order_Id, fk_Item_Id));
			LOGGER.info("Order item created");
			return item;
		}

		/**
		 * not functional for this table
		 */
		@Override
		public OrderItems update() {

			LOGGER.info("Cannot Be Updated!");
			return null;
		}

		/**
		 * Deletes an existing order item by the id of the item
		 * 
		 * @return
		 */
		@Override
		public int delete() {
			LOGGER.info("Please enter the id of the order item you would like to delete");
			Long id = utils.getLong();
			return orderItemsDAO.delete(id);
		}

}

