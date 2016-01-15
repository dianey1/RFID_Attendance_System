

package ReportGeneration;

import java.io.FileOutputStream;
 
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.*;
        
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;

/**
 * This class creates all .pdf documents for this software.
 * 
 * @author Sebastian Neba
 */

public class GeneratePDF {
 
     private FileOutputStream file ;
     private String filePath = "./test.pdf";
     private String tempDir = "./dist/";
    
     
  
            
    /**
     * Method creates a teacher's personal time table. If report is true, a dialog box which shows the
     * whether the PDF document was created is shown.
     * 
     * @param Name
     * @param outPutFile
     * @param report 
     */
    public GeneratePDF(List timeTableEntities,String Name, FileOutputStream outPutFile,boolean report){
                         
 
        try{
            
            Document document = new Document(PageSize.A4.rotate(),50,50,50,50);
            //Document document = new Document(); //Create PDF cocument                           
            PdfWriter writer = PdfWriter.getInstance(document,outPutFile);
                        
            document.open(); //Open the document for writting                    
     
            
            //Add UB's logo to the document
            Image img = Image.getInstance("./src/UB Logo.png");                        
            img.scaleToFit(250, 250);
            document.add(img);
        
            //Put some space between UB's logo and the time-table table
            document.add(new Paragraph(" "));            
            
            PdfPTable table = new PdfPTable(5); //Create a table with 7 columns. 6 the first column
            //is for labeling the day, and the rest are for displaying actual time table entries.
        
            table.setWidthPercentage(100);
        
            PdfPCell cell;            
      
            cell = new PdfPCell(new Paragraph("Time - Table of " + Name
                    ,FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0,0,255,255))));
            
            cell.setColspan(7);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);                            
            cell.setFixedHeight(45);
            table.addCell(cell);
        
            //Write the lecture periods as column headers on the table
            String lecturePeriods[] = {"7 - 9 AM ","9 - 11 AM","11 AM - 1 PM","1 - 3 PM","3 - 5 PM","5 - 7 PM",};
            cell.setColspan(1);
            cell = new PdfPCell( new Phrase(" "));             
            table.addCell(cell); 
        
            for(int z=0; z< 6; z++){
            cell = new PdfPCell( new Phrase(lecturePeriods[z]));  
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);                
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(30);
            table.addCell(cell); 
            }
            
            
            //Write the lecture days as cell leaders in the time table
            String teachingDays[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday",};
        
            for(int i = 0; i <6; i++){
                
            cell.setColspan(1);
            cell = new PdfPCell( new Phrase(teachingDays[i]));             
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);                
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(40);
            table.addCell(cell); 
        
            for(int j=0; j< 6; j++){
                            
            cell = new PdfPCell( new Phrase(" "));  
            
            table.addCell(cell);         
            }
            }
        
            
            //Add time table entries to the document            
            try{                        
//                            
//                while(!timeTableEntities.clear()){                        
//                    
//                    TimeTableEntry t = (TimeTableEntry)timeTableEntities.removeFromFront();
//                        
//                    //Get table cells belonging to a given. It seems as if tables
//                    //do not have the ability to reference a particular cell. =>
//                    //we have to get an array of all the cells in the row, and then access the
//                    //cell be referencing the array.
//                    PdfPCell dayCells[] = table.getRow(t.getDay() + 2).getCells();
//                    int j = t.getSlot() + 1;
//                    System.out.println(t.getDay() + " : " + t.getSlot() + " : " + t.getData());
//                    
//                    dayCells[j].addElement(new Phrase(t.getData(),FontFactory.getFont(FontFactory.HELVETICA, 9, Font.PLAIN, new CMYKColor(0,0,255,255))));
//                    dayCells[j].setHorizontalAlignment(Element.ALIGN_CENTER);                
//                    dayCells[j].setVerticalAlignment(Element.ALIGN_MIDDLE);
//                                            
//                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            
            
            document.add(table); //Add the table to the document                                  
            
            document.add(new Paragraph(" ")); //Put a space between the time-table and its creation date stamp
            
            document.add(new Paragraph("Time Table Generation System"));
            document.add(new Paragraph("University of Buea"));
             
            LocalDateTime x = LocalDateTime.now();                        
            
            
            document.add(new Paragraph(x.getHour() + " : " + x.getMinute() + " : " + x.getSecond() + "  " 
                    + x.getMonth() + " " + x.getDayOfMonth() + ", " + x.getYear() + "."));
            
            document.close();

            if(report == true)
            JOptionPane.showMessageDialog(null, "PDF created successfully");
        }catch(Exception e){
            e.printStackTrace();
        }        
            
    }
    
    
    public GeneratePDF(JPanel timeTablePanel, String useLess){
    
        try {
            
            
            file = new FileOutputStream(new File(filePath));
 
            Document document = new Document(PageSize.A4.rotate(),10,10,10,10);
            document.setMargins(30, 30, 30, 30);
            document.setMarginMirroringTopBottom(true);
            //Document document = new Document();
            //PdfWriter.getInstance(document, file);
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(filePath ));
                        
            document.open();                     
      
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(timeTablePanel.getWidth(), timeTablePanel.getHeight()-60);            
            

            Graphics2D g2 = template.createGraphics(timeTablePanel.getWidth(), timeTablePanel.getHeight() - 65);      
            //g2.translate(0, 2 );
            double scaleX = (document.getPageSize().getWidth() - 50)/ timeTablePanel.getWidth();
            double scaleY = (document.getPageSize().getHeight() - 75  ) / (timeTablePanel.getHeight());
            g2.scale(scaleX, scaleY);
           // g2.translate(document.getPageSize().getWidth(), document.getPageSize().getHeight());
            timeTablePanel.print(g2);
            g2.dispose();
                
           template.setHeight(550);
           cb.addTemplate(template,30, 24);
            
           for(int i=0; i < 28; i++)
            document.add(new Paragraph(" "));
            
            document.add(new Paragraph(" "
                    + ""
                    + "UB/Time Table generation system/",FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC, new CMYKColor(255,255,0,0))));
            
            
            document.addAuthor("nenar");
            document.close(); 
            file.close();
            
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(timeTablePanel, "Error creating PDF");
            e.printStackTrace();
        }
    }
    
        
    /**
     * Gets the personal time table file associated with this object
     * @return 
     */
    public File getFileLecturerTimeTableFile(){
        return new File(this.filePath);
    }
    
    /**
     * Deletes the personal time table associated wit this object.
     */
    public void deleteFile(){
        File f = new File(this.filePath);
        f.delete();
                }
}
