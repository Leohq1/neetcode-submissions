class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int counter1 = 0;
        int counter2 = 0;
        Integer maj1 = null;
        Integer maj2 = null;
        List<Integer> result = new ArrayList<>();
        for(int i : nums){
            if(maj1 != null && i == maj1){
                maj1 = i;
                counter1++;
            } else if(maj2 != null && i == maj2){
                maj2 = i;
                counter2++;
            } else if(maj1 == null){
                maj1 = i;
                counter1++;
            } else if(maj2 == null){
                maj2 = i;
                counter2++;
            } else{
                if(counter1 == 1 || counter2 == 1){
                    counter1--;
                    counter2--;
                    maj1 = (counter1 == 0) ? null : maj1;
                    maj2 = (counter2 == 0) ? null : maj2;
                } else{
                    counter1--;
                    counter2--;
                }
            }
        }
        
        //System.out.println("" + maj1 + ", " + counter1 + "; " + maj2 + ", " + counter2);
        counter1 = 0;
        counter2 = 0;
        int size = nums.length / 3;
        for(int i : nums){
            if(maj1 != null && i == maj1){
                counter1++;
            }
            if(maj2 != null && i == maj2){
                counter2++;
            }
        }
        //System.out.println("" + maj1 + ", " + counter1 + "; " + maj2 + ", " + counter2);
        if(counter1 > size) result.add(maj1);
        if(counter2 > size) result.add(maj2);
        return result;
    }
}