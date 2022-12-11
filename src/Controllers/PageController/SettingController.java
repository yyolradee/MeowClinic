/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Controllers.LayoutController;
import Controllers.Router;
import Layouts.SettingPageAccount;
import Layouts.SettingPageName;
import Model.SettingModel;
import Pages.Setting;
import Popup.ChangePassword;
import javax.swing.JOptionPane;

/**
 *
 * @author pongp
 */
public class SettingController extends Router implements Controller {

    private Setting setting;
    private SettingPageAccount settingPageAccount;
    private SettingPageName settingPageName;
    private ChangePassword cp;
    
    private SettingModel settingModel;

    public SettingController() {
        setting = new Setting(this);
        settingPageAccount = new SettingPageAccount();
        settingPageName = new SettingPageName(this);
        settingModel = new SettingModel();

        changeRoute("SettingPageName");
    }

    @Override
    public Setting getLayout() {
        return this.setting;
    }
    
    public void showPopupChangePassword(){
        cp = new ChangePassword(this);
    }
    
    public void changePassword(){
        if ((cp.getOldPass().getText()).equals(LayoutController.getUser().getPassword())){
            cp.getErrorMss().setText("");
            if (cp.getNewPass().getText().equals("")){
                cp.getErrorMss().setText("Password can't empthy.");
            }
            else if (cp.getNewPass().getText().equals(cp.getConPass().getText())){
                settingModel.changePassword(LayoutController.getUser().getID(), cp.getNewPass().getText());
                LayoutController.getUser().setPassword(cp.getNewPass().getText());
                cp.getErrorMss().setText("Password Changed.");
            }
            else {
                cp.getErrorMss().setText("Error: New Password not match");
            }
        }
        else {
            cp.getErrorMss().setText("Error: Old password is wrong");
        }
    }
    
    public void changeDisplayName(){
        //model update display name wait for nongzheng.
        JOptionPane.showMessageDialog(null, "Displayname changed.", "", JOptionPane.PLAIN_MESSAGE);
        settingPageName.getDisplaynamef().setText(LayoutController.getUser().getDisplayName());
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
