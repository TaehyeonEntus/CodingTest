-- 코드를 입력하세요
SELECT a.FLAVOR from first_half as a left join icecream_info as b ON a.flavor = b.flavor
where   a.total_order >= 3000 and
        b.INGREDIENT_TYPE like 'fruit%'
order by total_order desc