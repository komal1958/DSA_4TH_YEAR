import java.util.*;

public class subArraySumEqualK {
    public static int subArraySum(int[] nums, int k){
        int count=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; i<nums.length; j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }


    public static int subArraySum1(int[] nums, int k){
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subArraySum(nums, k));
        System.out.println(subArraySum1(nums, k));
    }
}
