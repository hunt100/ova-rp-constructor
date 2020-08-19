CREATE TABLE abilities (
    id bigint not null auto_increment,
    created_at datetime(6),
    description TEXT,
    level integer,
    name varchar(255),
    primary key (id)
);


create table abilities_magic (
    ability_id bigint not null,
    magic_id bigint not null
);

create table abilities_modifier_list (
    ability_id bigint not null,
    modifier_list_id bigint not null
);

create table app_users (
    id bigint not null auto_increment,
     created_at datetime(6),
     avatar_url TEXT,
     enable bit,
     login varchar(255),
     password varchar(255),
     primary key (id)
); 

create table attacks (
    id bigint not null auto_increment,
    created_at datetime(6),
    description varchar(255),
    dx integer,
    end integer,
    name varchar(255),
    roll integer,
    primary key (id)
); 

create table attacks_perks_and_flaws (
    attack_id bigint not null,
    perks_and_flaws_id bigint not null
); 

create table character_sheets (
    id bigint not null auto_increment,
    created_at datetime(6),
    appearance TEXT,
    base_defense integer,
    base_dice integer,
    base_endurance integer,
    base_health integer,
    base_tv integer,
    bio TEXT,
    character_name varchar(255),
    character_type varchar(255),
    other_notes varchar(255),
    personality TEXT,
    app_user_id bigint,
    primary key (id)
);

create table character_sheets_abilities (
    character_sheet_id bigint not null,
    abilities_id bigint not null
); 
create table character_sheets_attacks (
    character_sheet_id bigint not null,
    attacks_id bigint not null
); 

create table character_sheets_weaknesses (
    character_sheet_id bigint not null,
    weaknesses_id bigint not null
); 

create table chars_attributes_modifiers (
    type varchar(31) not null,
    id bigint not null auto_increment,
    created_at datetime(6),
    level integer,
    dn integer,
    text_description varchar(255),
    characteristic_type varchar(255),
    modifier integer,
    primary key (id)
); 

create table document_template (
    id bigint not null auto_increment,
    created_at datetime(6),
    doc_key varchar(255),
    filename varchar(255),
    original_text TEXT,
    text_kz TEXT,
    text_rus TEXT,
    title varchar(255),
    type varchar(255),
    primary key (id)
); 

create table magic (
    id bigint not null auto_increment,
    created_at datetime(6),
    base_endurance_cost integer,
    effect varchar(255),
    spell_level integer,
    spell_name varchar(255),
    primary key (id)
); 

create table perks (
    id bigint not null auto_increment,
    created_at datetime(6),
    description varchar(255),
    dx_per_level integer,
    endurance_per_level integer,
    level integer,
    name varchar(255),
    roll_per_level integer,
    primary key (id)
); 

create table roles (
    id bigint not null auto_increment,
    created_at datetime(6),
    name varchar(50), primary key (id)
); 

create table tokens (
    id bigint not null auto_increment,
    created_at datetime(6),
    expiry_date datetime(6),
    token varchar(255),
    user_id bigint not null,
    primary key (id)
); 

create table user_roles (
    user_id bigint not null,
    role_id bigint not null
); 

create table weakenesses (
    id bigint not null auto_increment,
    created_at datetime(6),
    description TEXT,
    level integer,
    name varchar(255),
    primary key (id)
); 

create table weakenesses_modifier_list (
    weakness_id bigint not null,
    modifier_list_id bigint not null
);

alter table abilities_magic add constraint UK_59mprvkg4ws97eji00ss1ylqg unique (magic_id);
alter table abilities_modifier_list add constraint UK_3wqvw0r28602qbax8w66qfym5 unique (modifier_list_id);
alter table attacks_perks_and_flaws add constraint UK_97k4ae9q6u76yj626bmn34i9o unique (perks_and_flaws_id);
alter table character_sheets_abilities add constraint UK_5m7m7wm5wauc41nd3ng2agf2m unique (abilities_id);
alter table character_sheets_attacks add constraint UK_rpyx4cb2qxo1k2lax9t3mkymn unique (attacks_id);
alter table character_sheets_weaknesses add constraint UK_5btxq32bpd2n6u5pkb4i673kc unique (weaknesses_id);
alter table document_template add constraint UK2kh3auuuajd7paueuyknubire unique (doc_key);
alter table weakenesses_modifier_list add constraint UK_boirxsa74m8wlt3huadrpvn8c unique (modifier_list_id);
alter table abilities_magic add constraint FKnwhnyq565gaf5y5s8o7mreegb foreign key (magic_id) references magic (id);
alter table abilities_magic add constraint FKncsjr27j30kk6sscmkft9mns4 foreign key (ability_id) references abilities (id);
alter table abilities_modifier_list add constraint FK48t36e3s2x7emmxqjdvwsipry foreign key (modifier_list_id) references chars_attributes_modifiers (id);
alter table abilities_modifier_list add constraint FKe56uan6vue0j5d5yk6fjge3uj foreign key (ability_id) references abilities (id);
alter table attacks_perks_and_flaws add constraint FKktnmtwqaif3x0gekh88hi6ykg foreign key (perks_and_flaws_id) references perks (id);
alter table attacks_perks_and_flaws add constraint FKi2cdq353ctl7hfjw5cdn05ni7 foreign key (attack_id) references attacks (id);
alter table character_sheets add constraint FK821nk8nfvtt57wdxir55lq6wf foreign key (app_user_id) references app_users (id);
alter table character_sheets_abilities add constraint FKh61dkq9xgpxswen4350jh5u3b foreign key (abilities_id) references abilities (id);
alter table character_sheets_abilities add constraint FKosmhojjmick1ebfh2lpyxrl0l foreign key (character_sheet_id) references character_sheets (id);
alter table character_sheets_attacks add constraint FKq4d21b1hgdweg0qqskl54hvqi foreign key (attacks_id) references attacks (id);
alter table character_sheets_attacks add constraint FKkv82a8d6wja3qp5wgb7efv7rg foreign key (character_sheet_id) references character_sheets (id);
alter table character_sheets_weaknesses add constraint FK54i7b31fqdj5o1v7h30yxbjv0 foreign key (weaknesses_id) references weakenesses (id);
alter table character_sheets_weaknesses add constraint FK2k8v4gx5q9jagdoten63koa8s foreign key (character_sheet_id) references character_sheets (id);
alter table tokens add constraint FKssoclj554j37h8cofgeis7e8w foreign key (user_id) references app_users (id);
alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
alter table user_roles add constraint FKaf154i5th4vvgbahf8b8pa688 foreign key (user_id) references app_users (id);
alter table weakenesses_modifier_list add constraint FKjfh3w7sxban4h26vv0yskmsi0 foreign key (modifier_list_id) references chars_attributes_modifiers (id);
alter table weakenesses_modifier_list add constraint FKqc2gf991pv507oi50iuajq0eb foreign key (weakness_id) references weakenesses (id);