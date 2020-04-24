package com.voc.fr.plugin.login;

import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ParserType;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2020/04/20 11:46
 */
public class VisualLoginComponent extends Component {

    @Override
    public ScriptPath script(RequestClient requestClient) {
        return ScriptPath.build("com/voc/fr/plugin/login/plugin.js");
    }

    @Override
    public StylePath style(RequestClient requestClient) {
        return StylePath.build("com/voc/fr/plugin/login/plugin.css", ParserType.DYNAMIC);
    }

    @Override
    public Filter filter() {
        return new VisualLoginFilter();
    }

}
