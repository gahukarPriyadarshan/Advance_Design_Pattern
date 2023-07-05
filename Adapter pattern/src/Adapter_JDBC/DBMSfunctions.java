package Adapter_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMSfunctions {
    public Connection connect_to_database(String dbURL,String dbUser,String dbPass){
        Connection conn=null;

        try{
            conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if(conn != null){
                System.out.println("Conn established");
            }
            else{
                System.out.println("conn not established ");
            }

        }catch( Exception e){
            System.out.println("q");
        }
        return conn;
    }

    public void createTable(Connection conn,String tableName){
        Statement statement;
        try {
            String query = "create table " + tableName +
                    "(empid SERIAL, empname varchar(20)," +
                    " empaddress varchar(30) ,empsalary double precision ,primary key(empid))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created ...");


        }catch(Exception e){
            System.out.println("Error " + e);
        }
    }
    public void deleteEmployee(Connection conn,int id){
        try{
            String query= "DELETE from employee where empid = "+ id;
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Deleted");
        }catch (Exception e){
            System.out.println("Error : " + e);

        }

    }

    public void getData(Connection conn,String tableName){
        try{
            String query ="select * from "+tableName +" order by empid";
            Statement statement= conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("empid");
                String name = rs.getString("empname");                                              
                String address = rs.getString("empaddress");
                double salary = rs.getDouble("empsalary");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Address: " + address);
                System.out.println(", Salary: " + salary);
            }
            rs.close();
        }catch(Exception e){
            System.out.println(" ");
        }
    }
    public void insertData(Connection conn,String tablename,int empid,String empname, String empaddress,double empsalary){


        try{
            String query ="insert into "+tablename+" (empid,empname,empaddress,empsalary) " +
                    "values("+empid+","+"'"+empname+"'"+","+"'"+empaddress+"'"+","+empsalary+")";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("data inserted ");
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
