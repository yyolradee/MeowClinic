/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Pages.Setting;

/**
 *
 * @author pongp
 */
public class SettingController implements Controller {

    private Setting setting;

    public SettingController() {
        setting = new Setting();
    }

    @Override
    public Setting getLayout() {
        return this.setting;
    }

}
