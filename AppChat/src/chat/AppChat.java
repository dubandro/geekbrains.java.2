package chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppChat extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chatclient.fxml"));
        primaryStage.setTitle("My Chat");
        primaryStage.getIcons().add(new Image(AppChat.class.getResourceAsStream("mails.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
