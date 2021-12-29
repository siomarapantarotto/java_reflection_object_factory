// Definition of core class Department
// Author: Siomara Pantarotto
// File : Department.java
// Date : June,8,2000

import java.util.*;
public class Department {

    private String rowId;       // RowId
    private int nbr;             // Department id number
    private String name;        // Department name
    private String code;        // Department code
    private double partyBudget; // Amount for parties

    /////////////////////////////////////////////////////////////////////////
    // Constructors
    //
    public Department() {
        setDepartment("", 0, "", "", 0 );
    }

    public Department(Vector v) {
        setDepartment( (String) v.elementAt(0),
                    Integer.parseInt((String) v.elementAt(1)),
                    (String) v.elementAt(2),
                    (String) v.elementAt(3),
                    Integer.parseInt((String) v.elementAt(4)));
    }

    public Department(String rowId, int nbr, String name, String code, double partyBudget) {
        setDepartment(rowId,
                    nbr,
                    name,
                    code,
                    partyBudget);
    }

    ////////////////////////////////////////////////////////////////////////
    // Set methods
    //
    public void setDepartment(String rowId, int nbr, String name, String code, double partyBudget) {
        setRowId(rowId);
        setNbr(nbr);
        setName(name);
        setCode(code);
        setPartyBudget(partyBudget);
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPartyBudget(double partyBudget) {
        this.partyBudget = partyBudget;
    }

    ///////////////////////////////////////////////////////////////////////
    // Get methods
    //
    public String getRowId() {
        return rowId;
    }

    public int getNbr()    {
        return nbr;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPartyBudget() {
        return partyBudget;
    }
}
