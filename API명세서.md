<h1 style='background-color: rgba(55, 55, 55, 0.4); text-align: center'>API 명세서 </h1>

해당 API 명세서는 'Food Insight'의 REST API를 명세하고 있습니다.

- Domain : <http://localhost:9999>  

***

<h2 style='background-color: rgba(55, 55, 55, 0.2); text-align: center'>Auth 모듈</h2>

인증 및 인가와 관련된 REST API 모듈  
로그인, 회원가입, 소셜 로그인, 소셜 회원가입 등의 API가 포함되어 있습니다.  

- url : /api/v1/auth  

***

#### - 로그인  

##### 설명

클라이언트로부터 사용자 아이디와 평문의 비밀번호를 입력받고 아이디와 비밀번호가 일치한다면 성공 처리가 되며 access_token과 해당 토큰의 만료 기간을 반환합니다. 만약 아이디 혹은 비밀번호가 하나라도 틀리다면 실패 처리를 합니다. 서버 에러, 데이터베이스 에러, 토큰 생성 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/sign-in**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| userEmailId | String | 사용자 아이디(이메일 형식) | O |
| userPassword | String | 사용자의 비밀번호 | O |

###### Example

```bash
curl -v -X POST "http://localhost:9999/api/v1/auth/sign-in" \
 -d "userEmailId=service123@email.com" \
 -d "userPassword=P!ssw0rd"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| accessToken | String | 사용자의 토큰 | O |
| expires | int | 토큰 만료 기간 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.",
  "accessToken": "${ACCESS_TOKEN}",
  "expires": 3600
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (로그인 정보 불일치)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "SF",
  "message": "Sign in Failed."
}
```

**응답 : 실패 (토큰 생성 실패)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "TF",
  "message": "Token creation Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 이메일 중복 확인  
  
##### 설명

클라이언트로부터 이메일을 입력받아 해당하는 이메일이 이미 사용중인 이메일인지 확인합니다. 중복되지 않은 이메일이면 성공 처리를 합니다. 만약 중복되는 아이디라면 실패 처리를 합니다. 데이터 유효성 검사 실패, 중복된 이메일, 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/email-check**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| userEmailId | String | 중복 확인할 사용자의 아이디(이메일 형식) | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/email-check" \
 -d "userEamilId=service123@email.com" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (중복된 이메일)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DE",
  "message": "Duplicatied Email."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 닉네임 중복 확인  
  
##### 설명

클라이언트로부터 닉네임을 입력받아 해당하는 닉네임이 이미 사용중인 닉네임인지 확인하고 사용하고 있지 않은 닉네임이라면 성공 처리를 합니다. 만약 중복된 닉네임이라면 실패 처리를 합니다. 데이터 유효성 검사 실패, 중복된 닉네임, 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/nickname-check**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| nickname | String | 중복 확인할 사용자의 닉네임 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/nickname-check" \
 -d "nickname=service22"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (중복된 닉네임)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DN",
  "message": "Duplicatied Nickname."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 사업자등록번호 중복 확인  
  
##### 설명

클라이언트로부터 사업자등록번호를 입력받아 해당하는 사업자등록번호가 이미 사용중인 사업자등록번호인지 확인하고 사용하고 있지 않은 사업자등록번호라면 성공 처리를 합니다. 만약 중복된 사업자등록번호라면 실패 처리를 합니다. 데이터 유효성 검사 실패, 중복된 사업자등록번호, 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **s/busines-registration-check**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| businessRegistrationNumber | String | 중복 확인할 사용자의 사업자등록번호 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/busines-registration-check" \
 -d "businessRegistrationNumber=222-22-22222"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (중복된 사업자등록번호)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DR",
  "message": "Duplicated Business Registration Number."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 전화번호 인증
  
##### 설명

클라이언트로부터 전화번호를 입력받아 6자리의 인증 결과 코드를 해당 전화번호로 전송합니다. 전화번호로 전송이 성공적으로 종료되었으면 성공 처리를 합니다. 만약 전화번호로 전송에 실패했으면 실패 처리를 합니다. 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/tel-number-auth**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| userTelNumber | String | 인증 번호를 전송할 사용자 전화번호 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/tel-number-auth" \
 -d "userTelNumber=010-0000-0000" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (전화번호 전송 실패)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "SF",
  "message": "Auth Number Send Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```
