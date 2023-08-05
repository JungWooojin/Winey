CREATE TABLE `t_region_nm` (
   `region_nm_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   `region_nm`	VARCHAR(15) UNIQUE NOT NULL
);

CREATE TABLE t_user (
    `user_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `email`	VARCHAR(25) UNIQUE NOT NULL,
    `pw`	VARCHAR(20) NOT NULL,
    `role`	VARCHAR(10) NOT NULL,
    `nm`	VARCHAR(20) NOT NULL,
    `birth`	date NOT NULL,
    `gender` CHAR(2) NOT NULL CHECK (gender IN (0,1)),
    `tel` VARCHAR(11) NOT NULL,
    `login_token` varchar(255),
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME,
    `region_nm_id` BIGINT UNSIGNED,
    `tos_yn` int NOT NULL CHECK (tos_yn IN (0,1)),
    `del_yn` int NOT NULL CHECK (del_yn IN (0,1)),
    FOREIGN KEY (region_nm_id) REFERENCES t_region_nm (region_nm_id)
);

CREATE TABLE `t_category` (
  `category_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `nm`	VARCHAR(20) UNIQUE NOT NULL,
  `temp`	VARCHAR(10) UNIQUE NULL
);

CREATE TABLE `t_country` (
    `country_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `nm`	VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE `t_feature` (
    `feature_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `sweety`	TINYINT NOT NULL CHECK(`sweety` IN (0,1,2,3,4)),
    `acidity`	TINYINT NOT NULL CHECK(`acidity` IN (0,1,2,3,4)),
    `body`	TINYINT NOT NULL CHECK(`body` IN (0,1,2,3,4))
);

CREATE TABLE `t_aroma` (
   `aroma_id`	BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   `flower`	TINYINT DEFAULT 0 CHECK(`flower` IN (0,1)),
   `plant`	TINYINT DEFAULT 0 CHECK(`plant` IN (0,1)),
   `fruit`	TINYINT DEFAULT 0 CHECK(`fruit` IN (0,1)),
   `spicy`	TINYINT DEFAULT 0 CHECK(`spicy` IN (0,1)),
   `earth`	TINYINT DEFAULT 0 CHECK(`earth` IN (0,1)),
   `oak`	TINYINT DEFAULT 0 CHECK(`oak` IN (0,1)),
   `nuts`	TINYINT DEFAULT 0 CHECK(`nuts` IN (0,1))
);

CREATE TABLE  `t_product` (
    `product_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `category_id` BIGINT UNSIGNED NOT NULL,
    `feature_id` BIGINT UNSIGNED NOT NULL,
    `country_id` BIGINT UNSIGNED NOT NULL,
    `aroma_id` BIGINT UNSIGNED NOT NULL,
    `nm_kor` VARCHAR(100) NOT NULL,
    `nm_eng` VARCHAR(100) NOT NULL,
    `price` BIGINT NOT NULL,
    `pic` VARCHAR(100),
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME,
    `promotion` INT CHECK(promotion IN(0,1)),
    `beginner` INT CHECK(beginner IN(0,1)),
    `alcohol` INT NOT NULL,
    `quantity` int not null default 0,
    FOREIGN KEY (category_id) REFERENCES t_category (category_id),
    FOREIGN KEY (feature_id) REFERENCES t_feature (feature_id),
    FOREIGN KEY (country_id) REFERENCES t_country (country_id),
    FOREIGN KEY (aroma_id) REFERENCES t_aroma (aroma_id)
);
CREATE TABLE `t_sale` (
    `sale_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `product_id` BIGINT UNSIGNED NOT NULL,
    `sale` INT NULL,
    `sale_price` INT NULL,
    `start_sale` DATETIME NULL,
    `end_sale` DATETIME NULL,
    `sale_yn` INT NULL CHECK (sale_yn in (0,1)),
    FOREIGN KEY (product_id) REFERENCES t_product (product_id)
);

CREATE TABLE `t_store` (
    `store_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `region_nm_id`	BIGINT UNSIGNED NOT NULL,
    `nm`	VARCHAR(25) UNIQUE NOT NULL,
    `tel`	VARCHAR(12) NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME,
    FOREIGN KEY (region_nm_id) REFERENCES t_region_nm (region_nm_id)
);


CREATE TABLE `t_big_category` (
    `big_category_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `b_kind` VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY (`big_category_id`)
);

CREATE TABLE `t_small_category` (
    `small_category_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `big_category_id` BIGINT UNSIGNED,
    `s_kind` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`small_category_id`),
    FOREIGN KEY (big_category_id) REFERENCES t_big_category (big_category_id)
);

CREATE TABLE `t_wine_pairing` (
    `product_id` BIGINT UNSIGNED NOT NULL,
    `small_category_id` BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (small_category_id) REFERENCES t_small_category (small_category_id),
    FOREIGN KEY (product_id) REFERENCES t_product (product_id)
);

CREATE TABLE `t_order`(
    `order_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `store_id` bigint unsigned not null,
    `total_order_price` BIGINT UNSIGNED NOT NULL,
    `order_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `payment` INT NOT NULL,
    `pickup_time` DATETIME,
    `order_status` INT CHECK(order_status IN(0,1,2,3,4,5,6)),
    FOREIGN KEY (`user_id`) REFERENCES`t_user` (`user_id`),
    FOREIGN KEY (`store_id`) REFERENCES`t_store` (`store_id`),
    PRIMARY KEY (`order_id`)
);

CREATE TABLE t_order_detail (
    order_detail_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT UNSIGNED NOT NULL,
    product_id BIGINT UNSIGNED NOT NULL,
    quantity INT NOT NULL,
    sale_price BIGINT NOT NULL,
    FOREIGN KEY (`order_id`) REFERENCES`t_order`(`order_id`),
    FOREIGN KEY (`product_id`) REFERENCES`t_product`(`product_id`)
);


CREATE TABLE `t_order_refund`(
     `refund_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
     `order_id` BIGINT UNSIGNED NOT NULL,
     `refund_reason` VARCHAR(50) NULL,
     `refund_yn` INT NOT NULL CHECK (refund_yn IN (0,1)),
     `refund_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (`refund_id`),
     FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
);

CREATE TABLE `t_cart`(
    `cart_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `product_id` BIGINT UNSIGNED NOT NULL,
    `quantity` BIGINT UNSIGNED,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NULL ,
    FOREIGN KEY (user_id) REFERENCES t_user (user_id),
    FOREIGN KEY (product_id) REFERENCES t_product (product_id)
);

CREATE TABLE `t_review` (
    `review_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `order_detail_id` BIGINT UNSIGNED NOT NULL,
    `review_level` TINYINT NOT NULL,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME,
    FOREIGN KEY (order_detail_id) REFERENCES t_order_detail (order_detail_id)
);
