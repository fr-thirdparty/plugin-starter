package com.voc.fr.plugin.api;

import com.voc.fr.plugin.data.html.ITableMeta;
import com.voc.fr.plugin.data.html.TablePhraseException;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

/**
 * 表解析接口
 *
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/04 22:18
 */
public interface ITablePhrase {
    public static final String CAPTION = "caption";

    /**
     * 从输入流获取表格信息
     *
     * @param bytes 字节信息
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    Collection<ITableMeta> getTableInfo(byte[] bytes) throws TablePhraseException;

    /**
     * 从输入流获取表格信息
     *
     * @param in 输入流
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    Collection<ITableMeta> getTableInfo(InputStream in) throws TablePhraseException;

    /**
     * 从资源文件获取表格信息
     *
     * @param url 资源定位器
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    Collection<ITableMeta> getTableInfo(URL url) throws TablePhraseException;

    /**
     * 从文件获取表格信息
     *
     * @param file 文件
     * @return 表信息集合
     * @throws TablePhraseException 解析异常
     */
    Collection<ITableMeta> getTableInfo(File file) throws TablePhraseException;

}
