DROP TABLE IF EXISTS `filemodes`;
CREATE TABLE `filemodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `pid` int(11) NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  `file_size` int(20) NOT NULL,
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_dir` int(1) NOT NULL DEFAULT '0',
  `is_public` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `regis_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
