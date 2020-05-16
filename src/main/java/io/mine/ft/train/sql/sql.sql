-- 互动：
-- interact interact
-- interact_name interactName
drop table t_interact
create table t_interact(   -- Interact
   interact_id          integer     primary key,     -- interactId
   interact_name        varchar(50),-- 互动标题
   interact_detail      varchar(2000),-- 互动详细内容
   department          varchar(50),-- 学生院系
   student_name           varchar(10),-- 学生名称							5
   teacher_name         varchar(10),-- 老师名称
   flag_answer         char(1),-- 是否回复
   answer_content        varchar(2000),-- 回复内容
   flag_estimate       char(1),-- 是否评价
   estimate_content    varchar(2000),-- 评价内容						10
   tuid                 integer,-- 老师id
   sid                 integer,-- 学生id
   score                double(5,2),-- 评分
   create_date          timestamp,-- 互动创建时间
   answer_time         timestamp,-- 回复时间											15
   estimate_time       timestamp,-- 评价时间
   teacher_department   varchar(50),-- 老师院系
   flag_teacher_accusation char(1),-- 老师是否举报
   flag_student_accusation char(1)-- 学生是否举报
);

insert into t_interact values(1001,'夸克的质量计算',null,null,'霁月','郭靖','y',null,null,null,
null,1,null,DATE_FORMAT('2015-2-4','yyyy-mm-dd'),DATE_FORMAT('2015-2-5','yyyy-mm-dd'),null,'物理系','n','n');

insert into t_interact values(1002,'洛伦茨变换条件？',null,null,'霁月','郭靖','n',null,null,null,
null,1,null,DATE_FORMAT('2015-1-15','yyyy-mm-dd'),null,null,'物理系','n','n');

insert into t_interact values(1003,'采光的角度',null,null,'霁月','小龙女','y',null,null,null,
null,1,null,DATE_FORMAT('2015-2-4','yyyy-mm-dd'),DATE_FORMAT('2015-2-5','yyyy-mm-dd'),null,'艺术系','n','n');

insert into t_interact values(1004,'阴影与立体的关系?',null,null,'霁月','小龙女','n',null,null,null,
null,1,null,DATE_FORMAT('2015-1-15','yyyy-mm-dd'),null,null,'艺术系','n','n');

insert into t_interact values(1005,'独立主格结构?',null,null,'霁月','黄蓉','y',null,null,null,
null,1,null,DATE_FORMAT('2015-2-4','yyyy-mm-dd'),DATE_FORMAT('2015-2-5','yyyy-mm-dd'),null,'外语系','n','n');

insert into t_interact values(1006,'非谓语动词有被动式吗？',null,null,'霁月','黄蓉','n',null,null,null,
null,1,null,DATE_FORMAT('2015-1-15','yyyy-mm-dd'),null,null,'外语系','n','n');

insert into t_interact values(1007,'无穷级数的收敛条件？',null,null,'霁月','李莫愁','y',null,null,null,
null,1,null,DATE_FORMAT('2015-2-4','yyyy-mm-dd'),DATE_FORMAT('2015-2-5','yyyy-mm-dd'),null,'数学系','n','n');

insert into t_interact values(1008,'拉普拉斯变换条件？',null,null,'霁月','李莫愁','n',null,null,null,
null,1,null,DATE_FORMAT('2015-1-15','yyyy-mm-dd'),null,null,'数学系','n','n');

insert into t_interact values(1009,'熵的计算？',null,null,'霁月','黄药师','y',null,null,null,
null,1,null,DATE_FORMAT('2015-2-4','yyyy-mm-dd'),DATE_FORMAT('2015-2-5','yyyy-mm-dd'),null,'化学系','n','n');

insert into t_interact values(1010,'氧化还原反应的能量计算？',null,null,'霁月','黄药师','n',null,null,null,
null,1,null,DATE_FORMAT('2015-1-15','yyyy-mm-dd'),null,null,'化学系','n','n');


-- 创建序列
create sequence interact_seq start with 5000;
drop sequence interact_seq;
select interact_seq.nextval from dual;



-- 举报：
create table t_accusation (
   accusation_id  integer primary key,
   teacher_accusation_content varchar(1000),-- 老师举报内容
   student_accusation_time timestamp,-- 学生举报时间
   teacher_accusation_time timestamp,-- 老师举报时间
   i_id  integer  unique references t_interact(INTERACT_ID) ,-- 举报的互动id
   student_accusation_content varchar(1000)-- 学生举报内容
);

create sequence accusation_seq start with 10;
delete from t_accusation

-- 用户：
create table t_user(
	user_id integer primary key,
	username varchar(50),-- 用户名
	password varchar(50),-- 密码
	realname varchar(10),-- 真名
	department varchar(50),-- 院系
	role varchar(10) check (role in('student','teacher'))-- 学生/教师
);

select *from t_user

delete from t_user

insert into t_user values(1,'霁月',100001,'小武','物理系','student');

insert into t_user values(2,'望月',100006,'郭靖','物理系','teacher');
insert into t_user values(3,'拜月',100007,'小龙女','艺术系','teacher');
insert into t_user values(4,'射月',100008,'黄蓉','外语系','teacher');
insert into t_user values(5,'秋月',100008,'李莫愁','数学系','teacher');
insert into t_user values(6,'花月',100008,'黄药师','化学系','teacher');

create sequence user_seq;
-- 课程表：
create table t_course(
	course_id integer(5) primary key,
	course_name varchar(50)-- 课程名
);
create sequence course_seq;

delete from t_course
select * from t_course

insert into t_course values(102,'核物理');
insert into t_course values(112,'量子力学');
insert into t_course values(103,'素描');
insert into t_course values(113,'油画');
insert into t_course values(104,'英文');
insert into t_course values(114,'日文');
insert into t_course values(105,'微积分');
insert into t_course values(115,'复分析');
insert into t_course values(106,'无机化学');
insert into t_course values(116,'有机化学');


-- 课程关系表：
create table course_user(
	primary key(u_id,c_id),
        u_id integer  REFERENCES t_user(user_id),
		c_id integer REFERENCES t_course(course_id)
      );

delete from course_user ;
select * from course_user;

insert into course_user values(2,102);
insert into course_user values(2,112);
insert into course_user values(3,103);
insert into course_user values(3,113);
insert into course_user values(4,104);
insert into course_user values(4,114);
insert into course_user values(5,105);
insert into course_user values(5,115);
insert into course_user values(6,106);
insert into course_user values(6,116);



