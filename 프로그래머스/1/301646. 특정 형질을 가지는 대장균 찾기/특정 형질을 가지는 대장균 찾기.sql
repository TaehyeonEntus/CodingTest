SELECT COUNT(*) as COUNT
FROM ECOLI_DATA
where   (Bin(genotype) like '%1__' or
        Bin(genotype) like '%1')and
        Bin(genotype) not like '%1_'