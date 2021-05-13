
package hu.unideb.inf;

import Components.Alaplap;
import Components.Gephaz;
import Components.Memoria;
import Components.Processzor;
import Components.Videokartya;
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
    
    void  pdfGenrationGephaz(String fájlnév, ObservableList<Gephaz> data)
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
                
                table.addCell(actualGephaz.getName());
                table.addCell(actualGephaz.getFormfactor());
                table.addCell(actualGephaz.getVents());
                table.addCell(actualGephaz.getStorage());
                table.addCell(actualGephaz.getPrice());
            }
            
            
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a KékIbolya csapat!");           
            Paragraph alap=new Paragraph(alairas);          
            document.add(alap);
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
              
        }
        document.close();
    }
    
    void  pdfGenrationAlaplap(String fájlnév, ObservableList<Alaplap> data)
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
            float[] columnWidths= {2,2,2,2,1,1};
            PdfPTable table = new  PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Alaplap lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(6);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell("Név");
            table.addCell("Formatum");
            table.addCell("Foglalat");
            table.addCell("Memória foglalat");
            table.addCell("Memória száma");
            table.addCell("Ár");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Alaplap actualAlaplap=data.get(counter-1);
                
                table.addCell(actualAlaplap.getName());
                table.addCell(actualAlaplap.getFormfactor());
                table.addCell(actualAlaplap.getSocket());
                table.addCell(actualAlaplap.getMemoryslot());
                table.addCell(actualAlaplap.getAmountofmem());
                table.addCell(actualAlaplap.getPrice());
            }
            
            
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a KékIbolya csapat!");           
            Paragraph alap=new Paragraph(alairas);          
            document.add(alap);
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
              
        }
        document.close();
    }
    
    void  pdfGenrationMemoria(String fájlnév, ObservableList<Memoria> data)
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
            float[] columnWidths= {2,2,2,2,1,1,1};
            PdfPTable table = new  PdfPTable(columnWidths);
            table.setWidthPercentage(110);
            PdfPCell cell = new PdfPCell(new Phrase("Alaplap lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(7);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell("Név");
            table.addCell("Foglalat");
            table.addCell("Méret");
            table.addCell("Órajel");
            table.addCell("Időzítő");
            table.addCell("KIT");
            table.addCell("Ár");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Memoria actualMemoria=data.get(counter-1);
                
                table.addCell(actualMemoria.getName());
                table.addCell(actualMemoria.getSlot());
                table.addCell(actualMemoria.getSize());
                table.addCell(actualMemoria.getFrequency());
                table.addCell(actualMemoria.getTiming());
                table.addCell(actualMemoria.getAmount());
                table.addCell(actualMemoria.getPrice());
            }
            
            
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a KékIbolya csapat!");           
            Paragraph alap=new Paragraph(alairas);          
            document.add(alap);
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
              
        }
        document.close();
    }
    void  pdfGenrationProcesszor(String fájlnév, ObservableList<Processzor> data)
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
            float[] columnWidths= {2,2,2,2,1,1,1};
            PdfPTable table = new  PdfPTable(columnWidths);
            table.setWidthPercentage(110);
            PdfPCell cell = new PdfPCell(new Phrase("Alaplap lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(7);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell("Name");
            table.addCell("Socket");
            table.addCell("Cores");
            table.addCell("Threads");
            table.addCell("Frequency");
            table.addCell("MaxFrequency");
            table.addCell("Ár");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Processzor actualProcesszor=data.get(counter-1);
                
                table.addCell(actualProcesszor.getName());
                table.addCell(actualProcesszor.getSocket());
                table.addCell(actualProcesszor.getCores());
                table.addCell(actualProcesszor.getThreads());
                table.addCell(actualProcesszor.getFrequency());
                table.addCell(actualProcesszor.getMaxfrequency());
                table.addCell(actualProcesszor.getPrice());
            }
            
            
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a KékIbolya csapat!");           
            Paragraph alap=new Paragraph(alairas);          
            document.add(alap);
            
        }
        catch(Exception e)
        {
               e.printStackTrace();
              
        }
        document.close();
    }
    
    void  pdfGenrationVideokartya(String fájlnév, ObservableList<Videokartya> data)
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
            float[] columnWidths= {2,2,2,2,1,1,1};
            PdfPTable table = new  PdfPTable(columnWidths);
            table.setWidthPercentage(110);
            PdfPCell cell = new PdfPCell(new Phrase("Alaplap lista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(7);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            table.addCell("Manifacture");
            table.addCell("Name");
            table.addCell("Slot");
            table.addCell("Vram");
            table.addCell("Frequency");
            table.addCell("Length");
            table.addCell("Price");
            
            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for (int counter = 1 ; counter <= data.size(); counter++)
            {
                Videokartya actualVideokartya=data.get(counter-1);
                
                table.addCell(actualVideokartya.getManifacture());
                table.addCell(actualVideokartya.getName());
                table.addCell(actualVideokartya.getSlot());
                table.addCell(actualVideokartya.getVram());
                table.addCell(actualVideokartya.getFrequency());
                table.addCell(actualVideokartya.getLength());
                table.addCell(actualVideokartya.getPrice());
            }
            
            
            
            document.add(table);
            
            Chunk alairas = new Chunk("\n\n\n Sok szeretettel a KékIbolya csapat!");           
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
