package com.zmm.commonutils.utils;

import com.zmm.commonutils.exception.BaseRuntimeException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/11/18
 **/
public class ExcelUtil {

    /**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param excelData Excel表格的数据，封装为List<List<String>>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<String> tableHead,
                                   List<List<Object>> excelData,
                                   String sheetName,
                                   String fileName) throws IOException {
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 设置样式
        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        style1.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        style1.setBorderTop(BorderStyle.THIN);
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setBorderRight(BorderStyle.THIN);
        style1.setWrapText(true);
        /**设置单元格格式为文本格式*/
        HSSFDataFormat format = workbook.createDataFormat();
        style1.setDataFormat(format.getFormat("@"));

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //存储最大列宽
        Map<Integer,Integer> maxWidth = new HashMap<Integer,Integer>();
        //设置表head
        HSSFRow row1 = sheet.createRow(0);
        for (int i = 0; i < tableHead.size(); i++) {
            Cell createCell = row1.createCell(i);
            createCell.setCellValue(tableHead.get(i));
            createCell.setCellStyle(style1);
            maxWidth.put(i,createCell.getStringCellValue().getBytes().length  * 256 + 200);
        }
        //设置表格默认列宽度
//        sheet.setDefaultColumnWidth(columnWidth);
        //写入List<List<String>>中的数据
        int rowIndex = 1;
        for(List<Object> data : excelData){
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);
            //遍历添加本行数据
            for (int i = 0; i < data.size(); i++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(i);
                //将单元格格式设置成文本格式
                cell.setCellType(CellType.STRING);
                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i).toString());
                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
                int length = cell.getStringCellValue().getBytes().length  * 256 + 200;
                //这里把宽度最大限制到10000
                if (length>10000){
                    length = 10000;
                }
                maxWidth.put(i,Math.max(length,maxWidth.get(i)));
                cell.setCellStyle(style1);
            }
        }
        // 必须在单元格设值以后进行
        // 列宽自适应
        for (int i = 0; i < tableHead.size(); i++) {
            sheet.setColumnWidth(i,maxWidth.get(i));
//            sheet.autoSizeColumn(k);//另一种写法
        }
        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");
        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName +".xls");
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());
        //关闭workbook
        workbook.close();
    }

    public static List<List<String>> uploadExcel(MultipartFile file, HttpServletRequest request){
        if (file.isEmpty()) {
            throw new BaseRuntimeException("400","文件为空！");
        }
        List<List<String>> excelData = null;
        try {
            HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row = null;
            excelData = new ArrayList<List<String>>();
            //循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                List<String> data = new ArrayList<String>();
                row = sheet.getRow(i);
                for (int j = 0; j <row.getPhysicalNumberOfCells() ; j++) {
                    HSSFCell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    data.add(cell.getStringCellValue());
                }
                excelData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }

}
