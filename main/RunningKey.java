

public class RunningKey {

    public static String Encrypt(String plainText, String Libri) {
        int plaintTextSize = plainText.length();
        String key = generateRepeatedKey(Libri,plaintTextSize);

        char[] plaintTextArray = plainText.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] cipherTextArray = new char[plaintTextSize];

        for (int i = 0; i < plaintTextSize; i++) {
            char currentChar = plaintTextArray[i];
            char keyChar = keyArray[i];

            if (!Character.isLetter(currentChar)) {
                cipherTextArray[i] = currentChar;
                continue;
            }
            if (Character.isUpperCase(currentChar) && Character.isUpperCase(keyChar)) {
                cipherTextArray[i] = (char) ((((currentChar - 'A') + (keyChar - 'A')) % 26) + 'A');
            } else if (Character.isUpperCase(currentChar)) {
                cipherTextArray[i] = (char) ((((currentChar - 'A') + (keyChar - 'a')) % 26) + 'A');
            } else if (Character.isUpperCase(keyChar)) {
                cipherTextArray[i] = (char) ((((currentChar - 'a') + (keyChar - 'A')) % 26) + 'a');
            } else {
                cipherTextArray[i] = (char) ((((currentChar - 'a') + (keyChar - 'a')) % 26) + 'a');
            }
        }
        return new String(cipherTextArray);
    }

    public static String Decrypt(String cipherText, String Libri) {
        int cipherTextSize = cipherText.length();
        String key = generateRepeatedKey(Libri,cipherTextSize);

        char[] cipherTextArray = cipherText.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] plainTextArray = new char[cipherTextSize];

        for (int i = 0; i < cipherTextSize; i++) {
            char currentChar = cipherTextArray[i];
            char keyChar = keyArray[i];

            if (!Character.isLetter(currentChar)) {
                plainTextArray[i] = currentChar;
                continue;
            }

            if (Character.isUpperCase(currentChar) && Character.isUpperCase(keyChar)) {
                plainTextArray[i] = (char) ((((currentChar - 'A') - (keyChar - 'A') + 26) % 26) + 'A');
            } else if (Character.isUpperCase(currentChar)) {
                plainTextArray[i] = (char) ((((currentChar - 'A') - (keyChar - 'a') + 26) % 26) + 'A');
            } else if (Character.isUpperCase(keyArray[i])) {
                plainTextArray[i] = (char) ((((currentChar - 'a') - (keyChar - 'A') + 26) % 26) + 'a');
            } else {
                plainTextArray[i] = (char) ((((currentChar - 'a') - (keyChar - 'a') + 26) % 26) + 'a');
            }
        }

        return new String(plainTextArray);
    }
    
    private static String generateRepeatedKey(String Libri, int requiredLength){
        StringBuilder keyBuilder = new StringBuilder();
        while (keyBuilder.length() < requiredLength) {
            keyBuilder.append(Libri);
        }
        return keyBuilder.substring(0,requiredLength);
    }
}

