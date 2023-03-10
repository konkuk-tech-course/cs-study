# 메모리

> 메모리는 기억을 위한 장치이다.

라고 이전 시간에 컴퓨터의 구성요소를 알아보면서 공부했었다. 오늘은 그 메모리를 집중적으로 알아보자.

## 메모리 계층

> 메모리 계층은 `레지스터`, `캐시`, `RAM(주 기억장치)`, `저장장치(HDD,SSD), 보조기억장치` 순으로 구성된다.
> **메모리 계층 구조(Memory hierarchy)** 란 메모리를 필요에 따라 여러 가지 종류로 나누어 둠을 의미한다. 이때 필요한 대부분의 경우 CPU가 메모리에 더 빨리 접근하기 위함이다.

메모리 계층 구조는 위에서 밑으로 갈 수록 비용이 싸지고, 저장할 수 있는 용량이 커진다는 특징을 가지고 있는데 하나씩 알아보자.

### 레지스터

레지스터는 CPU가 요청을 처리하는데 데 필요한 데이터를 임시로 저장하기 위한 기억장치이다.
이전에 CPU가 제어, ALU, 레지스터 로 구성이 되어있다고 했는데 그 중 레지스터인 것이다.

프로세서에 위치한 고속 메모리로, 프로세스가 바로 사용할 수 있도록 하는 데이터(소량의 데이터, 처리 중인 중간 결과 등)를 담은 영역이다.

그러한 CPU의 레지스터에도 여러 종류들이 있는데 확인해보자.


> - 프로그램 계수기(PC, Program Counter):	다음에 실행할 명령어(instruction)의 주소를 가지고 있는 레지스터
> - 누산기(AC, Accumulator):	연산 결과 데이터를 일시적으로 저장하는 레지스터
> - 명령어 레지스터(IR, Instruction Register):	현재 수행 중인 명령어를 가지고 있는 레지스터
> - 상태 레지스터(SR, Status Register): 현재 CPU의 상태를 가지고 있는 레지스터
> - 메모리 주소 레지스터(MAR, Memory Address Register): 메모리로부터 읽어오거나 메모리에 쓰기 위한
주소를 가지고 있는 레지스터
> - 메모리 버퍼 레지스터(MBR, Memory Buffer Register):	메모리로부터 읽어온 데이터 또는
메모리에 써야할 데이터를 가지고 있는 레지스터
> - 입출력 주소 레지스터(I/O AR, I/O Address Register): 입출력 장치에 따른 입출력 모듈의 주소를
가지고 있는 레지스터
> - 입출력 버퍼 레지스터(I/O BR, I/O Buffer Register):	입출력 모듈과 프로세서 간의 데이터 교환을 위해
사용되는 레지스터

이렇게 많은 종류의 내부 레지스터들이 CPU안에 존재를 한다. 그래서 이 안에 있는 작업들은 레지스터를 통해 하게 되는데 가장 빠르고, 저장공간이 가장 좁다는 것을 알고 가야겠다.


### 캐시 

캐시는 데이터나 값을 미리 복사해 놓는 임시 장소로써, 시스템의 효율성을 위해 사용하는 것이다?

### 시스템의 효율성?

- 캐시라는 임시 저장공간에 접근 시간에 비해 원래 데이터를 접근하는 시간이 오래 걸리는 경우
- 값을 다시 계산하는 시간을 절약하고 싶은 경우

### 캐시의 목적

속도가 빠른 장치(CPU)와 느린 장치(메모리) 사이에서 속도차에 따른 병목 현상을 완화하기 위한 용도이다.
그래서 캐싱이라는 단어도 존재한다.
> 캐싱 : 캐시라고 하는 좀 더 빠른 메모리 영역에서 데이터를 가져와서 접근하는 방식이다.

그래서 예시를 들어보면 여러 메모리 계층이 있지만 레지스터와 RAM사이의 속도 차이를 줄이고자 중간에 캐시라는 계층이 있는 것처럼 약간 중간에 존재하는 중재자같은 존재였다.

그리고 이러한 계층들을 `캐싱 계층`이라고도 부르기도 한다. (캐시 메모리, 보조기억장치 사이 있는 RAM도 캐싱계층이 된다.)


### 캐시의 종류

- CPU 캐시 :  대용량의 메인 메모리 접근을 빠르게 하기 위해 CPU 칩 내부나 바로 옆에 탑재하는 작은 메모리이다.
    - 하드웨어를 통해 관리가 된다.
    - L1,L2,L3 캐시라는 종류의 캐시가 내부에 있다.(여기서 L은 level을 의미한다.)

> - L1 캐시 : 일반적으로 CPU 안에 내장되어 데이터 사용/참조에 가장 먼저 사용된다. 8~64kb정도 용량으로 가장 빠르게 접근, 여기서 못 찾으면 L2캐시 메모리로 넘어간다.
> - L2 캐시 : 용도는 L1과 비슷, 속도는 L1보다 느리며 RAM보다는 빠르다. 용량은 64kb~4MB정도이다.
> - L3 캐시 : 동일한 용도이긴 하지만 웬만한 프로세서는 L3를 달고있지 않는다. L2로도 충분히 커버할 수 있기 때문이다. 그래서 보통 듀얼 코어까지는 L3캐시는 없지만, CPU가 아닌 메인보드에 내장되는 경우가 많다.
            
