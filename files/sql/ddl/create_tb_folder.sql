create table public.folder
(
    id                  integer      default nextval('folder_seq'::regclass)      not null
        constraint folder_pk
            primary key,
    folder_code         integer                                                   not null,
    folder_name         varchar(500)                                              not null,
    folder_partent_code bigint                                                    not null,
    folder_parent_name  varchar(200)                                              not null,
    icon                varchar(500),
    owner_id            varchar(200)                                              not null,
    created_by          varchar(200) default 'sys'::character varying             not null,
    created_time        timestamp    default (now())::timestamp without time zone not null,
    updated_by          varchar(200) default 'sys'::character varying             not null,
    updated_time        timestamp    default (now())::timestamp without time zone not null,
    is_deleted          integer      default 0                                    not null,
    external_data       varchar(500)
);

comment on table public.folder is '个人目录';

comment on column public.folder.folder_code is '目录code';

comment on column public.folder.folder_name is '目录名称';

comment on column public.folder.folder_partent_code is '父目录code';

comment on column public.folder.folder_parent_name is '父目录名称';

comment on column public.folder.icon is '目录icon';

comment on column public.folder.owner_id is '拥有者id';

alter table public.folder
    owner to postgres;

create unique index folder_folder_code_uindex
    on public.folder (folder_code);

