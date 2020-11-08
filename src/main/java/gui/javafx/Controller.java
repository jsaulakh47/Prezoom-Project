package gui.javafx;

import java.io.File;

// import gui.javafx.datamodel.TodoItem;

// import java.time.LocalDate;
// import java.time.Month;
// import java.util.ArrayList;
// import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button presentButton;

    @FXML
    private Button previewButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button cameraButton;

    @FXML
    private Button attributesButton;

    @FXML
    private Button transitionsButton;

    @FXML
    private Button interpolationsButton;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;


    public void initialize() {
       
    }

    @FXML
    public void handleSaveClick() {
        logger("Saving file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showSaveDialog(saveButton.getScene().getWindow());
        if (file != null) {
            logger("File saved as: " + file.getPath());
        } else {
            logger("Save cancelled");
        }
    }

    @FXML
    public void handleLoadClick() {
        logger("Loading file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Load Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showOpenDialog(saveButton.getScene().getWindow());
        if (file != null) {
            logger("File loaded as: " + file.getPath());
        } else {
            logger("Load cancelled");
        }
    }

    @FXML
    public void handlePresentClick() throws Exception {
        Stage primaryStage = new Stage();
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());


        primaryStage.show();
    }

    @FXML
    public void handlePreviewClick() {
        logger("Preview!!!");
    }

    @FXML
    public void handleAttributesClick() {
        logger("Attributes!!!");
    }

    @FXML
    public void handleSettingsClick() {
        logger("Settings!!!");
    }

    @FXML
    public void handleTransitionsClick() {
        logger("Transitions!!!");
    }

    @FXML
    public void handleInterpolationsClick() {
        logger("Interpolations!!!");
    }

    @FXML
    public void handleCameraClick() {
        logger("Camera!!!");
    }

    public void logger(String value) {
        System.out.println(value);
        rightStatus.setText(value);
    }
}
