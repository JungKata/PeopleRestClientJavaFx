package hu.petrik.peoplerestclientjavafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ListPeopleController {
    @FXML
    public Button insertButton;
    @FXML
    public Button updateButton;
    @FXML
    public Button deleteButton;
    @FXML
    public TableView<Person> peopleTable;
    @FXML
    public TableColumn<Person, String> nameColumn;
    @FXML
    public TableColumn<Person, String> emailColumn;
    @FXML
    public TableColumn<Person, Integer> ageColumn;

    @FXML
    private void initialize(){
        //getName( függvény eredményét írja ki
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        try {
            Response response = RequestHandler.get(App.BASE_URL);
            String content = response.getContent();
            Gson converter = new Gson();
            Person[] people = converter.fromJson(content, Person[].class);
            for (Person person : people){
                peopleTable.getItems().add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void insertClick(ActionEvent actionEvent) {
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteClick(ActionEvent actionEvent) {
    }
}