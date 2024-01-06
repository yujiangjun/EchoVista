create table public.cat_question
(
    id            integer      default nextval('cat_question'::regclass)    not null
        constraint cat_question_pk
            primary key,
    cat_code      integer,
    cat_name      varchar(100)                                              not null,
    ques_code     integer,
    ques_name     varchar(200),
    ques_name_en  varchar(200),
    icon          varchar(1000),
    ques_order    integer,
    ques_type     integer,
    is_deleted    integer      default 0                                    not null,
    created_by    varchar(200) default 'sys'::character varying             not null,
    created_time  timestamp    default (now())::timestamp without time zone not null,
    updated_by    varchar(200) default 'sys'::character varying             not null,
    updated_time  timestamp    default (now())::timestamp without time zone not null,
    survey_type   varchar(200),
    external_data varchar(100)
);

comment on table public.cat_question is '题目分类库';

comment on column public.cat_question.cat_code is '分类code';

comment on column public.cat_question.cat_name is '分类名称';

comment on column public.cat_question.ques_code is '题型code';

comment on column public.cat_question.ques_name is '题型名称';

comment on column public.cat_question.ques_name_en is '题型名称en';

comment on column public.cat_question.icon is '题型icon';

comment on column public.cat_question.ques_order is '题型序号';

comment on column public.cat_question.ques_type is '题型类型 1 input 2 select 3 multi select 4 upload';

comment on column public.cat_question.survey_type is '问卷类型';

alter table public.cat_question
    owner to postgres;

create unique index cat_question_cat_code_ques_code_uindex
    on public.cat_question (cat_code, ques_code);

