# Kernel360 작은도서관
Kernel360의 작은 도서관입니다.

## 구성원들간 책을 돌려볼 수 있도록 연결해주는 서비스 입니다.


## 테이블

ERD에는 다음과 같은 테이블이 있습니다.

* `Member`: 회원 정보를 저장하는 테이블
* `Book`: 책 정보를 저장하는 테이블
* `Loan`: 대여 정보를 저장하는 테이블

## 필드

각 테이블에는 다음과 같은 필드가 있습니다.

### Member

* `id`: 회원 ID
* `name`: 회원 이름
* `email`: 회원 이메일
* `password`: 회원 비밀번호

### Book

* `book_id`: 책 ID
* `user_id`: user ID
* `title`: 책 제목
* `isbn`: 책 ISBN 번호
* `author`: 책 저자
* `category`: 책 카테고리
* `bookCover`: 책 이미지


### Loan

* `loanId`: 대여키
* `book_id`: 책아이디
* `loanDate`: 대출일자
* `returnDate`: 반납일자
* `loanStatus`: 대여상태
