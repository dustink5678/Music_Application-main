package javafxbackround.music;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import org.jfugue.player.Player;

public class Music {
    private static Player player;
    
    // Initialize player once
    static {
        player = new Player();
    }
    
    public static void playNote(String note) {
        try {
            // Check if we can get a sequencer (tests if MIDI is available)
            Sequencer sequencer = MidiSystem.getSequencer();
            if (!sequencer.isOpen()) {
                sequencer.open();
            }
            
            // Play the note with a properly initialized sequencer
            player.play(note);
            
            // No need to close the sequencer here as it would cause issues with 
            // rapid note playing. The JVM will handle closing it on shutdown.
            
        } catch (MidiUnavailableException e) {
            System.err.println("MIDI system unavailable: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error playing note: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Add this method to cleanly close resources when application exits
    public static void shutdown() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            if (sequencer.isOpen()) {
                sequencer.close();
            }
        } catch (MidiUnavailableException e) {
            // Ignore, we're shutting down anyway
        }
    }
}