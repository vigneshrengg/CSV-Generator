package com.report.csv.writer;

/**
 *
 * @author VIGNESH R
 */
public class CSVParser implements CSVChar
{

    /**
     *
     * @param cellData
     * @return
     */
    public static String sanitizeCSV(String cellData)
    {
        if (cellData == null)
        {
            cellData = "";
        }
            
        cellData = cellData.trim();
        
        StringBuilder resultBuilder = new StringBuilder(cellData);

        int lastIndex = 0;

        while (resultBuilder.indexOf(QUOTE, lastIndex) >= 0)
        {
            int quoteInd = resultBuilder.indexOf(QUOTE, lastIndex);
            resultBuilder = replace(resultBuilder,quoteInd);
            lastIndex = quoteInd + 2;
        }
        
        char firstChar = cellData.charAt(0);
        char lastChar = cellData.charAt(lastIndex);
        
        if (cellData.contains(DELIMITER) || cellData.contains(NL)
                || Character.isWhitespace(firstChar) || Character.isWhitespace(lastChar)) 
        {
            resultBuilder.insert(0, QUOTE).append(QUOTE);
        }

        return resultBuilder.toString();
    }
    
    public static StringBuilder replace(StringBuilder resultBuilder,int quoteInd)
    {
        resultBuilder.replace(quoteInd, quoteInd + 1, "\"\"");
        
        return resultBuilder;            
    }

    /**
     *
     */
    public CSVParser()
    {
        
    }
}

