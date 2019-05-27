package com.corre.du.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcel {

    private static String[][] cases;

    public static Object[][] readCases(String filePath) throws IOException,BiffException{
        InputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = Workbook.getWorkbook(inputStream);

        Sheet sheet = workbook.getSheet(0);
        int rsRows = sheet.getRows();//获取总行数
        int rsColums = sheet.getColumns();//获取总列数
        
        int countY = 0;
        for(int i = 0; i < rsRows; i++){
            if (sheet.getCell(3,i).getContents().equals("Y"))
                countY++;
        }
        
        int x = 0;
        for (int i = 1; i < rsRows ; i++){
            if (sheet.getCell(3,i).getContents().equals("Y")){{
                for (int j = 0 ; j< rsColums; j++){
                    cases[x][j] = sheet.getCell(j,i).getContents();
                }
                x++;
            }}
        }
        return cases;
    }
}
