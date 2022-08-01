



package myframebooksotre;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


public class codes1 {
    Connection con;
    Statement std;
    ResultSet rs;
    DefaultTableModel model;
    
    public Statement setConnection(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","NASRA","nasra123");
            std= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            
            
        }catch(ClassNotFoundException | SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error: " +sqle.getMessage());
            
            
            
        }
        return std;
    }
    public void setSQL(String sql){
        try{
       
           setConnection();
          int r= std.executeUpdate(sql);
             JOptionPane.showMessageDialog(null,r==1?"operation is done":"failed");
       con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            
        }
        
    }
    public void viewTable(String sql,JTable table){
          try{
           setConnection();
           rs=std.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            
        }
}
    public ResultSet search(String sql){
          try{
           
            setConnection();
             rs=std.executeQuery(sql);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            
        } 
    return rs;
}
    

}
