package com.voc.fr.plugin.data.html

/**
 * 原始表格行信息接口
 *
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 22:15
 */
interface IRowMeta {

    /**
     * 行号
     *
     * @return int
     */
    val rowNumber: Int

    /**
     * 单元列信息
     *
     * @return Collection<ICellMeta>
     */
    val cellMeta: Collection<ICellMeta>

}