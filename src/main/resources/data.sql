-- User 테이블에 테스트 유저 추가
INSERT INTO User (username, password, email) VALUES ('testUser01', '123456767', 'kjkj5868@gmail.com');
INSERT INTO User (username, password, email) VALUES ('testUser02', '1111111', 'UKnow928@gmail.com');

-- Book 테이블에 테스트 도서 추가
INSERT INTO Book (booktitle, isbn, author) VALUES ('클린코드', 1234567890123, '로버트 C. 마틴');
INSERT INTO Book (booktitle, isbn, author) VALUES ('프로그래머의 뇌', 555453242423, '펠리너 헤르만스');