package chat;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

import static javafx.scene.control.ButtonType.CANCEL;

public class ChatPopUp {

    public static void loginDialog() {

        // Create the custom dialog
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("My Chat - Login");
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, CANCEL);
        // Create the username and password labels and fields
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 11, 11, 11));
        // TextField
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        // Adding TF to grid
        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);
        // Enable/Disable login button depending on whether a username was entered
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });
        // Set content
        dialog.getDialogPane().setContent(grid);
        // Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter((ButtonType dialogButton) -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            Authorization.userLogIn(usernamePassword.getKey(), usernamePassword.getValue());
        });
    }

    public static void alert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("My Chat - Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
