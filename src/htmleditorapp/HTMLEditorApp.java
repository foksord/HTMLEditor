package htmleditorapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorApp extends Application {
    private HTMLEditor htmlEditor = null;
    private final String INITIAL_TEXT = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Document</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "Hello World" +
            "</body>\n" +
            "</html>";
            
    
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("HTMLEditor");
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        VBox vRoot = new VBox();

        vRoot.setPadding(new Insets(8, 8, 8, 8));
        vRoot.setSpacing(5);

        htmlEditor = new HTMLEditor();
        htmlEditor.autosize();
        htmlEditor.setHtmlText(INITIAL_TEXT);
        vRoot.getChildren().add(htmlEditor);

        final Label htmlLabel = new Label();
        htmlLabel.autosize();
        htmlLabel.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setContent(htmlLabel);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(220);

        Button showHTMLButton = new Button("Show the HTML below");
        vRoot.setAlignment(Pos.CENTER);
        showHTMLButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                    htmlLabel.setText(htmlEditor.getHtmlText());
            }
        });

        vRoot.getChildren().addAll(showHTMLButton, scrollPane);
        root.getChildren().addAll(vRoot);
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
