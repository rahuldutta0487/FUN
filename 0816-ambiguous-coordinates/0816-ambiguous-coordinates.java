class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for(int i = 1; i < s.length(); i++){
            helper(result, s.substring(0, i), s.substring(i));
        }
        return result;
    }
    private void helper(List<String> result, String x, String y){
        List<String> coordinatex = breakstring(x);
        List<String> coordinatey = breakstring(y);
        for(String dx : coordinatex){
            if(valid(dx)){
                for(String dy : coordinatey){
                    if(valid(dy)){
                        result.add("(" + dx + ", " + dy + ")");
                    }
                }
            }
        }
    }
    private List<String> breakstring(String x){
        List<String> list = new ArrayList<>();
        list.add(x);
        for(int i = 1; i < x.length(); i++){
            list.add(x.substring(0, i) + "." + x.substring(i));
        }
        return list;
    }
    private boolean valid(String s){
        if(s.contains(".")){
            String[] substring = s.split("\\.");
            if(!substring[0].equals("0") && substring[0].startsWith("0")){
                return false;
            }
            else{
                return !substring[1].endsWith("0");
            }
        }
        else{
            if(s.equals("0")){
                return true;
            }
            else{
                return !s.startsWith("0");
            }
        }
    }
}