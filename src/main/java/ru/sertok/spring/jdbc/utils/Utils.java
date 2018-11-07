package ru.sertok.spring.jdbc.utils;

import java.io.UnsupportedEncodingException;
import java.util.function.Function;

public class Utils {

    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);

    public static String hash(String password) {
        return bcrypt.hash(password);
    }

    public static boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
        return bcrypt.verifyAndUpdateHash(password, hash, updateFunc);
    }


    public static String decode(String input) {
        try {
            if (input != null) {
                byte[] tmp = input.getBytes("Cp1252");
                return (new String(tmp, "Cp1251"));
            } else {
                return (null);
            }
        } catch (UnsupportedEncodingException ex) {
            return "Не поддерживаемая кодировка!";
        }
    }
}
