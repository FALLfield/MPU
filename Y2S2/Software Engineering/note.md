## Chapter 1 Software Engineering process

- Some questions

  - What is software
    - Computer programs and associated documentation. Software products may be
      developed for a particular customer or may be developed for a general
      market
  - What are the attributes of good software
    - Good software should deliver the required functionality and good
      performance to the user and should be maintainable, dependable and usable
  - What is software engineering
    - Software engineering is an engineering discipline that is concerned with
      all aspects of software production
  - What are the fundamental software engineering activities
    - Software specification, software development, software validation and
      software evolution
  - What is the difference between software engineering and computer science
    - Computer science focuses on theory and fundamentals; software engineering
      is concerned with the practicalities of developing and delivering useful
      software
  - What is the difference between software engineering and system engineering
    - System engineering is concerned with all aspects off computer-based
      systems development including hardware, software and process engineering.
      Software engineering is part of this more general process
  - What are the key challenges facing software engineering
    - Coping with increasing diversity, demands for reduced delivery times adn
      developing trustworthy software
  - What are the costs of software engineering
    - Roughly 60% of software costs are development costs, 40% are testing
      costs. For custom software, evolution costs often exceed development costs
  - What are the best software engineeing techniques and methods
    - While all software projects have to be professionally managed and
      developed, different techniques are appropriate for different types of
      system. For example, games should always be developed using a series of
      prototypes whereas safety critical control systems require a complete and
      analyzable specification to be developed.
  - What differences has the web made to software engineering
    - The web has led to the availability of software services and the
      possiblity of developing highly distributed service-based systems.
      Web-based systems development has led to important advances in programming
      languages and software reuse

- Professional software development

  - Software products

    - Generic products
      - Stand-alone systems that are marketed and sold to and customer who
        wishes to buy them
      - Example: PC software

  - Customized products

    - Software that is commissioned by a specific customer to meet their own
      needs
    - Example: Embedded control systems

  - Product specification

    - Generic product specification
    - Customized product specification

  - **Essential attributes of good software**

    - Maintainability
    - Dependability and security
    - Efficiency
    - Acceptability

  - Software engineering
    - Software engineering is an engineering discipline , using _appropriate
      theories and methods to solve problems bearing in mind_ organizational and
      financial constraints
  - Importance of software engineering
    - More and more, individuals and society rely on advanced software systems
    - Able to produce _reliable and trustworthy systems_ economically and
      quickly
    - Cheaper in long run
    - For most types of system, the majority of costs are the costs of changing
      the software after it has gone into use
  - Software engineering diversity

    - Many types of software system, no universal set of software techniques
      that is applicable to all of these
    - The software engineering methods and tools used depend on the type of
      application being developed
    - Customer background

    - Application types

      - Stand-alone applications
        - Run on local computer
      - Interactive transaction-based applications
        - execute on remote computers
      - Embedded control systems
        - Software control systems that control and manage hardware devices
      - Entertainment systems
        - Systems that are primarily for personal use and which are intended to
          entertain the user
      - Systems of systems
        - Systems are composed of a number of other software systems
      - Batch processing systems
        - These are business systemss that arae designed to process data in
          large batches
      - Systems for modeling and simulation
        - Systems designed for scientists and engineers
      - Data collection Systems
        - Collect data from their envionment using a set of sensors and send
          that data to other systems for proessing

    - Software engineering fundamentals

      - It applies to all types of software systems
      - Systems should be developed using a managed and understood development
        process
      - Dependability and performance are important for all types of systems
      - Understanding and managing the software specification and requirements
        are important
      - Where appropriate, you should reuse software that has already been
        developed rather than write new software

    - Internet software engineering

      - The Web is now a platform for running application
      - Organizations are increasingly developing web-based systems rather than
        local systems.
      - Users do not buy software buy pay according to use.

- Web based software engineering

  - Software reuse if the dominant approach for constructing web-based systems.
  - Incremental and agile development
  - Service-oriented systems
  - Rich interfaces

- User design

  - User experience
    - User Interface

