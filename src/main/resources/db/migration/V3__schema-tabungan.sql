create table tabungan
(
    id          character varying(64) primary key,
    no_rekening character varying(20) not null unique,
    nasabah_id  character varying(64) not null,
    saldo       numeric(8, 2)         not null default 0,
    foreign key (no_rekening) references nasabah (id) on delete cascade on update cascade
);