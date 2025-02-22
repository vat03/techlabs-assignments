use ORGANIZATION;

INSERT INTO EMP VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10); 
INSERT INTO EMP VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-1', 2850, NULL, 30); 
INSERT INTO EMP VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-9',2450, NULL, 10); 
INSERT INTO EMP VALUES (7566, 'JONES', 'MANAGER',7839, '1981-4-2', 2975, NULL, 20); 
INSERT INTO EMP VALUES (7654, 'MARTIN','SALESMAN',7698, '1981-9-28', 1250, 1400, 30); 
INSERT INTO EMP VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-2-20', 1600, 300, 30); 
INSERT INTO EMP VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-9-8', 1500,0,30); 
INSERT INTO EMP VALUES (7900, 'JAMES', 'CLERK',7698, '1981-12-3',950,NULL,30); 
INSERT INTO EMP VALUES (7521, 'WARD', 'SALESMAN',7698, '1981-2-22',1250, 500,30); 
INSERT INTO EMP VALUES (7902, 'FORD', 'ANALYST',7566, '1981-12-3', 3000, NULL, 20); 
INSERT INTO EMP VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20); 
INSERT INTO EMP VALUES (7788, 'SCOTT', 'ANALYST',7566, '1982-12-09', 3000, NULL, 20); 
INSERT INTO EMP VALUES (7876, 'ADAMS', 'CLERK',7788, '1983-1-12', 1100, NULL, 20); 
INSERT INTO EMP VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-1-23',1300, NULL, 10);

select * from emp;

select ENAME from emp order by ENAME desc;

select * from emp where DEPTNO = 20 or DEPTNO = 30;

select * from emp where JOB = "MANAGER";

select * from emp where sal >= 2000 and sal <= 5000;

select * from emp where comm is null;

select ENAME, SAL, Comm, sal+comm from emp;

select hireDate, current_date(), timestampdiff(year, hireDate, current_Date()) as 'tenure' from emp; 

select * from emp where ENAME like 's%';

select distinct deptno from emp;

select lower(ename), lower(job) from emp;

select * from emp order by sal desc limit 3;

select * from emp where DEPTNO = 10 and job in ("MANAGER", "CLERK");  

select * from emp where job like "CLERK" order by deptno;

select * from emp where DEPTNO = (select deptno from emp where ename like "SCOTT");

select * from emp where job = (select job from emp where ename like "SMITH");

select * from emp where mgr = (select EMPNO from emp where ename like "KING");

select * from emp where sal = (select sal from emp where ename like "BLAKE");

select DEPTNO, count(EMPNO) as "Number of Employees" from emp group by DEPTNO;

select JOB, count(empno) as "Number of Employess" from emp group by job;

select JOB, DEPTNO, count(empno) as "Number of Employess" 
from emp 
group by job, DEPTNO 
order by job, DEPTNO;

select * from emp 
where deptno in (
	select DEPTNO 
    from emp 
    group by DEPTNO 
    having count(EMPNO) > 3) 
order by DEPTNO;

select * from emp 
where JOB in (
	select JOB 
    from emp 
    group by JOB 
    having count(EMPNO) > 3) 
order by JOB;

select e.ename as "Employee Name", d.dname as "Department Name", d.loc as "Location" 
from dept d
left join emp e on d.DEPTNO = e.DEPTNO;

select d.dname as "Department Name", e.ename as "Employee Name"
from dept d
join emp e on d.DEPTNO = e.DEPTNO;

select d.dname as "Department Name", e.ename as "Employee Name"
from dept d
left join emp e on d.DEPTNO = e.DEPTNO where e.ename is null;

SELECT d.dname AS "Department Name", COUNT(e.empno) AS "Employee Count"
FROM dept d
left JOIN emp e ON d.deptno = e.deptno
GROUP BY d.dname
HAVING COUNT(e.empno) > 3
ORDER BY d.dname DESC;
