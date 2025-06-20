package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StrTokenizer implements ListIterator<String>, Cloneable {
    private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE;
    private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
    private char[] chars;
    private StrMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StrMatcher ignoredMatcher;
    private StrMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StrMatcher trimmerMatcher;

    static {
        StrTokenizer strTokenizer = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = strTokenizer;
        strTokenizer.setDelimiterMatcher(StrMatcher.commaMatcher());
        strTokenizer.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer.setEmptyTokenAsNull(false);
        strTokenizer.setIgnoreEmptyTokens(false);
        StrTokenizer strTokenizer2 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = strTokenizer2;
        strTokenizer2.setDelimiterMatcher(StrMatcher.tabMatcher());
        strTokenizer2.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer2.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer2.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer2.setEmptyTokenAsNull(false);
        strTokenizer2.setIgnoreEmptyTokens(false);
    }

    public StrTokenizer() {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List<String> list, String str) {
        if (StringUtils.isEmpty(str)) {
            if (!isIgnoreEmptyTokens()) {
                if (isEmptyTokenAsNull()) {
                    str = null;
                }
            } else {
                return;
            }
        }
        list.add(str);
    }

    private void checkTokenized() {
        if (this.tokens == null) {
            char[] cArr = this.chars;
            if (cArr == null) {
                List<String> list = tokenize((char[]) null, 0, 0);
                this.tokens = (String[]) list.toArray(new String[list.size()]);
                return;
            }
            List<String> list2 = tokenize(cArr, 0, cArr.length);
            this.tokens = (String[]) list2.toArray(new String[list2.size()]);
        }
    }

    private static StrTokenizer getCSVClone() {
        return (StrTokenizer) CSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getCSVInstance() {
        return getCSVClone();
    }

    private static StrTokenizer getTSVClone() {
        return (StrTokenizer) TSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getTSVInstance() {
        return getTSVClone();
    }

    private boolean isQuote(char[] cArr, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i2 + i6;
            if (i7 >= i3 || cArr[i7] != cArr[i4 + i6]) {
                return false;
            }
        }
        return true;
    }

    private int readNextToken(char[] cArr, int i2, int i3, StrBuilder strBuilder, List<String> list) {
        while (i2 < i3) {
            int max = Math.max(getIgnoredMatcher().isMatch(cArr, i2, i2, i3), getTrimmerMatcher().isMatch(cArr, i2, i2, i3));
            if (max == 0 || getDelimiterMatcher().isMatch(cArr, i2, i2, i3) > 0 || getQuoteMatcher().isMatch(cArr, i2, i2, i3) > 0) {
                break;
            }
            i2 += max;
        }
        if (i2 >= i3) {
            addToken(list, "");
            return -1;
        }
        int isMatch = getDelimiterMatcher().isMatch(cArr, i2, i2, i3);
        if (isMatch > 0) {
            addToken(list, "");
            return i2 + isMatch;
        }
        int isMatch2 = getQuoteMatcher().isMatch(cArr, i2, i2, i3);
        if (isMatch2 <= 0) {
            return readWithQuotes(cArr, i2, i3, strBuilder, list, 0, 0);
        }
        return readWithQuotes(cArr, i2 + isMatch2, i3, strBuilder, list, i2, isMatch2);
    }

    private int readWithQuotes(char[] cArr, int i2, int i3, StrBuilder strBuilder, List<String> list, int i4, int i5) {
        char c2;
        char[] cArr2 = cArr;
        int i6 = i2;
        int i7 = i3;
        StrBuilder strBuilder2 = strBuilder;
        List<String> list2 = list;
        int i8 = i5;
        strBuilder.clear();
        boolean z = i8 > 0;
        int i9 = i6;
        int i10 = 0;
        while (i9 < i7) {
            if (z) {
                int i11 = i10;
                int i12 = i9;
                if (isQuote(cArr, i9, i3, i4, i5)) {
                    int i13 = i12 + i8;
                    if (isQuote(cArr, i13, i3, i4, i5)) {
                        strBuilder2.append(cArr2, i12, i8);
                        i9 = i12 + (i8 * 2);
                    } else {
                        i10 = i11;
                        i9 = i13;
                        z = false;
                    }
                } else {
                    i9 = i12 + 1;
                    c2 = cArr2[i12];
                    strBuilder2.append(c2);
                }
            } else {
                int i14 = i10;
                int i15 = i9;
                int isMatch = getDelimiterMatcher().isMatch(cArr2, i15, i6, i7);
                if (isMatch > 0) {
                    addToken(list2, strBuilder2.substring(0, i14));
                    return i15 + isMatch;
                } else if (i8 <= 0 || !isQuote(cArr, i15, i3, i4, i5)) {
                    int isMatch2 = getIgnoredMatcher().isMatch(cArr2, i15, i6, i7);
                    if (isMatch2 <= 0) {
                        isMatch2 = getTrimmerMatcher().isMatch(cArr2, i15, i6, i7);
                        if (isMatch2 > 0) {
                            strBuilder2.append(cArr2, i15, isMatch2);
                        } else {
                            i9 = i15 + 1;
                            c2 = cArr2[i15];
                            strBuilder2.append(c2);
                        }
                    }
                    i9 = i15 + isMatch2;
                    i10 = i14;
                } else {
                    i9 = i15 + i8;
                    i10 = i14;
                    z = true;
                }
            }
            i10 = strBuilder.size();
        }
        addToken(list2, strBuilder2.substring(0, i10));
        return -1;
    }

    public Object clone() {
        try {
            return cloneReset();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Object cloneReset() throws CloneNotSupportedException {
        StrTokenizer strTokenizer = (StrTokenizer) super.clone();
        char[] cArr = strTokenizer.chars;
        if (cArr != null) {
            strTokenizer.chars = (char[]) cArr.clone();
        }
        strTokenizer.reset();
        return strTokenizer;
    }

    public String getContent() {
        char[] cArr = this.chars;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public StrMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StrMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StrMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public String[] getTokenArray() {
        checkTokenized();
        return (String[]) this.tokens.clone();
    }

    public List<String> getTokenList() {
        checkTokenized();
        ArrayList arrayList = new ArrayList(this.tokens.length);
        for (String add : this.tokens) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public StrMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    public boolean hasNext() {
        checkTokenized();
        return this.tokenPos < this.tokens.length;
    }

    public boolean hasPrevious() {
        checkTokenized();
        return this.tokenPos > 0;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    public int nextIndex() {
        return this.tokenPos;
    }

    public String nextToken() {
        if (!hasNext()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i2 = this.tokenPos;
        this.tokenPos = i2 + 1;
        return strArr[i2];
    }

    public int previousIndex() {
        return this.tokenPos - 1;
    }

    public String previousToken() {
        if (!hasPrevious()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i2 = this.tokenPos - 1;
        this.tokenPos = i2;
        return strArr[i2];
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public StrTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    public StrTokenizer setDelimiterChar(char c2) {
        return setDelimiterMatcher(StrMatcher.charMatcher(c2));
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            strMatcher = StrMatcher.noneMatcher();
        }
        this.delimMatcher = strMatcher;
        return this;
    }

    public StrTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z) {
        this.emptyAsNull = z;
        return this;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z) {
        this.ignoreEmptyTokens = z;
        return this;
    }

    public StrTokenizer setIgnoredChar(char c2) {
        return setIgnoredMatcher(StrMatcher.charMatcher(c2));
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.ignoredMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setQuoteChar(char c2) {
        return setQuoteMatcher(StrMatcher.charMatcher(c2));
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.quoteMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.trimmerMatcher = strMatcher;
        }
        return this;
    }

    public int size() {
        checkTokenized();
        return this.tokens.length;
    }

    public String toString() {
        if (this.tokens == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + getTokenList();
    }

    /* access modifiers changed from: protected */
    public List<String> tokenize(char[] cArr, int i2, int i3) {
        if (cArr == null || i3 == 0) {
            return Collections.emptyList();
        }
        StrBuilder strBuilder = new StrBuilder();
        ArrayList arrayList = new ArrayList();
        int i4 = i2;
        while (i4 >= 0 && i4 < i3) {
            i4 = readNextToken(cArr, i4, i3, strBuilder, arrayList);
            if (i4 >= i3) {
                addToken(arrayList, "");
            }
        }
        return arrayList;
    }

    public StrTokenizer(String str) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
    }

    public static StrTokenizer getCSVInstance(String str) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(str);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(String str) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(str);
        return tSVClone;
    }

    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public String next() {
        if (hasNext()) {
            String[] strArr = this.tokens;
            int i2 = this.tokenPos;
            this.tokenPos = i2 + 1;
            return strArr[i2];
        }
        throw new NoSuchElementException();
    }

    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.tokens;
            int i2 = this.tokenPos - 1;
            this.tokenPos = i2;
            return strArr[i2];
        }
        throw new NoSuchElementException();
    }

    public StrTokenizer reset(String str) {
        reset();
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
        return this;
    }

    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public StrTokenizer(String str, char c2) {
        this(str);
        setDelimiterChar(c2);
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(cArr);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(cArr);
        return tSVClone;
    }

    public StrTokenizer reset(char[] cArr) {
        reset();
        this.chars = ArrayUtils.clone(cArr);
        return this;
    }

    public StrTokenizer(String str, char c2, char c3) {
        this(str, c2);
        setQuoteChar(c3);
    }

    public StrTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = ArrayUtils.clone(cArr);
    }

    public StrTokenizer(char[] cArr, char c2) {
        this(cArr);
        setDelimiterChar(c2);
    }

    public StrTokenizer(char[] cArr, char c2, char c3) {
        this(cArr, c2);
        setQuoteChar(c3);
    }

    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        setQuoteMatcher(strMatcher2);
    }
}
