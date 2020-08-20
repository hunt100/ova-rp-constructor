alter table app_users add column image_id bigint;
alter table character_sheets add column image_id bigint;
alter table app_users drop column avatar_url;

create table images (
id bigint not null auto_increment,
created_at datetime(6),
image TEXT,
plain_url TEXT,
public_id varchar(255),
title varchar(255),
primary key (id)
);

alter table app_users add constraint FKqb6xhmmp1tsjccqx5lk6341ww foreign key (image_id) references images (id);
alter table character_sheets add constraint FKmgo3l6p9cml24o92sdihlxvh5 foreign key (image_id) references images (id);