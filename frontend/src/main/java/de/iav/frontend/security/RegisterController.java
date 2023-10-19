package de.iav.frontend.security;

import de.iav.frontend.HelloApplication;
import de.iav.frontend.model.Bag;
import de.iav.frontend.model.UserWithoutIdDto;
import de.iav.frontend.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterController {
    @FXML
    public TextField usernameInput;
    @FXML
    public TextField emailInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Label errorLabel;
    private UserWithoutIdDto userWithoutIdDto;

    private final UserService userService = new UserService();

    @FXML
    protected void onRegisterClick() {
        register();
    }

    //private final AuthService authService = AuthService.getInstance();

    public void register() {

        /*AppUserRequest appUserRequest = new AppUserRequest(
                usernameInput.getText(),
                emailInput.getText(),
                passwordInput.getText()
        );

        if (authService.registerAppUser(appUserRequest)) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            Stage stage = (Stage) usernameInput.getScene().getWindow();
            stage.setScene(scene);

        } else {
            errorLabel.setText(authService.errorMessage());
        }*/
        userWithoutIdDto = new UserWithoutIdDto(usernameInput.getText(), emailInput.getText(), passwordInput.getText(), new ArrayList<Bag>());
        userService.addUser(userWithoutIdDto);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) usernameInput.getScene().getWindow();
        stage.setScene(scene);

    }
}
