-- 1.部门表
CREATE TABLE `tb_dept` (
`dept_id` int(11) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '部门号',
`dept_name` varchar(32) NOT NULL DEFAULT '' COMMENT '部门名称',
`major_name` varchar(32) DEFAULT NULL COMMENT '部门主管',
`telephone` varchar(16) DEFAULT NULL COMMENT '电话',
`email` varchar(32) DEFAULT NULL COMMENT '邮箱'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';


-- 2.员工表
CREATE TABLE `tb_employee` (
`emp_id` int(11) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '员工号',
`emp_name` varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
`dept_id` int(11) unsigned NOT NULL COMMENT '部门号',
`job_name` varchar(32) DEFAULT NULL COMMENT '职位id',
`join_date` date DEFAULT NULL COMMENT '入职时间',
`telephone` varchar(16) DEFAULT NULL COMMENT '联系方式'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';