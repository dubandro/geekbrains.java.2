package chat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    public ListView onlineUsers;
    public TextArea chatArea;
    public TextArea inputText;
    public Button btnSendMessage;
    public Button btnAttachment;
    public MenuItem menuSignIn;
    public MenuItem menuSignOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onlineUsers.setItems(FXCollections.observableArrayList("User_1", "User_2", "User_3", "User_4", "User_5"));
        if (!Authorization.isAuthorize()) {
            onlineUsers.setOpacity(0.5);
            menuSignOut.setDisable(true);
        }
    }

    public void authorize() {
        if (!Authorization.isAuthorize()) ChatPopUp.loginDialog();
        if (Authorization.isAuthorize()) {
            onlineUsers.setOpacity(1.0);
            menuSignIn.setDisable(true);
            menuSignOut.setDisable(false);
        }
    }

    public void signIn(ActionEvent actionEvent) {
        authorize();
    }

    public void signOut(ActionEvent actionEvent) {
        if (Authorization.isAuthorize()) Authorization.userLogOut();
        if (!Authorization.isAuthorize()) {
            onlineUsers.setOpacity(0.5);
            menuSignIn.setDisable(false);
            menuSignOut.setDisable(true);
            ChatPopUp.alert("See You Soon...");
        }
    }

    public void preferences(ActionEvent actionEvent) {
    }

    public void quit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void delete(ActionEvent actionEvent) {
        inputText.clear();
    }

    public void help(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://github.com/dubandro/geekbrains.java.2"));
    }

    public void about(ActionEvent actionEvent) throws URISyntaxException {
        ChatPopUp.alert("My Chat\ndubandro for geekbrains\n\u00A9 2021");
    }

    public void btnAttach(ActionEvent actionEvent) throws IOException {
    }

    public void pressEnter(KeyEvent actionEvent) {
        if (actionEvent.getCode().equals(KeyCode.ENTER) && actionEvent.isShiftDown()) sendMessage();
    }

    public void btnSend(ActionEvent actionEvent) {
        sendMessage();
    }

    public void sendMessage() {
        if (Authorization.isAuthorize()) {
            String msg = inputText.getText();
            if (msg.length() > 0) {
                chatArea.appendText(msg + System.lineSeparator());
                inputText.clear();
            }
        } else ChatPopUp.alert("Authorization required!");
    }
}