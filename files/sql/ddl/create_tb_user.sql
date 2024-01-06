create table public."user" (
                               id integer primary key not null default nextval('id_seq'::regclass),
                               user_id character varying(200) not null, -- 用户id
                               password character varying(200) not null, -- 密码
                               user_name character varying(200) not null, -- 用户名
                               email character varying(500),
                               full_name character varying(500), -- 全名称
                               is_active integer not null default 0, -- 是否激活 1是 0否
                               is_deleted integer not null default 0, -- 是否删除 1是0否
                               created_by character varying not null default 'sys',
                               created_time timestamp without time zone default (now())::timestamp without time zone,
                               updated_by character varying default 'sys',
                               updated_time timestamp without time zone default (now())::timestamp without time zone
);
create unique index user_id__index on "user" using btree (user_id);
comment on column public."user".user_id is '用户id';
comment on column public."user".password is '密码';
comment on column public."user".user_name is '用户名';
comment on column public."user".full_name is '全名称';
comment on column public."user".is_active is '是否激活 1是 0否';
comment on column public."user".is_deleted is '是否删除 1是0否';

