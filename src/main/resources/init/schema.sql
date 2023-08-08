DROP TABLE IF EXISTS `t_product`;

CREATE TABLE  `t_product` (
      `product_id` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
      `category_id` BIGINT UNSIGNED NOT NULL,
      `feature_id` BIGINT UNSIGNED NOT NULL,
      `country_id` BIGINT UNSIGNED NOT NULL,
      `aroma_id` BIGINT UNSIGNED NOT NULL,
      `nm_kor` VARCHAR(100) NOT NULL,
      `nm_eng` VARCHAR(100) NOT NULL,
      `price` BIGINT NOT NULL,
      `quantity` BIGINT NOT NULL,
      `pic` VARCHAR(100),
      `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `updated_at` DATETIME,
      `promotion` INT NOT NULL CHECK(promotion IN(0,1)),
      `beginner` INT NOT NULL CHECK(beginner IN(0,1)),
      `alcohol` INT NOT NULL,
      FOREIGN KEY (category_id) REFERENCES t_category (category_id),
      FOREIGN KEY (feature_id) REFERENCES t_feature (feature_id),
      FOREIGN KEY (country_id) REFERENCES t_country (country_id),
      FOREIGN KEY (aroma_id) REFERENCES t_aroma (aroma_id)
);