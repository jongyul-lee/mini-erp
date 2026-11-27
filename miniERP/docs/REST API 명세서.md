
# Mini ERP API 명세서

## API 목록

| 구분 | 기능 | HTTP Method | API Path | 상태 |
|---|---|---|---|---|
| 상품 | 등록 | POST | `/api/v1/product` | 완료 |
| 상품 | 이름 조회 | GET | `/api/v1/product/{name}` | 완료 |
| 상품 | 전체 조회 | GET | `/api/v1/products` | 완료 |
| 상품 | 정보 수정 | PATCH | `/api/v1/product/{productId}` | 예정 |
| 상품 | 재고 입고 | POST | `/api/v1/product/{productId}/stock-in` | 예정 |
| 상품 | 재고 부족 목록 조회 | GET | `/api/v1/products/low-stock` | 예정 |
| 주문 | 생성 | POST | `/api/v1/order` | 완료 |
| 주문 | 상세 조회 | GET | `/api/v1/order/{orderId}` | 예정 |
| 주문 | 완료 처리 | PATCH | `/api/v1/order/{orderId}/complete` | 예정 |
| 주문 | 취소 처리 | PATCH | `/api/v1/order/{orderId}/cancel` | 예정 |
| 주문 | 전체 목록 조회 | GET | `/api/v1/orders` | 예정 |
| 주문 | 조건 검색 | GET | `/api/v1/orders?status=PENDING` | 예정 |
| 주문 | 페이지네이션 | GET | `/api/v1/orders?page=0&size=10` | 예정 |
| 사용자 | 회원가입 | POST | `/api/v1/users` | 예정 |
| 사용자 | 로그인 | POST | `/api/v1/auth/login` | 예정 |
| 사용자 | 내 주문 목록 | GET | `/api/v1/users/me/orders` | 예정 |

---

## 개발 우선순위

### 1단계 - 주문 관리

- [x] 주문 생성
- [ ] 주문 상세 조회
- [ ] 주문 완료 처리 및 재고 차감
- [ ] 주문 취소 처리
- [ ] 주문 전체 목록 조회
- [ ] 주문 조건 검색
- [ ] 주문 페이지네이션

### 2단계 - 상품 및 재고 관리

- [x] 상품 등록
- [x] 상품 이름 조회
- [x] 상품 전체 조회
- [ ] 상품 정보 수정
- [ ] 상품 재고 입고
- [ ] 재고 부족 상품 조회

### 3단계 - 사용자 관리

- [ ] 회원가입
- [ ] 로그인
- [ ] JWT 인증
- [ ] 사용자별 주문 내역 조회
- [ ] 사용자 권한 관리

### 4단계 - 클라이언트 및 서버 배포

- [ ] WPF 상품 관리 화면
- [ ] WPF 주문 관리 화면
- [ ] WPF 로그인 화면
- [ ] Spring Boot 서버 라즈베리파이 배포
- [ ] PostgreSQL 데이터베이스 배포

---

## 주문 처리 규칙

### 주문 생성
- 주문 상태는 `PENDING`으로 저장한다.
- 주문 생성 시 상품 재고는 차감하지 않는다. (COMPLETED로 변경 시 차감한다.)
- `orders`와 `order_product`는 하나의 트랜잭션으로 저장한다.

### 주문 완료
- `PENDING` 상태의 주문만 완료할 수 있다.
- 주문 완료 시 상품 재고를 차감한다.
- 재고가 부족하면 주문 완료를 거부한다.
- 주문 상태 변경과 재고 차감은 하나의 트랜잭션으로 처리한다.
- 중복 완료 요청으로 재고가 두 번 차감되지 않도록 한다.

### 주문 취소
- `PENDING` 상태의 주문만 취소할 수 있다.
- 주문 취소 시 상품 재고는 변경하지 않는다.
- 이미 `COMPLETED`인 주문은 취소할 수 없다.
