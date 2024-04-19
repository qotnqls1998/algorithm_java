-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS outs left outer join ANIMAL_INS ins
on ins.ANIMAL_ID = outs.ANIMAL_ID
where ins.INTAKE_CONDITION is NULL
order by outs.ANIMAL_ID;
