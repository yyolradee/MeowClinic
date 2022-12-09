/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.PageController;

import Controllers.Controller;
import Pages.Records;

/**
 *
 * @author pongp
 */
public class RecordsController implements Controller {

    private Records record;

    public RecordsController() {
        record = new Records();
    }

    @Override
    public Records getLayout() {
        return this.record;
    }
}
