# Bus Reservation System (Java + MySQL)

## Overview
This is a simple console-based bus reservation system built using Java and MySQL. The application allows users to view available buses, check seat availability, and make bookings for a selected date. It demonstrates backend logic, database connectivity, and basic object-oriented design.

---

## Features
- Display available buses with details
- Book tickets by entering passenger details
- Check seat availability before confirming booking
- Store booking data in a MySQL database
- Prevent overbooking based on capacity

---

## Tech Stack
- Java
- JDBC
- MySQL

---

## Project Structure
BusReserv/
├── BusDemo.java # Application entry point
├── Bus.java # Bus model class
├── Booking.java # Booking logic and input handling
├── BusDao.java # Bus-related database operations
├── BookingDao.java # Booking-related database operations
├── DbConnection.java # Database connection configuration

---

## Database Setup

### Create Database
```sql
CREATE DATABASE busresv;
USE busresv;

Create Tables
Bus Table
CREATE TABLE bus (
    id INT PRIMARY KEY,
    ac INT,
    capacity INT
);
Booking Table
CREATE TABLE booking (
    passenger_name VARCHAR(50),
    bus_no INT,
    travel_date DATE
);
Configuration

Update database credentials in DbConnection.java:

private static final String url = "jdbc:mysql://localhost:3306/busresv";
private static final String userName = "root";
private static final String passWord = "your_password";
