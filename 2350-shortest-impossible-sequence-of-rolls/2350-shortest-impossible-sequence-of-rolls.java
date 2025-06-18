class Solution {
    public int shortestSequence(int[] rolls, int k) {
   int seq = 0, cnt = 0, dice[] = new int[k + 1];
   for (var r : rolls)
       if (dice[r] == seq) {
           dice[r] = seq + 1;
           if (++cnt % k == 0)
               ++seq;
       }
   return seq + 1;
}
}