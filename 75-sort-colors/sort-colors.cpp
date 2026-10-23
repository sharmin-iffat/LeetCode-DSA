class Solution {
public:
    void sortColors(vector<int>& nums) {
        int zeroes = 0;
        int ones = 0;
        int twoes = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                zeroes++;
            }else if(nums[i] == 1){
                ones++;
            }else{
                twoes++;
            }
        }
        for(int i=0; i<nums.size(); i++){
            if(zeroes >0){
                nums[i] = 0;
                zeroes--;
            }else if(ones > 0){
                nums[i] = 1;
                ones--;
            }else{
                nums[i] = 2;
            }
        }
    }
};