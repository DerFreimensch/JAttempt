package com.example;

import com.example.controller.BaseController;
import com.example.controller.CreateController;
import com.example.model.Student;
import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

import java.io.IOException;
import java.io.InputStream;

public class AppFX extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList<Object> studentsList = FXCollections.observableArrayList();

    public AppFX() {
        studentsList.add(new Student("a", "a", 23, "1945"));
        studentsList.add(new Student("b", "b", 22, "1945"));
        studentsList.add(new Student("c", "c", 21, "1941"));
        studentsList.add(new Student("d", "d", 19, "1941"));
        studentsList.add(new Student("e", "e", 20, "1942"));
    }

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dogs application");
        showBaseWindow();
    }

    public void showBaseWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppFX.class.getResource("/maket/123.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            InputStream iconStream = getClass().getResourceAsStream("/icons/GUAP.jpg");
            Image image = new Image(iconStream);
            primaryStage.getIcons().add(image);
            BaseController controller = loader.getController();
            controller.setAppFX(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void showCreateWindow(Student student) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AppFX.class.getResource("/maket/new.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Новый студент");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setScene(new Scene(page));
            CreateController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setStudent(student);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }

    public ObservableList<Object> getStudentsList() {
        return studentsList;
    }
}