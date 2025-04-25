import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AddMemberController {

    private DatabaseManager database = new DatabaseManager();

    @FXML
    private TextField memberNameField;
    @FXML
    private TextField memberIdField;
    @FXML
    private Button tt;
    @FXML
    private Button addmemberbutton;
    @FXML
    private Label el;

    public void initialize() {

        tt.setOnAction(event -> transfer((Stage) ((Node) event.getSource()).getScene().getWindow()));

        addmemberbutton.setOnAction(e -> {
            String name = memberNameField.getText();
            String memberId = memberIdField.getText();
            if (!name.isEmpty() && !memberId.isEmpty()) {
                database.addMember(new Member(name, memberId));
                memberNameField.clear();
                memberIdField.clear();
                el.setText( name + " added successfully " );
            }
            else {
                el.setText( " Please check fields! " );
            }
        });

    }

    private void transfer (Stage primaryStage) {
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

}
