/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3309
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3309
 Source Schema         : cq_pension

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 21/10/2020 16:51:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `act_id` int(10) NOT NULL COMMENT '活动id',
  `act_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `act_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动内容',
  `act_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动内容',
  `act_place` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  `act_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `act_btime` datetime(6) NULL DEFAULT NULL COMMENT '开始时间',
  `act_etime` datetime(6) NULL DEFAULT NULL COMMENT '结束时间',
  `act_rem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`act_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `bed_id` int(6) NOT NULL COMMENT '床位编号',
  `room_id` int(10) NULL DEFAULT NULL COMMENT '房间编号',
  `bed_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '入住价格',
  `bed_occupy` enum('占用','不占用') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否占用',
  PRIMARY KEY (`bed_id`) USING BTREE,
  INDEX `room_id`(`room_id`) USING BTREE,
  CONSTRAINT `bed_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '床位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES (1, 101, 15.50, '不占用');
INSERT INTO `bed` VALUES (2, 101, 12.30, '占用');
INSERT INTO `bed` VALUES (4, 101, 10000000.00, '不占用');
INSERT INTO `bed` VALUES (5, 101, 34925.00, '占用');
INSERT INTO `bed` VALUES (6, 101, 34925.00, '不占用');

-- ----------------------------
-- Table structure for bed_repl
-- ----------------------------
DROP TABLE IF EXISTS `bed_repl`;
CREATE TABLE `bed_repl`  (
  `br_id` int(10) NOT NULL COMMENT '记录编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `o_bed_id` int(6) NULL DEFAULT NULL COMMENT '原床位编号',
  `n_bed_id` int(6) NULL DEFAULT NULL COMMENT '新床位编号',
  `charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`br_id`) USING BTREE,
  INDEX `o_bed_id`(`o_bed_id`) USING BTREE,
  INDEX `n_bed_id`(`n_bed_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '床位更换表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for build
-- ----------------------------
DROP TABLE IF EXISTS `build`;
CREATE TABLE `build`  (
  `b_id` int(2) NOT NULL COMMENT '楼房编号',
  `b_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `fl_num` int(4) NULL DEFAULT NULL COMMENT '层数',
  `b_time` datetime(0) NULL DEFAULT NULL COMMENT '建成时间',
  `b_per` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用途',
  `dev_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建设负责人',
  `b_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼房负责人',
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼房表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of build
-- ----------------------------
INSERT INTO `build` VALUES (1, 'sds', 20, '2020-10-14 11:10:48', '不知道用途', 'zhd', 'zhd');

-- ----------------------------
-- Table structure for charge_bill
-- ----------------------------
DROP TABLE IF EXISTS `charge_bill`;
CREATE TABLE `charge_bill`  (
  `cb_id` int(20) NOT NULL COMMENT '收费单号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `cb_time` datetime(0) NULL DEFAULT NULL COMMENT '收费时间',
  `charg_esti` decimal(12, 2) NULL DEFAULT NULL COMMENT '预计收费',
  `charg_act` decimal(12, 2) NULL DEFAULT NULL COMMENT '待付金额',
  `pay_method` enum('微信','支付宝','现金','银行卡','未支付') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录员',
  `cb_rem` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cb_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收费单记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of charge_bill
-- ----------------------------
INSERT INTO `charge_bill` VALUES (1, 1, '2020-10-22 10:22:37', 186.30, 0.00, '微信', 'zhd', '阿斯蒂芬喀斯柯达房间里卡');
INSERT INTO `charge_bill` VALUES (2, 2, '2020-10-14 00:00:00', 123.50, 50.00, '微信', 'zhd', '时代峻峰看见爱上了打开房间卡萨丁九分裤');
INSERT INTO `charge_bill` VALUES (3, 1, '2020-10-12 16:13:53', 256.50, 256.50, '微信', '', '');
INSERT INTO `charge_bill` VALUES (4, 2, '2020-11-22 16:20:01', 12.30, 0.00, '未支付', NULL, NULL);
INSERT INTO `charge_bill` VALUES (7, 1, '2020-10-12 16:22:26', 555.00, 0.00, '未支付', '', '');

-- ----------------------------
-- Table structure for duty_record
-- ----------------------------
DROP TABLE IF EXISTS `duty_record`;
CREATE TABLE `duty_record`  (
  `dr_id` int(10) NOT NULL COMMENT 'id',
  `emp_id` int(10) NULL DEFAULT NULL COMMENT '值班员工编号',
  `dr_time` datetime(0) NULL DEFAULT NULL COMMENT '值班时间',
  `dr_ctime` datetime(0) NULL DEFAULT NULL COMMENT '换班时间',
  `dr_arrange` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值班安排',
  `dr_rem` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '值班记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for eat_cons
-- ----------------------------
DROP TABLE IF EXISTS `eat_cons`;
CREATE TABLE `eat_cons`  (
  `ec_id` int(20) NOT NULL COMMENT '消费记录编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `cb_id` int(20) NULL DEFAULT NULL COMMENT '收费单号',
  `cons_time` datetime(0) NULL DEFAULT NULL COMMENT '消费时间',
  `pe_id` int(11) NULL DEFAULT NULL COMMENT '套餐编号',
  `pe_price` decimal(6, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `ec_status` enum('已支付','未支付') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`ec_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE,
  INDEX `pe_id`(`pe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '额外餐饮消费' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for eat_level
-- ----------------------------
DROP TABLE IF EXISTS `eat_level`;
CREATE TABLE `eat_level`  (
  `el_id` int(10) NOT NULL COMMENT '规格编号',
  `el_des` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `el_price` decimal(6, 2) NULL DEFAULT NULL COMMENT '价格',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`el_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '餐饮规格（三菜一汤，两肉一菜等）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eat_level
-- ----------------------------
INSERT INTO `eat_level` VALUES (1, '四菜一汤', 22.50, 'zhd');

-- ----------------------------
-- Table structure for emm_user
-- ----------------------------
DROP TABLE IF EXISTS `emm_user`;
CREATE TABLE `emm_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `emp_id` int(10) NOT NULL COMMENT '员工编号',
  `emp_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `emp_password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role_id` int(6) NULL DEFAULT NULL COMMENT '角色',
  `can_use` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `emm_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工登录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emm_user
-- ----------------------------
INSERT INTO `emm_user` VALUES (1, 2010060001, 'zhd', '123456', 1, '是');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(11) NOT NULL COMMENT '员工编号',
  `emp_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `emp_sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `emp_birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `emp_phone` bigint(11) NULL DEFAULT NULL COMMENT '电话',
  `emp_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `emp_add` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `emp_photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `emp_native` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `emp_marry` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否婚配',
  `emp_major` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `emp_card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `emp_edu` enum('小学','初中','高中','本科','硕士','博士') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (2010060001, 'zhd', '男', '1998-01-08', 13229725504, 'ceboe_zhd@qq.com', '广东省罗定市太平', NULL, '广东罗定', '否', '软件工程', '44538119980108xxxx', '本科');

-- ----------------------------
-- Table structure for employeemanage
-- ----------------------------
DROP TABLE IF EXISTS `employeemanage`;
CREATE TABLE `employeemanage`  (
  `emm_id` int(10) NOT NULL COMMENT '就职编号',
  `emp_id` int(10) NULL DEFAULT NULL COMMENT '员工编号',
  `emm_job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `emm_inc` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否在职',
  `emm_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '资薪',
  `emm_etime` date NULL DEFAULT NULL COMMENT '入职时间',
  `emm_dtime` date NULL DEFAULT NULL COMMENT '离职时间',
  PRIMARY KEY (`emm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeemanage
-- ----------------------------
INSERT INTO `employeemanage` VALUES (1, 2010060001, 'zhd', '是', 12.03, '2020-10-14', NULL);

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family`  (
  `fm_id` int(6) NOT NULL COMMENT '家属编号',
  `op_id` int(6) NULL DEFAULT NULL COMMENT '老人编号',
  `fm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家属名字',
  `fm_sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `fm_phone` bigint(11) NULL DEFAULT NULL COMMENT '联系电话',
  `fm_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `fm_office` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公地址',
  `fm_rel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '亲属关系',
  `fm_charge` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否负责人',
  `fm_record` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`fm_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人家属信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `fl_id` int(2) NOT NULL COMMENT '楼层编号',
  `b_id` int(2) NULL DEFAULT NULL COMMENT '楼房编号',
  `r_num` int(2) NULL DEFAULT NULL COMMENT '房间数量',
  `fl_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层名称',
  `fl_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fl_id`) USING BTREE,
  INDEX `b_id`(`b_id`) USING BTREE,
  CONSTRAINT `floor_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `build` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '楼层信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES (1, 1, 10, '1', 'zhd');
INSERT INTO `floor` VALUES (2, 1, 132, '2层', 'zhd');

-- ----------------------------
-- Table structure for heal_ass
-- ----------------------------
DROP TABLE IF EXISTS `heal_ass`;
CREATE TABLE `heal_ass`  (
  `ha_id` int(10) NOT NULL COMMENT 'id',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人id',
  `ha_num` int(20) NULL DEFAULT NULL COMMENT '评估单号',
  `ha_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评估类型',
  `ha_time` datetime(0) NULL DEFAULT NULL COMMENT '评估时间',
  `ha_level` enum('1','2','3','特护') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议护理级别',
  `live_ass` enum('建议入住','不建议入住') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住评估',
  `ha_person` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评估人',
  `ha_eye` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视力障碍',
  `ha_ear` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '听力障碍',
  `ha_mood` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '精神状态',
  `ha_move` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行动能力',
  `ha_talk` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交流能力',
  `ha_limbs` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '肢体能力',
  `ha_daily` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日常生活能力',
  `ha_eat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '饮食障碍',
  `ha_med` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药物过敏',
  `ha_rec` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`ha_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '健康评估表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ill_history
-- ----------------------------
DROP TABLE IF EXISTS `ill_history`;
CREATE TABLE `ill_history`  (
  `ih_id` int(10) NOT NULL COMMENT 'id',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人id',
  `ih_dis` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病',
  `ih_cure` enum('痊愈','未痊愈') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否痊愈',
  `recur_pos` enum('不复发','较低概率','较高概率','极高概率') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复发可能',
  `ih_attention` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `ih_rec` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`ih_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '病史记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ill_record
-- ----------------------------
DROP TABLE IF EXISTS `ill_record`;
CREATE TABLE `ill_record`  (
  `ill_id` int(10) NOT NULL COMMENT 'id',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人id',
  `ill_dis` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病',
  `ill_time` datetime(0) NULL DEFAULT NULL COMMENT '生病时间',
  `med_mech` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊机构',
  `reco_time` datetime(0) NULL DEFAULT NULL COMMENT '痊愈时间',
  `ill_attention` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注意事项',
  `ill_rec` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`ill_id`) USING BTREE,
  INDEX `ill_record_ibfk_1`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '疾病记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for join_act
-- ----------------------------
DROP TABLE IF EXISTS `join_act`;
CREATE TABLE `join_act`  (
  `ja_id` int(10) NOT NULL COMMENT 'id',
  `act_id` int(10) NULL DEFAULT NULL COMMENT '活动id',
  `act_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人id',
  PRIMARY KEY (`ja_id`) USING BTREE,
  INDEX `join_act_ibfk_1`(`act_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动参与表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kitchen
-- ----------------------------
DROP TABLE IF EXISTS `kitchen`;
CREATE TABLE `kitchen`  (
  `k_id` int(10) NOT NULL COMMENT '菜品编号',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `dish_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品名',
  `dish_make` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品组成',
  `dish_mix` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品配料',
  `cooker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厨师',
  `charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厨房负责人',
  `recorder` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`k_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜品制作记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kitchen
-- ----------------------------
INSERT INTO `kitchen` VALUES (1, '2020-10-20 17:16:38', '小鸡炖蘑菇', '小鸡，蘑菇', '盐，鸡精', 'zhd', 'zhd', 'zhd');

-- ----------------------------
-- Table structure for live
-- ----------------------------
DROP TABLE IF EXISTS `live`;
CREATE TABLE `live`  (
  `live_id` int(10) NOT NULL COMMENT '入住id',
  `op_id` int(10) NOT NULL COMMENT '老人编号',
  `live_time` datetime(0) NULL DEFAULT NULL COMMENT '入住时间',
  `bed_id` int(4) NULL DEFAULT NULL COMMENT '入住的床位编号',
  `live_pro` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入住协议地址',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '退住时间',
  `end_pro` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退住协议',
  `el_id` int(10) NULL DEFAULT NULL COMMENT '餐饮规格编号',
  `np_id` int(10) NULL DEFAULT NULL COMMENT '基础护理项编号',
  PRIMARY KEY (`live_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE,
  INDEX `bed_id`(`bed_id`) USING BTREE,
  INDEX `el_id`(`el_id`) USING BTREE,
  INDEX `np_id`(`np_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人入住信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `log_id` int(20) NOT NULL COMMENT 'ID',
  `log_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类型',
  `log_con` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体操作',
  `log_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `log_date` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `log_time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `m_id` int(11) NOT NULL COMMENT '物资编号',
  `m_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物资号',
  `m_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `m_price` decimal(12, 2) NULL DEFAULT NULL COMMENT '价格',
  `depr_rate` decimal(3, 2) NULL DEFAULT NULL COMMENT '折旧率',
  `item_type` enum('一次性用品','耐用品') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物品类型',
  `stock_num` int(10) NULL DEFAULT NULL COMMENT '现存数量',
  `charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `level` int(2) NULL DEFAULT NULL COMMENT '菜单级别',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `parent` int(8) NULL DEFAULT NULL COMMENT '父菜单编号',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 1, '系统管理', 'el-icon-s-tools', 'sysManage', NULL);
INSERT INTO `menu` VALUES (2, 1, '数据统计', 'el-icon-s-data', 'dataStat', NULL);
INSERT INTO `menu` VALUES (3, 1, '组织管理', 'el-icon-s-flag', 'organManag', NULL);
INSERT INTO `menu` VALUES (4, 1, '养老管理', 'el-icon-s-custom', 'olderManag', NULL);
INSERT INTO `menu` VALUES (5, 2, '系统设置', '', 'sysSet', 1);
INSERT INTO `menu` VALUES (6, 2, '权限管理', NULL, 'authority', 1);
INSERT INTO `menu` VALUES (7, 2, '管理员管理', NULL, 'manager', 1);
INSERT INTO `menu` VALUES (8, 2, '日志管理', NULL, 'log', 1);
INSERT INTO `menu` VALUES (9, 2, '系统备份恢复', NULL, 'backup', 1);
INSERT INTO `menu` VALUES (10, 2, '员工管理', NULL, 'employee', 3);
INSERT INTO `menu` VALUES (11, 2, '到访记录', NULL, 'visitRecord', 3);
INSERT INTO `menu` VALUES (12, 2, '社工活动', NULL, 'socialWork', 3);
INSERT INTO `menu` VALUES (13, 2, '物资管理', NULL, 'material', 3);
INSERT INTO `menu` VALUES (14, 2, '老人管理', NULL, 'opeople', 4);
INSERT INTO `menu` VALUES (15, 2, '收费管理', NULL, 'chargeBill', 4);
INSERT INTO `menu` VALUES (16, 2, '餐饮管理', NULL, 'eat', 4);
INSERT INTO `menu` VALUES (17, 2, '护理项', NULL, 'nursProject', 4);
INSERT INTO `menu` VALUES (18, 2, '住宿管理', NULL, 'accom', 4);
INSERT INTO `menu` VALUES (19, 2, '健康状况管理', NULL, 'phyCondition', 4);
INSERT INTO `menu` VALUES (20, 2, '活动记录', NULL, 'activity', 4);
INSERT INTO `menu` VALUES (22, 3, '菜品制作记录', NULL, 'kitchen', 16);
INSERT INTO `menu` VALUES (23, 3, '套餐列表', NULL, 'eatPrice', 16);
INSERT INTO `menu` VALUES (24, 3, '体检报告', NULL, 'phyExam', 19);
INSERT INTO `menu` VALUES (25, 3, '病史记录', NULL, 'illHistory', 19);
INSERT INTO `menu` VALUES (26, 3, '疾病记录', NULL, 'illRecord', 19);
INSERT INTO `menu` VALUES (27, 3, '健康评测', NULL, 'healAss', 19);
INSERT INTO `menu` VALUES (28, 3, '员工信息', NULL, 'employee', 10);
INSERT INTO `menu` VALUES (29, 3, '值班记录', NULL, 'dutyRecord', 10);

-- ----------------------------
-- Table structure for nurs_plan
-- ----------------------------
DROP TABLE IF EXISTS `nurs_plan`;
CREATE TABLE `nurs_plan`  (
  `n_id` int(10) NOT NULL COMMENT '计划编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `np_level` int(2) NULL DEFAULT NULL COMMENT '护理等级',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `adda_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件地址',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '护理计划' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nurs_proj
-- ----------------------------
DROP TABLE IF EXISTS `nurs_proj`;
CREATE TABLE `nurs_proj`  (
  `np_id` int(10) NOT NULL COMMENT '护理项编号',
  `na_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护理项名称',
  `np_des` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情',
  `np_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '价格',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`np_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '护理项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nurs_record
-- ----------------------------
DROP TABLE IF EXISTS `nurs_record`;
CREATE TABLE `nurs_record`  (
  `n_id` int(10) NOT NULL COMMENT '记录编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `np_id` int(10) NULL DEFAULT NULL COMMENT '护理项编号',
  `nn_des` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `result` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '护理结果',
  `nurse` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行护工',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`n_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE,
  INDEX `np_id`(`np_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '护理记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for older_user
-- ----------------------------
DROP TABLE IF EXISTS `older_user`;
CREATE TABLE `older_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `op_id` int(10) NOT NULL COMMENT '登录账号（老人编号）',
  `op_password` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `can_use` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人账号登录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for opeople
-- ----------------------------
DROP TABLE IF EXISTS `opeople`;
CREATE TABLE `opeople`  (
  `op_id` int(10) NOT NULL COMMENT '老人编号',
  `op_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人姓名',
  `op_age` int(4) NULL DEFAULT NULL COMMENT '老人年龄',
  `op_sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人性别',
  `op_native` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `op_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `op_photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片',
  `op_card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `op_phone` bigint(11) NULL DEFAULT NULL COMMENT '联系电话',
  `op_birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老人个人信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of opeople
-- ----------------------------
INSERT INTO `opeople` VALUES (1234, 'zhd', 67, '男', '广东肇庆', '广东肇庆端州', '../../assets/img/大鹏鸟1.jpg', '4456456', 13229845562, '2020-10-01');

-- ----------------------------
-- Table structure for out
-- ----------------------------
DROP TABLE IF EXISTS `out`;
CREATE TABLE `out`  (
  `out_id` int(10) NOT NULL COMMENT '编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `out_time` datetime(0) NULL DEFAULT NULL COMMENT '外出时间',
  `predict_time` datetime(0) NULL DEFAULT NULL COMMENT '预计回来时间',
  `real_time` datetime(0) NULL DEFAULT NULL COMMENT '实际回来时间',
  `out_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外出原因',
  `outfm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同意家属名',
  `out_record` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  `out_eaa` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批人',
  PRIMARY KEY (`out_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '外出状况表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for perm_menu
-- ----------------------------
DROP TABLE IF EXISTS `perm_menu`;
CREATE TABLE `perm_menu`  (
  `per_id` int(6) NOT NULL COMMENT '权限编号',
  `menu_id` int(8) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`per_id`, `menu_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE,
  CONSTRAINT `perm_menu_ibfk_1` FOREIGN KEY (`per_id`) REFERENCES `permissions` (`per_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `perm_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限-菜单联系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perm_menu
-- ----------------------------
INSERT INTO `perm_menu` VALUES (1, 1);
INSERT INTO `perm_menu` VALUES (1, 2);
INSERT INTO `perm_menu` VALUES (1, 3);
INSERT INTO `perm_menu` VALUES (1, 4);
INSERT INTO `perm_menu` VALUES (1, 5);
INSERT INTO `perm_menu` VALUES (1, 8);
INSERT INTO `perm_menu` VALUES (1, 9);
INSERT INTO `perm_menu` VALUES (1, 10);
INSERT INTO `perm_menu` VALUES (1, 11);
INSERT INTO `perm_menu` VALUES (1, 12);
INSERT INTO `perm_menu` VALUES (1, 13);
INSERT INTO `perm_menu` VALUES (1, 14);
INSERT INTO `perm_menu` VALUES (1, 15);
INSERT INTO `perm_menu` VALUES (1, 16);
INSERT INTO `perm_menu` VALUES (1, 17);
INSERT INTO `perm_menu` VALUES (1, 18);
INSERT INTO `perm_menu` VALUES (1, 19);
INSERT INTO `perm_menu` VALUES (1, 20);
INSERT INTO `perm_menu` VALUES (1, 22);
INSERT INTO `perm_menu` VALUES (1, 23);
INSERT INTO `perm_menu` VALUES (1, 24);
INSERT INTO `perm_menu` VALUES (1, 25);
INSERT INTO `perm_menu` VALUES (1, 26);
INSERT INTO `perm_menu` VALUES (1, 27);

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `per_id` int(6) NOT NULL COMMENT '权限ID',
  `per_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `per_des` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `per_menu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子菜单',
  `per_rem` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`per_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, '系统管理', '可进行系统管理操作', NULL, '');

-- ----------------------------
-- Table structure for person_eat
-- ----------------------------
DROP TABLE IF EXISTS `person_eat`;
CREATE TABLE `person_eat`  (
  `pe_id` int(10) NOT NULL COMMENT '需求编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `dishlike` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '忌口',
  `habbit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '饮食编号',
  `pe_rec` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  PRIMARY KEY (`pe_id`) USING BTREE,
  INDEX `op_id`(`op_id`) USING BTREE,
  CONSTRAINT `person_eat_ibfk_1` FOREIGN KEY (`op_id`) REFERENCES `opeople` (`op_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人餐饮需求' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for phy_exam
-- ----------------------------
DROP TABLE IF EXISTS `phy_exam`;
CREATE TABLE `phy_exam`  (
  `pe_id` int(10) NOT NULL COMMENT '记录编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人ID',
  `pe_form` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体检单',
  `pe_hos` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体检医院',
  `pe_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体检类型',
  `pe_time` datetime(0) NULL DEFAULT NULL COMMENT '体检时间',
  `pe_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体检负责人',
  `pe_rec` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录人',
  `pe_rem` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '体检报告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for price_eat
-- ----------------------------
DROP TABLE IF EXISTS `price_eat`;
CREATE TABLE `price_eat`  (
  `pe_id` int(10) NOT NULL COMMENT '套餐编号',
  `mael` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名',
  `feature` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特点',
  `pe_spec` int(10) NULL DEFAULT NULL COMMENT '规格编号',
  `m_make` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐组成',
  `m_person` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐配置人',
  PRIMARY KEY (`pe_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '套餐列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price_eat
-- ----------------------------
INSERT INTO `price_eat` VALUES (1, '套餐一', '补血、护心、降血压，但糖分略高', 1, '糖醋排骨，凉拌青瓜，番茄炒鸡蛋，小白菜，红枣枸杞猪骨汤', 'zhd');

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`  (
  `re_id` int(10) NOT NULL COMMENT '退费编号',
  `op_id` int(10) NULL DEFAULT NULL COMMENT '老人编号',
  `re_status` enum('退费完成','未完成') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退费状态',
  `re_time` datetime(0) NULL DEFAULT NULL COMMENT '退费时间',
  `re_money` decimal(8, 2) NULL DEFAULT NULL COMMENT '退费金额',
  `re_method` enum('支付宝','微信','银行账户','现金') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退费方式',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录员',
  PRIMARY KEY (`re_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退费记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rep_content
-- ----------------------------
DROP TABLE IF EXISTS `rep_content`;
CREATE TABLE `rep_content`  (
  `rc_id` int(6) NOT NULL COMMENT 'ID',
  `rep_id` int(6) NULL DEFAULT NULL COMMENT '所属报表ID',
  `rc_data` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据表',
  `rc_field` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段',
  `field_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段注释',
  PRIMARY KEY (`rc_id`) USING BTREE,
  INDEX `rep_id`(`rep_id`) USING BTREE,
  CONSTRAINT `rep_content_ibfk_1` FOREIGN KEY (`rep_id`) REFERENCES `report` (`rep_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报表内容' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `rep_id` int(6) NOT NULL COMMENT '报表ID',
  `rep_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报表名称',
  `rep_des` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`rep_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报表管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(6) NOT NULL COMMENT '角色表ID',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `role_des` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `role_rec` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录状态',
  `role_rem` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '具备除后台用户管理外的所有权限', NULL, '');

-- ----------------------------
-- Table structure for role_perm
-- ----------------------------
DROP TABLE IF EXISTS `role_perm`;
CREATE TABLE `role_perm`  (
  `role_id` int(6) NOT NULL COMMENT '角色ID',
  `per_id` int(6) NOT NULL COMMENT '权限ID',
  `rp_rem` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`, `per_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `per_id`(`per_id`) USING BTREE,
  CONSTRAINT `role_perm_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_perm_ibfk_2` FOREIGN KEY (`per_id`) REFERENCES `permissions` (`per_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_perm
-- ----------------------------
INSERT INTO `role_perm` VALUES (1, 1, '');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int(4) NOT NULL COMMENT 'id',
  `flo_id` int(10) NULL DEFAULT NULL COMMENT '对应楼层id',
  `room_num` int(10) NULL DEFAULT NULL COMMENT '房号',
  `bed_num` int(4) NULL DEFAULT NULL COMMENT '床位数',
  `room_sun` enum('向阳','不向阳') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否向阳',
  `room_spe` enum('特护','普通') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否特护',
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `flo_id`(`flo_id`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`flo_id`) REFERENCES `floor` (`fl_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房间信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (101, 1, 102, 3, '向阳', '普通');
INSERT INTO `room` VALUES (201, 1, 201, 100, '向阳', '特护');

-- ----------------------------
-- Table structure for social_worker_act
-- ----------------------------
DROP TABLE IF EXISTS `social_worker_act`;
CREATE TABLE `social_worker_act`  (
  `swa_id` int(10) NOT NULL COMMENT '活动编号',
  `swa_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动内容',
  `swa_btime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `swa_etime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `org_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织名称',
  `org_pnum` int(4) NULL DEFAULT NULL COMMENT '组织人数',
  `org_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织负责人',
  `swa_charge` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院方负责人',
  `swa_rem` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`swa_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '社工活动记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for use_record
-- ----------------------------
DROP TABLE IF EXISTS `use_record`;
CREATE TABLE `use_record`  (
  `ur_id` int(15) NOT NULL COMMENT '记录编号',
  `m_id` int(10) NULL DEFAULT NULL COMMENT '物资编号',
  `applicant` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `use_time` datetime(0) NULL DEFAULT NULL COMMENT '领用时间',
  `use_num` int(6) NULL DEFAULT NULL COMMENT '领用数量',
  `re_time` datetime(0) NULL DEFAULT NULL COMMENT '归还时间',
  `is_dem` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否损坏',
  `use_des` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用详情',
  `note_taker` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '记录员',
  PRIMARY KEY (`ur_id`) USING BTREE,
  INDEX `m_id`(`m_id`) USING BTREE,
  CONSTRAINT `use_record_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `material` (`m_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物资使用记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for visit_record
-- ----------------------------
DROP TABLE IF EXISTS `visit_record`;
CREATE TABLE `visit_record`  (
  `vr_id` int(6) NOT NULL COMMENT '记录编号',
  `vr_ttime` datetime(6) NULL DEFAULT NULL COMMENT '到访时间',
  `vr_ltime` datetime(6) NULL DEFAULT NULL COMMENT '离开时间',
  `vr_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `vr_phone` int(20) NULL DEFAULT NULL COMMENT '联系电话',
  `vr_purpsoe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到访目的',
  `vr_rem` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `vr_dutyname` int(10) NULL DEFAULT NULL COMMENT '值班人员',
  PRIMARY KEY (`vr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '到访记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
