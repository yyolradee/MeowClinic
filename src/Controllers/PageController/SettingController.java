/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Controllers.Router;
import Layouts.SettingPageAccount;
import Layouts.SettingPageName;
import Pages.Setting;

/**
 *
 * @author pongp
 */
public class SettingController extends Router implements Controller {

    private Setting setting;
    private SettingPageAccount settingPageAccount;
    private SettingPageName settingPageName;

    public SettingController() {
        setting = new Setting();
        settingPageAccount = new SettingPageAccount();
        settingPageName = new SettingPageName();

        changeRoute("SettingPageName");
    }

    @Override
    public Setting getLayout() {
        return this.setting;
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(settingPageName))) {
            replacePanel(this.setting.getPanel(), settingPageName);
        } else if (name.equals(getClassName(settingPageAccount))) {
            replacePanel(this.setting.getPanel(), settingPageAccount);
        }
//        else if (name.equals(getClassName(Cashier.getLayout()))) {
//            replacePanel(mainLayout.getPanel(), Cashier.getLayout());
//        } else if (name.equals(getClassName(Setting.getLayout()))) {
//            replacePanel(mainLayout.getPanel(), Setting.getLayout());
//        }
    }

}
