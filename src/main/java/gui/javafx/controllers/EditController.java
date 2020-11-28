package gui.javafx.controllers;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import app.model.Sheet;
import app.model.attributes.AttributeLabel;
import app.model.objects.ObjectType;
import app.utility.PropertyName;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.views.EditView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 *  This is Editcontroller class which controlls the view and observes the model.
 */

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

    /**
    * This sub-routine is used to update the view.  
    */    
    public void initialize() {
        this.model = Entry.model;
        this.view = new EditView();
        updateStates(model.getSheetSize());
        model.addPropertyChangeListener(this);

        pane.getChildren().clear();
        pane.getChildren().add(view);
        view.widthProperty().bind(pane.widthProperty());
        view.heightProperty().bind(pane.heightProperty());
        
        line.getProperties().put("name", ObjectType.LINE.getType());
        image.getProperties().put("name", ObjectType.IMAGE.getType());
        circle.getProperties().put("name", ObjectType.CIRCLE.getType());
        text.getProperties().put("name", ObjectType.PLAIN_TEXT.getType());
        content.getProperties().put("name", ObjectType.TEXT_AREA.getType());
        rectangle.getProperties().put("name", ObjectType.RECTANGLE.getType());
    }

    /**
    * This sub-routine handle the saving of sheet. 
     */
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


    /**
    * This sub-routine handle the loading of sheet from the desktop. 
    */
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

    /**
    * This sub-routine is used to switch to presentation mode. 
    */
    @FXML
    public void handlePresentClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = new File("src/main/java/gui/javafx/fxml/presentation_mode.fxml").toURI().toURL();

        Parent root = fxmlLoader.load(url);
        Scene scene = new Scene(root);
        scene.setCursor(Cursor.NONE);
        stage.setScene(scene);

        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }

    /**
    * This sub-routine is used to preview. 
    */
    @FXML
    private void handlePreviewClick() {
        // interactor.logger("Preview!!!");
    }

    @FXML
    private void handleSettingsClick() {
        // interactor.logger("Settings!!!");
    }

     /**
    * This sub-routine handle . 
    */
    @FXML
    private void handleTransitionsClick() {
        // interactor.logger("Transitions!!!");
    }

    /**
    * This sub-routine is offeres the multiple modes of interpolation to user . 
    */
    @FXML
    public void handleInterpolationsClick() {
        // interactor.logger("Interpolations!!!");
    }

    /**
    * This sub-routine handle the camara. 
    */
    @FXML
    private void handleCameraClick() {
        // interactor.logger("Camera!!!");
    }

    /**
    * This sub-routine is used to add the state. 
    */
    @FXML
    private void handleAddClick() {
        model.addState(null);
        view.update();
    }

    /**
    * This sub-routine hadles the drag event. 
    */
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

    /**
     * This sub-routine is used to change the cursor when cursor on any object. 
    */
    @FXML
    private void handleMouseEntered(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.OPEN_HAND);
    }

    /**
    * This sub-routine is used to exit from the change. 
    */
    @FXML
    private void handleMouseExited(MouseEvent event) {
        ((Node) event.getSource()).setCursor(Cursor.DEFAULT);
    }

    /**
    * This sub-routine is used to update the view. 
    * @param size. 
    */
    public void updateStates(int size) {
        bar.getChildren().clear();
        int activeState = model.getCurrentStateIndex();
        
        for (int i = 0; i < size; i++) {
            Button node = new Button(String.valueOf(i + 1));

            final int index = i;
            if (index == activeState) {
                node.setStyle("-fx-font-size:9; -fx-background-color: #add8e6");
                node.requestFocus();
            } else {
                node.setStyle("-fx-font-size:9");
            }

            bar.getChildren().add(node);
            ContextMenu menu = new ContextMenu();
            MenuItem delete = new MenuItem("Delete");
            MenuItem replicate = new MenuItem("Replicate");

            replicate.setOnAction((ActionEvent e) -> {
                model.replicateState(index);
            });

            delete.setOnAction((ActionEvent e) -> {
                model.removeState(index);
                updateStates(model.getSheetSize());
            });

            menu.getItems().add(replicate);
            menu.getItems().add(delete);

            node.setOnMousePressed(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    menu.show(node, e.getScreenX(), e.getScreenY());
                }
            });

            node.setOnAction(e -> {
                model.setCurrentStateIndex(index);
                updateStates(model.getSheetSize());
            });
            
            view.update();
            changes.getChildren().clear();
        }
    }

    /**
    * This sub-routine is used to show Attributes of the clicked object. 
    * @param id. 
    */
    public void showAttributes(int id) {
        
        var wrapper = new Object(){
            double i;
            double j;
            String iKey; 
            String jKey;      
        };

        int position = 1;
        Label label = new Label("Transitions");
        label.setStyle("-fx-font-weight:bold; -fx-font-size:15");

        changes.getChildren().clear();
        Transform transform = view.getTransform();
        Map<String, String> attr = model.getObjectAttributes(id);

        changes.add(label, 0, position++, 2, 1);
        changes.add(new Label(), 0, position++, 2, 1);
        attr.computeIfPresent(AttributeLabel.X_POSITION.getLabel(), (k, v) -> {
            wrapper.i = Double.parseDouble(v);
            wrapper.iKey = k;
            return null;
        });

        attr.computeIfPresent(AttributeLabel.Y_POSITION.getLabel(), (k, v) -> {
            wrapper.j = Double.parseDouble(v);
            wrapper.jKey = k;
            return null;
        });
        
        
        Point2D p = transform.viewToWorld(wrapper.i, wrapper.j);
        if (attr.containsKey(AttributeLabel.STROKE_COLOR.getLabel())) {
            String key = AttributeLabel.STROKE_COLOR.getLabel();
            addColor(key, attr.get(key), position);
            attr.remove(key);
            position++;
        } if (attr.containsKey(AttributeLabel.FILL_COLOR.getLabel())) {
            String key = AttributeLabel.FILL_COLOR.getLabel();
            addColor(key, attr.get(key), position);
            attr.remove(key);
            position++;
        }         
        
        addText(wrapper.iKey, String.valueOf(p.getX()), position++);
        addText(wrapper.jKey, String.valueOf(p.getY()), position++);

        if (attr.containsKey(AttributeLabel.Y_POSITION.getLabel())) {
            String key = AttributeLabel.Y_POSITION.getLabel();
            addText(key, attr.get(key), position);
            attr.remove(key);
            position++;
        }
        
        for (Map.Entry<String, String> entry : attr.entrySet()) {
            addText(entry.getKey(), entry.getValue(), position);
            position++;
        }
    }

    /**
    * This sub-routine is allow a user to change the color of an existing object. 
    * @param size,value,position. 
    */
    public void addColor(String key, String value, int position) {
        Map<String, String> attr = new HashMap<>();
        ColorPicker color = new ColorPicker(Color.web(value));
        color.setStyle("-fx-color-label-visible:false;");
        color.setOnAction(e -> {
            attr.put(key, color.getValue().toString());

            model.updateObject(model.getCurrentObjectId(), attr);
            
            view.update();
        });

        changes.add(new Label(key), 0, position, 1, 1);
        changes.add(color, 1, position, 1, 1);
    }

    /**
    * This sub-routine is allow user to displaying and changing of attribute. 
    * @param key : return the key.
    * @param value : return the value.
    * @param position : return the position.
    */
    public void addText(String key, String value, int position) {
        Map<String, String> attr = new HashMap<>();
        TextField textField = new TextField(value);
        textField.setStyle("-fx-color-label-visible:false;");
        textField.textProperty().addListener((e, old, text) -> {
            textField.setText(" ".trim().equals(text.trim()) ? "0" : text.trim());
            attr.put(key, textField.getText());

            model.updateObject(model.getCurrentObjectId(), attr);            
            view.update();
        });

        changes.add(new Label(key), 0, position, 1, 1);
        changes.add(textField, 1, position, 1, 1);
    }

    /**
     * This Sub-routine handle.
     * @param :event
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (PropertyName.STATES.getName().equals(event.getPropertyName())) {
            updateStates((int) event.getNewValue());
        } else if (PropertyName.ATTRIBUTES.getName().equals(event.getPropertyName())) {
            showAttributes((int) event.getNewValue());
        } else if (PropertyName.OBJECTID.getName().equals(event.getPropertyName())) {
            if ((int) event.getNewValue() == 0) {
                changes.getChildren().clear();
            }
        }
    }
}
