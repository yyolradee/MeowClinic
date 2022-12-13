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
    private LayoutController lc;
    
    private SettingModel settingModel;

    public SettingController(LayoutController lc) {
        setting = new Setting(this);
        settingPageAccount = new SettingPageAccount();
        settingPageName = new SettingPageName(this);
        settingModel = new SettingModel();
        this.lc = lc;
        
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
        settingModel.updateDisplayName(LayoutController.getUser().getID(), settingPageName.getDisplaynamef().getText());
        LayoutController.getUser().setDisplayName(settingPageName.getDisplaynamef().getText());
        settingPageName.getDisplaynamef().setText(LayoutController.getUser().getDisplayName());
        JOptionPane.showMessageDialog(null, "Displayname changed.", "", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void deleteAcc(){
        settingModel.deleteAccount(LayoutController.getUser().getID());
        LayoutController.setUser(null);
        lc.changeRoute("AuthLayout");
        JOptionPane.showMessageDialog(null, "Your account have been deleted.", "", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void changeRoute(String name) {
        name = name.toLowerCase();
        if (name.equals(getClassName(settingPageName))) {
            replacePanel(this.setting.getPanel(), settingPageName);
        } else if (name.equals(getClassName(settingPageAccount))) {
            replacePanel(this.setting.getPanel(), settingPageAccount);
        }
    }

}
