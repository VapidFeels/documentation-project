package documentationProj;

/**
 *
 * @author Joshua Shelton
 */

public class SolveFibonacci {

	/**
	 * This is a program for finding the result of the nth term in the Fibonacci
	 * sequence and its runtime, both recursively and iteratively.
	 * 
	 * @param args
	 */
	static int count = 0;
	static int prevNumber;
	static int prevPrevNumber;
	static long startTimeRecursive;

	
	/**
	 * This is the recursive solve of the selected term, which is passed from the main method.
	 * @param selectedTerm The nth term of the Fibonacci sequence which is passed from the main method.
	 */
	public static void recursiveSolve(int selectedTerm) {

		long endTime;
		long timeToCalculate;
		
		int result;
		
		if (count == selectedTerm) { // BASE CASE: selectedTerm equals the amount of times recursiveSolve has been called, meaning we can solve for the nth selectedTerm.
			if (selectedTerm == 0 || selectedTerm == 1) { // If selectedTerm is 0 or 1, we already know what these equal in the Fibonacci sequence.
				endTime = System.nanoTime();
				timeToCalculate = endTime - startTimeRecursive;
				System.out.println("Term " + selectedTerm + " in the Fibonacci sequence equates to " + selectedTerm + "."); // F0 and F1 will always equal 0 and 1 respectively.
				System.out.println("It took " + timeToCalculate + " nano seconds to calculate recursively.\n");
				
				count = 0;
				prevPrevNumber = 0;
				prevNumber = 0;
			}
			else { // If selectedTerm is anything other than 0 or 1, we have been looping and recording the two previous numbers of the sequence and are ready to solve for the selectedTerm.
				result = prevNumber + prevPrevNumber;
				endTime = System.nanoTime();
				timeToCalculate = endTime - startTimeRecursive;
				System.out.println("Term " + selectedTerm + " in the Fibonacci sequence equates to " + result + ".");
				System.out.println("It took " + timeToCalculate + " nano seconds to calculate recursively.\n");
				
				count = 0;
				prevPrevNumber = 0;
				prevNumber = 0;
			}
		}
		else { // RECURSIVE CASE: we have not looped through recursiveSolve enough times.
			if (count == 0 || count == 1) { // If count equals 0 or 1, again, we know what these values equal, so we can skip to 'count = 2' and assign the two previous numbers to 1 and 0.
				prevNumber = 1;
				prevPrevNumber = 0;
				count = 2;
				recursiveSolve(selectedTerm);
			}
			else { // If count is 2 or greater, we assign result with the sum of the two previous numbers, and before continuing, we assign new values to the two previous numbers.
				result = prevNumber + prevPrevNumber;
				prevPrevNumber = prevNumber;
				prevNumber = result;
				count += 1;
				recursiveSolve(selectedTerm);
			}
		}
		
	}

	/**
	 * This is the iterative solve of the selected term, which is passed from the
	 * main method.
	 * 
	 * @param selectedTerm The nth term of the Fibonacci sequence which is passed from the main method.
	 */
	public static void iterativeSolve(int selectedTerm) {

		long startTimeIteration = System.nanoTime();
		long endTime;
		long timeToCalculate;
		
		int result = 0;
		
		if (selectedTerm == 0 || selectedTerm == 1) { // Check for 0 and 1, which results are already known.
			endTime = System.nanoTime();
			timeToCalculate = endTime - startTimeIteration;
			System.out.println("Term " + selectedTerm + " in the Fibonacci sequence equates to " + selectedTerm + "."); // F0 and F1 will always equal 0 and 1 respectively.
			System.out.println("It took " + timeToCalculate + " nano seconds to calculate iteratively.\n");
			
			count = 0;
			prevPrevNumber = 0;
			prevNumber = 0;
			return;
		}
		
		// Previous two values are already pre-defined in the sequence.
		prevNumber = 1;
		prevPrevNumber = 0;
		for (count = 2; count <= selectedTerm; count++) { // Start count at 2, since values 0 and 1 are already pre-defined and known.
			result = prevNumber + prevPrevNumber;
			prevPrevNumber = prevNumber;
			prevNumber = result;
		}
		
		// Give end results.
		endTime = System.nanoTime();
		timeToCalculate = endTime - startTimeIteration;
		System.out.println("Term " + selectedTerm + " in the Fibonacci sequence equates to " + result + "."); // F0 and F1 will always equal 0 and 1 respectively.
		System.out.println("It took " + timeToCalculate + " nano seconds to calculate iteratively.\n");
		
		count = 0;
		prevPrevNumber = 0;
		prevNumber = 0;
	}
	
	
	/**
	 * This is the main method, which defines which terms are to be solved and calls both previous methods.
	 * @param args Standard args parameter.
	 */
	public static void main(String[] args) {
		int[] termsToSolve = {5, 10, 15, 20};
		
		startTimeRecursive = System.nanoTime();
		
		System.out.println("RECURSIVE SOLVES: \n");
		for (int element : termsToSolve) {
			recursiveSolve(element);
		}
		
		System.out.println("ITERATIVE SOLVES: \n");
		for (int element : termsToSolve) {
			iterativeSolve(element);
		}
	}

}
