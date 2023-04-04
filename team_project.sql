/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : team_project

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2022-12-04 14:42:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `team_id` int(10) DEFAULT NULL,
  `tel` varchar(200) DEFAULT NULL,
  `images` varchar(200) DEFAULT NULL,
  `ct_info` varchar(2000) DEFAULT NULL,
  `ac_time` datetime DEFAULT NULL,
  `ct_address` varchar(200) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `host` varchar(10) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='社团活动管理';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('2', '足球比赛', '1', '12345678', null, '足球都来了', '2022-09-01 21:25:52', '足球场', '1', '2022-08-08 21:26:16', 'lisi', '1');
INSERT INTO `activity` VALUES ('4', '阅读启蒙', '2', '321321', 'http://localhost:9999//images/f304a663-a571-4cdc-a327-4b45324df934.png', '　　为丰富校园文化内容，给广大社员们一个展示自我的平台，同时也展现学生采风的成果，显现我社在美学与文学方面的成绩，通过学生作品的形式促进各方面的交流。', '2022-08-09 08:00:00', '2132312', '4', '2022-08-08 22:01:30', '321321', '1');
INSERT INTO `activity` VALUES ('5', '今日文学', '2', '321321321', null, '学哥学姐： 是你们亲自接我们入校，又带领我们融入了这个大家庭，三年里你们留下的回忆会继续伴我们成长，希望你们一路走好，创造自己美好的未来', '2022-08-09 20:21:12', '小广场', '4', '2022-08-09 20:21:26', '张三', '1');
INSERT INTO `activity` VALUES ('6', '风采归来', '2', '13212344321', 'http://localhost:9999//images/9bc85d56-4a27-4fa4-b5bf-79f7a3e4461f.png', '　　乐于展示，敢于展示。', '2022-08-31 08:00:00', '多媒体教室', '4', '2022-08-21 11:24:09', '赵晓雪', '0');

-- ----------------------------
-- Table structure for apply_info
-- ----------------------------
DROP TABLE IF EXISTS `apply_info`;
CREATE TABLE `apply_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `number` varchar(40) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `qq` varchar(60) DEFAULT NULL,
  `weixin` varchar(60) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `team_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='社团入团申请记录,申请生成可入团';

-- ----------------------------
-- Records of apply_info
-- ----------------------------
INSERT INTO `apply_info` VALUES ('1', 'lisi', '男', '21321321321', '13443211234', 'lisi@126.com', '西门口', '123213212', '444444', '我想入团', '2022-08-01 20:33:32', '1', '1');
INSERT INTO `apply_info` VALUES ('2', 'wangwu', '女', '132144324443432', '13456789023', 'wangwu@126.com', '北京', '1235432', '132456790', '社团好玩么', '2022-07-14 08:23:50', '1', '2');
INSERT INTO `apply_info` VALUES ('3', 'zhaoliu', '男', '13221213244343243', '12345678909', 'zhaoliu@126.com', '天津', '321323211', '321321332', '我想加入', '2022-07-14 16:03:59', '1', '2');
INSERT INTO `apply_info` VALUES ('7', 'xiaolu', '女', null, '13523456789', '2121@126.com', '', '212121', '212121', '21212121', '2022-08-17 20:50:52', '0', '2');
INSERT INTO `apply_info` VALUES ('8', 'wangxiaoyan', '女', null, '13212345687', '21212121@126.com', '212121', '', '212121', '212121212121', '2022-08-17 21:13:54', '0', '2');
INSERT INTO `apply_info` VALUES ('9', '测试是', '女', null, '13212345678', 'ceshi2@126.com', '212121', '', '212121', '测试吧', '2022-09-25 17:39:16', '0', '6');
INSERT INTO `apply_info` VALUES ('10', 'qq', '女', null, '13512345432', 'qq@126.com', 'zhengxi', '', '1234567890', '测试下', '2022-09-28 15:43:04', '1', '11');
INSERT INTO `apply_info` VALUES ('11', 'ceshisa', '男', null, '13212457656', 'ceshisa@126.com', '飒飒撒', '', '21212212121', '21212122121', '2022-10-28 20:10:34', '0', '7');
INSERT INTO `apply_info` VALUES ('13', 'lining', '男', null, '13212098765', 'lining@126.com', '122121', '', '212121212', '22111111', '2022-10-28 20:25:21', '0', '5');
INSERT INTO `apply_info` VALUES ('14', 'liuhulan', '男', null, '13456789000', 'liuhulan@126.com', 'xian', '', '212122121', '212121212121我要入团', '2022-12-04 12:21:27', '1', '12');
INSERT INTO `apply_info` VALUES ('15', 'liuhulan', '男', null, '13456789000', '13456789000@126.com', '13456789000', '', '13456789000', '134567890002212121', '2022-12-04 12:26:26', '1', '11');

