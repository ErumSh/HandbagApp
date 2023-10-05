package de.iav.frontend.controller;

import de.iav.frontend.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartPageController {
    //private final UserService userService = UserService.getInstance();
    @FXML
    public PasswordField password;
    @FXML
    public TextField email;
    public Label informationForUser;


    public void signInButtonPressed(ActionEvent actionEvent) throws IOException {

    }

    public void signUpButtonPressed(ActionEvent actionEvent) throws IOException {

    }

    public void deleteUser() {
    }
}


