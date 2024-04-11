COMP2024 Oracle Project Script File Part1.Creating an Oracle Database with Script 

create table Employee(
    EID number(3),
    Fname varchar2(9),
    Lname varchar2(9),
    Address varchar2(50),
    DOB date,
    Gender char(1),
    Salary number(7),
    Bonus number(4),
    constraint Employee_EID_pk primary key (EID));
create table Department(
    DID number(3),
    Name varchar2(40),
    Mgr_EID number(3),
    Mgr_Start_Date Date,
    constraint Department_DID_pk primary key (DID),
    constraint Department_Mgr_EID_fk foreign key (Mgr_EID) references Employee(EID));

alter table Employee add(
    DID number(3),
    constraint Employee_DID_fk foreign key (DID) references Department (DID));
create table Project(
    PID number(1),
    Name varchar2(30),
    DID number(3),
    constraint Project_PID_pk primary key (PID),
    constraint Project_DID_fk foreign key (DID) references Department(DID));
create table Work_On(
    EID number(3),
    PID number(1),
    Hours number(3),
    constraint Work_On_EPID_pk primary key (EID, PID),
    constraint Work_On_EID_fk foreign key (EID) references Employee(EID),
    constraint Work_On_PID_fk foreign key (PID) references Project(PID));

insert into Department
values(
        10,
        'Consumer Products Department',
        NULL,
        DATE '1994-10-01'
    );
insert into Department
values(
        11,
        'Industrial Products Department',
        NULL,
        DATE '1995-05-01'
    );
insert into Department
values(
        12,
        'Research Department',
        NULL,
        DATE '1990-06-15'
    );

insert into Employee
values(
        123,
        'Wilson',
        'Ho',
        '163 Old Road, Bayswater, London',
        DATE '1955 -12 -10',
        'M',
        15000,
        NULL,
        12
    );
insert into Employee
values(
        456,
        'Mary',
        'Law',
        '134,Leicester Square,London',
        DATE '1965 -10 -05',
        'M',
        19000,
        NULL,
        11
    );
insert into Employee
values(
        789,
        'Paul',
        'Smith',
        '356 The Queen''s Walk,Lodon',
        DATE '1975 -08 -06',
        'F',
        14000,
        NULL,
        11
    );
insert into Employee
values(
        111,
        'John',
        'Simon',
        '883 Fair Road, Coventry',
        DATE '1960 -09 -07',
        'M',
        30000,
        NULL,
        12
    );
insert into Employee
values(
        222,
        'Lucas',
        'Tse',
        '569 Heddon Street, Mayfair, London',
        DATE '1970 -04 -02',
        'M',
        20000,
        5000,
        10
    );
insert into Employee
values(
        333,
        'Rebecca',
        'Sam',
        '10 Grove Lane, Ipswich, Suffolk',
        DATE '1950 -01 -08',
        'F',
        35000,
        2500,
        10
    );
insert into Employee
values(
        987,
        'Terry',
        'Shooter',
        '26 York Street, London',
        DATE '1973 -05 -30',
        'M',
        23000,
        NULL,
        12
    );
insert into Employee
values(
        654,
        'Lawrence',
        'Yip',
        '11-15 Betterton Street, Covent Garden, London',
        DATE '1953 -02 -27',
        'M',
        32000,
        NULL,
        11
    );
insert into Employee
values(
        321,
        'Gary',
        'Marker',
        '221 Holloway Road, London',
        DATE '1963 -11 -16',
        'F',
        26000,
        NULL,
        12
    );
insert into Employee
values(
        881,
        'James',
        'Steve',
        '321 Voctory Road, Coventry',
        DATE '1971 -12 -31',
        'M',
        28000,
        NULL,
        12
    );

update Department set Mgr_EID=333 where DID = 10;
update Department set Mgr_EID=654 where DID = 11;
update Department set Mgr_EID=111 where DID = 12;

