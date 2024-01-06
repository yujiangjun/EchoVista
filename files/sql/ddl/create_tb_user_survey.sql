create table public.user_survey
(
    id             integer      default nextval('user_survey_seq'::regclass) not null
        constraint user_survey_pk
            primary key,
    user_survey_id varchar(200)                                              not null,
    survey_title   varchar(200),
    survey_desc    varchar(100)                                              not null,
    user_id        varchar(200)                                              not null,
    folder_id      varchar(200),
    is_deleted     integer,
    created_by     varchar(200) default 'sys'::character varying             not null,
    created_time   timestamp    default (now())::timestamp without time zone not null,
    updated_by     varchar(200) default 'sys'::character varying             not null,
    updated_time   timestamp    default (now())::timestamp without time zone not null,
    status         integer                                                   not null
);

comment on table public.user_survey is '用户调查表';

comment on column public.user_survey.survey_title is '问卷标题';

comment on column public.user_survey.survey_desc is '副标题';

comment on column public.user_survey.user_id is '所属用户';

comment on column public.user_survey.folder_id is '所属目录';

comment on column public.user_survey.status is '问卷状态 0 初始化 1 草稿 2 已发布 3 停止收集';

alter table public.user_survey
    owner to postgres;

create index user_survey_user_id_index
    on public.user_survey (user_id);

create unique index user_survey_user_survey_id_user_id_folder_id_uindex
    on public.user_survey (user_survey_id, user_id, folder_id);

