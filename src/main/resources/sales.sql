--根据数据库说明书，创建商品销售表 SALES
---关于此表的建立可以参考博客上oracle分类中的文章，知识量有点大！

--oracle 不支持级联更新，真怂！
--注意，有外来键
CREATE TABLE sales
(
       sId  NUMBER(10) PRIMARY KEY,
                                          --外键必须是外表主键,
       gid   NUMBER(10) REFERENCES goods(gid)   NOT NULL,
       mId   NUMBER(10) REFERENCES salesman(sid) NOT NULL,
       sDate DATE DEFAULT SYSDATE NOT NULL, --表内数据改动时自动获取系统时间并同步到数据库
       sNum  NUMBER(11) NOT NULL
);

--生成序列

CREATE SEQUENCE gsales_seq
       START WITH      1
       INCREMENT BY    1
       MINVALUE        1
       MAXVALUE     100000
       NOCYCLE
       CACHE           10

--触发器

CREATE TRIGGER  gsales_trigger
       BEFORE INSERT ON gsales
       FOR EACH ROW
       BEGIN
           SELECT gsales_seq.nextval into :new.gsid FROM dual;
       END
commit;

# mysql
CREATE TABLE shopping.sales (
	sId int(10) not null,
	gId int(10) not null,
	mId int(10) not null,
	sDate datetime not null,
	sNum int(10) not null,
	primary key(sId),
	constraint fK_sales_goods foreign key(gId) references goods(gId),
	constraint fk_sales_salesman foreign key(mId) references salesman(mId)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- 触发器
CREATE TRIGGER sales_trigger
AFTER
INSERT ON sales
FOR EACH ROW
UPDATE goods SET gNum = gNum -new.sNum WHERE gId = new.gId;

CREATE TRIGGER add_trigger
AFTER
DELETE ON sales
FOR EACH row
UPDATE goods SET gNum = gNum +old.sNum WHERE gId = old.gId;

CREATE TRIGGER update_trigger
AFTER
UPDATE ON sales
FOR EACH row
UPDATE goods SET gNum = gNum -(new.sNum-old.sNum) WHERE gId = old.gId;

CREATE TRIGGER date_trigger
BEFORE
INSERT ON sales
FOR EACH row
	if new.sDate is null
	then
		set new.sDate = now();
	end if;

show triggers;
# DROP trigger goods_trigger;