실질적으로 L3캐시는 CPU 성능에 직접적인 영향을 끼치지는 않는다.

- 디스크 캐시 : 하드디스크에 접근하는 시간을 개선하기 위해 RAM에 저장하는 기법이다. 하드디스크에 접근하는 것보다 RAM에 접근하는게 더 빠르기 때문
    - RAM과 보조기억장치 사이에 존재하는 캐시이다.
  
- 기타 캐시
    - 위 하드웨어에 의해 다뤄지는 캐시와 달리 소프트웨어적으로 관리가 된다.
    - 페이지 캐시 : 운영 체제의 메인 메모리를 하드 디스크에 복사해 놓는 캐시(ex : 웹 브라우저의 웹 페이지 캐시)

### 캐시 설정 : 지역성에 따라

지역성이 뭐냐
> 지역성 : 캐시가 효율적으로 동작하려면, 캐시에 저장할 데이터가 지역성을 가져야 한다. 지역성이란 데이터 접근이 시간적, 혹은 공간적으로 가깝게 일어나는 것을 의미한다.

여기 지역성에는 2가지 종류가 있다. 
> - 시간적 지역성: 특정 데이터가 한번 접근되었을 경우, 가까운 미래에 또 한번 데이터에 접근할 가능성이 높은 것을 시간적 지역성이라고 한다.

메모리 상의 같은 주소에 여러 차례 읽기 쓰기를 수행할 경우 상대적으로 작은 크기의 캐시를 사용해도 효율성을 꾀할 수 있다.

> - 공간적 지역성 : 특정 데이터와 가까운 주소가 순서대로 접근되었을 경우를 공간적 지역성이라고 한다. 

접근된 기억장소와 인접한 기억장소에 접근 될 가능성이 높다는 것을 말한다.

### 캐시 히트와 캐시 미스

- 캐시 히트 : CPU가 참조하고자 하는 메모리가 캐시에 존재하고 있을 경우 캐시 히트라고 한다.
- 캐시 미스 : CPU가 참고하고자 하는 메모리가 캐시에 존재하지 않으면 캐시 미스라고 한다.

그런데 캐시 미스에는 여러가지 종류들이 존재한다고 한다.
- compulsory miss(cold miss) : 해당 메모리 주소를 처음 불렀기 때문에 일어나는 미스이다. (프로그램을 새로 켰을때 일어나게 된다.)
- conflict miss: 캐시 메모리에 a,b를 저장한다고 했을 때 a,b가 같은 캐시 메모리 주소에 할당되어서 일어나는 미스이다.
- capacity miss : 캐시 메모리에 공간이 부족해서 나는 미스

캐시를 히트하게 되는 경우에는 해당하는 데이터를 제어장치를 거쳐서 가져오게 된다. 이 경우 위치도 가깝고 CPU 내부 버스를 기반으로 작동하기 때문에 빠르다.

그러나 캐시미스의 경우에는 메모리에서 가져와야 하는데 시스템 버스를 기반으로 작동하기 때문에 엄청 느리다.

### 캐시매핑 

> 캐시매핑 : 캐시가 히트되기 위해 매핑하는 방법 , CPU의 레지스터와 RAM 간에 데이터를 주고받을 때 기반으로 주로 설명한다.

상대적으로 크기가 엄청 작은 레지스터와 주 메모리가 데이터를 주고 받기 위함인데 레지스터가 캐싱 계층으로써 역할을 잘 해주려면 이런 캐시 매핑을 잘해줘야 캐시 히트가 잘 될거다. 

### 캐시매핑의 종류
- 직접 매핑 : 메인 메모리에서와 동일한 배열을 가지도록 매핑을 한다. -> 메모리 1~100 캐시 1~10이라면 1 :1~10, 2:1~20 이런 식으로 찾는 단순한 방법이다.
    - 장점 : 탐색이 쉽기에 처리가 빠르다
    - 단점 : 충돌 발생이 많이 일어나고, 적중률이 낮다.
- 연관 매핑 : 직접 매핑의 단점을 보완하기 위해 나온 매핑이다. 순서를 일치시키지 않고 관련 있는 캐시와 메모리를 매핑하는 것이다.
    - 장점 : 적중률이 높다.
    - 단점 : 모든 블록을 탐색해야 하기에 속도가 엄청 느리다.
- 집합 연관 매핑 : 직접 매핑, 연관 매핑을 합쳐 놓은 것이다. 두 개의 장점만을 취하기 위하여 만든 방법이다. 순서를 일치시키지만 집합을 둬서 저장하며 블록화를 시킨다고 한다.


### 웹 브라우저의 캐시

소프트웨어적인 대표적인 캐시로 웹 브라우저들의 캐시들이 있다. 종류로는 `쿠키`, `로컬 스토리지`, `세션 스토리지`가 있다.

이러한 캐시들은 주로 사용자의 인증이나 커스텀한 정보들을 나중에 서버에 요청할 때 자신의 id나 중복 요청 방지를 막기 위하여 사용이 되곤 한다.

