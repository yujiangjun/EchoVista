create sequence public.user_survey_seq
    as integer
    maxvalue 999999999;

alter sequence public.user_survey_seq owner to postgres;