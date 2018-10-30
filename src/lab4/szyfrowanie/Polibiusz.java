package lab4.szyfrowanie;

public class Polibiusz implements Algorithm {
    @Override
    public String crypt(String s) {
        String out = "";
        int row, col;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {

            row = (int) Math.ceil((s.charAt(i) - 'a') / 5.0) + 1;
            col = ((s.charAt(i) - 'a') % 5) + 1;
            if (s.charAt(i) >= 'j') {
                if (col == 1) {
                    col = 6;
                    row = row - 1;
                }
                col = col - 1;
            }
            out += row;
            out += col;
        }
        return out;
    }

    @Override
    public String decrypt(String s) {
        String out = "";
        int num;
        for (int i = 0; i < s.length(); i += 2) {
            num = 5 * (Character.getNumericValue(s.charAt(i + 1)) - 1) + Character.getNumericValue(s.charAt(i)) - 1;
            if (num > 9) num++;
            out += 'a' + num;
        }
        return out;
    }
}
