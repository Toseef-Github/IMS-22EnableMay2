INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`items` (item_name, price) VALUES ('car', '5000');
INSERT INTO `ims`.`orders` (fk_id) VALUES ('1');
INSERT INTO `ims`.`order_items` (item_quantity, fk_order_id, fk_item_id) VALUES ('2', '1', '1');