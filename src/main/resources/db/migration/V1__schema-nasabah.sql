create table nasabah
(
    id            character varying(64) primary key,
    cif           character varying(10) not null unique,
    nama_depan    character varying(50) not null,
    nama_belakang character varying(100),
    tgl_lahir     date                  not null,
    created_date  timestamp
);