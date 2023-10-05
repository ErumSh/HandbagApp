package de.iav.frontend.security;

import de.iav.frontend.controller.BagController;
import de.iav.frontend.security.AuthService;
import de.iav.frontend.service.BagService;
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

    @FXML
    public Label errorLabel;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public TextField usernameInput;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final BagService bagService = new BagService();

    public void onLoginClick(ActionEvent actionEvent) {
        login();
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
        Stage stage = (Stage) usernameInput.getScene().getWindow();
        stage.setScene(scene);
    }
    private final AuthService authService = AuthService.getInstance();

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
    }

}
