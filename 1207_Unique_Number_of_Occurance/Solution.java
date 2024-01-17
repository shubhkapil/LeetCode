class Solution {
    //using HashMap

    // public boolean uniqueOccurrences(int[] arr) {

    //     int n = arr.length;
    //     HashMap<Integer,Integer> mp = new HashMap<>();
    //     int[] occur = new int[10001];

    //     for(int i = 0;i<n;i++)
    //         mp.compute(arr[i], (k,v) -> (v==null) ? 1 : v+1);
        
    //     for(int i : mp.values())
    //     {
    //         if(occur[i]!=0)
    //             return false;
    //         occur[i]++;
    //     }
    //     return true;
        
    // }

    //Using Arrays as map
    public boolean uniqueOccurrences(int[] arr) {

        int n = arr.length;
        int[] occur = new int[2001];
        boolean[] already_exist = new boolean[2001];

        for(int i = 0;i<n;i++)
            occur[arr[i]+1000]++;
        
        for(int i = 0;i<2001;i++)
        {
            int val = occur[i];
            if(val!=0 && already_exist[val])
                return false;
            already_exist[val] = true;
        }
        return true;
        
    }
}