//package com.voc.fr.plugin.data.core;
//
//import com.voc.fr.plugin.data.html.ICellMeta;
//import com.voc.fr.plugin.data.html.IHtmlCellMeta;
//import com.voc.fr.plugin.data.html.IRowMeta;
//import com.voc.fr.plugin.data.html.ITableMeta;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * @author Wu Yujie
// * @email coffee377@dingtalk.com
// * @time 2019/09/05 09:29
// */
//public class TableMeta implements ITableMeta {
//
//    private String name;
//
//    private Collection<IRowMeta> rowMetas;
//
//    @Nullable
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @NotNull
//    @Override
//    public Collection<IRowMeta> getRowMetas() {
//        return rowMetas;
//    }
//
//    public void setRowMetas(Collection<IRowMeta> rowMetas) {
//        this.rowMetas = rowMetas;
//    }
//
//    @Override
//    public int getRowCount() {
//        return rowMetas.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        Iterator<IRowMeta> metaIterator = rowMetas.iterator();
//        /* 获取第一行，计算表格列数 */
//        if (metaIterator.hasNext()) {
//            IRowMeta rowMeta = metaIterator.next();
//            return rowMeta.getCellMeta().stream().mapToInt(cellMeta -> {
//                if (cellMeta instanceof IHtmlCellMeta) {
//                    IHtmlCellMeta htmlCellMeta = (IHtmlCellMeta) cellMeta;
//                    Integer colSpan = htmlCellMeta.getColSpan();
//                    return colSpan == null ? 1 : colSpan;
//                }
//                return 0;
//            }).sum();
//        }
//        return 0;
//    }
//
//    @NotNull
//    @Override
//    public Object[][] getDataStorageSet() {
//        Object[][] result = new Object[getRowCount()][getColumnCount()];
//        for (IRowMeta rowMeta : rowMetas) {
//            for (ICellMeta cellMeta : rowMeta.getCellMeta()) {
//                cellMeta.setDataStorageSet(result);
//                cellMeta.fillValue();
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public String[] getFieldName(int fieldRow) {
//        List<String> colName = new ArrayList<>();
//        if (fieldRow > 0 && fieldRow <= getRowCount()) {
//            Object[] columnNames = getDataStorageSet()[fieldRow - 1];
//            for (Object columnName : columnNames) {
//                colName.add(columnName.toString());
//            }
//        } else {
//            for (int i = 0; i < getColumnCount(); i++) {
//                colName.add("ColName " + i);
//            }
//        }
//        return colName.toArray(new String[]{});
//    }
//
//    @Override
//    public Object[][] getData(int fieldRow) {
//        if (fieldRow > 0 && fieldRow < getRowCount()) {
//            Object[][] result = new Object[getRowCount() - fieldRow][getColumnCount()];
//            Object[][] raw = getDataStorageSet();
//            for (int i = 0; i < raw.length; i++) {
//                if (i + 1 > fieldRow) {
//                    result[i - fieldRow] = raw[i];
//                }
//            }
//            return result;
//        } else if (fieldRow <= 0) {
//            return getDataStorageSet();
//        }
//        return new Object[][]{};
//    }
//
//}
