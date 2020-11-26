package gui.javafx.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;

import app.model.Sheet;
import gui.javafx.views.EditView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditController implements PropertyChangeListener {
    private Sheet model;
    private EditView view;

    @FXML
    private Pane pane;

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
        this.model = new Sheet();
        this.view = new EditView(model);
        this.model.addPropertyChangeListener(this);

        this.model.addState();
        pane.getChildren().clear();
        pane.getChildren().add(this.view);

        line.getProperties().put("name", "Line");
        text.getProperties().put("name", "Text");
        image.getProperties().put("name", "Image");
        circle.getProperties().put("name", "Circle");
        content.getProperties().put("name", "TextArea");
        rectangle.getProperties().put("name", "Rectangle");
    }

    @FXML
    public void handleSaveClick() {
        // interactor.logger("Saving file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text", "*.alpha"));

        File file = chooser.showSaveDialog(saveButton.getScene().getWindow());
        if (file != null) {
            // interactor.logger("File saved as: " + file.getPath());
        } else {
            // interactor.logger("Save cancelled");
        }
    }

    @FXML
    public void handleLoadClick() {
        // interactor.logger("Loading file");
        FileChooser chooser = new FileChooser();

        chooser.setTitle("Load Application File");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text", "*.alpha"));

        File file = chooser.showOpenDialog(saveButton.getScene().getWindow());
        if (file != null) {
            // interactor.logger("File loaded as: " + file.getPath());
        } else {
            // interactor.logger("Load cancelled");
        }
    }

    @FXML
    public void handlePresentClick() throws Exception {
        Stage stage = new Stage();

        URL url = new File("src/main/java/gui/javafx/fxml/presentation_mode.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    private void handlePreviewClick() {
        // interactor.logger("Preview!!!");
    }

    @FXML
    private void handleSettingsClick() {
        // interactor.logger("Settings!!!");
    }

    @FXML
    private void handleTransitionsClick() {
        // interactor.logger("Transitions!!!");
    }

    @FXML
    public void handleInterpolationsClick() {
        // interactor.logger("Interpolations!!!");
    }

    @FXML
    private void handleCameraClick() {
        // interactor.logger("Camera!!!");
    }

    @FXML
    private void handleAddClick() {
        this.model.addState();
    }

    @FXML
    private void handleDragDetected(MouseEvent event) {
        Node node = (Node) event.getSource();
        String object = node.getProperties().get("name").toString();

        // interactor.logger(object + " selected");
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
    private void handleMouseEntered(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.OPEN_HAND);
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.DEFAULT);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        bar.getChildren().clear();
        for (int i = 0; i < (int) event.getNewValue(); i++) {
            String text = String.valueOf(i + 1);

            Button node = new Button();
            node.setStyle("-fx-background-color:#f5f5f5");
            node.setStyle("-fx-font-size:9");
            node.setText(text);
       
            node.getProperties().put("id", String.valueOf(i));
            bar.getChildren().add(node);
        
            ContextMenu menu = new ContextMenu();
            MenuItem delete = new MenuItem("Delete");
            MenuItem replicate = new MenuItem("Replicate");

            final int index = i;
            replicate.setOnAction((ActionEvent e) -> {
                this.model.replicateState(index);
            });

            delete.setOnAction((ActionEvent e) -> {
                this.model.removeState(index);
            });

            menu.getItems().add(replicate);
            menu.getItems().add(delete);

            node.setOnMousePressed(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    menu.show(node, e.getScreenX(), e.getScreenY());
                }
            });
        }
    }
}
