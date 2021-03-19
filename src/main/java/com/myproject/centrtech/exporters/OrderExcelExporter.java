package com.myproject.centrtech.exporters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.myproject.centrtech.model.Order;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OrderExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private Order order;

    public OrderExcelExporter(Order order) throws IOException{
        this.order = order;


        
        workbook = new XSSFWorkbook();
        sheet = workbook.getSheetAt(3);

 

        // InputStream is = new FileInputStream("C:/Users/user/Desktop/logo3.png");
        // byte[] bytes = IOUtils.toByteArray(is);
        // int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        // is.close();

        // CreationHelper helper = workbook.getCreationHelper();
        // sheet = workbook.createSheet("Order");
        // Drawing drawing = sheet.createDrawingPatriarch();
        // ClientAnchor anchor = helper.createClientAnchor();
        // anchor.setCol1(0);
        // anchor.setRow1(0);
        // Picture pict = drawing.createPicture(anchor, pictureIdx);
        // pict.resize();
        
        // ClientAnchor anchor1 = helper.createClientAnchor();
        // anchor1.setCol1(0);
        // anchor1.setRow1(24);
        // Picture pict1 = drawing.createPicture(anchor1, pictureIdx);
        // pict1.resize();
        // sheet.addMergedRegion(new CellRangeAddress(4,4,2,6));
        // sheet.addMergedRegion(new CellRangeAddress(28,28,2,6));
    }

    private void writeHeaderRow(){
        
        // Row row = sheet.createRow(6);
        
        
        // CellStyle cellStyle = cell.getCellStyle();
        // cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // cell.setCellStyle(cellStyle);
        // cell.setCellValue("Акт приймання техніки та устаткування №"  + order.getId());

        // Row row2 = sheet.createRow(5);
        // Cell cell2 = row2.createCell(3);
       
        // String d = order.getDateCreate().getDayOfMonth() +"/"+ order.getDateCreate().getMonth().getValue() +"/"+  order.getDateCreate().getYear();
        // cell2.setCellValue("Від:         " + order.getDateCreate());
        



        // Row row1 = sheet.createRow(28);
        // Cell cell1 = row1.createCell(2);
        
        // cell1.setCellValue("Акт приймання техніки та устаткування №"  + order.getId());
        // CellStyle cellStyle1 = cell.getCellStyle();
        // cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        // cell1.setCellStyle(cellStyle1);

        // Row row3 = sheet.createRow(29);
        // Cell cell3 = row3.createCell(3);
        // cell3.setCellValue("Від:         " + order.getDateCreate());

        
    }

    private void writeDataRows(){}

    public void expotr(HttpServletResponse res) throws IOException{
        writeHeaderRow();
        writeDataRows();
        
        ServletOutputStream outputStream = res.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
}
