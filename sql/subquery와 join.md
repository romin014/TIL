# ssubquery와 join
>#### 250118

## 1. Subquery
 * Subquery
    * 여러번의 연산 수행
    * 조건문에 연산결과 사용
    * 조건에 쿼리 결과 사용  

 *  Subquery의 구조
```
select 컬럼1, 컬럼2
from(select 컬럼1, 컬럼2
     from 테이블
     )a
```
* 위의 구조를 제외하고도 다양한 방법으로 사용가능

사용 예시
> select studentName, age\
from student  
where studentID = (
   select studentID\
   from student\
   where grade >= 2\
   group by studentID
   )


## 2. JOIN
* JOIN
    * 다른 테이블의 데이터가 필요할 때 사용
    * JOIN의 종류  
      * left join : 공통컬럼(키값)을 기준으로 조인 조건에 해당하는 값이 있다면 그 값을 가져오고 값이 없다면 NULL값을 조회(합집합)
      * inner join : 공통컬럼(키값)을 기준으로 두 테이블 모두에 있는 값만 조회(교집합)

* JOIN 기본구조
```
select 컬럼
from 테이블1 a left join 테이블2 b on a.공통컬럼 = b.공통컬럼
```
사용예시
>select s.studentID, c.className\
from student s `left join` class c `on` s.studentID = c.classID