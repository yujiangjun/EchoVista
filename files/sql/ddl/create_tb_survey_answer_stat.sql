create table public.survey_answer_stat (
                                           id integer primary key not null default nextval('survey_answer_stat_seq'::regclass),
                                           survey_id character varying(255) not null, -- 问卷id
                                           ques_id character varying(255) not null, -- 问题id
                                           answer_count integer default 0, -- 回答人数
                                           is_deleted integer not null default 0,
                                           created_by character varying(255) not null default 'sys',
                                           created_time timestamp without time zone not null default (now())::timestamp without time zone,
                                           updated_by character varying(255),
                                           updated_time timestamp without time zone not null default (now())::timestamp without time zone
);
create unique index survey_answer_stat_survey_id_ques_id_uindex on survey_answer_stat using btree (survey_id, ques_id);
comment on table public.survey_answer_stat is '答卷统计详情表';
comment on column public.survey_answer_stat.survey_id is '问卷id';
comment on column public.survey_answer_stat.ques_id is '问题id';
comment on column public.survey_answer_stat.answer_count is '回答人数';

