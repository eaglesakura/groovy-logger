package com.eaglesakura.tool.log
/**
 * ログ出力管理クラス
 */
public class Logger {
    private static int indent = 0;

    // インデントが指定以下の場合のみログを出力する
    static int outLogLevel = 4;

    private static String indentText = "";

    /**
     * このメソッドは現在何も行わない
     */
    @Deprecated
    public static void initialize() {
    }

    private static void updateIndentText() {
        indentText = "";
        for (int i = 0; i < indent; ++i) {
            indentText += " ";
        }
    }

    public static void pushIndent() {
        ++indent;
        updateIndentText();
    }

    public static void popIndent() {
        --indent;
        if (indent < 0) {
            throw new IllegalStateException("push indent < pop indent");
        }

        updateIndentText();
    }

    public static void out(String fmt, Object... formats) {
        out(String.format(fmt, formats));
    }

    public static void out(String message) {
        if (indent > outLogLevel) {
            return;
        }
        println(indentText + message);
    }

}
