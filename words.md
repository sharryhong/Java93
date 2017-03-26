# 개발 용어 

- Node : 예) 탐색기는 트리노드 
- Context Menu(일반인 : Popup Menu) : 상황에 맞는 메뉴. 예) 노드를 마우스 오른쪽버튼 눌렀을 때 나오는 메뉴 

#### 정형 데이터, 비정형 데이터 
- 정형 데이터 : 엑셀, DBMS(디비 관리 시스템)처럼 형식이 있는 데이터
 - 원하는 데이터를 찾기 쉽다. 
- 비정형 데이터 : 워드, 이메일, 게시글의 내용, 보고서처럼 형식이 없는 데이터 
 - 원하는 데이터 찾으려면 검색기능이 필요하다.

#### build
실행 최적상태로 명령어를 만드는 동시에 실행가능 구조로 미리 세팅(배치)해놓는것
- 실행 최적상태 : object file =  binary = p-code = bytecode(자바) 라고 부른다
- build를 하면 문법검사 : source에 문법적 오류가 있는지 확인, 기계어 번역 등

#### 파일과 실행 프로그램의 관계 
- `doc`  ---> word processer 등의 실행 프로그램 
- `.fla`  ---> Flash Player 실행프로그램 
- `script`(명령어를 작성할 때 사용하는 언어) ---> Engine = Interpreter(인터프리터, 해석기) = Player = Virtual Machine(가상머신).. 모두 같은 말 

#### Engine 엔진 
- = Player 플레이어 = Interpreter 인터프리터 = Virtual Machine 가상머신
- 스크립트나 특정 형식의 데이터를 읽어서 처리하는 프로그램을 말한다. 

#### 스크립트(Script)
- 명령어를 작성할 때 사용하는 언어
- text로 작성한다. 
- 대형 프로그램 작성이 아닌 소형 프로그램 작성용 
- 보통 별도의 변환 과정을 거치지 않고 작성한 원본 명령을 그대로 실행한다. 
- 예) JavaScript, VB Script, Perl, PHP, Python, Action Script 등 

#### 스크립트 엔진(Script Engine(=Player =Interpreter = Virtual Machine))
- 스크립트를 읽어서 실행시키는 프로그램 
- 자바스크립트 엔진, PHP 엔진 등 

#### 프로세스 
현재 실행중인 프로그램 <br>
- 프로세스 스케줄링 : cpu에서 프로세스 관리 

#### 엄격한 언어 
개발자가 잘못사용함으로서 시스템 오류를 발생시키는 것을 방지하기 위해. 큰 시스템의 개발 <br>
예) Java, C++ 등