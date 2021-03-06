SELECT USER
FROM DUAL;
--==>> SCOTT

DESC TBL_MEMBERLIST;

DROP TABLE TBL_MEMBERLIST;
--==>> Table TBL_MEMBERLIST이(가) 삭제되었습니다.
DROP SEQUENCE MEMBERLISTSEQ;
--==>> Sequence MEMBERLISTSEQ이(가) 삭제되었습니다.


--○ 실습 테이블 생성(TBL_MEMBERLIST)
CREATE TABLE TBL_MEMBERLIST
( MID       NUMBER
, NAME      VARCHAR2(30)
, TELEPHONE VARCHAR2(50)
, CONSTRAINT MEMEBERLIST_MID_PK PRIMARY KEY(MID)
);
--==>> Table TBL_MEMBERLIST이(가) 생성되었습니다.


--○ 시퀀스 생성
CREATE SEQUENCE MEMBERLISTSEQ
NOCACHE;
--==>> Sequence MEMBERLISTSEQ이(가) 생성되었습니다.


--○ 샘플 데이터 입력
INSERT INTO TBL_MEMBERLIST(MID, NAME, TELEPHONE) VALUES(MEMBERLISTSEQ.NEXTVAL, '최현정', '010-5678-5678');

INSERT INTO TBL_MEMBERLIST(MID, NAME, TELEPHONE) 
VALUES(MEMBERLISTSEQ.NEXTVAL, '정효진', '010-1234-1234');
--==>> 1 행 이(가) 삽입되었습니다. * 2


--○ 데이터 조회
SELECT MID, NAME, TELEPHONE
FROM TBL_MEMBERLIST
ORDER BY MID;

SELECT MID, NAME, TELEPHONE FROM TBL_MEMBERLIST ORDER BY MID
;
--==>>
/*
1	최현정	010-5678-5678
2	정효진	010-1234-1234
*/


--○ 인원 수 조회 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBERlIST;

SELECT COUNT(*) AS COUNT FROM TBL_MEMBERlIST
;
--==>> 2

--○ 커밋
COMMIT;