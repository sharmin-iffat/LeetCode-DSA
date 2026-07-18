class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r= arr.length-1;

        while(l<r){
            if(!isVowel(arr[l])){
                l++;
            }else if(!isVowel(arr[r])){
                r--;
            }else{
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return new String(arr);
    }


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l] = arr[r]; 
        arr[r] = temp;

    }
}