insert into Project
values(1, 'Mobile Phone', 10);
insert into Project
values(2, 'Interactive TV', 12);
insert into Project
values(3, 'I-Phone Applications', 10);
insert into Project
values(4, 'Internet Phone', 10);
insert into Project
values(5, 'Mobile Phone', 11);
insert into Work_On
values(123, 3, 27);
insert into Work_On
values(456, 3, 12);
insert into Work_On
values(789, 4, 35);
insert into Work_On
values(111, 1, 15);
insert into Work_On
values(111, 2, 5);
insert into Work_On
values(222, 5, 30);
insert into Work_On
values(333, 3, 20);
insert into Work_On
values(333, 5, 20);
insert into Work_On
values(987, 4, 25);
insert into Work_On
values(654, 2, 30);
insert into Work_On
values(321, 1, 15);
insert into Work_On
values(321, 2, 10);

-- 1.List all the information in the Employee table.
SELECT * FROM  Employee;

-- 2.List the employees who live in London.
SELECT * FROM Employee WHERE Address like'%London%';

-- 3.List the full information of all the managers that were employed in 1995.
SELECT Employee.*, Department.name, Department.Mgr_Start_Date FROM Employee JOIN Department on Employee.EID = Department.Mgr_EID WHERE EXTRACT(YEAR FROM Mgr_Start_Date) = 1995;

-- 4.List the full information of all the employees that were born in 70s.
SELECT * FROM Employee WHERE EXTRACT(YEAR FROM DOB) >= 1970 AND EXTRACT(YEAR FROM DOB) <= 1979;

-- 5.List the full information of all the employees that were born in August.
SELECT * FROM Employee WHERE EXTRACT(MONTH FROM DOB) = 8;

-- 6.List the full information of all the employees whose age is greater than 50.
SELECT * FROM Employee WHERE
    EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM DOB) > 50
    OR (EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM DOB) = 50
        AND EXTRACT(MONTH FROM CURRENT_DATE) > EXTRACT(MONTH FROM DOB))
    OR (EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM DOB) = 50
        AND EXTRACT(MONTH FROM CURRENT_DATE) = EXTRACT(MONTH FROM DOB)
        AND EXTRACT(DAY FROM CURRENT_DATE) >= EXTRACT(DAY FROM DOB));
    
-- 7.List the name of the manager of each department.
SELECT CONCAT(Employee.Fname, Employee.Lname) AS mgr_name, Department.name FROM Employee JOIN Department ON Employee.EID = Department.Mgr_EID;

-- 8.List the name of the youngest manager.
SELECT CONCAT(e.Fname,e.Lname) AS youngest_mgr 
FROM Employee e INNER JOIN Department d ON e.EID = d.Mgr_EID 
WHERE e.DOB=(SELECT MAX(e.DOB) FROM Employee e INNER JOIN Department d ON e.EID = d.Mgr_EID);

-- 9.How many employees are there and they are living in London?
SELECT COUNT(*) emmployee_num FROM Employee WHERE Address LIKE '%London%';


-- 10.How many male and female employees are there in each department? The department names should be shown in the result.
SELECT d.name, 
       SUM(CASE WHEN e.Gender = 'M' THEN 1 ELSE 0 END) AS MaleCount,
       SUM(CASE WHEN e.Gender = 'F' THEN 1 ELSE 0 END) AS FemaleCount
FROM Department d
JOIN Employee e ON d.DID = e.DID
GROUP BY d.name;

-- 11. Find minimum, maximum, and average employee salary
SELECT MAX(Salary) AS maximum, MIN(Salary) AS minimum, SUM(Salary)/COUNT(Salary) AS average
FROM (
    SELECT Salary FROM Employee ORDER BY Salary DESC
) Salary;

-- 12. Find number of employees and sum of their salaries in each department. The department names should be shown in the result.
SELECT COUNT(e.EID) as employee_num, SUM(e.Salary) as sal_sum, d.name
FROM Employee e 
JOIN Department d ON e.DID = d.DID 
GROUP BY d.name;

-- 13. List the department which employs the lowest number of employees.
SELECT MIN(COUNT(e.EID)) as lowest_employee_num
FROM Employee e 
JOIN Department d ON e.DID = d.DID 
GROUP BY d.name;

