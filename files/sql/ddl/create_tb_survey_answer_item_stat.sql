create table public.survey_answer_item_stat (
                                                id integer primary key not null default nextval('survey_answer_item_stat_seq'::regclass),
                                                answer_stat_id integer not null, -- 答卷问题统计id
                                                survey_answer_item_id integer not null, -- 问题选项id
                                                item_count integer not null, -- 该选项被选择数量
                                                is_deleted integer not null default 0,
                                                created_by character varying(255) not null default 'sys',
                                                created_time timestamp without time zone not null default (now())::timestamp without time zone,
                                                updated_by character varying(255) not null default 'sys',
                                                updated_time timestamp without time zone not null default (now())::timestamp without time zone,
                                                ques_content_id integer not null -- 问题选项id
);
create unique index survey_answer_item_stat_answer_stat_id_uindex on survey_answer_item_stat using btree (answer_stat_id);
create unique index survey_answer_item_stat_survey_answer_item_id_uindex on survey_answer_item_stat using btree (survey_answer_item_id);
comment on table public.survey_answer_item_stat is '答卷问题选项统计表';
comment on column public.survey_answer_item_stat.answer_stat_id is '答卷问题统计id';
comment on column public.survey_answer_item_stat.survey_answer_item_id is '问题选项id';
comment on column public.survey_answer_item_stat.item_count is '该选项被选择数量';
comment on column public.survey_answer_item_stat.ques_content_id is '问题选项id';

