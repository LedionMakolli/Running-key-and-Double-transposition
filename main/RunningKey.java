

public class RunningKey {

    public static String Encrypt(String plainText, String Libri) {
        plainText = plainText.replace(" ","");
        int plaintTextSize = plainText.length();
        String key = Libri.substring(0,plaintTextSize);

        char[] plaintTextArray = plainText.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] cipherTextArray = new char[plaintTextSize];

        for (int i = 0; i < plaintTextSize; i++) {
            if (Character.isUpperCase(plaintTextArray[i]) && Character.isUpperCase(keyArray[i])) {
                cipherTextArray[i] = (char) ((((plaintTextArray[i] - 'A' ) + (keyArray[i] - 'A')) % 26) + 'A');
            }else if(Character.isUpperCase(plaintTextArray[i])) {
                cipherTextArray[i] = (char) ((((plaintTextArray[i] - 'A' ) + (keyArray[i]  - 'a')) % 26) + 'A');
            }
            else if(Character.isUpperCase(keyArray[i])) {
                cipherTextArray[i] = (char) ((((plaintTextArray[i] - 'a') + (keyArray[i] - 'A')) % 26) + 'a');
            }else {
                cipherTextArray[i] = (char) ((((plaintTextArray[i] - 'a' ) + (keyArray[i] - 'a')) % 26) + 'a');
            }
        }


        return new String(cipherTextArray);
    }

    public static String Decrypt(String cipherText, String Libri) {
        cipherText = cipherText.replace(" ","");
        int cipherTextSize = cipherText.length();
        String key = Libri.substring(0, cipherTextSize);

        char[] cipherTextArray = cipherText.toCharArray();
        char[] keyArray = key.toCharArray();
        char[] plainTextArray = new char[cipherTextSize];

        for (int i = 0; i < cipherTextSize; i++) {
            if (Character.isUpperCase(cipherTextArray[i]) && Character.isUpperCase(keyArray[i])) {
                plainTextArray[i] = (char) ((((cipherTextArray[i] - 'A') - (keyArray[i] - 'A') + 26) % 26) + 'A');
            } else if (Character.isUpperCase(cipherTextArray[i])) {
                plainTextArray[i] = (char) ((((cipherTextArray[i] - 'A') - (keyArray[i] - 'a') + 26) % 26) + 'A');
            } else if (Character.isUpperCase(keyArray[i])) {
                plainTextArray[i] = (char) ((((cipherTextArray[i] - 'a') - (keyArray[i] - 'A') + 26) % 26) + 'a');
            } else {
                plainTextArray[i] = (char) ((((cipherTextArray[i] - 'a') - (keyArray[i] - 'a') + 26) % 26) + 'a');
            }
        }

        return new String(plainTextArray);
    }
}

