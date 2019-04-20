package utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ExcelReader(String excelPath)
	{
		File file=new File(excelPath);
		try {
			FileInputStream fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);					
			wb.close();
			}
		catch (Exception e) {
						e.printStackTrace();
		}
	}
	public String getData(int sheetNumber, int rowNo, int colNo)
	{
		sheet=wb.getSheetAt(sheetNumber);
		String testData=sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
		return testData;
	}
	public int getRowNo(int sheetNumber)
	{
		sheet=wb.getSheetAt(sheetNumber);
		int rows=sheet.getLastRowNum();
		return rows;
	}
}


