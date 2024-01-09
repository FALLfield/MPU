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
    `𝞼<sub>𝞼 <sub>brach-name = 'Macau' 𝝠 region = "Macau" </sub> (ACCOUNT)`
    - List all staff information with a salary greater than £10000 𝞼 <sub>salary
      > 10000</sub>