-- ----------------------------
-- Table structure for apply_list
-- ----------------------------
DROP TABLE IF EXISTS `apply_list`;
CREATE TABLE `apply_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` int(10) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `app_time` datetime DEFAULT NULL,
  `app_author` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='审核记录表';

-- ----------------------------
-- Records of apply_list
-- ----------------------------
INSERT INTO `apply_list` VALUES ('1', '2', '不同意啊，你没有技能', '2', '2022-07-13 10:55:13', '1');
INSERT INTO `apply_list` VALUES ('2', '2', '同意吧，看你不容易', '1', '2022-07-14 10:55:41', '1');
INSERT INTO `apply_list` VALUES ('3', '2', '审核建议想写什么写什么', '1', null, '1');
INSERT INTO `apply_list` VALUES ('4', '1', '你加入干什么，别加入了 回家', '2', '2022-07-14 16:02:02', '1');
INSERT INTO `apply_list` VALUES ('5', '3', '我同意拉', '1', '2022-08-02 22:17:19', '1');
INSERT INTO `apply_list` VALUES ('6', '10', 'tongyi', '1', '2022-09-28 15:46:01', '6');
INSERT INTO `apply_list` VALUES ('7', '14', '同意了', '1', '2022-12-04 12:24:10', '9');
INSERT INTO `apply_list` VALUES ('8', '15', 'keyi', '1', '2022-12-04 12:29:11', '6');

-- ----------------------------
-- Table structure for cost_list
-- ----------------------------
DROP TABLE IF EXISTS `cost_list`;
CREATE TABLE `cost_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost_list
-- ----------------------------
INSERT INTO `cost_list` VALUES ('1', '11', '买礼物', '200', '2022-08-09 21:00:18', '给参加猜谜语活动的学生准备礼物');
INSERT INTO `cost_list` VALUES ('2', '11', '测试费用1', '100', '2022-08-09 21:55:53', '测试成功了么1');
INSERT INTO `cost_list` VALUES ('3', '11', '2121', '212121', '2022-08-09 21:59:49', '212121');
INSERT INTO `cost_list` VALUES ('4', '2', '种子书友会', '1000', '2022-08-21 11:28:19', '买书分发');
INSERT INTO `cost_list` VALUES ('5', '2', '阅读启蒙送爱心', '300', '2022-08-21 11:28:44', '发送小奖品');
INSERT INTO `cost_list` VALUES ('6', '2', '测试', '122', '2022-10-28 19:41:36', '221212121');

-- ----------------------------
-- Table structure for leave_info
-- ----------------------------
DROP TABLE IF EXISTS `leave_info`;
CREATE TABLE `leave_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='在线留言管理';

-- ----------------------------
-- Records of leave_info
-- ----------------------------
INSERT INTO `leave_info` VALUES ('13', '13567899876', 'zhangsan@126.com', 'ceshizhang', '一老一幼”系民心，一枝一叶总关情。习近平总书记说“要让老百姓体会到我们党是全心全意为人民服务的', '2022-08-21 09:32:39');
INSERT INTO `leave_info` VALUES ('14', '13212345678', 'xukai@126.com', '徐凯', '毕业时节，相逢又告别，归帆又离岸，既是往日欢乐的终结，又是未来幸福的开端', '2022-08-21 10:46:54');
INSERT INTO `leave_info` VALUES ('15', '13245677654', 'zhaowei@126.com', 'zhaoxiaowei', '别忘了，受伤时给我电话，成功时给我短信，寂寞时找我聊天，难忘社友情', '2022-08-21 10:47:36');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(20) DEFAULT NULL,
  `user_id` varchar(120) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告信息';

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `images` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='社团信息管理';

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '海韵文学社', '1', '2', '7', '2022-07-11 15:28:03', '1', 'http://localhost:9999//images/wenxue.png');
INSERT INTO `team` VALUES ('2', '文渊汉服社', '1', '1', '4', '2022-07-12 21:34:58', '1', 'http://localhost:9999//images/hanfu.png');
INSERT INTO `team` VALUES ('4', '桐源工作室', '1', '2', '8', '2022-07-12 22:41:14', '1', 'http://localhost:9999//images/wenxue.png');
INSERT INTO `team` VALUES ('5', '文艺摄影社', '1', '7', '11', '2022-07-12 22:46:21', '1', 'http://localhost:9999//images/sheying.png');
INSERT INTO `team` VALUES ('6', '天选滑轮社', '1', '10', '10', '2022-07-22 08:00:00', '1', 'http://localhost:9999//images/lunhua.png');
INSERT INTO `team` VALUES ('7', '少林武术社', '1', '9', '1', '2022-07-13 22:46:52', '1', 'http://localhost:9999//images/wushu.png');
INSERT INTO `team` VALUES ('11', '一休动漫社', '1', '8', '9', '2022-07-28 20:56:57', '1', 'http://localhost:9999//images/dongman.png');
INSERT INTO `team` VALUES ('12', '美好时光', '1', '7', '6', '2022-08-31 08:00:00', '1', 'http://localhost:9999//images/5cdf0d1b-4ac7-46a3-9e8e-68226e32a235.png');

