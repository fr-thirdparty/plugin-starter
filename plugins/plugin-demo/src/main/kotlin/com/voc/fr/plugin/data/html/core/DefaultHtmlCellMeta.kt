package com.voc.fr.plugin.data.html.core

import com.voc.fr.plugin.data.html.IHtmlCellMeta

/**
 * @author  Wu Yujie
 * @email  coffee377@dingtalk.com
 * @time  2019/09/06 22:21
 */
open class DefaultHtmlCellMeta : DefaultCellMeta(), IHtmlCellMeta {

    override var rowSpan: Int? = null

    override var colSpan: Int? = null

    override fun isRowMerge(): Boolean {
        return rowSpan ?: 1 > 1
    }

    override fun isColMerge(): Boolean {
        return colSpan ?: 1 > 1
    }

    override val columnIndex: Int
        get() {
            val curRow = dataStorageSet[rowIndex]

            for (i in curRow.indices) {
                if (curRow[i] == null) {
                    return i
                }
            }
            return 0
        }

    override fun fillValue() {
        val rowNum = rowSpan ?: 1
        val colNum = colSpan ?: 1
        val colPosition = columnIndex

        for (i in 0 until rowNum) {
            for (j in 0 until colNum) {
                dataStorageSet[rowIndex + i][colPosition + j] = value
            }
        }


    }

}