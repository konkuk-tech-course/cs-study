## TCP/IP 4계층 모델

 - `인터넷 프로토콜 스위트(internet protocol suite)`란 인터넷에서 컴퓨터들이 서로 정보를 주고 받는데 쓰이는 프로토콜의 집합
 - `인터넷 프로토콜 스위트(internet protocol suite)`를 `TCP/IP(Transmission Control Protocol) 4계층 모델`이나 `OSI 7계층 모델`로 설명함.

### 1. 계층 구조
 - TCP/IP 계층은 4개의 Layer로 이루어져 있으며 OSI 7 Layer와 많이 비교한다.
 - 이 계층 모델은 네트워크에서 사용되는 통신 프로토콜의 집합으로 계층들은 프로토콜의 네트워킹 범위에 따라 네 개의 추상화 계층으로 구성된다.

<sup>[The logical mapping between OSI basic reference model and the TCP/IP stack.](#tcp-ip-and-osi-layer)</sup>![img.png](tcp-ip-and-osi-difference.png)
> 위에서 그림에서 볼 수 있는 계층들은 특정 계층이 변경되었을 때 다른 계층이 영향을 받지 않도록 설계되었다.

##### **1. 애플리케이션(Application) 계층**

- FTP, HTTP, SSH, SMTP, DNS 등 응용 프로그램이 사용되는 프로토콜 계층으로 웹 서비스, 이메일 등 서비스를 실질적으로 사람들에게 제공하는 층이다.
> - `FTP`: 장치와 장치 간의 파일을 전송하는 데 사용되는 표준 통신 프로토콜
> - `SSH`: 보안되지 않은 네트워크에서 네트워크 서비스를 안전하게 운영하기 위한 암호화 네트워크 프로토콜
> - `HTTP`: World Wide Web을 위한 데이터 통신의 기초이자 웹 사이트를 이용하는 데 쓰는 프로토콜
> - `SMTP`: 전자 메일 전송을 위한 인터넷 표준 통신 프로토콜
> - `DNS`: 도메인 이름과 IP 주소를 매핑해주는 서버.

##### **2. 전송(Transport) 계층**

- 송신자와 수신자를 연결하는 통신 서비스를 제공하며 연결 지향 데이터 스트림 지원, 신뢰성, 흐름 제어를 제공할 수 있으며 Application 계층과 Internet 계층 사이의 데이터가 전달될 때 중계 역할을 한다.
- 대표적으로 TCP, UDP가 있다.
> - `TCP`: 패킷 사이의 순서를 보장하고 연결지향 프로토콜을 사용해 연결하여 신뢰성을 구축해 수신 여부를 확인하며 `가상회선 패킷 교환 방식`을 사용한다.
> - `UDP`: 순서를 보장하지 않고 수신 여부를 확인하지 않으며 단순히 데이터만 주는 `데이터그램 패킷 교환 방식`을 사용한다.
> > **가상회선 패킷 교환 방식**이란
> > - 각 패킷에는 가상회선 식별자가 포함되며 모든 패킷을 전송하면 가상 회선이 해제되고 패킷들은 전송된 순서대로 도착하는 방식을 말한다.

>





<details>
<summary>Reference</summary>
<div markdown="1">
<a name="tcp-ip-and-osi-layer">https://www.researchgate.net/figure/The-logical-mapping-between-OSI-basic-reference-model-and-the-TCP-IP-stack_fig2_327483011</a>
</div>
</details>
