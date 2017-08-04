package MainEditor.Template03;

import MainEditor.Template02.Template02View;
import MainEditor.TemplateModel;

import javax.swing.*;

/**
 * Created by Wiktor Łazarski on 04.08.2017.
 */
public class Template03Controller {

    private Template03Model model;
    public Template03Model getModel(){return model;}

    public Template03Controller(Template03View view){
        //creating model
        model = new Template03Model();

        //menu attributes
        createMenuModel(view);

        //content attributes
        model.setIframes(view.contentVisualizingPanel.getFields());

        //ads attributes
        model.setPane(view.adsVisualizingPanel.getFields().get(0));     //always one next prev option are turned off
    }

    private void createMenuModel(Template03View view){

        //adding menu size
        model.setMenuSize(view.menuVisualizingPanel.getFields().size());

        //adding menu texts
        String[] texts = new String[view.menuVisualizingPanel.getFields().size()];
        for(int i = 0; i < texts.length; i++)
            texts[i] = view.menuVisualizingPanel.getFields().get(i).getText();

        model.setMenuTexts(texts);

        //adding menu font
        model.setMenuFont(view.menuVisualizingPanel.getFields().get(0).getFont());

        //adding menu font color
        model.setMenuFontColor(view.menuControllerPanel.getFontColors().getSelectedItem().toString());

        //adding menu background color
        model.setMenuBackgroundColor(view.menuControllerPanel.getBackgroundColors().getSelectedItem().toString());

        //adding menu text position
        switch (view.menuVisualizingPanel.getFields().get(0).getHorizontalAlignment()){
            case JTextField.LEFT :
                model.setMenuPosition("left");break;
            case JTextField.CENTER :
                model.setMenuPosition("center");break;
            case JTextField.RIGHT :
                model.setMenuPosition("right");break;
        }
    }

}