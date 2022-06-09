DROP TABLE IF EXISTS `order_items`;

DROP TABLE IF EXISTS `orders`;

DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    item_id INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
	item_name VARCHAR(40) DEFAULT NULL,
    price DEC(11,2) DEFAULT NULL,
    PRIMARY KEY (item_id)
);

CREATE TABLE IF NOT EXISTS `orders` (
	order_id INT(11) NOT NULL AUTO_INCREMENT,
    fk_id INT(11) NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (fk_id) REFERENCES customers(`id`)
    
);

CREATE TABLE IF NOT EXISTS `order_items` (
	order_item_id INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
    item_quantity INT DEFAULT 1,
    fk_order_id INT(11) NOT NULL,
    fk_item_id INT(11) NOT NULL,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
    FOREIGN KEY (fk_item_id) REFERENCES items(item_id)
    );