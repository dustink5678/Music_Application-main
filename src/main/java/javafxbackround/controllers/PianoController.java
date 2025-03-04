package javafxbackround.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafxbackround.music.App;
import javafxbackround.music.Music;

public class PianoController {
    
    @FXML
    private HBox pianoKeysContainer;
    
    @FXML
    private Button playSampleButton;
    
    private static final String[] WHITE_KEYS = {"C", "D", "E", "F", "G", "A", "B"};
    private static final String[] BLACK_KEYS = {"C#", "D#", "F#", "G#", "A#"};
    
    @FXML
    public void initialize() {
        System.out.println("PianoController initializing...");
        try {
            createPianoKeys();
            System.out.println("Piano keys created successfully");
        } catch (Exception e) {
            System.out.println("Error creating piano keys: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void createPianoKeys() {
        double whiteKeyWidth = 60;
        double whiteKeyHeight = 200;
        double blackKeyWidth = 40;
        double blackKeyHeight = 120;
        
        Pane keyboardPane = new Pane();
        pianoKeysContainer.getChildren().add(keyboardPane);
        
        for (int i = 0; i < WHITE_KEYS.length; i++) {
            Rectangle whiteKey = createKey(i * whiteKeyWidth, 0, whiteKeyWidth, whiteKeyHeight, Color.WHITE, WHITE_KEYS[i]);
            keyboardPane.getChildren().add(whiteKey);
        }
        
        double[] blackKeyPositions = {0.75, 1.75, 3.75, 4.75, 5.75};
        for (int i = 0; i < BLACK_KEYS.length; i++) {
            Rectangle blackKey = createKey(blackKeyPositions[i] * whiteKeyWidth - blackKeyWidth/2, 0, 
                                         blackKeyWidth, blackKeyHeight, Color.BLACK, BLACK_KEYS[i]);
            keyboardPane.getChildren().add(blackKey);
        }
    }
    
    private Rectangle createKey(double x, double y, double width, double height, Color color, String note) {
        Rectangle key = new Rectangle(x, y, width, height);
        key.setFill(color);
        key.setStroke(Color.BLACK);
        key.setStrokeWidth(1);
        
        key.setOnMousePressed(event -> {
            playNote(note);
            key.setFill(color == Color.WHITE ? Color.LIGHTGRAY : Color.DARKGRAY);
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
    
    @FXML
    private void handlePlaySample() {
        App.playSampleSong();
    }
}