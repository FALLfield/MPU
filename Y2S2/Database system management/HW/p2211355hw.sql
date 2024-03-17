COMP2024 Oracle Project Script File Part1.Creating an Oracle Database with Script create table Employee(
    EID varchar2(3),
    Fname varchar2(9),
    Lname varchar2(9),
    Address varchar2(50),
    DOB date,
    Gender char(1),
    Salary number(7),
    Bonus number(4),
    DID varchar(3),
    constraint Employee_EID_pk primary key (EID),
    constraint Employee_DID_fk foreign key (DID) references Department(DID),
);
create table Department(
    DID varchar2(3),
    Name varchar2(20),
    Mgr_EID varchar2(3),
    Mgr_Start_Date date,
    constraint Department_DID_pk primary key (DID),
    constraint Department_Mgr_EID_fk foreign key (Mgr_EID) references Employee(EID),
);
create table Project(
    PID varchar2(1),
    Name varchar2(30),
    DID varchar2(3),
    constraint Project_PID_pk primary key (PID),
    constraint Project_DID_fk foreign key (DID) references Department(DID),
);
create table Work_On(
    EID varchar2(3),
    PID varchar2(1),
    Hours number(3),
    constraint Work_On_EP_pk primary key (EID, PID),
    constraint Work_On_EID_fk foreign key (EID) references Employee(EID),
    constraint Work_On_PID_fk foreign key (PID) references Project(PID),
);
insert into Employee
values(
        '123',
        'Wilson',
        'Ho',
        '163 Old Road, Bayswater, London',
        DATE(1955 -12 -10),
        'M',
        15000,
,
        '12'
    );
insert into Employee
values(
        '456',
        'Mary',
        'Law',
        '134,Leicester Square',
        'London',
        DATE(1965 -10 -05),
        'M',
        19000,
,
        '11'
    );
insert into Employee
values(
        '789',
        'Paul',
        'Smith',
        "356 The Queen's Walk,Lodon",
        DATE(1975 -08 -06),
        'F',
        14000,
,
        '11'
    );
insert into Employee
values(
        '111',
        'John',
        'Simon',
        '883 Fair Road, Coventry',
        DATE(1960 -09 -07),
        'M',
        30000,
,
        '12'
    );
insert into Employee
values(
        '222',
        'Lucas',
        'Tse',
        '569 Heddon Street, Mayfair, London',
        DATE(1970 -04 -02),
        'M',
        20000,
        5000,
        '10'
    );
insert into Employee
values(
        '333',
        'Rebecca',
        'Sam',
        '10 Grove Lane, Ipswich, Suffolk',
        DATE(1950 -01 -08),
        'F',
        35000,
        2500,
        '10'
    );
insert into Employee
values(
        '987',
        'Terry',
        'Shooter',
        '26 York Street, London',
        DATE(1973 -05 -30),
        'M',
        23000,
,
        '12'
    );
insert into Employee
values(
        '654',
        'Lawrence',
        'Yip',
        '11-15 Betterton Street, Covent Garden, London',
        DATE(1953 -02 -27),
        'M',
        32000,
,
        '11'
    );
insert into Employee
values(
        '321',
        'Gary',
        'Marker',
        '221 Holloway Road, London',
        DATE(1963 -11 -16),
        'F',
        26000,
,
        '12'
    );
insert into Employee
values(
        '881',
        'James',
        'Steve',
        '321 Voctory Road, Coventry',
        DATE(1971 -12 -31),
        'M',
        28000,
,
        '12'
    );
insert into Department
values(
        '10',
        'Consumer Products Department',
        '333',
        DATE(1994 -10 -01)
    );
insert into Department
values(
        '11',
        'Industrial Products Department',
        '654',
        DATE(1995 -05 -01)
    );
insert into Department
values(
        '12',
        'Research Department',
        '111',
        DATE(1990 -06 -15)
    );
insert into Project
values('1', 'Mobile Phone', '10');
insert into Project
values('2', 'Interactive TV', '12');
insert into Project
values('3', 'I-Phone Applications', '10');
insert into Project
values('4', 'Internet Phone', '10');
insert into Project
values('5', 'Mobile Phone', '11');
insert into Work_On
values('123', '3', 27);
insert into Work_On
values('456', '3', 12);
insert into Work_On
values('789', '4', 35);
insert into Work_On
values('111', '1', 15);
insert into Work_On
values('111', '2', 5);
insert into Work_On
values('222', '5', 30);
insert into Work_On
values('333', '3', 20);
insert into Work_On
values('333', '5', 20);
insert into Work_On
values('987', '4', 25);
insert into Work_On
values('654', '2', 30);
insert into Work_On
values('321', '1', 15);
insert into Work_On
values('321', '2', 10);