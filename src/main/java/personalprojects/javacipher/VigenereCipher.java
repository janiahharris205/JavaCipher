package personalprojects.javacipher;

/**
 *
 * @author JaNiah Harris
 */
 
public class VigenereCipher extends SubstitutionCipher {
    private String keyword;
    private int keywordIndex;

    public VigenereCipher(String keyword) {
        this.keyword = keyword.toUpperCase();
        this.keywordIndex = 0;
    }

    @Override
    public char encryptChar(char ch) {
        if (alphabetic(ch)) {
            char keywordChar = keyword.charAt(keywordIndex);
            int key = getKeyNum(keywordChar);
            keywordIndex = (keywordIndex + 1) % keyword.length();
            return shiftChar(ch, key);
        }
        return ch;
    }

    @Override
    public char decryptChar(char ch) {
        if (alphabetic(ch)) {
            char keywordChar = keyword.charAt(keywordIndex);
            int key = getKeyNum(keywordChar);
            keywordIndex = (keywordIndex + 1) % keyword.length();
            return shiftChar(ch, 26 - key);
        }
        return ch;
    }

    @Override
    public void reset() {
        keywordIndex = 0;
    }
}

