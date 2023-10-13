import java.util.ArrayList;

class Solution4 {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        ArrayList<Integer> maxCommonSubsequence = new ArrayList<>();

        for (int ptrA = 0; ptrA < N; ptrA++) {
            if (binarySearch(B, A[ptrA]) != -1) {
                int whereToPut = lowerBound(maxCommonSubsequence, A[ptrA]);

                if (whereToPut == -1) {
                    // target is larger than all the elements
                    maxCommonSubsequence.add(A[ptrA]);
                }
                else {
                    // target can replace an existing element in MCS
                    maxCommonSubsequence.set(whereToPut, A[ptrA]);
                }
            }
        }

        // Uncommon elements deleted from A + Missing common elements to be inserted in A
        return (N - maxCommonSubsequence.size()) + (M - maxCommonSubsequence.size());
    }

    static int lowerBound(ArrayList<Integer> nums, int target) {
        int i = 0, j = nums.size() - 1;
        int lowerBound = -1;
        while (i <= j) {
            int mid = (i+j)/2;

            if (target <= nums.get(mid)) {
                lowerBound = mid;
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }

        return lowerBound;
    }

    static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = (i+j)/2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                j = mid - 1;
            }
            else {
                i = mid + 1;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[] A, B;
        int N, M;

        N = 5; M = 3;
        A = new int[] {1, 2, 5, 3, 1};
        B = new int[] {1, 3, 5};
        System.out.println(Solution4.minInsAndDel(A, B, N, M));

        N = 2; M = 2;
        A = new int[] {1, 4};
        B = new int[] {1, 4};
        System.out.println(Solution4.minInsAndDel(A, B, N, M));

        N = 6; M = 7;
        A = new int[] {7, 4, 10, 6, 1 ,9};
        B = new int[] {1, 2, 3, 4, 5, 6, 8};
        System.out.println(Solution4.minInsAndDel(A, B, N, M));
    }
}
