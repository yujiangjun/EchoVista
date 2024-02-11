create table public.user_survey (
                                    id integer primary key not null default nextval('user_survey_seq'::regclass),
                                    user_survey_id character varying(200) not null,
                                    survey_title character varying(200), -- 问卷标题
                                    survey_desc character varying(100) not null, -- 副标题
                                    user_id character varying(200) not null, -- 所属用户
                                    folder_id character varying(200), -- 所属目录
                                    is_deleted integer,
                                    created_by character varying(200) not null default 'sys',
                                    created_time timestamp without time zone not null default (now())::timestamp without time zone,
                                    updated_by character varying(200) not null default 'sys',
                                    updated_time timestamp without time zone not null default (now())::timestamp without time zone,
                                    status integer not null, -- 问卷状态 0 初始化 1 草稿 2 已发布 3 停止收集
                                    survey_url character varying(255), -- 问卷地址
                                    survey_mobile_url character varying(255) -- 手机问卷地址
);
create index user_survey_user_id_index on user_survey using btree (user_id);
create unique index user_survey_user_survey_id_user_id_folder_id_uindex on user_survey using btree (user_survey_id, user_id, folder_id);
comment on table public.user_survey is '用户调查表';
comment on column public.user_survey.survey_title is '问卷标题';
comment on column public.user_survey.survey_desc is '副标题';
comment on column public.user_survey.user_id is '所属用户';
comment on column public.user_survey.folder_id is '所属目录';
comment on column public.user_survey.status is '问卷状态 0 初始化 1 草稿 2 已发布 3 停止收集';
comment on column public.user_survey.survey_url is '问卷地址';
comment on column public.user_survey.survey_mobile_url is '手机问卷地址';

