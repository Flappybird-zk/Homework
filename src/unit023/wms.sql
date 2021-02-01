

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL COMMENT '学号',
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `gender` char(1) NOT NULL DEFAULT '1' COMMENT '0女，1男',
  `birthday` date NOT NULL COMMENT '出生日期',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `latest_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

LOCK TABLES `student` WRITE;

INSERT INTO `student` (`id`, `username`, `gender`, `birthday`, `created_time`, `latest_time`)
VALUES
	(1,'lisi','1','1992-12-27','2021-02-01 09:48:35','2021-02-01 09:48:35'),
	(2,'lisi','1','1995-12-22','2021-02-01 09:59:08','2021-02-01 09:59:08');

UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL COMMENT '用户ID',
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(6) NOT NULL DEFAULT '' COMMENT '密码',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `latest_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理用户表';

LOCK TABLES `user` WRITE;

INSERT INTO `user` (`id`, `username`, `password`, `created_time`, `latest_time`)
VALUES
	(1,'zhangsan','123456','2021-02-01 09:42:05','2021-02-01 09:42:10');

UNLOCK TABLES;

