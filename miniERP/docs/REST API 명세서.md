# Mini ERP API 명세서

index | 기능 | HTTP Method | API Path | 상태 |
|---|---|---|---|---|
| 상품 | 등록 | POST | /api/v1/product | 완료 |
| 상품 | 이름 조회 | GET | /api/v1/product/{name} | 완료 |
| 상품 | 전체 조회 | GET | /api/v1/products | 완료 |
| 주문 | 생성 | POST | /api/v1/order  | 완료 |
| 주문 | 상세 조회 | GET | /api/v1/order/{orderId} | 예정 |
 |주문 | 완료 처리 | PATCH | /api/v1/order/{orderId}/complete | 예정 |