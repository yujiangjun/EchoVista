create table public.config_dict
(
    id            integer      default nextval('config_dict_seq'::regclass) not null
        constraint config_dict_pk
            primary key,
    type_code     integer                                                   not null,
    type_name     varchar(200)                                              not null,
    dict_code     integer                                                   not null,
    dict_name     varchar(200)                                              not null,
    external_data varchar(1000)                                             ,
    is_deleted    integer      default 0                                    not null,
    created_by    varchar(200) default 'sys'::character varying             not null,
    created_time  timestamp    default (now())::timestamp without time zone not null,
    updated_by    varchar(200) default 'sys'::character varying             not null,
    updated_time  timestamp    default (now())::timestamp without time zone not null
);

comment on table public.config_dict is '配置字典表';

comment on column public.config_dict.type_code is '类型编码';

comment on column public.config_dict.type_name is '类型名称';

comment on column public.config_dict.dict_code is '字典编码';

comment on column public.config_dict.dict_name is '字典名称';

comment on column public.config_dict.external_data is '字典拓展JSON';

alter table public.config_dict
    owner to postgres;

create unique index config_dict_dict_code_type_code_uindex
    on public.config_dict (dict_code, type_code);

