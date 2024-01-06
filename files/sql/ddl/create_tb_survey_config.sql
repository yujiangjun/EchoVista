create table public.survey_config
(
    id                integer      default nextval('survey_config_seq'::regclass) not null,
    config_id         varchar(200)                                                not null,
    config_cat_desc   varchar(100)                                                not null,
    config_code       integer                                                     not null,
    config_name       varchar(200)                                                not null,
    config_value_type integer      default 1                                      not null,
    config_order      integer      default 0                                      not null,
    is_deleted        integer      default 0                                      not null,
    created_by        varchar(200) default 'sys'::character varying               not null,
    created_time      timestamp    default (now())::timestamp without time zone   not null,
    updated_by        varchar(200) default 'sys'::character varying               not null,
    updated_time      timestamp    default (now())::timestamp without time zone   not null
);

comment on table public.survey_config is '问卷配置表';

comment on column public.survey_config.config_id is '配置id';

comment on column public.survey_config.config_cat_desc is '配置分类描述';

comment on column public.survey_config.config_code is '配置code';

comment on column public.survey_config.config_name is '配置名称';

comment on column public.survey_config.config_value_type is '配置项值类型 1 bool 2 int 3 other';

comment on column public.survey_config.config_order is '配置项序号';

alter table public.survey_config
    owner to postgres;

