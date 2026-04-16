# Restaurant Management System

## Project Overview
The Restaurant Management System is a Java-based Object-Oriented Programming (OOP) application designed to manage the daily operations of a restaurant. The system integrates multiple modules to handle users, employees, customers, meals, orders, billing, offers, rewards, notifications, and reports.

The goal of this project is to apply OOP principles such as encapsulation, inheritance, abstraction, and modular design to build a structured and scalable system.

---

## Features

### Administrative Module
- Manage employees (Add, Update, Delete, Search, List)
- Manage meals (Add, Update, Delete, Search, List)
- Generate reports (customers, employees, sales)
- Create offers and marketing programs

### Employee Module
- Manage customers (Add, Update, Delete, Search, List)
- Create and cancel orders
- Handle billing and payments
- Receive notifications about offers and rewards

### Customer Module
- Store customer profile and history
- Track orders and payments
- Track received offers and gifts
- Register in loyalty and marketing programs

### Orders & Meals
- Create orders with multiple items
- Calculate total order cost
- Manage meal availability and categories

### Billing & Payments
- Generate bills from orders
- Process payments
- Track payment history
- Apply offers and discounts

### Offers & Rewards
- Apply discounts based on conditions
- Reward customers based on total spending
- Loyalty and reward program support

### Notifications
- Notify employees about new offers
- Notify customers when eligible for rewards

### Reports
- Generate customer reports
- Generate employee reports
- Generate sales and payment reports

---

## Technologies Used

- Java (Core Java)
- Object-Oriented Programming (OOP)
- ArrayList for data storage
- Console-based UI
- Git & GitHub for version control

---

## Project Structure

```

src/
│
├── model/        → Data classes (Customer, Order, Meal, etc.)
├── service/      → Business logic (OrderService, BillingService, etc.)
├── util/         → Helper classes (InputValidator, IdGenerator, etc.)
├── enums/        → Enumerations (OrderStatus, PaymentMethod, etc.)
└── main/         → Main application entry point

```

---

## Team Members & Roles

- Member 1 — Team Leader (Architecture & Integration)
- Member 2 — Employee & Customer Management
- Member 3 — Meals & Orders
- Member 4 — Billing, Offers & Reports
- Member 5 — Menus & Input Handling
- Member 6 — Programs, Testing & Documentation

---

## How to Run the Project

1. Clone the repository:
```

git clone [git@github.com](mailto:git@github.com):M0SAIF-ANTNET/Restaurant-Management-System.git

```

2. Navigate to the project folder:
```

cd Restaurant-Management-System

```

3. Compile the project:
```

javac src/main/Main.java

```

4. Run the project:
```

java src.main.Main

```

---

## Development Workflow

- Each team member works on a separate branch
- Changes are committed with clear messages
- Code is reviewed and merged by the Team Leader
- Main branch contains stable code only

---

## System Workflow

1. Admin logs in and manages employees and meals  
2. Employee logs in and manages customers  
3. Employee creates an order for a customer  
4. Order total is calculated  
5. Bill is generated  
6. Payment is processed  
7. System checks for offers and rewards  
8. Notifications are sent  
9. Reports can be generated  

---

## OOP Concepts Applied

- Encapsulation → Private fields with getters/setters  
- Inheritance → Person → User → Admin/Employee  
- Abstraction → Separation of models and services  
- Composition → Order contains OrderItems, OrderItem contains Meal  

---

## Future Improvements

- Add GUI (JavaFX or Swing)
- Add database integration (MySQL)
- Add authentication security
- Improve reporting system
- Add real-time notifications

---

## Final Note

This project demonstrates how to build a complete system using Object-Oriented Programming principles. The focus is on clean architecture, modular design, and proper collaboration between team members.

---
