# JavaBlog
***Note: The following Readme was written immediately after the completion of this project, in a state of frustration with Java documentation. I have since learnt a lot more about the language, and have less grudges against the community than I did at the time of writing.***

Clone of the Flask tutorial demo blog. This is less of a README and more of a report on my experience of working on this project.
I set out to make a clone of the demo blog from Flask's Python tutorial. I am already quite familiar with Flask and thought this would be a good way to familiarise myself with web development in Java. I was planning to do some further web development in Java and I also wanted to prepare myself better for the programming course I will be undertaking at university. Java is the language used in that course, so I wanted a bit of a headstart.
Ultimately this just turned out to be a project filled with frustrations, but I will get into more details about that soon.
## Design Decisions
Since I was setting out to clone the Flask demo, I wanted to make a web application using the most minimalist tools available in Java. I eventually discovered that development in Java doesn't really work that way. The field appears to contain some basic building blocks which are not at all user friendly, and then some giant bloated frameworks which aren't really suited to individual users. I didn't want to use Spring, or any of the other frameworks people mentioned online. As a Python user, I am used to being able to download some lightweight applications and get started following a basic tutorial. This was not my experience with Java at all.
Anyway, this was my motivation for choosing to build the application using JDBC with SQLite, Servlets and JSP pages in Java EE, and JSP tags. This was all the external technology I used. Unlike SQLAlchemy with Flask, there does not appear to be any easy way of executing database commands in Java without directly passing in SQL syntax. Therefore I was forced to build my own interface to connect the database with the application. I think I did a reasonably good job of creating some classes for interfacing between the two, as well as unit tests to ensure the consistent and smooth operation of this library. Without more experience in Java, however, I can't say for sure if I have followed best practices.
My reason for using Servlets and JSP was basically that it was the only option I could find. When I searched online for web development in Java, I saw mention of Servlets, and then I saw frameworks such as Spring. The need to create a build on the Spring website, as well as the constant mention of paid options was quite offputting, as I am used to working with free software. Looking back, this project would have been far simpler in Spring. I don't regret the choice I made, however, as I was forced to learn a lot.
## Death of the Project
What caused this project to reach an untimely death so close to completion was my attempt to replicate Flask's templating system using JSP and the tag library. This seemed like a task that should have been simple, but I just couldn't find a way to implement it. The more I searched, the more I got the distinct feeling that I was attempting something that Java didn't really support. It seemed as if Java had totally different approaches to these sorts of problems, mainly by pushing bloated proprietary frameworks on the user. I decided that I had learned as much as I needed or wanted to from this project.
## Conclusions
I feel that I benefited greatly from the work involved in adjusting my mind to such a heavily object-oriented style of programming. I definitely increased my understanding of web development and database access by implementing this project in a language that was new to me. I also experienced intense frustration with the state of documentation in Java. On the one hand I could see all the details of each API on Oracle's hideous web pages, never touched by the light of a stylesheet. On the other I had to wade through endless tutorials pointing out the blindingly obvious about how to connect with a database, without ever once explaining how to use these techniques in a more persistent or extensible context.
The biggest takeaway from this project for me was not to work on projects I don't personally care enough about. This project was meant primarily for my portfolio. I didn't have much personal interest in learning more about web development in Java. As a result, I grew frustrated when I couldn't understand how to solve basic problems. Now that I have switched to spending more of my attention on game development, I am much more enthusiastic about what I am learning.
