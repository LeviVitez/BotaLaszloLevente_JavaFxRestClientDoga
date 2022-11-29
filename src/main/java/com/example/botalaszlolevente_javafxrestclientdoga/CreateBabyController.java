package com.example.botalaszlolevente_javafxrestclientdoga;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class CreateBabyController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField hospitalField;
    @FXML
    private  TextField birthDateField;
    @FXML
    private Button submitButton;

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String gender = genderField.getText().trim();
        String birthDate = birthDateField.getText().trim();
        String hospital = hospitalField.getText();
        Baby newBaby = new Baby(0, name,gender,hospital,birthDate);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newBaby);
        try {
            Response response = RequestHandler.post(BabyApp.BASE_URL, json);
            if (response.getResponseCode() == 201) {
                warning("baby added!");
                nameField.setText("");
                genderField.setText("");
                hospitalField.setText("");
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
