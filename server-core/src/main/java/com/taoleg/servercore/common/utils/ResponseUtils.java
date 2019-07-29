package com.taoleg.servercore.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Response Utils
 */
public class ResponseUtils {

    public static void writeJson(HttpServletResponse response, Object bean) {

        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            writer = response.getWriter();
            if(bean instanceof String){
                writer.print(bean);
            }else{
                writer.print(JSON.toJSONString(bean));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    public static void writeExcel(HttpServletResponse response, String excelName, HSSFWorkbook workbook) {
        OutputStream outputStream = null;

        response.setHeader("Content-Disposition", "attachment; filename=\"" + excelName + "\"");
        try{
            response.setContentType("application/msexcel");
            response.setHeader("Content-Disposition", "attachment;fileName="+
                    new String(excelName+".xls"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        }catch(IOException ioException){
        }finally {
            if(outputStream != null){
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
