create table gen_column
(
  column_id bigint auto_increment comment '字段ID'
    primary key,
  column_name varchar(30) default '' null comment '字段名称',
  column_comment varchar(30) default '' null comment '列注释',
  column_table_id bigint null comment '表ID'
)
  comment '代码生成字段表';

create table gen_table
(
  table_id bigint auto_increment comment '表ID'
    primary key,
  table_name varchar(30) default '' null comment '表名',
  table_comment varchar(30) default '' null comment '表注释'
)
  comment '代码生成表';

create table `order`
(
  order_id bigint(11) auto_increment comment '订单ID'
  primary key,
  order_no varchar(30) default '' null comment '订单编号',
  user_id bigint null comment '用户ID'
  )
  comment '订单表';

create table sys_file
(
  file_id bigint auto_increment comment '文件id'
    primary key,
  file_name varchar(30) default '' not null comment '文件名称',
  file_uuid varchar(30) default '' not null comment '文件唯一编号',
  file_size bigint default 0 not null comment '文件大小',
  file_modified_time datetime not null comment '文件最后修改时间',
  file_create_time datetime not null comment '文件记录创建日期',
  file_update_time datetime null comment '文件记录修改日期',
  constraint h_file_file_uuid_uindex
    unique (file_uuid)
)
  comment '文件表';

create table sys_log
(
  log_id bigint auto_increment comment '日志ID'
    primary key,
  log_content varchar(255) default '' null comment '日志内容',
  log_type char(2) default '' null comment '日志类型'
)
  comment '系统日志表';

create table user
(
  user_id bigint auto_increment comment '用户ID'
    primary key,
  user_name varchar(30) default '' null comment '用户名',
  login_name varchar(30) default '' null comment '登录名',
  user_password varchar(30) default '' null comment '密码'
)
  comment '用户表';

