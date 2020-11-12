package gui.javafx;

import java.io.File;
import java.util.prefs.NodeChangeListener;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Interactor {
    private Label status;

    public Interactor(Label status) {
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

        node.setOnMouseEntered((MouseEvent e) -> {
            node.setCursor(Cursor.OPEN_HAND);
        });

        node.setOnMouseExited((MouseEvent e) -> {
            node.setCursor(Cursor.DEFAULT);
        });

        node.setOnMouseClicked((MouseEvent e) -> {
            if (e.getClickCount() == 2) {
                logger(type + " selected");
                node.setCursor(Cursor.CROSSHAIR);
                node.requestFocus();
                // node.ss
            }
        });

        return node;
    }

    public Node createRectangle() {
        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
    
        rectangle.setOnMouseDragged((MouseEvent e) -> {
            rectangle.setX(e.getX() - rectangle.getWidth() / 2);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2);
        });

        return (Node) rectangle;
    }


    public Node createCircle() {
        Circle circle = new Circle(20, Color.RED);

        circle.setOnMouseDragged((MouseEvent e) -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());            
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

        imageView.setOnMouseDragged((MouseEvent e) -> {
            imageView.setX(e.getX() - imageView.getFitWidth() / 2);
            imageView.setY(e.getY() - imageView.getFitHeight() / 2);
        });

        return (Node) imageView;
    }

    public Node createLine() {
        Line line = new Line(100, 100, 200, 200);

        line.setOnMouseDragged((MouseEvent e) -> {
            line.setTranslateX(e.getX() - Math.abs((line.getEndX() - line.getStartX()) / 2));
            line.setTranslateY(e.getY() - Math.abs((line.getEndY() - line.getStartY()) / 2));
        });

        return (Node) line;
    }

    public Node createText() {
        Text text = new Text("Text");

        text.setOnMouseDragged((MouseEvent e) -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        return (Node) text;
    }

    public Node createTextArea() {
        TextArea textArea = new TextArea();
        Pane pane = new Pane();
        textArea.setMaxSize(300.0, 150.0);
        pane.getChildren().addAll(textArea);

        pane.setOnMouseDragged((MouseEvent e) -> {

            System.out.println("is dragged");

            // double offsetX = e.getSceneX() - orgSceneX;
            // double offsetY = e.getSceneY() - orgSceneY;
            // double newTranslateX = orgTranslateX + offsetX;
            // double newTranslateY = orgTranslateY + offsetY;

            // textarea.setX(e);
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

        node.setOnMousePressed((MouseEvent e) -> {
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
