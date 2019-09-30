//package com.voc.fr.plugin.api;
//
//import com.voc.fr.plugin.data.html.IRowMeta;
//
//import java.util.Collection;
//
///**
// * 解析生成最终二维表信息
// *
// * @author Wu Yujie
// * @email coffee377@dingtalk.com
// * @time 2019/09/04 22:00
// */
//public interface ITableMeta {
//
//    /**
//     * 表格名称
//     *
//     * @return String
//     */
//    String getName();
//
//    /**
//     * 数据行信息
//     *
//     * @return Collection<IRowMeta>
//     */
//    Collection<IRowMeta> getRowMeta();
//
//    /**
//     * 行数（合并单元格拆分后）
//     *
//     * @return int
//     */
//    int getRowCount();
//
//    /**
//     * 列数（合并单元格拆分后）
//     *
//     * @return int
//     */
//    int getColumnCount();
//
//    /**
//     * 解析后原始数据（含字段名）
//     *
//     * @return String[][]
//     */
//    Object[][] rawData();
//
//    /**
//     * 字段名
//     *
//     * @param fieldRow 字段所在行
//     * @return String[]
//     */
//    String[] getFieldName(int fieldRow);
//
//    /**
//     * 实际展示数据
//     *
//     * @param fieldRow 字段所在行
//     * @return String[][]
//     */
//    Object[][] getData(int fieldRow);
//
//}
