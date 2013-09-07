package com.mcprohosting.games.jamrpg.gui.datatypes;

import org.lwjgl.util.Rectangle;

public abstract class Entity {
	protected float x;
	protected float y;
	protected Sprite sprite;
	protected float dx;
	protected float dy;

	private Rectangle me = new Rectangle();
	private Rectangle him = new Rectangle();

	protected Entity(Sprite spirte, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}

	public void move(long delta) {
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}

	public void setHorizontalMovement(float dx) {
		this.dx = dx;
	}

	public float getHorizontalMovement() {
		return this.dx;
	}

	public void setVeriticalMovement(float dy) {
		this.dy = dy;
	}

	public float getVeriticalMovement() {
		return this.dy;
	}

	public int getX() {
		return (int) this.x;
	}

	public int getY() {
		return (int) this.y;
	}

	public boolean collidesWith(Entity other) {
		me.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		him.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(), other.sprite.getHeight());

		return me.intersects(him);
	}

	public abstract void collidedWith(Entity other);
}
