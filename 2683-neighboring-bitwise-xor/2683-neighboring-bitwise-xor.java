class Solution {
    public boolean doesValidArrayExist(int[] derived) {
       int xor=0;//d[i]=o[i]^o[i+1] as two o[i] =0  if xor d[i]'s=0
       for(int n:derived){ xor^=n; }
       return xor==0; 
    /* int c=0;  //1's in derive or notsame bitpairs in original
       for(int n:derived) { c+=n; } //add 1's in count
       return c%2==0;  //1's are even notsame can paired */
    /*  int[] o = new int[derived.length+1]; o[0]=0;
      for(int i=0;i<derived.length;i++){
        o[i+1]= derived[i]^o[i];
      }
      boolean checkz= (o[0] == o[o.length-1]);
      o[0]=1;
      for(int i=0;i<derived.length;i++){
        o[i+1] = derived[i]^o[i];
      }
      boolean check1 = (o[0] == o[o.length-1]);
      return checkz || check1; */
    }
}