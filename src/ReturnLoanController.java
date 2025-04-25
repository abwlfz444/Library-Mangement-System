import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ReturnLoanController {
    @FXML
    private TextField loanIdField;
    @FXML
    private Button tt;

    @FXML
    private void returnLoan() {
        String loanId = loanIdField.getText();
        // Logic to return loan
        loanIdField.clear();
    }

    public void initialize() {
        tt.setOnAction(event -> transfer((Stage) ((Node) event.getSource()).getScene().getWindow()));
    }

    private void transfer (Stage primaryStage) {
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
}
