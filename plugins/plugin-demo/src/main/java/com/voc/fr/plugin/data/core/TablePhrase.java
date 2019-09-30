//package com.voc.fr.plugin.data.core;
//
//import com.voc.fr.plugin.data.*;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author Wu Yujie
// * @email coffee377@dingtalk.com
// * @time 2019/09/05 09:27
// */
//public class TablePhrase implements ITablePhrase {
//
//    @NotNull
//    @Override
//    public Collection<ITableMeta> getTableInfo(@NotNull byte[] bytes) throws TablePhraseException {
//        try {
//            InputStream inputStream = new ByteArrayInputStream(bytes);
//            return getTableInfo(inputStream);
//        } catch (NullPointerException e) {
//            throw new TablePhraseException("字节码不能为空", e);
//        }
//    }
//
//    @NotNull
//    @Override
//    public Collection<ITableMeta> getTableInfo(@NotNull InputStream in) throws TablePhraseException {
//        try {
//            Document document = Jsoup.parse(in, null, "");
//            return getTableInfo(document);
//        } catch (IOException e) {
//            throw new TablePhraseException("解析表格时出错", e);
//        }
//    }
//
//    @NotNull
//    @Override
//    public Collection<ITableMeta> getTableInfo(@NotNull URL url) throws TablePhraseException {
//        try {
//            byte[] bytes = IOUtils.toByteArray(url);
//            return getTableInfo(bytes);
//        } catch (IOException e) {
//            throw new TablePhraseException("解析表格时出错", e);
//        }
//    }
//
//    @NotNull
//    @Override
//    public Collection<ITableMeta> getTableInfo(File file) throws TablePhraseException {
//        try {
//            URL url = file.toURI().toURL();
//            return getTableInfo(url);
//        } catch (MalformedURLException e) {
//            throw new TablePhraseException("解析表格时出错", e);
//        }
//    }
//
//    protected Collection<ITableMeta> getTableInfo(Document document) {
//        List<ITableMeta> tableMetas = new ArrayList<>();
//        Elements tables = document.select("table");
//        for (int i = 0; i < tables.size(); i++) {
//            Element element = tables.get(i);
//            ITableMeta tableMeta = resolverTable(element, i);
//            tableMetas.add(tableMeta);
//        }
//        return tableMetas;
//    }
//
//    /**
//     * 解析单表
//     *
//     * @param tableElement Element
//     * @param tableIndex   索引位置
//     * @return ITableMeta
//     */
//    private ITableMeta resolverTable(Element tableElement, int tableIndex) {
//        TableMeta tableMeta = new TableMeta();
//        /* 表名称 */
//        tableMeta.setName(getTableName(tableElement, tableIndex));
//        /* 数据行信息 */
//        Collection<IRowMeta> rowMeta = getRowMeta(tableElement);
//        tableMeta.setRowMetas(rowMeta);
//        return tableMeta;
//    }
//
//    /**
//     * 获取表名称
//     *
//     * @param tableElement Element
//     * @param tableIndex   表位置索引
//     * @return String
//     */
//    private String getTableName(Element tableElement, int tableIndex) {
//        Elements caption = tableElement.select("caption");
//        String name = "table" + tableIndex;
//        if (!caption.isEmpty()) {
//            String trim = caption.text().trim();
//            if (StringUtils.isNotEmpty(trim)) {
//                name = trim;
//            }
//        }
//        return name;
//    }
//
//    /**
//     * 获取表行信息
//     *
//     * @param tableElement Element
//     * @return Collection<IRowMeta>
//     */
//    private Collection<IRowMeta> getRowMeta(Element tableElement) {
//        List<IRowMeta> rowMetas = new ArrayList<>();
//        /* 获取所有行元素 */
//        Elements trs = tableElement.select("tr");
//        for (int i = 0; i < trs.size(); i++) {
//            IRowMeta rowMeta = resolverRowMeta(trs.get(i), i);
//            rowMetas.add(rowMeta);
//        }
//        return rowMetas;
//    }
//
//    /**
//     * 单行解析
//     *
//     * @param rowElement 行元素
//     * @param rowIndex   行索引
//     * @return RowMeta
//     */
//    private IRowMeta resolverRowMeta(Element rowElement, int rowIndex) {
//        RowMeta rowMeta = new RowMeta();
//
//        rowMeta.setRowNumber(rowIndex + 1);
//        List<ICellMeta> cellMetas = new ArrayList<>();
//        rowMeta.setCellMeta(cellMetas);
//
//        Elements columnElements = rowElement.children();
//
//        for (Element columnElement : columnElements) {
//            ICellMeta cellMeta = resolverCellMeta(columnElement, rowIndex);
//            cellMetas.add(cellMeta);
//        }
//        return rowMeta;
//    }
//
//    /**
//     * 单元格解析
//     *
//     * @param columnElement 列元素
//     * @param rowIndex      行索引
//     * @return ICellMeta
//     */
//    private ICellMeta resolverCellMeta(Element columnElement, int rowIndex) {
//        HtmlCellMeta cellMeta = new HtmlCellMeta();
//        cellMeta.setRowIndex(rowIndex);
//
//        String rowspan = columnElement.attr("rowspan");
//        if (StringUtils.isNotEmpty(rowspan)) {
//            cellMeta.setRowSpan(Integer.parseInt(rowspan));
//        }
//
//        String colspan = columnElement.attr("colspan");
//        if (StringUtils.isNotEmpty(colspan)) {
//            cellMeta.setColSpan(Integer.parseInt(colspan));
//        }
//
//        String value = columnElement.text().trim();
//        if (StringUtils.isNotEmpty(value)) {
//            cellMeta.setValue(value);
//        }
//
//        return cellMeta;
//    }
//
//}
