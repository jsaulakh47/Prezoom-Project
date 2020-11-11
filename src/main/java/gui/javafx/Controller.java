package gui.javafx;

import java.io.File;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {
    private GraphicsContext context;

    @FXML
    private Canvas canvas;

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

    @FXML
    private Rectangle rectangle;

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    @FXML
    private Text text;

    @FXML
    private TextArea textArea;

    @FXML
    private ImageView image;


    public void initialize() {
        canvas.heightProperty().bind(canvasPane.heightProperty());
        canvas.widthProperty().bind(canvasPane.widthProperty());
        context = canvas.getGraphicsContext2D();
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
    private void handlePreviewClick() {
        logger("Preview!!!");
    }

    @FXML
    private void handleAttributesClick() {
        logger("Attributes!!!");
    }

    @FXML
    private void handleSettingsClick() {
        logger("Settings!!!");
    }

    @FXML
    private void handleTransitionsClick() {
        logger("Transitions!!!");
    }

    @FXML
    public void handleInterpolationsClick() {
        logger("Interpolations!!!");
    }

    @FXML
    private void handleCameraClick() {
        logger("Camera!!!");
    }

    @FXML
    private void handleAddClick() {
        logger("add State!!!");
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {
        String object = event.getSource().getClass().getSimpleName();
        logger(object + " selected");

        Dragboard dragboard = rectangle.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cc = new ClipboardContent();
        cc.putString(object);

        dragboard.setContent(cc);
        event.consume();
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
        event.consume();
    }

    @FXML
    private void handleDragDrop(DragEvent event) {
        logger(event.getDragboard().getString() + " created");
        // context.fillRect(event.getX(), event.getY(), 50.0, 50.0);
    }

    public void logger(String value) {
        System.out.println(value);
        rightStatus.setText(value);
    }
}
