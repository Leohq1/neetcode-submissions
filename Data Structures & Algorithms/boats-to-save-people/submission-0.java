class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int result = 0;
        while(left <= right){
            if(left == right){
                result++;
                break;
            }
            if(people[left] + people[right] <= limit){
                result++;
                left++;
                right--;
            } else{
                result++;
                right--;
            }
        }
        return result;
    }
}