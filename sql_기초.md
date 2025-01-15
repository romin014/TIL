# SQL 기초
>#### 250115  

## 1. SQL의 기본 구조
 * SELECT  
    * 데이터를 가져오는 기본 명령어
    * 데이터를 조회하는 모든 쿼리에 사용됨

 * FROM  
    * 데이터를 가져올 테이블을 특정해주는 문법

 사용예시
>select *  
from student  
`* : 모든 칼럼을 가져와 출력`  

## 2. WHERE
* WHERE  
    * 조건에 맞는 특정 데이터를 가져올 수 있도록 필터링 해주는 문법

* WHERE의 구조
```
select 불러올 데이터
from 테이블
where 필터링 조건
```
사용예시
>select *  
from student  
where age > 10  

## 3. 비교연산, BETWEEN, IN, LIKE  
* 비교연산자의 종류  
    * = : 같다  
    * <> : 같지 않다  
    * ` > : 크다  
    * ` >= : 크거나 같다
    * < : 작다
    * <= : 작거나 같다  
* BETWEEN  
    * between a and b : a와 b 사이  
> where age between 10 and 20
* IN
    * in(a,b) : a와 b를 포함
> where age in (10, 11)  
* LIKE
    * like '시작문자%'
    * like '%포함문자%'
    * like '%끝문자'  
> where name like '김%'



