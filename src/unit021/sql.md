## 作业一
###SQL

<pre>
use lagou;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
`pid` int(11) DEFAULT NULL COMMENT '商品ID',
`pname` varchar(20) DEFAULT NULL COMMENT '商品名称',
`price` double DEFAULT NULL COMMENT '商品价格',
`category_name` varchar(32) DEFAULT NULL COMMENT '商品分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

LOCK TABLES `product` WRITE;
INSERT INTO `product` (`pid`, `pname`, `price`, `category_name`)
VALUES
(1,'联想电脑',5000,'电脑办公'),
(2,'海尔电脑',3000,'电脑办公'),
(3,'雷神电脑',5000,'电脑办公'),
(4,'JACK JONES',800,'服装'),
(5,'真维斯',200,'服装'),
(6,'花花公子',440,'服装'),
(7,'劲霸',2000,'服装'),
(8,'香奈儿',800,'女士用品'),
(9,'相宜本草',200,'女士用品'),
(10,'面霸',5,'女士用品'),
(11,'雪碧',56,'饮料饮品'),
(12,'香飘飘奶茶',1,'饮料饮品'),
(13,'iPhone9',8000,NULL);
UNLOCK TABLES;
</pre>

### 查询练习
#### 1.查询所有的商品
<pre>
SELECT *
  FROM `product`;
</pre>
#### 2.查询商品名和商品价格
<pre>
SELECT `pname`, `price`
  FROM `product`;
</pre>
#### 3.别名查询.使用的关键字是as（as可以省略的）.
<pre>
SELECT `pname` `商品名称`, `price` `商品价格`
  FROM `product`;
</pre>
#### 4.查询商品价格，对价格去除重复；
<pre>
SELECT DISTINCT `price`
  FROM `product`;
</pre>
#### 5.查询结果是表达式（运算查询）：将所有商品的价格+10元进行显示.
<pre>
SELECT `pid`, `pname`, `price` + 10 `price`, `category_name`
  FROM `product`;
</pre>
#### 6.查询商品名称为“花花公子”的商品所有信息：
<pre>
SELECT *
  FROM `product`
 WHERE `pname` = '花花公子';
</pre>
#### 7.查询价格为800商品
<pre>
SELECT *
  FROM `product`
 WHERE `price` = 800;
</pre>
#### 8.查询价格不是800的所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `price` != 800;
</pre>
#### 9.查询商品价格大于60元的所有商品信息
<pre>
SELECT *
  FROM `product`
 WHERE `price` > 60;
</pre>
#### 10.查询商品价格在200到1000之间所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `price` > 200
   AND `price` < 1000;
</pre>
#### 11.查询商品价格是200或800的所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `price` = 200
    OR `price` = 800;
</pre>
#### 12.查询含有'霸'字的所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `pname` LIKE '%霸%';
</pre>
#### 13.查询以'香'开头的所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `pname` LIKE '香%';
</pre>
#### 14.查询第二个字为'想'的所有商品
<pre>
SELECT *
  FROM `product`
 WHERE `pname` LIKE '_想%';
</pre>
#### 15.商品没有分类的商品
<pre>
SELECT *
  FROM `product`
 WHERE `category_name` IS NULL;
</pre>
#### 16.查询有分类的商品
<pre>
SELECT *
  FROM `product`
 WHERE `category_name` IS NOT NULL;
</pre>


### 排序练习
#### 1.使用价格对商品信息排序(降序)
-- 提示：使用order by语句
<pre>
SELECT *
  FROM `product`
 ORDER BY `price` DESC;
</pre>
#### 2.在价格排序(降序)的基础上，以主键排序(降序)
-- 提示：若价格相同，相同价格的数据以pid降序排序
<pre>
SELECT *
  FROM `product`
 ORDER BY `price` DESC, `pid` DESC;
</pre>
#### 3.显示商品的价格(去重复)，并排序(降序)
-- 提示：DISTINCT 关键字去重 
<pre>
SELECT DISTINCT `price`
  FROM `product`
 ORDER BY `price` DESC;
</pre>


### 聚合函数/分组函数练习：
#### 1 查询商品的总条数(两种方式)
-- 提示：使用count()
<pre>
SELECT COUNT(*) `总条数`
  FROM `product`;
</pre>
<pre>
SELECT COUNT(1) `总条数`
  FROM `product`;
</pre>
#### 2 查看price商品的总价格
-- 提示：使用sum();
<pre>
SELECT SUM(`price`) `总价格`
  FROM `product`;
</pre>
#### 3 查看price的最大值和最小值
-- 提示：使用max()  min()
<pre>
SELECT MAX(`price`) `price最大值`, MIN(`price`) `price最小值`
  FROM `product`;
