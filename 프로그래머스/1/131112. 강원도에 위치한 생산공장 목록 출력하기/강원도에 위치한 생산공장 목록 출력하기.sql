-- 코드를 입력하세요
SELECT factory_id, FACTORY_NAME, ADDRESS
from FOOD_FACTORY
where address like '강원도%'
order by factory_id asc