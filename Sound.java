import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	/**
	 * create clip objects 
	 */
	private Clip clipMenu, clipGame, clip;
	/**
	 * create constant strings for the music and noises 
	 */
	private final String MENU_MUSIC = "menu.wav", GAME_MUSIC = "game.wav", BUTTON = "ping1.wav", CHEW = "chewing.wav", GAME_OVER = "GameOver.wav";
	/**
	 * create a audio input stream variable 
	 */
	private AudioInputStream ais;
	/**
	 * method to play the main menu music 
	 */
	public void playMenuMusic() {
		File sound = new File(MENU_MUSIC);

		try {
			ais = AudioSystem.getAudioInputStream(sound);
			clipMenu = AudioSystem.getClip();
			clipMenu.open(ais); //Clip opens AudioInputStream
			clipMenu.loop(clipMenu.LOOP_CONTINUOUSLY); //Start playing audio
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to play the game music 
	 */
	public void playGameMusic() {
		File sound = new File(GAME_MUSIC);

		try {
			ais = AudioSystem.getAudioInputStream(sound);
			clipGame = AudioSystem.getClip();
			clipGame.open(ais); //Clip opens AudioInputStream
			clipGame.loop(clipGame.LOOP_CONTINUOUSLY); //Start playing audio
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to play the noise for clicking buttons 
	 */
	public void playButton() {
		File sound = new File(BUTTON);

		try {
			ais = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(ais); //Clip opens AudioInputStream
			clip.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to play the noise when eating 
	 */
	public void playChew() {
		File sound = new File(CHEW);

		try {
			ais = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(ais); //Clip opens AudioInputStream
			clip.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to play the game over noise 
	 */
	public void playGameOver() {
		File sound = new File(GAME_OVER);

		try {
			ais = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(ais); //Clip opens AudioInputStream
			clip.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * method to stop all the music 
	 */
	public void stopAll() {
		if (clipMenu != null && clipMenu.isRunning()) {
			clipMenu.stop(); // stops clip 
			clipMenu.close(); // close clip 
		}
		if (clipGame != null && clipGame.isRunning()) {
			clipGame.stop(); // stops clip
			clipGame.close(); // close clip 
		}
	}
}