import java.util.*;
class Solution {
    public String largestGoodInteger(String num) {
        for(int i=9;i>=0;i--){
            String str = String.valueOf(i).repeat(3);
            if(num.contains(str))return str;
        }
        return "";
    }
}