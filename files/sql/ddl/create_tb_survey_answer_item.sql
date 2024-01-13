create table public.survey_answer_item
(
    id             integer      default nextval('survey_answer_item_seq'::regclass) not null
        constraint survey_answer_item_pk
            primary key,
    answer_id      varchar(200)                                                     not null,
    ques_id        varchar(200)                                                     not null,
    answer_item_id varchar(200)                                                     not null,
    item_value     varchar(200),
    is_deleted     integer                                                          not null,
    created_by     varchar(200) default 'sys'::character varying                    not null,
    created_time   timestamp    default (now())::timestamp without time zone        not null,
    updated_by     varchar(200) default 'sys'::character varying                    not null,
    updated_time   timestamp    default (now())::timestamp without time zone        not null
);

comment on table public.survey_answer_item is '问卷回答明细表';

comment on column public.survey_answer_item.answer_id is '回答表id';

comment on column public.survey_answer_item.ques_id is '问题id';

comment on column public.survey_answer_item.answer_item_id is '回答明细id';

comment on column public.survey_answer_item.item_value is '回答的值,可能是选项，也可能是输入的，用JSON对象保存';

alter table public.survey_answer_item
    owner to postgres;

create index survey_answer_item_answer_id_index
    on public.survey_answer_item (answer_id);

create unique index survey_answer_item_answer_item_id_uindex
    on public.survey_answer_item (answer_item_id);

create index survey_answer_item_ques_id_index
    on public.survey_answer_item (ques_id);

