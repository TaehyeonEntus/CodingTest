-- 코드를 입력하세요
SELECT 
A.TITLE, 
B.BOARD_ID, 
B.REPLY_ID, 
B.WRITER_ID, 
B.CONTENTS, 
DATE_FORMAT(B.CREATED_DATE,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as a join USED_GOODS_REPLY as b
on a.board_id = b.board_id
where a.created_date like '%2022-10%'
order by b.created_date asc, a.title asc