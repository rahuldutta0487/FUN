class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if(a == e){ // if Rock and Queen Same Row 
            if(a == c && ((d > b && d < f) || (d > f && d < b))){ // if bishop in the middle between them
                return 2;
            }
            return 1;
        } else if (b == f){ // if Rock and Queen Same Column 
            if(d == b && ((c > a && c < e) || (c > e && c < a))){  // if bishop in the middle between them
                return 2;
            }
            return 1;
        } else if (Math.abs(c - e) == Math.abs(d - f)){            // if bishop and Queen Same diagonal 
            if(Math.abs(c - a) == Math.abs(d - b) && Math.abs(e - a) == Math.abs(f - b) && ((a > e && a < c) || (a < e && a > c)) ){  // if rock in the middle between them
                return 2;
            }
            return 1;
        } else {
            return 2;
        }
    }
}