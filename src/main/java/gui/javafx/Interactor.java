package gui.javafx;

public class Interactor {
    // public Node createImage(Map<String, String> attr, double X, double Y) {
    //     Image file = new Image((new File(attr.get("Source"))).toURI().toString());

    //     ImageView image = new ImageView();
    //     image.setFitHeight(Double.parseDouble(attr.get(AttributeLabel.HEIGHT.getLabel())));
    //     image.setFitWidth(Double.parseDouble(attr.get(AttributeLabel.WIDTH.getLabel())));
    //     image.setImage(file);
    //     image.setX(X);
    //     image.setY(Y);

    //     image.setOnMouseDragged(e -> {
    //         image.setX(e.getX() - image.getFitWidth() / 2);
    //         image.setY(e.getY() - image.getFitHeight() / 2);
    //     });

    //     image.setOnMouseClicked(e -> {
    //         if (e.getClickCount() == 2) {
    //             image.requestFocus();
    //             logger("Image selected");
    //             changes.getChildren().clear();
                
    //             ShapeUtility.addImageX(changes, image, 1);
    //             ShapeUtility.addImageY(changes, image, 2);
    //             ShapeUtility.addImageWidth(changes, image, 3);
    //             ShapeUtility.addImageHeight(changes, image, 4);
    //         }
    //     });

    //     image.getProperties().put("name", ObjectType.IMAGE.getType());
    //     return (Node) image;
    // }

    // public Node createLine(Map<String, String> attr, double X, double Y) {
    //     Line line = new Line();
    //     line.setStartX(X);
    //     line.setStartY(Y);
    //     line.setEndX(Double.parseDouble(attr.get("End X")));
    //     line.setEndY(Double.parseDouble(attr.get("End Y")));
    //     line.setFill(Color.web(attr.get(AttributeLabel.FILL_COLOR.getLabel())));
    //     line.setStroke(Color.web(attr.get(AttributeLabel.STROKE_COLOR.getLabel())));

    //     line.setOnMouseDragged(e -> {
    //         line.setTranslateX(e.getX() - Math.abs((line.getEndX() - line.getStartX()) / 2));
    //         line.setTranslateY(e.getY() - Math.abs((line.getEndY() - line.getStartY()) / 2));
    //     });

    //     line.setOnMouseClicked(e -> {
    //         if (e.getClickCount() == 2) {
    //             line.requestFocus();
    //             logger("Line selected");
    //             changes.getChildren().clear();
                
    //             ShapeUtility.addFillColor(changes, line, 1);
    //             ShapeUtility.addStrokeColor(changes, line, 2);
    //             ShapeUtility.addStrokeWidth(changes, line, 3);
    //             ShapeUtility.addLineStartX(changes, line, 4);
    //             ShapeUtility.addLineStartY(changes, line, 5);
    //             ShapeUtility.addLineEndX(changes, line, 6);
    //             ShapeUtility.addLineEndY(changes, line, 7);
    //         }
    //     });
        
    //     line.getProperties().put("name", ObjectType.LINE.getType());
    //     return (Node) line;
    // }

    // public Node createText(Map<String, String> attr, double X, double Y) {
    //     Text text = new Text();
    //     text.setX(X);
    //     text.setY(Y);
    //     text.setText(attr.get("Text"));
    //     text.setFill(Color.web(attr.get(AttributeLabel.FILL_COLOR.getLabel())));
    //     text.setStroke(Color.web(attr.get(AttributeLabel.STROKE_COLOR.getLabel())));

    //     text.setOnMouseDragged(e -> {
    //         text.setX(e.getX());
    //         text.setY(e.getY());
    //     });

    //     text.setOnMouseClicked(e -> {
    //         if (e.getClickCount() == 2) {
    //             text.requestFocus();
    //             logger("Text selected");
    //             changes.getChildren().clear();
                
    //             ShapeUtility.addFillColor(changes, text, 1);
    //             ShapeUtility.addStrokeColor(changes, text, 2);
    //             ShapeUtility.addStrokeWidth(changes, text, 3);
    //             ShapeUtility.addTextX(changes, text, 4);
    //             ShapeUtility.addTextY(changes, text, 5);
    //             ShapeUtility.addTextText(changes, text, 6);
    //         }
    //     });

    //     text.getProperties().put("name", ObjectType.PLAIN_TEXT.getType());
    //     return (Node) text;
    // }

    // public Node createTextArea(Map<String, String> attr, double X, double Y) {
    //     Pane pane = new Pane();
    //     TextArea textArea = new TextArea();

    //     textArea.setWrapText(true);
    //     textArea.setMaxSize(300.0, 150.0);
    //     pane.getChildren().addAll(textArea);
    //     textArea.setText(attr.get("Text"));

    //     pane.setOnMouseDragged(e -> {

    //     });

    //     pane.getProperties().put("name", ObjectType.TEXT_AREA.getType());
    //     return pane;
    // }

    // public void addContextMenu(Node node)
    // {
    //     ContextMenu menu = new ContextMenu();

    //     MenuItem interpolation = new MenuItem("Interpolation");
    //     MenuItem attributes = new MenuItem("Attributes");
    //     MenuItem delete = new MenuItem("Delete");

    //     interpolation.setOnAction((ActionEvent e) -> {
    //         logger("Work in progress");
    //     });
        
    //     attributes.setOnAction((ActionEvent e) -> {
    //         logger("Work in progress");
    //     });

    //     delete.setOnAction((ActionEvent e) -> {
    //         pane.getChildren().remove(node);
    //     });

    //     menu.getItems().addAll(interpolation, attributes, delete);

    //     node.setOnMousePressed(e -> {
    //         if (e.getButton() == MouseButton.SECONDARY) {
    //             logger("Right click detected");
    //             menu.show(node, e.getScreenX(), e.getScreenY());
    //         }
    //     });
    // }

    // public void logger(String value) {
    //     System.out.println(value);
    //     status.setText(value);
    // }
}
