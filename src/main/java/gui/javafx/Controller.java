package gui.javafx;

import java.io.File;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {
    private Interactor interactor;

    @FXML 
    private Pane canvasPane;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private ImageView presentButton;

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
    private ImageView addButton;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;
    
    public void initialize() {
        interactor = new Interactor(rightStatus);
        Region region = (Region) canvasPane;

        final Rectangle outputClip = new Rectangle();

        outputClip.setArcWidth(1.0);
        outputClip.setArcHeight(1.0);
        region.setClip(outputClip);

        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });        
    }

    @FXML
    public void handleSaveClick() {
        interactor.logger("Saving file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showSaveDialog(saveButton.getScene().getWindow());
        if (file != null) {
            interactor.logger("File saved as: " + file.getPath());
        } else {
            interactor.logger("Save cancelled");
        }
    }

    @FXML
    public void handleLoadClick() {
        interactor.logger("Loading file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Load Application File");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text", "*.alpha")
        );

        File file = chooser.showOpenDialog(saveButton.getScene().getWindow());
        if (file != null) {
            interactor.logger("File loaded as: " + file.getPath());
        } else {
            interactor.logger("Load cancelled");
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
    private void handlePreviewClick() {
        interactor.logger("Preview!!!");
    }

    @FXML
    private void handleAttributesClick() {
        interactor.logger("Attributes!!!");
    }

    @FXML
    private void handleSettingsClick() {
        interactor.logger("Settings!!!");
    }

    @FXML
    private void handleTransitionsClick() {
        interactor.logger("Transitions!!!");
    }

    @FXML
    public void handleInterpolationsClick() {
        interactor.logger("Interpolations!!!");
    }

    @FXML
    private void handleCameraClick() {
        interactor.logger("Camera!!!");
    }

    @FXML
    private void handleAddClick() {
        interactor.logger("Add State!!!");
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {
        String object = event.getSource().getClass().getSimpleName();
        interactor.logger(object + " selected");

        Node node = (Node) event.getSource();
        Dragboard dragboard = node.startDragAndDrop(TransferMode.COPY);
        // SnapshotParameters snapshotParams = new SnapshotParameters();
        // WritableImage image = node.snapshot(snapshotParams, null);
        // dragboard.setDragView(image, event.getX(), event.getY());

        ClipboardContent cc = new ClipboardContent();
        cc.putString(object);

        dragboard.setContent(cc);
        event.consume();
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.ANY);
            event.consume();
        }
    }

    @FXML
    private void handleDragDrop(DragEvent event) {
        String object = event.getDragboard().getString();
        Node node = interactor.createObject(object);
        node.relocate(event.getX(), event.getY());
        canvasPane.getChildren().add(node);

        interactor.addContextMenu(node, canvasPane);
        interactor.logger(object + " created");
        event.setDropCompleted(true);
    }

    @FXML
    private void handleMouseEntered(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.OPEN_HAND);
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.DEFAULT);
    }
}
