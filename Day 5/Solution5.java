import java.util.ArrayList;

class Solution5
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long[] hist, long n)
    {
        int i=0, j=i;
        long ans = 0;
        ArrayList<Long> done = new ArrayList<>();

        while (i < hist.length) {
            while (j < hist.length && hist[i] <= hist[j]) {
                j++;
            }

            ans = Math.max(ans, (j-i)*hist[i]);
            done.add(hist[i]);
            long added = hist[i];

            if (j >= hist.length) {
                while (done.contains(added)) i++;
                j = i;
            }
            else {
                hist[i] = hist[j];
                j = i;
            }
        }

        return ans;
    }
}
