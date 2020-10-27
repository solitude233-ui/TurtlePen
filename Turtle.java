package ca.queensu.cs.cisc124.asgmt.a2;

import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import ca.queensu.cs.cisc124.notes.basics.geometry.Vector2;
import princeton.introcs.StdDraw;
import java.awt.Color;

public class Turtle {
	private Point2 position;
	private double heading;
	private Pen pen;

	/**
	 * Create a turtle at location {@code (0, 0)} with a heading of {@code 0.0}
	 * degrees. The turtle's pen is {@code Color.BLACK}, with a radius of
	 * {@code 0.5f}, and is in the down state.
	 */
	public Turtle() {
		this.position = new Point2();
		this.heading = 0.0;
		this.pen = new Pen();
	}

	/**
	 * Create a turtle from another turtle. The created turtle is initialized having
	 * the same position, heading, and pen as the other turtle, but moves
	 * independently of the other turtle.
	 * 
	 * @param other the turtle to copy
	 */
	public Turtle(Turtle other) {
		this.position = other.position;
		this.heading = other.heading;
		this.pen = other.pen;
	}

	/**
	 * Create a turtle with the given starting position, heading, and pen color. The
	 * pen radius is set to {@code 0.5f} and is in the down state.
	 * 
	 * @param position the starting position of the turtle
	 * @param heading  the angle in degrees from the x axis that the turtle is
	 *                 facing in
	 * @param c        the pen color
	 * @throws IllegalArgumentException if the heading is negative or greater than
	 *                                  360 degrees
	 * @throws NullPointerException     if the pen color c is null
	 */
	public Turtle(Point2 position, double heading, Color c) {
		this.position = position;
		this.heading = heading;
		this.pen.color = c;
	}

	/**
	 * Gets a copy of the current position of the turtle.
	 * 
	 * <p>
	 * The returned point is a new {@code Point2} instance equal to the turtle's
	 * current position.
	 * 
	 * @return the current position of the turtle
	 */
	public Point2 getPosition() {
		return new Point2(this.position);
	}

	/**
	 * Gets the direction that the turtle is facing in as an angle measured from the
	 * x axis. The angle of the turtle is always in the range of {@code 0} degrees,
	 * inclusive, and {@code +360} degrees, exclusive.
	 * 
	 * @return the angle measured in degrees from the x axis that the turtle is
	 *         facing
	 */
	public double getHeading() {
		return this.heading;
	}

	/**
	 * Returns a string representation of this turtle. The string representation is:
	 * 
	 * <ol>
	 * <li>the position of the turtle (as given by {@code Point2.toString}),
	 * followed by
	 * <li>a comma and a space, followed by
	 * <li>the heading, followed by
	 * <li>a space, the string "degrees", a space, and a comma, followed by
	 * <li>the pen color (as given by {@code Color.toString})
	 * </ol>
	 * 
	 * @return a string representation of this turtle
	 */
	@Override
	public String toString() {
		String s = String.format("%s, %f degrees, %s", this.getPosition(), this.getHeading(), this.getPenColor());
		return s;
	}

	/**
	 * Draws a line connecting the specified start and end positions using the
	 * turtle's current pen color and pen radius.
	 * 
	 * <p>
	 * No line is drawn if the turtle's pen is up.
	 * 
	 * @param start the starting point of the line
	 * @param end   the ending point of the line
	 */
	private void drawLine(Point2 start, Point2 end) {
		if (this.isisPenDown()) {
			StdDraw.setPenColor(this.getPenColor());
			StdDraw.setPenRadiusInPixels(this.getPenRadius());
			StdDraw.line(start.x(), start.y(), end.x(), end.y());
		}
	}

	/**
	 * Teleports the turtle to the specified position without drawing a line.
	 * 
	 * <p>
	 * The turtle changes the coordinates of its position to equal to coordinates of
	 * the specified position.
	 * 
	 * @param position the position to teleport the turtle to
	 */
	public void teleport(Point2 position) {
		this.position.set(position.x(), position.y());
	}

	/**
	 * Walks this turtle by the specified distance in the heading direction changing
	 * the position of the turtle. A negative distance walks the turtle backwards
	 * without changing the heading.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * @param distance a distance for the turtle to walk
	 */
	private void walk(double distance) {
		Point2 current = new Point2(this.position);
		double x = Math.toRadians(this.heading);
		double y = Math.toRadians(this.heading);
		Vector2 v = new Vector2(distance * Math.cos(x), distance * Math.sin(y));
		this.position.add(v);
		// you should call drawLine as the final operation in this method
		// to draw a line from the previous turtle position to the new
		// (current) turtle position
		drawLine(current, this.position);
	}

