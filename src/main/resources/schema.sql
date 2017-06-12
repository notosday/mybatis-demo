DROP TABLE IF EXISTS `city2`;

CREATE TABLE `city2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_id` bigint(20) DEFAULT NULL,
  `city_name` varchar(128) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8