# Project Pages<br>
- Front: [cloneProjectFront](https://github.com/laeongmulti/cloneProjectFront)<br>
- Back: [cloneProjectBackBoot](https://github.com/laeongmulti/cloneProjectBackBoot)<br>
- DB: [cloneProjectDB](https://github.com/laeongmulti/cloneProjectDB)<br>


# 백엔드

**소개**<br>
- Spring Boot + JPA 로 이루어짐
- 초기엔 서버 이해를 위해 비교적 쉬운 Boot랑 JPA를 간단하게만 사용하고 강의를 진행하면서 Spring Legacy 와 MyBatis를 사용한 새로운 백엔드 구축 예정

**설치방법**<br>
인터넷에서 Docker Desktop 필수 설치<br>
아래 주의사항 먼저 읽는것도 추천<br>
cloneProjectDB 에서 먼저 도커에 올려야함!<br>

도커에 Spring Boot 업로드<br>
````bash
docker-compose up --build
````

이미 DB 설정시 my-network를 생성하였다면 별도의 추가 작업이 필요 없음<br>

나중에 백엔드 실행시 DB서버가 없는경우 서버가 죽으니 먼저 실행해두는것을 권장함 (스프링은 원래 이런 것 같음)<br>

**로컬 실행 방법**<br>
Spring Boot에서 로컬 실행은 아래 파일로 이동한 뒤 f5 누르면 됨<br>
src/main/java/come/cloneproject/demo/DemoApplication.java<br>

**주의 사항**
1. 개발 환경 세팅 <br>
기본적으로 자바는 JVM에서 실행됨. 우리가 Hello.java를 만들고, IDE에서 f5를 눌러 편히 실행해도 결과값이 나오는건 IDE가 그것까지 고려해서 우리에게 출력해주기 때문<br>

해당 프로젝트도 변경사항 반영을 설정해 놓긴 했지만 어찌 되었든든 서버를 재시작 해야해서 도커에서 개발하는건 매우 비효율적임.<br>
도커는 호환성과 작동 잘 되는지정도만 확인하고 로컬에서 개발하는것을 추천<br>
도커 목적이 서버 틀어놓고 개발하라는것도 아니라서 어쩔 수 없음<br>

2. 백엔드 실행시 설정 변경<br>
백엔드 실행시 어디서 실행되느냐에 따라 DB에 접속하는 방식이 달라짐. 따라서 맞춰서 설정해야함<br>

src/main/resources/application.properties<br>

위 파일에서 도커로 실행했을때와 로컬 IDE에서 f5로 실행했을때 주석부분이 다르니 필요한걸로 둘중 하나 선택해서 주석 풀고 사용하면 됨<br>

application.properties를 수정하면 도커의 기존 컨테이너를 삭제하고 재업로드 해야함
```bash
  docker-compose down
```
위 명령어로 컨테이너에서 삭제하고
```bash
  docker-compose up --build
```
다시 업로드하면 됨<br>
## REST API 작성 가이드<br>
클라이언트가 항상 동일한 응답 구조를 받을 수 있도록 아래 규칙을 지켜주세요.
### 1. 성공 응답처리
- 필요한 경우 `SuccessCode` enum에 **코드 번호**와 **메시지**를 추가.
- API 컨트롤러에서는 응답 데이터가 있는 경우 `ResponseEntity.ok(ApiResponse.success(SuccessCode, data))` 형태로 응답 / 응답 데이터가 없는 경우 `ResponseEntity.ok(ApiResponse.success(SuccessCode))` 형태로 응답.
```java
// 예시
@GetMapping("/api/member")
public ResponseEntity<ApiResponse<MemberResponse>> getMember(@RequestParam Long id) {
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_FETCH_SUCCESS, memberService.getMemberById(id)));
}

@PostMapping("/api/member/register")
public ResponseEntity<ApiResponse<Void>> registerMember(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {
    memberService.registerMember(memberRegisterRequest);
    return ResponseEntity.ok(ApiResponse.success(SuccessCode.MEMBER_CREATE_SUCCESS));
}
```

### 2. 예외 처리
- 예외가 필요한 경우 `ErrorCode` enum에 **코드 번호**, **메시지**, **HttpStatus**를 추가.
- Service 계층에서 예외 상황 발생 여부를 확인하고, `throw new CustomException(ErrorCode.XXX)` 형식으로 처리.
```java
// 예시
public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    if (products.isEmpty()) throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
    else {
        return products.stream()
                .map(product -> new ProductResponse(product))
                .toList();
    }

}
```
### 3. 응답 결과 예시
```json
{
    "success": true,
    "code": 100,
    "message": "회원 조회 성공",
    "data": {
        "id": 1,
        "name": "최성보",
        "nickname": "최성보",
        "phone": "010-1234-5678",
        "address": "서울특별시",
        "updatedAt": "2025-05-12T14:12:51.229661",
        "status": false,
        "authority": 1,
        "email": "cseongbo17@naver.com",
        "joinDate": "2025-05-12T14:12:51.229682"
    }
}
```