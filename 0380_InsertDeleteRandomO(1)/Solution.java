import java.util.*;

class RandomizedSet {

    HashMap<Integer,Integer> mp;
    ArrayList<Integer> arr;

    public RandomizedSet() {
        mp = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mp.get(val)==null || mp.get(val)==0)
        {
            mp.put(val,1);
            arr.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {

        if(mp.get(val)==null || mp.get(val)==0)
            return false;
        else
        {
            mp.put(val,0);
            arr.remove(arr.indexOf(val));
            return true;
        }
        
    }
    public int getRandom() {
        int index = (int)(Math.random()*1000)%arr.size();
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */