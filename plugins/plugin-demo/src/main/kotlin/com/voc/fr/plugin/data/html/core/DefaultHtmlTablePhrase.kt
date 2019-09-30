package com.voc.fr.plugin.data.html.core

import com.voc.fr.plugin.data.html.*
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.util.*

/**
 * @author  Wu Yujie
 * @email  coffee377@dingtalk.com
 * @time  2019/09/06 17:27
 */
open class DefaultHtmlTablePhrase : ITablePhrase {

    override fun getTableInfo(bytes: ByteArray): Collection<ITableMeta> {
        try {
            val inputStream = ByteArrayInputStream(bytes)
            return getTableInfo(inputStream)
        } catch (e: NullPointerException) {
            throw TablePhraseException("字节码不能为空", e)
        }

    }

    override fun getTableInfo(inputStream: InputStream): Collection<ITableMeta> {
        try {
            val document = Jsoup.parse(inputStream, null, "")
            return getTableInfo(document)
        } catch (e: IOException) {
            throw TablePhraseException("解析表格时出错", e)
        }
    }

    override fun getTableInfo(url: URL): Collection<ITableMeta> {
        try {
            val bytes = IOUtils.toByteArray(url)
            return getTableInfo(bytes)
        } catch (e: IOException) {
            throw TablePhraseException("解析表格时出错", e)
        }
    }

    override fun getTableInfo(file: File): Collection<ITableMeta> {
        try {
            val url = file.toURI().toURL()
            return getTableInfo(url)
        } catch (e: MalformedURLException) {
            throw TablePhraseException("解析表格时出错", e)
        }
    }

    protected open fun getTableInfo(document: Document): Collection<ITableMeta> {
        val tableMetas = ArrayList<ITableMeta>()
        val tables = document.select(TABLE)
        for (i in tables.indices) {
            val element = tables[i]
            val tableMeta = resolverTable(element, i)
            tableMetas.add(tableMeta)
        }
        return tableMetas
    }

    /**
     * 解析单表
     *
     * @param tableElement Element
     * @param tableIndex   索引位置
     * @return ITableMeta
     */
    private fun resolverTable(tableElement: Element, tableIndex: Int): ITableMeta {
        val name = getTableName(tableElement, tableIndex)
        val rowMetas = getRowMetas(tableElement)
        return DefaultTableMeta(name, rowMetas)
    }

    /**
     * 获取表名称
     *
     * @param tableElement Element
     * @param tableIndex   表位置索引
     * @return String
     */
    private fun getTableName(tableElement: Element, tableIndex: Int): String {
        val caption = tableElement.select(TABLE_CAPTION)
        var name = "table$tableIndex"
        if (!caption.isEmpty()) {
            val trim = caption.text().trim { it <= ' ' }
            if (StringUtils.isNotEmpty(trim)) {
                name = trim
            }
        }
        return name
    }

    /**
     * 获取表行信息
     *
     * @param tableElement Element
     * @return Collection<IRowMeta>
     */
    private fun getRowMetas(tableElement: Element): Collection<IRowMeta> {
        val rowMetas = ArrayList<IRowMeta>()
        /* 获取所有行元素 */
        val trs = tableElement.select(TR)
        for (i in trs.indices) {
            val rowMeta = resolverRowMeta(trs[i], i)
            rowMetas.add(rowMeta)
        }
        return rowMetas
    }

    /**
     * 单行解析
     *
     * @param rowElement 行元素
     * @param rowIndex   行索引
     * @return RowMeta
     */
    private fun resolverRowMeta(rowElement: Element, rowIndex: Int): IRowMeta {
        val rowMeta = DefaultRowMeta()

        rowMeta.setRowNumber(rowIndex + 1)
        val cellMetas = ArrayList<ICellMeta>()
        rowMeta.setCellMeta(cellMetas)

        val columnElements = rowElement.children()

        for (columnElement in columnElements) {
            val cellMeta = resolverCellMeta(columnElement, rowIndex)
            cellMetas.add(cellMeta)
        }
        return rowMeta
    }

    /**
     * 单元格解析
     *
     * @param columnElement 列元素
     * @param rowIndex      行索引
     * @return ICellMeta
     */
    private fun resolverCellMeta(columnElement: Element, rowIndex: Int): ICellMeta {
        val cellMeta = DefaultHtmlCellMeta()
        cellMeta.setRowIndex(rowIndex)

        val rowspan = columnElement.attr(ROW_SPAN)
        if (StringUtils.isNotEmpty(rowspan)) {
            cellMeta.rowSpan = Integer.parseInt(rowspan)
        }

        val colspan = columnElement.attr(COL_SPAN)
        if (StringUtils.isNotEmpty(colspan)) {
            cellMeta.colSpan = Integer.parseInt(colspan)
        }

        val value = columnElement.text().trim { it <= ' ' }
        if (StringUtils.isNotEmpty(value)) {
            cellMeta.setValue(value)
        }

        return cellMeta
    }

}
