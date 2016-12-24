/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioplayernew;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author student
 */
class MyAudioPlayer {
    
    Clip audioClip;
    
    void load() throws IOException, UnsupportedAudioFileException, LineUnavailableException{
        File audioFile = new File("C:\\Users\\student\\Downloads\\1.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class,format);
        audioClip = (Clip) AudioSystem.getLine(info);
    }

    void play() {
        try {
            load();
        } catch (IOException ex) {
            Logger.getLogger(MyAudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MyAudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(MyAudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        audioClip.start();
    }
    
}
