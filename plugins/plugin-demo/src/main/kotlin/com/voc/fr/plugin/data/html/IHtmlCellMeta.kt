package com.voc.fr.plugin.data.html

/**
 * Html 表单元信息接口
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/06 15:02
 */
interface IHtmlCellMeta : ICellMeta {

    /**
     * 合并行数
     *
     * @return Integer
     */
    var rowSpan: Int?

    /**
     * 合并列数
     *
     * @return Integer
     */
    var colSpan: Int?

    /**
     * 是否行合并
     *
     * @return boolean
     */
    fun isRowMerge(): Boolean

    /**
     * 是否列合并
     *
     * @return boolean
     */
    fun isColMerge(): Boolean

}
