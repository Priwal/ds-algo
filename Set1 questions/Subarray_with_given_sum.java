// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/

class Solution
{ 
    public static int subArraySum(int[] arr, int n, int sum)
    { 
        //code here.
        HashMap<Integer,Integer> hm=new HashMap<>();
        int count=0;
        int pref_sum=0;
        
         for(int i=0;i<n;i++)
         {
             pref_sum+= arr[i];
            
            if(pref_sum==sum)
            count++;
            if(hm.containsKey(pref_sum-sum))
              count+=hm.get(pref_sum-sum);
              
              
              Integer val = hm.get(pref_sum);
              if(val==null)
              hm.put(pref_sum,1);
              else
                hm.put(pref_sum,val+1);}
         
        
        
   return count;
    }
}