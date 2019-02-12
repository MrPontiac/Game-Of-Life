import java.util.ArrayList;

class Main {
	/**
	 * Initiates a {@link GoL} class and creates a "blinker" and a square; It also
	 * can take in two arguments to control how it works
	 * <p>
	 * Arg One: controls how many generations to do
	 * <p>
	 * Arg Two: controls the speed of the generations; the number is actually a
	 * delay in milliseconds in between each generation
	 * <p>
	 * Arg Three: Determines whether or not to print out the generation
	 **/
	public static void main(String[] args) {
		GoL life = new GoL(10, 10);

		life.set(1, 2, (char) 49);
		life.set(1, 3, (char) 49);
		life.set(1, 4, (char) 49);

		life.set(6, 5, (char) 49);
		life.set(5, 5, (char) 49);
		life.set(5, 6, (char) 49);

		int i = 1;
		int k = 0;
		int speed = 0;

		if (args.length != 0) {
			k = Integer.parseInt(args[0]);
			if (args.length == 2) {
				speed = Integer.parseInt(args[1]);
			}
		} else {
			k = 10;
		}
		if (args.length < 2) {
			speed = 100;
		}

		while (i <= k) {
			System.out.println("Generation " + i);
			life.printArray();
			life.Generation();
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
				System.err.println(e);
				break;
			}
			i++;
		}
	}
}