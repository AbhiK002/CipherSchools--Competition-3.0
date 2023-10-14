import java.util.Stack;

class Solution5
{
    public static long getMaxArea(long[] hist, long n) {
        long maxArea = 0;

        // store the index of the first occurring smaller element for each element, on the left side
        long[] smallerElementOnLeft = new long[(int) n];
        Stack<Integer> lastChecked = new Stack<>();

        for (int i = 0; i < n; i++) {
            long target = hist[i];

            // remove all the last checked elements (greater than / equal to) the current target
            while (!lastChecked.isEmpty() && hist[lastChecked.peek()] >= target)
                lastChecked.pop();

            if (lastChecked.isEmpty()) {
                // all previously checked elements were greater than the target
                smallerElementOnLeft[i] = -1;
            }
            else {
                // the TOP of the stack contains an element that is smaller than the target
                smallerElementOnLeft[i] = lastChecked.peek();
            }

            lastChecked.push(i);
        }

        // store the index of the first occurring smaller element for each element, on the right side
        long[] smallerElementOnRight = new long[(int) n];
        lastChecked.clear();

        for (int i = (int) n - 1; i >= 0; i--) {
            long target = hist[i];

            // remove all the last checked elements (greater than / equal to) the current target
            while (!lastChecked.isEmpty() && hist[lastChecked.peek()] >= target)
                lastChecked.pop();

            if (lastChecked.isEmpty()) {
                // all previously checked elements were greater than the target
                smallerElementOnRight[i] = (int) n;
            }
            else {
                // the TOP of the stack contains an element that is smaller than the target
                smallerElementOnRight[i] = lastChecked.peek();
            }

            lastChecked.push(i);
        }


        for (int i = 0; i < (int) n; i++) {
            long height = hist[i];

            // - 1 because the width is exclusively BETWEEN the 2 indices with smaller elements
            long width = smallerElementOnRight[i] - smallerElementOnLeft[i] - (long) 1;
            long area = width * height;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}


class Main2 {
    public static void main(String[] args) {
        long[] hist;
        long n;

        hist = new long[]{6, 2, 5, 4, 5, 1, 6};
        n = 7;
        System.out.println(Solution5.getMaxArea(hist, n));

        hist = new long[]{7, 2, 8, 9, 1, 3, 6, 5};
        n = 8;
        System.out.println(Solution5.getMaxArea(hist, n));

        hist = new long[]{32423, 23235, 52523, 34522, 52334, 23565};
        n = 6;
        System.out.println(Solution5.getMaxArea(hist, n));
    }
}
