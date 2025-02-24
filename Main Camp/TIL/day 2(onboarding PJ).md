[본캠프 2일차]Onboarding_Mini_Project

### 주간 과제

프로젝트 명 : 팀원을 소개하는 웹페이지 만들기
기간 : 2.17 ~ 21
맡은 역할 : 메인 페이지 등록/삭제 기능 & 데이터베이스

- git 주소 : https://github.com/s-woni/Onboarding-Mini-Project
- 팀 노션 : https://www.notion.so/teamsparta/13-19d2dc3ef51480489ac9c060183149f4

# 1. 구현
> - 깃을 사용하여 각자 자기가 맡은 기능을 구현하고 깃을 통해 공유하는 형식으로 프로젝트를 진행  
> - 각자의 코드를 추후 통합할 예정  
> - 기능은 부트스트랩의 코드를 사용하여 구현함  

### 1. 오버레이
* 버튼을 클릭하면 모달을 띄움
```
<!-- button click modal -->
<button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        추가하기
    </button>
```
* 모달에 들어갈 내용 구성
```
<!-- modal -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <!-- title -->
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- body -->
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="image" placeholder="이미지 URL">
                        <label for="image">이미지 선택</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="name" placeholder="이름">
                        <label for="name">이름</label>
                    </div>
                    <div class="form-floating">
                        <select class="form-select" id="gender" aria-label="성별 선택">
                            <option selected>선택</option>
                            <option value="여성">여성</option>
                            <option value="남성">남성</option>
                        </select>
                        <label for="gender">성별 선택</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="number" class="form-control" id="age" placeholder="나이">
                        <label for="age">나이</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="MBTI" placeholder="MBTI">
                        <label for="MBTI">MBTI</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="hobby" placeholder="취미">
                        <label for="hobby">취미</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" id="introduction" placeholder="소개 한마디"></textarea>
                        <label for="introduction">소개 한마디</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="git" placeholder="Git 주소">
                        <label for="git">Git 주소</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="blog" placeholder="블로그 주소">
                        <label for="blog">블로그 주소</label>
                    </div>

                </div>
                <div class="modal-footer">
                    <button id="postingbtn" type="button" class="btn btn-dark">저장</button>
                </div>
            </div>
        </div>
    </div>
```
### 2. 데이터 베이스 연결
* 데이터베이스는 Firebase로 구현할 것이기에 필요한 라이브러리 가져오기
```
// Firebase SDK 라이브러리
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-app.js";
import { getFirestore } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-firestore.js";
import { collection, addDoc, getDocs, deleteDoc, doc } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-firestore.js";
```
* Firebase의 내 아이디 등 설정 구성 입력하고 초기화
```
// Firebase 설정
//
//

// Firebase 인스턴스 초기화
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
```
### 3. 메인화면에 카드 생성 및 삭제
* 모달로 입력받은 값 데이터베이스에 저장
```
// 게시 버튼 클릭 이벤트
$("#postingbtn").click(async function () {
    let image = $("#image").val();
    let name = $("#name").val();
    let gender = $("#gender").val();
    let age = $("#age").val();
    let MBTI = $("#MBTI").val();
    let hobby = $("#hobby").val();
    let introduction = $("#introduction").val();
    let git = $("#git").val();
    let blog = $("#blog").val();

    let docData = {
        'image': image,
        'name': name,
        'gender': gender,
        'age': age,
        'MBTI': MBTI,
        'hobby': hobby,
        'introduction': introduction,
        'git': git,
        'blog': blog
    };

    try {
        await addDoc(collection(db, "tim"), docData);
        alert('저장완료!');
        window.location.reload();
    } catch (error) {
        console.error("저장 실패: ", error);
        alert('저장 실패: ' + error.message);
    }
});
```


* 데이터베이스에 저장된 값을 사용해 메인화면에 카드 생성
```
// 카드 생성
async function loadCards() {
    let docs = await getDocs(collection(db, "tim"));
    docs.forEach((doc) => {
        let row = doc.data();
        let image = row['image'];
        let name = row['name'];
        let age = row['age'];
        let gender = row['gender'];
        let MBTI = row['MBTI'];

        // 생성된 카드에 포함할 데이터
        let temp_html = `
            <div class="col">
                <div class="card h-100">
                    <img src="${image}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${name}</h5>
                        <p class="card-text">${age}</p>
                        <p class="card-text">${gender}</p>
                        <p class="card-text">${MBTI}</p>
                        <button class="btn btn-outline-secondary delete-btn position-absolute bottom-0 end-0 mb-3 me-4" data-id="${doc.id}">삭제</button>
                    </div>
                </div>
            </div>`;
        $('#card').append(temp_html);
    });
}
// 카드 로드
loadCards();
```

* 생성된 카드 삭제(데이터베이스 값도 삭제됨)
```
// 삭제 버튼 이벤트
$(document).on('click', '.delete-btn', async function () {
    const docId = $(this).data('id');
    const docRef = doc(db, "tim", docId);

    try {
        await deleteDoc(docRef);
        alert('삭제 완료!');
        window.location.reload();
    } catch (error) {
        console.error("삭제 실패: ", error);
        alert('삭제 실패: ' + error.message);
    }
});
```



# 2. 겪었던 문제점 & 에러
* 데이터베이스의 값을 통해 생성할 카드 구현
   * 처음 카드를 생성하기 위헤서는 이미 존재하는 카드가 있고 그 카드의 구현 값을 가져와 새로운 카드가 생성되는 방식  
   * 기존에 있던 카드는 데이터베이스에 값이 저장되어있지 않았기 때문에 새롭게 생성된 카드들과는 달리 사용자가 임의로 삭제할 수 없음
   * 해결방안 1 : 기존 카드 삭제
      * 기존의 카드를 삭제하고 실행시키니 데이터베이스에는 값이 저장되지만 저장값을 통한 새로운 카드가 생성되지는 않음
   * 해결방안 2 : 카드의 'display' 값을 'none'으로 설정
      * 기존 카드가 보이지 않게 되었지만 새롭게 생성되는 카드들 또한 보이지 않음
   * 해결방안 3 : 기존 카드의 내용을 모두 삭제
      * 기존 카드 없이도 원하는 모양의 카드들이 새롭게 생성됨
      * `<div id="card" class="row row-cols-1 row-cols-md-4 g-4"> </div>`  

# 3. 내일 할 것
다른 팀원들이 작업한 코드를 확인하고 하나의 완성물로 병합하기

