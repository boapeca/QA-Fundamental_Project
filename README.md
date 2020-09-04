# Fundamental_Project

# GameLibrary



* [Brief](#Brief)
  * [Additional Requirements](#Additional-Requirements)
  * [Application Requirements](#Application-Requirements)
* [User Stories](#User-Stories)
* [MoSCoW Prioritisation](#MoSCoW-Prioritisation)
* [Risk Assessment](#Risk-Assessment)
* [Implementation](#Implementation)
* [Front-End](#Front-End)
* [Future Improvements](#Future-Improvements)

### Brief

The objective of this project was "To create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training."
That being said I have decided to make an application that allows the user to read, add, edit and delete games from their own library. This has an aim of allowing the user to create libraries in their profile.

### Additional Requirements

I am also required to include the following:

* Kanban Board : Jira
* Documentation on the project
* A java based functional application
* <del> Testing
* Version Control System : Github
* CI server and GCP

### Application Requirements

To be able to produce a simple but functional Game Library application, it must contain or allow the user to do the following:

* Create a user account that stores:
  * User Name
  * Email
  * Password
* Allow the user to create libraries and games
* Edit games and libraries
* Delete any unwanted games or libraries
* View and update their account details
* Delete their account

### User Stories

For this project the user has to be able to interact and do certains actions with the web application. The user stories for the current iteration are as follows:

 * As an user I want to be able to register in the application to have a my own profile.
 * As an user I want to be able to able to see my Game Library. (Read)
 * As an user I want to be able to add Games to my Library. (Create)
 * As an user I want to be able to delete Games from my Library.(Delete)
 * As an user I want to be able to edit Games on my library. (Update)
 * As an user I want to be able to edit my name/password on my profile.

### MoSCoW Prioritisation

**NEEDS CHANGING**

| Prioritisation     | Specification    |  
| ----------- | ----------- |  
| Must      | The application must allow the user to create a personal account |
| Must   | The application must allow the user to add multiple Libraries|
| Must   | The application must allow the user to add, edit and delete games from their profile|
| Should   | The application should allow the user to edit their profile| 
| Could    |  The application could allow the user to customize their profile, user icons, folders for their games, etc. |
| Wont | The application could allow users to search for other users profiles|


### Risk Assessment
Risk assessment can be found here: [Google Docs](https://docs.google.com/document/d/1W9KHjCci3DqWZmPc7FcpdVsgnVJplajcUnwxI6uf4u8/edit?usp=sharing)

Screenshots of the same document can be seen bellow:

![Risk Assessment pic1](https://github.com/psilva12/Fundamental_Project/blob/master/risk%201.png)

![Risk Assessment pic2](https://github.com/psilva12/Fundamental_Project/blob/master/risk%202.png)

### Implementation

### Database Structure
The following picture is an Entity Relationship (ERD) and it shows the relationship between the different tables on this application.

![Database Structure v1](https://github.com/psilva12/Fundamental_Project/blob/master/ERD%20v1.png)

As it can be observerd in the ERD, there is a one to many relationship between the user and the library, as an user can have multiple Libraries under their profile. Likewise, library has a one to many relationship with the games table and a single library can have multiple games.

### CI Pipeline

![CI Pipeline]()

### Front-End


### Future Improvements

