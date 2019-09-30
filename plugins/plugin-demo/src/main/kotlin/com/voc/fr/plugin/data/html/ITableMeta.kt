package com.voc.fr.plugin.data.html

/**
 * 二维表信息
 *
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 22:00
 */
interface ITableMeta {

    /**
     * 表名称
     *
     * @return String
     */
    val name: String?

    /**
     * 数据行信息
     *
     * @return Collection<IRowMeta>
     */
    val rowMetas: Collection<IRowMeta>

    /**
     * 行数（合并单元格拆分后）
     *
     * @return int
     */
    val rowCount: Int

    /**
     * 列数（合并单元格拆分后）
     *
     * @return int
     */
    val columnCount: Int

    /**
     * 数据存储集合
     */
    val dataStorageSet:Array<Array<Any?>>

    /**
     * 字段名
     *
     * @param fieldRow 字段所在行
     * @return String[]
     */
    fun getFieldName(fieldRow: Int): Array<String>

    /**
     * 实际展示数据
     *
     * @param fieldRow 字段所在行
     * @return String[][]
     */
    fun getData(fieldRow: Int): Array<Array<Any?>>

}