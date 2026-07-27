class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {
            int j = Math.min(i + k - 1, arr.length - 1);
            swap(i, j, arr);
        }

        return new String(arr);
    }
    private void swap(int i, int j, char[] arr){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}