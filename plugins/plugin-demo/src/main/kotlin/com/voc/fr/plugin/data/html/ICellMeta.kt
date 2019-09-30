package com.voc.fr.plugin.data.html

/**
 * 原始表格单元信息接口
 *
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 21:57
 */
interface ICellMeta {

    /**
     * 行索引
     *
     * @return int
     */
    val rowIndex: Int

    /**
     * 列索引
     *
     * @return int
     */
    val columnIndex: Int

    /**
     * 值
     *
     * @return String
     */
    val value: Any?

    /**
     * 数据存储集合
     */
    var dataStorageSet: Array<Array<Any?>>

    /**
     * 依据单元格合并情况，填充二维表数据
     */
    fun fillValue()

}
