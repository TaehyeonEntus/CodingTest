select id, ifnull(length,10) as LENGTH from fish_info
order by length desc, id asc
limit 10