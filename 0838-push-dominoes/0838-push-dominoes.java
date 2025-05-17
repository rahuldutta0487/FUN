class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R"; // Boundary markers
        StringBuilder res = new StringBuilder();
        int prev = 0;
        
        for (int curr = 1; curr < dominoes.length(); curr++) {
            if (dominoes.charAt(curr) == '.') continue;
            
            // Handle segment between prev and current
            int span = curr - prev - 1;
            if (prev > 0) res.append(dominoes.charAt(prev));
            
            if (dominoes.charAt(prev) == dominoes.charAt(curr)) {
                // Same force (LL or RR)
                for (int i = 0; i < span; i++) 
                    res.append(dominoes.charAt(prev));
            } 
            else if (dominoes.charAt(prev) == 'L' && dominoes.charAt(curr) == 'R') {
                // No effect between L...R
                for (int i = 0; i < span; i++) 
                    res.append('.');
            } 
            else {
                // R...L collision
                for (int i = 0; i < span / 2; i++) 
                    res.append('R');
                if (span % 2 == 1) 
                    res.append('.');
                for (int i = 0; i < span / 2; i++) 
                    res.append('L');
            }
            prev = curr;
        }
        return res.toString();
    }
}