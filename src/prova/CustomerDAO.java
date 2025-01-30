package prova;

import java.sql.*;


public class CustomerDAO {
    
    private Connection con;
    
    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Conexão estabelecida.");
    }
    
    public void insertCustomer(Customer c) throws SQLException {
        
        //CREATE - Inserir
            String sql = "insert into customer"
                    + " (store_id, first_name, last_name, email, address_id, active)"
                    + " values"
                    + " (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, c.getStore_id());
            pst.setString(2, c.getFirst_name());
            pst.setString(3, c.getLast_name());
            pst.setString(4, c.getEmail());
            pst.setInt(5, c.getAddress_id());
            pst.setInt(6, c.getActive());
            
            pst.execute();
            pst.close();
            System.out.println("Customer adicionado.");
        
    }
    
    public void deleteCustomer(int id) throws SQLException{
        String sql = "delete from customer " + "where customer_id=?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, id);
        pst.execute();
        pst.close();
        System.out.println("Customer " + id + " excluído.");
    }
    
     public void updateCustomer(int id) throws SQLException{
        String sql = "update customer " + "set store_id=?, first_name=?, last_name=?, email=?, addres_id=?, active=? " + "where customer_id=?"; //Adicione valores
        
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.executeUpdate();
        pst.close();
        System.out.println("Customer " + id + " atualizado.");
       
    }
    
    public void showCustomers() throws SQLException{
        //READ - Consultas
            Statement st = con.createStatement();
            
            String query = "select * from customer limit 5";
            
            ResultSet rs = st.executeQuery(query);
            
            ResultSetMetaData md = rs.getMetaData();
            int col = md.getColumnCount();
            
            System.out.println("Tabela: " + md.getTableName(1));
            
            for (int i = 1; i <= col; i++) {
                System.out.print(md.getColumnName(i) + "\t");
                
            }
            System.out.println("");
            
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }
            
            con.close();
    }
    
}
