package org.antlr.intellij.plugin;

import com.intellij.lang.Language;

public class STv4Language extends Language {
    public static final STv4Language INSTANCE = new STv4Language();

    private STv4Language() {
        super("STv4");
    }
}
