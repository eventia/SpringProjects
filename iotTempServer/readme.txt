readme

IoT Temperatur Server

DB ����
id : scott1
pw : tiger1
table  iottemp

drop table iottemp;
create table iottemp(
  MID NUMBER(4) primary key,
  MDEVICE varchar2(10),
  MVALUE varchar2(10),
  MDATE date default sysdate
);

drop SEQUENCE iottemp_seq;
CREATE SEQUENCE iottemp_seq;

commit;

