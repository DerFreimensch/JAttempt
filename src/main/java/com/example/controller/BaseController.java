package com.example.controller;

import com.example.AppFX;
import com.example.model.Student;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

public class BaseController {
    @FXML
    private TableView students;
    @FXML
    private TableColumn nameList;
    @FXML
    private TextField name;
    @FXML
    private TextField secondname;
    @FXML
    private TextField age;
    @FXML
    private TextField group;
    @FXML
    private AppFX appFX;

    private void initialize() {

        students.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentsInformation((Student) newValue));
    }
    public void setAppFX(AppFX appFX) {
        this.appFX = appFX;
        students.setItems(appFX.getStudentsList());

        nameList.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>) cellDataFeatures -> cellDataFeatures.getValue().getName());
        students.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentsInformation((Student) newValue));
    }

    private void showStudentsInformation(Student currentStudent) {
        if (currentStudent != null) {
            name.setText(currentStudent.getName() != null ? currentStudent.getName().getValue() : null);
            secondname.setText(currentStudent.getSecondname() != null ? currentStudent.getSecondname().getValue() : null);
            age.setText(currentStudent.getAge() != null ? String.valueOf(currentStudent.getAge().get()) : null);
            group.setText(currentStudent.getGroup() != null ? currentStudent.getGroup().getValue() : null);
        } else {
            name.setText("");
            secondname.setText("");
            age.setText("");
            group.setText("");
        }
    }

    @FXML
    private void delete() {
        int selectedIndex = students.getSelectionModel().getSelectedIndex();
        students.getItems().remove(selectedIndex);
    }

    @FXML
    private void edit() {
        int selectedIndex = students.getSelectionModel().getSelectedIndex();
        students.getItems().set(selectedIndex, new Student(name.getText(), secondname.getText(), Integer.parseInt(age.getText()), group.getText()));
    }

    @FXML
    private void create() {
        Student someStudent = new Student();
        appFX.showCreateWindow(someStudent);
        if (someStudent.getName() != null && !someStudent.getName().getValue().isEmpty()) {
            appFX.getStudentsList().add(someStudent);
        }
    }
}
