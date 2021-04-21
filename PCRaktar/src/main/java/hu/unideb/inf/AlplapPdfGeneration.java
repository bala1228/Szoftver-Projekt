/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

/**
 *
 * @author Felhasználó(user)
 */
public class AlplapPdfGeneration {
    
    void  AlaplappdfGenration(String fájlnév, ObservableList<Alaplap> data)
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
            PdfPCell cell = new PdfPCell(new Phrase("Alaplap lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(5);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Név");
            table.addCell("Formatum");
            table.addCell("Processzor Fog");
            table.addCell("Memoria Fog");
            table.addCell("Ár");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Alaplap actualAlaplap=data.get(counter-1);
                
                table.addCell(actualAlaplap.getNev());
                table.addCell(actualAlaplap.getFomatum());
                table.addCell(actualAlaplap.getProceszorFog());
                table.addCell(actualAlaplap.getMemoriaFog());
                table.addCell(actualAlaplap.getAr());
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
