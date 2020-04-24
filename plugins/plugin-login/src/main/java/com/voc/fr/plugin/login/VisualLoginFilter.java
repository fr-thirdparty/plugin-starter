package com.voc.fr.plugin.login;

import com.fr.decision.config.AppearanceConfig;
import com.fr.web.struct.Filter;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2020/04/20 17:48
 */
public class VisualLoginFilter implements Filter {
    @Override
    public boolean accept() {
        return Constants.PLUGIN_ID.equals(AppearanceConfig.getInstance().getLoginPageId());
    }
}
