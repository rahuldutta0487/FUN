class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        
        
        List<StringBuilder> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(new StringBuilder());
        }

        int n = s.length(); 
        int flag = -1;      
        int i = 0;         

       
        for (char c : s.toCharArray()) {
            row.get(i).append(c); 
            
            
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }

            i += flag; 
        }

        
        StringBuilder sb = new StringBuilder();
        for (StringBuilder r : row) {
            sb.append(r.toString());
        }

        return sb.toString(); 
    }
}