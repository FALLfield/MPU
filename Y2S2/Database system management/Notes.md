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
