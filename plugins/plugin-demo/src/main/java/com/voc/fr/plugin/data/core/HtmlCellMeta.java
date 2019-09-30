//package com.voc.fr.plugin.data.core;
//
//import com.voc.fr.plugin.data.html.IHtmlCellMeta;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///**
// * @author Wu Yujie
// * @email coffee377@dingtalk.com
// * @time 2019/09/05 10:35
// */
//public class HtmlCellMeta implements IHtmlCellMeta {
//
//    private int rowIndex;
//    private Integer rowSpan;
//    private Integer colSpan;
//    private Object value;
//    private Object[][] rawData = new Object[][]{};
//
//    @Override
//    @NotNull
//    public Object[][] getDataStorageSet() {
//        return rawData;
//    }
//
//    @Override
//    public void setDataStorageSet(@NotNull Object[][] objects) {
//        this.rawData = objects;
//    }
//
//    @Override
//    public int getRowIndex() {
//        return rowIndex;
//    }
//
//    public void setRowIndex(int rowIndex) {
//        this.rowIndex = rowIndex;
//    }
//
//    @Nullable
//    @Override
//    public Integer getRowSpan() {
//        return rowSpan;
//    }
//
//    @Override
//    public void setRowSpan(Integer rowSpan) {
//        this.rowSpan = rowSpan;
//    }
//
//    @Nullable
//    @Override
//    public Integer getColSpan() {
//        return colSpan;
//    }
//
//    @Override
//    public void setColSpan(Integer colSpan) {
//        this.colSpan = colSpan;
//    }
//
//    @Override
//    public int getColumnIndex() {
//        Object[] curRow = getDataStorageSet()[rowIndex];
//
//        for (int i = 0; i < curRow.length; i++) {
//            if (curRow[i] == null) {
//                return i;
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean isRowMerge() {
//        return rowSpan != null && rowSpan.compareTo(1) > 0;
//    }
//
//    @Override
//    public boolean isColMerge() {
//        return colSpan != null && colSpan.compareTo(1) > 0;
//    }
//
//    @Override
//    public Object getValue() {
//        return this.value;
//    }
//
//    public void setValue(Object value) {
//        this.value = value;
//    }
//
//    @Override
//    public void fillValue() {
//        int rowIndex = getRowIndex();
//        int columnIndex = getColumnIndex();
//
//        int rowSpan = (getRowSpan() == null ? 1 : getRowSpan());
//        int colSpan = (getColSpan() == null ? 1 : getColSpan());
//
//        /* 合并单元格处理 */
//        if (isRowMerge() || isColMerge()) {
//            for (int i = 0; i < rowSpan; i++) {
//                for (int j = 0; j < colSpan; j++) {
//                    rawData[rowIndex + i][columnIndex + j] = value;
//                }
//            }
//        } else {
//            rawData[rowIndex][columnIndex] = value;
//        }
//
//    }
//
//}
