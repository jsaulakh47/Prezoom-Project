package gui.javafx;

import java.io.File;

// import gui.javafx.datamodel.TodoItem;

// import java.time.LocalDate;
// import java.time.Month;
// import java.util.ArrayList;
// import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

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


    public void initialize() {
       
    }


    @FXML
    public void handleSaveClick() {
        System.out.println("Saving file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showSaveDialog(saveButton.getScene().getWindow());
        if (file != null) {
            System.out.println("File saved as: " + file.getPath());
        } else {
            System.out.println("Save cancelled");
        }
    }

    @FXML
    public void handleLoadClick() {
        System.out.println("Loading file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Load Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showOpenDialog(saveButton.getScene().getWindow());
        if (file != null) {
            System.out.println("File loaded as: " + file.getPath());
        } else {
            System.out.println("Load cancelled");
        }
    }

    @FXML
    public void handlePresentClick() {
        System.out.println("Presentation!!!");
    }

    @FXML
    public void handlePreviewClick() {
        System.out.println("Preview!!!");
    }

    @FXML
    public void handleAttributesClick() {
        System.out.println("Attributes!!!");
    }

    @FXML
    public void handleSettingsClick() {
        System.out.println("Settings!!!");
    }

    @FXML
    public void handleTransitionsClick() {
        System.out.println("Transitions!!!");
    }

    @FXML
    public void handleInterpolationsClick() {
        System.out.println("Interpolations!!!");
    }

    @FXML
    public void handleCameraClick() {
        System.out.println("Camera!!!");
    }
}
