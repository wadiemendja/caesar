public class Main {
    // alphabet
    static char alpha[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'j', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    static String encrypte(String message, int key) {
        String encryptedMessage = "";
        for (int j = 0; j < message.length(); j++) {
            boolean found = false;
            for (int i = 0; i < alpha.length; i++) {
                if (message.charAt(j) == alpha[i]) {
                    found = true;
                    int newLetterPosition = i + key;
                    if (newLetterPosition < alpha.length) {
                        encryptedMessage += alpha[newLetterPosition];
                    } else {
                        int newLetterPosition2 = (i + key) - alpha.length;
                        encryptedMessage += alpha[newLetterPosition2];
                    }
                }
            }
            if (!found)
                encryptedMessage += message.charAt(j);
        }
        return encryptedMessage;
    }

    static String decrypte(String message, int key) {
        String decryptedMessage = "";
        for (int j = 0; j < message.length(); j++) {
            boolean found = false;
            for (int i = 0; i < alpha.length; i++) {
                if (message.charAt(j) == alpha[i]) {
                    found = true;
                    int newLetterPosition = i - key;
                    if (newLetterPosition >= 0) {
                        decryptedMessage += alpha[newLetterPosition];
                    } else {
                        int newLetterPosition2 = (alpha.length) + newLetterPosition;
                        decryptedMessage += alpha[newLetterPosition2];
                    }
                }
            }
            if (!found)
                decryptedMessage += message.charAt(j);
        }
        return decryptedMessage;
    }

    public static void main(String args[]) {
        // clé de chefferement
        int key = 5;
        // message to encrypte
        String message = "hello wadie how are you ?";
        System.out.println("Message : " + message + " | with the key = " + key);
        // encrypte
        String encyptedString = encrypte(message, key);
        System.out.println("Encrypted message : " + encyptedString);
        System.out.println("Decrypted message : " + decrypte(encyptedString, key));
    }
}
