package javafxbackround.music;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxbackround.program.MusicPlayer;

public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;

    @Override
    @SuppressWarnings("exports")
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        
        javafx.scene.layout.VBox root = new javafx.scene.layout.VBox(20);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(20));
        
        javafx.scene.control.Label titleLabel = new javafx.scene.control.Label("Piano Music Application");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        javafx.scene.control.Button playButton = new javafx.scene.control.Button("Play Happy Birthday");
        playButton.setStyle("-fx-font-size: 14px; -fx-padding: 10 20 10 20;");
        playButton.setOnAction(e -> playSampleSong());
        
        javafx.scene.layout.HBox pianoKeysContainer = createPianoKeys();
        
        root.getChildren().addAll(titleLabel, pianoKeysContainer, playButton);
        
        scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Piano Music Application");
        stage.setResizable(false);
        stage.show();
        primaryStage.setOnCloseRequest(event -> {
        Music.shutdown();
    });
    }
    
    private javafx.scene.layout.HBox createPianoKeys() {
        javafx.scene.layout.HBox container = new javafx.scene.layout.HBox(0);
        container.setAlignment(javafx.geometry.Pos.CENTER);
        container.setPrefHeight(220);
        container.setPrefWidth(700);
        
        javafx.scene.layout.Pane keyboardPane = new javafx.scene.layout.Pane();
        container.getChildren().add(keyboardPane);
        
        String[] WHITE_KEYS = {"C", "D", "E", "F", "G", "A", "B"};
        String[] BLACK_KEYS = {"C#", "D#", "F#", "G#", "A#"};
        double whiteKeyWidth = 60;
        double whiteKeyHeight = 200;
        double blackKeyWidth = 40;
        double blackKeyHeight = 120;
        
        for (int i = 0; i < WHITE_KEYS.length; i++) {
            javafx.scene.shape.Rectangle whiteKey = createKey(i * whiteKeyWidth, 0, 
                                         whiteKeyWidth, whiteKeyHeight, 
                                         javafx.scene.paint.Color.WHITE, WHITE_KEYS[i]);
            keyboardPane.getChildren().add(whiteKey);
        }
        
        double[] blackKeyPositions = {0.75, 1.75, 3.75, 4.75, 5.75};
        for (int i = 0; i < BLACK_KEYS.length; i++) {
            javafx.scene.shape.Rectangle blackKey = createKey(blackKeyPositions[i] * whiteKeyWidth - blackKeyWidth/2, 0, 
                                         blackKeyWidth, blackKeyHeight, 
                                         javafx.scene.paint.Color.BLACK, BLACK_KEYS[i]);
            keyboardPane.getChildren().add(blackKey);
        }
        
        return container;
    }
    
    private javafx.scene.shape.Rectangle createKey(double x, double y, double width, double height, 
                                                 javafx.scene.paint.Color color, String note) {
        javafx.scene.shape.Rectangle key = new javafx.scene.shape.Rectangle(x, y, width, height);
        key.setFill(color);
        key.setStroke(javafx.scene.paint.Color.BLACK);
        key.setStrokeWidth(1);
        
        key.setOnMousePressed(event -> {
            playNote(note);
            key.setFill(color == javafx.scene.paint.Color.WHITE ? 
                      javafx.scene.paint.Color.LIGHTGRAY : javafx.scene.paint.Color.DARKGRAY);
        });
        
        key.setOnMouseReleased(event -> {
            key.setFill(color);
        });
        
        return key;
    }
    
    private void playNote(String note) {
        new Thread(() -> {
            Music.playNote(note);
        }).start();
    }
    
    public static void playSampleSong() {
        MusicPlayer player = new MusicPlayer();
        new Thread(() -> player.playSong()).start();
    }
    @SuppressWarnings("exports")
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}