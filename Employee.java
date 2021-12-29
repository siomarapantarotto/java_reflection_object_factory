// Definition of core class Employee
// Author: Siomara Pantarotto
// File : Employee.java
// Date : July,3,2000

import java.util.*;

public class Employee {

    private String rowId;        // RowId
    private int id;               // Employee id number
    private String lastName;     // Employee last name
    private String firstName;    // Employee first name
    private String email;        // Employee email
    private double salary;       // Employee salary

    //////////////////////////////////////////////////////////////////////
    // Constructors
    //
    public Employee() {
        setEmployee("", 0, "", "", "", 0 );
    }

    public Employee(Vector v) {
        setEmployee( (String) v.elementAt(0),
                    Integer.parseInt((String) v.elementAt(1)),
                    (String) v.elementAt(2),
                    (String) v.elementAt(3),
                    (String) v.elementAt(4),
                    Integer.parseInt((String) v.elementAt(5)));
    }

    public Employee(String rowId, int id, String lastName, String firstName,
                    String email, double partyBudget) {
        setEmployee(rowId,
                    id,
                    lastName,
                    firstName,
                    email,
                    salary);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Set methods
    //
    public void setEmployee(String rowId, int id, String lastName, String firstName,
                            String email, double salary) {
        setRowId(rowId);
        setId(id);
        setLastName(lastName);
        setFirstName(firstName);
        setEmail(email);
        setSalary(salary);
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /////////////////////////////////////////////////////////////////////////
    // Get methods
    //
    public String getRowId() {
        return rowId;
    }

    public int getId()    {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}
