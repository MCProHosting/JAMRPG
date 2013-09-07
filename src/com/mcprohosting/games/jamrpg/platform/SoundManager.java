package com.mcprohosting.games.jamrpg.platform;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

import java.nio.IntBuffer;

public class SoundManager {
	private boolean outputSound;

	private int[] buffers = new int[256];
	private int[] sources;
	private IntBuffer scratchBuffer = BufferUtils.createIntBuffer(256);
	private int bufferIndex;
	private int sourceIndex;

	public SoundManager() {}

	public void playEffect(int buffer) {
		if (outputSound) {
			int channel = sources[(sourceIndex++ % (sources.length-1))];

			AL10.alSourcei(channel, AL10.AL_BUFFER, buffers[buffer]);
			AL10.alSourcePlay(channel);
		}
	}

	public void playSound(int buffer) {
		if (outputSound) {
			AL10.alSourcei(sources[sources.length-1], AL10.AL_BUFFER, buffers[buffer]);
			AL10.alSourcePlay(sources[sources.length-1]);
		}
	}

	public boolean isPlayingSound() {
		return AL10.alGetSourcei(sources[sources.length-1], AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
	}

	public void initalize(int channels) {
		try {
			AL.create();

			scratchBuffer.limit(channels);
			AL10.alGenSources(scratchBuffer);
			scratchBuffer.rewind();
			scratchBuffer.get(sources = new int[channels]);

			if (AL10.alGetError() != AL10.AL_NO_ERROR) {
				throw new LWJGLException("Unable to allocate " + channels + " sources");
			}

			outputSound = true;
		} catch (LWJGLException le) {
			le.printStackTrace();
			System.out.println("System sound could not be allocated.");
		}
	}

	public int addSound(String path) {
		scratchBuffer.rewind().position(0).limit(1);
		AL10.alGenBuffers(scratchBuffer);
		buffers[bufferIndex] = scratchBuffer.get(0);

		WaveData waveFile = WaveData.create("jam/" + path);

		AL10.alBufferData(buffers[bufferIndex], waveFile.format, waveFile.data, waveFile.samplerate);

		waveFile.dispose();

		return bufferIndex++;
	}

	public void destroy() {
		if (outputSound) {
			scratchBuffer.position(0).limit(sources.length);
			scratchBuffer.put(sources).flip();
			AL10.alSourceStop(scratchBuffer);

			AL10.alDeleteBuffers(scratchBuffer);

			scratchBuffer.position(0).limit(bufferIndex);
			scratchBuffer.put(buffers, 0, bufferIndex).flip();
			AL10.alDeleteBuffers(scratchBuffer);

			AL.destroy();
		}
	}
}