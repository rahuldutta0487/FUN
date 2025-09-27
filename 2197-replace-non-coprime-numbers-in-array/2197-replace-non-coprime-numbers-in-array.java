class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list= Arrays.stream(nums).boxed().collect(Collectors.toList());
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<nums.length;++i){
            stack.push(nums[i]);
            boolean flag=true;
            while(stack.size()>=2 && flag){
                int first=stack.pop();
                int second=stack.pop();
                if(coprime(first,second)){
                    stack.push(lcm(first,second));
                }else{
                    flag=false;
                    stack.push(second);
                    stack.push(first);
                }
            }
        }
        List<Integer> list1 = new ArrayList<>(stack);
        return list1;
    }
    private boolean coprime(int a, int b){
            return gcd(a, b) > 1;
        }
        private int lcm(int a, int b){
            return (int)((1L * a * b) / gcd(a, b));
        }

        private int gcd(int a, int b){
            if(a>b) return gcd(b,a);
            while(b!=0){
                int temp=b;
                b=a%b;
                a=temp;
            }
            return a;
        }
}