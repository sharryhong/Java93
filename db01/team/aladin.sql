-- 판매자
DROP TABLE IF EXISTS TABLE RESTRICT;

-- 구매자
DROP TABLE IF EXISTS TABLE2 RESTRICT;

-- 책정보
DROP TABLE IF EXISTS TABLE3 RESTRICT;

-- 장바구니
DROP TABLE IF EXISTS TABLE4 RESTRICT;

-- 주문과정
DROP TABLE IF EXISTS TABLE5 RESTRICT;

-- 게시판
DROP TABLE IF EXISTS TABLE6 RESTRICT;

-- 배송
DROP TABLE IF EXISTS TABLE7 RESTRICT;

-- 1:1문의
DROP TABLE IF EXISTS TABLE8 RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS TABLE9 RESTRICT;

-- 주문
DROP TABLE IF EXISTS TABLE10 RESTRICT;

-- 판매내역
DROP TABLE IF EXISTS TABLE11 RESTRICT;

-- 보관함
DROP TABLE IF EXISTS TABLE12 RESTRICT;

-- 책정보사진
DROP TABLE IF EXISTS Temporary RESTRICT;

-- 리뷰사진
DROP TABLE IF EXISTS Temporary2 RESTRICT;

-- 주소
DROP TABLE IF EXISTS Temporary3 RESTRICT;

-- 구매서적
DROP TABLE IF EXISTS TABLE13 RESTRICT;

-- 회원
DROP TABLE IF EXISTS Temporary4 RESTRICT;

-- 판매자
CREATE TABLE TABLE (
	MNO  INTEGER     NOT NULL COMMENT '판매자번호', -- 판매자번호
	BCOM VARCHAR(50) NOT NULL COMMENT '출판사명', -- 출판사명
	BNUM INTEGER     NOT NULL COMMENT '사업자번호' -- 사업자번호
)
COMMENT '판매자';

-- 판매자
ALTER TABLE TABLE
	ADD CONSTRAINT PK_TABLE -- 판매자 기본키
		PRIMARY KEY (
			MNO -- 판매자번호
		);

-- 판매자 유니크 인덱스
CREATE UNIQUE INDEX UIX_TABLE
	ON TABLE ( -- 판매자
		BNUM ASC -- 사업자번호
	);

ALTER TABLE TABLE
	MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '판매자번호';

-- 구매자
CREATE TABLE TABLE2 (
	MNO INTEGER     NOT NULL COMMENT '구매자번호', -- 구매자번호
	NIC VARCHAR(50) NULL     COMMENT '닉네임', -- 닉네임
	BIR DATE        NOT NULL COMMENT '생년월일', -- 생년월일
	GEN CHAR(1)     NOT NULL COMMENT '성별' -- 성별
)
COMMENT '구매자';

-- 구매자
ALTER TABLE TABLE2
	ADD CONSTRAINT PK_TABLE2 -- 구매자 기본키
		PRIMARY KEY (
			MNO -- 구매자번호
		);

ALTER TABLE TABLE2
	MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '구매자번호';

-- 책정보
CREATE TABLE TABLE3 (
	BNO   INTEGER      NOT NULL COMMENT '책번호', -- 책번호
	BNAME VARCHAR(50)  NOT NULL COMMENT '책이름', -- 책이름
	PRICE INTEGER      NOT NULL COMMENT '가격', -- 가격
	CONT  MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	WRT   VARCHAR(50)  NOT NULL COMMENT '지은이', -- 지은이
	BCOM  VARCHAR(50)  NOT NULL COMMENT '출판사명', -- 출판사명
	PDT   DATETIME     NOT NULL COMMENT '발간일', -- 발간일
	INT   MEDIUMTEXT   NULL     COMMENT '소개', -- 소개
	GENR  VARCHAR(255) NOT NULL COMMENT '장르', -- 장르
	COUNT INTEGER      NOT NULL COMMENT '수량', -- 수량
	MNO   INTEGER      NOT NULL COMMENT '판매자번호' -- 판매자번호
)
COMMENT '책정보';

-- 책정보
ALTER TABLE TABLE3
	ADD CONSTRAINT PK_TABLE3 -- 책정보 기본키
		PRIMARY KEY (
			BNO -- 책번호
		);

