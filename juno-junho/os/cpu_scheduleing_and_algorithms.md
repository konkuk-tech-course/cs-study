# 3.4 CPU 스케줄링 알고리즘

## CPU 스케줄러와 Dispatcher의 차이
- CPU Scheduler: CPU가 쉬지 않고 일할 수 있도록 프로세스를 선택하는 역할.
    - ready 상태 process를 모아놓은 ready queue에 실행되길 원하는 ㅍ로세스들이 기다리고 있는데, CPU 스케줄러가 CPU에서 실행될 프로세스를 선택하는 역할을 한다.
- Dispatcher: 선택된 process를 실제 CPU에서 실행될 수 있도록 만드는 역할을 한다.
  - 선택된 process에게 CPU를 할당하는 역할. 
  - Context Switching 역할을 한다. (CPU와 관련된 민감한 작업이기 때문에, OS에서 조심스럽게 다루어야 하므로 kernel mode에서 실행하는데, kernel 모드에서 user 모드로 전환 역할을 dispatcher가 한다)
  - 새로운 선택된 프로세스를 실행 될 수 있게 다시 user모드로 전환되는데, control을 새로운 process에게 넘겨준다.
  - 새롭게 선택된 process가 어디서부터 작업을 시작해야 할지 실행되어야할 적절한 위치로 선택된 process를 이동하는 역할을 한다.

## 스케줄링의 선점 방식
- 스케줄링의 선점 방식에는 비선점 스케줄링(Non-preemptive Scheduling)과 선점 스케줄링(preemptive Scheduling)이 있다.

### Non-preemptive Scheduling (비선점 스케줄링)
하나의 프로세스가 cpu에서 실행중인 `RUNNING` 상태일때, exit되어 `TERMINATED` 상태가 될 수도 있고, IO 작업을 위해 `WAITING` 상태가 될 수도 있고,
자발적으로 다른 process에서 CPU를 사용할 수 있도록 interrupt를 발생시켜 양보하여 `READY` 상태가 될 수도 있다.

이 세 가지 상태에 대해서만 (TERMINATED, WAITING, READY) OS가 개입하여 스케줄링 하는 것을 비선점 스케줄링이라고 한다.

* 비선점인 이유 : 모든 세가지 경우가 프로세스가 **자발적으로** RUNNING 상태에서 빠져나가기 때문에 비선점 방식이라고 한다.
* CPU에서 실행되는 Process가 OS의 강제적인 개입 없이 자발적으로 실행되는 것이다.

비선점 스케줄링(Non-preemptive Scheduling)의 특징: 
 - 신사적(OS 입장에서는 process가 CPU를 다 쓸때까지 기다려줌)
 - 협력적(**Cooperative**): 프로그램 레벨에서 서로 협력해야만 번갈아가면서 CPU를 사용하는 것이 가능하기 때문에 (스스로 양보하고 턴을 넘기는 개념) -> Cooperative는 co-routine에서도 나옴
 - 느린 응답성: CPU 다 쓸때까지 프로세스를 기다려 주는 것이기에 사용자 입장에서는 응답성이 느리다고 느낄 수 있다.

### Preemptive Scheduling (선점 스케줄링)
Non-preemptive 스케줄링이 하는 역할을 다 한다. 거기에 **추가적으로** 프로세스가 CPU에서 실행이 다 끝나지 않았음에도 개입하는 경우가 있다.

예를 들어, multi-tasking에서 time slice를 다 쓰면 CPU 작업이 다 끝나지 않아도 ready Queue로 돌아와야 한다. 

WAITING 상태의 프로세스가 IO 작업이 완료되어 READY상태로 된다. READY 상태의 프로세스가 CPU에서 지금 실행되고 있는 프로세스보다 우선순위가 더 높다면 바로 CPU에서 실행시키고 싶을때 사용 
RUNNING 상태의 프로세스가 충분히 CPU를 사용하지 않았음에도 강제로 READY 상태로 바꾸는 것을 선점 스케줄링이라고 한다.

