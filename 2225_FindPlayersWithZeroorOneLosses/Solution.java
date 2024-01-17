class Solution {
    public class Status
        {
            private int win;
            private int loss;

            int getWin()
            {
                return this.win;
            }
                

            int getLoss()
            {
                return this.loss;
            }
                

            void setWin(int win)
            {
                this.win = win;
            }
            
            void setLoss(int loss)
            { 
                this.loss = loss;
            }
            
            Status(int win,int loss)
            {
                this.win = win;
                this.loss = loss;
            }
        }

    public List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer,Status> mp = new HashMap<>();

        int n = matches.length;

        for(int i = 0;i<n;i++)
        {
            int winner = matches[i][0];
            int loser = matches[i][1];

            if(mp.get(winner)==null)
            {
                mp.put(winner,new Status(1,0));
            }
            else
            {
                Status s = mp.get(winner);
                int wins = s.getWin();
                s.setWin(wins+1);
            }

            if(mp.get(loser)==null)
            {
                mp.put(loser,new Status(0,1));
            }
            else
            {
                Status s = mp.get(loser);
                int loss = s.getLoss();
                s.setLoss(loss+1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        for(int i : mp.keySet())
        {
            if(mp.get(i).loss==0)
            {
                left.add(i);
            }
            else if(mp.get(i).loss==1)
            {
                right.add(i);
            }
        }
        Collections.sort(left);
        ans.add(left);
        Collections.sort(right);
        ans.add(right);

        return ans;
    }
}