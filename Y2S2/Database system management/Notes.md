### Chapter 1 Introduction

- Review

  - Entity type -> Relation -> Table(physical design)
  - Never use 's' in Entity type name
  - Anomalies in the relational model refer to inconsistencies or errors that
    can arise when working with relational databases.
  - We make the foreign key after normalization

- Relational Algebra Operations
  - Selection
  - Projection
  - Cartesian product
  - Union
  - Intersection
  - Set differences
- Selection

  - predict (R) 𝞼
    - Works on a single relation R and defines a relation that contains only
      those tuples of R that satisfy the specified condition
    - 𝞼 <sub>brach-name = 'Macau'</sub>(ACCOUNT), ACCOUNT is the **Entity type
      name**
    - Example
    ```sql
    SELECT *
    FROM ACCOUNT
    WHERE brach-name = "Macau" AND .......
    ```
    𝞼 <sub>𝞼 <sub>brach-name = 'Macau' 𝝠 region = "Macau" </sub> (ACCOUNT)
    - List all staff information with a salary greater than £10000 𝞼 <sub>salary
      > 10000</sub>

- Projection Operation

  - Works on a single relation R and defines a relation that contains a vertical
    subset of R, extracting the values of specified attributes and eliminating
    duplicates
  - ∏ as symbol
  - Example
    - Produce a list of salaries for all staff, showing only staffNo, fName,
      lName, and salary details
    - ∏ <sub>staffNo, fName, lName, salary</sub> (Staff)
    - `SELECT DISTINCT Salary FROM STAFF;`

- Union Operation

  - Union of two relations R and S defines a relation that contains all the
    tuples of R，or S, or both R and S, duplicated tuples being eliminated
  - 𝖴
  - Example
    - Produce a list of all staff that work in either of two departments,
      showing only their staffNo, and dateOfBirth
    - ∏<sub>staffNo,dob</sub>(Staff_DepA) 𝖴 ∏<sub>staffNo,dob</sub>(Staff_DepB)

- Set differences

  - Defines a relation consisting of the tuples that are in relation R, but not
    in S
  - Example
    - Produce a list of all staff that **only work in department A**, showing
      only their sraffNo, and dob
    - ∏<sub>staffNo, dob</sub> - ∏<sub>staffNo,dob</sub>

- Cartesian product
  - Defines a relation that is the concatenation of every tuple of relation R
    with every tuple of relation S
  - R ⨯ S
  - Example
    - Combine details of staff (S) and teh departments(D)
    - ∏<sub>staffNo,job,dept</sub>(S) ⨯ ∏<sub>dept, name</sub>(D)
    - 与之对应的是JOIN
- Join
  - Natural Join
    - T ⨝ U
  - Semijoin
    - T ▷<sub>B</sub> U
    - 它的结果是一个新的表，其中包含第一个表中满足条件的记录以及与第二个表中满足连接条件的记录相关的信息。
  - Left Outer Join
    - T ⟕ U
    - 在进行左外连接时，将左表的每一行与右表进行比较，并返回满足连接条件的行。如果右表中没有匹配的行，则使用NULL值填充右表的列。
  - Division
  - Theta Join
    - Defines a relation that contains tuples satisfying the predicate F from
      the Cartesian product the Cartesian product of R and S
    - R ⨝<sub>(condition)</sub>
    - ∏<sub>staffNo,job,dept</sub>(S) ⨝<sub>Staff.debt =
      Dept.dept</sub>∏<sub>dept, name</sub>(Dept)
  - Equijion (a special type of Theta Join)

## Chapter 2 Query Processing

- One of the major criticisms often cited in Relational Model was inadequate
  performace of queries
- Find the most cost effective way to perform a complex query
- Aims of QP (query proecessing)
  - **transform query written in high-level language into correct adn efficient
    execution strategy expressed in low-level language**
- Phases of QP
  - Query Porcessing:The activities involved in retrieving data from database
  - Query Decomposition:
    - To transform a high-level query into a relational algebra query
    - And to check that the query is syntactically and semantically correct
  - Query OPtimization:
    - The activity of choosing an efficient execution strategy for processing a
      query
  - Code Generation:
  - Runtime Query:
- Two choices when first 3 phases of QP can be carried out
  - Dynamic Query Optimzation
    - Dynamically carry out decomposition and optimization every time query is
      run
    - Advantage
      - All information required to select an optimum strategy is up to date
    - Disadvantage
      - **The performance of query is affected** because to query has to be
        parsed,validated, and optimized before it can be executed
  - Static Query Optimzation
    - THe query is parsed, validated, and optimized once, when query is first
      submitted
