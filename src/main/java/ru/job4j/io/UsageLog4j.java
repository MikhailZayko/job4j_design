package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 1;
        short s = 12;
        int i = 123;
        long l = 1234L;
        float f = 1234.5F;
        double d = 1234.56D;
        char c = 'C';
        boolean bool = false;
        LOG.debug("byte : {}, short : {}, int : {}, long : {}, float : {}, double : {}, char : {}, boolean : {}",
                b, s, i, l, f, d, c, bool);
    }
}