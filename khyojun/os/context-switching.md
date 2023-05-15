# 컨텍스트 스위칭


> 가정 : CPU가 싱글 코어일 경우를 말한다.
> - 컨텍스트 스위칭은 프로세스의 컨텍스트 또는 상태를 저장하여 필요할 때 다시 로드하고 이전과 동일한 지점에서 실행을 재개할 수 있도록 한다.
> - 멀티 코어인 경우에는 문맥 교환을 최소화하여 두 프로세스를 나눠서 실행할 수 있기 때문

## Context-Switching이란?

> 멀티프로세스 환경에서 CPU가 어떤 하나의 프로세스를 실행하고 있는 상태에서 인터럽트 요청에 의해 다음 우선 순위의 프로세스가 실행되어야 할 때 기존의 프로세스의 상태 또는 레지스터 값(Context)을 저장하고 CPU가 다음 프로세스를 수행하도록 새로운 프로세스의 상태 또는 레지스터 값(Context)를 교체하는 작업을 Context Switch(Context Switching)라고 한다.


## Context-Switching의 단계

<img src="what-is-context-switching-in-operating-system-context-switching-flow.png">

> 사진 출처 : https://afteracademy.com/blog/what-is-context-switching-in-operating-system/

위 그림과 같은 예시가 대표적이다. 단계별로 진행과정을 보면 다음과 같다.

> 1. 프로세스 P1의 컨텍스트, 즉 실행상태에 있는 프로세스 P1은 PCB1에 저장이 된다. 
> 2. PCB1을 Ready queue, I/O queue 등 관련 queue로 이동시킨다.
> 3. 준비 상태에서 실행할 새 프로세스, 프로세스 P2를 선택한다.
> 4. P2를 실행 상태로 변경시키고 PCB2를 업데이트 한다. 혹시 이전에 P2가 실행된 적이 있으면 그때까지 했던 명령의 위치를 찾아 그곳부터 실행한다.
> 5. 다시 P1을 실행시키려면 위에서 한 단계(1-4단계)를 다시 하면 된다.

> 참고 : Context-Switching이 일어나기 위해서는 일반적으로 최소 2개의 프로세스를 필요로 한다, Round-robin의 알고리즘의 경우 1개의 프로세스만으로 Context Switching이 가능하다.


## Context-Switching의 장단점

### 장점
- 멀티태스킹, 시분할을 통한 멀티프로그래밍을 할수 있게 한다.
  - 멀티 태스킹은 사용자에게 둘 이상의 프로세스가 동시에 실행되고 있는 것처럼 착각시킨다.
  - 그치만 실제로는 엄청나게 빠른 context-switching이 일어나고 있는 것이어서 동시에 일어나는 것처럼 느끼는 거다.

### 단점
- context-switching을 하기 위해선 약간의 시간, 전환 시간이 필요하다는 것이다.
    - 이 시간 동안 CPU가 수행할 수 있는 유효한 작업이 없기 때문에 순수한 오버헤드가 일어난다.

> 오버헤드? : 어떤 처리를 하기 위해 추가적으로 들어가는 간접적인 처리 시간 · 메모리 등을 말한다.


## 컨텍스트 스위칭 트리거(일어나는 상황)

Context-Switching에는 3가지 주요 트리거(일어나는 상황)가 있는데 다음과 같다.

- 멀티태스킹 : 위에서 언급한 것처럼 사용한다.
- 인터럽트 처리 : 하드웨어 인터럽트가 발생할 때 context 일부를 전환하는데 이것은 자동으로 발생시킨다. 필요한 시간을 최소화시키기 위해 일부 context만 변경시킨다.
- 사용자 및 커널 모드 전환 : os에서 사용자 모드 커널 모드 사이의 전환이 필요할 때 context switching이 발생할 수 있다. 
- 자식 프로세스가 Fork를 할 때 : 3번의 경우가 될 수 있다.


### 출처 
- https://gaeunhan.tistory.com/70
- https://www.tutorialspoint.com/what-is-context-switching-in-operating-system#
- https://jeong-pro.tistory.com/93
- https://afteracademy.com/blog/what-is-context-switching-in-operating-system/