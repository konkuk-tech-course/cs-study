## 4.1 데이터베이스 기본



### 들어가기 전 알고 갈 용어
> - DB: 일정 규칙, 혹은 규약 -> 구조화되어 저장된 데이터들의 모음이다.
> - DBMS: 이걸 관리하는 시스템 RDBMS, NoSQL 등이 있다.

### 엔티티(Entity)

> Entity: 여러개의 속성을 가진 명사

생각해보면 속성이 없는 명사가 있나? 거의 대부분의 것들이라고 할 수 있다.

### 약한 엔티티, 강한 엔티티

약한 엔티티 : 의존적인 엔티티이다.
강한 엔티티 : 본인에게 의존하는 엔티티가 있으면 그 엔티티에 비해서 상대적으로 강한 엔티티이다.

예시로 방과 건물의 관계를 생각해볼 수 있다. 

방은 건물이 있어야만 존재할 수 있다. 그렇게 보면 상대적으로 방이 약한 엔티티, 건물이 강한 엔티티가 되어진다.

### 릴레이션

> 릴레이션 : 정보를 구분하여 저장하는 기본 단위 이것을 RDBMS에서는 `테이블` NoSQL에서는 `컬렉션`이라고 부른다.

| 이름    | 전화번호   | 출석   |
|-------|--------|------|
| KIM   | 010-1234-5678 | yes |
| LEE  | 010-2763-4235 | no |
| PARK  | 010-9738-2938 | no |

위와 같은 구조를 RDB에서 `테이블`이라고 부른다.

위 테이블의 구성요소는 다음과 같다.
- 속성(attribute) : 릴레이션에서 관리하는 구체적이며 구유한 이름을 갖는 정보이다.(이름, 전화번호, 출석)
- 레코드: 테이블에 쌓이는 행(row)
- 도메인: 속성들이 가질 수 있는 값의 집합 출석을 예로 들면 {yes,no}가 된다.
- 필드: 속성이 있는 곳



### 필드의 타입

필드는 각자 타입을 가지고 있다. 


### 숫자 타입

| 숫자타입      |  용량(바이트)  | 최솟값(부호 있음)  | 최솟값(부호 없음) | 최댓값(부호 없음) | 최댓값(부호 있음) |
|-----------|:---------:|:-----------:|:----------:|:----------:|:----------:|
| TINYINT   |     1     |    -128     |     0      |    127     |    255     |
| SMALLINT  |     2     |   -32768    |     0      |   32767    |   65535    |
| MEDIUMINT |     3     |  -8388608   |     0      |  8388607   |  16777215  |
| INT       |     4     | -2147483648 |     0      | 2147483647 | 4294967295 |
| BIGINT    |     8     |    -2^63    |     0      |   2^63-1   |   2^64-1   |



### 날짜타입

- DATE: 날짜 부분만 있고 시간 범위가 없는 것이다. 범위가 `1000-01-01~9999-12-31`까지이다.
- DATETIME: 날짜 시간 부분 다 나오는 것이다. 범위가 `1000-01-01 00:00:00~9999-12-31 23:59:59` 이다. 8바이트의 용량을 가진다.
- TIMESTAMP: 날짜 시간 부분 모두 포함하며 이것은 자동으로 현재 날짜를 지정하고 시간을 알 때 사용한다. 범위는 `1970-01-01 00:00:01~2038-01-19 03:14:07`까지 지원을 한다. 4바이트의 용량이다.


### 문자타입

- CHAR : 고정된 길이의 문자를 저장하는데 CHAR(30)이라고 하면 최대 30글자를 입력할 수 있다. 
- VARCHAR : 가변되는 길이의 문자를 저장하는데 VARCHAR(30)이라고 하면 최대 30글자를 입력할 수 있다.
- CHAR,VARCHAR의 차이 : 위 2개의 차이는 CHAR는 30이라고 지정하면 30만큼 공간을 만들어놓고 VARCHAR는 해당 문자의 길이만큼만 공간을 만든다.
- TEXT: 큰 문자열을 저장하는데 주로 쓰이며 게시판의 본문을 저장하는데 사용한다/
- BLOB: 이밎, 동영상 등 큰 데이터 저장에 사용하며 아마존의 이미지 호스팅 서비스인 S3를 이용하는 등 서버에 파일을 올리고 파일에 관한 경로를 VARCHAR로 저장한다.
- ENUM: 열거형 문자열 타입이다. ('se','su') 이런 식으로 저장하고 단일 선택만 가능하다. 최대 65,535개의 요소들을 넣을 수 있다.
- SET: ENUM과 비슷하지만 여러 개의 데이터를 선택할 수 있고 비트 단위의 연산을 할 수 있고 최대 64개의 요소를 집어넣을 수 있다. 
- ENUM,SET의 경우 단점: 공간적 이점을 볼 수 있지만 정의한 목록을 수정해야 한다는 단점이 있다.


