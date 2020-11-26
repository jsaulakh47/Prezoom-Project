package gui.javafx;

import java.util.HashMap;
import java.util.Map;

import app.model.attributes.AttributeLabel;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

public class ShapeUtility {
    public static void addLable(GridPane pane, Node node, String value, int position) {
        pane.add(new Label(value), 0, position, 1, 1);
        node.getProperties().put("name", value);
        pane.add(node, 1, position, 1, 1);
    }
    public static void addFillColor(GridPane pane, Shape shape, int position) {
        ColorPicker fill = new ColorPicker((Color) shape.getFill());
        fill.setStyle("-fx-color-label-visible: false ;");
        fill.setOnAction(e -> {
            shape.setFill(fill.getValue());
        });

        fill.setStyle("-fx-color-label-visible: false ;");
        addLable(pane, fill, AttributeLabel.FILL_COLOR.getLabel(), position);
    }

    public static void addStrokeColor(GridPane pane, Shape shape, int position) {
        ColorPicker stroke = new ColorPicker((Color) shape.getStroke());
        stroke.setStyle("-fx-color-label-visible:false;");
        stroke.setOnAction(e -> {
            shape.setStroke(stroke.getValue());
        });

        stroke.setStyle("-fx-color-label-visible:false;");
        addLable(pane, stroke, AttributeLabel.STROKE_COLOR.getLabel(), position);
    }