</pre>
#### 4 查看price的平均值
-- 提示：使用 AVG() 
<pre>
SELECT AVG(`price`) `price平均值`
  FROM `product`;
</pre>
#### 5 查询价格大于200商品的总条数
-- 提示：使用 COUNT(*)统计条数
<pre>
SELECT COUNT(*) `总条数`
  FROM `product`
 WHERE `price` > 200;
</pre>


### 分组练习
#### 1 统计各个分类商品的个数
<pre>
SELECT `category_name`, COUNT(*) `num`
  FROM `product`
 GROUP BY `category_name`;
</pre>

#### 2 统计各个分类商品的个数,且只显示个数大于1的信息
<pre>
SELECT `category_name`, COUNT(*) `num`
  FROM `product`
 GROUP BY `category_name`
HAVING `num` > 1;
</pre>


## 作业二

### SQL
<pre>
DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

LOCK TABLES `dept` WRITE;
INSERT INTO `dept` (`id`, `name`)
VALUES
	(1,'开发部'),
	(2,'市场部'),
	(3,'财务部');
UNLOCK TABLES;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `salary` double DEFAULT NULL COMMENT '工资',
  `join_date` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int(11) DEFAULT NULL COMMENT '外键，关联部门表(部门表的主键)',
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';

LOCK TABLES `employee` WRITE;
INSERT INTO `employee` (`id`, `name`, `gender`, `salary`, `join_date`, `dept_id`)
VALUES
	(1,'孙悟空','男',7200,'2013-02-24',1),
	(2,'猪八戒','男',3600,'2010-12-02',2),
	(3,'唐僧','男',9000,'2008-08-08',2),
	(4,'白骨精','女',5000,'2015-10-07',3),
	(5,'蜘蛛精','女',4500,'2011-03-14',1);
UNLOCK TABLES;
</pre>

### 查询功能

#### 1 查询工资最高的员工是谁？
<pre>
SELECT *
  FROM `employee`
 WHERE `salary` =
       (SELECT MAX(`salary`)
          FROM `employee`);
</pre>
#### 2 查询工资小于平均工资的员工有哪些？
<pre>
SELECT *
  FROM `employee`
 WHERE `salary` <
       (SELECT AVG(`salary`)
          FROM `employee`);
</pre>
#### 3 查询工资大于5000的员工，来至于哪些部门，输出部门的名字
<pre>
SELECT `name` `部门名称`
  FROM `dept`
       INNER JOIN (SELECT DISTINCT(`dept_id`) `dept_id`
                     FROM `employee`
                    WHERE `salary` > 5000) `ee`
       ON `dept`.`id`=`ee`.`dept_id`;
</pre>
#### 4 查询开发部与财务部所有的员工信息，分别使用子查询和表连接实现
<pre>
SELECT `ee`.*
  FROM `employee` `ee`
 WHERE `dept_id` IN
       (SELECT DISTINCT(`id`) `id`
          FROM `dept`
         WHERE `name` = '开发部'
            OR `name` = '财务部');
</pre>
<pre>
SELECT `ee`.*
  FROM `employee` `ee`
       INNER JOIN `dept`
       ON `ee`.`dept_id` = `dept`.`id`
 WHERE `dept`.`name` = '开发部'
    OR `dept`.`name` = '财务部';
</pre>

#### 5 查询2011年以来入职的员工信息和部门信息，分别使用子查询和表连接实现
<pre>
SELECT `ee`.*, `de`.`name` `dept_name`
  FROM (SELECT *
          FROM `employee`
         WHERE `join_date` > '2011') `ee`
       LEFT JOIN `dept` `de`
       ON `ee`.`dept_id` = `de`.`id`;
</pre>
<pre>
SELECT `ee`.*, `dept`.`name` `dept_name`
  FROM `employee` `ee`
       LEFT JOIN `dept`
       ON `ee`.`dept_id` = `dept`.`id`
 WHERE `ee`.`join_date` > '2011';
</pre>


## 作业三

### SQL
<pre>
DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '课程名',
  `teacher_id` int(11) DEFAULT NULL COMMENT '外键 对应老师表 主键id',
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `course` WRITE;

INSERT INTO `course` (`id`, `name`, `teacher_id`)
VALUES
	(1,'语文',1),
	(2,'数学',1),
	(3,'生物',2),
	(4,'化学',2),
	(5,'物理',2),
	(6,'英语',3);
UNLOCK TABLES;


DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `city` varchar(10) DEFAULT NULL COMMENT '城市',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

LOCK TABLES `student` WRITE;