- 쿠키 : 만료 기한이 있는 키-값 저장소, 4KB까지 데이터를 저장(보안이 잘 안됨)
- 로컬 스토리지: 만료기한이 없는 키-값 저장소, 10MB까지 저장할 수 있고 웹 브라우저를 닫아도 계속 저장이 되어있다. HTML5에 추가된 저장소이다. 클라이언트에서만 수정 가능
- 세션 스토리지 : 만료기한이 없는 키-값 저장소, 탭 단위로 세션 스토리지를 생성하고 탭을 닫으면 해당 데이터 삭제된다. 5MB까지 저장 되고 HTML5에서 추가되었다. 클라이언트에서만 수정 가능

로컬 세션 스토리지는 HTML5에서 추가된 스토리지라고 하는데 HTML5가 아닌 웹 브라우저에서는 사용할 수 없고 클라이언트에서만 수정이 가능하다고 한다. 이 둘의 가장 큰 차이점은 영구성이다.

로컬 스토리지는 데이터를 지우지 않는다면 계속 브라우저에 남아있지만, 세션은 탭을 닫으면 데이터가 자동으로 제거가 된다.


> 참고 : 데이터베이스에서도 캐싱 계층 : redis가 있다. 처음 요청할때는 쿼리를 날려야 하지만 두번째부터는 캐시에 저장되있는 친구를 가져와 사용할 수도 있다. 그러면 쿼리 요청을 줄일 수 있다.

### 주 기억장치(Main Memory)

주 기억장치이며 컴퓨터에서 수치, 명령, 자료 등을 기억하는 컴퓨터 하드웨어 장치이다.

크게 2 종류로 나뉜다.
- RAM : 휘발성 기억 장치, 단기간 저장 구성 요소, 전원이 유지되는 동안 CPU의 연산 및 동작에 필요한 모든 내용 저장, 전원 종료시 기억된 내용 삭제
- ROM : 고정 기억 장치, 비휘발성 메모리
    - 변경 가능성이 희박한 것을 저장 
        - 소프트웨어 : 초기 부팅 관련 부분
        - 하드웨어 : 프린터 작동에 관여하는 펌웨어 명령 등


## 운영체제에서의 메모리 관리

컴퓨터라는 것도 한정적인 자원을 가진 부품이기에 여기에 있는 메모리라는 자원도 관리를 해줘야하는것도 운영체제의 책임이자 역할이다.
어떻게 역할을 수행하는지 알아보자.

### 가상 메모리
> 가상 메모리 : 메모리 관리 기법 중 하나, 실제로 이용 가능한 메모리 자원을 추상화하여 이를 사용하는 사용자들에게 매우 큰 메모리로 보이게 만드는 작업

책 p.148의 사진을 참고하여 설명하자면 가상적으로 주어진 주소를 가상 주소, 실제 메모리상에 있는 주소를 실제 주소라고 부르기로 했다. 이때 가상주소가 MMU라는 메모리관리장치에 의해서 실제 주소로 변환이 되어지기 때문에 사용자가 실제 주소를 의식할 필요 없이 프로그램을 구축할 수 있게 되었다.

### 그래서 진짜 가상 메모리가 뭔데?

라고 묻는다면 
> 가상 메모리(Virtual Memory)는 이러한 물리적 메모리 크기의 한계를 극복하기 위해 나온 기술이다. 프로세스를 실행할 때 실행에 필요한 일부만 메모리에 로드하고 나머지는 디스크에 두는 것이다.

이를 통해서 프로세스 전체가 물리적 메모리에 있는 것 처럼 수행되는 효과를 얻어 수행하게 된다. 그래서 실제로는 메모리에 아주 작은 양의 주소 공간만 있어도 충분히 프로세스를 수행할 수 있는 것이다. 그에 다라 더 많은 프로그램을 동시에 실행할 수 있게 되는거다.

