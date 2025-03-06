[본캠프 1일차]onboarding, git

## 1. 오늘의 학습 내용
### 1. Git 기초
* Git이란?  
   - 코드 변경점을 기록  
   - 버전 관리 도구(형상 관리 도구)
* Github란?
   - 온라인 백업 및 공유
   - 온라인 코드 저장소

### 2. Git 기초 명령어
1. git init
   - git 저장소를 생성하거나 기존 저장소를 초기화
   - 정확한 경로를 입력해야 원하는 프로젝트만 기록 가능
2. git status
   - 기록 가능한 파일들의 상태 확인
   - 변경사항이 있지만 add를 하지 않았다면 붉은색으로 표시됨
3. git add
   - 저장할 파일 지정(저장하는 것은 아님)
   - 모든 변경 사항 지정 -> git add .
4. git commit -m "메시지 작성"
   - add로 추가된 파일 저장
   - 메시지는 알아보기 편한 단어(변경사항 등) 사용
5. git log
   - 저장 내역 확인
   - 커밋 메시지를 통해 변경점 추측 -> git reset으로 과거로 돌아가기 가능 -> q를 사용해 끝내기
6. git push
   - git remote add origin <github 주소> -> github 주소를 origin으로 지정
   - git branch -M main -> 현재 브랜치명을 main으로 바꿈
   - git push -u origin main -> git push를 할 때 defalt값을 git push origin main으로 변환
7. git clone
   - git clone <github 주소> .
   - 프로젝트의 코드 복제
8. git pull
   - 다른 사람이 변경한 코드 가져오기

### 3. 주간 과제

프로젝트 명 : 팀원을 소개하는 웹페이지 만들기
기간 : 2.17 ~ 21
맡은 역할 : 메인 페이지 등록/삭제 기능 & 데이터베이스

- git 주소 : https://github.com/s-woni/Onboarding-Mini-Project
- 팀 노션 : https://www.notion.so/teamsparta/13-19d2dc3ef51480489ac9c060183149f4

