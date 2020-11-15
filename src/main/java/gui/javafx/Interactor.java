package gui.javafx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicComboBoxUI.FocusHandler;

import app.api.Interaction;
import app.model.States;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Interactor {
    private List<States> states;

    private Label status;

    private GridPane changes;

    public Interactor(Label status, GridPane changes) {
        this.states = new ArrayList<States>();
        this.changes = changes;
        this.status = status;
    }

    public Node createObject(String type) {
        Node node;
        
        if ("Circle".equals(type)) {
            node = createCircle();
        } else if ("ImageView".equals(type)) {
            node = createImage();
        } else if ("Line".equals(type)) {
            node = createLine();
        } else if ("Text".equals(type)) {
            node = createText();
        }  else if ("Pane".equals(type)) {
            node = createTextArea();
        } else {
            node = createRectangle();
        }

        node.setOnMouseEntered(e -> {
            node.setCursor(Cursor.OPEN_HAND);
        });

        node.setOnMouseExited(e -> {
            node.setCursor(Cursor.DEFAULT);
        });

        return node;
    }

    public Node createRectangle() {
        Map<String, String> attr = Interaction.createObject("Rectangle", "10", "10");

        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
    
        rectangle.setOnMouseDragged(e -> {
            rectangle.setX(e.getX() - rectangle.getWidth() / 2);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2);
        });

        rectangle.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                logger("Rectangle selected");
                rectangle.requestFocus();
                
                ShapeUtility.addFillColor(changes, rectangle, 0);
                ShapeUtility.addStrokeColor(changes, rectangle, 1);
            }
        });

        return (Node) rectangle;
    }


    public Node createCircle() {
        Circle circle = new Circle(20, Color.RED);

        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());            
        });

        circle.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                logger("Circle selected");
                circle.requestFocus();
                
                ShapeUtility.addFillColor(changes, circle, 0);
                ShapeUtility.addStrokeColor(changes, circle, 1);
            }
        });

        return (Node) circle;
    }

    public Node createImage() {
        File file = new File("src/main/resources/img-icon.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setImage(image);

        imageView.setOnMouseDragged(e -> {
            imageView.setX(e.getX() - imageView.getFitWidth() / 2);
            imageView.setY(e.getY() - imageView.getFitHeight() / 2);
        });

        return (Node) imageView;
    }

    public Node createLine() {
        Line line = new Line(100, 100, 200, 200);

        line.setOnMouseDragged(e -> {
            line.setTranslateX(e.getX() - Math.abs((line.getEndX() - line.getStartX()) / 2));
            line.setTranslateY(e.getY() - Math.abs((line.getEndY() - line.getStartY()) / 2));
        });

        return (Node) line;
    }

    public Node createText() {
        Text text = new Text("Text");

        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        return (Node) text;
    }

    public Node createTextArea() {
        Pane pane = new Pane();
        TextArea textArea = new TextArea();

        textArea.setWrapText(true);
        textArea.setMaxSize(300.0, 150.0);
        pane.getChildren().addAll(textArea);

        pane.setOnMouseDragged(e -> {

            System.out.println("is dragged");

            // double offsetX = e.getSceneX() - orgSceneX;
            // double offsetY = e.getSceneY() - orgSceneY;
            // double newTranslateX = orgTranslateX + offsetX;
            // double newTranslateY = orgTranslateY + offsetY;

            // textarea.setXe;
            // textarea.setTranslateY(newTranslateY);
        });

        return pane;
    }

    public void addContextMenu(Node node, Pane parent)
    {
        ContextMenu menu = new ContextMenu();

        MenuItem interpolation = new MenuItem("Interpolation");
        MenuItem attributes = new MenuItem("Attributes");
        MenuItem delete = new MenuItem("Delete");

        interpolation.setOnAction((ActionEvent e) -> {
            logger("Work in progress");
        });
        
        attributes.setOnAction((ActionEvent e) -> {
            logger("Work in progress");
        });

        delete.setOnAction((ActionEvent e) -> {
            parent.getChildren().remove(node);
        });

        menu.getItems().addAll(interpolation, attributes, delete);

        node.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                logger("Right click detected");
                menu.show(node, e.getScreenX(), e.getScreenY());
            }
        });
    }
    
    public void addStateButton(Pane parent)
    { 
        Button node = new Button();
        node.setStyle("-fx-background-color:#f5f5f5");
        node.setStyle("-fx-font-size:9");

        if (parent.getChildren().size() == 0) {
            node.getProperties().put("id", "1");
            node.setText("1");
        } else {
            String id = String.valueOf(parent.getChildren().size() + 1);
            node.getProperties().put("id", id);
            node.setText(String.valueOf(id));
        }
       
        parent.getChildren().add(node);

        ContextMenu menu = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");

        delete.setOnAction((ActionEvent e) -> {
            parent.getChildren().remove(node);
        });

        menu.getItems().add(delete);

        node.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                logger("Right click detected");
                menu.show(node, e.getScreenX(), e.getScreenY());
            }
        });
    }
    
    public void logger(String value) {
        System.out.println(value);
        status.setText(value);
    }
}
