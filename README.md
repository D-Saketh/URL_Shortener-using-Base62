URL Shortener

A Core Java console-based URL Shortener designed to demonstrate how a simple URL shortening system works while applying important Java and software design concepts. The application allows users to register and log in, shorten long URLs into compact short URLs, view their previously created URLs, and retrieve the original URL using the generated short code.

Features
User Registration & Login – Users can create an account and authenticate using their email and password.
URL Shortening – Users can enter any URL and generate a unique short URL.
Base62 Encoding – Sequential IDs are converted into compact short codes using Base62 encoding.
View My URLs – Logged-in users can view the URLs they have previously shortened.
URL Retrieval – Users can enter a generated short URL to retrieve the corresponding original URL.
File-Based Persistence – User information and URL mappings are stored in text files, allowing data to remain available after the application is closed.
Exception Handling – Custom exceptions are used to handle cases such as an invalid or unavailable short URL.
How It Works

The application starts with a user authentication menu where the user can either register, log in, or exit.

After successful login, the user is presented with a URL menu containing options to shorten a URL, view their URLs, open a short URL, or log out.

When a user chooses to shorten a URL, the application generates a sequential ID for the URL. This ID is then converted into a Base62 short code using digits, lowercase letters, and uppercase letters.

For example:

Long URL
    ↓
Generate Sequential ID
    ↓
Base62 Encoding
    ↓
Generate Short Code
    ↓
Store URL Mapping
    ↓
Return Short URL

The URL mapping contains the ID, original URL, generated short code, and the ID of the user who created it.

When the user wants to retrieve the original URL, they enter the short URL. The application extracts the short code and searches the stored URL mappings. Once a matching short code is found, the corresponding original URL is returned.

Architecture

The project follows a layered architecture to separate different responsibilities:

                Main
                 ↓
            Controller
                 ↓
             Service
                 ↓
           Repository
                 ↓
           File Storage
Controller Layer

Handles user interaction through the console and receives input from the user.

Service Layer

Contains the main business logic, such as authentication, URL shortening, Base62 conversion, and retrieving original URLs.

Repository Layer

Responsible for reading and writing user and URL data.

File Storage

The application uses:

data/
├── users.txt
└── urls.txt

instead of a database for persistence in this version of the project.

Base62 Encoding

Base62 encoding is used to generate compact short codes from sequential numeric IDs.

The character set contains:

0-9
a-z
A-Z

This gives a total of 62 characters.

The algorithm repeatedly divides the ID by 62 and uses the remainders to construct the short code.

For example:

Sequential ID
      ↓
Repeated division by 62
      ↓
Remainders
      ↓
Reverse the result
      ↓
Base62 Short Code

This allows numeric IDs to be represented using shorter combinations of characters.

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
Technologies & Concepts
Java 21
Core Java
Object-Oriented Programming
Encapsulation
Abstraction
Interfaces
Collections
File Handling
Exception Handling
Custom Exceptions
Base62 Encoding
Layered Architecture
Separation of Concerns
Constructor-based dependency injection




Author - Darimireddy Saketh Ram
