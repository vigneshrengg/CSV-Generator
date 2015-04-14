package com.report.csv.gen;

/**
 *
 * @author VIGNESH R
 */
public class CSVException extends Exception
{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public CSVException() 
    {

    }

    /**
     *
     * @param message
     */
    public CSVException(String message) 
    {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public CSVException(Throwable cause) 
    {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public CSVException(String message, Throwable cause) 
    {
        super(message, cause);
    }

}
