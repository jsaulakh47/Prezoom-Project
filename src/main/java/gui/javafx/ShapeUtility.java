package gui.javafx;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ShapeUtility {
    public static void addFillColor(GridPane pane, Shape shape, int position) {
        ColorPicker fill = new ColorPicker((Color) shape.getFill());
        fill.setStyle("-fx-color-label-visible: false ;");
        fill.setOnAction(e -> {
            shape.setFill(fill.getValue());
        });

        fill.setStyle("-fx-color-label-visible: false ;");

        pane.add(new Label("Fill Color"), 0, position, 1, 1);
        pane.add(fill, 1, position, 1, 1);
    }

    public static void addStrokeColor(GridPane pane, Shape shape, int position) {
        ColorPicker stroke = new ColorPicker((Color) shape.getStroke());
        stroke.setStyle("-fx-color-label-visible:false;");
        stroke.setOnAction(e -> {
            shape.setStroke(stroke.getValue());
        });

        stroke.setStyle("-fx-color-label-visible:false;");

        pane.add(new Label("Stroke Color"), 0, position, 1, 1);
        pane.add(stroke, 1, position, 1, 1);
    }

    public static void addRectangleX(GridPane pane, Rectangle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setX(Double.parseDouble(textField.getText()));
        });
    }

    public static void addRectangleY(GridPane pane, Rectangle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setY(Double.parseDouble(textField.getText()));
        });
    }

    public static void addRectangleWidth(GridPane pane, Rectangle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setWidth(Double.parseDouble(textField.getText()));
        });
    }

    public static void addRectangleHeight(GridPane pane, Rectangle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setHeight(Double.parseDouble(textField.getText()));
        });
    }

    public static void addCircleX(GridPane pane, Circle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setCenterX(Double.parseDouble(textField.getText()));
        });
    }

    public static void addCircleY(GridPane pane, Circle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setCenterY(Double.parseDouble(textField.getText()));
        });
    }

    public static void addCircleRadius(GridPane pane, Circle shape, String value, int position) {
        TextField textField = new TextField(value);
        textField.setOnAction(e -> {
            shape.setRadius(Double.parseDouble(textField.getText()));
        });
    }

}
