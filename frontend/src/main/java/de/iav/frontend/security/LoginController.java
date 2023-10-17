package de.iav.frontend.security;

import de.iav.frontend.controller.BagController;
import de.iav.frontend.model.User;
import de.iav.frontend.security.AuthService;
import de.iav.frontend.service.BagService;
import de.iav.frontend.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private final UserService userService = UserService.getInstance();
    @FXML
    public Label errorLabel;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public TextField emailInput;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final BagService bagService = new BagService();

    private User user;

    public void onLoginClick(ActionEvent actionEvent) {
        login();
    }
    public void login() {
        System.out.println(emailInput.getText());
        if (emailInput.getText().isEmpty() || emailInput.getText().isBlank()) {
            errorLabel.setText("Please enter email");
        } else {
            if (userService.getUserByEmail(emailInput.getText()) == null) {
                errorLabel.setText("User does not exist, please create new account");
            } else {
                if (passwordInput.getText().isEmpty() || passwordInput.getText().isBlank()) {
                    errorLabel.setText("Please enter password");
                } else {
                    User logInUser = userService.getUserByEmail(emailInput.getText());
                    System.out.println(logInUser.password());
                    System.out.println(passwordInput.getText());
                    if (!(userService.getUserByEmail(emailInput.getText()).password()).equals(passwordInput.getText())) {
                        errorLabel.setText("Wrong password");
                    } else {
                        if ((userService.getUserByEmail(emailInput.getText()).password()).equals(passwordInput.getText())) {
                            System.out.println("correct password, switch to portfolio page");
                            System.out.println("logInUser: " + logInUser);
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/bag-view.fxml"));

                            user = userService.getUserByEmail(emailInput.getText());
                            Parent parent = null;
                            try {
                                parent = fxmlLoader.load();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            BagController bagController = fxmlLoader.getController();
                            Scene scene = new Scene(parent);
                            Stage stage = (Stage) emailInput.getScene().getWindow();
                            stage.setScene(scene);
                            bagController.email= emailInput.getText();
                            bagController.User.setText((userService.getUserByEmail(emailInput.getText())).userName());
                            //System.out.println(String.valueOf(bagService.getBagByType("tabby")));
                            bagController.Label1.setText(String.valueOf(bagService.getBagById("1").price())+ "$");
                            bagController.Label2.setText(String.valueOf(bagService.getBagById("2").price()) + "$");
                        }
                    }
                }
            }
        }
    }


    public void onRegisterClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/register-view.fxml"));
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        Stage stage = (Stage) emailInput.getScene().getWindow();
        stage.setScene(scene);
    }
    /*private final AuthService authService = AuthService.getInstance();

    public void login() {
        if (authService.login(usernameInput.getText(), passwordInput.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/iav/frontend/bag-view.fxml"));


            Parent parent = null;
            try {
                parent = fxmlLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            BagController bagController = fxmlLoader.getController();
            Scene scene = new Scene(parent);
            Stage stage = (Stage) usernameInput.getScene().getWindow();
            stage.setScene(scene);
            //System.out.println(String.valueOf(bagService.getBagByType("tabby")));
            bagController.Label1.setText(String.valueOf(bagService.getBagByType("tabby").price())+ "$");
            bagController.Label2.setText(String.valueOf(bagService.getBagByType("lunchbox").price()) + "$");
        } else {
            errorLabel.setText(authService.errorMessage());
        }
    }*/

}
