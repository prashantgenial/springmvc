package test;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateDocument {

   public static void main(String[] args)throws Exception  {
   
      //Blank Document
      XWPFDocument document = new XWPFDocument(); 
		
      //Write the Document in file system
      FileOutputStream out = new FileOutputStream( new File("createdocument.docx"));
      
      //create Paragraph
      XWPFParagraph paragraph = document.createParagraph();
      XWPFRun run = paragraph.createRun();
      run.setText("At tutorialspoint.com, we strive hard to " +
         "provide quality tutorials for self-learning " +
         "purpose in the domains of Academics, Information " +
         "Technology, Management and Computer Programming Languages.");
      
      //create table
      XWPFTable table = document.createTable();
		
      //create first row
      XWPFTableRow tableRowOne = table.getRow(0);
      tableRowOne.getCell(0).setText("col one, row one");
      tableRowOne.addNewTableCell().setText("col two, row one");
      tableRowOne.addNewTableCell().setText("col three, row one");
		
      //create second row
      XWPFTableRow tableRowTwo = table.createRow();
      tableRowTwo.getCell(0).setText("col one, row two");
      tableRowTwo.getCell(1).setText("col two, row two");
      tableRowTwo.getCell(2).setText("col three, row two");
		
      //create third row
      XWPFTableRow tableRowThree = table.createRow();
      tableRowThree.getCell(0).setText("col one, row three");
      tableRowThree.getCell(1).setText("col two, row three");
      tableRowThree.getCell(2).setText("col three, row three");
      
      document.write(out);
      out.close();
      System.out.println("createdocument.docx written successully");
   }
}