ALTER TABLE TABLE3
	MODIFY COLUMN BNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '책번호';

-- 장바구니
CREATE TABLE TABLE4 (
	SBNO  INTEGER     NOT NULL COMMENT '장바구니번호', -- 장바구니번호
	BNAME VARCHAR(50) NOT NULL COMMENT '상품명', -- 상품명
	PRICE INTEGER     NOT NULL COMMENT '가격', -- 가격
	COUNT INTEGER     NOT NULL COMMENT '수량', -- 수량
	ONO   INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	BNO   INTEGER     NOT NULL COMMENT '책번호' -- 책번호
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE TABLE4
	ADD CONSTRAINT PK_TABLE4 -- 장바구니 기본키
		PRIMARY KEY (
			SBNO -- 장바구니번호
		);

ALTER TABLE TABLE4
	MODIFY COLUMN SBNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '장바구니번호';

-- 주문과정
CREATE TABLE TABLE5 (
	COL10 <데이터 타입 없음> NOT NULL COMMENT '주문과정번호', -- 주문과정번호
	COL   <데이터 타입 없음> NULL     COMMENT '상품명', -- 상품명
	COL2  <데이터 타입 없음> NULL     COMMENT '가격', -- 가격
	COL3  <데이터 타입 없음> NULL     COMMENT '수량', -- 수량
	COL4  <데이터 타입 없음> NULL     COMMENT '배송방법', -- 배송방법
	COL5  <데이터 타입 없음> NULL     COMMENT '결제방법', -- 결제방법
	COL6  <데이터 타입 없음> NULL     COMMENT '주문인', -- 주문인
	COL7  <데이터 타입 없음> NULL     COMMENT '주소', -- 주소
	COL8  <데이터 타입 없음> NULL     COMMENT '폰번호', -- 폰번호
	COL9  <데이터 타입 없음> NULL     COMMENT '메시지' -- 메시지
)
COMMENT '주문과정';

-- 주문과정
ALTER TABLE TABLE5
	ADD CONSTRAINT PK_TABLE5 -- 주문과정 기본키
		PRIMARY KEY (
			COL10 -- 주문과정번호
		);

-- 게시판
CREATE TABLE TABLE6 (
)
COMMENT '게시판';

-- 배송
CREATE TABLE TABLE7 (
	DNO      INTEGER      NOT NULL COMMENT '배송번호', -- 배송번호
	DCOM     VARCHAR(50)  NOT NULL COMMENT '배송회사', -- 배송회사
	IVNO     INTEGER      NOT NULL COMMENT '송장번호', -- 송장번호
	DDAY     DATETIME     NOT NULL COMMENT '배송일자', -- 배송일자
	DPAY     INTEGER      NOT NULL COMMENT '배송비', -- 배송비
	DET_ADDR VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	SNO      INTEGER      NOT NULL COMMENT '판매내역번호', -- 판매내역번호
	ARNO     INTEGER      NULL     COMMENT '주소번호' -- 주소번호
)
COMMENT '배송';

-- 배송
ALTER TABLE TABLE7
	ADD CONSTRAINT PK_TABLE7 -- 배송 기본키
		PRIMARY KEY (
			DNO -- 배송번호
		);

-- 배송 유니크 인덱스
CREATE UNIQUE INDEX UIX_TABLE7
	ON TABLE7 ( -- 배송
		IVNO ASC -- 송장번호
	);

ALTER TABLE TABLE7
	MODIFY COLUMN DNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '배송번호';

-- 1:1문의
CREATE TABLE TABLE8 (
	QNO  INTEGER      NOT NULL COMMENT '문의번호', -- 문의번호
	TITL VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	CONT MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	ANS  MEDIUMTEXT   NULL     COMMENT '답변', -- 답변
	CDT  DATETIME     NULL     COMMENT '등록일', -- 등록일
	ADT  DATETIME     NULL     COMMENT '답변일', -- 답변일
	MNO  INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '1:1문의';

-- 1:1문의
ALTER TABLE TABLE8
	ADD CONSTRAINT PK_TABLE8 -- 1:1문의 기본키
		PRIMARY KEY (
			QNO -- 문의번호
		);

ALTER TABLE TABLE8
	MODIFY COLUMN QNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '문의번호';

-- 리뷰
CREATE TABLE TABLE9 (
	RNO  INTEGER      NOT NULL COMMENT '리뷰번호', -- 리뷰번호
	TITL VARCHAR(255) NULL     COMMENT '제목', -- 제목
	CONT MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	STAR INTEGER      NULL     COMMENT '평점', -- 평점
	NIC  VARCHAR(50)  NULL     COMMENT '닉네임', -- 닉네임
	DATE DATETIME     NOT NULL COMMENT '날짜', -- 날짜
	LIKE CHAR(1)      NULL     COMMENT '공감', -- 공감
	MNO  INTEGER      NOT NULL COMMENT '구매자번호' -- 구매자번호
)
COMMENT '리뷰';

-- 리뷰
ALTER TABLE TABLE9
	ADD CONSTRAINT PK_TABLE9 -- 리뷰 기본키
		PRIMARY KEY (
			RNO -- 리뷰번호
		);

ALTER TABLE TABLE9
	MODIFY COLUMN RNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰번호';

-- 주문
CREATE TABLE TABLE10 (
	ONO      INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
	PDT      DATETIME     NOT NULL COMMENT '결제날짜', -- 결제날짜
	RNAME    VARCHAR(50)  NOT NULL COMMENT '수령인', -- 수령인
	PRD      VARCHAR(255) NOT NULL COMMENT '주문상품', -- 주문상품
	DET_ADDR VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
	COUNT    INTEGER      NOT NULL COMMENT '수량', -- 수량
	PRICE    INTEGER      NOT NULL COMMENT '가격', -- 가격
	PAYM     VARCHAR(50)  NOT NULL COMMENT '결제방법', -- 결제방법
	DELM     VARCHAR(50)  NOT NULL COMMENT '배송방법', -- 배송방법
	ETC      MEDIUMTEXT   NULL     COMMENT '기타사항', -- 기타사항
	ARNO     INTEGER      NULL     COMMENT '주소번호', -- 주소번호
	MNO      INTEGER      NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT '주문';

-- 주문
ALTER TABLE TABLE10
	ADD CONSTRAINT PK_TABLE10 -- 주문 기본키
		PRIMARY KEY (
			ONO -- 주문번호
		);

ALTER TABLE TABLE10
	MODIFY COLUMN ONO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문번호';

-- 판매내역
CREATE TABLE TABLE11 (
	SNO   INTEGER      NOT NULL COMMENT '판매내역번호', -- 판매내역번호
	CDT   DATETIME     NOT NULL COMMENT '등록일', -- 등록일
	PDT   DATETIME     NOT NULL COMMENT '결제날짜', -- 결제날짜
	SPRD  VARCHAR(255) NOT NULL COMMENT '판매상품', -- 판매상품
	COUNT INTEGER      NOT NULL COMMENT '수량', -- 수량
	PRICE INTEGER      NOT NULL COMMENT '가격', -- 가격
	EDT   DATETIME     NOT NULL COMMENT '종료일', -- 종료일
	ONO   INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
	MNO   INTEGER      NOT NULL COMMENT '판매자번호' -- 판매자번호
)
COMMENT '판매내역';

-- 판매내역
ALTER TABLE TABLE11
	ADD CONSTRAINT PK_TABLE11 -- 판매내역 기본키
		PRIMARY KEY (
			SNO -- 판매내역번호
		);

ALTER TABLE TABLE11
	MODIFY COLUMN SNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '판매내역번호';

-- 보관함
CREATE TABLE TABLE12 (
)
COMMENT '보관함';

-- 책정보사진
CREATE TABLE Temporary (
	BPNO INTEGER   NOT NULL COMMENT '책정보사진번호', -- 책정보사진번호
	PIC  VARBINARY NOT NULL COMMENT '사진', -- 사진
	BNO  INTEGER   NOT NULL COMMENT '책번호' -- 책번호
)
COMMENT '책정보사진';

-- 책정보사진
ALTER TABLE Temporary
	ADD CONSTRAINT PK_Temporary -- 책정보사진 기본키
		PRIMARY KEY (
			BPNO -- 책정보사진번호
		);

ALTER TABLE Temporary
	MODIFY COLUMN BPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '책정보사진번호';

-- 리뷰사진
CREATE TABLE Temporary2 (
	RPNO INTEGER   NOT NULL COMMENT '리뷰사진번호', -- 리뷰사진번호
	PIC  VARBINARY NULL     COMMENT '사진', -- 사진
	RNO  INTEGER   NULL     COMMENT '리뷰번호' -- 리뷰번호
)
COMMENT '리뷰사진';

-- 리뷰사진
ALTER TABLE Temporary2
	ADD CONSTRAINT PK_Temporary2 -- 리뷰사진 기본키
		PRIMARY KEY (
			RPNO -- 리뷰사진번호
		);

ALTER TABLE Temporary2
	MODIFY COLUMN RPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰사진번호';

-- 주소
CREATE TABLE Temporary3 (
	ARNO     INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
	PST_NO   VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
	BAS_ADDR VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE Temporary3
	ADD CONSTRAINT PK_Temporary3 -- 주소 기본키
		PRIMARY KEY (
			ARNO -- 주소번호
		);

ALTER TABLE Temporary3
	MODIFY COLUMN ARNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 구매서적
CREATE TABLE TABLE13 (
	BNO INTEGER NOT NULL COMMENT '책번호', -- 책번호
	MNO INTEGER NOT NULL COMMENT '구매자번호' -- 구매자번호
)
COMMENT '구매서적';

-- 구매서적
ALTER TABLE TABLE13
	ADD CONSTRAINT PK_TABLE13 -- 구매서적 기본키
		PRIMARY KEY (
			BNO -- 책번호
		);

ALTER TABLE TABLE13
	MODIFY COLUMN BNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '책번호';

-- 회원
CREATE TABLE Temporary4 (
	MNO      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	NAME     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	TEL      VARCHAR(30)  NOT NULL COMMENT '폰번호', -- 폰번호
	DET_ADDR VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	EMAIL    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	ARNO     INTEGER      NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '회원';

-- 회원
ALTER TABLE Temporary4
	ADD CONSTRAINT PK_Temporary4 -- 회원 기본키
		PRIMARY KEY (
			MNO -- 회원번호
		);

ALTER TABLE Temporary4
	MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 판매자
ALTER TABLE TABLE
	ADD CONSTRAINT FK_Temporary4_TO_TABLE -- 회원 -> 판매자
		FOREIGN KEY (
			MNO -- 판매자번호
		)
		REFERENCES Temporary4 ( -- 회원
			MNO -- 회원번호
		);

-- 구매자
ALTER TABLE TABLE2
	ADD CONSTRAINT FK_Temporary4_TO_TABLE2 -- 회원 -> 구매자
		FOREIGN KEY (
			MNO -- 구매자번호
		)
		REFERENCES Temporary4 ( -- 회원
			MNO -- 회원번호
		);

-- 책정보
ALTER TABLE TABLE3
	ADD CONSTRAINT FK_TABLE_TO_TABLE3 -- 판매자 -> 책정보
		FOREIGN KEY (
			MNO -- 판매자번호
		)
		REFERENCES TABLE ( -- 판매자
			MNO -- 판매자번호
		);

-- 장바구니
ALTER TABLE TABLE4
	ADD CONSTRAINT FK_TABLE10_TO_TABLE4 -- 주문 -> 장바구니
		FOREIGN KEY (
			ONO -- 주문번호
		)
		REFERENCES TABLE10 ( -- 주문
			ONO -- 주문번호
		);

-- 장바구니
ALTER TABLE TABLE4
	ADD CONSTRAINT FK_TABLE3_TO_TABLE4 -- 책정보 -> 장바구니
		FOREIGN KEY (
			BNO -- 책번호
		)
		REFERENCES TABLE3 ( -- 책정보
			BNO -- 책번호
		);

-- 배송
ALTER TABLE TABLE7
	ADD CONSTRAINT FK_TABLE11_TO_TABLE7 -- 판매내역 -> 배송
		FOREIGN KEY (
			SNO -- 판매내역번호
		)
		REFERENCES TABLE11 ( -- 판매내역
			SNO -- 판매내역번호
		);

-- 배송
ALTER TABLE TABLE7
	ADD CONSTRAINT FK_Temporary3_TO_TABLE7 -- 주소 -> 배송
		FOREIGN KEY (
			ARNO -- 주소번호
		)
		REFERENCES Temporary3 ( -- 주소
			ARNO -- 주소번호
		);

-- 1:1문의
ALTER TABLE TABLE8
	ADD CONSTRAINT FK_Temporary4_TO_TABLE8 -- 회원 -> 1:1문의
		FOREIGN KEY (
			MNO -- 회원번호
		)
		REFERENCES Temporary4 ( -- 회원
			MNO -- 회원번호
		);

-- 리뷰
ALTER TABLE TABLE9
	ADD CONSTRAINT FK_TABLE2_TO_TABLE9 -- 구매자 -> 리뷰
		FOREIGN KEY (
			MNO -- 구매자번호
		)
		REFERENCES TABLE2 ( -- 구매자
			MNO -- 구매자번호
		);

-- 주문
ALTER TABLE TABLE10
	ADD CONSTRAINT FK_TABLE2_TO_TABLE10 -- 구매자 -> 주문
		FOREIGN KEY (
			MNO -- 구매자번호
		)
		REFERENCES TABLE2 ( -- 구매자
			MNO -- 구매자번호
		);

-- 주문
ALTER TABLE TABLE10
	ADD CONSTRAINT FK_Temporary3_TO_TABLE10 -- 주소 -> 주문
		FOREIGN KEY (
			ARNO -- 주소번호
		)
		REFERENCES Temporary3 ( -- 주소
			ARNO -- 주소번호
		);

-- 판매내역
ALTER TABLE TABLE11
	ADD CONSTRAINT FK_TABLE10_TO_TABLE11 -- 주문 -> 판매내역
		FOREIGN KEY (
			ONO -- 주문번호
		)
		REFERENCES TABLE10 ( -- 주문
			ONO -- 주문번호
		);

-- 판매내역
ALTER TABLE TABLE11
	ADD CONSTRAINT FK_TABLE_TO_TABLE11 -- 판매자 -> 판매내역
		FOREIGN KEY (
			MNO -- 판매자번호
		)
		REFERENCES TABLE ( -- 판매자
			MNO -- 판매자번호
		);

-- 책정보사진
ALTER TABLE Temporary
	ADD CONSTRAINT FK_TABLE3_TO_Temporary -- 책정보 -> 책정보사진
		FOREIGN KEY (
			BNO -- 책번호
		)
		REFERENCES TABLE3 ( -- 책정보
			BNO -- 책번호
		);

-- 리뷰사진
ALTER TABLE Temporary2
	ADD CONSTRAINT FK_TABLE9_TO_Temporary2 -- 리뷰 -> 리뷰사진
		FOREIGN KEY (
			RNO -- 리뷰번호
		)
		REFERENCES TABLE9 ( -- 리뷰
			RNO -- 리뷰번호
		);

-- 구매서적
ALTER TABLE TABLE13
	ADD CONSTRAINT FK_TABLE2_TO_TABLE13 -- 구매자 -> 구매서적
		FOREIGN KEY (
			MNO -- 구매자번호
		)
		REFERENCES TABLE2 ( -- 구매자
			MNO -- 구매자번호
		);

-- 구매서적
ALTER TABLE TABLE13
	ADD CONSTRAINT FK_TABLE3_TO_TABLE13 -- 책정보 -> 구매서적
		FOREIGN KEY (
			BNO -- 책번호
		)
		REFERENCES TABLE3 ( -- 책정보
			BNO -- 책번호
		);

-- 회원
ALTER TABLE Temporary4
	ADD CONSTRAINT FK_Temporary3_TO_Temporary4 -- 주소 -> 회원
		FOREIGN KEY (
			ARNO -- 주소번호
		)
		REFERENCES Temporary3 ( -- 주소
			ARNO -- 주소번호
		);