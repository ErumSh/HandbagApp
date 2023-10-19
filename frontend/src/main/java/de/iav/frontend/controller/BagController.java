package de.iav.frontend.controller;

import de.iav.frontend.model.Bag;
import de.iav.frontend.model.User;
import de.iav.frontend.service.BagService;
import de.iav.frontend.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class BagController {

    public Label Label1;
    //Image image = new Image("/Users/erumshaukat/IdeaProjects/HandbagApp/frontend/src/main/resources/de/iav/frontend/IMG_9516.jpg");
    public Label Label2;
    private final BagService bagService = new BagService();
    public Button BuyButton;
    public Label User;
    private final UserService userService = new UserService();
    public String email;
    public Label Label5;
    public Label Label4;
    public Label Label3;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Button MyCart;
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
            BuyBag("1");
        }
        else if (iconClicked == 2)
        {
            BuyBag("2");
        }
        else if (iconClicked == 3)
        {
            BuyBag("3");
        }
        else if (iconClicked == 4)
        {
            BuyBag("4");
        }
        else if (iconClicked == 5)
        {
            BuyBag("5");
        }
    }
    public void BuyBag(String bag){
        User oldUser = userService.getUserByEmail(email);
        List<Bag> listOfBags = oldUser.listOfBags();
        Bag newBag = bagService.getBagById(bag);
        listOfBags.add(newBag);
        List<Bag> listOfBagsUpdated = listOfBags;
        User newUser = new User(oldUser.id(), oldUser.userName(), oldUser.email(), oldUser.password(),oldUser.role(), listOfBagsUpdated);
        System.out.println(newUser);
        userService.updateUser(newUser);

    }
    public void MyCartPressed(ActionEvent actionEvent) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/List.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        CartListController cartListController = fxmlLoader.getController();

        Scene scene = new Scene(parent);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        User user = userService.getUserByEmail(email);
        cartListController.NameLabel.setText(user.userName());
        ObservableList<Bag> listOfBags = FXCollections.observableArrayList(user.listOfBags());
        cartListController.listBags.setItems(listOfBags);
        cartListController.listBags.setCellFactory(param -> new ListCell<Bag>() {
            @Override
            protected void updateItem(Bag item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString()); // You can format the text as per your requirements here
                    setPrefHeight(40); // Set the preferred height for each cell
                    setWrapText(true); // Enable text wrapping
                }
            }

        });
        cartListController.email = this.email;
    }

    public void Icon3Clicked(MouseEvent mouseEvent) {iconClicked = 3;
    }

    public void Icon4Clicked(MouseEvent mouseEvent) {iconClicked = 4;
    }

    public void Icon5Clicked(MouseEvent mouseEvent) {iconClicked = 5;
    }
}
