package Adapter_JDBC;

import java.sql.Connection;

class JDBCMain {
    public static void main(String[] args) {
        DBMSfunctions dbmsFunctions =new DBMSfunctions();
        String dbUrl ="jdbc:postgresql://localhost:5432/employee";
        String dbUser ="postgres";
        String dbPass ="rcoem";

        Connection conn =dbmsFunctions.connect_to_database(dbUrl,dbUser,dbPass);
 //       dbmsFunctions.createTable(conn, "lemployee");
//        dbmsFunctions.deleteEmployee(conn,1);
  //      dbmsFunctions.insertData(conn,"employee",10,"Vickey","Chandrapur",4526.22);
        dbmsFunctions.getData(conn,"employee");
        try{
        conn.close();
            System.out.println("Connection closed");
        }catch(Exception e){
            System.out.println(" ");
        }
    }
}