***

#### - 전화번호 인증 확인
  
##### 설명

클라이언트로부터 전화번호와 인증 번호를 입력받아 해당하는 전화번호에 전송한 인증번호와 일치하는지 확인합니다. 일치한다면 성공 처리를 합니다. 만약 일치하지 않는다면 실패처리를 합니다. 데이터베이스 오류가 발생할 수 있습니다.

- method : **POST**  
- URL : **/tel-number-check**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| userTelNumber | String | 인증 번호를 확인할 사용자 전화번호 | O |
| authNumber | String | 인증 확인할 인증 번호 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/email-auth-check" \
 -d "userTelNumber=010-0000-0000" \
 -d "authNumber=012345"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Varidation Failed."
}
```

**응답 : 실패 (전화번호 인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 오류)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 회원가입
  
##### 설명

클라이언트로부터 이메일, 비밀번호, 닉네임, 이름, 전화번호, 인증번호, 주소, 사업자등록번호를 입력받아 회원가입 처리를 합니다. 정상적으로 회원가입이 완료되면 성공 처리를 합니다. 만약 중복된 이메일, 중복된 닉네임, 중복된 사업자등록번호, 인증번호 불일치가 발생하면 실패처리를 합니다. 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/sign-up**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| userEmailId | String | 사용자 아이디(이메일 형식) | O |
| userPassword | String | 사용자 비밀번호(영문+숫자 8~13자) | O |
| nickname | String | 사용자 닉네임 | O |
| userName | String | 사용자 이름 | O |
| userTelNumber | String | 사용자 전화번호 | O |
| authNumber | String | 인증 확인할 인증 번호 | O |
| userAddress | String | 사용자 주소 | O |
| businessRegistrationNumber | String | 사용자 사업자등록번호 | X |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/auth/sign-up" \
 -d "userEmailId=service123@email.com" \
 -d "userPassword=P!ssw0rd" \
 -d "nickname=service22" \
 -d "userName=홍길동" \
 -d "userTelNumber=010-0000-0000" \
 -d "authNumber=012345" \
 -d "userAddress=부산광역시" \
 -d "businessRegistrationNumber=222-22-22222"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (중복된 이메일)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DE",
  "message": "Duplicatied Email."
}
```

**응답 : 실패 (중복된 닉네임)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DN",
  "message": "Duplicatied Nickname."
}
```

**응답 : 실패 (중복된 사업자등록번호)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "DR",
  "message": "Duplicated Business Registration Number."
}
```

