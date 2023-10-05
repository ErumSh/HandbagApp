package de.iav.frontend.controller;

import de.iav.frontend.service.BagService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BagController {

    public Label Label1;
    //Image image = new Image("/Users/erumshaukat/IdeaProjects/HandbagApp/frontend/src/main/resources/de/iav/frontend/IMG_9516.jpg");
    public Label Label2;
    private final BagService bagService = new BagService();
    public Button BuyButton;
    int iconClicked;

    public void Icon1Clicked(MouseEvent mouseEvent) {
        iconClicked = 1;


    }

    public void Icon2Clicked(MouseEvent mouseEvent) {
        iconClicked = 2;
    }

    public void BuyButtonClicked(ActionEvent actionEvent) {
        if (iconClicked == 1)
        {
            System.out.println("first");
        }
        else if (iconClicked == 2)
        {
            System.out.println("second");
        }
    }
}
