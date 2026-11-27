package utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.User;


import java.io.IOException;
import java.net.URL;

public class SceneSwitchingHelper {


    public static void switchSceneWithData(javafx.event.ActionEvent event, String fxml, User user) {
        try {

            URL location = SceneSwitchingHelper.class.getResource(fxml);

            if (location == null) {
                AlertGenerator.showAlert(
                        "FXML Error",
                        "FXML file not found:\n" + fxml
                );
                return;
            }

            FXMLLoader loader = new FXMLLoader(location);
            Parent root = loader.load();

            Object controller = loader.getController();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            AlertGenerator.showAlert(
                    "Scene Loading Error",
                    "Unable to load the FXML file."
            );

        } catch (Exception e) {
            e.printStackTrace();
            AlertGenerator.showAlert(
                    "Unexpected Error",
                    e.getMessage()
            );
        }
    }

}