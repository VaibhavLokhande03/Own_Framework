package pom.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exel_Data_Provider {

	XSSFWorkbook wb;
public Exel_Data_Provider() throws Exception {
	String path="C:\\Users\\HP\\eclipse-workspace\\Own_Framework\\Test_Data\\Data.xlsx";
	FileInputStream file=new FileInputStream(path);
	wb=new XSSFWorkbook(file);
}

public String getStringData(String Sheetname,int row,int cell) {
	return wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
}
}
