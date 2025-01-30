public class MaxFinder {
    public int findmax(int[][] set) {
        int max = 0;
        for (int j = 0; j < set.length; j++){
            for (int i = 0; i < set[j].length; i++) {
                if (set[j][i] > max) {
                    max = set[0][i];
                }
            }
        }
        return max;
    }
}
