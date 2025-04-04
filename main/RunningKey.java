


public class RunningKey {

    public String EncryptRunningKey(String plainText,String Libri) {
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
}

