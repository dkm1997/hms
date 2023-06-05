package generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant 
{
	public static String getcellvalue(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		 String cellvalue=null;
		
		try {
			cellvalue=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception e) 
		{
			cellvalue=Integer.toString( (int) workbook.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue());
		
		}
			
		
		
		
	
		return cellvalue;
		
	}	
	
}