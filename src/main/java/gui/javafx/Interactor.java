package gui.javafx;

import java.io.File;
import java.util.List;
import java.util.Map;

import app.api.Interaction;
import app.model.objects.Objects;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
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
    public int state;
    private int current;
    private Label status;

    private Pane pane;
    private GridPane changes;

    public Interactor(Label status, GridPane changes, Pane pane) {
        this.changes = changes;
        this.status = status;
        this.pane = pane;
        this.current = 0;
        this.state = 0;
    }

    public void createObject(String type, double x, double y) {
        Objects attr = Interaction.createObject(type, current, String.valueOf(x), String.valueOf(y));
        
        Node node = creator(type, attr, x, y);

        node.setOnMouseEntered(e -> {
            node.setCursor(Cursor.OPEN_HAND);
        });

        node.setOnMouseExited(e -> {
            node.setCursor(Cursor.DEFAULT);
        });

        pane.getChildren().add(node);
        addContextMenu(node);
    }

    public Node creator (String type, Objects attr, double x, double y) {
        Node node;
        if ("Circle".equals(type)) {
            node = createCircle(attr.getAttributes(), x, y);
        } else if ("Image".equals(type)) {
            node = createImage(attr.getAttributes(), x, y);
        } else if ("Line".equals(type)) {
            node = createLine(attr.getAttributes(), x, y);
        } else if ("Text".equals(type)) {
            node = createText(attr.getAttributes(), x, y);
        } else if ("TextArea".equals(type)) {
            node = createTextArea(attr.getAttributes(), x, y);
        } else {
            node = createRectangle(attr.getAttributes(), x, y);
        }

        node.getProperties().put("object_id", attr.getId());
        node.getProperties().put("state_id", current);

        return node;
    }

    public Node createRectangle(Map<String, String> attr, double X, double Y) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(X);
        rectangle.setY(Y);
        rectangle.setWidth(Double.parseDouble(attr.get("Width")));
        rectangle.setHeight(Double.parseDouble(attr.get("Height")));

        rectangle.setFill(Color.web(attr.get("Fill color")));
        rectangle.setStroke(Color.web(attr.get("Stroke color")));
    
        rectangle.setOnMouseDragged(e -> {
            rectangle.setX(e.getX() - rectangle.getWidth() / 2);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2);
        });

        rectangle.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                rectangle.requestFocus();
                logger("Rectangle selected");
                changes.getChildren().clear();
                
                ShapeUtility.addFillColor(changes, rectangle, 1);
                ShapeUtility.addStrokeColor(changes, rectangle, 2);
                ShapeUtility.addRectangleX(changes, rectangle, 3);
                ShapeUtility.addRectangleY(changes, rectangle, 4);
                ShapeUtility.addRectangleWidth(changes, rectangle, 5);
                ShapeUtility.addRectangleHeight(changes, rectangle, 6);
            }
        });

        rectangle.getProperties().put("name", "Rectangle");
        return (Node) rectangle;
    }


    public Node createCircle(Map<String, String> attr, double X, double Y) {
        Circle circle = new Circle();
        circle.setCenterX(X);
        circle.setCenterY(Y);
        circle.setRadius(Double.parseDouble(attr.get("Radius")));

        circle.setFill(Color.web(attr.get("Fill color")));
        circle.setStroke(Color.web(attr.get("Stroke color")));

        circle.setOnMouseDragged(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());            
        });
        
        circle.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                circle.requestFocus();
                logger("Circle selected");
                changes.getChildren().clear();
                
                ShapeUtility.addFillColor(changes, circle, 1);
                ShapeUtility.addStrokeColor(changes, circle, 2);
                ShapeUtility.addCircleX(changes, circle, 3);
                ShapeUtility.addCircleY(changes, circle, 4);
                ShapeUtility.addCircleRadius(changes, circle, 5);
            }
        });

        circle.getProperties().put("name", "Circle");
        return (Node) circle;
    }

    public Node createImage(Map<String, String> attr, double X, double Y) {
        Image file = new Image((new File(attr.get("Source"))).toURI().toString());

        ImageView image = new ImageView();
        image.setFitHeight(Double.parseDouble(attr.get("Height")));
        image.setFitWidth(Double.parseDouble(attr.get("Width")));
        image.setImage(file);
        image.setX(X);
        image.setY(Y);

        image.setOnMouseDragged(e -> {
            image.setX(e.getX() - image.getFitWidth() / 2);
            image.setY(e.getY() - image.getFitHeight() / 2);
        });

        image.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                image.requestFocus();
                logger("Image selected");
                changes.getChildren().clear();
                
                ShapeUtility.addImageX(changes, image, 1);
                ShapeUtility.addImageY(changes, image, 2);
                ShapeUtility.addImageWidth(changes, image, 3);
                ShapeUtility.addImageHeight(changes, image, 4);
            }
        });

        image.getProperties().put("name", "Image");
        return (Node) image;
    }

    public Node createLine(Map<String, String> attr, double X, double Y) {
        Line line = new Line();
        line.setStartX(X);
        line.setStartY(Y);
        line.setEndX(Double.parseDouble(attr.get("End X")));
        line.setEndY(Double.parseDouble(attr.get("End Y")));
        line.setFill(Color.web(attr.get("Fill color")));
        line.setStroke(Color.web(attr.get("Stroke color")));

        line.setOnMouseDragged(e -> {
            line.setTranslateX(e.getX() - Math.abs((line.getEndX() - line.getStartX()) / 2));
            line.setTranslateY(e.getY() - Math.abs((line.getEndY() - line.getStartY()) / 2));
        });

        line.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                line.requestFocus();
                logger("Line selected");
                changes.getChildren().clear();
                
                ShapeUtility.addFillColor(changes, line, 1);
                ShapeUtility.addStrokeColor(changes, line, 2);
                ShapeUtility.addLineStartX(changes, line, 3);
                ShapeUtility.addLineStartY(changes, line, 4);
                ShapeUtility.addLineEndX(changes, line, 5);
                ShapeUtility.addLineEndY(changes, line, 6);
            }
        });
        
        line.getProperties().put("name", "Line");
        return (Node) line;
    }

    public Node createText(Map<String, String> attr, double X, double Y) {
        Text text = new Text();
        text.setX(X);
        text.setY(Y);
        text.setText(attr.get("Text"));
        text.setFill(Color.web(attr.get("Fill color")));
        text.setStroke(Color.web(attr.get("Stroke color")));

        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        text.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                text.requestFocus();
                logger("Text selected");
                changes.getChildren().clear();
                
                ShapeUtility.addFillColor(changes, text, 1);
                ShapeUtility.addStrokeColor(changes, text, 2);
                ShapeUtility.addTextX(changes, text, 3);
                ShapeUtility.addTextY(changes, text, 4);
                ShapeUtility.addTextText(changes, text, 5);
            }
        });

        text.getProperties().put("name", "Text");
        return (Node) text;
    }

    public Node createTextArea(Map<String, String> attr, double X, double Y) {
        Pane pane = new Pane();
        TextArea textArea = new TextArea();

        textArea.setWrapText(true);
        textArea.setMaxSize(300.0, 150.0);
        pane.getChildren().addAll(textArea);

        pane.setOnMouseDragged(e -> {

            // double offsetX = e.getSceneX() - orgSceneX;
            // double offsetY = e.getSceneY() - orgSceneY;
            // double newTranslateX = orgTranslateX + offsetX;
            // double newTranslateY = orgTranslateY + offsetY;

            // textarea.setXe;
            // textarea.setTranslateY(newTranslateY);
        });

        textArea.getProperties().put("name", "TextArea");
        return pane;
    }

    public void addContextMenu(Node node)
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
            pane.getChildren().remove(node);
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
        ++state;
        current = state;
        Interaction.addState();
        Button node = new Button();
        node.setStyle("-fx-background-color:#f5f5f5");
        node.setStyle("-fx-font-size:9");

        if (parent.getChildren().size() == 0) {
            node.setText("1");
        } else {
            String id = String.valueOf(parent.getChildren().size() + 1);
            node.setText(String.valueOf(id));
        }
       
        node.getProperties().put("id", String.valueOf(state));
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

        if (pane.getChildren().size() > 0) {
            for (Node child : pane.getChildren()) {
                saveObject(child);
            }
        }

        pane.getChildren().clear();
        changes.getChildren().clear();

        node.setOnAction(e -> {
            if (pane.getChildren().size() > 0) {
                for (Node child : pane.getChildren()) {
                    saveObject(child);
                }
            }

            pane.getChildren().clear();
            changes.getChildren().clear();

            current = Integer.parseInt(node.getProperties().get("id").toString());
            List<Objects> shapes = Interaction.loadState(current);

            if (shapes.size() > 0) {
                for (Objects shape : shapes) {
                    double x = Double.parseDouble(shape.getAttributes().get("X position"));
                    double y = Double.parseDouble(shape.getAttributes().get("Y position"));
                    Node object = creator(shape.getType(), shape, x, y);
                    pane.getChildren().add(object);
                }
            }
            logger("Sheet " + node.getText() + " loaded");
        });
    }

    public void saveObject(Node object) {
        int objectId = Integer.parseInt(object.getProperties().get("object_id").toString());
        int stateId = Integer.parseInt(object.getProperties().get("state_id").toString());
        String type = object.getProperties().get("name").toString();
        Map<String, String> attr;

        if ("Circle".equals(type)) {
            attr = ShapeUtility.getCircleProperties((Circle) object);
        } else if ("Image".equals(type)) {
            attr = ShapeUtility.getImageProperties((ImageView) object);
        } else if ("Line".equals(type)) {
            attr = ShapeUtility.getLineProperties((Line) object);
        } else if ("Text".equals(type)) {
            attr = ShapeUtility.getTextProperties((Text) object);
        } else if ("TextArea".equals(type)) {
            attr = ShapeUtility.getTextAreaProperties((Text) object);
        } else {
            attr = ShapeUtility.getRectangleProperties((Rectangle) object);
        }

        Interaction.saveObject(stateId, objectId, attr);
    }
    
    public void logger(String value) {
        System.out.println(value);
        status.setText(value);
    }
}
