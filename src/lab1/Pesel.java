package lab1;

public class Pesel {
    public static boolean check(String toCheck) {
        if (toCheck.length() != 11) return false;
        char[] digitChars = new char[11];
        toCheck.getChars(0, 11, digitChars, 0);
        int[] digits = new int[11];
        for (int i = 0; i < 11; ++i) {
            digits[i] = digitChars[i] - '0';
        }


        if (digits[2] * 10 + digits[3] > 42) return false;

        if (digits[4] * 10 + digits[5] > 31) return false;

        int checksum = 9 * digits[0] + 7 * digits[1] + 3 * digits[2] + digits[3] + 9 * digits[4] + 7 * digits[5] + 3 * digits[6] + digits[7] + 9 * digits[8] + 7 * digits[9];

        return checksum % 10 == digits[10];
    }

    public String pesel;

    public String getPesel() {
        return pesel;
    }

    public Pesel(String pesel) {
        if (check(pesel)) {
            this.pesel = pesel;
        } else {
            throw new IllegalArgumentException("Podano zly pesel");
        }
    }

}