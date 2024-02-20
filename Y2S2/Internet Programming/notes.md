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
    modification to be called the **MTV framework (Model-Template-View)**
  - Includes ORM that supports many databases
- Common tasks supprorted by Django
  - User authentication
  - templates, routes, and views
  - admin interface
  - robust security
  - support for multiple database backends
  - ...

## Chapter2 The First Web Application

- Building the first Web application with views and URLConfs

- We specify the function display in views.py by URLConfs
- What is MTV Framework
  - M stands for Model
  - T stands for Template
  - V stands for View
- What is a Django Application?
  - A single Django project contains one or more apps within it that all work
    together to power a web application.
- In settings.py
  - Domain name
  - Application name
- How to create an App -`python manage.py startapp pages`
  - App files
    - admin.py
    - apps.py
    - migrations/
    - models.py
    - tests.py
    - views.py
  - ## prject-level urls.p

## Chapter3 Templates and ClassBasedViews

- Templates 
    - Django uses templates so that individual HTML files can be served by a view to a web page specified by the URL 
    - A Django template is a text document, or a normal Python string, that is marked up using the Django template language, with the intention to separate the presentation of a document from its data 
        - **A template can contain template tags and variables**
    - Template Filters
        - Template filters are simple ways of altering the value of variables before they're displayed. Like:
            ``{{name | lower}}``
        - Filters can be chained, that takes the first element in a list and converts it to uppercase 
            ``{{my_list|first|upper}}``
    - Template tags
        - if/else
            ``` {% if athlete_list %}
                    Numver of athletes: {{athlete_list | length}}
               {% elif athlete_in_locker_room_list %}
                    <p>Athletes should be out of the locker room soom! </p>
            ```
        - for
            ``{% for key, value in data.items %} {% endfor %}``
        - for - an optional {%empty%} clause
            ``{% for athlete in athelete_list %} ... {% empty %} ... {% endfor %}`` 
            just like an if\else clause, empty points the situation that empty content in list 
        - forloop tamplate variable
            - forloop.counter 
                - Always set to an integer representing the number of times the loop has been entered
            - forloop.revcounter
            - forloop.revcounter0
            - forloop.first
            - forloop.last
            - forloop.parentloop
                - A reference to the forloop object for the parent loop 
        - Comment
            - ``{# ... #}`` for one line
            - ``{% comment %} .... {% comment %}`` for multiple lines
    - Normally, Django looks within each app for templates
        - If we want to customize the templates path, *we should change the TEMPLATES structure's DIRS*
        - Firstly, create a project-level folder called templates(myTestSite/templates) and an HTML file called home.html
        - Under DIRS, use [BASE_DIR/'templates']
            - BASE_DIR is a variable that stores the path to the directory in which your project's setting.py module is contained 

- Class-Based Views: TemplateView
    - example
        ```python 
        #pages/views.py
        from django.views.generic import TemplateView
        class HomePageView(TemplateView):
            template_name = 'home.html' ```
    - then change URLs 
        - example
            ```python
            #pages_project/urls.py
            from django.contrib import admin
            from django.urls import path, include
            urlpatterns = [
                path('admin/', admin.site.urls),
                path('',include('pages.urls')),
            ]```

            ```python
            #pages/urls.py 
            from django.urls import path
            from . import views
            urlpatterns = [
                path('',views.HomePageView.as_view(), name='home'),
            ]```
- Summary
    - Django uses templates to generate THML files so that individual HTML files can be served by a view to a web page specified by the URL 
    - Extending Templates
        - One place for our header code that would be inherited by all other templates 
        - The content of base.html is as follows
            ```HTML 
            < !-- templates/base.html -- >
            <header>
                <a href="{% url 'home' %}"Home</a> | <a href="{%url 'about'%}About</a>"
            <header>```
## Chapter 4 Models with Django Admin

- ORM (Object Relational Mapper)

  - With Django, querying an underlying database is taken care of by the _ORM_
  - An ORM tool provides a simple mapping between an object(the 'O' in ORM) and
    the underlying database compared to traditional SQL
  - RAW SQL queries are complex than Django ORM
  - example of SQL

  ```py
    from django.shortcuts import render
    import MySQLdb

    def book_list(requrest) :
        db = MySQLdb.connect(user = 'me', db = 'mydb', passwd = 'secret', host = 'localhost')
        cursor = db.cursor()
        cursor.execute('SELECT name FROM books ORDER BY name')
        names = [row[0] for row in cursor.fetchall()]
        db.close()
        return render(request, 'book_list.html', {'names':names})
  ```

- Database-driven websites
  - Most modern web applications foten involves interacting with a database
  - Behind the scenes, a database-driven website connects to a database server,
    retrieves some data out of it, and display that data on a web page.
- Problems of raw SQL queries

  - Hard-coding the databse connection parameters. Ideally, these parameters
    would be stored in the Django configuration
  - Boilerplate code: Creating a connection, creating a cursor, executing a
    statement, and closing the connection. Ideally, all we'd have to do is
    specify which results we wanted
  - It ties us to MySQL. If we want to switch from MySQL to PostgreSQL, we'll
    most likely have to rewrite a large amount of our code.

- Defining Models in Python

  - A Django model is a description of the data in database, represented as
    Python Code
  - SQL is _inconsisten across databas plateforms_. If you 're distributing a
    web application, for example, it's much more pragmatic to distribute a
    Python module that describes your data layout thatn separate sets of CREATE
    TABLE statements for MySQL, PostgreSQL, and SQLite.

- Field name
  - Field name restriction
    - A field name cannot be  a Python reserved word
    - A field name cannot contain more than one underscore in a row 
