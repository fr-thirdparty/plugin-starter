package com.voc.fr.plugin.data.core;

import com.voc.fr.plugin.data.html.core.DefaultCellMeta;
import com.voc.fr.plugin.data.html.core.DefaultHtmlCellMeta;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/06 18:06
 */
public class DefaultCellMetaTest {

    @Test
    public void defaultCellMeta() {
        DefaultCellMeta cellMeta = new DefaultCellMeta();
        cellMeta.setRowIndex(1);
        cellMeta.setColumnIndex(1);
        cellMeta.setValue(33);
        cellMeta.setDataStorageSet(new Object[2][2]);
        cellMeta.fillValue();
        Object o = cellMeta.getDataStorageSet()[1][1];
        Assert.assertEquals(33, o);
    }

    @Test
    public void defaultHtmlCellMeta() {
        DefaultHtmlCellMeta cellMeta = new DefaultHtmlCellMeta();
        cellMeta.setRowIndex(1);
        cellMeta.setValue(2);
        cellMeta.setRowSpan(3);
        cellMeta.setColSpan(3);
        cellMeta.setDataStorageSet(new Object[20][20]);
        cellMeta.fillValue();
        Object o = cellMeta.getDataStorageSet()[1][1];
        Assert.assertEquals(2, o);
    }

}
