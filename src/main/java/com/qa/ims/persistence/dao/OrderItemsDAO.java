package com.qa.ims.persistence.dao;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;


public class OrderItemsDAO implements Dao<OrderItems> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
	Long order_Item_Id = resultSet.getLong("order_Item_Id");
	Long item_Quantity = resultSet.getLong("item_Quantity");
	Long fk_Order_Id = resultSet.getLong("fk_Order_Id");
	Long fk_Item_Id = resultSet.getLong("fk_Item_Id");
	return new OrderItems(order_Item_Id, item_Quantity, fk_Order_Id, fk_Item_Id);
	}

	/**
	* Reads all order items from the database
	*/
	@Override
	public List<OrderItems> readAll() {
	try (Connection connection = DBUtils.getInstance().getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("SELECT * FROM order_Items");) {
	List<OrderItems> orderItems = new ArrayList<>();
	while (resultSet.next()) {
	orderItems.add(modelFromResultSet(resultSet));
	}
	return orderItems;
	} catch (SQLException e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return new ArrayList<>();
	}

	public OrderItems readLatest() {
	try (Connection connection = DBUtils.getInstance().getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("SELECT * FROM order_Items ORDER BY order_Item_Id DESC LIMIT 1");) {
	resultSet.next();
	return modelFromResultSet(resultSet);
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	/**
	* Creates an order items in the database
	*/
	@Override
	public OrderItems create(OrderItems orderItems) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("INSERT INTO order_Items(item_Quantity, fk_Order_Id, fk_Item_Id) VALUE (?, ?, ?)");) {
	statement.setLong(1, orderItems.getItem_Quantity());
	statement.setLong(2, orderItems.getFk_Order_Id());
	statement.setLong(3, orderItems.getFk_Item_Id());
	statement.executeUpdate();
	return readLatest();
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	@Override
	public OrderItems read(Long order_Items_Id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_Items WHERE order_Items_Id = ?");) {
	statement.setLong(1, order_Items_Id);
	try (ResultSet resultSet = statement.executeQuery();) {
	resultSet.next();
	return modelFromResultSet(resultSet);
	}
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	/**
	* Updates an order items in the database
	*/
	@Override
	public OrderItems update(OrderItems orderItems) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection
	.prepareStatement("UPDATE order_Items SET item_Quantity = ?, fk_Order_Id = ?, fk_Item_Id = ? WHERE order_Items_Id = ?");) {
	statement.setLong(1, orderItems.getItem_Quantity());
	statement.setLong(2, orderItems.getFk_Order_Id());
	statement.setLong(3, orderItems.getFk_Item_Id());
	statement.executeUpdate();
	return read(orderItems.getOrder_Item_Id());
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	/**
	* Deletes an order items in the database
	*/
	@Override
	public int delete(long order_Items_Id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("DELETE FROM order_Items WHERE order_Item_Id = ?");) {
	statement.setLong(1, order_Items_Id);
	int ret = statement.executeUpdate();
	LOGGER.debug("Successfully Deleted");
	return ret;
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return 0;
	}
	}

	