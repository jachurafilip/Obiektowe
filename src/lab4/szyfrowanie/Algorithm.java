package lab4.szyfrowanie;

interface Algorithm {
    String crypt(String s);

    String decrypt(String s);
}
