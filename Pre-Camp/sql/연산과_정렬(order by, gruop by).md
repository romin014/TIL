# 연산과_정렬(order by, gruop by)
>#### 250116 

## 1. SQL로 연산하기
 * 숫자 연산자  
```
+ : 더하기
- : 빼기
* : 곱하기
/ : 나누기
```

 * SUM 
    * SUM(컬럼) : 데이터의 합계  
 * AVG 
    * AVG(컬럼) : 데이터의 평균값
 * COUNT
    * COUNT(컬럼) : 데이터의 갯수
 * DISTINCT
    * DISTINCT 컬럼 : 데이터의 중복제거
 * MAX
    * MAX(컬럼) : 데이터의 최댓값 
 * MIN
    * MIN(컬럼) : 데이터의 최솟값
```
select avg(score) avg_score,  
        count(distinct student_id),  
        count_id,  
        min(score) min_score
from student  
```
## 2. GROUP BY
* GROUP BY
    * 특정 열을 기준으로 데이터를 그룹화해주는 문법

* GROUP BY 의 구조
```
select 카테고리 컬럼,  
        sum(계산 컬럼) 별명
from 테이블
group by 카테고리 컬럼
```
사용예시
>select major, avg(age) avg_age\
from student  
group by major

## 3. ORDER BY
* ORDER BY
    * select 문에서 나온 결과를 정렬하기 위한 문법

* ORDER BY 의 구조
```
select 카테고리 컬럼,
        sum(계산 컬럼)
from 테이블
group by 카테고리 컬럼
order by 정렬을 원하는 컬럼
* asc : 오름차순
* desc : 내림차순
```
사용예시
>select major,
        avg(age) avg_age\
from student  
order by major desc

