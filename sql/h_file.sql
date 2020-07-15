create table h_file
(
    file_id            int auto_increment comment '文件id'
        primary key,
    file_name          varchar(80) charset utf8           not null comment '文件名称',
    file_uuid          varchar(80) charset utf8           not null comment '文件唯一编号',
    file_size          int      default 0                 not null comment '文件大小',
    file_modified_time datetime                           not null comment '文件最后修改时间',
    file_create_time   datetime default CURRENT_TIMESTAMP not null comment '文件记录创建日期',
    file_update_time   datetime                           null comment '文件记录修改日期',
    constraint h_file_file_uuid_uindex
        unique (file_uuid)
)
    comment '文件表';


