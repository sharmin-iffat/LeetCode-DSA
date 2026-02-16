class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();

        for(int c:candyType) set.add(c);

        return Math.min(set.size(), candyType.length/2);
    }
}