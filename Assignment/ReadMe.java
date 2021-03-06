package week5.day13;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String[][] readExcel(String filename) {
		// TODO Auto-generated method stub
		XSSFWorkbook wb =new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheetName = wb.getSheet("CreateIncident");
		int totalRowsCount=sheetName.getPhysicalNumberOfRows();
		System.out.println(totalRowsCount);
		int rowsCount=sheetName.getLastRowNum();
		System.out.println(rowsCount);
		int cellCount=sheetName.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		String[][] data=new String [rowsCount][cellCount];
		for(int i=1;i<=rowsCount;i++) {
		XSSFRow row = sheetName.getRow(i);
		for(int j=0;j<cellCount;j++) {
		XSSFCell cell = row.getCell(j);
		String stringCellValue = cell.getStringCellValue();
		data[i-1][j]=stringCellValue;
		}
	}
		wb.close();
		return data;
	}
}

}
