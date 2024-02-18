package personalprojects.javacipher;

/**
 *
 * @author JaNiah Harris
 */
abstract class SubstitutionCipher implements Cipher {
    public abstract char encryptChar(char ch);
    public abstract char decryptChar(char ch);
    public abstract void reset();

    public static boolean alphabetic(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static int getKeyNum(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        } else {
            return -1;
        }
    }

    public static char shiftChar(char ch, int key) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ((ch - 'A' + key) % 26 + 'A');
        } else if (ch >= 'a' && ch <= 'z') {
            return (char) ((ch - 'a' + key) % 26 + 'a');
        } else {
            return ch;
        }
    }

    @Override
    public String encrypt(String plaintext) {
        reset();
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            ciphertext.append(encryptChar(ch));
        }
        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        reset();
        StringBuilder plaintext = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            plaintext.append(decryptChar(ch));
        }
        return plaintext.toString();
    }
}
