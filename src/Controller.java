import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller{

    @FXML
    private Pane addb;
    @FXML
    private Pane editb;
    @FXML
    private Pane addm;
    @FXML
    private Pane editm;
    @FXML
    private Pane lb;
    @FXML
    private Pane rl;

//------------------------------------------------------

    @FXML
    public void initialize() {
        addb.setOnMouseClicked((event -> openaddbook((Stage) ((Node) event.getSource()).getScene().getWindow())));
        editb.setOnMouseClicked((event -> openeditbook((Stage) ((Node) event.getSource()).getScene().getWindow())));
        addm.setOnMouseClicked((event -> openaddmember((Stage) ((Node) event.getSource()).getScene().getWindow())));
        editm.setOnMouseClicked((event -> openeditmember((Stage) ((Node) event.getSource()).getScene().getWindow())));
        lb.setOnMouseClicked((event -> openloanbook((Stage) ((Node) event.getSource()).getScene().getWindow())));
        rl.setOnMouseClicked((event -> openreturnloan((Stage) ((Node) event.getSource()).getScene().getWindow())));
    }

//------------------------------------------------------

    private void openaddbook(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_book.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Add Book");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openaddmember(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_member.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Add Member");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openeditbook(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edit_delete_book.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Edit Book");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openeditmember(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edit_delete_member.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Edit Member");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openloanbook(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loan_book.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Loan Book");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openreturnloan(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/return_loan.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setX(primaryStage.getX() + 50); // 50 پیکسل به راست
            newStage.setY(primaryStage.getY() + 50); // 50 پیکسل به پایین
            newStage.setResizable(false);
            newStage.setTitle("Return Loan");
            newScene.setFill(Color.TRANSPARENT);
            newStage.show();
            Image newImage = new Image(getClass().getResourceAsStream("/images/icon.png"));
            newStage.getIcons().add(newImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//------------------------------------------------------

    @FXML
    private Pane titlepane ;
    @FXML
    private ImageView btnclose ;
    @FXML
    private ImageView btnmini ;

//------------------------------------------------------

    private double x, y;

    public void init(Stage stage) {

        titlepane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlepane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnclose.setOnMouseClicked(mouseEvent -> stage.close());
        btnmini.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

    }

}