package drawing;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class DrawingTest {
	private Main drawing = new Main();

	@Test
	public void testCreate() {
		assertTrue(false);

	}

	@Test
	public void testLine() {

	}

	@Test
	public void testRectablge() {

	}

	@Test
	public void testBucketFill() {

	}

	@Test
	public void testQuit() {

	}

	public static void main(String... args) {
		Result result = JUnitCore.runClasses(DrawingTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());

	}

}
