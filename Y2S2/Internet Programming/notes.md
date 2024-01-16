## Introduction

- Framework
  - Definition
    - A framework is a **big library or group of libraries that provides many
      services**
    - It mostly takes all the **diffidult, repetitive tasks** in setting up a
      new web application and either does them for you or make them very easy
      for you to do
  - Frameworks provide functionality to perform common operations required to
    run web applications
    - URL routing
    - HTML, XML, JSON, and other output format templating
    - Database manipulation
    - Security against Cross-site request forgery
    - Session storage and retrieval
    - _For example_
      - Django web application framework includes an Object-Relational Mapping
        layer that abstracts relational database read, write, query, and delete
        operations
  - Whether or not you use a web framework depends on your experience with web
    development and what you're trying to accomplish
- Databases
  - Defination
    - Store data of application
    - **relational and non-relational databases**
  - Examples
    - MongoDB -an open-sourced NoSQL database
    - PostgreSQL -a popular open-sourced SQL databse
    - MySQL -another popular open-sourced SQL database
    - Oracle -an enterprise SQL databse
    - SQL Server -an SQL server manager created by Microsoft
- Client and Server
  - Defination of Client
    - This party \*\*requests pages from server, and displays them to the user.
      (Client is often a web browser)
  - There are typically multiple clients interacting with the same application
    store on a server
  - Defination of Server
    - Responsible for saving pages
- Front-end and back-end
  - The front-end is comprised of **HTML, CSS and JavaScript**. This is how and
    where the website is shown to users
  - The back-end is comprised of **server and datase**.
- Client-side programming
  - Definition
    - Client-side progamming is **writing code that will run on the client,**
      and is done in languages that can be excuted by the browser
  - Client side programming has mostly to do with the user interface, with which
    the user interacts
    - Main tasks
      - Valiadating input
      - Animation
      - Manipulating UI elements
      - Applying styles
      - Some calculations are done when you don't want the page to refresh so
        often
- Server-side programming
  - The server side **isn't visible to users**, powers the client side, using
    languages supported by the server
  - It is used to **create the logic of websites and applications**
  - Typical uses of server-side programming
    - Process user input
    - Display pages
    - Structure web applications
    - Interact with permanent storage
- Web Application Archtecture
- HTTP
  - Definition
    - A statelesss, application-layer protocol for communicating between
      distributed systems
  - Communication takes place over TCP/IP, but any reliable Reviewtransport can
    be used
- URLs(网址)
- Request
  - URLs reveal the identity of the particular host with which we want to
    communicate
  - The common request verbs are
    - GET
      - fetch an existing resource. The URL contains all the necessary
        information the server needs to locate and return the resource
    - POST
      - create a new resource. POST requests usually carry a payload that
        specifies the data for the new resource
  - Status Code
    - Represents requests status
      - 2XX: successful
      - 4XX: Client Error
        - 400: Bad requests
        - 403: Forbidden
        - 404: Not Found

## Introduction to Django and Getting Started

- Django
  - Django is a free and open source web framework, written in Python that
    encourages rapid development
  - It follows the **MVC(Model-view-controller)** pattern, with its own
    modification to be called the MTV framework (Model-Template-View)
  - Includes ORM that supports many databases
- Common tasks supprorted by Django
  - User authentication
  - templates, routes, and views
  - admin interface
  - robust security
  - support for multiple database backends
  - ...

## Chapter2 The First Web Application
