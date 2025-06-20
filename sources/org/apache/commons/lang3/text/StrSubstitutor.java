package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators((Iterable<?>) list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor((StrLookup<?>) StrLookup.systemPropertiesLookup()).replace(obj);
    }

    private int substitute(StrBuilder strBuilder, int i2, int i3, List<String> list) {
        StrMatcher strMatcher;
        boolean z;
        char c2;
        StrMatcher strMatcher2;
        String str;
        int isMatch;
        StrBuilder strBuilder2 = strBuilder;
        int i4 = i2;
        int i5 = i3;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar2 = getEscapeChar();
        StrMatcher valueDelimiterMatcher2 = getValueDelimiterMatcher();
        boolean isEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean z2 = list == null;
        int i6 = i4;
        int i7 = i4 + i5;
        int i8 = 0;
        int i9 = 0;
        char[] cArr = strBuilder2.buffer;
        List<String> list2 = list;
        while (i6 < i7) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i6, i4, i7);
            if (isMatch2 != 0) {
                if (i6 > i4) {
                    int i10 = i6 - 1;
                    if (cArr[i10] == escapeChar2) {
                        strBuilder2.deleteCharAt(i10);
                        i8--;
                        i7--;
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c2 = escapeChar2;
                        cArr = strBuilder2.buffer;
                        z = z2;
                        i9 = 1;
                    }
                }
                int i11 = i6 + isMatch2;
                int i12 = i11;
                int i13 = 0;
                while (true) {
                    if (i12 >= i7) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c2 = escapeChar2;
                        z = z2;
                        i6 = i12;
                        break;
                    } else if (!isEnableSubstitutionInVariables || (isMatch = variablePrefixMatcher.isMatch(cArr, i12, i4, i7)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i12, i4, i7);
                        if (isMatch3 == 0) {
                            i12++;
                        } else if (i13 == 0) {
                            strMatcher2 = variableSuffixMatcher;
                            c2 = escapeChar2;
                            String str2 = new String(cArr, i11, (i12 - i6) - isMatch2);
                            if (isEnableSubstitutionInVariables) {
                                StrBuilder strBuilder3 = new StrBuilder(str2);
                                substitute(strBuilder3, 0, strBuilder3.length());
                                str2 = strBuilder3.toString();
                            }
                            int i14 = i12 + isMatch3;
                            if (valueDelimiterMatcher2 != null) {
                                char[] charArray = str2.toCharArray();
                                z = z2;
                                int i15 = 0;
                                while (i15 < charArray.length && (isEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i15, i15, charArray.length) == 0)) {
                                    int isMatch4 = valueDelimiterMatcher2.isMatch(charArray, i15);
                                    strMatcher = variablePrefixMatcher;
                                    if (isMatch4 != 0) {
                                        String substring = str2.substring(0, i15);
                                        str = str2.substring(i15 + isMatch4);
                                        str2 = substring;
                                        break;
                                    }
                                    i15++;
                                    variablePrefixMatcher = strMatcher;
                                }
                                strMatcher = variablePrefixMatcher;
                            } else {
                                strMatcher = variablePrefixMatcher;
                                z = z2;
                            }
                            str = null;
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                                list2.add(new String(cArr, i4, i5));
                            }
                            checkCyclicSubstitution(str2, list2);
                            list2.add(str2);
                            String resolveVariable = resolveVariable(str2, strBuilder2, i6, i14);
                            if (resolveVariable != null) {
                                str = resolveVariable;
                            }
                            if (str != null) {
                                int length = str.length();
                                strBuilder2.replace(i6, i14, str);
                                int substitute = (substitute(strBuilder2, i6, length, list2) + length) - (i14 - i6);
                                i7 += substitute;
                                i8 += substitute;
                                cArr = strBuilder2.buffer;
                                i6 = i14 + substitute;
                                i9 = 1;
                            } else {
                                i6 = i14;
                            }
                            list2.remove(list2.size() - 1);
                        } else {
                            StrMatcher strMatcher3 = variableSuffixMatcher;
                            boolean z3 = z2;
                            i13--;
                            i12 += isMatch3;
                            escapeChar2 = escapeChar2;
                            variablePrefixMatcher = variablePrefixMatcher;
                        }
                    } else {
                        i13++;
                        i12 += isMatch;
                    }
                }
            } else {
                i6++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
                c2 = escapeChar2;
                z = z2;
            }
            variableSuffixMatcher = strMatcher2;
            escapeChar2 = c2;
            z2 = z;
            variablePrefixMatcher = strMatcher;
        }
        return z2 ? i9 : i8;
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    /* access modifiers changed from: protected */
    public String resolveVariable(String str, StrBuilder strBuilder, int i2, int i3) {
        StrLookup<?> variableResolver2 = getVariableResolver();
        if (variableResolver2 == null) {
            return null;
        }
        return variableResolver2.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
    }

    public void setEscapeChar(char c2) {
        this.escapeChar = c2;
    }

    public StrSubstitutor setValueDelimiter(char c2) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c2));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c2) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c2));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c2) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c2));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public String replace(CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i3).append(charSequence, i2, i3);
        substitute(append, 0, i3);
        return append.toString();
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i2, int i3) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i3).append(stringBuffer, i2, i3);
        if (!substitute(append, 0, i3)) {
            return false;
        }
        stringBuffer.replace(i2, i3 + i2, append.toString());
        return true;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (!StringUtils.isEmpty(str)) {
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        setValueDelimiterMatcher((StrMatcher) null);
        return this;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    /* access modifiers changed from: protected */
    public boolean substitute(StrBuilder strBuilder, int i2, int i3) {
        return substitute(strBuilder, i2, i3, (List<String>) null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c2);
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public boolean replaceIn(StringBuilder sb, int i2, int i3) {
        if (sb == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i3).append(sb, i2, i3);
        if (!substitute(append, 0, i3)) {
            return false;
        }
        sb.replace(i2, i3 + i2, append.toString());
        return true;
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c2, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c2, str3);
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public boolean replaceIn(StrBuilder strBuilder, int i2, int i3) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i2, i3);
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c2) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c2);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c2, String str3) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c2);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i3).append(str, i2, i3);
        return !substitute(append, 0, i3) ? str.substring(i2, i3 + i2) : append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c2) {
        this(strLookup, strMatcher, strMatcher2, c2, DEFAULT_VALUE_DELIMITER);
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c2, StrMatcher strMatcher3) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c2);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(StringBuffer stringBuffer, int i2, int i3) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i3).append(stringBuffer, i2, i3);
        substitute(append, 0, i3);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i2, int i3) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i3).append(strBuilder, i2, i3);
        substitute(append, 0, i3);
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public String replace(char[] cArr, int i2, int i3) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i3).append(cArr, i2, i3);
        substitute(append, 0, i3);
        return append.toString();
    }
}
