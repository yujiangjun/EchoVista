create table public.survey_answer_item (
                                           id integer primary key not null default nextval('survey_answer_item_seq'::regclass),
                                           answer_id character varying(200) not null, -- 回答表id
                                           ques_id character varying(200) not null, -- 问题id
                                           answer_item_id character varying(200) not null, -- 回答明细id
                                           item_value character varying(200), -- 回答的值,可能是选项，也可能是输入的，用JSON对象保存
                                           is_deleted integer not null,
                                           created_by character varying(200) not null default 'sys',
                                           created_time timestamp without time zone not null default (now())::timestamp without time zone,
                                           updated_by character varying(200) not null default 'sys',
                                           updated_time timestamp without time zone not null default (now())::timestamp without time zone,
                                           ques_content_id integer not null -- 问题选项id
);
create index survey_answer_item_answer_id_index on survey_answer_item using btree (answer_id);
create unique index survey_answer_item_answer_item_id_uindex on survey_answer_item using btree (answer_item_id);
create index survey_answer_item_ques_id_index on survey_answer_item using btree (ques_id);
comment on table public.survey_answer_item is '问卷回答明细表';
comment on column public.survey_answer_item.answer_id is '回答表id';
comment on column public.survey_answer_item.ques_id is '问题id';
comment on column public.survey_answer_item.answer_item_id is '回答明细id';
comment on column public.survey_answer_item.item_value is '回答的值,可能是选项，也可能是输入的，用JSON对象保存';
comment on column public.survey_answer_item.ques_content_id is '问题选项id';

