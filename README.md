# Fundamental_Project

# GameLibrary



* [Brief](#Brief)
  * [Additional Requirements](#Additional-Requirements)
  * [Application Requirements](#Application-Requirements)
* [User Stories](#User-Stories)
* [MoSCoW Prioritisation](#MoSCoW-Prioritisation)
* [Implementation](#Implementation)
* [Risk Assessment](#Risk-Assessment)
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



### Implementation

### Database Structure
The following picture is an Entity Relationship (ERD) and it shows the relationship between the different tables on this application.

![Database Structure v1](https://github.com/psilva12/Fundamental_Project/blob/master/ERD%20v1.png)

As it can be observerd in the ERD, there is a one to many relationship between the user and the library, as an user can have multiple Libraries under their profile. Likewise, library has a one to many relationship with the games table and a single library can have multiple games.

### CI Pipeline

![CI Pipeline](https://github.com/psilva12/Fundamental_Project/blob/master/CI%20Pipeline.png)

The CI Pipeline in the picture above is the continuous integration pipelines and all frameworks and sercives that played a part in building this application. The current pipeline allows for fast, simple and efficient integration in the application, as a developer I can produce new features or fix current ones and push my solution to GitHub, which will then trigger CircleCi that will check that code and produce an error reports. 
After the report is complete and no errors have been found CircleCi will push the new code live to the cloud VM, in this case we are using Google Cloud Platform(GCP).

### Project Tracking

I used Jira to keep track of tasks and issues that needed to be addressed in order to complete the application, the jira board can be found here: [Jira Board](https://psos11.atlassian.net/secure/RapidBoard.jspa?rapidView=2&projectKey=FP&selectedIssue=FP-28)

![Jira Board Sprint1](https://github.com/psilva12/Fundamental_Project/blob/master/Jira%20Board.png)


![Jira BackLog](https://github.com/psilva12/Fundamental_Project/blob/master/Jira%20BackLog.png)

The board was design with 3 fields for each Sprint. In the case for this application it was one sprint for the first iteration of the application, the 3 fields are To Do which represents the tasks still to do from that sprint. In Progress which is the issue being currently tackled and finally Done which are all the issues currently completed on the Sprint.
As it can be obversed the vast majority of issues for this Spring have been successfully completed, the other will carry on to the next Sprint which will take care of the next iteration of the application.


### Risk Assessment
Risk assessment can be found here: [Google Docs](https://docs.google.com/document/d/1W9KHjCci3DqWZmPc7FcpdVsgnVJplajcUnwxI6uf4u8/edit?usp=sharing)

Screenshots of the same document can be seen bellow:

![Risk Assessment pic1](https://github.com/psilva12/Fundamental_Project/blob/master/risk%201.png)

![Risk Assessment pic2](https://github.com/psilva12/Fundamental_Project/blob/master/risk%202.png)

### CI Server

The yaml file is responsible to give Circle Ci instructions to test, build and deploy the application. These are the instructions for this project:

![Ci Server Yaml](https://github.com/psilva12/Fundamental_Project/blob/master/src/main/resources/static/images/CI.png)

### Front-End
The Front End pages at this moment are styled to a certain degree, the front end was build mainly in HTML. However the application is stable and functional.

As the user naviates for the first time to the application is it required to create an account
![Sign Up](https://github.com/psilva12/Fundamental_Project/blob/master/src/main/resources/static/images/SignUp%20Page.png)

This is the main page for the application where the user can add games and libraries to their profile
![User Page](https://github.com/psilva12/Fundamental_Project/blob/master/src/main/resources/static/images/User%20Profile.png)

Example:
![User Library](https://github.com/psilva12/Fundamental_Project/blob/master/src/main/resources/static/images/library%20example.png)

And finally the edit page where the user can edit and delete games or library as he/she wishes no longer to have them or correct any errors on creation.

![Edit Page](https://github.com/psilva12/Fundamental_Project/blob/master/src/main/resources/static/images/editPage.png)


### Future Improvements

There are a few Future Improvement I would like to implement for this application:
* Fix the Login to allow multiple users to use the application simultaneously
* Allow the users to manage their profile more freely, allowing them to follow other users and see their game libraries.
* Fix and improve the UI
* Add a Game Suggestion feature where it would generate games for the user to choose to add on their libraries.

