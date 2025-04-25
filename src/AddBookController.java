import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AddBookController {

    private DatabaseManager database = new DatabaseManager();

    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField quantityField;
    @FXML
    private Button tt;
    @FXML
    private Button addbookbutton;
    @FXML
    private Label el;


    public void initialize() {
        tt.setOnAction(event -> transfer((Stage) ((Node) event.getSource()).getScene().getWindow()));

        addbookbutton.setOnAction(e -> addBook());
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String quantityText = quantityField.getText().trim();

        if (areFieldsValid(title, author, quantityText)) {
            try {
                int quantity = Integer.parseInt(quantityText);
                database.addBook(new Book(title, author, quantity));
                clearFields();
                el.setText(quantityText + " " + title + " added successfully.");
            } catch (NumberFormatException ex) {
                el.setText("Please check the quantity field!");
            }
        } else {
            el.setText("Please check fields!");
        }
    }

    private boolean areFieldsValid(String title, String author, String quantityText) {
        return !title.isEmpty() && !author.isEmpty() && !quantityText.isEmpty();
    }

    private void clearFields() {
        titleField.clear();
        authorField.clear();
        quantityField.clear();
    }

    private void transfer (Stage primaryStage) {
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
}