- Software process activities

  - Market researching
  - Software specification
  - Software development
    - Designed and programmed
  - Software validation
    - Software is cheched to ensure that it is what the customer requires.
  - Software evolution

- General issues that affect software

  - Heterogeneity
  - Business and social change
  - Security and trust
  - Scale

- Software engineering ethics

  - **Issues of professional responsibility**
    - Confidentiality
      - Engineers should normally respect the condidentiality of their employers
        or clients irrespective of whether or not a formal confidentiality
        agreement has been signed
    - Competence
      - Engineerrs should not misrepresent their level of competence
    - Intellectual property rights
    - Computer misuse
  - ACM/IEEE Code of Ethics
    - The professional societies in the US have cooperated to produce a code of
      ethical practice
    - The Code contains eight Principles related to the behaviour of and
      decisions made by professional software engineers -Rationale for the code
      of ethics
    - Computers have a central and growing role in commerce, industry,
      government, medicine, education, entertainment and society at large
  - **Ethical dilemmas**
    - Disagreement in principle with the policies of senior management
    - Your employers acts in an unethical way and the releases a safety-critical
      system without finishing the testing of the system
    - Participation in the deveolopment of military weapons systems or nuclear
      systems

- Software process model
  - **An abstract representation of a process**
  - Presents a description of a process from some particular perspective 
- Software process description
  - When we describe and discuss processes, we usually talk about the activities in these processes such as **specifying a data model, designing a user interface, etc and the ordering of these activities**
  - Includes
    - Products
    - Roles
      - which reflect the reponsibilities of the people involved in the process 
    - Pre- and Post-conditions


- Waterfall model 
  - Phases
    - Requirements analysis and definition
    - System and software design
    - Implementation and unit testing
    - Integration and system testing
    - Operation maintenance
  - Drawbacks
    - Difficulty of accommondating change after the process is underway
    - Inflexible partitioning of the project into distinct stages makes it difficult to respond to changing customer requirements
    - The waterfall model is mostly used for larger systems engineering projects where a system is developed at several sites

- Incremental development
  - 
  
  - benefits
    - The cost of accommodating changing customer requirements is reduced
    - It is easier to get customer feedback on the development work that has been done
    - More rapid delivery and deployment of useful software to the customer is possible 
  
  - Problems
    - The process is not visible
    - System structure tendss to degrade as new increments are added 

- Agile Methods

  - The aim of agile methods is to reduce overheads in the software process and
    to be albe to respond quickly to changing requirements withoout excessive
    rework

- Process Improvement
  - Purpose (DCQ)
    - Enhancing the quality of softwares
    - REducing costs
    - Accelerating their development process
  - Approaches to improvement
    - The process maturity approach, which focuses on improving process and
      project management and introducing good software engineering practice
    - The agile approach, which focuses on iterative development and the
      reduction of overheads in the software process
  - Process metrics
    - Time taken for process activities to be completed
    - Resource required for processes or activities
    - Number of occurences of a particular event
  - Capability maturity levels
    - Level1 initial
    - Level2 Managed
    - Level3 Defined
    - Level4 Quantitatively managed
    - Level5 Optimizing

## Chapter3 Requirement Engineering

    - Description
      `
      Market     Requirement -> Design    ->     Validation   -> Evaluation
                           Implementation   Test
                                            Verification
      ``

- Requirement Engineering

  - The process of establishing the services that a customer requires
  - What is requirement?
    - It may rango from a high-level abstract statement of a service or of a
      system constraint to a detailed functional specification
    -

- Functional & Non-Functional Req.

  -
  - Goals and requirements
    - Goal - A general intention of the use such as ease of use
    - Verifiable non-functional reuirement -- A statement using some measure
      that can objectively tested
  - Usability requirements
    - Easy use system for medical staffs
      - Four hours training is enough
  - Metrics
    - Speed
    - Size
    - Easy to use

- Requirements engineering processes

  - Depending on the application domain, the people involved and the
    orgnaization developing the requirements
  - ## Steps
    -
    -
    -
  -

- Requirements elicitation
  - The requirements elicitation and analysis process
    - Requirement discovery
    - Requirement classification and organization
    - Requirements prioritization negotiation
    - Requirements specification
