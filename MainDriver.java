// Driver to test the Manager class
// Author: Siomara Pantarotto
// File : ManDriver.java
// Date : June,30,2000
import java.sql.*;
public class MainDriver {

    ///////////////////////////////////////////////////////////////////////////////
    // Main - Principal entry
    //
    public static void main( String args[] )
    {        Connection con = new DBConnection().getConnection();       
        Manager mgr1 = new Manager(con, "DEPTS", "Department" );

        System.out.println("\n-------------------------------------------------------------");
        Department d1 = (Department) mgr1.query("nbr = 1");
        System.out.println("\nRowId : " + d1.getRowId());
        System.out.println("Nbr : " + d1.getNbr());
        System.out.println("Name : " + d1.getName());
        System.out.println("Code : " + d1.getCode());
        System.out.println("Party Budget: " + d1.getPartyBudget());

        System.out.println("\n-------------------------------------------------------------");
        Department d2 = (Department) mgr1.query("nbr = 999");
        System.out.println("\nRowId : " + d2.getRowId());
        System.out.println("Nbr : " + d2.getNbr());
        System.out.println("Name : " + d2.getName());
        System.out.println("Code : " + d2.getCode());
        System.out.println("Party Budget: " + d2.getPartyBudget());

        Manager mgr2 = new Manager(con, "EMPLOYEE", "Employee" );

        System.out.println("\n-------------------------------------------------------------");
        Employee e1 = (Employee) mgr2.query("id = 1");
        System.out.println("\nRowId : " + e1.getRowId());
        System.out.println("Id Number : " + e1.getId());
        System.out.println("Last Name : " + e1.getLastName());
        System.out.println("First Name : " + e1.getFirstName());
        System.out.println("Email : " + e1.getEmail());
        System.out.println("Salary/hour : " + e1.getSalary());

        System.out.println("\n-------------------------------------------------------------");
        Employee e2 = (Employee) mgr2.query("id = 999");
        System.out.println("\nRowId : " + e2.getRowId());
        System.out.println("Id Number : " + e2.getId());
        System.out.println("Last Name : " + e2.getLastName());
        System.out.println("First Name : " + e2.getFirstName());
        System.out.println("Email : " + e2.getEmail());
        System.out.println("Salary/hour : " + e2.getSalary());
    }

}
