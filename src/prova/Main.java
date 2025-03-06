package prova;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {
        
        Customer c = new Customer(1, "Dmitri", "Mendeleiev", "dimitri@mendeleiev.com", 3, 1);
        CustomerDAO dao = new CustomerDAO();
        
        dao.deleteCustomer(5);
        dao.showCustomers();
        
        //Salvar arquivos no GitHub diretamente do PowerShell
        //Entrar no diretório do arquivo através do cd "C:\Users\20221074010001\Documents\NetBeansProjects\prova"
        //> git add .
        //> git commit -m "Comentário"
        //> git push -u origin main
        
    }
    
}
