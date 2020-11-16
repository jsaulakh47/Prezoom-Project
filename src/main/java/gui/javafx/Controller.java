package gui.javafx;

import java.io.File;

import app.model.attributes.TextArea;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    private Button transitionsButton;

    @FXML
    private Button interpolationsButton;

    @FXML
    private ImageView addButton;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;

    @FXML
    private HBox bar;

    @FXML
    private GridPane changes;

    // Shapes
    @FXML
    private Rectangle rectangle;
    
    @FXML
    private Circle circle;

    @FXML
    private ImageView image;

    @FXML
    private Text text;

    @FXML
    private Line line;

    @FXML
    private Pane content;

    public void initialize() {
        Region region = (Region) canvasPane;
        Rectangle outputClip = new Rectangle();
        interactor = new Interactor(rightStatus, changes, canvasPane);

        outputClip.setArcWidth(1.0);
        outputClip.setArcHeight(1.0);
      
        region.setClip(outputClip);
        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });

        rectangle.getProperties().put("name", "Rectangle");
        content.getProperties().put("name", "TextArea");
        circle.getProperties().put("name", "Circle");
        image.getProperties().put("name", "Image");
        text.getProperties().put("name", "Text");
        line.getProperties().put("name", "Line");
        
        interactor.addStateButton(bar);
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
        interactor.addStateButton(bar);
        interactor.logger("State added");
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {
        Node node = (Node) event.getSource();
        String object = node.getProperties().get("name").toString();

        interactor.logger(object + " selected");
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
        interactor.createObject(object, event.getX(), event.getY());

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
