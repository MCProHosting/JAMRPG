package com.mcprohosting.games.jamrpg.platform;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class SoundManager {
	private static ArrayList<MediaPlayer> mediaPlayers = new ArrayList<MediaPlayer>();
	private static boolean outputSound = true;

	public static void playSound(String sound) {
		if (outputSound) {
			Media media = new Media(sound);
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			addMediaPlayer(mediaPlayer);
			mediaPlayer.play();
		}
	}

	public static void playSoundInThread(final String sound) {
		new Thread(
				new Runnable() {
					public void run() {
						if (outputSound) {
							Media media = new Media(sound);
							MediaPlayer mediaPlayer = new MediaPlayer(media);
							addMediaPlayer(mediaPlayer);
							mediaPlayer.play();
						}
					}
				}).start();
	}

	//A synchronized reference to mediaPlayers to avoid concurrent modification. ;)
	private synchronized static void addMediaPlayer(MediaPlayer mediaPlayer) {
		mediaPlayers.add(mediaPlayer);
	}

	public static void stopAllSounds() {
		for (MediaPlayer mediaPlayer : mediaPlayers) {
			mediaPlayer.stop();
		}
	}

	public static boolean getOutputSound() {
		return outputSound;
	}

	public static ArrayList<MediaPlayer> getMediaPlayers() {
		return mediaPlayers;
	}
}