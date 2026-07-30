# Food Delivery API

A RESTful API built with **Spring Boot** for managing restaurants, menus, and customer orders.

## Features
- Search Menu's price and Restaurant
- Top Five highest order
- create order
- get list restaurant
- get restaurant menus
- add, update, delete restaurant 

## Tech Stack

- Java 17 (or your version)
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Jakarta Validation

## Installation
### 1. Clone Repository

```bash
git clone https://github.com/HilmyThoriq/food-delivery.git
cd food-delivery
```

### 2. Configure Database

Import the mysql database from repo

Edit `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run Project

Using Maven

```bash
mvn spring-boot:run
```

or

```bash
mvn clean install
java -jar target/food-delivery.jar
```

Server runs on

```
http://localhost:8080
```

---

# API Endpoints

## Restaurant

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/restaurants` | Get all restaurants |
| GET | `/restaurants/{id}/menus` | Get restaurant menus by ID |
| POST | `/restaurants` | Create restaurant |
| PUT | `/restaurants/{id}` | Update restaurant |
| DELETE | `/restaurants/{id}` | Delete restaurant |

---

## Menu

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/menus` | Get all menus |
| GET | `/menus/{id}` | Get menu by ID |
| POST | `/menus` | Create menu |
| PUT | `/menus/{id}` | Update menu |
| DELETE | `/menus/{id}` | Delete menu |

---

## Order

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/orders/topFive` | Get top 5 highest order |
| POST | `/orders/createOrder` | Create new order |
| GET | `/orders` | Get all orders |

---

## Menu

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/menus/search` | search menu by keyword |

---

# Sample Request

## Restaurant
### Get All Restaurant

**GET**

```
/restaurants
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Restaurants retrieved successfully",
    "data": [
        {
            "id": 1,
            "name": "McDonalds",
            "address": "Jakarta",
            "createdAt": "2026-07-30T23:51:11"
        },
        {
            "id": 2,
            "name": "KFC",
            "address": "Bandung",
            "createdAt": "2026-07-07T23:51:13"
        },
        {
            "id": 3,
            "name": "Burger King",
            "address": "Surabaya",
            "createdAt": null
        },
        {
            "id": 5,
            "name": "KFC halal",
            "address": "Jl. Ahmad Yani No. 11, Bandung",
            "createdAt": "2026-07-31T00:00:12.62312"
        }
    ]
}
```
### Get Menus by Restaurant ID

**GET**

```
/restaurants/{restaurantId}/menus
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Menus retrieved successfully",
    "data": [
        {
            "id": 3,
            "restaurantId": 2,
            "name": "Original Chicken",
            "price": 45000.00
        },
        {
            "id": 4,
            "restaurantId": 2,
            "name": "French Fries",
            "price": 20000.00
        }
    ]
}
```

### Create Restaurant

**POST**

```
/restaurants
```
Request
```json
{
  "name": "KFC kw super",
  "address": "Jl. Ahmad Yani No. 35, Bandung"
}
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Restaurant created successfully",
    "data": {
        "id": 6,
        "name": "KFC kw super",
        "address": "Jl. Ahmad Yani No. 35, Bandung",
        "createdAt": "2026-07-31T01:15:31.1028012"
    }
}
```
### Update Restaurant

**PUT**

```
/restaurants/{restaurantId}
```
Request
```json
{
  "name": "KFC kw super",
  "address": "Jl. Ahmad Yani No. 35, Bandung"
}
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Restaurant updated successfully",
    "data": {
        "id": 5,
        "name": "KFC halal",
        "address": "Jl. Ahmad Yani No. 11, Bandung",
        "createdAt": "2026-07-31T00:00:12.62312"
    }
}
```

### Delete Restaurant

**DELETE**

```
/restaurants/{restaurantId}

```
Response

```json
### Update Restaurant

**PUT**

```
/restaurants/{restaurantId}
```
Request
```json
{
  "name": "KFC kw super",
  "address": "Jl. Ahmad Yani No. 35, Bandung"
}
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Restaurant deleted successfully",
    "data": null
}
```

## Order
### Get Top Highest 5 Orders

**GET**

```
/orders/topFive
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Top five orders retrieved successfully",
    "data": [
        {
            "rank": 1,
            "orderId": 3,
            "customerName": "Thor",
            "totalPrice": 135000.00,
            "totalItems": 3
        },
        {
            "rank": 2,
            "orderId": 4,
            "customerName": "Adi",
            "totalPrice": 135000.00,
            "totalItems": 3
        },
        {
            "rank": 3,
            "orderId": 1,
            "customerName": "Hilmy",
            "totalPrice": 105000.00,
            "totalItems": 3
        },
        {
            "rank": 4,
            "orderId": 2,
            "customerName": "John",
            "totalPrice": 90000.00,
            "totalItems": 2
        }
    ]
}
```

### Get Top Highest 5 Orders

**GET**

```
/orders/createOrder
```
Request
```json
{
  "customerName": "Hah",
  "restaurantId": 2,
  "items": [
    {
      "menuId": 1,
      "quantity": 2
    },
    {
      "menuId": 2,
      "quantity": 1
    }
  ]
}
```

Response
```json
{
    "success": true,
    "status": 201,
    "message": "Order created successfully",
    "data": {
        "id": 5,
        "customerName": "Hah",
        "totalPrice": 135000.00,
        "restaurantId": 2,
        "createdAt": "2026-07-31T01:22:46.2802543"
    }
}
```

## Menu
### Search Menu by keyword

**GET**

```
/menus/search?keyword={keyword}
```
Response

```json
{
    "success": true,
    "status": 200,
    "message": "Menus retrieved successfully",
    "data": [
        {
            "id": 2,
            "name": "French Fries",
            "price": 25000.00,
            "restaurantName": "McDonalds"
        },
        {
            "id": 4,
            "name": "French Fries",
            "price": 20000.00,
            "restaurantName": "KFC"
        }
    ]
}
```




# Future Improvements

- JWT Authentication
- Role-Based Authorization
- Swagger/OpenAPI Documentation
- Pagination & Sorting
- Unit Testing
