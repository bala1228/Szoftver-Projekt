
package hu.unideb.inf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;






public class PdfGeneration {
    
    void  pdfGenration(String fájlnév, ObservableList<Gephaz> data)
    {
        Document document = new Document();
        
        try
        {
            PdfWriter.getInstance(document,new FileOutputStream(fájlnév +".pdf"));
            document.open();
       //     Image image1= Image.getInstance(getClass().getResource("C:\\Users\\Felhasználó(user)\\OneDrive\\Asztali gép\\SFM_JavaApp\\Szoftver-Projekt\\PCRaktar\\src\\main\\java/raketa.png"));
       //     image1.scaleToFit(200,86);
       //     image1.setAbsolutePosition(200f, 750f);
       //     document.add(image1);
            
            // Táblázat
            float[] columnWidths= {2,2,2,2,2};
            PdfPTable table = new  PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Gépház lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(5);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Név");
            table.addCell("Alaplaptipus");
            table.addCell("Be. Ventillator");
            table.addCell("Ssd hely");
            table.addCell("Ár");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Gephaz actualGephaz=data.get(counter-1);
                
                table.addCell(actualGephaz.getNev());
                table.addCell(actualGephaz.getAlaplaptipus());
                table.addCell(actualGephaz.getBeepitetVentilatorokSzama());
                table.addCell(actualGephaz.getSsdhely());
                table.addCell(actualGephaz.getAr());
            }
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a mikúlástól");           
            Paragraph alap=new Paragraph(alairas);          
            document.add(alap);
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
              
        }
        document.close();
    }
    
}