- Relational Algebra Tree
  - **Leaf node** created for each base relation
  - Non-leaf node created for each intermediate relation produced by RA
    operation
  - Root of tree represents query result
  - Sequence is directed from leaves to root

## Chapter 3 Transaction Mangement

- #### Part1
- Transaction Support

  - Transaction Concept
    - **Action, or series of actions, carried out by user or application, which
      accesses or changes contents of database**
    - A transaction is _complete_, taking a _consistent database_ state into
      another _consistent database_ state.
    - A transaction consisting of two _database operations_, and a non-database
      operation
      `Read(StaffNo = x, salary) Salary = salary * 1.1 Write(staffNo = x, salary)` -
      `Read(X)` which transfers the data item X from the database to a variable
      called X - `Write(X)`,which transfers the variable X into data item X in
      database
    - Two main issues to deal with
      - Concurrent execution of multiple transactions
        - Most BMS are multi-user systems
        - The concurrent execution of transactions must be such that each
          transaction appears to execute _isolation_
        - **Possible Problems of concurrency**
          - Lost Update
          - Temporary Update
          -
      - Failures of various kinds, such as hardware failures and system crashes

- Properties of Transactions (ACID)

  - **Atomicity**: _all or nothing_. Either all operations of the transaction
    are properly reflected in the database or none are.
    - Exactly once: Keep trying'till acknowledged and serer discards duplicate
      requests
  - **Consistency**: _state transformation_. Must transform database from one
    consistent state to another.
  - **Isolated**: _no concurrency anomalies_. Partial effects of incomplete
    transactions should not be visible to other transactions.
    - Running programs concurretly on same data can create concurrency anomalies
  - **Durable**: _committed transaction effects persist_. Effects of a committed
    transaction are permanent and must not be lost because of later failure.

- Transaction Execution
  - Transaction manager
  - Scheduler
  - Recovery manager
  - Buffer manager
- Transaction Summary

  - Transaction concept: read and write
  - Transaction properties (ACID): atomicity, consistency, isolated and durable
  - Commmit and rollback

- #### Part2

- Concurrency control
  - **Process of managing simultaneous operations on the database without having
    them interface with one another**
  - Reason ofr Allowing Concurrency
    - Improved throughput of transactions and system resource utilization
    - Reduced waiting time of transaction
  - Three examples of potential problems caused by concurrency
    - Lost update problem
    - Temporary update problem
    - incorrect summary problem
- Serial Schedules and Serializability
  - A Schedule is a sequential order of the instructions(R/W/A/C) of n transactions such that the ordering of the instructions of each transaction is preserved.
  - Serial Schedule
    - A schedule that does not interleave the actions of different transactions
  - Non-serial Schdules
    - A schedule where the operations from a set of concurrent transactions are interleaved
  - A schedule S is serializable if the outcome of its execution is the same as the outcome of at least one serial schedule constituted by the same transactions of S
  - Read-write COnflict Rules
    - Two actions are conflicting in a schedule if they belong to different transactions, they operate on the same element, and one of them is a write.
- Locking and Two phase locking
- Deadlock and how it can be resolved
- Timestamping
- Optimistic Techniques

## Chapter 4 SQL Data Definition Language

- Data definition

  - SQL DDL allows database objects such as schemas, domains, tables, views, and indexes to be created and destroyed.
  - Syntax example
    `CREATE TABLE [schema] `

- Create a Table

  - Creates a table with one or more columns of the specified `dataType`
  - With **NOT NULL**, system rejects any attempts to insert a null in the column
  - Can specify a **DEFAULT** calue for the column
  - A primary key can not be **NOT NULL**

  - Integrity constraint
    - Required Data NOT NULL
    - Domain constraints-check
    - Entity integrity- PRIMARY KEY
    - Referential integrity : FOREIGN KEY
    - General constraints
  - Primary key of a table must contain a unique, not-null value for each row. - `CREATE TABLE dept(
    deptno     NUMBER(2),
    dname      VARCHAR2(2)    NOT NULL,
    loc        VARCHAR2(13)
    CONSTRAINT dept_name_uk    UNIQUE(dname),
    CONSTRAINT dept_deptno_pk     PRIMARY KEY(deptno),
    CONSTRAINT dept_name_nn    NOT NULL(dname),
)`