	/**
	 * Walks the turtle forward by a given distance in the heading direction
	 * changing the position of the turtle.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * <p>
	 * The heading of the turtle does not change.
	 * 
	 * @param distance the distance to move
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void forward(double distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("Distance cannot be less than zero.");
		}
		this.walk(distance);
	}

	/**
	 * Walks the turtle backward by a given distance in the direction opposite to
	 * the heading direction changing the position of the turtle.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * <p>
	 * The heading of the turtle does not change.
	 * 
	 * @param distance the distance to move
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void backward(double distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("Distance cannot be less than zero.");
		}
		this.walk(-distance);
	}

	/**
	 * Returns the angle lying in the range 0 degrees (inclusive) to 360 degrees
	 * (exclusive) that is equivalent to {@code degrees}.
	 * 
	 * @param degrees an angle to wrap to the range 0 to 360 degrees
	 * @return the wrapped angle
	 */
	private static double wrapAngle(double degrees) {
		double angle = degrees % 360;
		if (angle < 0) {
			angle += 360;
		}
		return angle;
	}

	/**
	 * Turns the turtle to the left (counter clockwise), increasing its heading by
	 * delta degrees. The heading of the turtle is always corrected to lie within
	 * the range of {@code 0} degrees, inclusive, and {@code +360} degrees,
	 * exclusive.
	 * 
	 * @param delta the angle in degrees to turn counter clockwise
	 * @throws IllegalArgumentException if delta is less than zero
	 */
	public void turnLeft(double delta) {
		if (delta < 0) {
			throw new IllegalArgumentException("Angle cannot be less than zero.");
		}
		this.heading += delta;
		this.heading = wrapAngle(this.heading);
	}

	/**
	 * Turns the turtle to the right (clockwise), decreasing its heading by delta
	 * degrees. The heading of the turtle is always corrected to lie within the
	 * range of {@code 0} degrees, inclusive, and {@code +360} degrees, exclusive.
	 * 
	 * @param delta the angle in degrees to turn clockwise
	 * @throws IllegalArgumentException if delta is less than zero
	 */
	public void turnRight(double delta) {
		if (delta < 0) {
			throw new IllegalArgumentException("Angle cannot be less than zero.");
		}
		this.heading -= delta;
		this.heading = wrapAngle(this.heading);
	}

	/**
	 * Returns {@code true} if the turtle's pen is down, {@code false} otherwise.
	 * 
	 * @return {@code true} if the turtle's pen is down, {@code false} otherwise
	 */
	public boolean isisPenDown() {
		return this.pen.isPenDown();
	}

	/**
	 * Sets the pen to the down position. A line will be drawn when the turtle moves
	 * forward or backwards.
	 */
	public void penDown() {
		pen.setPenDown(true);
	}

	/**
	 * Sets the pen to the up position. No line will be drawn when the turtle moves
	 * forward or backwards.
	 */
	public void penUp() {
		pen.setPenDown(false);
	}

	/**
	 * Gets the current pen color.
	 * 
	 * @return the current pen color
	 */
	public Color getPenColor() {
		return pen.getColor();
	}

	/**
	 * Sets the pen color.
	 * 
	 * @param c the new pen color
	 * @throws IllegalArgumentException if the pen color c is null
	 */
	public void setPenColor(Color c) {
		if (c == null) {
			throw new IllegalArgumentException("Color c cannot be null");
		}
		pen.setColor(c);
	}

	/**
	 * Gets the current pen radius. The radius has no units, it is up to the caller
	 * to decide how to interpret the magnitude of the returned radius.
	 * 
	 * <p>
	 * The returned radius is always greater than or equal to zero.
	 * 
	 * @return the current pen radius
	 */
	public double getPenRadius() {
		return pen.getRadius();
	}

	/**
	 * Sets the pen radius. The radius has no units, it is up to the caller to
	 * decide how to interpret the magnitude of the returned radius.
	 * 
	 * @param radius the pen radius
	 * @throws IllegalArgumentException if the radius is negative
	 */
	public void setPenRadius(double radius) {
		if (radius < 0) {
			throw new IllegalArgumentException("Radius cannot be negative.");
		}
		pen.setRadius(radius);
	}

}
