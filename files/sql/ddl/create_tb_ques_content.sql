create table public.ques_content
(
    id                 integer   default nextval('survey_content_seq'::regclass) not null
        constraint ques_content_pk
            primary key,
    content_id         varchar(200),
    ques_id            integer                                                   not null,
    content_item_label integer,
    content_item_value varchar(50),
    content_order      integer                                                   not null,
    is_deleted         integer   default 0                                       not null,
    created_by         varchar(200),
    created_time       timestamp default (now())::timestamp without time zone    not null,
    updated_by         varchar(200)                                              not null,
    updated_time       timestamp default (now())::timestamp without time zone    not null
);

comment on table public.ques_content is '问题内容表';

comment on column public.ques_content.content_id is '问题内容id';

comment on column public.ques_content.ques_id is '问题id';

comment on column public.ques_content.content_item_label is '问题显示';

comment on column public.ques_content.content_item_value is '问题内容value';

comment on column public.ques_content.content_order is '序号';

alter table public.ques_content
    owner to postgres;

create unique index ques_content_content_id_uindex
    on public.ques_content (content_id);

create index ques_content_ques_id_content_id_index
    on public.ques_content (ques_id, content_id);

