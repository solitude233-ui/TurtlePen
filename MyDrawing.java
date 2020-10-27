package ca.queensu.cs.cisc124.asgmt.a2;

import java.awt.Color;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import ca.queensu.cs.cisc124.notes.basics.geometry.Vector2;
import princeton.introcs.StdDraw;

/**
 * This class uses the Turtle and the Pen class to create and draw an
 * interesting image.
 * 
 * @author Zhixiang Guo
 *
 */

public class MyDrawing {

	public static void main(String[] args) {
		// You can change the coordinate scale of the canvas
		// that the turtle draws on if you wish. For example,
		//
		// StdDraw.setScale(-2, 2);
		//
		// will use a canvas having corners (-2, -2) and (2, 2)
		Turtle t1 = new Turtle();
		t1.setPenColor(Color.CYAN);
		t1.setPenRadius(4f);
		t1.turnRight(45);
		double i = 0.9;
		while (i > 0) {
			Point2 p1 = new Point2(0, i);
			t1.teleport(p1);
			t1.forward(Math.sqrt(i + i));
			i -= 0.1;
		}
		t1.turnLeft(90);
		t1.forward(Math.sqrt(0.405));

		Turtle t2 = new Turtle();
		t2.setPenColor(Color.PINK);
		t2.setPenRadius(4f);
		t2.turnRight(45);
		double j = 0.1;
		double k = 1;
		while (j < 0.9) {
			k -= 0.1;
			Point2 p2 = new Point2(1, j);
			t2.teleport(p2);
			t2.backward(Math.sqrt(k + k));
			j += 0.1;
		}
		t2.turnRight(90);
		Point2 p = new Point2(1, 1);
		t2.teleport(p);
		t2.forward(Math.sqrt(0.405));

		Turtle t3 = new Turtle();
		t3.setPenColor(Color.GRAY);
		t3.setPenRadius(4f);
		t3.turnLeft(45);
		double m = 0.9;
		while (m > 0.1) {
			Point2 p4 = new Point2(m, 0);
			t3.teleport(p4);
			t3.forward(Math.sqrt(2));
			m -= 0.1;
		}
		t3.turnLeft(90);
		Point2 q = new Point2(1, 0);
		t3.teleport(q);
		t3.forward(Math.sqrt(0.405));

		Turtle t4 = new Turtle();
		t4.setPenColor(Color.ORANGE);
		t4.setPenRadius(4f);
		t4.turnLeft(225);
		double n = 0.9;
		while (n > 0.1) {
			Point2 p5 = new Point2(0, n);
			t4.teleport(p5);
			t4.backward(Math.sqrt(2));
			n -= 0.1;
		}
		t4.turnLeft(90);
		Point2 a = new Point2(0, 1);
		t4.teleport(a);
		t4.forward(Math.sqrt(0.405));

	}
}
