package com.example.controller;

import com.example.model.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateController {
    private Stage dialogStage;
    private Student student;

    @FXML
    private TextField nickName;

    @FXML
    private void ok() {
        if (nickName != null && !nickName.getText().isEmpty()) {
            student.setName(new SimpleStringProperty(nickName.getText()));
            dialogStage.close();
        }
    }

    @FXML
    private void cansel() {
        dialogStage.close();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
