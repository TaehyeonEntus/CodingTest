-- 코드를 입력하세요
SELECT PT_NAME,PT_NO,GEND_CD,AGE,ifnull(TLNO,'NONE') from patient
where gend_cd like 'W' and age <= 12
order by age desc, pt_name asc