그래서 실 경험으로 게임 속도가 많이 느려지게 되면 가상메모리를 다음과 같이 늘려야 된다는 설정이 나온다.
참고 [가상 메모리 설정](https://develop-project123456789.tistory.com/47)

가상 메모리는 가상 주소와 실제 주소가 매핑되어 있고 프로세스의 주소 정보가 들어 있는 `페이지 테이블`로 관리되는데 이때 `TLB`를 사용한다.

> - 페이징: 어느 정도의 사이즈만큼 메모리에 올릴 지에 대한 결정을 내리기 위하여 나온 단위
> - 페이지 테이블: 가상 주소에 있는 페이지 번호와 해당 페이지의 첫 물리 주소 정보를 매핑한 표
> - TLB: 메모리와 CPU 사이에 있는 주소 변환을 위한 캐시, 페이지 테이블의 리스트를 보관하며 CPU가 페이지 테이블까지 가지 않도록 해 속도를 향상시켜주는 캐시 계층이다.

솔직히 잘 이해가 되지 않는다. 

가상 메모리라는 개념에 대해서 완전 처음부터 가보자. 애초에 프로세스를 실행하려고하는데 모든 전체에 해당하는 프로세스가 다 필요한게 아니라 일부만 필요하기 때문에 일부만 메모리에 로드하고 나머지는 디스크에 놔두는 거다.

그렇게 따지면 가상메모리는 무한대의 크기를 가질 수 있나? -> 이론적으로만 그렇다. 그러나 실제 가상 메모리의 최대 크기는 컴퓨터 시스템이 가진 물리 메모리의 최대 크기로 한정이 된다.

그리고 CPU의 비트에 따라 결정이 된다. 예를 들면 4gb의 메모리를 가진 곳에서 4gb만큼의 프로세스 10개를 실행시키면? 40gb가 필요한데 어떻게 해야될까?

이때 가상 메모리 시스템에서는 물리 메모리의 내용 중 일부를 하드디스크의 일부 공간, 즉 스왑 영역이라는 곳으로 옮기게 되는데!

> 스왑 영역 : 하드디스크에 존재하지만 메모리 관리자가 관리하는 영역으로 메모리의 일부, 가상 메모리의 구성 요소 중 하나.

그래서 만약 물리 메모리가 가득 차면 일부 프로세스를 스왑 영역(스왑 아웃)으로 보내고 몇 개의 프로세스가 작업을 마치면 스왑 영역에 있는 프로세스를 메모리로 가져온다.(스왑인)

이 말을 요약해보면 하드디스크의 일부를 스왑영역으로 사용하는데 가상 메모리 = 스왑 영역 + 물리 메모리를 합친거라고 봐도 된다.


위 스왑 영역을 활용한 것을 어찌보면 스와핑! 이라고 할 수 있다. 



### 요구 페이징 기법

그런데 우리가 보면 그런 말이 또 있다. **전체 프로세스가 필요한 것보다 실행에만 필요한 프로세스만 사용하면 된다.** 여기서 말 그대로 요구 페이징이라는 것은 진짜 내가 당장 사용해야하는 페이지들만 올리는 방식이다.
따라서 특정 페이지에 대한 CPU의 요청이 들어온 뒤 해당 메모리를 적재한다.

그러면 장점은 어떤 것이 있을까?
> 1. 필요한 페이지만 메모리에 적재하기 때문에 메모리 사용량이 감소한다.
> 2. 프로세스 전체를 메모리에 올리는 데 소요되는 입출력 오버헤드가 감소한다.
> 3. 사용되지 않는 주소 영역에 대한 입출력이 줄어 응답시간이 줄어든다.
> 4. 시스템이 더 많은 프로세스를 수용할 수 있게 해준다.
> 5. 물리적 메모리의 제약을 벗어날 수 있다.

>오버헤드? : 오버헤드란 프로그램의 실행흐름에서 나타나는 현상중 하나로 예를 들어 , 프로그램의 실행흐름 도중에 동떨어진 위치의 코드를 실행시켜야 할 때 , 추가적으로 시간,메모리,자원이 사용되는 현상입니다.
한마디로 정의하자면,  오버 헤드는 특정 기능을 수행하는데 드는 간접적인 시간, 메모리 등 자원을 말한다.

이를 예로 들어보면 10초 걸리는 기능이 어떠한 원인으로 20초동안 진행되었다면 10초가 오버헤드 된 것이다.

그래서 아까 필요한 친구만 올려놓는다고 했는데 그 기준을 *유효/무효 비트(valid/invalid bit)를 두어 각 page가 메모리에 존재하는지 표시하게 된다. 만약 찾고자 하는 친구가 무효 비트를 나타내면 페이지 폴트를 일으킨다.
>*유효/무효 비트 : 해당 비트가 유효하면 메모리에 있음을 의미하고, 무효하면 메모리에 없음을 의미합니다.


### 스와핑

> 하드디스크의 일부분을 마치 메모리처럼 불러와 쓰는 것을 스와핑이라고 한다.

### 페이지 폴트

> 페이지 폴트(page fault)란 프로세스의 주소 공간에는 존재하지만 지금 이 컴퓨터의 RAM(물리 메모리)에는 없는 데이터에 접근했을 때 발생! 그로 인한 스와핑이 일어나게 된다.

1. CPU는 물리 메모리를 확인하여 해당 페이지가 없으면 트랩(sw 인터럽트)를 발생시켜서 운영체제에 알린다.
2. 운영체제는 CPU의 동작을 잠시 멈춘다.
3. 운영체제는 페이지 테이블을 확인해 가상 메모리에 페이지가 존재하는지 확인하고, 없으면 프로세스를 중단하고 현재 물리 메모리에 비어 있는 프레임이 있는지 찾는다. 그 이후 물리 메모리에도 없으면 스와핑이 일어난다.
4. 비어 있는 프레임에 해당 페이지를 로드하고, 페이지 테이블을 최신화시킨다.
5. 중단된 CPU를 다시 시작한다.

이 과정에서 스왑인이 실행된거라고 볼 수 있다.

> 페이지: 가상 메모리를 사용하는 최소 크기 단위
> 프레임 : 실제 메모리를 사용하는 최소 크기 단위

## 페이지 교체 알고리즘

>  필요한 페이지가 메모리에 없을 때 page-falut가 발생하고 Backing Store에서 해당 페이지를 찾아 빈 프레임에 로딩해야 하는데, 이때 빈 프레임이 없을 경우 희생 당할 프레임(victim frame)을 고르는 알고리즘이 페이지 교체 알고리즘이다.

페이지 교체 알고리즘은 page-fault 발생 비율을 줄이는 것을 목표로 한다.

### 오프라인 알고리즘

이 알고리즘은 사용할 수는 없지만 성능의 기준으로 사용하기 위해 있다고 한다.
> 오프라인 알고리즘은 먼 미래에 참조되는 페이지와 현재 할당하는 페이지를 바꾸는 알고리즘이다.


### OPT(Optimal)

>OPT 알고리즘 : 앞으로 가장 오랫동안 사용되지 않을 페이지 교체
- 가장 이상적이다.
- 프로세스가 앞으로 사용할 페이지를 미리 알아야 함 -> 불가능
- 비교 연구 목적을 위해 사용됨


### FIFO(First Input First Output)

>FIFO 알고리즘 : 가장 먼저 온 페이지를 교체 영역에 가장 먼저 놓는 방법

### LRU(Least Recentle Used)

가정: 가장 오랫동안 사용하지 않았던 데이터라면 앞으로도 사용할 확률이 적을 것이다.

> LRU 알고리즘 : 가장 오랫동안 사용하지 않은 페이지를 교체

이 방식은 어찌보면 자원이 많이 필요하다. 오래된 것이라는 기준이 있기에 그에 대한 것을 파악하기 위해 `계수기`, `스택`을 둬야 하기 때문이다.

단점: 프로세스가 주기억장치에 접근할때마다 참조된 페이지 시간을 기록해야 하므로 막대한 오버헤드가 발생
카운터나 큐, 스택과 같은 별도의 하드웨어가 필요

### LFU(Least Frequently Used)

> LFU 알고리즘 : 참조 횟수가 가장 낮은 페이지를 교체

이것도 어찌보면 자원이 필요하다. 참조 횟수를 체크해야 되기 때문이다.

단점 : 가장 최근에 불려온 페이지가 바로 교체 될 수도 있다. 구현도 복잡하다, 막대한 오버헤드가 발생한다.

### MFU(Most Frequently Used)

> MFU 알고리즘 : 가장 많이 참조된 페이지를 교체

이 알고리즘은 가정이 필요한데 가장 많이 사용이 됬으면 앞으로 사용이 안 될 것이라는 가정이다.

### NUR(Not Used Recently) or Clock

> NUR 알고리즘 : 최근에 사용하지 않은 페이지를 교체한다는 것이다. 이 측면에서 LRU와 비슷한데 거기서 발전한 것이다. clock 알고리즘이라고도 부른다.

0과 1의 비트를 사용하여 최근에 참조되었는지 아닌지를 판단한다. 시계 방향으로 돌면서 0을 찾고 0을 찾는 순간 해당 프로세스를 교체하고 해당 부분을 1로 바꾸는 식으로 진행이 된다.

장점 : 적은 오버헤드로 적절한 성능
단점 : 교체되는 페이지의 참조 시점이 가장 오래되었다는 것을 보장하지는 못함

그런데 비트도 2개가 있다.
1. 참조 비트 : 페이지가 참조되었을 때 1 아닐 때 0 (모든 참조비트를 주기적으로 0으로 변경한다.)
2. 변형 비트 : 페이지 내용이 변경되지 않았을 때는 0, 변경되면 1이다.

> 출처 : [페이지 교체 알고리즘](https://doh-an.tistory.com/28#:~:text=%F0%9F%92%A1%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B5%90%EC%B2%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98&text=%ED%8E%98%EC%9D%B4%EC%A7%95%20%EA%B8%B0%EB%B2%95%EC%9C%BC%EB%A1%9C%20%EB%A9%94%EB%AA%A8%EB%A6%AC%EB%A5%BC,%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B5%90%EC%B2%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%B4%EB%9D%BC%EA%B3%A0%20%ED%95%9C%EB%8B%A4)




### 스레싱

> 스레싱 : 메모리의 페이지 폴트율이 높은 것을 의미, 이는 컴퓨터의 심각한 성능 저하를 초래한다. 

스레싱은 어찌보면 악순환이라고 불러도 될 거 같다. 왜냐하면 페이지 폴트율이 올라가게 되면 위 과정처럼 CPU가 멈추는 단계가 일어난다.

그런데 이렇게 CPU가 멈춰서 이용률이 낮아지면 운영체제는 "얘가 일을 안하네?"라고 인식해서 많은 프로세스를 또 메모리에 올린다. 그러면 계속 악순환이 돌게 되는 거다.

그래서 이를 해결하기 위해서는 메모리를 늘리거나, HDD를 SSD로 바꾸는 방법이 있다.

또 다른 방법으로는 운영체제에서 이를 해결할 수 있도록 작업 세트, PFF라는 방법들이 있다.
그리고 또 스레싱을 해결하기 위해서는 정적 할당 방식, 동적 할당 방식으로 크게 나눌 수 있다.
  
> 출처 : [스레싱 관련](https://straw961030.tistory.com/155)

### 정적 할당 방식

> 정적할당은 프로세스 실행 초기에 프레임을 나누어준 후 그 크기를 고정하는 것으로 균등 할당 방식과 비례 할당 방식이 있다. 

- 균등 할당 방식 : 균등 할당 방식은 프로세스의 크기에 상관없이 모든 프로세스들에게 동등하게 사용 가능한 프레임을 나누어주는 것이다.
- 비례 할당 방식 : 비례 할당 방식은 프로세스의 크기에 비례하여 프레임을 할당하는 방식이다.

그런데 이러한 정적 할당 방식들은 문제점이 있다.

1. 프로세스가 실행 중에 필요로 하는 프레임을 유동적으로 반영하지 못한다.
>예를 들어, 동영상 플레이어같은 경우에는 프로그램 자체는 프로세스의 크기가 작아 그에 맞는 프레임을 실행 초기에 할당받을 것이다. 하지만, 동영상 재생을 위해 용량이 큰 동영상을 불러온다면 더 많은 프레임이 요구된다.
이러한 경우에 정적 할당 방식은 프로세스가 실행되면서 유동적으로 프레임을 반영하지 못한다.


2. 사용하지 않은 메모리를 처음부터 미리 확보하여 공간을 낭비한다.

>정적 할당 방식은 큰 프로세스를 실행하면서 당장 필요 없는 프레임을 미리 할당하기 때문에 메모리가 낭비된다.

그래서 이러한 문제점들이 있었기에 동적 할당 방식이 나오게 되었다.

### 동적 할당 방식

동적 할당 방식에는 책에서 언급한 작업세트, PFF가 있다.

### 작업세트(working set)
>  프로세스가 일정 시간 동안 집중적으로 특정 주소 영역을 참조하는 경향이 있는데 이를 지역성 집합이라고 합니. 워킹셋 알고리즘은 지역성 집합이 메모리에 동시에 올라갈 수 있도록 보장하는 메모리 관리 알고리즘입니다.

워킹셋은 한꺼번에 메모리에 올라가야 하는 페이지들의 집합인데 한꺼번에 올라갈 수 있는 메모리 공간이 있을 때만 동작을 하게 된다. 그렇지 않은 경우에는 기존 메모리의 페이지를 디스크로 스왑 아웃 시켜 공간을 확보한다.
이런 방법으로 하면 미리 메모리에 로드를 하기에 탐색에 드는 비용을 줄이고 스와핑 또한 줄일 수 있다고 한다.

여기서 알아야하는 용어가 2가지가 있다. `working set size`, `working set window` 이다.

- working set size : 물리 메모리에 유지할 페이지의 크기를 의미하며 작업집합에 들어갈 최대 페이지의 수를 의미한다.
- working set window : 현재 시점에 최대 어느 범위까지의 페이지를 살펴볼 것인가를 결정하는 것이다.

그래서 중요한 것이 이 set window의 사이즈를 잘 봐야 한다. 크기에 따라 프로세스의 실행 성능이 달라진다고 한다. 

너무 크게 할 경우에는 필요 없는 페이지가 메모리에 올라갈 수 있고 너무 작게 하면 필요한 페이지가 스왑 영역으로 옮겨지기 때문에 잘 조절해야 한다.

그런데 이 방식에는 단점이 있다.

>충분한 페이지를 할당하지 않으면 작업집합에 있는 페이지를 물리 메모리에 유지하기 힘든 단점

어떤 프레임을 물리 메모리에 유지해야 하는지는 알 수 있지만 프로세스에게 프레임을 얼마나 할당해야하는지를 알 수 없다. 그러다보면 프로세스의 성능만 높아지지 스레싱의 문제를 해결을 못 할 때도 있다.

### PFF(Page Fault Frequency)

페이지 폴트 빈도를 조절하는 방법으로 상한선과 하한선을 만들어서 상한선에 도달하면 프레임을 늘리고 하한선에 도달하면 프레임을 줄이는 것이다.


### 메모리 할당

메모리에 프로그램을 할당할 때는 시작 메모리 위치, 메모리의 할당 크기를 기반으로 할당을 하게 된다. 그때 `연속 할당`, `불연속 할당`으로 나뉘게 된다.

### 연속 할당

연속된 하나의 큰 메모리에서 프로세스에 메모리를 할당시켜주는 기법인데 2가지가 있다.

- 고정크기 메모리할당: 메모리를 고정된 크기로 나누고 프로세스를 할당시킨다.
  - 미리 정해진 크기로 나누기 때문에 융통성이 없다.
  - 내부 단편화가 일어나게 된다.
- 가변크기 메모리할당: 프로세스마다 요구되는 메모리 크기에 맞춰서 메모리를 할당시킨다.
  - 내부 단편화는 발생하지 않고 외부 단편화가 발생할 수 있다. 
  - 가변크기 할당 방식에는 최초적합, 최적적합, 최악적합에 따라 할당을 하게 된다.
    - 최조 적합(first fit): 위쪽이나 아래쪽부터 시작해서 비어있는 곳을 찾으면 바로 할당한다.
    - 최적 적합(best fit): 프로세스의 크기 이상인 공간 중 가장 작은 공간부터 할당한다.
    - 최악 적합(worst fit): 프로세스의 크기와 가장 많이 차이가 나는 비어있는 곳에 할당한다.

> - 내부 단편화 : 메모리를 나눈 크기보다 프로그램이 작아서 들어가지 못하는 공간이 많이 발생하는 현상
> - 외부 단편화 : 메모리를 나눈 크기보다 프로그램이 커서 들어가지 못하는 공간이 많이 발생하는 현상
> - 홀(hole) : 할당할 수 잇는 비어 있는 메모리 공간

### 불연속 할당

하나의 프로세스가 물리적 메모리의 여러 위치에 분산되어 올라갈 수 있는 메모리 할당 기법이다. 이 기법은 현대 운영체제가 쓰는 방법으로 `페이징 기법`, `세그멘테이션`, `페이지드 세그멘테이션`이 있다.

### 페이징 기법

>페이징 기법 : 프로세스의 주소 공간을 동일한 크기의 페이지 단위로 나누어 물리적 메모리의 서로 다른 위치에 페이지들을 저장하는 방식
   - 홀의 크기가 균일하지 않은 문제가 없어지지만 주소 변환이 복잡해질 수 있다.(분산 시켜놨기 때문에)
   -  페이징 기법은 동적 메모리 할당 문제(메모리 주소 공간 결정 문제)가 발생하지 않는다는 강점을 가진다.
   - 어떠한 빈 공간이든 활용을 할 수 있기 때문에 외부 단편화 문제는 일어나지 않는다.
   - 프로그램의 크기가 항상 페이지 크기의 배수가 된다는 보장이 없기 때문에 프로세스의 주소 공간 중 제일 마지막에 위치한 페이지에서는 내부조각이 발생할 가능성이 있다.

### 페이징 기법의 페이지 테이블이 있는 이유

> 특정 프로세스의 몇 번째 페이지가 물리적 메모리의 몇 번째 프레임에 들어 있다는 페이지별 주소 변환 정보를 유지하고 있어야 한다. 따라서 페이징 기법에서는 모든 프로세스가 각각의 주소 변환을 위한 페이지 테이블(page table)을 가지며, 이 테이블은 프로세스가 가질 수 있는 페이지의 개수만큼 주소 변환 엔트리를 가지고 있게 된다.

즉 논리 주소를 통해 물리 주소를 알아야 하기 때문이다.

### 페이지 테이블에 접근하기 위해 운영체제가 사용하는 방법

운영체제가 페이지 테이블에 접근하기 위하여서 2개의 레지스터를 주로 사용한다고 한다.

1. 페이지 테이블 기준 레지스터(page table base register) : 페이지 테이블 시작 위치
2. 페이지 테이블 길이 레지스터 (page table length register) : 페이지 테이블 의 크기

그런데 이러한 정보를 얻어내려면 물리적 메모리에 저장되어있기 때문에 접근을 해야한다. 그런데 문제가 일어난다.

실제 물리적 메모리의 주소를 알기 위해서는 
1. 페이지 테이블에 접근하기 위해 물리적 메모리에 접근
2. 실제 물리적 메모리를 얻기 위한 접근

총 2번의 메모리 접근을 하게되는 오버헤드가 발생한다. 
이와 같은 문제를 해결하기 위해 TLB(Translation Look-aside Buffer)라고 불리는 고속의 주소 변환용 하드웨어 캐시를 사용한다.

TLB는 굉장히 비싸다. 그래서 속도는 빠르지만 용량은 되게 적어서 모든 정보가 다 들어있지는 않다. 그래서 TLB를 확인해도 원하는 페이지 정보를 확인 할 수 없다면 페이지 테이블을 방문하여 물리적 메모리 주소를 확인한다.

어찌보면 캐시 히트 미스와 같은 부분일 수도...


### 세그멘테이션

> 세그멘테이션 : 프로세스의 주소공간을 의미 단위의 세그먼트로 나누어 물리적 메모리에 올리는 방법이다.

일반적으로 프로세스의 주소 공간은 data, code, stack 등의 의미로 나뉘는데 각각의 기능 단위를 세그먼트라고도 하고 하나로 묶어서 세그먼트라고도 한다.

세그먼트로 할 수는 있지만 문제는 각 세그먼트가 동일한 크기를 갖지 않는다는 것이다.(의미로만 나눴기 때문에)

### 세그먼트 테이블

이전 페이징 기법처럼 세그먼트 테이블도 존재를 한다. 그 안에는 2가지 정보를 가지고 있다.

- 기준점(base) : 물리적 메모리에서 세그먼트의 시작 위치
- 한계점(limit) : 세그먼트의 길이

페이징 기법이랑 거의 비슷하게 여기도 레지스터 2개를 또 사용한다.

- 세그먼트 테이블 기준 레지스터(STBR) : 프로세스의 세그멘트 테이블 메모리 위치(시작 주소)
- 세그먼트 테이블 길이 레지스터(STLR) : 프로세스 세그멘트의 총 개수

### 세그멘테이션의 주소 변환 방법
>세그먼테이션 기법에서는 논리적 주소를 물리적 주소로 변환하기 전에 두 가지 항목을 체크합니다.
> 1. 요청된 세그먼트의 번호가 STLR 미만의 값인지 확인합니다. 만약 그렇지 않다면 존재하지 않는 세그먼트에 대한 접근으로 예외상황을 발생시켜 메모리에 접근 봉쇄합니다.
> 2. 논리적 주소의 오프셋 값이 그 세그먼트의 길이보다 작은 값인지 확인합니다. 만약 그렇지 않다면 세그먼트 테이블의 길이를 넘어서는 오프셋 위치에 대한 접근으로 예외상황을 발생시켜 메모리에 접근 봉쇄합니다.


### 세그멘테이션의 장단점

- 장점 : 공유와 보안의 측면에서 페이징 기법에 비해 효과적이다.(의미 단위로 나눴기 때문에 특정 주소 공간에 접근할 경우 찾기 쉽다.)
- 단점 : 외부 단편화가 일어나게 된다. 왜냐하면 의미별로 나눠서 길이가 균일하지 않기 때문이다.


### 페이지드 세그멘테이션

페이지드 세그멘테이션은 2가지를 합친거다. 페이징 기법 + 세그멘테이션 기법의 장점만 빼왔다.

세그멘테이션처럼 프로세스를 의미 단위로 분할하되, 불규칙한 길이가 아닌 동일한 크기의 페이지들의 집합으로 구성한다.


### 페이지드 세그멘테이션 테이블

하나의 세그멘트를 여러개의 페이지로 구성이 되기 때문에 테이블도 2개를 사용해야 한다.

- 외부의 세그멘트 테이블
- 내부의 페이지 테이블


### 테이블을 이용한 주소 변환 기법
페이지드 세그먼테이션 테이블을 활용하여 주소변환 하는 과정은 다음과 같다.


1. 논리적 주소의 상위 비트인 세그먼트 번호를 통해 세그먼트 테이블의 해당 항목을 확인한다.

2. 해당 항목에는 세그먼트의 길이와 세그먼트의 페이지 테이블 시작 주소가 있다.

3. 세그먼트 길이를 넘어선 메모리 접근인지 체크한다. 유효하지 않다면 트랩을 발생시킨다.

4. 오프셋 값을 상위/하위 비트로 나누어 상위비트는 세그먼트 내의 페이지 번호로 사용하고, 하위 비트는 페이지 내에서의 변위로 사용한다.

> Offset : 기준 주소에서 얼만큼 떨어진 곳에 떨어진 메모리를 지칭

> 출처 : [불연속 할당 관련](https://zangzangs.tistory.com/141)



### 출처
- [캐시](https://12bme.tistory.com/402)
- [메모리](https://velog.io/@yu-jin-song/CS-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B3%84%EC%B8%B5-%EA%B5%AC%EC%A1%B0)
- [디스크 캐시](https://mygumi.tistory.com/275)
- [캐시](https://ko.wikipedia.org/wiki/%EC%BA%90%EC%8B%9C)
- [가상 메모리](https://velog.io/@chappi/OS%EB%8A%94-%ED%95%A0%EA%BB%80%EB%8D%B0-%ED%95%B5%EC%8B%AC%EB%A7%8C-%ED%95%A9%EB%8B%88%EB%8B%A4.-14%ED%8E%B8-%EA%B0%80%EC%83%81-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B0%9C%EC%9A%94-%ED%8E%98%EC%9D%B4%EC%A7%95)
- [스레싱](https://zangzangs.tistory.com/144#:~:text=%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4%EA%B0%80%20%EC%A7%91%EC%A4%91%EC%A0%81%EC%9C%BC%EB%A1%9C%20%EC%82%AC%EC%9A%A9,%EC%9D%84%20%EC%8A%A4%EB%A0%88%EC%8B%B1%EC%9D%B4%EB%9D%BC%EA%B3%A0%20%ED%95%A9%EB%8B%88%EB%8B%A4)
- [페이지 교체 알고리즘](https://doh-an.tistory.com/28#:~:text=%F0%9F%92%A1%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B5%90%EC%B2%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98&text=%ED%8E%98%EC%9D%B4%EC%A7%95%20%EA%B8%B0%EB%B2%95%EC%9C%BC%EB%A1%9C%20%EB%A9%94%EB%AA%A8%EB%A6%AC%EB%A5%BC,%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B5%90%EC%B2%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%B4%EB%9D%BC%EA%B3%A0%20%ED%95%9C%EB%8B%A4)



주소 : 물리적 주소 + 논리적 주소
논리적 주소는 Base Register에서 물리적 주소를 통해 시작 주소를 알 수 있기 때문에
항상 0번에서 부터 시작 논리적 주소는 CPU 내부에 저장되는 것이 아닌 0부터 ~ N 자체적으로 생성하고
MMU를 통해 물리적인 주소 변환



### 추가로 생각해볼 요소들

물리적 주소는 논리적 주소를 mmu를 통해 매핑한 결과를 얻는 주소
내부/외부 단편화의 실질적인 상황에 대한 설명을 의논해 볼 필요성
단편화를 줄이는 방법들의 대한 의논
왜 알고리즘이 변경되었을까?
페이징과 세그먼트를 나눈 이유?
페이징 교체 알고리즘이 상황별 어떤 방식을 취했을 때 단편화를 줄일 수 있나?
