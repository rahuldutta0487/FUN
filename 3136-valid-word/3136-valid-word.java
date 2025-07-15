class Solution {
    public boolean isValid(String word) {
        int n=word.lenght();
        if(n<3){
            return false;
        }
        int vow=0;
        int conso=0;
        for(char c:word.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiouAEIOU".indexOf(c) != -1){
                    vow++;
                } else {
                    conso++;
                }
            }
            else if(!Character.isDigit(c)){
                return false;
            }
        }
        return vow >=1 && conso >=1;
    }
}