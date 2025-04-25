import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.List;

public class EditDeleteBookController {
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> resultsList;
    @FXML
    private Button tt;
    @FXML
    private ListView booklistview;

    private DatabaseManager database;

    public void initialize() {

        database = new DatabaseManager();
        loadBooks();

        tt.setOnAction(event -> transfer((Stage) ((Node) event.getSource()).getScene().getWindow()));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> searchBooks(newValue));

    }

    private void loadBooks() {
        booklistview.getItems().clear();
        List<Book> books = database.getBooks();
        booklistview.getItems().addAll(books);
//        for (Book book : books) {
//            booklistview.getItems().add(book.getTitle() + " - " + book.getAuthor());
//        }
    }

    private void searchBooks(String query) {
        resultsList.getItems().clear();
        if (query.isEmpty()) {
            return;
        }
        List<Book> foundBooks = database.searchBooks(query);
        for (Book book : foundBooks) {
            resultsList.getItems().add(book.getTitle() + " - " + book.getAuthor());
        }
    }

    private void transfer (Stage primaryStage) {
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
}
