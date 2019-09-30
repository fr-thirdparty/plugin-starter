package com.voc.fr.plugin.data.html.core

import com.voc.fr.plugin.data.html.IHtmlCellMeta
import com.voc.fr.plugin.data.html.IRowMeta
import com.voc.fr.plugin.data.html.ITableMeta
import java.util.ArrayList

/**
 * @author  Wu Yujie
 * @email  coffee377@dingtalk.com
 * @time  2019/09/07 22:00
 */
class DefaultTableMeta(override val name: String, override val rowMetas: Collection<IRowMeta>) : ITableMeta {

    override val rowCount: Int
        get() = rowMetas.size

    override val columnCount: Int
        get() {
            val metaIterator = rowMetas.iterator()
            /* 获取第一行，计算表格列数 */
            if (metaIterator.hasNext()) {
                val rowMeta = metaIterator.next()
                return rowMeta.cellMeta.stream().mapToInt { cellMeta ->
                    when (cellMeta) {
                        is IHtmlCellMeta -> cellMeta.colSpan ?: 1
                        else -> 0
                    }
                }.sum()
            }
            return 0
        }

    override val dataStorageSet: Array<Array<Any?>>
        get() {
            val storageSet = Array<Array<Any?>>(rowCount) { arrayOfNulls(columnCount) }
            for (rowMeta in rowMetas) {
                for (cellMeta in rowMeta.cellMeta) {
                    cellMeta.dataStorageSet = storageSet
                    cellMeta.fillValue()
                }
            }
            return storageSet
        }

    override fun getFieldName(fieldRow: Int): Array<String> {
        val colName = ArrayList<String>()
        if (fieldRow in 1..rowCount) {
            val columnNames = dataStorageSet[fieldRow - 1]
            for (columnName in columnNames) {
                colName.add(columnName.toString())
            }
        } else {
            for (i in 0 until columnCount) {
                colName.add("ColName $i")
            }
        }
        return colName.toTypedArray()
    }

    override fun getData(fieldRow: Int): Array<Array<Any?>> {
        if (fieldRow in 1 until rowCount) {
            val result = Array<Array<Any?>>(rowCount - fieldRow) { arrayOfNulls(columnCount) }
            val raw = dataStorageSet
            for (i in raw.indices) {
                if (i + 1 > fieldRow) {
                    result[i - fieldRow] = raw[i]
                }
            }
            return result
        } else if (fieldRow <= 0) {
            return dataStorageSet
        }
        return arrayOf()
    }

}