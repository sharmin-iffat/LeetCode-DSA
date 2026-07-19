class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int l=0, r= arr.length-1;

        while(l<r){
            boolean left = isVowel(arr, l);
            boolean right = isVowel(arr, r);

            if(!left) l++;
            else if(!right) r--;
            else{
                swap(arr, l, r);
                l++;
                r--;
            } 
        }
        return new String(arr);
    }

    private boolean isVowel(char[] arr, int i){
        char ch = arr[i];

        if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u'){
            return true;
        }
        return false;  
    }

    private void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}