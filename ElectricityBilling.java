import java.sql.;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Customer {
    private String customerId;
    private String name;
    private double unitsConsumed;
    private double billAmount;

    public Customer(String customerId, String name, double unitsConsumed) {
        this.customerId = customerId;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
        calculateBill();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void calculateBill() {
        MapString, Double rateSlabs = new HashMap();
        rateSlabs.put(slab1, 1.5);
        rateSlabs.put(slab2, 2.5);
        rateSlabs.put(slab3, 4.0);

        if (unitsConsumed = 100) {
            billAmount = unitsConsumed  rateSlabs.get(slab1);
        } else if (unitsConsumed = 300) {
            billAmount = (100  rateSlabs.get(slab1)) + ((unitsConsumed - 100)  rateSlabs.get(slab2));
        } else {
            billAmount = (100  rateSlabs.get(slab1)) + (200  rateSlabs.get(slab2)) + ((unitsConsumed - 300)  rateSlabs.get(slab3));
        }
    }

    public double getBillAmount() {
        return billAmount;
    }

    public String getName() {
        return name;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }
}

class ElectricityBillingSystem {
    private Connection connection;

    public ElectricityBillingSystem() {
        try {
            connection = DriverManager.getConnection(jdbcsqliteelectricity_billing.db);
            initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeDatabase() {
        String createTableQuery = CREATE TABLE IF NOT EXISTS Customers ( +
                                  customer_id TEXT PRIMARY KEY,  +
                                  name TEXT NOT NULL,  +
                                  units_consumed REAL NOT NULL,  +
                                  bill_amount REAL NOT NULL);
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(String customerId, String name, double unitsConsumed) {
        Customer customer = new Customer(customerId, name, unitsConsumed);
        String insertQuery = INSERT INTO Customers (customer_id, name, units_consumed, bill_amount) VALUES (, , , );
        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getName());
            pstmt.setDouble(3, customer.getUnitsConsumed());
            pstmt.setDouble(4, customer.getBillAmount());
            pstmt.executeUpdate();
            System.out.println(Customer  + name +  added successfully.);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllCustomers() {
        String selectQuery = SELECT  FROM Customers;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            if (!rs.isBeforeFirst()) {
                System.out.println(No customers found.);
                return;
            }

            while (rs.next()) {
                System.out.println(-------------------------------);
                System.out.println(Customer ID  + rs.getString(customer_id));
                System.out.println(Name  + rs.getString(name));
                System.out.println(Units Consumed  + rs.getDouble(units_consumed));
                System.out.printf(Total Bill $%.2f%n, rs.getDouble(bill_amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(String customerId) {
        String deleteQuery = DELETE FROM Customers WHERE customer_id = ;
        try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setString(1, customerId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected  0) {
                System.out.println(Customer ID  + customerId +  removed successfully.);
            } else {
                System.out.println(Customer not found.);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricityBillingSystem system = new ElectricityBillingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(nElectricity Billing System);
            System.out.println(1. Add Customer);
            System.out.println(2. View All Customers);
            System.out.println(3. Remove Customer);
            System.out.println(4. Exit);

            System.out.print(Enter your choice );
            int choice = scanner.nextInt();
            scanner.nextLine();  Consume the newline

            switch (choice) {
                case 1
                    System.out.print(Enter Customer ID );
                    String customerId = scanner.nextLine();
                    System.out.print(Enter Customer Name );
                    String name = scanner.nextLine();
                    System.out.print(Enter Units Consumed );
                    double unitsConsumed = scanner.nextDouble();
                    system.addCustomer(customerId, name, unitsConsumed);
                    break;
                case 2
                    system.viewAllCustomers();
                    break;
                case 3
                    System.out.print(Enter Customer ID to Remove );
                    String idToRemove = scanner.nextLine();
                    system.removeCustomer(idToRemove);
                    break;
                case 4
                    System.out.println(Exiting system. Goodbye!);
                    scanner.close();
                    return;
                default
                    System.out.println(Invalid choice. Please try again.);
            }
        }
    }
}