-- ----------------------------
-- Table structure for team_user
-- ----------------------------
DROP TABLE IF EXISTS `team_user`;
CREATE TABLE `team_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `realname` varchar(120) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `image` varchar(120) DEFAULT NULL,
  `join_time` datetime DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='社团成员管理';

-- ----------------------------
-- Records of team_user
-- ----------------------------
INSERT INTO `team_user` VALUES ('1', 'zhaoliu', 'zhaoliu', '男', '123456789098', 'zhaoliu@126.com', null, '2022-08-02 22:17:19', '11', '123456');
INSERT INTO `team_user` VALUES ('2', 'lili', 'lili', '女', '13212345678', 'lili@126.com', null, '2022-08-06 21:22:49', '2', '123456');
INSERT INTO `team_user` VALUES ('3', 'zhangsi2', 'zhangsi2', '男', '213321321321321', 'zhangsi@163.com', null, '2022-08-10 21:35:15', '11', '123456');
INSERT INTO `team_user` VALUES ('4', 'qq', 'qq', '女', '13512345432', 'qq@126.com', null, '2022-09-28 15:47:25', '11', '123456');
INSERT INTO `team_user` VALUES ('5', 'liuhulan', 'liuhulan', '男', '13456789000', 'liuhulan@126.com', null, '2022-12-04 12:24:10', '12', '123456');
INSERT INTO `team_user` VALUES ('6', 'liuhulan', 'liuhulan', '男', '13456789000', '13456789000@126.com', null, '2022-12-04 12:29:11', '11', '123456');

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='社团分类和介绍';

-- ----------------------------
-- Records of type_info
-- ----------------------------
INSERT INTO `type_info` VALUES ('1', '汉服社', '从名字当中我们就能看出来，汉服社跟汉服有关。汉服社主要是弘扬跟继承中国传统文化。让大学生通过穿汉服，体验古人的生活方式，了解汉服的起源与发展。');
INSERT INTO `type_info` VALUES ('2', ' 文学社', '      文学社是文化气息非常浓厚的社团，爱好文学、喜欢咬文嚼字的学生，一定要参加文学社。在文学社当中，我们不仅可以结交喜爱文学的同学，还能提高自己的文化素养');
INSERT INTO `type_info` VALUES ('7', '摄影社', '摄影社是爱好摄影同学的集结地。对于喜欢摄影，喜欢拍照的学生，一定要参加学校的摄影社。但是摄影社的同学一般每人一部相机，一部好的相机价值不菲，同学们要做好经济之间的平衡');
INSERT INTO `type_info` VALUES ('8', '动漫社', '动漫社是一个好玩又有趣的社团。动漫社会不定期地举办一些cosplay活动。通过角色扮演，大学生可以感受动漫人物的快乐');
INSERT INTO `type_info` VALUES ('9', '武术社', '武术社是大学当中比较吃香的社团。每个学校几乎都有武术社，对于喜欢武术的学生，可以参加学校的武术社。这样不仅可以学习武术，还能强身健体');
INSERT INTO `type_info` VALUES ('10', ' 轮滑社', '轮滑社是大学当中比较拉风的社团。轮滑社的学生各个身怀绝技，穿着轮滑鞋，穿梭在人群中。对于喜欢轮滑，想要学习轮滑的学生，可以加入大学当中的轮滑社');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `realname` varchar(120) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `type` int(10) DEFAULT NULL COMMENT '0 社团管理员\r\n            1 总管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', '123456', '张三', '女', '13912345432', 'zhangsan@126.com', '1', '1');
INSERT INTO `userinfo` VALUES ('4', 'kevin', '123456', 'lisi', '男', '13712345678', 'lisi@163.com', '0', '0');
INSERT INTO `userinfo` VALUES ('6', 'kappy', '123456', '占山', '女', '13812345432', 'zhangsan@126.com', '0', '1');
INSERT INTO `userinfo` VALUES ('7', 'lily', '123456', '丽丽', '女', '13456789876', 'lili@163.com', '0', '0');
INSERT INTO `userinfo` VALUES ('8', 'wangxiaoming', '123456', '王小明', '男', '13212349876', 'wangxiaoming@126.com', '0', '0');
INSERT INTO `userinfo` VALUES ('9', 'xiaozhan', '123456', '肖战', '男', '13567896543', 'xiaozhan@126.com', '0', '0');
INSERT INTO `userinfo` VALUES ('10', 'chengyi', '123456', '成毅', '男', '13212344321', 'chegyi@163.com', '0', '0');
INSERT INTO `userinfo` VALUES ('11', 'ceshi', '123456', '测试', '女', '21221', '21212121', '0', '0');
INSERT INTO `userinfo` VALUES ('12', 'wangjiguang', '123456', 'wangjiguang', '男', '321321', '321132321321', '0', '0');
