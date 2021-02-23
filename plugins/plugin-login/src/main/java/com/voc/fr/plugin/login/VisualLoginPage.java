package com.voc.fr.plugin.login;

import com.fr.decision.fun.impl.AbstractLoginPageProvider;
import com.fr.decision.web.LoginComponent;
import com.fr.general.Inter;
import com.fr.intelli.record.Focus;
import com.fr.intelli.record.Original;
import com.fr.record.analyzer.EnableMetrics;
import com.fr.web.struct.Atom;
import com.voc.fr.tool.annotation.core.FunctionDefineProvider;
import com.voc.fr.tool.annotation.decision.LoginPageProvider;
import com.voc.fr.tool.annotation.design.PresentKindProvider;
import com.voc.fr.tool.annotation.design.ServerTableDataDefineProvider;
import com.voc.fr.tool.annotation.design.TableDataDefineProvider;
import com.voc.fr.tool.annotation.plugin.ChangeNote;
import com.voc.fr.tool.annotation.plugin.ChangeNotes;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2020/04/20 11:51
 */
@EnableMetrics
@ChangeNote(dateOf = "2020-04-21", contents = {"插件初始化", "测试信息"})
@LoginPageProvider
@ChangeNotes({
        @ChangeNote(dateOf = "2020-04-22", contents = {"测试1"}),
        @ChangeNote(dateOf = "2019-04-26", contents = {"测试2"})
})
@FunctionDefineProvider(name = "Test")
@PresentKindProvider
@TableDataDefineProvider
@ServerTableDataDefineProvider
public class VisualLoginPage extends AbstractLoginPageProvider {

    @Override
    public String name() {
        return Inter.getLocText("name");
    }

    @Override
    public String text() {
        return Inter.getLocText("name");
    }

    @Override
    public String coverPath() {
        return "com/voc/fr/plugin/login/images/cover.png";
    }

    @Override
    public String imgPath() {
        return "";
    }

    @Override
    public int imgHeight() {
        return 1080;
    }

    @Override
    public int imgWidth() {
        return 1920;
    }

    @Override
    public Atom attach() {
        return LoginComponent.KEY;
    }

    @Override
    @Focus(
            id = Constants.PLUGIN_ID,
            text = "",
            source = Original.PLUGIN
    )
    public Atom client() {
        return new VisualLoginComponent();
    }
}
