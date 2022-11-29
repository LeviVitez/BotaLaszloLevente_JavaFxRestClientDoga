package com.example.botalaszlolevente_javafxrestclientdoga;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class UpdateBabyController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField hospitalField;
    @FXML
    private  TextField birthDateField;
    @FXML
    private Button updateButton;
    private Baby baby;
    public void setBaby(Baby baby) {
        this.baby = baby;
        nameField.setText(this.baby.getName());
        genderField.setText(this.baby.getGender());
        hospitalField.setText(this.baby.getHospital());
        birthDateField.setText(this.baby.getBirthDate());
    }
    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String gender = genderField.getText().trim();
        String birthDate = birthDateField.getText().trim();
        String age = hospitalField.getText();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (gender.isEmpty()) {
            warning("gender is required");
            return;
        }
        if (birthDate.isEmpty()) {
            warning("birthdate is required");
            return;
        }
        this.baby.setName(name);
        this.baby.setGender(gender);
        this.baby.setHospital(age);
        this.baby.setBirthDate(birthDate);
        Gson converter = new Gson();
        String json = converter.toJson(this.baby);
        try {
            String url = BabyApp.BASE_URL + "/" + this.baby.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}