create sequence public.folder_seq
    as integer
    maxvalue 999999999;

alter sequence public.folder_seq owner to postgres;