INSERT INTO `student` (`id`, `name`, `city`, `age`)
VALUES
	(1,'小王','北京',20),
	(2,'小李','上海',18),
	(3,'小周','北京',22),
	(4,'小刘','北京',21),
	(5,'小张','上海',22),
	(6,'小赵','北京',17),
	(7,'小蒋','上海',23),
	(8,'小韩','北京',25),
	(9,'小魏','上海',25),
	(10,'小明','北京',20);
UNLOCK TABLES;

DROP TABLE IF EXISTS `student_course`;

CREATE TABLE `student_course` (
  `student_id` int(11) DEFAULT NULL COMMENT '外键 对应学生表主键',
  `course_id` int(11) DEFAULT NULL COMMENT '外键 对应课程表主键',
  `score` int(11) DEFAULT NULL COMMENT '某学员 某科的 考试分数',
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生与课程中间表';

LOCK TABLES `student_course` WRITE;

INSERT INTO `student_course` (`student_id`, `course_id`, `score`)
VALUES
	(1,1,80),
	(1,2,90),
	(1,3,85),
	(1,4,78),
	(2,2,53),
	(2,3,77),
	(2,5,80),
	(3,1,71),
	(3,2,70),
	(3,4,80),
	(3,5,65),
	(3,6,75),
	(4,2,90),
	(4,3,80),
	(4,4,70),
	(4,6,95),
	(5,1,60),
	(5,2,70),
	(5,5,80),
	(5,6,69),
	(6,1,76),
	(6,2,88),
	(6,3,87),
	(7,4,80),
	(8,2,71),
	(8,3,58),
	(8,5,68),
	(9,2,88),
	(10,1,77),
	(10,2,76),
	(10,3,80),
	(10,4,85),
	(10,5,83);
UNLOCK TABLES;

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师表';

LOCK TABLES `teacher` WRITE;

INSERT INTO `teacher` (`id`, `name`)
VALUES
	(1,'关羽'),
	(2,'张飞'),
	(3,'赵云');
UNLOCK TABLES;
</pre>

#### 第一题
-- 1、查询平均成绩大于70分的同学的学号,姓名,和平均成绩  
-- 1.1 分组查询每个学生的 学号,姓名,平均分  
-- 1.2 增加条件：平均成绩大于70
<pre>
SELECT `stu`.`id`, `stu`.`name`,
       AVG(`sc`.`score`) `score_avg`
  FROM `student` `stu`
       LEFT JOIN `student_course` `sc`
       ON `stu`.`id` = `sc`.`student_id`
 GROUP BY `stu`.`id`
HAVING `score_avg` > 70;
</pre>

#### 第二题
-- 2. 查询所有同学的学号、姓名、选课数、总成绩  
-- 2.1 需要查询两张表 student表和 student_course表  
-- 2.2 需要使用 student_id 学号字段,进行分组  
-- 2.3 需要使用到 count函数 sum函数  
<pre>
SELECT `stu`.`id`, `stu`.`name`,
       COUNT(`sc`.`course_id`) `选课数`, SUM(`sc`.`score`) `总成绩`
  FROM `student` `stu`
       LEFT JOIN `student_course` `sc`
       ON `stu`.`id` = `sc`.`student_id`
 GROUP BY `stu`.`id`;
</pre>

#### 第三题
-- 3. 查询学过赵云老师课程的同学的学号、姓名  
-- 3.1 查询赵云老师的id  
-- 3.2 根据老师ID,在课程表中查询所教的课程编号  
-- 3.3 将上面的子查询作为 where 后面的条件  
<pre>
SELECT `stu`.`id`, `stu`.`name`
  FROM `student_course` `sc`
       LEFT JOIN `student` `stu`
       ON `sc`.`student_id` = `stu`.`id`
 WHERE `sc`.`course_id` IN
       (SELECT `id`
          FROM `course`
         WHERE `teacher_id` =
               (SELECT `id`
                  FROM `teacher`
                 WHERE `name` = '赵云'));
</pre>

#### 第四题
-- 4. 查询选课 少于三门学科的学员  
-- 4.1 查询每个学生学了几门课 条件1：小于等于三门  
-- 4.2 查询 学号和姓名， 将4.1 作为临时表  
<pre>
SELECT `id`, `name`
  FROM `student`
 WHERE `id` IN
       (SELECT `student_id`
          FROM `student_course`
         GROUP BY `student_id`
        HAVING count(*) <= 3);
</pre>


## 作业四

### 数据库表设计
以下是我们拉钩教育平台数据库中的某几张表,为了降低难度,已经简化的表中字段  

请同学们看图分析出三张表之间的关系  

请设计三张表，要求如下:  

讲师表  
   讲师ID 主键 int类型  
   讲师姓名 VARCHAR类型  
   讲师简介 VARCHAR类型  
   讲师级别 char类型 高级讲师&首席讲师  
   为讲师姓名添加索引  

课程分类表  
课程分类ID 主键 int类型  
课程分类名称 VARCHAR类型 比如前端开发 后端开发 数据库DBA......  
课程分类描述 VARCHAR类型  
创建时间 datatime类型  
更新时间 datatime类型  

课程表  
课程ID 主键 int类型  
课程讲师ID 外键 用于描述课程的授课老师  
课程分类ID 外键 用于描述课程所属的分类 比如 Java课程就属于后端分类  
课程标题 VARCHAR类型 比如Java VUE PHP ......  
总课时 int类型  
浏览数量 bigint类型  
课程状态 char 类型,  0 未发布(默认)  1 已发布  
为 课程标题字段添加索引  
为 teacher_id & subject_id,添加外键约束  

#### SQL
<pre>
# lagou_teacher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lagou_teacher`;

CREATE TABLE `lagou_teacher` (
  `id` int(11) NOT NULL COMMENT '讲师ID',
  `tname` varchar(255) DEFAULT '' COMMENT '讲师姓名',
  `introduction` varchar(255) DEFAULT NULL COMMENT '讲师简介',
  `level` char(4) DEFAULT NULL COMMENT '讲师级别',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`tname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='讲师表';

LOCK TABLES `lagou_teacher` WRITE;
INSERT INTO `lagou_teacher` (`id`, `tname`, `introduction`, `level`)
VALUES
	(1,'刘德华','毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱','高级讲师'),
	(2,'郭富城','毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富','首席讲师');
UNLOCK TABLES;


# lagou_subject
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lagou_subject`;

CREATE TABLE `lagou_subject` (
  `id` int(11) NOT NULL COMMENT '课程分类ID',
  `sname` varchar(255) DEFAULT NULL COMMENT '课程分类名称',
  `introduction` varchar(255) DEFAULT NULL COMMENT '课程分类描述',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程分类表';

LOCK TABLES `lagou_subject` WRITE;
INSERT INTO `lagou_subject` (`id`, `sname`, `introduction`, `created_time`, `updated_time`)
VALUES
	(1,'后端开发','后端课程包括 Java PHP Python','2020-03-27 00:44:04','2020-03-27 00:44:04'),
	(2,'前端开发','前端课程包括 JQuery VUE angularJS','2020-02-27 10:00:04','2020-02-27 18:44:04');
UNLOCK TABLES;


# lagou_course
# ------------------------------------------------------------
DROP TABLE IF EXISTS `lagou_course`;

CREATE TABLE `lagou_course` (
  `id` int(11) NOT NULL COMMENT '课程ID',
  `teacher_id` int(11) DEFAULT NULL COMMENT '课程讲师ID 外键 用于描述课程的授课老师',
  `subject_id` int(11) DEFAULT NULL COMMENT '课程分类ID 外键 用于描述课程所属的分类 比如 Java课程就属于后端分类',
  `title` varchar(255) DEFAULT NULL COMMENT '课程标题 比如Java VUE PHP',
  `hours` int(11) DEFAULT NULL COMMENT '总课时',
  `views` bigint(20) DEFAULT NULL COMMENT '浏览数量',
  `status` char(1) DEFAULT NULL COMMENT '课程状态 0 未发布(默认)  1 已发布',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `fk_subject_course` (`subject_id`),
  KEY `fk_teacher_course` (`teacher_id`),
  CONSTRAINT `fk_subject_course` FOREIGN KEY (`subject_id`) REFERENCES `lagou_subject` (`id`),
  CONSTRAINT `fk_teacher_course` FOREIGN KEY (`teacher_id`) REFERENCES `lagou_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

LOCK TABLES `lagou_course` WRITE;
INSERT INTO `lagou_course` (`id`, `teacher_id`, `subject_id`, `title`, `hours`, `views`, `status`)
VALUES
	(1,1,1,'Java',300,250000,'1'),
	(2,2,2,'VUE',400,200000,'1');
UNLOCK TABLES;
</pre>

#### 查询需求
查询刘德华老师所教的课程属于哪个课程分类
<pre>
SELECT `sname` `课程分类`
  FROM `lagou_subject` `lb`
       INNER JOIN (SELECT `subject_id`
                     FROM `lagou_course`
                    WHERE `teacher_id` =
                          (SELECT `id`
                             FROM `lagou_teacher`
                            WHERE `tname` = '刘德华')) AS `lc`
       ON `lb`.`id` = `lc`.`subject_id`;
</pre>