**응답 : 실패 (전화번호 인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

<h2 style='background-color: rgba(55, 55, 55, 0.2); text-align: center'>User 모듈</h2>

사용자 정보와 관련된 REST API 모듈 
  
- url : /api/v1/user  

***

#### - 로그인 유저 정보 반환
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 요청을 받으면 해당 토큰의 작성자(subject)에 해당하는 사용자 정보를 반환합니다. 성공 시에는 사용자의 아이디와 권한을 반환합니다. 인증 실패 및 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Example

```bash
curl -v -X GET "http://localhost:4000/api/v1/user/" \
 -H "Authorization: Bearer {JWT}"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| userId | String | 사용자의 아이디 | O |
| userRole | String | 사용자의 권한 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.",
  "uesrId": "${userId}",
  "userRole": "${userRole}"
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***
<h2 style='background-color: rgba(55, 55, 55, 0.2); text-align: center'>Board 모듈</h2>

Q&A 게시물과 관련된 REST API 모듈 
  
- url : /api/v1/board  

***

#### - Q&A 게시물 작성
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 제목, 내용을 입력받고 작성에 성공하면 성공 처리를 합니다. 만약 작성에 실패하면 실패 처리됩니다. 인가 실패, 데이터 유효성 검사 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| title | String | Q&A 제목 | O |
| contents | String | Q&A 내용 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/board/" \
 -H "Authorization: Bearer {JWT}" \
 -d "title={title}" \
 -d "contents={contents}"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```
**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 전체 게시물 리스트 불러오기
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 요청을 보내면 작성일 기준 내림차순으로 게시물 리스트를 반환합니다. 만약 불러오기에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/list**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Example

```bash
curl -v -X GET "http://localhost:4000/api/v1/board/list" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| boardList | BoardListItem[ ] | Q&A 게시물 리스트 | O |

**BoardListItem**
| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |
| status | boolean | 상태 | O |
| title | String | 제목 | O |
| writerId | String | 작성자 아이디</br>(첫글자를 제외한 나머지 문자는 *) | O |
| writeDatetime | String | 작성일</br>(yy.mm.dd 형태) | O |
| ciewCount | int | 조회수 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.",
  "boardList": [
    {
      "receptionNumber": 1,
      "status": false,
      "title": "test",
      "writerId": "s*********",
      "wirteDatetime": "24.05.02",
      "viewCount": 0
    }, ...
  ]
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 검색 게시물 리스트 불러오기
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 검색어를 입력받고 요청을 보내면 작성일 기준 내림차순으로 제목에 해당 검색어가 포함된 게시물 리스트를 반환합니다. 만약 불러오기에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/list/${searchWord}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

<<<<<<< HEAD
###### Query Pram

| name | type | description | required |
|---|:---:|:---:|:---:|
| word | String | 검색어 | O |
=======
###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| searchWord | String | 검색어 | O |
>>>>>>> c4993b3f46c5d47ef83764c5f55a7f9e58306319

###### Example

```bash
<<<<<<< HEAD
curl -v -X GET "http://localhost:4000/api/v1/board/list/search?word=${searchWord}" \
=======
curl -v -X GET "http://localhost:4000/api/v1/board/list/${searchWord}" \
>>>>>>> c4993b3f46c5d47ef83764c5f55a7f9e58306319
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| boardList | BoardListItem[ ] | Q&A 게시물 리스트 | O |

**BoardListItem**
| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |
| status | boolean | 상태 | O |
| title | String | 제목 | O |
| writerId | String | 작성자 아이디</br>(첫글자를 제외한 나머지 문자는 *) | O |
| writeDatetime | String | 작성일</br>(yy.mm.dd 형태) | O |
| ciewCount | int | 조회수 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.",
  "boardList": [
    {
      "receptionNumber": 1,
      "status": false,
      "title": "test",
      "writerId": "s*********",
      "wirteDatetime": "24.05.02",
      "viewCount": 0
    }, ...
  ]
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 게시물 불러오기
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 접수번호를 입력받고 요청을 보내면 해당하는 Q&A 게시물 데이터를 반환합니다. 만약 불러오기에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/{receptionNumber}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |

###### Example

```bash
curl -v -X GET "http://localhost:4000/api/v1/board/${receptionNumber}" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| receptionNumber | int | 접수 번호 | O |
| status | boolean | 상태 | O |
| title | String | 제목 | O |
| writerId | String | 작성자 아이디 | O |
| writeDatetime | String | 작성일</br>(yyyy.mm.dd 형태) | O |
| viewCount | int | 조회수 | O |
| contents | String | 내용 | O |
| comment | String | 답글 내용 | X |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.",
  "receptionNumber": ${receptionNumber},
  "status": ${status},
  "title": ${title},
  "writerId": ${writerId},
  "writeDatetime": ${writeDatetime},
  "viewCount": ${viewCount},
  "contents": ${contents},
  "comment": ${comment}
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (존재하지 않는 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "NB",
  "message": "No Exist Board."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 게시물 조회수 증가
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 접수번호를 입력받고 요청을 보내면 해당하는 Q&A 게시물의 조회수가 증가합니다. 만약 증가에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **PATCH**  
- URL : **/{receptionNumber}/increase-view-count**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |

###### Example

```bash
curl -v -X PATCH "http://localhost:4000/api/v1/board/${receptionNumber}/increase-view-count" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (존재하지 않는 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "NB",
  "message": "No Exist Board."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 게시물 답글 작성
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 접수번호와 답글 내용을 입력받고 요청을 보내면 해당하는 Q&A 게시물의 답글이 작성됩니다. 만약 증가에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **POST**  
- URL : **/{receptionNumber}/comment**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| comment | string | 답글 내용 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/board/${receptionNumber}/comment" \
 -H "Authorization: Bearer {JWT}" \
 -d "comment={comment}"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (존재하지 않는 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "NB",
  "message": "No Exist Board."
}
```

**응답 : 실패 (이미 작성된 답글)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "WC",
  "message": "Written Comment."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 게시물 삭제
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 접수번호를 입력받고 요청을 보내면 해당하는 Q&A 게시물이 삭제됩니다. 만약 삭제에 실패하면 실패 처리를 합니다. 인가 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **DELETE**  
- URL : **/{receptionNumber}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 접수 번호 | O |

###### Example

```bash
curl -v -X POST "http://localhost:4000/api/v1/board/${receptionNumber}" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```

**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (존재하지 않는 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "NB",
  "message": "No Exist Board."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (인증 실패)**
```bash
HTTP/1.1 401 Unauthorized
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authentication Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - Q&A 게시물 수정
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 접수번호, 제목, 내용을 입력받고 수정에 성공하면 성공 처리를 합니다. 만약 수정에 실패하면 실패 처리됩니다. 인가 실패, 데이터 유효성 검사 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **PUT**  
- URL : **/{receptionNumber}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| receptionNumber | int | 수정할 접수 번호 | O |

###### Request Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| title | String | Q&A 제목 | O |
| contents | String | Q&A 내용 | O |

###### Example

```bash
curl -v -X PUT "http://localhost:4000/api/v1/board/${receptionNumber}" \
 -H "Authorization: Bearer {JWT}" \
 -d "title={title}" \
 -d "contents={contents}"
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success."
}
```
**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (존재하지 않는 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "NB",
  "message": "No Exist Board."
}
```

**응답 : 실패 (답변 완료된 게시물)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "WC",
  "message": "Written Comment."
}
```

**응답 : 실패 (권한 없음)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

<h2 style='background-color: rgba(55, 55, 55, 0.2); text-align: center'>Estate 모듈</h2>

오피스텔 부동산 가격 정보와 관련된 REST API 모듈  
지역 평균 데이터, 비율 관련 데이터 API가 포함되어 있습니다.  
  
- url : /api/v1/estate  

***

#### - 지역 평균 데이터 불러오기
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 지역을 입력받고 불러오기에 성공하면 성공 처리를 합니다.(매매가, 전세가, 월세 보증금의 단위는 1,000원 단위) 만약 불러오기에 실패하면 실패 처리됩니다. 인가 실패, 데이터 유효성 검사 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/local/{local}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| local | String | 조회할 지역 | O |

###### Example

```bash
curl -v -X PUT "http://localhost:4000/api/v1/estate/local/{local}" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| yearMonth | String[] | 연월 리스트 | O |
| sale | int[] | 매매가 리스트 | O |
| lease | int[] | 전세가 리스트 | O |
| monthRent | int[] | 월세 보증금 리스트 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.", 
  "yearMonth": ['23-01', '23-02', '23-03', '23-04', ..., '23-12'],
  "Sale": [4354, 3434, 4343, ..., 2146],
  "lease": [4354, 3434, 4343, ..., 2146],
  "monthRent": [4354, 3434, 4343, ..., 2146]
}
```
**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***

#### - 비율 데이터 불러오기
  
##### 설명

클라이언트로부터 Request Header의 Authorization 필드로 Bearer 토큰을 포함하여 지역을 입력받고 불러오기에 성공하면 성공 처리를 합니다.(날짜 데이터를 제외한 모든 단위는 백분율 단위) 만약 불러오기에 실패하면 실패 처리됩니다. 인가 실패, 데이터 유효성 검사 실패, 데이터베이스 에러가 발생할 수 있습니다.

- method : **GET**  
- URL : **/ratio/{local}**  

##### Request

###### Header

| name | description | required |
|---|:---:|:---:|
| Authorization | 인증에 사용될 Bearer 토큰 | O |

###### Path Variable

| name | type | description | required |
|---|:---:|:---:|:---:|
| local | String | 조회할 지역 | O |

###### Example

```bash
curl -v -X PUT "http://localhost:4000/api/v1/estate/ratio/{local}" \
 -H "Authorization: Bearer {JWT}" 
```

##### Response

###### Header

| name | description | required |
|---|:---:|:---:|
| Content-Type | 반환하는 Response Body의 Content Type (application/json) | O |

###### Response Body

| name | type | description | required |
|---|:---:|:---:|:---:|
| code | String | 결과 코드 | O |
| message | String | 결과 메세지 | O |
| yearMonth | String[] | 연월 리스트 | O |
| return40 | double[] | 40m^2 이하 수익률 리스트 | O |
| return4060 | double[] | 40m^2 초과 60m^2 이하 수익률 리스트 | O |
| return6085 | double[] | 60m^2 초과 85m^2 이하 수익률 리스트 | O |
| return85 | double[] | 85m^2 초과 수익률 리스트 | O |
| leaseRatio40 | double[] | 40m^2 이하 매매가 대비 전세가 비율 리스트 | O |
| leaseRatio4060 | double[] | 40m^2 초과 60m^2 이하 매매가 대비 전세가 비율 리스트 | O |
| leaseRatio6085 | double[] | 60m^2 초과 85m^2 이하 매매가 대비 전세가 비율 리스트 | O |
| leaseRatio85 | double[] | 85m^2 초과 매매가 대비 전세가 비율 리스트 | O |
| monthRentRatio40 | double[] | 40m^2 이하 전세가 대비 월세 보증금 비율 리스트 | O |
| monthRentRatio4060 | double[] | 40m^2 초과 60m^2 이하 전세가 대비 월세 보증금 비율 리스트 | O |
| monthRentRatio6085 | double[] | 60m^2 초과 85m^2 이하 전세가 대비 월세 보증금 비율 리스트 | O |
| monthRentRatio85 | double[] | 85m^2 초과 전세가 대비 월세 보증금 비율 리스트 | O |

###### Example

**응답 성공**
```bash
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
{
  "code": "SU",
  "message": "Success.", 
  "yearMonth": ['23-01', '23-02', '23-03', '23-04', ..., '23-12'],
  "return40": [10.5, 11.1, 12.5, ..., 11.8],
  "return4060": [10.5, 11.1, 12.5, ..., 11.8],
  "return6085": [10.5, 11.1, 12.5, ..., 11.8],
  "return85": [10.5, 11.1, 12.5, ..., 11.8],
  "leaseRatio40": [10.5, 11.1, 12.5, ..., 11.8],
  "leaseRatio4060": [10.5, 11.1, 12.5, ..., 11.8],
  "leaseRatio6085": [10.5, 11.1, 12.5, ..., 11.8],
  "leaseRatio85": [10.5, 11.1, 12.5, ..., 11.8],
  "monthRentRatio40": [10.5, 11.1, 12.5, ..., 11.8],
  "monthRentRatio4060": [10.5, 11.1, 12.5, ..., 11.8],
  "monthRentRatio6085": [10.5, 11.1, 12.5, ..., 11.8],
  "monthRentRatio85": [10.5, 11.1, 12.5, ..., 11.8],
}
```
**응답 : 실패 (데이터 유효성 검사 실패)**
```bash
HTTP/1.1 400 Bad Request
Content-Type: application/json;charset=UTF-8
{
  "code": "VF",
  "message": "Validation Failed."
}
```

**응답 : 실패 (인가 실패)**
```bash
HTTP/1.1 403 Forbidden
Content-Type: application/json;charset=UTF-8
{
  "code": "AF",
  "message": "Authorization Failed."
}
```

**응답 : 실패 (데이터베이스 에러)**
```bash
HTTP/1.1 500 Internal Server Error
Content-Type: application/json;charset=UTF-8
{
  "code": "DBE",
  "message": "Database Error."
}
```

***