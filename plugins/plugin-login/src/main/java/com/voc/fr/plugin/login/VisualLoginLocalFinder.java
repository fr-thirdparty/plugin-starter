package com.voc.fr.plugin.login;

import com.fr.stable.fun.impl.AbstractLocaleFinder;
import com.voc.fr.tool.annotation.core.LocaleFinder;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2020/04/21 10:57
 */
@LocaleFinder
public class VisualLoginLocalFinder extends AbstractLocaleFinder {
    @Override
    public String find() {
        return "com/voc/fr/plugin/login/message";
    }
}
