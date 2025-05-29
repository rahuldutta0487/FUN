class Solution {
    int cnt[];
    void update(int o, int l, int r, int num){
        if(l>num || r<num) return;
        cnt[o]++;
        if(l==r) return;
        int m=(l+r)>>1;
        update(o*2,l,m,num);
        update(o*2+1,m+1,r,num);
    }
    int query(int o, int l, int r, int l1, int r1){
        if(r1<l || l1>r) return 0;
        if(r1>=r && l1<=l) return cnt[o];
        int m=(l+r)>>1;
        return query(o*2,l,m,l1,r1)+query(o*2+1,m+1,r,l1,r1);
    }
    public int createSortedArray(int[] instructions) {
        int max=1, res=0, mod=1_000_000_007;
        for(int num:instructions) max=Math.max(max,num);
        cnt=new int[max<<2];
        for(int num:instructions){
            int smaller=query(1,1,max,1,num-1);
            int bigger=query(1,1,max,num+1,max);
            res=(res+Math.min(smaller,bigger))%mod;
            update(1,1,max,num);
        }
        //System.out.println(Arrays.toString(cnt));
        return res;
    }
}