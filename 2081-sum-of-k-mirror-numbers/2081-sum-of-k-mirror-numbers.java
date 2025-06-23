class Solution {
    public long kMirror(int k, int n) {
        int count = 0;
        long sum = 0;
        for (int len = 1; ; len++) {
            List<Long> candidates = new ArrayList<>();
            generateBaseKPal(0, len, new StringBuilder(), candidates, k);
            for (long val : candidates) {
                if (isBase10Pal(val)) {
                    sum += val;
                    count++;
                    if (count == n) return sum;
                }
            }
        }
    }

    public boolean isBase10Pal(long num) {
        long original = num;
        long reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }

    public void generateBaseKPal(int i, int totalLen, StringBuilder sb, List<Long> list, int base) {
        if (i >= (totalLen + 1) / 2) {
            list.add(formBaseKPal(sb, totalLen, base));
            return;
        }
        for (int digit = 0; digit < base; digit++) {
            if (i == 0 && digit == 0) continue;
            sb.append(digit);
            generateBaseKPal(i + 1, totalLen, sb, list, base);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public long formBaseKPal(StringBuilder sb, int totalLen, int base) {
        String left = sb.toString();
        String right = new StringBuilder(left.substring(0, totalLen / 2)).reverse().toString();
        String fullPalStringInBaseK = left + right;
        return Long.parseLong(fullPalStringInBaseK, base);
    }
}