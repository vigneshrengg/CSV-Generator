package com.report.csv.gen;

import com.report.csv.writer.CSVChar;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author VIGNESH R
 */
public class CSVHeader implements CSVChar
{

    private List<String> columns;
    private HashMap<String, Integer> columnIndexes;

    /**
    * Constructor
    * Initialize the LinkedList and HashMap.
    */
    public CSVHeader()
    {
        columns = new LinkedList<String>();
        columnIndexes = new HashMap<String, Integer>();
    }

    /**
     * Constructor
     * 
     * @param columns  
     */
    public CSVHeader(String... columns)
    {
        this();
        for (int i = 0; i < columns.length; i++)
        {
            this.columns.add(columns[i]);
            columnIndexes.put(columns[i], i);
        }
    }

    /**
     * Column Index
     * 
     * @param column
     * @return Current specified column index.
     */
    public int getColumnIndex(String column)
    {
        Integer index = columnIndexes.get(column);
        if (index != null)
        {
            return index;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Column Count
     * 
     * @return columns size.
     */
    public int getColumnCount()
    {
        return columns.size();
    }

    /**
     * Perform a write function using Writer.
     * @param writer
     */
    public void toWriter(Writer writer)
    {
        try
        {
            boolean firstRow = true;

            for (String column : columns)
            {
                if (firstRow)
                {
                    firstRow = false;
                }
                else
                {
                    writer.write(DELIMITER);
                }

                writer.write(QUOTE);
                writer.write(column);
                writer.write(QUOTE);
            }
        }
        catch (IOException ex)
        {
            try
            {
                throw new CSVException("Error writing Header" + ex.getMessage());
            }
            catch (CSVException e)
            {

            }
        }
    }
}
