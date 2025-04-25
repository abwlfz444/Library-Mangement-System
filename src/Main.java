import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/First.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("gIS");
        scene.setFill(Color.TRANSPARENT);
        stage.show();
        Image image = new Image(getClass().getResourceAsStream("/images/icon.png"));
        stage.getIcons().add(image);
        ((Controller)loader.getController()).init(stage);
    }

    public void run(){
        launch();
    }
}
