create table public.survey_ques
(
    id            integer      default nextval('survey_ques_seq'::regclass) not null
        constraint survey_ques_pk
            primary key,
    ques_id       varchar(200)                                              not null,
    ques_code     varchar(1000)                                             not null,
    ques_title    varchar(500)                                              not null,
    survey_id     varchar(200)                                              not null,
    ques_order    integer      default 0                                    not null,
    external_data varchar(1000),
    is_deleted    integer      default 0                                    not null,
    created_by    varchar(200) default 'sys'::character varying             not null,
    created_time  timestamp    default (now())::timestamp without time zone not null,
    updated_by    varchar(200) default 'sys'::character varying             not null,
    updated_time  timestamp    default (now())::timestamp without time zone not null,
    is_must_oper  smallint     default 0                                    not null
);

comment on table public.survey_ques is '问卷问题表';

comment on column public.survey_ques.ques_id is '问题id';

comment on column public.survey_ques.ques_code is '问题编码';

comment on column public.survey_ques.ques_title is '问题标题';

comment on column public.survey_ques.survey_id is '问卷id';

comment on column public.survey_ques.ques_order is '问题序号';

comment on column public.survey_ques.is_must_oper is '是否必填/选 0否1是';

alter table public.survey_ques
    owner to postgres;

create unique index survey_ques_ques_id_uindex
    on public.survey_ques (ques_id);

create index survey_ques_survey_id_index
    on public.survey_ques (survey_id);

