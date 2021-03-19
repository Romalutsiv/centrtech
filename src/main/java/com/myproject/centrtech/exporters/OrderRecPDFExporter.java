package com.myproject.centrtech.exporters;

import java.awt.Color;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.myproject.centrtech.enums.Defects;
import com.myproject.centrtech.model.Order;

public class OrderRecPDFExporter {

    private Order order;

    public OrderRecPDFExporter(Order order){
        this.order = order;
    }

    private void writeTableHeader(){}

    private void writeTableData(){}

    public void export(HttpServletResponse res) throws DocumentException, IOException{
        Document doc = new Document(PageSize.A4);

        PdfWriter.getInstance(doc, res.getOutputStream());
        Image png = Image.getInstance("C:/Users/user/Desktop/logo3.png");
        png.scalePercent(33);
        doc.open();
        doc.add(png);
        Font hex = new Font(Font.BOLDITALIC, 16);
        Phrase phrase1 = new Phrase("Акт приймання техніки та устаткування №" + order.getId() + " від: " +order.getDateCreate(), hex);
        Paragraph paragraph1 = new Paragraph(phrase1);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        doc.add(paragraph1);
        paragraph1 = new Paragraph("");
        doc.add(paragraph1);

        PdfPTable table = new PdfPTable(4);
        int[] headerwidths = {3, 11, 3, 11}; // percentage
        table.setWidths(headerwidths);
        table.setWidthPercentage(100); // percentage
        PdfPCell cell = new PdfPCell(new Paragraph("Дані замовника:"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table.addCell(cell);
        table.addCell("П.І.П");
        table.addCell(order.getClient().getFirstName() + " " + order.getClient().getLastName());
        table.addCell("Телефон");
        table.addCell(order.getClient().getPhoneNumber());
        table.addCell("Адреса");
        table.addCell(order.getClient().getAddres());
        table.addCell("Email");
        table.addCell(order.getClient().getMail());
        
        doc.add(table);

        PdfPTable table1 = new PdfPTable(4);
        float []headerwidths1 = {6.5f, 7.5f, 6.5f, 7.5f}; // percentage
        table1.setWidths(headerwidths1);
        table1.setWidthPercentage(100); // percentage
        cell = new PdfPCell(new Paragraph("Інформація про техніку"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table1.addCell(cell);

        table1.addCell("Тип виробу");
        table1.addCell(order.getDevice().getType());
        table1.addCell("Відколи");
        table1.addCell(isDefect(Defects.SPALLS, order.getDevice().getDefects()));

        table1.addCell("Марка");
        table1.addCell(order.getDevice().getName());
        table1.addCell("Тріщини");
        table1.addCell(isDefect(Defects.CRACKS, order.getDevice().getDefects()));

        table1.addCell("Модель");
        table1.addCell(order.getDevice().getModel());
        table1.addCell("Розломи");
        table1.addCell(isDefect(Defects.FAULT, order.getDevice().getDefects()));

        table1.addCell("Серійний номер");
        table1.addCell(order.getDevice().getSerialNumber());
        table1.addCell("подряпини корпусу");
        table1.addCell(isDefect(Defects.BODYSCATTERS, order.getDevice().getDefects()));

        table1.addCell("Пароль ОС/BIOS");
        table1.addCell(order.getDevice().getPassword());
        table1.addCell("Подряпини на екрані");
        table1.addCell(isDefect(Defects.SCREENCATTERS, order.getDevice().getDefects()));
        
        table1.addCell("Зарядний пристрій");
        table1.addCell(isDefect(Defects.CHARGER, order.getDevice().getDefects()));
        table1.addCell("Цілісність портів");
        table1.addCell(isDefect(Defects.INTEGRITYOFPORTS, order.getDevice().getDefects()));

        table1.addCell("Візуальні дефекти");
        table1.addCell(isDefect(Defects.VISUALDEFECTS, order.getDevice().getDefects()));
        table1.addCell("Сліди відкриття");
        table1.addCell(isDefect(Defects.OPENTRACES, order.getDevice().getDefects()));

        table1.addCell("Наявність АКБ");
        table1.addCell(isDefect(Defects.AVAILABLEBATTERY, order.getDevice().getDefects()));
        table1.addCell("Сліди залиття");
        table1.addCell(isDefect(Defects.FOLLOWINGTRACKS, order.getDevice().getDefects()));
        doc.add(table1);

        table1 = new PdfPTable(4);
        
        
        table1.setWidthPercentage(100); // percentage
        cell = new PdfPCell(new Paragraph("Замовлена несправність"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table1.addCell(cell);
        String s = order.getDevice().getText();
        System.out.print(s.length());
        if (s.length() > 140) s="_";

        cell = new PdfPCell(new Paragraph(s));
        cell.setRowspan(2);
        cell.setColspan(4);
        table1.addCell(cell);
        doc.add(table1);
        hex = new Font(Font.BOLDITALIC, 12);
        phrase1 = new Phrase("З Прейскурантом Виконавця Замовник ознайомлений до початку робіт. Сторони претензій одна до одної немає.", hex);
        doc.add(new Paragraph(phrase1));
        table = new PdfPTable(2);
        int[] headerwidths2 = {9, 5}; // percentage
        table.setWidths(headerwidths2);
        table.setWidthPercentage(100); 
        cell= new PdfPCell(new Paragraph("Обладнання передав, з умовами договору ознайомлений(а) та приймаю їх"));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph(" ________________  Замовник"));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("Обладання прийняв "));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("  ________________ Виконавець"));
        cell.setBorder(0);
        table.addCell(cell);
        doc.add(table);

        doc.add(png);
        hex = new Font(Font.BOLDITALIC, 16);
        phrase1 = new Phrase("Акт приймання техніки та устаткування №" + order.getId() + " від: " +order.getDateCreate(), hex);
        paragraph1 = new Paragraph(phrase1);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        doc.add(paragraph1);
        paragraph1 = new Paragraph("");
        doc.add(paragraph1);

        table = new PdfPTable(4);
        table.setWidths(headerwidths);
        table.setWidthPercentage(100); // percentage
        cell = new PdfPCell(new Paragraph("Дані замовника:"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table.addCell(cell);
        table.addCell("П.І.П");
        table.addCell(order.getClient().getFirstName() + " " + order.getClient().getLastName());
        table.addCell("Телефон");
        table.addCell(order.getClient().getPhoneNumber());
        table.addCell("Адреса");
        table.addCell(order.getClient().getAddres());
        table.addCell("Email");
        table.addCell(order.getClient().getMail());
        
        doc.add(table);

        table1 = new PdfPTable(4);
        table1.setWidths(headerwidths1);
        table1.setWidthPercentage(100); // percentage
        cell = new PdfPCell(new Paragraph("Інформація про техніку"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table1.addCell(cell);

        table1.addCell("Тип виробу");
        table1.addCell(order.getDevice().getType());
        table1.addCell("Відколи");
        table1.addCell(isDefect(Defects.SPALLS, order.getDevice().getDefects()));

        table1.addCell("Марка");
        table1.addCell(order.getDevice().getName());
        table1.addCell("Тріщини");
        table1.addCell(isDefect(Defects.CRACKS, order.getDevice().getDefects()));

        table1.addCell("Модель");
        table1.addCell(order.getDevice().getModel());
        table1.addCell("Розломи");
        table1.addCell(isDefect(Defects.FAULT, order.getDevice().getDefects()));

        table1.addCell("Серійний номер");
        table1.addCell(order.getDevice().getSerialNumber());
        table1.addCell("подряпини корпусу");
        table1.addCell(isDefect(Defects.BODYSCATTERS, order.getDevice().getDefects()));

        table1.addCell("Пароль ОС/BIOS");
        table1.addCell(order.getDevice().getPassword());
        table1.addCell("Подряпини на екрані");
        table1.addCell(isDefect(Defects.SCREENCATTERS, order.getDevice().getDefects()));
        
        table1.addCell("Зарядний пристрій");
        table1.addCell(isDefect(Defects.CHARGER, order.getDevice().getDefects()));
        table1.addCell("Цілісність портів");
        table1.addCell(isDefect(Defects.INTEGRITYOFPORTS, order.getDevice().getDefects()));

        table1.addCell("Візуальні дефекти");
        table1.addCell(isDefect(Defects.VISUALDEFECTS, order.getDevice().getDefects()));
        table1.addCell("Сліди відкриття");
        table1.addCell(isDefect(Defects.OPENTRACES, order.getDevice().getDefects()));

        table1.addCell("Наявність АКБ");
        table1.addCell(isDefect(Defects.AVAILABLEBATTERY, order.getDevice().getDefects()));
        table1.addCell("Сліди залиття");
        table1.addCell(isDefect(Defects.FOLLOWINGTRACKS, order.getDevice().getDefects()));
        doc.add(table1);

        table1 = new PdfPTable(4);
        
        
        table1.setWidthPercentage(100); // percentage
        cell = new PdfPCell(new Paragraph("Замовлена несправність"));
        cell.setBackgroundColor(new Color(189, 209, 255));
        cell.setBorderWidth(2);
        cell.setColspan(4);
        table1.addCell(cell);
        s = order.getDevice().getText();
        
        if (s.length() > 140) s="__________";

        cell = new PdfPCell(new Paragraph(s));
        cell.setRowspan(2);
        cell.setColspan(4);
        table1.addCell(cell);
        doc.add(table1);
        hex = new Font(Font.BOLDITALIC, 12);
        phrase1 = new Phrase("З Прейскурантом Виконавця Замовник ознайомлений до початку робіт. Сторони претензій одна до одної немає.", hex);
        doc.add(new Paragraph(phrase1));
        table = new PdfPTable(2);
        table.setWidths(headerwidths2);
        table.setWidthPercentage(100); 
        cell= new PdfPCell(new Paragraph("Обладнання передав, з умовами договору ознайомлений(а) та приймаю їх"));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph(" ________________  Замовник"));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("Обладання прийняв "));
        cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("  ________________ Виконавець"));
        cell.setBorder(0);
        table.addCell(cell);
        doc.add(table);

        doc.close();



    }

    private String isDefect(Defects defect, Set<Defects> def){
        String s = "-";
        for (Defects defects : def) {
            if (defect.equals(defects)){
                s = "+";
                break;
            }
        }
        return s;
    }
    
}
