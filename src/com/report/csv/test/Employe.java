package com.report.csv.test;

/**
 *
 * @author Vignesh R
 */
public class Employe {
    
    private int empId;
    private String empDOB;
    private String empName;
    private String empDesg;
    private double empSalary;
    
    /**
     *
     * @param empId
     * @param empName
     * @param empDOB
     * @param empDesg
     * @param empSalary
     */
    public Employe(int empId,String empName,String empDOB, String empDesg,double empSalary)
    {
        super();
        this.empId = empId;
        this.empDOB = empDOB;
        this.empName = empName;
        this.empDesg = empDesg;
        this.empSalary = empSalary;
    }
    
    /**
     *
     * @return
     */
    public int getempId(){return empId;}

    /**
     *
     * @return
     */
    public String getempDOB(){return empDOB;}

    /**
     *
     * @return
     */
    public String getempName(){return empName;}

    /**
     *
     * @return
     */
    public String getempDesg(){return empDesg;}

    /**
     *
     * @return
     */
    public double getempSalary(){return empSalary;}
    
    /**
     *
     * @param empId
     */
    public void setempId(int empId){this.empId = empId;}

    /**
     *
     * @param empDOB
     */
    public void setempDOB(String empDOB){this.empDOB = empDOB;}

    /**
     *
     * @param empName
     */
    public void setempName(String empName){this.empName = empName;}

    /**
     *
     * @param empDesg
     */
    public void setempDesg(String empDesg){this.empDesg = empDesg;}

    /**
     *
     * @param empSalary
     */
    public void setempSalary(double empSalary){this.empSalary = empSalary;}
    
}
