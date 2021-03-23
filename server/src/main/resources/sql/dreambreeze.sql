/*
@author dream breeze
@website www.dreambreeze.cn
@date 2020/09/01
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user`
(
    `user_id`       bigint(20) unsigned NOT NULL COMMENT '用户id',
    `name`          varchar(255)        NOT NULL DEFAULT '' COMMENT '用户名',
    `password`      varchar(255)        NOT NULL DEFAULT '' COMMENT '登陆密码',
    `phone`         varchar(255)        NOT NULL DEFAULT '' COMMENT '电话号码',
    `gender`        tinyint(3)          NOT NULL DEFAULT 3 COMMENT '性别: 1:女; 2:男 ; 3:未知',
    `age`           tinyint(3)          NOT NULL DEFAULT 18 COMMENT '年龄',
    `avatar`        varchar(255)        NOT NULL DEFAULT '' COMMENT '用户头像存储路径',
    `school`        varchar(255)        NOT NULL DEFAULT '' COMMENT '毕业学校',
    `company`       varchar(255)        NOT NULL DEFAULT '' COMMENT '公司',
    `profession`    varchar(255)        NOT NULL DEFAULT '' COMMENT '职业',
    `email`         varchar(255)        NOT NULL DEFAULT '' COMMENT '邮箱',
    `address`       varchar(255)        NOT NULL DEFAULT '' COMMENT '用户地址',
    `mark`          mediumint(9)        NOT NULL DEFAULT 0 COMMENT '用户积分',
    `birthday`      bigint(20)          NOT NULL DEFAULT 0 COMMENT '用户生日',
    `rank_id`       bigint(20)          NOT NULL DEFAULT 0 COMMENT '用户等级',
    `says`          varchar(255)        NOT NULL DEFAULT 'talk is cheap' COMMENT '用户语录',
    `introduction`  varchar(255)        NOT NULL DEFAULT '' COMMENT '个人简介',
    `last_login_ip` varchar(15)         NOT NULL DEFAULT '' COMMENT '用户上一次登录IP地址',
    `register_time` bigint(20)          NOT NULL DEFAULT 0 COMMENT '用户注册时间',
    `register_ip`   varchar(25)         NOT NULL DEFAULT '' COMMENT '用户注册时IP地址',
    `active_time`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '用户最后活跃时间',
    `locked`        tinyint(3)          NOT NULL DEFAULT 0 COMMENT '是否锁定，0为不锁定，1为锁定',
    `freeze`        tinyint(3)          NOT NULL DEFAULT 0 COMMENT '是否冻结，0为不冻结，1为冻结',
    `create_by`     bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at`     bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`     bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`     bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户表';

-- ----------------------------
-- Table structure for d_role
-- ----------------------------
DROP TABLE IF EXISTS `d_role`;
CREATE TABLE `d_role`
(
    `role_id`   bigint(20) unsigned NOT NULL COMMENT '角色ID',
    `role_name` varchar(20)         NOT NULL COMMENT '角色名',
    `create_by` bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at` bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='角色表';

-- ----------------------------
-- Table structure for d_power
-- ----------------------------
DROP TABLE IF EXISTS `d_power`;
CREATE TABLE `d_power`
(
    `power_id`      bigint(20) unsigned NOT NULL COMMENT '权限ID',
    `power_key`     varchar(125)        NOT NULL COMMENT '权限码',
    `power_content` varchar(255)        NOT NULL DEFAULT '' COMMENT '权限内容',
    `create_by`     bigint(20)          NOT NULL COMMENT '创建用户',
    `create_name`   varchar(255)        NOT NULL COMMENT '创建用户名',
    `create_at`     bigint(20)          NOT NULL COMMENT '创建日期',
    `delete_at`     bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`power_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='功能权限表';

-- ----------------------------
-- Table structure for d_role
-- ----------------------------
DROP TABLE IF EXISTS `d_user_role`;
CREATE TABLE `d_user_role`
(
    `user_role_id` bigint(20) unsigned NOT NULL COMMENT '用户角色ID',
    `role_id`      bigint(20) unsigned NOT NULL COMMENT '角色ID',
    `power_id`     bigint(20) unsigned NOT NULL COMMENT '权限ID',
    PRIMARY KEY (`user_role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户角色关系表';

-- ----------------------------
-- Table structure for d_role
-- ----------------------------
DROP TABLE IF EXISTS `d_role_power`;
CREATE TABLE `d_role_power`
(
    `role_power_id` bigint(20) unsigned NOT NULL COMMENT '角色权限ID',
    `role_id`       bigint(20) unsigned NOT NULL COMMENT '角色ID',
    `power_id`      bigint(20) unsigned NOT NULL COMMENT '权限ID',
    PRIMARY KEY (`role_power_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='角色权限关系表';

-- ----------------------------
-- Table structure for d_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `d_user_attention`;
CREATE TABLE `d_user_attention`
(
    `ua_id`       smallint(5) unsigned NOT NULL COMMENT '用户关注ID',
    `user_id`     bigint(20)           NOT NULL COMMENT '关注用户ID',
    `user_name`   bigint(20)           NOT NULL COMMENT '关注用户名',
    `create_by`   bigint(20)           NOT NULL COMMENT '创建用户',
    `create_name` varchar(255)         NOT NULL COMMENT '创建用户名',
    `create_at`   bigint(20)           NOT NULL COMMENT '创建日期',
    `delete_at`   bigint(20)           NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`ua_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='用户关注表';

-- ----------------------------
-- Table structure for d_user_rank
-- ----------------------------
DROP TABLE IF EXISTS `d_user_rank`;
CREATE TABLE `d_user_rank`
(
    `rank_id`   bigint(20) unsigned NOT NULL COMMENT '等级ID',
    `rank_mark` bigint(20)          NOT NULL COMMENT '等级积分',
    `rank_name` varchar(32)         NOT NULL COMMENT '等级名称',
    `create_by` bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at` bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`rank_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='等级表';

-- ----------------------------
-- Table structure for d_visitor
-- ----------------------------
DROP TABLE IF EXISTS `d_visitor`;
CREATE TABLE `d_visitor`
(
    `visitor_id` bigint(20) unsigned NOT NULL COMMENT '访客记录ID',
    `visitor_ip` varchar(15)         NOT NULL COMMENT '访客IP地址',
    `user_id`    bigint(20)          NOT NULL COMMENT '被访问用户ID',
    `where_id`   bigint(20)          NOT NULL COMMENT '查看ID',
    `where_name` varchar(255)        NOT NULL COMMENT '查看作品名',
    `create_by`  bigint(20)          NOT NULL DEFAULT 0 COMMENT '创建用户',
    `create_at`  bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`  bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`  bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`visitor_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='访客记录表';

-- ----------------------------
-- Table structure for d_saying
-- ----------------------------
DROP TABLE IF EXISTS `d_saying`;
CREATE TABLE `d_saying`
(
    `saying_id` bigint(20) unsigned NOT NULL COMMENT '箴言D',
    `author`    varchar(255)        NOT NULL DEFAULT '' COMMENT '作者',
    `content`   text                NOT NULL COMMENT '内容',
    `create_by` bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at` bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`saying_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='箴言表';

-- ----------------------------
-- Table structure for d_article
-- ----------------------------
DROP TABLE IF EXISTS `d_article`;
CREATE TABLE `d_article`
(
    `article_id`  bigint(20) unsigned NOT NULL COMMENT '文章ID',
    `view_num`    bigint(20)          NOT NULL DEFAULT 0 COMMENT '查看次数',
    `title`       varchar(128)        NOT NULL COMMENT '文章标题',
    `summary`     varchar(255)        NOT NULL DEFAULT '' COMMENT '文章简介',
    `cover_img`   varchar(255)        NOT NULL DEFAULT '' COMMENT '封面图片的路径',
    `content`     text                NOT NULL COMMENT '文章内容',
    `send_ip`     varchar(15)         NOT NULL COMMENT '发布IP',
    `status`      tinyint(3)          NOT NULL DEFAULT 0 COMMENT '状态:0为草稿，1为成品',
    `top`         tinyint(3)          NOT NULL DEFAULT 0 COMMENT '是否置顶:0为否，1为是',
    `support`     tinyint(3)          NOT NULL DEFAULT 0 COMMENT '是否博主推荐:0为否，1为是',
    `security`    tinyint(3)          NOT NULL DEFAULT 1 COMMENT '私密等级:0为私有，1为公开，2为仅好友查看',
    `create_by`   bigint(20)          NOT NULL COMMENT '创建用户',
    `create_name` varchar(255)        NOT NULL COMMENT '用户名',
    `create_at`   bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`article_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='文章表';

-- ----------------------------
-- Table structure for d_code
-- ----------------------------
DROP TABLE IF EXISTS `d_code`;
CREATE TABLE `d_code`
(
    `code_id`     smallint(5) unsigned NOT NULL COMMENT '微码ID',
    `code_name`   varchar(60)          NOT NULL COMMENT '微码名称',
    `code_url`    varchar(255)         NOT NULL COMMENT '微码地址',
    `cover_img`   varchar(255)         NOT NULL DEFAULT '' COMMENT '封面图片的路径',
    `view_num`    bigint(20)           NOT NULL DEFAULT 0 COMMENT '查看次数',
    `security`    tinyint(3)           NOT NULL DEFAULT 1 COMMENT '私密等级:0为私有，1为公开，2为仅好友查看',
    `create_by`   bigint(20)           NOT NULL COMMENT '创建用户',
    `create_name` varchar(255)         NOT NULL COMMENT '创建用户名',
    `create_at`   bigint(20)           NOT NULL COMMENT '创建日期',
    `update_at`   bigint(20)           NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`   bigint(20)           NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`code_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='微码表';

-- ----------------------------
-- Table structure for d_photos
-- ----------------------------
DROP TABLE IF EXISTS `d_photos`;
CREATE TABLE `d_photos`
(
    `photo_id`          bigint(20) unsigned NOT NULL COMMENT '相片ID',
    `photo_name`        varchar(255)        NOT NULL COMMENT '相片名称',
    `photo_src`         varchar(255)        NOT NULL DEFAULT '' COMMENT '图片路径',
    `photo_description` varchar(255)        NOT NULL DEFAULT '' COMMENT '图片描述',
    `view_num`          bigint(20)          NOT NULL DEFAULT 0 COMMENT '查看次数',
    `upload_ip`         varchar(15)         NOT NULL COMMENT '图片操作上传IP地址',
    `security`          tinyint(3)          NOT NULL DEFAULT 1 COMMENT '私密等级:0为私有，1为公开，2为仅好友查看',
    `create_by`         bigint(20)          NOT NULL COMMENT '创建用户',
    `create_name`       varchar(255)        NOT NULL COMMENT '创建用户名',
    `create_at`         bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`         bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`         bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`photo_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='相片表';

-- ----------------------------
-- Table structure for d_link
-- ----------------------------
DROP TABLE IF EXISTS `d_link`;
CREATE TABLE `d_link`
(
    `link_id`     smallint(5) unsigned NOT NULL COMMENT '链接ID',
    `link_name`   varchar(60)          NOT NULL COMMENT '链接名称',
    `link_url`    varchar(255)         NOT NULL COMMENT '链接地址',
    `cover_img`   varchar(255)         NOT NULL DEFAULT '' COMMENT 'LOGO图片',
    `author_name` varchar(255)         NOT NULL DEFAULT '' COMMENT '链接作者',
    `show_order`  bigint(20)           NOT NULL COMMENT '在页面显示的顺序',
    `create_by`   bigint(20)           NOT NULL COMMENT '创建用户',
    `create_name` varchar(255)         NOT NULL COMMENT '创建用户名',
    `create_at`   bigint(20)           NOT NULL COMMENT '创建日期',
    `update_at`   bigint(20)           NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`   bigint(20)           NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`link_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='链接表';

-- ----------------------------
-- Table structure for d_sort
-- ----------------------------
DROP TABLE IF EXISTS `d_sort`;
CREATE TABLE `d_sort`
(
    `sort_id`     bigint(20) unsigned NOT NULL COMMENT '分类ID',
    `sort_name`   varchar(60)         NOT NULL COMMENT '分类名称',
    `parent_id`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '父级分类',
    `type`        tinyint(3)          NOT NULL DEFAULT 1 COMMENT '分类对象： 1、article ;  2、code;   3、link;   4、photo',
    `cover_img`   varchar(255)        NOT NULL DEFAULT '' COMMENT '封面图片的路径',
    `create_by`   bigint(20)          NOT NULL COMMENT '创建用户',
    `create_name` varchar(255)        NOT NULL COMMENT '创建用户名',
    `create_at`   bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`sort_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='分类表';

-- ----------------------------
-- Table structure for d_sort_entity
-- ----------------------------
DROP TABLE IF EXISTS `d_sort_entity`;
CREATE TABLE `d_sort_entity`
(
    `sort_entity_id` bigint(20) unsigned NOT NULL COMMENT '分类关系ID',
    `sort_id`        bigint(20)          NOT NULL COMMENT '分类ID',
    `entity_id`      bigint(20)          NOT NULL DEFAULT 0 COMMENT 'article_id or code_id  or photo_id or link_id',
    PRIMARY KEY (`sort_entity_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='分类关系表';

-- ----------------------------
-- Table structure for d_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `d_like`;
CREATE TABLE `d_like`
(
    `like_id`   bigint(20) unsigned NOT NULL COMMENT '点赞收藏记录ID',
    `entity_id` bigint(20)          NOT NULL COMMENT 'article_id or code_id  or photo_id',
    `type`      tinyint(3)          NOT NULL COMMENT '1点赞, 2收藏',
    `create_by` bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at` bigint(20)          NOT NULL COMMENT '创建日期',
    PRIMARY KEY (`like_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='点赞收藏表';

-- ----------------------------
-- Table structure for d_phone_message
-- ----------------------------
DROP TABLE IF EXISTS `d_phone_message`;
CREATE TABLE `d_phone_message`
(
    `message_id` bigint(20) unsigned NOT NULL COMMENT '短信ID号',
    `phone_num`  varchar(12)         NOT NULL COMMENT '用户手机号码',
    `contents`   varchar(255)        NOT NULL COMMENT '发送内容',
    `user_id`    bigint(20)          NOT NULL COMMENT '用户ID',
    `create_at`  bigint(20)          NOT NULL COMMENT '创建日期',
    PRIMARY KEY (`message_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='短信记录表';

-- ----------------------------
-- Table structure for d_secret_message
-- ----------------------------
DROP TABLE IF EXISTS `d_secret_message`;
CREATE TABLE `d_secret_message`
(
    `secret_id`       bigint(20) unsigned NOT NULL COMMENT '私信ID',
    `receive_id`      bigint(20)          NOT NULL COMMENT '收信者ID',
    `message_topic`   varchar(64)         NOT NULL COMMENT '私信标题',
    `message_content` varchar(255)        NOT NULL COMMENT '私信内容',
    `create_by`       bigint(20)          NOT NULL COMMENT '创建用户',
    `create_name`     varchar(255)        NOT NULL COMMENT '创建用户名',
    `create_at`       bigint(20)          NOT NULL COMMENT '创建日期',
    `delete_at`       bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`secret_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='私信表';

-- ----------------------------
-- Table structure for d_system_message
-- ----------------------------
DROP TABLE IF EXISTS `d_system_message`;
CREATE TABLE `d_system_message`
(
    `system_id`      bigint(20) unsigned NOT NULL COMMENT '系统通知ID',
    `role_id`        bigint(20)          NOT NULL COMMENT '角色ID',
    `system_topic`   varchar(60)         NOT NULL COMMENT '通知标题',
    `system_content` varchar(255)        NOT NULL COMMENT '通知内容',
    `create_by`      bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at`      bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`      bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`      bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`system_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='系统通知表';

-- ----------------------------
-- Table structure for d_stay_message
-- ----------------------------
DROP TABLE IF EXISTS `d_stay_message`;
CREATE TABLE `d_stay_message`
(
    `stay_id`         bigint(5) unsigned NOT NULL COMMENT '留言ID',
    `user_id`         bigint(20)         NOT NULL COMMENT '收到留言的用户ID',
    `message_content` varchar(255)       NOT NULL COMMENT '留言内容',
    `message_ip`      varchar(15)        NOT NULL COMMENT '留言用户的IP地址',
    `create_by`       bigint(20)         NOT NULL COMMENT '创建用户',
    `create_at`       bigint(20)         NOT NULL COMMENT '创建日期',
    `update_at`       bigint(20)         NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`       bigint(20)         NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`stay_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='留言表';

-- ----------------------------
-- Table structure for d_user_comment
-- ----------------------------
DROP TABLE IF EXISTS `d_user_comment`;
CREATE TABLE `d_user_comment`
(
    `comment_id`     bigint(20) unsigned NOT NULL COMMENT '评论ID',
    `commit_content` varchar(255)        NOT NULL COMMENT '评论内容',
    `commit_time`    bigint(20)          NOT NULL COMMENT '评论时间',
    `commit_ip`      varchar(15)         NOT NULL COMMENT '评论时的IP地址',
    `entity_id`      bigint(20)          NOT NULL COMMENT 'article_id or code_id  or photo_id',
    `create_by`      bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at`      bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`      bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`      bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`comment_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='评论表';

-- ----------------------------
-- Table structure for d_read
-- ----------------------------
DROP TABLE IF EXISTS `d_read`;
CREATE TABLE `d_read`
(
    `read_id`   bigint(20) unsigned NOT NULL COMMENT '系统通知ID',
    `entity_id` bigint(20)          NOT NULL DEFAULT 0 COMMENT 'system_id or  secret_id or comment_id or stay_id',
    `create_by` bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at` bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at` bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`read_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='已读表';

-- ----------------------------
-- Table structure for d_ad
-- ----------------------------
DROP TABLE IF EXISTS `d_ad`;
CREATE TABLE `d_ad`
(
    `ad_id`       bigint(20) unsigned NOT NULL COMMENT '广告自增ID',
    `position`    smallint(5)         NOT NULL COMMENT '代表的是该广告所处的广告位',
    `media_type`  bigint(20)          NOT NULL DEFAULT '0' COMMENT '广告类型,0图片;1flash;2代码;3文字',
    `ad_name`     varchar(60)         NOT NULL COMMENT '该条广告记录的广告名称',
    `ad_link`     varchar(255)        NOT NULL COMMENT '广告链接地址',
    `ad_code`     text                NOT NULL COMMENT '广告链接的表现,文字广告就是文字或图片和flash就是它们的地址',
    `start_time`  bigint(20)          NOT NULL DEFAULT '0' COMMENT '广告开始时间',
    `end_time`    bigint(20)          NOT NULL DEFAULT '0' COMMENT '广告结束时间',
    `name`        varchar(60)         NOT NULL COMMENT '广告主姓名',
    `email`       varchar(60)         NOT NULL DEFAULT '' COMMENT '广告主邮箱',
    `phone`       varchar(60)         NOT NULL COMMENT '广告主电话',
    `click_count` bigint(20)          NOT NULL DEFAULT 0 COMMENT '点击次数',
    `enabled`     bigint(20)          NOT NULL DEFAULT 1 COMMENT '该广告是否关闭;1开启; 0关闭',
    `create_by`   bigint(20)          NOT NULL COMMENT '创建用户',
    `create_at`   bigint(20)          NOT NULL COMMENT '创建日期',
    `update_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '修改日期',
    `delete_at`   bigint(20)          NOT NULL DEFAULT 0 COMMENT '删除日期',
    PRIMARY KEY (`ad_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='广告表';