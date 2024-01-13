create table public.survey_answer
(
    id           integer      default nextval('survey_answer_seq'::regclass) not null
        constraint survey_answer_pk
            primary key,
    ip           varchar(200),
    location     varchar(200),
    answer_date  timestamp    default (now())::timestamp without time zone   not null,
    survey_id    varchar(200),
    is_deleted   integer      default 0                                      not null,
    created_by   varchar(200) default 'sys'::character varying               not null,
    created_time timestamp    default (now())::timestamp without time zone   not null,
    updated_by   varchar(200) default 'sys'::character varying               not null,
    updated_time timestamp    default (now())::timestamp without time zone   not null
);

comment on table public.survey_answer is '回答基础表';

comment on column public.survey_answer.location is '归属地';

comment on column public.survey_answer.answer_date is '回答时间';

comment on column public.survey_answer.survey_id is '问卷id';

alter table public.survey_answer
    owner to postgres;

create index survey_answer_survey_id_index
    on public.survey_answer (survey_id);

