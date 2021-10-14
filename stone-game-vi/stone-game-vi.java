class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Stone> q = new PriorityQueue<Stone>((a, b) -> b.alice + b.bob - a.alice - a.bob);
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