### 관계

- 1:1 : 유저당 유저 이메일의 관계처럼 하나씩 관계를 맺는 것을 말한다.
- 1:N : 한 유저당 여러개의 상품을 가질 수 있는 관계이다.
- N:M : 1:N + 1:M 관계라고 볼 수도 있다. 



### 키

테이블 간의 관계를 조금 더 명확하게 하고 테이블 자체의 인덱스를 위해 설정된 장치이다.

- 기본키 :  PrimaryKey 줄여서 PK라고 부르기도 한다. 유일성과 최소성을 만족하는 키이다.
  - 자연키: 중복된 값들을 자연스럽게 제거하면서 뽑히게 된 키를 자연키라고 한다.
  - 인조키: 인위적으로 ID를 만들어 고유 식별자처럼 사용하는 것이다. 예시로 MYSQL 에서는 auto increment처럼 설정을 한다.
- 외래키 :  Foreign Key 줄여서 FK라고 하며 다른 테이블의 기본키를 그대로 참조하는 값으로 개체와의 관계를 식별하는데 사용한다.
- 후보키 :  candidate key라고도 되며 기본키가 될 수도 있는 후보들이며 유일성과 최소성을 동시에 만족하는 키이다.
- 슈퍼키 :  슈퍼키는 각 레코드를 유일하게 식별할 수 있는 유일성을 갖춘 키이다.
- 대체키 :alternate key라고도 하며 후보키가 두 개 이상일 경우 하나를 기본키로 지정하고 남은 키들을 대체 키라고 한다.

키에 대해서는 제대로 이렇게 개념을 알고 예시들을 통해 확인하는게 좋은 것 같다.

| ID       | num |
|----------|:---:|
| PDT-0001 |  1  |
| PDT-0002 |  2  |   
| PDT-0002 |  2  |  
| PDT-0004 |  4  | 
| PDT-0005 |  8  |


위 테이블의 경우에는? ID에 중복이 되는 PDT-0002이라는 값이 존재해서 ID가 기본키가 될 수가 없다. 유일성이 만족하지 않기 때문이다.

| ID       | num |
|----------|:---:|
| PDT-0001 |  1  |
| PDT-0002 |  2  |   
| PDT-0003 |  2  |  
| PDT-0004 |  4  | 
| PDT-0005 |  8  |

이렇게 되면? ID가 유일한 값들로 이루어져 있기 때문에 ID를 PK로 선정할 수 있다. 

**중요한 것이 최소성이라는 것인데 {ID,num}도 복합키가 될 수는 있지만 최소성을 만족하지 않는다. 왜냐하면 ID라는 갯수가 하나인 키만으로도 구분이 되기에 최소성을 만족하기 위해서는 키가 1개인 후보키들 중 하나로 선정해야 한다.**

이렇게 되면 유일성과 최소성이라는 것을 이렇게 정의할 수 있을 거 같다.
> - 유일성 : 각 행의 유일한 값이어야 한다.
> - 최소성 : 각 행을 유일하게 식별할 수 있는 "최소한의" 속성들의 집합이다.


이 중 그러니까 자연스럽게 중복 없애고 최소성 찾고 하게 되면 자연키, 인위적으로 만들면 인조키이다.

**1**

| ID       | num |
|----------|:---:|
| PDT-0001 |  1  |
| PDT-0002 |  2  |   
| PDT-0003 |  2  | 

**2**

| user-id  | check |
|----------|:-----:|
| PDT-0001 |  yes  |
| PDT-0002 |  yes  |   
| PDT-0003 |  no   |


위 2개의 테이블을 봤을 때 user-id는  1번 테이블의 기본키인 ID를 가지고 있다. 그러면 user-id는 FK 즉 `외래키`라고 불릴 수 있다.


이후의 다른 키들을 보면 1번 테이블에 ID, num, {ID,num} 을 슈퍼키로 가질 수 있다. 왜냐하면 유일성을 만족하기 때문이다.

그렇지만 ID,num은 후보키가 될 수 있고 거기서 선택된 ID를 기본키로 한다면 num이 대체키가 된다. 