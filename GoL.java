import java.util.ArrayList;

/**
 * A class to emulate a Game of Life as per Conway's rules
 **/
class GoL {
	private int w = 0;
	private int h = 0;
	private int flag = 0;
	private char[][] matrix = null;

	/**
	 * Creates an array of variable size
	 **/
	public GoL(int w1, int h1) {
		w = w1;
		h = h1;
		matrix = new char[w][h];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = '-';
			}
		}
	}

	/**
	 * Creates an array of variable size, along with the option to debug the program
	 **/
	public GoL(int w1, int h1, int debugFlag) {
		w = w1;
		h = h1;
		matrix = new char[w][h];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = '-';
			}
		}
		flag = debugFlag;
	}

	/**
	 * Set a point to a value, of which are '-' and '1'
	 **/
	public void set(int x, int y, char val) {
		matrix[x][y] = val;
	}

	/**
	 * Do a generation according to the actual rules of Conway's Game of Life
	 **/
	public void Generation() {
		ArrayList<Character> changes = new ArrayList<Character>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					if (j == 0) {
						if (matrix[i][j] == (1 + 48)) {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (c < 2) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						}
					} else if (j == matrix[0].length - 1) {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c < 2) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						}
					} else {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						}
					}
				} else if (i == matrix.length - 1) {
					if (j == 0) {
						if (matrix[i][j] == (1 + 48)) {
							int c = 0;
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						} else {
							int c = 0;
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						}
					} else if (j == matrix[0].length - 1) {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c < 2) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						}
					} else {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');

							}
						}
					}
				} else {
					if (j == 0) {
						if (matrix[i][j] == (1 + 48)) {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}

							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						}
					} else if (j == matrix[0].length - 1) {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}

							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						}
					} else {
						if (matrix[i][j] == '-') {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}

							if (c == 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add((char) (1 + 48));
							}
						} else {
							int c = 0;
							if (matrix[i + 1][j] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i + 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j + 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j - 1] == (1 + 48)) {
								c++;
							}
							if (matrix[i - 1][j] == (1 + 48)) {
								c++;
							}
							if (c < 2 || c > 3) {
								changes.add((char) i);
								changes.add((char) j);
								changes.add('-');
							}
						}
					}
				}
			}
		}
		for (int k = 0; k < changes.size() - 2; k += 3) {
			int i = changes.get(k);
			int j = changes.get(k + 1);
			char num = changes.get(k + 2);

			matrix[i][j] = (char) num;
			if (flag == 1) {
				System.out.println("Matrix[" + i + "][" + j + "] => " + num);
			}
		}
	}

	/**
	 * Print the array
	 **/
	public void printArray() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}