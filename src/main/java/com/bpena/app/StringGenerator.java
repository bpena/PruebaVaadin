package com.bpena.app;

import com.vaadin.shared.util.SharedUtil;

/**
 * Created by Bernardo on 15/5/2016.
 */
public class StringGenerator {
    static String[] strings = new String[] { "lorem", "ipsum", "dolor", "sit",
            "amet", "consectetur", "quid", "securi", "etiam", "tamquam", "eu",
            "fugiat", "nulla", "pariatur" };
    int stringCount = -1;

    public String nextString(boolean capitalize) {
        if (++stringCount >= strings.length) {
            stringCount = 0;
        }
        return capitalize ? SharedUtil.capitalize(strings[stringCount])
                : strings[stringCount];
    }
}
