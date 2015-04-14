package com.report.csv.gen;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author VIGNESH R
 */
public class CSVGenerator
{
    private final Writer csvWriter;
    private char[] lineDelim = new char[]{'\n'};
    private String END_NL;

    private CSVHeader _header;
    private List<CSVRow> _listRows;
    private CSVRow _csvRow;

    private boolean closed;

    /**
     *
     * @param csvWriter
     */
    public CSVGenerator(Writer csvWriter)
    {
        this.END_NL = System.getProperty("line.seperator");
        closed = false;
        _listRows = new LinkedList<CSVRow>();        
        this.csvWriter = csvWriter;
    }

    /**
     *
     * @param csvWriter
     * @param lineDelim
     */
    public CSVGenerator(Writer csvWriter, char... lineDelim)
    {
        this(csvWriter);
        this.END_NL = System.getProperty("line.seperator");
        this.lineDelim = lineDelim;
    }

    /**
     *
     * @param columns
     * @throws CSVException
     */
    public void setHeader(String... columns) throws CSVException
    {
        if (closed)
        {
            throw new CSVException("cannot set header: CSVWriter is already closed");
        }
        else
        {
            _header = new CSVHeader(columns);
        }
    }

    /**
     *
     * @param index
     * @param value
     * @throws CSVException
     */
    public void set(int index, Object value) throws CSVException
    {
        if (_csvRow == null)
        {
            _csvRow = new CSVRow(_header);
            _listRows.add(_csvRow);
            closed = true;
        }

        _csvRow.set(index, value);
    }

    /**
     *
     * @param column
     * @param value
     * @throws CSVException
     */
    public void set(String column, Object value) throws CSVException
    {
        int index = _header.getColumnIndex(column);

        if (index < 0)
        {
            throw new CSVException("unknown column: " + column);
        }
        else
        {
            set(index, value);
        }
    }

    /**
     *
     */
    public void next()
    {
        if (_csvRow == null)
        {
            _csvRow = new CSVRow(_header);
            _listRows.add(_csvRow);
            closed = true;
        }
        _csvRow = new CSVRow(_header);
        _listRows.add(_csvRow);
    }

    /**
     *
     * @throws IOException
     */
    public void writeData() throws IOException
    {
        _header.toWriter(csvWriter);
        csvWriter.write(lineDelim);

        boolean firstRow = true;
        for (CSVRow row : _listRows)
        {
            if (firstRow)
            {
                firstRow = false;
            }
            else
            {
                csvWriter.write(lineDelim);
            }

            row.toWriter(csvWriter);
        }
    }

    /**
     *
     * @throws IOException
     */
    public void flush() throws IOException
    {
        csvWriter.flush();
    }
}
