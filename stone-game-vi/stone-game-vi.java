class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Stone> q = new PriorityQueue<Stone>((a, b) -> b.alice + b.bob - a.alice - a.bob);
        // sort each stone in decreasing on the basis of it's worth
        // each player will remove a stone which helps them score more for themselves
        // as well as prevents the other player from scoring more
        // so a stone with a larger total value (i.e. value for alice + value for bob) is more worthy
        // and thus will be removed first
        
        for(int i = 0; i < aliceValues.length; i++) {
            q.add(new Stone(aliceValues[i], bobValues[i]));
        }
        
        int ac = 0, bc = 0;
        boolean aliceTurn = true;
        while(!q.isEmpty()) {
            if(aliceTurn) ac += q.poll().alice;
            else bc += q.poll().bob;
            aliceTurn = !aliceTurn;
        }
        
        return Integer.compare(ac, bc);
    }
    
    private static class Stone {
        int alice, bob;
        
        Stone(int a, int b) {
            alice = a;
            bob = b;
        }
    }
}