package ca.queensu.cs.cisc124.asgmt.a2;

import java.awt.Color;

/**
 * This class creates a pen object to draw and supports changing the color,
 * radius and the up/down state of the pen.
 * 
 * @author Sean Guo
 *
 */

public class Pen {
	java.awt.Color color;
	private double radius;
	private boolean isPenDown;

	/**
	 * Creates a pen with default color in black, default radius of 0.5f and default
	 * state of the pen is down.
	 */
	public Pen() {
		this.color = Color.BLACK;
		this.radius = 0.5f;
		this.isPenDown = true;
	}

	/**
	 * Create a pen with the given color, radius and state of the pen.
	 * 
	 * @param color,   color of the pen.
	 * @param radius,  radius of the pen.
	 * @param penDown, up/down state of the pen.
	 */
	public Pen(java.awt.Color color, int radius, boolean penDown) {
		this.color = color;
		this.radius = radius;
		this.isPenDown = penDown;
	}

	/**
	 * Create a pen from another pen. The created pen is initialized having the same
	 * color, radius, and up/down state as the other pen.
	 * 
	 * @param other, the pen to copy.
	 */
	public Pen(Pen other) {
		this.color = other.color;
		this.radius = other.radius;
		this.isPenDown = other.isPenDown;
	}

	/**
	 * Return the up/down state of the pen.
	 * 
	 * @return the up/down state of the pen.
	 */
	public boolean isPenDown() {
		return this.isPenDown;
	}

	/**
	 * Change the pen to down state if the value is true and up state if the value
	 * is false.
	 * 
	 * @param value if pen is down or not.
	 */
	public void setPenDown(boolean value) {
		this.isPenDown = value;
	}

	/**
	 * Return the current color of the pen.
	 * 
	 * @return the current color of the pen.
	 */
	public java.awt.Color getColor() {
		return this.color;
	}

	/**
	 * Set the current color of the pen to the given color.
	 * 
	 * @param color color of the pen to change to.
	 */
	public void setColor(java.awt.Color color) {
		this.color = color;
	}

	/**
	 * Return the current radius of the pen.
	 * 
	 * @return the current radius of the pen.
	 */
	public double getRadius() {
		return this.radius;
	}

	/**
	 * Set the current radius of the pen to the given radius.
	 * 
	 * @param radius radius of the pen to change to.
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
