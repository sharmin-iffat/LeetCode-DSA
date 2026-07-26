class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++){
            char[] words = arr[i].toCharArray();

            swap(words);

            arr[i] = new String(words);
        }
        return String.join(" ", arr);   
    }

    private void swap(char[] arr){

        int l=0, r = arr.length-1;
        while(l<=r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}