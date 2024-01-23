## Chapter1 Introduction to Object Oriented Technologies

- **Five attributes of a complex system**
  - Hierarchic Structure
    - All systems have subsystems and all systems are parts of larger systems
  - Relative Primitive
    - The choice of what components in a system are primitive, is **relatively
      arbitrary and is largely up to the discretion of the observer of the
      system**
  - Separation of Concerns
    - Provides a clear separation of concerns among the various paarts of a
      system, making it possible to study each part in relative isolation
  - Common Patterns
    - Complex systes have common patterns. These patterns may **involve the
      reuse of small components**
  - Stable Intermediate Forms
    - We can never craft the primitive objects correctly at the first time, and
      complex systems tend to evolve overtime
- Software Development Life Cycle

  - **SDLC is a structured sequence of stages in software engineering to develop
    the software product**
  - Steps
    - Define User Requiremets
    - Feasibillity Study (Proof of Concept)
    - System Analysis
    - Software design
    - Programming
    - User Acceptance Testing
    - Operation & Maintenance

- Object Oriented Technologies - Elegant, Reuse, Generalize
  - **Obejct Oriented Design**
    - OOD approach defines everything in terms of object
    - Each Obejct contains encapsulated data and procedures grouped together
    - Objects are assembled together and interacted with others, and eventually
      become a complete system
  - **OOP**
    - Obejct-oriented programming is a method of implementation in which
      programs are organized as cooperative collections of obejcts, each of
      which represents an instance of some classes, and whose classes are all
      members of a hierarchy of classes united via inheritance relationships
- Good Software Properties
  - Usability
  - Completeness
  - Robustness
  - Efficiency
  - Scalability
  - Readability
  - Reusability
  - Simplicity
  - Maintainability
  - Extensibility
- Function Oriented Design
  - FOD identifies system functions and transform them with input and output
  - FOD aprroach defines module base on functions
  - Each module is then divided into sub modules
  - This top-down approach allows sub modules to be reused by other modules
- Obejct Model
  - Abstraction
    - Denotes the **essential characteristics of an objecct that distinguish it
      from all other kinds of objects and thus provide crisply defined
      conceptual boundaries**, relative to perspective of the viewer
  - Encapsulation
    - Encapsulation hides the abstraction details from the end users
  - Modulation
    - Modulation divides a program into modules which can be compiled
      separately, but which have connections with other modules
  - Hierarchy
    - Hierarchy is a ranking or ordering of abstractions
  - Benefits of using obejct model
    - It helps to exploit the expressive power of object-based and object
      oriented programming languages
    - It encourages the reuse not only of software but of entire designs,
      leading to the creation of reusable application frameworks
    - It profuces systems that are built on stable intermediate forms, which are
      more resilient to change
    - It appeals to the workings of human cognition

## Chapter2

- Class

  - What is a Java Class
    - Classes are constructs that define objects of the same type
  - Class variables & Class Methods
    - In Java, there is a keyword `static` for defining class level variables
      and methods

- Objects

  - An object is a tangible antity that exhibits some well-defined behaviors
  - The benifits of Abstraction
    - We can write less codes when creating new classes
    - We can focus more on the implementation work
    - We can centralize the common codes and can change them consistently

- Stateful and Stateless objects

  - Stateful objects for individual user
    - Multiple instances
    - User level variables
  - Stateless objects for all users
    - Unique instance
    - Application level variables

- Aggregation

  - If a class has an entity reference, it is known as Aggregation
  - Aggregation represents "has a" relationship
  - Benifits
    - Code reuse is also best achived by aggregation when there is NOT "is a"
      relationship
    - INheritance should be used only if the relationship "is a" is maintained
      throughout the lifetime of the objects involved.

- Encapsulation
  - Variable names must be unique in some procedural programming languages
  - A single procefural program will commonly hold a thousand of vairables and
    many functions
