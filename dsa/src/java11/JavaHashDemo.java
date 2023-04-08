package java11;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class JavaHashDemo {

    static String getPhpEquivalentSHA256Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(text.getBytes());

        StringBuilder hexString = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
//            hexString.append(Integer.toHexString(0xFF & bytes[i]));
            sb.append(String.format("%02x", bytes[i]));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        test1();
        test2();
    }

    static void test1() throws NoSuchAlgorithmException {
        String desired = "f1904cf1a9d73a55fa5de0ac823c4403ded71afd4c3248d00bdcd0866552bb79";
        System.out.println(desired.equals(getPhpEquivalentSHA256Hash("mary@example.com")));
    }

    static void test2() throws NoSuchAlgorithmException {
        String desired = "1ef970831d7963307784fa8688e8fce101a15685d62aa765fed23f3a2c576a4e";
        String desired2 = "a6e349c7a8850f27ebcfa1865854e845c074da83ff19384d4b4c9df78357fa5a";
        System.out.println(desired.equals(getPhpEquivalentSHA256Hash("+15559876543")));
        System.out.println(desired2.equals(getPhpEquivalentSHA256Hash("+15559876543")));
    }


}
