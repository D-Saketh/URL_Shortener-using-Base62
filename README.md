URL Shortener

A Core Java console-based URL Shortener that allows users to register, log in, shorten long URLs, view their shortened URLs, and retrieve the original URL using a generated short code.

Features
User registration and login
Email and password authentication
Shorten any URL
Automatic short-code generation using Base62 encoding
View URLs created by the logged-in user
Retrieve the original URL using a short URL
File-based data persistence
Custom exception handling
Layered architecture using Controller, Service, and Repository layers
Architecture
User
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
File Storage
Project Structure
URLShortener
├── data
│   ├── users.txt
│   └── urls.txt
│
└── src
    └── urlshortener
        ├── controller
        │   ├── UserController.java
        │   └── URLController.java
        │
        ├── service
        │   ├── UserService.java
        │   └── URLService.java
        │
        ├── repository
        │   ├── UserRepository.java
        │   ├── FileUserRepository.java
        │   ├── URLRepository.java
        │   └── FileURLRepository.java
        │
        ├── model
        │   ├── User.java
        │   └── URLMapping.java
        │
        ├── exception
        │   └── ShortURLNotFoundException.java
        │
        ├── util
        │   └── Base62Util.java
        │
        └── Main.java
How It Works
1. User Registration

A new user provides:

Name
Email
Password

The user information is stored in users.txt.

2. Login

The application verifies the entered email and password against the stored users.

After successful authentication, the user gets access to the URL menu.

3. Shorten URL

The user enters a long URL:

https://www.example.com/some/very/long/url

The application:

Generates a sequential ID.
Converts the ID into a Base62 short code.
Creates a short URL.
Stores the mapping in urls.txt.

Example:

ID → 125
Base62 → 21

Short URL:
http://short.ly/21
4. Open Short URL

When the user enters:

http://short.ly/21

the application extracts the short code:

21

It searches the stored URL mappings and retrieves the corresponding original URL.

Base62 Encoding

Base62 uses 62 characters:

0-9
a-z
A-Z

The ID is repeatedly divided by 62 and the remainders are used to generate the short code.

This provides a compact representation of the numeric ID.

Data Persistence

The project uses simple text files instead of a database.

users.txt

Stores user information:

1|Saketh|saketh@gmail.com|password
urls.txt

Stores URL mappings:

1|https://example.com|1|1

The fields represent:

ID | Original URL | Short Code | User ID
Technologies Used
Java 21
Core Java
Object-Oriented Programming
Collections
Interfaces
Exception Handling
File I/O
Base62 Encoding
Layered Architecture
Running the Project
Requirements
Java 21 or later
IntelliJ IDEA or any Java IDE


Application Flow:

Start
  ↓
Register / Login
  ↓
Authentication
  ↓
URL Menu
  ├── Shorten URL
  ├── View My URLs
  ├── Open Short URL
  └── Logout

Learning Outcomes

This project provided practical experience with:

Designing a layered Java application
Applying OOP principles
Using interfaces and abstraction
Working with collections
Reading and writing files
Implementing custom exceptions
Understanding URL mapping
Implementing Base62 encoding
Separating business logic from data access
Author

Darimireddy Saketh Ram
  
