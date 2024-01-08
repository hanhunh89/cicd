charset utf8;
USE springmvcDB;

CREATE TABLE IF NOT EXISTS book(
	b_bookId VARCHAR(10) NOT NULL,
	b_name VARCHAR(30),
	b_unitPrice INTEGER,
	b_author VARCHAR(50),
	b_description TEXT,
	b_publisher VARCHAR(20),
	b_category VARCHAR(20),
	b_unitsInStock LONG,
	b_releaseDate VARCHAR(20),
	b_condition VARCHAR(20),
	b_fileName VARCHAR(20),
	PRIMARY KEY (b_bookId)
)DEFAULT CHARSET=utf8;

DELETE FROM book;

INSERT INTO book VALUES('1234', '미코가 힘을숨김', 30000, '심미코', '미코가 사실 짱짱맨이었다','새벽','판타지', 1000, '2020/05/29', '','1234.jpg');
INSERT INTO book VALUES('4567', '오늘은 요리왕', 20000, '개미코', '미코 개밥만들기','새벽','요리', 2000, '2020/02/22', '','4567.jpg');