선점 스케줄링(preemptive Scheduling)의 특징:
 - 적극적
 - 강제적
 - 빠른응답성
 - 데이터 일관성의 문제 (Critical Section, 동기화를 위한 lock과 연결)

## 스케줄링 알고리즘

[//]: # (### 비선점 스케줄링&#40;Non-preemptive scheduling&#41; 알고리즘)
- FCFS(First-Come, First-Served): 가장 먼저 온 것을 가장 먼저 처리하는 알고리즘.
   - Queue 방식대로 처리하는 것이다.
   - 준비된 queue에서 오래 기다리는 현상인 `convey effect`가 발생할 수 있다.
- SJF(Shortest-Job-First): 프로세스의 다음 CPU burst가 가장 짧은 프로세스로 부터 실행한다.
- SRTF(Shortest-Remaining-Time-First): 남은 CPU burst가 가장 짧은 프로세스 부터 실행한다.
  - SJF에서 preemptive 방식이 적용된 방식을 말한다.
- Priority: 우선순위가 높은 프로세스 부터 실행한다.
  - 문제: starvation(기아 상태) 혹은 무한 봉쇄(indefinite blocking) 발생 할 수 있음.

[//]: # (### 선점 스케줄링&#40;Preemptive scheduling&#41; 알고리즘)
- Round Robin(라운드 로빈): time slice로 나눠진 CPU 타임을 번갈아 가면서 실행하는 방식이다. 
  - multi-tasking과 가장 비슷한 스케줄링 방식이다.
  - time slice, time quantum이 매우 크면,FCFS와 비슷해진다
- Multi-level Queue(다단계 큐): 프로세스들을 더 중요한 것/ 덜 중요한것으로 그룹화 시켜 그룹마다 큐를 두는 방식을 말한다.
  - group간에도 우선순위가 있고, group마다 또 자기만의 스케줄링 방식이 있다.
  - scheduler는 multi level queue로 두고, 우선순위에 따라 group1에서 끝날지 group2에서 끝날지를 결정한다. 그리고 각 queue안에서 각각의 스케줄링 방식으로 프로세스를 꺼내개 되는 방식

### 기아상태(Starvation)란?
- 특정 프로세스가 우선순위가 낮아 원하는 자원을 계속 할당 받지 못하는 상태를 starvation, 기아 상태라고 한다.

**Starvation과 Deadlock**
- Deadlock: 프로세스가 자원을 얻지 못해 다음 처리를 못하는 상태
- Starvation: 프로세스가 원하는 자원을 계속 할당 받지 못하는 상태
- 주로 deadlock은 여러 프로세스가 동일 자원 점유를 요청할 때 발생하고, starvation은 여러 프로세스가 부족한 자원을 점유하기 위해 경쟁할 때 특정 프로세스는 영원히 자원 할당이 안되는 경우를 말한다.

**Starvation이 발생하는 스케줄링 알고리즘**
- SJF: CPU burst가 긴 프로세스는 거의 영원히 CPU를 할당 받을 수 없다.
- SRT: 긴 burst time을 가진 프로세스는 영원히 할당 받을 수 없다.
- Priority: 우선 순위가 낮다면 할당받기 어려워 기아 상태가 발생할 수 있다.


**해결책**
- Aging 기법: 오래 기다린 프로세스의 우선 순위를 높여준다.
- 우선 순위가 아닌 요청 순서대로 처리하는 FIFO 기반 요청 큐를 사용한다.

Reference: 
- [기아상태](https://velog.io/@woga1999/Starvation-%EA%B8%B0%EC%95%84-%EC%83%81%ED%83%9C-%EB%9E%80)
  - [CPU 스케줄러와 스케줄링](https://www.youtube.com/watch?v=LgEY4ghpTJI&list=PLcXyemr8ZeoQOtSUjwaer0VMJSMfa-9G-&index=9)