-- 14. List the employees who have bonus?
SELECT CONCAT(Fname, Lname) as name 
FROM Employee
WHERE bonus IS NOT NULL;

-- 15.Find out how many employees do not have bonus?
SELECT COUNT(*) as no_bonus
FROM Employee
WHERE bonus IS NULL;

-- 16. List the total income of each employee. The employee names should be shown in the result.
SELECT CONCAT(Fname, Lname) AS name, (COALESCE(bonus,0) + Salary) AS income
FROM Employee;

-- 17.Find out the number of employees who did not work on any project.
SELECT COUNT(*) as no_work
FROM Employee e 
LEFT JOIN Work_On w ON w.EID = e.EID 
WHERE w.PID IS NULL;

-- 18. Who is the youngest female employee? Full information should be shown.
SELECT *
FROM Employee
WHERE DOB = (
    SELECT MIN(DOB)
    FROM Employee
    WHERE Gender = 'F'
);

-- 19. Find out the average age of each department. The department names should be shown in the result.
SELECT ROUND(SUM(EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM e.DOB))/COUNT(e.EID)) as avg_age, d.name 
FROM Employee e 
JOIN Department d ON e.DID = d.DID 
GROUP BY d.name;

--20. Who has the highest accumulated project hours? Full information should be shown
SELECT e.*, subquery.max_hours
FROM Employee e
JOIN (
    SELECT w.EID, SUM(w.hours) AS max_hours
    FROM Work_On w
    GROUP BY w.EID
) subquery ON e.EID = subquery.EID
WHERE subquery.max_hours = (
    SELECT MAX(SUM(w.hours))
    FROM Work_On w
    GROUP BY w.EID
);

-- 21. List all the employees whose age is greater than the average age of all the employees.*
select * from Employee
where trunc(months_between(sysdate,DOB)/12)>(select avg(trunc(months_between(sysdate,DOB)/12)) from Employee);

-- 22. Find all employees whose age is larger than the age of at least one employee in the Research Department.
select * from Employee
where trunc(months_between(sysdate,DOB)/12)>(select min(trunc(months_between(sysdate,DOB)/12)) 
       from Employee
       where DID=12
);

-- 23.Find all the employees whose names contain a letter “Y”, arranged in descending order of the last name.
SELECT * FROM Employee WHERE Fname like '%Y%' OR Lname like '%Y%' ORDER BY Lname DESC;

-- 24. List all the employees whose age is greater than the average age of all the employees.
select * from Employee
where trunc(months_between(sysdate,DOB)/12)>(select avg(trunc(months_between(sysdate,DOB)/12)) from Employee);

-- 25. Find out the number of projects in each department. The name of each department must be shown.
SELECT COUNT(p.PID) AS pro_num, d.name 
FROM Project p 
JOIN Department d ON p.DID = d.DID 
GROUP BY d.name;

-- 26.Who work in only one project? The employee names should be shown in the result.
SELECT CONCAT(e.Fname, e.Lname) as Name 
FROM Employee e
JOIN Work_On w ON e.EID = w.EID
GROUP BY e.Fname, e.Lname 
HAVING COUNT(w.PID) = 1;

-- 27. Who work in more than one project? The employee names should be shown in the result.
SELECT CONCAT(e.Fname, e.Lname) as Name 
FROM Employee e
JOIN Work_On w ON e.EID = w.EID
GROUP BY e.Fname, e.Lname 
HAVING COUNT(w.PID) > 1;

-- 28.How many projects have been undertaken by each employee? The employee names should be shown in the result.
SELECT CONCAT(e.Fname, e.Lname), COUNT(w.PID) as pro_num
FROM Employee e
JOIN Work_On w ON e.EID = w.EID
GROUP BY e.Fname, e.Lname;

-- 29. How many projects have been undertaken by male and female employees?

-- 30. How many employees have worked on each project? The project names should be shown in the result
SELECT COUNT(EID) as pro_num, p.name 
FROM Work_On w 
JOIN Project p ON w.PID = p.PID 
GROUP BY p.PID, p.name;

 

