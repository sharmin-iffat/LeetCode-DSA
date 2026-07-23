class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count =0, i=0, j=0;

        while(i<m && j<n){
            if(players[i] <= trainers[j]){
                count++;
                i++;
                j++;
            }else if(trainers[j] < players[i]) j++;
            else i++;
        }
        return count;

    }
}