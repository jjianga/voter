package org.jjianga.voter.util;

import com.github.liuhuagui.gridexcel.GridExcel;
import org.apache.commons.io.FileUtils;
import org.jjianga.voter.entity.AthleteInfo;

public class ExcelUtils {
    /**
     * 使用Streaming UserModel写出数据到Excel
     * @throws Exception
     */
    public void writeExcelByStreaming() throws Exception {
//        GridExcel.writeByStreaming(AthleteInfo.class)
//                .head(writeFunctionMap())//对象字段到Excel列的映射
//                .createSheet()
//                .process(MockData.data())//模拟数据。在这里设置业务数据集合。
//                .write(FileUtils.openOutputStream(new File("/excel/test.xlsx")));
    }
}
