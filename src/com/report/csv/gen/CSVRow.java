package com.report.csv.gen;

import com.report.csv.writer.CSVChar;
import com.report.csv.writer.CSVWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author VIGNESH R
 */
public class CSVRow implements CSVChar
{

    /**
     *
     */
    public CSVWriter _writer = null;
    private Object[] _data;
    private boolean[] isSet;
    
    CSVRow(CSVHeader header)
    {
        _data = new Object[header.getColumnCount()];
        isSet = new boolean[header.getColumnCount()];
    }

    /**
     *
     * @param index
     * @param value
     * @throws CSVException
     */
    public void set(int index, Object value) throws CSVException
    {
        if (index < 0 || index >= _data.length)
        {
            throw new CSVException("index out of range: " + index);
        }
        
        _data[index] = value;        
        isSet[index] = true;
    }

    /**
     *
     * @param csvWriter
     */
    public void toWriter(Writer csvWriter)
    {
        try
        {
            for (int i = 0; i < _data.length; i++)
            {
                if (i != 0)
                {
                    csvWriter.write(DELIMITER);
                }

                if (isSet[i])
                {
                    _writer = new CSVWriter(_data[i]);
                    _writer.write(csvWriter);
                }
            }
        }
        catch (IOException ex)
        {
            
        }
        catch(NullPointerException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
