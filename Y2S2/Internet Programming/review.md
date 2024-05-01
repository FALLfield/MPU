## Mid-term Review

- Highlights

  1. What is the difference between server-side programming and client-side programming

  Client-side programming is writing code that will run on the client, and is done in languages that can be executed by the browser, such as JavaScript. It involves everything users see on their screens. Client side programming has mostly to do with the user interface.
  The server side isn't visible to users, but it powers the client side, just as a power station generates electricity for your house. Code will run on the server. Used to create the logic of websites and applications

  2. There are 2 methods for submitting a form, GET vs POST. Briefly explain the difference between them

  GET: fetch an existing resource. The URL contains all teh necessary information the server needs to locate and return the resource.
  POST: create a new resource. POST requests usually carry a payload that specifies the data for the new resource

  3. What is a virtual reality? WHy do you need it?

  Virtual environments allow multiple installations of Python and their relevant packages to exist together in harmony. Because several Python applications that require a different version to run.

  4. Explain how Django implements its MTV framework

  Django uses models.py and views.py to implement MTV framework. models.py contins a description of the databse talbel of a Python class. views.py contains the businees logic for the page.

  5. Write hte commadn to create a project. Name some of the major files/directory structure that are created as result.

  `django-admin startproject (projectname)`
  It will produces a projectname directory, with manage.py in it. And a proejctname directory in it. In the proejct level , it contains **init**.py,settings.py,urls.py,wsgi.py

  6. Write the command to create an application. Name some of the major files / directory structure that created as a result

  `python manage.py startapp (app name)`

  It will contains **init**.py, admin.py, apps.py, migrations(with **init**.py) models.py, tests.py, views.py

  7. How to register an application to a Django project

  Add your application name in the settings.py, value = INSTALLED_APPS

  8. Name any 2 parameters your can configure in settings.py. For each of them, briefly explain what it is.

  INSTALLED_APPS points the registed apps. ALLOWED_HOST points the url the website uses.

  9. Load your website(yourusername.pythonanywhere.com/myApp) on the browser and the content of home.html is displayed as a result. Describe what has taken place to make this happen, fir example, by referring to the file and the corresponding content.

  Firstly we should create a APP and register it in settings.py. Then update the views.py file in the app level by using TemplateView to create View class which will points to home.html. Then Edit the proejct-level urls.py and create a application-level urls.py to modify the url we use.

  10. What is Django ORM

  Django ORM (Object-Relational Mapping) is a component of the Django web framework that provides an abstraction layer for interacting with databases. It allows developers to work with databases using Python code instead of writing raw SQL queries.

  11. After writing models.py, what are the two commands that are needed in order to apply the changes to the database? What is the difference between those 2 commands

  Firstly the migrate command to create an initial database based in Django's default settings `python manage.py migrate`
  Secondly, we create a migration file for an app with `python manage.py makemigrations app`
  Finally, we build the actual database with migrate which executes the instructions in our migrations file `python manage.py migrate app`

  12. For a model class, name any 4 of the common fields

  CharField, TextField, IntegerField, DateTimeField

  13. Understand (not necessary to write) manager method for a model

  In Django, a manager is a class that provides methods for querying the database and performing operations on a model's data. By default, every Django model has at least one manager, called the "default manager," which is automatically created for you. However, you can also define custom managers to add additional query methods or modify the default behavior.

  14. Django provides three types of fileds for forging relationships between models in your database. What are they?

  ForeignKey, ManyToManyField, OneToOneField

  15. Assuming you have a Django model named 'User', how do you define a foreign key field for this model in another model?

  `host = models.ForeignKey(User, related_name="host_set")`

  16. You should add a `get_absolute_url()` and `__str_()` method to each model you write. Briefly explain what each of these 2 methods do.

  `__str__()` method to improve the readability of methods. It is a quick way to change the representation of an object from a meanginless string to understandable data.
  `get_absolute_url()` method tells Django how to calculate the canonical URL for an object, which is "the official URL where this model is displayed"

  17. What is the command to create a superuser for the Django Admin?

  Fistly use `python manage.py createsuperuser`

  18. How to reigster models in Django Admin Site

  Edit the admin.py
  `from django.contrib import admin
from .models import Post
admin.site.register(modelname)`

  19. In order to use Django's template-loading API, you need to tell where the templates are. How do you do that?

  Edit the settings.py to add `DIRS:[BASE_DIR/'templates']}`

  20. In settings.py, what does this mean: 'DIRS:[BASE_DIR/'templates']'

  BASE_DIR is a variable that stores the path to the directory in which your project's settings.py module is contained. DIRS contains a list of paths to folders containg templates.

  21. In settings.py. What is the result of APP_DIRS set to True for TEMPLATES

  APP_DIRS is True by default, meaning Django will look for a folder named templates in each of your apps

  22. When will you use DetailView? How does it work? What causes DetailView to return 404 error?

  DetailView should be used when you want to present detail of a single model instance, which is similar to executing the SQL statement. DetailView expects a primary key passed to it as the identifier, via the URL. If the object does not exist, there is an Http404 Pge Noe Found exception.

  23. CRUD functionality: You need to know how to write the view and template files or each of the functionality

  Create Update Delete `{% crsf_token %}`
  ``#CreateView
  #views.py
  from django.views,generic.edit import CreateView
  class BlogViewCreate(CreateView):
  model = post
  template_name = 'post_new.html'
  fields = '**all**'

                  #html
                  <form action="" method = "post">{%csrf_token%}
                      {{form.as_p}}
                  <input type="submit" value="Save"/>
                  </form>`

  #Update View
  #views.py
  from django.views.generic import UpdateView
  class BlogUpdateView(UpdateView):
  model = post
  template_name = "post_update.html"
  fields = ['title','body']
  HTML
  <form action="" method = "post">{%csrf_token%}
  {{form.as_p}}
  <input type="submit" value="Save"/>
  </form>

  #DeleteView
  views.py
  from django.view.generic import DeleteView
  from .models import Post
  from django.urls import reverse_lazy
  class BlogDeleteView(DeleteView):
  model = Post
  template_name = 'post_delete.html'
  sucess_url = reverse_lazy('home')
  HTML
  <form action="" method="post">{{%csrf_token%}}
  <p>Are you confirm to delete?</p>
  <input type="submit" value="Confirm"/>
  </form> 24. By default, Django's class-based DetailView expects the pk as argument for the generic view. Name the method that needs to be overriden in order to replace this default behavior

  `get_object()` We can override the get_object so that it gets the single desired obejct from the database

  25. What is the purpose of writing the following line in a generic DeleteView?`success_url = reverse_lazy('home')`

  Load the homepage after delete is done successfully.

  26. Briefly explain how to configure a folder to hold static content (images, CSS) in a Django project

  - First, create a project-level folder for placing the static files
  - Confirm that in settings.py, INSTALLED_APPS has 'django.contrib.staticfiles' variable
  - Update STATICFILES_DIRS of settings.py to tell Django where to look for these static files.

  27. In settings.py, what is the result of defining the parameter LOGIN_REDIRECT_URL with a named URL pattern

  Set where to redirect the user upon a successful login
  The **LOGIN_URL** parameter is used to specify the URL where the user should be redirected if they are not logged in and try to access a view that requries authentication. 28. What is the use of django.contrib.auth in the INSTALLED_APPS tuple?

  django.contrib.auth provides Django with access to the authentication system, which should be listed in INSTALLED_APPS tuple within the settings.py file.

  29. What are the steps to add the Login/Logout functions using Django's default user model?

      - Add a project-level urlpattern for the auth system
      - Creating the login template, the login template being rendered
      - Edit settings.py to set where to redirect the user like `LOGIN_REDIRECT_URL='home', LOGOUT_REDIRECT_URL='home'`
      - Provide a link to login

  30. What are the steps to add the Sign Up function using Django's default user model?

            - Create an application, like 'acounts'
            - Add a project-level urlpattern to point to this new app
            - Create the file accounts/urls.py with the url mapping to handle sign up
            - Write the logic for the view SignUpView as stated in step 3 above, in views.py.
              `from django.contrib.auth.forms import UserCreationForm

      from django.urls import reverse_lazy
      class SignUpView(generic CreateView):
      form_class = UserCreationForm
      success_url = reverse_lazy('login')
      template_name = 'signup.html'`      - Create the template file for the presentation of the signup page`<form method = "post">{% csrf_token %}
      {{form.as_p}}
      <button type="submit"> Signup</button>
      </form>` - Provide a link

  31. Write the template with the necessary template tags and template variables such that

  - for a login user, the username and a logout link is displayed
    `{% if user.is_authenticated %}
      <p>{{user.username}}</p>
      <p><a href="{% url 'logout' %}">logout</a><p>`
  - for a logout user, a login link is displayed  
    {%else%}
    <p>You are not logged in </p>
    <p><a href="{%url 'login'%}>Login</a></p>"
    {%endif%}

  32. Write the template file for login.html with two textboxes for id and password and a button to submit the form

      ``{%extends 'base.html'%}
      {% block content %}
      <h1>Login</h1>
      <form method = "post">{% csrf_token %}
          {{form.as_p}}
      <button type = "submit">Login</button>
      </form>
      {%endblock content%}``

  33. Given the following URL ..
      - Waht action causes this URL to be displayed on the browser
        Because the User haven't login and enter the articles/new url, so that it will redirect to this url. After the User login then it will go to articles/new url.
  34. What is the purpose of writing the following line in settings.py
      AUTH_USER_MODEL = 'yourAppNameHere.CustomUser'
      Updating the settings.py is to tell Django to replace the built-in custom model to the new custom user model.
