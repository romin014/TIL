// Firebase SDK 라이브러리
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-app.js";
import { getFirestore } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-firestore.js";
import { collection, addDoc, getDocs, deleteDoc, doc } from "https://www.gstatic.com/firebasejs/9.22.0/firebase-firestore.js";

// Firebase 설정
const firebaseConfig = {
    apiKey: "AIzaSyAbwX7tWMJi1gTl_fURKx6FzFQjY6XOoto",
    authDomain: "sparta-e8b3d.firebaseapp.com",
    projectId: "sparta-e8b3d",
    storageBucket: "sparta-e8b3d.firebasestorage.app",
    messagingSenderId: "677399503700",
    appId: "1:677399503700:web:6b6359c8c8be5aa61adec1",
    measurementId: "G-TGCXX8SPG8"
};

// Firebase 인스턴스 초기화
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

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
