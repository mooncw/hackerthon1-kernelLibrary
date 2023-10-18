# Kernel360 작은도서관
Kernel360의 작은 도서관입니다.

## 구성원들간 책을 돌려볼 수 있도록 연결해주는 서비스 입니다.


## 테이블

ERD에는 다음과 같은 테이블이 있습니다.

* `User`: 회원 정보를 저장하는 테이블
* `Book`: 책 정보를 저장하는 테이블
* `Rental`: 대여 정보를 저장하는 테이블

## 필드

각 테이블에는 다음과 같은 필드가 있습니다.

### User

* `id`: 회원 ID
* 
* `username`: 회원 이름
* `email`: 회원 이메일
* `password`: 회원 비밀번호

### Book

* `book_id`: 책 ID
* `user_id`: user ID
* 
* `isRecovery`: 회수 여부
* `isRental`: 대출 여부


### Rental

* `rentalId`: 대여키
* `book_id`:  책 아이디
* `user_id` : 유저 아이디
* 
* `rentalDate`: 대출일자
* `returnDate`: 반납일자
