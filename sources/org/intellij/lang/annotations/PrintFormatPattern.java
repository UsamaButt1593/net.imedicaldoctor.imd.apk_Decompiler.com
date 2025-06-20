package org.intellij.lang.annotations;

class PrintFormatPattern {
    @Language("RegExp")

    /* renamed from: a  reason: collision with root package name */
    private static final String f31549a = "(?:\\d+\\$)?";
    @Language("RegExp")

    /* renamed from: b  reason: collision with root package name */
    private static final String f31550b = "(?:[-#+ 0,(<]*)?";
    @Language("RegExp")

    /* renamed from: c  reason: collision with root package name */
    private static final String f31551c = "(?:\\d+)?";
    @Language("RegExp")

    /* renamed from: d  reason: collision with root package name */
    private static final String f31552d = "(?:\\.\\d+)?";
    @Language("RegExp")

    /* renamed from: e  reason: collision with root package name */
    private static final String f31553e = "(?:[tT])?(?:[a-zA-Z%])";
    @Language("RegExp")

    /* renamed from: f  reason: collision with root package name */
    private static final String f31554f = "[^%]|%%";
    @Language("RegExp")

    /* renamed from: g  reason: collision with root package name */
    static final String f31555g = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";

    PrintFormatPattern() {
    }
}
