SELECT USER
FROM DUAL;

--�� ���̺� ����
CREATE TABLE TBL_STUDENT
( SID   NUMBER			-- PK
, NAME	VARCHAR2(30)
, TEL	VARCHAR2(30)
);

ALTER TABLE TBL_STUDENT
ADD CONSTRAINT TBL_STUDENT_SID_PK PRIMARY KEY (SID);

CREATE SEQUENCE STUDENTSEQ
NOCACHE;


CREATE TABLE TBL_GRADE
( SID	NUMBER	    	-- PK / FK
, SUB1	NUMBER(3)
, SUB2	NUMBER(3)
, SUB3	NUMBER(3)
, CONSTRAINT TBL_GRADE_SID_PK PRIMARY KEY (SID)
, CONSTRAINT TBL_GRADE_SID_FK FOREIGN KEY (SID)
             REFERENCES TBL_STUDENT (SID)
);


--�� ������ �Է�
INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '���ʿ�', '010-1234-5678');

INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '������', '010-5582-9982');

INSERT INTO TBL_STUDENT(SID, NAME, TEL)
VALUES(STUDENTSEQ.NEXTVAL, '������', '010-6111-1232');


INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(1, 100, 80, 70);

INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(2, 60, 50, 60);

INSERT INTO TBL_GRADE(SID, SUB1, SUB2, SUB3)
VALUES(3, 20, 90, 70);

COMMIT;


--�ۺ� ����
CREATE OR REPLACE VIEW STUDENTVIEW
AS
SELECT SID, NAME, TEL, ( SELECT COUNT(*)
                         FROM TBL_GRADE
                         WHERE SID= T.SID) AS SUB
FROM TBL_STUDENT T;


CREATE OR REPLACE VIEW GRADEVIEW
AS
SELECT S.SID, S.NAME, G.SUB1 AS SUB1, G.SUB2 AS SUB2, G.SUB3 AS SUB3
     , (G.SUB1 + G.SUB2 + G.SUB3) AS TOT
     , TRUNC((G.SUB1 + G.SUB2 + G.SUB3)/3, 1) AS AVG
     , CASE WHEN G.SUB1 <= 40 OR G.SUB2 <= 40 OR G.SUB3 <= 40 THEN '����'
            WHEN ROUND((G.SUB1 + G.SUB2 + G.SUB3)/3, 1) < 60 THEN '���հ�'
            ELSE '�հ�'
       END AS CH
FROM TBL_STUDENT S
RIGHT JOIN TBL_GRADE G
ON S.SID = G.SID;


--�� ������
SELECT SID, NAME, TEL
FROM STUDENTVIEW
where sid=1;

SELECT SID, NAME, SUB1, SUB2, SUB3, TOT, AVG, CH
FROM GRADEVIEW;

select count(*) as count
from tbl_student;