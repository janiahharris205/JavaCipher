package personalprojects.javacipher;

/**
 *
 * @author JaNiah Harris
 */
public class ShiftCipher extends SubstitutionCipher {
    private int key;

    public ShiftCipher(int key) {
        this.key = key;
    }

    @Override
    public char encryptChar(char ch) {
        if (alphabetic(ch)) {
            return shiftChar(ch, key);
        }
        return ch;
    }

    @Override
    public char decryptChar(char ch) {
        if (alphabetic(ch)) {
            return shiftChar(ch, 26 - key);
        }
        return ch;
    }

    @Override
    public void reset() {
        // Shift cipher has no state to reset
    }
}