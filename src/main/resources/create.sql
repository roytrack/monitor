CREATE TABLE `theuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL ,
  `password` varchar(100) NOT NULL ,
  `luru` datetime NOT NULL ,
  status INT NOT NULL,
  shenfenxinxi VARCHAR(3000),
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8;


CREATE TABLE `process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL ,
  `bookName` varchar(100) NOT NULL ,
  `bookId` varchar(100) NOT NULL ,
  total INT,
  consume INT,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   DEFAULT CHARSET=utf8

