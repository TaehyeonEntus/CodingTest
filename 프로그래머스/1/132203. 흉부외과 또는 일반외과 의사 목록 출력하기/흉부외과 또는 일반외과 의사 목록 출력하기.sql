-- 코드를 입력하세요
SELECT DR_NAME,DR_ID,MCDP_CD,date_format(HIRE_YMD,'%Y-%m-%d')
from DOCTOR
where mcdp_cd like 'cs' 
   or mcdp_cd like 'gs'
   
   order by hire_ymd desc, dr_name asc