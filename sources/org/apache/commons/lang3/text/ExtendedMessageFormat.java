package org.apache.commons.lang3.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class ExtendedMessageFormat extends MessageFormat {
    private static final String DUMMY_PATTERN = "";
    private static final char END_FE = '}';
    private static final String ESCAPED_QUOTE = "''";
    private static final int HASH_SEED = 31;
    private static final char QUOTE = '\'';
    private static final char START_FE = '{';
    private static final char START_FMT = ',';
    private static final long serialVersionUID = -2362048321261811743L;
    private final Map<String, ? extends FormatFactory> registry;
    private String toPattern;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    private StringBuilder appendQuotedString(String str, ParsePosition parsePosition, StringBuilder sb, boolean z) {
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        if (!z || charArray[index] != '\'') {
            int i2 = index;
            for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
                if (!z || !str.substring(index2).startsWith(ESCAPED_QUOTE)) {
                    char c2 = charArray[parsePosition.getIndex()];
                    next(parsePosition);
                    if (c2 == '\'') {
                        if (sb == null) {
                            return null;
                        }
                        sb.append(charArray, i2, parsePosition.getIndex() - i2);
                        return sb;
                    }
                } else {
                    sb.append(charArray, i2, parsePosition.getIndex() - i2);
                    sb.append(QUOTE);
                    parsePosition.setIndex(index2 + 2);
                    i2 = parsePosition.getIndex();
                }
            }
            throw new IllegalArgumentException("Unterminated quoted string at position " + index);
        }
        next(parsePosition);
        if (sb == null) {
            return null;
        }
        sb.append(QUOTE);
        return sb;
    }

    private boolean containsElements(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            for (Object obj : collection) {
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Format getFormat(String str) {
        String str2;
        if (this.registry != null) {
            int indexOf = str.indexOf(44);
            if (indexOf > 0) {
                String trim = str.substring(0, indexOf).trim();
                str2 = str.substring(indexOf + 1).trim();
                str = trim;
            } else {
                str2 = null;
            }
            FormatFactory formatFactory = (FormatFactory) this.registry.get(str);
            if (formatFactory != null) {
                return formatFactory.getFormat(str, str2, getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String str, ParsePosition parsePosition, boolean z) {
        appendQuotedString(str, parsePosition, (StringBuilder) null, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String insertFormats(java.lang.String r8, java.util.ArrayList<java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r7.containsElements(r9)
            if (r0 != 0) goto L_0x0007
            return r8
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r8.length()
            int r1 = r1 * 2
            r0.<init>(r1)
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            r3 = -1
            r4 = 0
        L_0x001a:
            int r5 = r1.getIndex()
            int r6 = r8.length()
            if (r5 >= r6) goto L_0x006c
            int r5 = r1.getIndex()
            char r5 = r8.charAt(r5)
            r6 = 39
            if (r5 == r6) goto L_0x0068
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 == r6) goto L_0x0042
            r6 = 125(0x7d, float:1.75E-43)
            if (r5 == r6) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            int r4 = r4 + -1
        L_0x003b:
            r0.append(r5)
            r7.next(r1)
            goto L_0x001a
        L_0x0042:
            int r4 = r4 + 1
            r0.append(r6)
            java.text.ParsePosition r5 = r7.next(r1)
            int r5 = r7.readArgumentIndex(r8, r5)
            r0.append(r5)
            r5 = 1
            if (r4 != r5) goto L_0x001a
            int r3 = r3 + 1
            java.lang.Object r5 = r9.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x001a
            r6 = 44
            r0.append(r6)
            r0.append(r5)
            goto L_0x001a
        L_0x0068:
            r7.appendQuotedString(r8, r1, r0, r2)
            goto L_0x001a
        L_0x006c:
            java.lang.String r8 = r0.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.ExtendedMessageFormat.insertFormats(java.lang.String, java.util.ArrayList):java.lang.String");
    }

    private ParsePosition next(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i2 = 1;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt == '\'') {
                getQuotedString(str, parsePosition, false);
            } else if (charAt == '{') {
                i2++;
            } else if (charAt == '}' && i2 - 1 == 0) {
                return str.substring(index2, parsePosition.getIndex());
            }
            next(parsePosition);
        }
        throw new IllegalArgumentException("Unterminated format element at position " + index);
    }

    private int readArgumentIndex(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!z && parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (Character.isWhitespace(charAt)) {
                seekNonWs(str, parsePosition);
                charAt = str.charAt(parsePosition.getIndex());
                if (!(charAt == ',' || charAt == '}')) {
                    z = true;
                    next(parsePosition);
                }
            }
            if ((charAt == ',' || charAt == '}') && sb.length() > 0) {
                try {
                    return Integer.parseInt(sb.toString());
                } catch (NumberFormatException unused) {
                }
            }
            sb.append(charAt);
            z = !Character.isDigit(charAt);
            next(parsePosition);
        }
        if (z) {
            throw new IllegalArgumentException("Invalid format argument index at position " + index + ": " + str.substring(index, parsePosition.getIndex()));
        }
        throw new IllegalArgumentException("Unterminated format element at position " + index);
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch);
            if (isMatch <= 0 || parsePosition.getIndex() >= str.length()) {
            }
            int isMatch2 = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch2);
            return;
        } while (parsePosition.getIndex() >= str.length());
    }

    public final void applyPattern(String str) {
        Format format;
        String str2;
        if (this.registry == null) {
            super.applyPattern(str);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char c2 = charArray[parsePosition.getIndex()];
            boolean z = true;
            if (c2 != '\'') {
                if (c2 == '{') {
                    i3++;
                    seekNonWs(str, parsePosition);
                    int index = parsePosition.getIndex();
                    int readArgumentIndex = readArgumentIndex(str, next(parsePosition));
                    sb.append('{');
                    sb.append(readArgumentIndex);
                    seekNonWs(str, parsePosition);
                    String str3 = null;
                    if (charArray[parsePosition.getIndex()] == ',') {
                        str2 = parseFormatDescription(str, next(parsePosition));
                        format = getFormat(str2);
                        if (format == null) {
                            sb.append(',');
                            sb.append(str2);
                        }
                    } else {
                        str2 = null;
                        format = null;
                    }
                    arrayList.add(format);
                    if (format != null) {
                        str3 = str2;
                    }
                    arrayList2.add(str3);
                    Validate.isTrue(arrayList.size() == i3);
                    if (arrayList2.size() != i3) {
                        z = false;
                    }
                    Validate.isTrue(z);
                    if (charArray[parsePosition.getIndex()] != '}') {
                        throw new IllegalArgumentException("Unreadable format element at position " + index);
                    }
                }
                sb.append(charArray[parsePosition.getIndex()]);
                next(parsePosition);
            } else {
                appendQuotedString(str, parsePosition, sb, true);
            }
        }
        super.applyPattern(sb.toString());
        this.toPattern = insertFormats(super.toPattern(), arrayList2);
        if (containsElements(arrayList)) {
            Format[] formats = getFormats();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Format format2 = (Format) it2.next();
                if (format2 != null) {
                    formats[i2] = format2;
                }
                i2++;
            }
            super.setFormats(formats);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !super.equals(obj) || ObjectUtils.notEqual(getClass(), obj.getClass())) {
            return false;
        }
        ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat) obj;
        return !ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern) && !ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry);
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + ObjectUtils.hashCode(this.registry)) * 31) + ObjectUtils.hashCode(this.toPattern);
    }

    public void setFormat(int i2, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormatByArgumentIndex(int i2, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public String toPattern() {
        return this.toPattern;
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, (Map<String, ? extends FormatFactory>) null);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map<String, ? extends FormatFactory> map) {
        super("");
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }

    public ExtendedMessageFormat(String str, Map<String, ? extends FormatFactory> map) {
        this(str, Locale.getDefault(), map);
    }
}
