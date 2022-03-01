package com.github.jonahbaayen.lab05;

import com.github.jonahbaayen.lab05.components.TextFieldWithPrompt;
import com.github.jonahbaayen.lab05.records.DataSource;
import com.github.jonahbaayen.lab05.records.StudentRecord;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Lab05 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Generate starting student records
        ObservableList<StudentRecord> records = DataSource.getAllMarks();

        // Generate tableview
        TableView tableView = new TableView();

        // Add columns
        TableColumn<StudentRecord, String> studentId = new TableColumn<>("SID");
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        TableColumn<StudentRecord, String> assignments = new TableColumn<>("Assignments");
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord, String> midterm = new TableColumn<>("Midterm");
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord, String> finalExam = new TableColumn<>("Final Exam");
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord, String> finalMark = new TableColumn<>("Final Mark");
        finalMark.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        TableColumn<StudentRecord, String> letterGrade = new TableColumn<>("Letter Grade");
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));

        tableView.getColumns().setAll(studentId, assignments, midterm, finalExam, finalMark, letterGrade);

        // Populate table
        for (StudentRecord record : records) {
            tableView.getItems().add(record);
        }

        // Set up scene
        VBox vbox = new VBox(tableView);

        // Set up "new student record" area (EXTRA CHALLENGE)
        TextFieldWithPrompt sidField = new TextFieldWithPrompt("SID");
        TextFieldWithPrompt midtermField = new TextFieldWithPrompt("Midterm / 100");
        TextFieldWithPrompt assignmentsField = new TextFieldWithPrompt("Assignments / 100");
        TextFieldWithPrompt finalExamField = new TextFieldWithPrompt("Final Exam / 100");

        // Fields for adding new records
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("SID:"), 0, 0);
        gridPane.add(sidField, 1, 0);
        gridPane.add(new Label("Midterm:"), 0, 1);
        gridPane.add(midtermField, 1, 1);
        gridPane.add(new Label("Assignments:"), 2, 0);
        gridPane.add(assignmentsField, 3, 0);
        gridPane.add(new Label("Final Exam:"), 2, 1);
        gridPane.add(finalExamField, 3, 1);

        // "add" button
        StackPane addButtonPane = new StackPane();
        addButtonPane.setPadding(new Insets(0, 10, 10, 10));
        addButtonPane.setAlignment(Pos.CENTER);

        Button addButton = new Button("Add");
        EventHandler<ActionEvent> buttonEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!(sidField.getText().isBlank() &&
                        midtermField.getText().isBlank() &&
                        assignmentsField.getText().isBlank() &&
                        finalExamField.getText().isBlank())) {
                    tableView.getItems().add(
                            new StudentRecord(
                                    sidField.getText(),
                                    Float.parseFloat(assignmentsField.getText()),
                                    Float.parseFloat(midtermField.getText()),
                                    Float.parseFloat(finalExamField.getText())));
                }
            }
        };
        addButton.setOnAction(buttonEvent);

        addButtonPane.getChildren().add(addButton);

        // Assemble scene elements
        vbox.getChildren().addAll(gridPane, addButtonPane);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Lab 05 - Jonah Baayen 100783828");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
