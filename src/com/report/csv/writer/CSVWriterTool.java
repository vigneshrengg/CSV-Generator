package com.report.csv.writer;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author VIGNESH R
 */
public interface CSVWriterTool
{
    public static final String STRING = "String";
    public static final String CHARACTER = "Character";
    public static final String INTEGER = "Integer";
    public static final String BYTE = "Byte";
    public static final String SHORT = "Short";
    public static final String LONG = "Long";
    public static final String DOUBLE = "Double";
    public static final String FLOAT = "Float";
    public static final String BOOLEAN = "Boolean";
    
    /**
     *
     * @param writer
     * @throws IOException
     */
    public abstract void write(Writer writer) throws IOException;
}
