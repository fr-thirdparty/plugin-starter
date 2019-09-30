package com.voc.fr.plugin.data.html.core

import com.voc.fr.plugin.data.html.ICellMeta
import com.voc.fr.plugin.data.html.IRowMeta
import java.util.ArrayList

/**
 * @author  Wu Yujie
 * @email  coffee377@dingtalk.com
 * @time  2019/09/07 18:09
 */
class DefaultRowMeta : IRowMeta {

    private var rowLine: Int = 0
    private var cellCollection: Collection<ICellMeta> = ArrayList()

    override val rowNumber: Int
        get() = rowLine

    override val cellMeta: Collection<ICellMeta>
        get() = cellCollection

    fun setRowNumber(rowNumber: Int) {
        this.rowLine = rowNumber
    }

    fun setCellMeta(cellMeta: Collection<ICellMeta>) {
        cellCollection = cellMeta
    }

}