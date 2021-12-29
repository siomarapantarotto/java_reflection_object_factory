// Definition of a reusable, generic Manager class that will take
// a table name and a Java class and generate a new instance of the
// passed Java class based on the table structure.
// Author: Siomara Pantarotto
// File : Manager.java
// Date : June,30,2000

import java.sql.*;
import java.util.*;
import java.lang.reflect.*;

public class Manager {

    private String tableName;
    private String className;
    private Connection con;
   

    /////////////////////////////////////////////////////////////////////////
    // Constructor of class Manager
    //
    public Manager(Connection con, String tableName, String className ) {
        setConnection(con);
        setTableName(tableName);
        setClassName(className);
    }

    //////////////////////////////////////////////////////////////////////////
    // Set methods
    //
    public void setConnection(Connection con)  { this.con = con;     }   
    public void setTableName(String tableName) { this.tableName = tableName; }   
    public void setClassName(String className) { this.className = className; }

    /////////////////////////////////////////////////////////////////////////
    // Get methods
    //
    public String getTableName() {         return tableName;    }    
    public String getClassName() {         return className;    }

    ///////////////////////////////////////////////////////////////////////
    // Query a DB table using metadata to get all the column names and build
    // a SELECT statement to select a unique row that matches a where clause
    // passed as parameter. If the row is found, this method generates a vector
    // with the desired values and call a methodthat intantiates an object.
    // If the row is not found this method invokes the method that uses no
    // argument and generates an object with default values.
    //
    public Object query(String whereClause) {
        Object aObject = null;
        Vector aVector = new Vector();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM " + getTableName() + " WHERE Rowid = ''"); // Rowid = '' avoids retriving all rows
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String selectClause = "ROWID";
            for (int col = 1; col <= columnCount; col++) {
                selectClause = selectClause + ", " + rsmd.getColumnLabel(col);
            }
            selectClause = "SELECT " + selectClause + " FROM " + getTableName();
            if (whereClause != "") {
                selectClause = selectClause + " WHERE " + whereClause;
            }
            rs = con.createStatement().executeQuery(selectClause);
            if (rs.next()) {
            // Generates a vector with all the values retrieve from the DB
            // table row and call method that creates an object using
            // constructor that have arguments
                aVector.removeAllElements();
                for (int col = 1; col <= columnCount + 1; col++) {
                    aVector.addElement(rs.getString(col));
                }                 Class[] vecArgsClass = new Class[] {Vector.class};                 Object[] vecArgsObject = new Object[] {aVector};                 Constructor vecArgsConstructor;                 Class classDefinition = Class.forName(getClassName());                 vecArgsConstructor = classDefinition.getConstructor(vecArgsClass);                 aObject = createObject(vecArgsConstructor, vecArgsObject);
            }
            else {                 // Call method that creates an object using NO-argument constructors                  // since no row matches the where clause that was passed as parameter
                aObject = createObject(getClassName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }         return aObject;
    }

    //////////////////////////////////////////////////////////////////////////
    // Create an Object Using No-Argument Constructors
    //
    public Object createObject(String className) {         System.out.println ("\nThe constructor used is : " + getClassName() + "()");
        Object aObject = null;
        try {
            Class classDefinition = Class.forName(getClassName());
            aObject = classDefinition.newInstance();
            System.out.println ("The object created is: " + aObject.toString());
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
        System.out.println(e);
        } catch (ClassNotFoundException e) {
        System.out.println(e);
        }
        return aObject;
    }

    ////////////////////////////////////////////////////////////////////////
    // Create an Object Using Constructors that Have Arguments
    //
    public Object createObject(Constructor constructor, Object[] arguments) {
        System.out.println ("\nThe constructor used is : " + constructor.toString());
        Object aObject = null;
        try {
            aObject = constructor.newInstance(arguments);
            System.out.println ("The object created is: " + aObject.toString());
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
        return aObject;
    }
}
