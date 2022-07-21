package book.ClassicComputerScienceProblemsInJava.c1.p003UnbreakableEncryption;

import java.util.Random;

public class UnbreakableEncryption {
    // Generate *length* random bytes
    private static byte[] randomKey(int length){
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    // 1100 - original
    // 1000 - dummy

    // 1011 -en
    // 1000 -dummy

    // 1100

    public static KeyPair encrypt(String original){
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        for(int i=0; i < originalBytes.length; i++){
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }

        return new KeyPair(dummyKey, encryptedKey);
    }

    public static String decrypt(KeyPair kp){
        byte[] decrypted = new byte[kp.key1.length];
        for( int i=0; i < kp.key1.length; i++){
            decrypted[i] = (byte) (kp.key1[i] ^ kp.key2[i]);
        }

        return new String(decrypted);
    }

    public static void main(String[] args) {

       String tes = "test";
        System.out.println(encrypt("test"));
    }
}
