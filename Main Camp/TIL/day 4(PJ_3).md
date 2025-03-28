[본캠프 4일차]Onboarding_Mini_Project

### 주간 과제

프로젝트 명 : 팀원을 소개하는 웹페이지 만들기
기간 : 2.17 ~ 21
맡은 역할 : 메인 페이지 등록/삭제 기능 & 데이터베이스

- git 주소 : https://github.com/s-woni/Onboarding-Mini-Project
- 팀 노션 : https://www.notion.so/teamsparta/13-19d2dc3ef51480489ac9c060183149f4

# 1. 마무리
> - 통합된 코드 확인 및 테스트  
> - 발표자료 준비

### 1. 추가 기능 구현
* 멤버 카드 수정
    * 수정 버튼 추가 및 데이터베이스 값 수정



# 2. 겪었던 문제점 & 에러
* 데이터베이스에 존재하는 값을 불러와 멤버카드를 수정
    * html에 존재하는 모달 템플릿을 불러와 사용
    * 수정버튼을 누른 뒤 카드가 수정되는 것이 아닌 수정된 값으로 새로운 카드 생성
    * 이미 있는 모달 템플릿을 가져와 버튼의 id값을 수정하지 않아 클릭 이벤트가 충돌함
    * 해결방안 1 : edit 버튼을 누를 때 버튼의 id값 변환  
    -> 수정하기 버튼을 누른 뒤, 클릭했던 멤버카드의 데이터값이 등록하기 버튼을 눌렀을 때 나오는 모달에 남아있음   
    -> 등록하기 버튼을 눌렀을 때 모달 초기화  
    -> 수정하기 버튼을 누르면 그 멤버카드의 인덱스 값을 불러와 데이터 값을 수정하는데 충돌이 있었는지 문서의 인덱스 값을 찾을 수 없는 오류 발생
    * 해결방안 2 : 수정하기 버튼 추가  
    -> 등록하기 버튼을 눌렀을 때는 숨겨 저장하기 버튼만 보이고, edit 버튼을 누르면 저장하기 버튼을 숨겨 수정하기 버튼만 보일 수 있도록 설정  
    -> 인덱스값을 읽어오지 못하는 오류 발생   
    -> `const q = query(collection(db, "members"), where("index", "==", parseInt(index)));`   
    인덱스값을 숫자로 변환시켜 저장된 값과 필요한 값의 타입을 일치 시킴  
        * 새롭게 생성되는 카드 없이 수정됨

# 3. 내일 할 것
통합된 코드에 오류가 없는지 재확인 후, 발표자료 제작