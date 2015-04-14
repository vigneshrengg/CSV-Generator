package com.report.csv.test;

import com.report.csv.gen.CSVException;
import com.report.csv.gen.CSVGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prasanth R
 */
public class CSVTest
{
    /**
     *
     * @param args
     * @throws IOException
     */
                
    public static void main(String[] args) throws IOException
    {
        File csvFile = new File("C:\\Users\\Prasanth R\\Desktop\\REPORT_CSV_GENERATOR2.csv");
        
        FileWriter writer = new FileWriter(csvFile);
        CSVGenerator csv = new CSVGenerator(writer);
        
        
        try
        {
            String usingFlow = "checkDatatype";

            String[] header = {"EMP_ID", "EMP_NAME", "EMP_DOB", "EMP_DESG", "EMP_SALARY"};
            String[] datatypeHeader = {"STRING", "INTEGER", "CHAR", "BYTE", "SHORT", "LONG", "DOUBLE", "FLOAT", "BOOLEAN","URL"};

            String[] _1 = {"1", "2", "3", "4", "5", "6"};
            String[] _2 = {"Franklin", "Bruce", "Jhon", "Wilson", "Mansion", "Kelli"};
            String[] _3 = {"1992-09-09", "1991-08-23", "", "1989-08-16", "", "1977-09-12"};
            String[] _4 = {"Software Engineer", "CEO", "Manager", "Admin", "Sweeper", "Senior"};
            String[] _5 = {"2000", "2000", "2000", "2000", "2000", "3000"};

            Employe _1emp = new Employe(123, "Raja", "1991-09-16", "Software Developer", 12000);
            Employe _2emp = new Employe(124, "Mani", "1989-07-18", "Human Resource", 11000);                        
            Employe _3emp = new Employe(125, "Chola", "1992-08-05", "Manager", 20000);
            Employe _4emp = new Employe(126, "Pandi", "1991-09-09", "CEO", 20000);
            Employe _5emp = new Employe(127, "Chakara", "1985-03-14", "Administrator", 1000);
            Employe _6emp = new Employe(129, "Arokya", "2001-09-09","IT Manager",9000);

            List<Employe> employ = new ArrayList<>();

            employ.add(_1emp);
            employ.add(_2emp);
            employ.add(_3emp);
            employ.add(_4emp);
            employ.add(_5emp);
            employ.add(_6emp);

            String[] STRING = {"\t'random \" doublequote'\t", "     comma,separated", "Two\n" + "lines", "_leading space, and a comma", "\"leading quote, comma", null};
            int[] INT = {1, 432, 34214, 4532, 21, 23};
            char[] CHAR = {'@', '\n', '\r', '\0', '\\', '\r'};
            byte[] BYTE = {0, 021, 12, 23, 12, 23};
            short[] SHORT = {12, 23, 354, 56, 2, 23};
            long[] LONG = {233, 34234, 234, 2434, 123, 238742374983209438L};
            double[] DOUBLE = {12d, 12.12d, 12.2387862736712d, 123.21, 0.2323712632653612d, 23.2983d};
            float[] FLOAT = {12.3f, 56.9f, 345.878756534536753f, 23, 56.78f, 89.892f};
            boolean[] BOOL = {true, false, true, false, true, true};
            String[] URL = {"http:\\www.google.com\\"  ,"http:\\localhost:8080\\","http:\\localhost:8080\\","http:\\localhost:8080\\","http:\\localhost:8080\\","http:\\localhost:8080\\"};
            String[] DATE = {"2014/12/12","1991/09/16","2006/04/10","2009/06/10","2012/05/03","2015/12/12"};
            
            switch (usingFlow)
            {
                case "List":
                    csv.setHeader(header);
                    for (Employe _employ : employ)
                    {
                        csv.set("EMP_ID", _employ.getempId());
                        csv.set("EMP_NAME", _employ.getempName());
                        csv.set("EMP_DOB", _employ.getempDOB());
                        csv.set("EMP_DESG", _employ.getempDesg());
                        csv.set("EMP_SALARY", _employ.getempSalary());
                        csv.next();
                    }
                    break;
                case "Array":
                    csv.setHeader(header);
                    for (int i = 0; i < _1.length; i++)
                    {
                        csv.set(0, _1[i]);
                        csv.set(1, _2[i]);
                        csv.set(2, _3[i]);
                        csv.set(3, _4[i]);
                        csv.set(4, _5[i]);
                        csv.next();
                    }
                    break;
                case "checkDatatype":
                    csv.setHeader(datatypeHeader);
                    for (int i = 0; i < STRING.length; i++)
                    {
                        csv.set(0, STRING[i]);
                        csv.set(1, INT[i]);
                        //csv.set(2, CHAR[i]);
                        //csv.set(3, BYTE[i]);
                        csv.set(4, SHORT[i]);
                        csv.set(5, LONG[i]);
                        csv.set(6, DOUBLE[i]);
                        csv.set(7, FLOAT[i]);
                        csv.set(7, _1[i]);
                        csv.set(9, URL[i]);
                        csv.set(8, BOOL[i]);
                        csv.next();
                    }
                    break;
            }

            csv.writeData();
        }
        catch (CSVException ex)
        {
        }
        finally
        {
            csv.flush();
        }
    }
}
