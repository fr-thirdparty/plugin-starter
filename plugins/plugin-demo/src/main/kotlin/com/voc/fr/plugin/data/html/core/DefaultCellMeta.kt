package com.voc.fr.plugin.data.html.core

import com.voc.fr.plugin.data.html.ICellMeta

open class DefaultCellMeta : ICellMeta {
    private var rIndex: Int = 0
    private var cIndex: Int = 0
    private var v: Any? = null

    override var dataStorageSet: Array<Array<Any?>> = arrayOf()

    override val rowIndex: Int
        get() = rIndex

    override val columnIndex: Int
        get() = cIndex

    override val value: Any?
        get() = v

    fun setRowIndex(rowIndex: Int) {
        rIndex = rowIndex
    }

    fun setColumnIndex(columnIndex: Int) {
        cIndex = columnIndex
    }

    fun setValue(value: Any) {
        v = value
    }

    override fun fillValue() {
        dataStorageSet[rowIndex][columnIndex] = value
    }

}