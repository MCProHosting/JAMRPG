package com.mcprohosting.games.jamrpg;

import com.mcprohosting.games.jamrpg.platform.InputManager;
import com.mcprohosting.games.jamrpg.platform.SoundManager;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class Utilities {
	public static void initializeJavaFX() {
		final CountDownLatch latch = new CountDownLatch(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JFXPanel(); // initializes JavaFX environment
				latch.countDown();
			}
		});
		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void hookShutdown() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				shutDown();
			}
		});
	}

	public static void shutDown() {
		InputManager.closeScanner();
		SoundManager.stopAllSounds();
	}
}