    public static void addStrokeWidth(GridPane pane, Shape shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getStrokeWidth()));
        textField.setOnAction(e -> {
            shape.setStrokeWidth(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.STROKE_WIDTH.getLabel(), position);
    }

    public static void addRectangleX(GridPane pane, Rectangle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getX()));
        textField.setOnAction(e -> {
            shape.setX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.X_POSITION.getLabel(), position);
    }

    public static void addRectangleY(GridPane pane, Rectangle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getY()));
        textField.setOnAction(e -> {
            shape.setY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.Y_POSITION.getLabel(), position);
    }

    public static void addRectangleWidth(GridPane pane, Rectangle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getWidth()));
        textField.setOnAction(e -> {
            shape.setWidth(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.WIDTH.getLabel(), position);
    }

    public static void addRectangleHeight(GridPane pane, Rectangle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getHeight()));
        textField.setOnAction(e -> {
            shape.setHeight(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.HEIGHT.getLabel(), position);
    }

    public static void addCircleX(GridPane pane, Circle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getCenterX()));
        textField.setOnAction(e -> {
            shape.setCenterX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.X_POSITION.getLabel(), position);
    }

    public static void addCircleY(GridPane pane, Circle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getCenterY()));
        textField.setOnAction(e -> {
            shape.setCenterY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.Y_POSITION.getLabel(), position);
    }

    public static void addCircleRadius(GridPane pane, Circle shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getRadius()));
        textField.setOnAction(e -> {
            shape.setRadius(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.RADIUS.getLabel(), position);
    }

    public static void addImageX(GridPane pane, ImageView shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getX()));
        textField.setOnAction(e -> {
            shape.setX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.X_POSITION.getLabel(), position);
    }

    public static void addImageY(GridPane pane, ImageView shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getY()));
        textField.setOnAction(e -> {
            shape.setY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.Y_POSITION.getLabel(), position);
    }

    public static void addImageWidth(GridPane pane, ImageView shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getFitWidth()));
        textField.setOnAction(e -> {
            shape.setFitWidth(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.WIDTH.getLabel(), position);
    }

    public static void addImageHeight(GridPane pane, ImageView shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getFitHeight()));
        textField.setOnAction(e -> {
            shape.setFitHeight(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.HEIGHT.getLabel(), position);
    }

    public static void addTextX(GridPane pane, Text shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getX()));
        textField.setOnAction(e -> {
            shape.setX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.X_POSITION.getLabel(), position);
    }

    public static void addTextY(GridPane pane, Text shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getY()));
        textField.setOnAction(e -> {
            shape.setY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.Y_POSITION.getLabel(), position);
    }

    public static void addTextText(GridPane pane, Text shape, int position) {
        TextField textField = new TextField(shape.getText());
        textField.setOnAction(e -> {
            shape.setText(textField.getText());
        });

        addLable(pane, textField, AttributeLabel.TEXT.getLabel(), position);
    }

    public static void addLineStartX(GridPane pane, Line shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getStartX()));
        textField.setOnAction(e -> {
            shape.setStartX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.X_POSITION.getLabel(), position);
    }

    public static void addLineStartY(GridPane pane, Line shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getStartY()));
        textField.setOnAction(e -> {
            shape.setStartY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.Y_POSITION.getLabel(), position);
    }

    public static void addLineEndX(GridPane pane, Line shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getEndX()));
        textField.setOnAction(e -> {
            shape.setEndX(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.END_X.getLabel(), position);
    }

    public static void addLineEndY(GridPane pane, Line shape, int position) {
        TextField textField = new TextField(String.valueOf(shape.getEndY()));
        textField.setOnAction(e -> {
            shape.setEndY(Double.parseDouble(textField.getText()));
        });

        addLable(pane, textField, AttributeLabel.END_Y.getLabel(), position);
    }

    public static Map<String, String> getRectangleProperties(Rectangle node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getX(), node.getY());
        attributes.put(AttributeLabel.WIDTH.getLabel(), String.valueOf(node.getWidth()));
        attributes.put(AttributeLabel.HEIGHT.getLabel(), String.valueOf(node.getHeight()));
        strokeFill(attributes, node);

        return attributes;
    }

    public static Map<String, String> getCircleProperties(Circle node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getCenterX(), node.getCenterY());
        attributes.put(AttributeLabel.RADIUS.getLabel(), String.valueOf(node.getRadius()));
        strokeFill(attributes, node);

        return attributes;
    }

    public static Map<String, String> getImageProperties(ImageView node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getX(), node.getY());
        attributes.put(AttributeLabel.WIDTH.getLabel(), String.valueOf(node.getFitWidth()));
        attributes.put(AttributeLabel.HEIGHT.getLabel(), String.valueOf(node.getFitHeight()));

        return attributes;
    }

    public static Map<String, String> getLineProperties(Line node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getStartX(), node.getStartY());
        attributes.put(AttributeLabel.END_X.getLabel(), String.valueOf(node.getEndX()));
        attributes.put(AttributeLabel.END_Y.getLabel(), String.valueOf(node.getEndY()));
        strokeFill(attributes, node);

        return attributes;
    }

    public static Map<String, String> getTextProperties(Text node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getX(), node.getY());
        attributes.put(AttributeLabel.TEXT.getLabel(), String.valueOf(node.getText()));
        ShapeUtility.strokeFill(attributes, node);

        return attributes;
    }

    public static Map<String, String> getTextAreaProperties(Pane node) {
        Map<String, String> attributes = new HashMap<String, String>();

        ShapeUtility.postion(attributes, node.getScene().getX(), node.getScene().getY());
        attributes.put(AttributeLabel.WIDTH.getLabel(), String.valueOf(node.getWidth()));
        attributes.put(AttributeLabel.HEIGHT.getLabel(), String.valueOf(node.getHeight()));
        attributes.put(AttributeLabel.TEXT.getLabel(), ((TextArea) node.getChildren().get(0)).getText());
        
        return attributes;
    }

    public static Map<String, String> strokeFill(Map<String, String> attributes, Shape node) {
        attributes.put(AttributeLabel.FILL_COLOR.getLabel(), String.valueOf(node.getFill()));
        attributes.put(AttributeLabel.STROKE_COLOR.getLabel(), String.valueOf(node.getStroke()));
        attributes.put(AttributeLabel.STROKE_WIDTH.getLabel(), String.valueOf(node.getStrokeWidth()));

        return attributes;
    }

    public static Map<String, String> postion(Map<String, String> attributes, double X, double Y) {
        attributes.put(AttributeLabel.X_POSITION.getLabel(), String.valueOf(X));
        attributes.put(AttributeLabel.Y_POSITION.getLabel(), String.valueOf(Y));

        return attributes;
    }
}
