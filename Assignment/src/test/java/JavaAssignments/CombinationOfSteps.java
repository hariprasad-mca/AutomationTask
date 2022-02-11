package JavaAssignments;

import org.testng.annotations.Test;

public class CombinationOfSteps {

	@Test
	public void combinationOfSteps() {
		int n = 4;
		System.out.println(findStep(n));
	}

	public static int findStep(int n) {
		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		else
			return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
	}
}
