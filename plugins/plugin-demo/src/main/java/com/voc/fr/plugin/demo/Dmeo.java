package com.voc.fr.plugin.demo;

import com.voc.fr.plugin.data.html.ITableMeta;
import com.voc.fr.plugin.data.html.ITablePhrase;
import com.voc.fr.plugin.data.html.core.DefaultHtmlTablePhrase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 10:10
 */
//@LocaleFinder
//@PluginInfo
public class Dmeo {


    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Project\\fine\\finesoft\\plugins\\plugin-demo\\src\\main\\resources\\test.html");

        ITablePhrase phrase = new DefaultHtmlTablePhrase();

        FileInputStream fileInputStream = new FileInputStream(file);
        Collection<ITableMeta> tableInfo = phrase.getTableInfo(fileInputStream);
        for (ITableMeta tableMeta : tableInfo) {
            StringBuilder sb = new StringBuilder();

            int fieldRow = 0;

            String[] fieldName = tableMeta.getFieldName(fieldRow);
            for (String value : fieldName) {
                sb.append(value).append("\t");
            }
            sb.append("\n\n");

            Object[][] data = tableMeta.getData(fieldRow);

            for (Object[] datum : data) {
                for (Object s : datum) {
                    sb.append(s).append("\t");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

}
