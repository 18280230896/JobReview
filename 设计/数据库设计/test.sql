/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/7 21:27:32                            */
/*==============================================================*/


drop table if exists t_admin;

drop table if exists t_class;

drop table if exists t_class_task;

drop table if exists t_group;

drop table if exists t_group_student;

drop table if exists t_student;

drop table if exists t_subject;

drop table if exists t_subject_studnet;

drop table if exists t_task;

drop table if exists t_task_file;

drop table if exists t_task_score;

drop table if exists t_teacher;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   admin_id             int not null auto_increment,
   admin_name           varchar(20) not null,
   admin_uname          varchar(20) not null,
   admin_pwd            varchar(30) not null,
   primary key (admin_id)
);

/*==============================================================*/
/* Table: t_class                                               */
/*==============================================================*/
create table t_class
(
   class_id             int not null auto_increment,
   teacher_id           int,
   class_name           varchar(20),
   primary key (class_id)
);

/*==============================================================*/
/* Table: t_class_task                                          */
/*==============================================================*/
create table t_class_task
(
   ct_id                int not null auto_increment,
   task_id              int,
   class_id             int,
   ct_type              int,
   ct_start_time        datetime,
   ct_end_time          datetime,
   primary key (ct_id)
);

/*==============================================================*/
/* Table: t_group                                               */
/*==============================================================*/
create table t_group
(
   group_id             int not null auto_increment,
   class_id             int,
   group_num            varchar(30),
   group_name           varchar(30),
   primary key (group_id)
);

/*==============================================================*/
/* Table: t_group_student                                       */
/*==============================================================*/
create table t_group_student
(
   gs_id                int not null auto_increment,
   student_id           int,
   group_id             int,
   primary key (gs_id)
);

/*==============================================================*/
/* Table: t_student                                             */
/*==============================================================*/
create table t_student
(
   student_id           int not null auto_increment,
   class_id             int,
   student_name         varchar(20),
   studnet_uname        varchar(20),
   student_pwd          varchar(30),
   primary key (student_id)
);

/*==============================================================*/
/* Table: t_subject                                             */
/*==============================================================*/
create table t_subject
(
   subject_id           int not null auto_increment,
   task_id              int,
   subject_name         varchar(255),
   primary key (subject_id)
);

/*==============================================================*/
/* Table: t_subject_studnet                                     */
/*==============================================================*/
create table t_subject_studnet
(
   ss_id                int not null auto_increment,
   subject_id           int,
   student_id           int,
   primary key (ss_id)
);

/*==============================================================*/
/* Table: t_task                                                */
/*==============================================================*/
create table t_task
(
   task_id              int not null auto_increment,
   teacher_id           int,
   task_name            varchar(30),
   task_type            int,
   primary key (task_id)
);

/*==============================================================*/
/* Table: t_task_file                                           */
/*==============================================================*/
create table t_task_file
(
   file_id              int not null auto_increment,
   subject_id           int,
   student_id           int,
   file_name            varchar(30),
   file_path            varchar(30),
   primary key (file_id)
);

/*==============================================================*/
/* Table: t_task_score                                          */
/*==============================================================*/
create table t_task_score
(
   score_id             int not null auto_increment,
   student_id           int,
   ct_id                int,
   score_num            int,
   primary key (score_id)
);

/*==============================================================*/
/* Table: t_teacher                                             */
/*==============================================================*/
create table t_teacher
(
   teacher_id           int not null auto_increment,
   teacher_name         varchar(20),
   teacher_uname        varchar(20),
   teacher_pwd          varchar(20),
   primary key (teacher_id)
);

alter table t_class add constraint FK_Relationship_1 foreign key (teacher_id)
      references t_teacher (teacher_id) on delete restrict on update restrict;

alter table t_class_task add constraint FK_Relationship_7 foreign key (task_id)
      references t_task (task_id) on delete restrict on update restrict;

alter table t_class_task add constraint FK_Relationship_8 foreign key (class_id)
      references t_class (class_id) on delete restrict on update restrict;

alter table t_group add constraint FK_Relationship_3 foreign key (class_id)
      references t_class (class_id) on delete restrict on update restrict;

alter table t_group_student add constraint FK_Relationship_4 foreign key (group_id)
      references t_group (group_id) on delete restrict on update restrict;

alter table t_group_student add constraint FK_Relationship_5 foreign key (student_id)
      references t_student (student_id) on delete restrict on update restrict;

alter table t_student add constraint FK_Relationship_2 foreign key (class_id)
      references t_class (class_id) on delete restrict on update restrict;

alter table t_subject add constraint FK_Relationship_9 foreign key (task_id)
      references t_task (task_id) on delete restrict on update restrict;

alter table t_subject_studnet add constraint FK_Relationship_10 foreign key (subject_id)
      references t_subject (subject_id) on delete restrict on update restrict;

alter table t_subject_studnet add constraint FK_Relationship_11 foreign key (student_id)
      references t_student (student_id) on delete restrict on update restrict;

alter table t_task add constraint FK_Relationship_6 foreign key (teacher_id)
      references t_teacher (teacher_id) on delete restrict on update restrict;

alter table t_task_file add constraint FK_Relationship_12 foreign key (subject_id)
      references t_subject (subject_id) on delete restrict on update restrict;

alter table t_task_file add constraint FK_Relationship_13 foreign key (student_id)
      references t_student (student_id) on delete restrict on update restrict;

alter table t_task_score add constraint FK_Relationship_14 foreign key (ct_id)
      references t_class_task (ct_id) on delete restrict on update restrict;

alter table t_task_score add constraint FK_Relationship_15 foreign key (student_id)
      references t_student (student_id) on delete restrict on update restrict;

