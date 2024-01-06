create table public.survey_config_detail
(
    id           integer      default nextval('survey_config_detail_seq'::regclass) not null
        constraint survey_config_detail_pk
            primary key,
    survey_id    varchar(200)                                                       not null,
    config_id    varchar(200),
    is_deleted   integer      default 0                                             not null,
    created_by   varchar(200) default 'sys'::character varying                      not null,
    created_time timestamp    default (now())::timestamp without time zone          not null,
    updated_by   varchar(200) default 'sys'::character varying                      not null,
    updated_time timestamp    default (now())::timestamp without time zone          not null
);

comment on table public.survey_config_detail is '问卷设置详情表';

comment on column public.survey_config_detail.config_id is '配置id';

alter table public.survey_config_detail
    owner to postgres;

create unique index survey_config_detail_survey_id_config_id_uindex
    on public.survey_config_detail (survey_id, config_id);

