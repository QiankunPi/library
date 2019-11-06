package library;


import java.io.File;   

import jxl.*;   
import jxl.write.*;  
import jxl.write.biff.RowsExceededException;  

import java.sql.*;  
import java.util.*;  

import javax.swing.JOptionPane;
public class HistorycaigouExcel {
    
    /** 
     * 导出Excel表 
     * @param rs 数据库结果集 
     * @param filePath 要保存的路径，文件名为 fileName.xls 
     * @param sheetName 工作簿名称 工作簿名称，本方法目前只支持导出一个Excel工作簿 
     * @param columnName 列名，类型为Vector 
     */  
    public void WriteExcel(ResultSet rs, String filePath, String sheetName, Vector<String> columnName) {  
        WritableWorkbook workbook = null; 
        WritableSheet sheet = null;  
        
        int rowNum = 1; // 从第一行开始写入  
        try {
            workbook = Workbook.createWorkbook(new File(filePath)); //  创建Excel文件  ，文件默认保存在ch01工程下的文件中
            sheet = workbook.createSheet(sheetName, 0); // 创建名为 sheetName 的工作簿
            this.writeCol(sheet, columnName, 0); // 首先将列名写入 
            // 将结果集写入  
            while(rs.next()) {  
                Vector<String> col = new Vector<String>(); // 用以保存一行数据  
                  
                for(int i = 1; i <= columnName.size(); i++) { // 将一行内容保存在col中  
                    col.add(rs.getString(i));  
                }  
                // 写入Excel  
                this.writeCol(sheet, col, rowNum++);  
            }  
              
        }catch(Exception e) {  
            e.printStackTrace();  
        }  
        finally {  
            try {  
                // 关闭  
                workbook.write();  
                workbook.close();  
                rs.close();  
            }catch(Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    /*** 
     * 将数组写入工作簿  
     * @param sheet 要写入的工作簿 
     * @param col 要写入的数据数组 
     * @param rowNum 要写入哪一行 
     * @throws WriteException  
     * @throws RowsExceededException  
     */  
    private void writeCol(WritableSheet sheet, Vector<String> col, int rowNum) throws RowsExceededException, WriteException {  
        int size = col.size(); // 获取集合大小  
        for(int i = 0; i <size; i++) { // 写入每一列  
            Label label = new Label(i, rowNum,(String) col.get(i));   
            sheet.addCell(label);
        }  
    }  
/**
     * @param args
     * @throws Exception
     */
    public static void main(String []args) throws Exception {  
        String DRIVER = "com.mysql.jdbc.Driver"; 
        String URL = "jdbc:mysql://localhost:3306/table1";  
        String USERNAME = "root";  
        String USERPASSWORD = "password"; 
        String sql = "select * from t_purchasedetail"; // 查询语句  
        Vector<String> columnName = new Vector<String>(); // 列名   
        columnName.add("单号");  //excel中的每个段的名字
        columnName.add("ISBN号");  
        columnName.add("采购数量");  
        columnName.add("进价");  
        columnName.add("采购金额");  
        columnName.add("采购日期");  
        columnName.add("供货编号"); 
        columnName.add("经办人");
        columnName.add("库号");
        columnName.add("货架");
          
        // 连接数据库  
        Class.forName(DRIVER);  
        Connection conn = DriverManager.getConnection(URL,USERNAME,USERPASSWORD);  
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
          
        // 导出文件  
        new HistorysaleExcel().WriteExcel(rs, "历史采购信息表.xls", "历史采购信息", columnName);    
    } 
}
