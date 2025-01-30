package prova;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {
        
        Customer c = new Customer(1, "Dmitri", "Mendeleiev", "dimitri@mendeleiev.com", 3, 1);
        CustomerDAO dao = new CustomerDAO();
        
        dao.deleteCustomer(5);
        dao.showCustomers();
        
    }
    
}
