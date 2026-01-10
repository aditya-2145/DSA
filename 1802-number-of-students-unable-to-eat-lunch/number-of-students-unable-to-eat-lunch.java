class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        for (int s : students) {
            count[s]++;
        }

        for (int sw : sandwiches) {
            if (count[sw] == 0) {
                break;
            }
            count[sw]--;
        }

        return count[0] + count[1];
    }
}
