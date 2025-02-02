SELECT id, email, first_name, last_name
FROM developer_infos
WHERE SKILL_1 LIKE '%python%' 
   OR SKILL_2 LIKE '%python%' 
   OR SKILL_3 LIKE '%python%'
   ORDER BY id asc