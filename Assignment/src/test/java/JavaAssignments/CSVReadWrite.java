package JavaAssignments;

import com.github.javafaker.Faker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

public class CSVReadWrite {

	static String outputFile = null;

	public static void main(String hp[]) {

//		writeCSV();
		parseCSV();

	}

	public static void parseCSV() {
		outputFile = System.getProperty("user.dir") + "\\CSVFiles\\Record101644529002261.csv";

		try {
			CsvReader cvsReader = new CsvReader(new FileReader(outputFile), ',');
			int i = 0;
			while (cvsReader.readRecord()) {
				List<String> stringList = new ArrayList<String>();
				int average = 0;
				if (i != 0) {
//					break;
					String[] rows = cvsReader.getValues();
					int colCount = 0;
					for (String col : rows) {
//						if (colCount >= 3) {
//							average = average+Integer.valueOf(col);
//							System.out.println(col);
							stringList.add(String.valueOf(col));
//						}
						colCount++;
					}
					System.out.println("Total Column is : " +colCount);
					System.out.println("Average is : " +average);
					stringList.add(String.valueOf(300/5));
//					writeAverage(colCount,average);
					writeCSVav(stringList);
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void writeCSVav(List<String> stringList) {
//		Faker faker = new Faker();
//		String filename = "Record";
//		Date date = new Date();
//		filename += date.getDate();
//		filename += date.getTime();
//		int min = 10;
//		int max = 100;
//		outputFile = System.getProperty("user.dir") + "\\CSVFiles\\" + filename + ".csv";

		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

			for(int i=0;i<stringList.size();i++) {
			
			csvOutput.write(String.valueOf(stringList.get(i)));
//			csvOutput.write("First Name");
//			csvOutput.write("Last Name");
//			csvOutput.write("Subject1");
//			csvOutput.write("Subject2");
//			csvOutput.write("Subject3");
//			csvOutput.write("Subject4");
//			csvOutput.write("Subject5");
//			csvOutput.write("Average");
			csvOutput.endRecord();
			
			}

//			for (int i = 1; i <= 5; i++) {
//				String t = String.valueOf(Math.random() * (max - min + 1) + min);
//				csvOutput.write("" + i);
//				csvOutput.write(faker.name().firstName());
//				csvOutput.write(faker.name().lastName());
//				csvOutput.write(String.valueOf(getRandomNumber()));
//				csvOutput.write(String.valueOf(getRandomNumber()));
//				csvOutput.write(String.valueOf(getRandomNumber()));
//				csvOutput.write(String.valueOf(getRandomNumber()));
//				csvOutput.write(String.valueOf(getRandomNumber()));
//				csvOutput.write(String.valueOf(average));
//				csvOutput.endRecord();
//			}
			csvOutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
		
//	}

	private static void writeAverage(int colCount, int average) {

		colCount = colCount+1;
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
//			csvOutput.com.csvreader.CsvWriter
//			
//			
//			csvOutput.writeNext(String.valueOf(average));
	        
			csvOutput.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void writeCSV() {

		Faker faker = new Faker();
		String filename = "Record";
		Date date = new Date();
		filename += date.getDate();
		filename += date.getTime();
		int min = 10;
		int max = 100;
		outputFile = System.getProperty("user.dir") + "\\CSVFiles\\" + filename + ".csv";

		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

			csvOutput.write("S NO");
			csvOutput.write("First Name");
			csvOutput.write("Last Name");
			csvOutput.write("Subject1");
			csvOutput.write("Subject2");
			csvOutput.write("Subject3");
			csvOutput.write("Subject4");
			csvOutput.write("Subject5");
			csvOutput.endRecord();

			for (int i = 1; i <= 5; i++) {
				String t = String.valueOf(Math.random() * (max - min + 1) + min);
				csvOutput.write("" + i);
				csvOutput.write(faker.name().firstName());
				csvOutput.write(faker.name().lastName());
				csvOutput.write(String.valueOf(getRandomNumber()));
				csvOutput.write(String.valueOf(getRandomNumber()));
				csvOutput.write(String.valueOf(getRandomNumber()));
				csvOutput.write(String.valueOf(getRandomNumber()));
				csvOutput.write(String.valueOf(getRandomNumber()));
				csvOutput.endRecord();
			}
			csvOutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int getRandomNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		int result = r.nextInt(high - low) + low;
		return result;
	}

	public static CsvWriter AddRow(Vector objResultVector, CsvWriter csvOutput)
			throws SQLException, DocumentException, IOException {

		for (int i = 0; i < objResultVector.size(); i++) {
			Vector innerVector = new Vector();
			innerVector = (Vector) objResultVector.elementAt(i);
			for (int j = 0; j < innerVector.size(); j++) {
				csvOutput.write((String) innerVector.elementAt(j));
			}
			csvOutput.endRecord();
		}
		return csvOutput;
	}
}
