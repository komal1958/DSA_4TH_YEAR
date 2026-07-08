import java.util.*;

public class maxSubArraySum {
    public static int maxSubArraySum1(int[] nums){
        if(nums.length==0) return 0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int cSum = 0;
            for(int j=i; j<nums.length; j++){
                cSum+=nums[j];
                maxSum=Math.max(maxSum, cSum);
            }
        }
        return maxSum;
    }


    public static int kadane(int[] nums){
        int sum=nums[0];
        int maxSum=nums[0];
        for(int i=1; i<nums.length; i++){
            sum=Math.max(sum+nums[i], nums[i]);
            maxSum=Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(maxSubArraySum1(nums));
        System.out.println(kadane(nums));
    }
}
