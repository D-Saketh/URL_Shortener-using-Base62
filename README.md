🔗 URL Shortener

    Turn long URLs into short, memorable links — built entirely with Core Java.

A console-based URL Shortener that demonstrates how a real-world URL shortening service works, from user authentication and URL generation to persistent storage and URL retrieval.
✨ What Can It Do?
Feature	Description
👤 Register	Create a new user account
🔐 Login	Authenticate using email & password
🔗 Shorten URL	Convert any long URL into a short URL
📋 My URLs	View URLs created by the logged-in user
🔎 Open Short URL	Enter a short URL and retrieve the original URL
🚪 Logout	End the current user session
💾 Persistence	Store users and URL mappings in files
⚡ How Does It Work?

The core idea is simple:

        🌐 Long URL
             │
             ▼
      Generate ID
             │
             ▼
      🔢 Base62 Encoding
             │
             ▼
      🔗 Short Code
             │
             ▼
   http://short.ly/21

When the user wants the original URL back:

🔗 Short URL
     │
     ▼
Extract Short Code
     │
     ▼
Search URL Mapping
     │
     ▼
🌐 Original URL

🔢 Base62 — The Core Algorithm

Instead of storing a large numeric ID directly, the project converts it into a compact Base62 representation.

Base62 uses:

0123456789
abcdefghijklmnopqrstuvwxyz
ABCDEFGHIJKLMNOPQRSTUVWXYZ

That's 62 possible characters.

The conversion repeatedly divides the ID by 62 and uses the remainders to construct the short code.

ID
 ↓
Divide by 62
 ↓
Take remainder
 ↓
Divide again
 ↓
Repeat
 ↓
Reverse remainders
 ↓
Short Code

For example:

125  →  21

So the application can create:

http://short.ly/21

🏗️ Architecture

The project follows a clean layered design:

                 👤 USER
                   │
                   ▼
            ┌──────────────┐
            │  Controller  │
            └──────┬───────┘
                   │
                   ▼
            ┌──────────────┐
            │   Service    │
            └──────┬───────┘
                   │
                   ▼
            ┌──────────────┐
            │  Repository  │
            └──────┬───────┘
                   │
                   ▼
            ┌──────────────┐
            │ File Storage │
            └──────────────┘

🎮 Controller

Handles user input and application menus.
🧠 Service

Contains the actual business logic such as authentication, ID generation, Base62 conversion, and URL retrieval.
💾 Repository

Responsible for storing and retrieving users and URL mappings.
📁 File Storage

Provides persistence through:
## 📂 Project Structure

```text
URLShortener
│
├── 📁 data
│   ├── users.txt
│   └── urls.txt
│
└── 📁 src
    └── 📁 urlshortener
        │
        ├── 📁 controller
        │   ├── UserController.java
        │   └── URLController.java
        │
        ├── 📁 service
        │   ├── UserService.java
        │   └── URLService.java
        │
        ├── 📁 repository
        │   ├── UserRepository.java
        │   ├── FileUserRepository.java
        │   ├── URLRepository.java
        │   └── FileURLRepository.java
        │
        ├── 📁 model
        │   ├── User.java
        │   └── URLMapping.java
        │
        ├── 📁 exception
        │   └── ShortURLNotFoundException.java
        │
        ├── 📁 util
        │   └── Base62Util.java
        │
        └── Main.java
```

## 🔄 Application Flow

```text
🚀 START
   │
   ▼
┌──────────────────────┐
│  📝 Register / 🔐 Login │
└──────────┬───────────┘
           │
           ▼
   🔐 Authentication
           │
           ▼
     🔗 URL MENU
           │
     ┌─────┼─────┬─────┐
     ▼     ▼     ▼     ▼
  Shorten  View  Open  Logout
    URL    URLs  URL
     │      │     │
     ▼      │     ▼
  Generate │  Extract
  ID       │  Short Code
     │      │     │
     ▼      │     ▼
  Base62   │  Search Mapping
     │      │     │
     ▼      │     ▼
Short Code │ Original URL
     │      │
     └──┬───┘
        ▼
   💾 File Storage
        │
        ▼
   users.txt / urls.txt
```

🧰 Tech Stack

Language

Java 21

Core Concepts

OOP · Interfaces · Collections · Exception Handling · File I/O

Algorithm

Base62 Encoding

Architecture

Controller → Service → Repository

Storage

File-based persistence
🎯 Why This Project?

The project was built to understand how a seemingly simple application like a URL shortener works internally.

It brings together multiple Core Java concepts into one practical application:

    User Authentication → Business Logic → Base62 Algorithm → Data Persistence → URL Retrieval

🚀 Future Enhancements
🌐 Web-based UI for creating, managing, and accessing shortened URLs
🏗️ Scalable System Design with Spring Boot, REST APIs, database, caching, load balancing, and distributed architecture


----------Author: Darimireddy Saketh Ram
