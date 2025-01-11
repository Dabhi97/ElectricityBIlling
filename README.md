# Electricity Billing System

## Project Description
The Electricity Billing System is a database-driven Java application designed to manage customer records, calculate electricity bills using tiered pricing logic, and generate bill summaries. It showcases the use of Object-Oriented Programming (OOP) principles, database integration with SQLite, and Java Database Connectivity (JDBC) for efficient CRUD (Create, Read, Update, Delete) operations.

## Features
- Add, retrieve, update, and delete customer records.
- Calculate electricity bills based on the number of units consumed.
- Store and manage data persistently using an SQLite database.
- Generate bill summaries for customers.

## Technologies Used
- **Java**: Core application logic and structure.
- **SQLite**: Lightweight database for data storage.
- **JDBC (Java Database Connectivity)**: For connecting and interacting with the SQLite database.

## Database Schema
The database includes a single table for storing customer information:
```sql
CREATE TABLE Customers (
    customer_id TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    units_consumed REAL NOT NULL,
    bill_amount REAL NOT NULL
);
```

## Setup Instructions

### Prerequisites
- **Java Development Kit (JDK)**
- SQLite (or DB Browser for SQLite for manual database management)
- SQLite JDBC driver (`sqlite-jdbc-<version>.jar`)

### Steps to Run
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd ElectricityBillingSystem
   ```

2. **Set Up the Database**:
   - Ensure the `electricity_billing.db` file is present in the project folder.
   - Alternatively, create the database using the provided `schema.sql` file:
     ```bash
     sqlite3 electricity_billing.db < schema.sql
     ```

3. **Compile the Java Files**:
   ```bash
   javac -cp "lib/sqlite-jdbc-<version>.jar" *.java
   ```

4. **Run the Application**:
   ```bash
   java -cp ".:lib/sqlite-jdbc-<version>.jar" Main
   ```

### Example Usage
1. Add a new customer:
   - Input: Customer ID, Name, Units Consumed.
   - Output: Confirmation of record addition.

2. Generate a bill:
   - Input: Customer ID.
   - Output: Calculated bill amount based on tiered pricing.

3. View all customer records:
   - Output: List of all customer details stored in the database.

4. Delete a customer:
   - Input: Customer ID.
   - Output: Confirmation of record deletion.

## Future Enhancements
- Implement data filtering, sorting, and analytics features using SQL queries.
- Add a graphical user interface (GUI) for improved usability.
- Enable exporting of bill summaries to PDF or Excel.

## Contributing
Feel free to fork this repository, make enhancements, and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

---

Happy coding!

