package com.voc.fr.plugin.data.html

import java.io.File
import java.io.InputStream
import java.net.URL

/**
 * 表解析接口
 *
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 22:18
 */
interface ITablePhrase {

    /**
     * 从输入流获取表信息
     *
     * @param bytes 字节信息
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    @Throws(TablePhraseException::class)
    fun getTableInfo(bytes: ByteArray): Collection<ITableMeta>

    /**
     * 从输入流获取表信息
     *
     * @param inputStream 输入流
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    @Throws(TablePhraseException::class)
    fun getTableInfo(inputStream: InputStream): Collection<ITableMeta>

    /**
     * 从资源文件获取表信息
     *
     * @param url 资源定位器
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    @Throws(TablePhraseException::class)
    fun getTableInfo(url: URL): Collection<ITableMeta>

    /**
     * 从文件获取表信息
     *
     * @param file 文件
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    @Throws(TablePhraseException::class)
    fun getTableInfo(file: File): Collection<ITableMeta>

}

val TABLE: String
    get() = "table"

val TABLE_CAPTION: String
    get() = "caption"

val TR: String
    get() = "tr"

val ROW_SPAN: String
    get() = "rowspan"

val COL_SPAN: String
    get() = "colspan"
