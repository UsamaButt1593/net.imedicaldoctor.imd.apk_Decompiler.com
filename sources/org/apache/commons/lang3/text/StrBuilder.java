package org.apache.commons.lang3.text;

import com.itextpdf.text.pdf.Barcode128;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.Builder;

public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        StrBuilderReader() {
        }

        public void close() {
        }

        public void mark(int i2) {
            this.mark = this.pos;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i2 = this.pos;
            this.pos = i2 + 1;
            return strBuilder.charAt(i2);
        }

        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        public void reset() {
            this.pos = this.mark;
        }

        public long skip(long j2) {
            if (((long) this.pos) + j2 > ((long) StrBuilder.this.size())) {
                j2 = (long) (StrBuilder.this.size() - this.pos);
            }
            if (j2 < 0) {
                return 0;
            }
            this.pos = (int) (((long) this.pos) + j2);
            return j2;
        }

        public int read(char[] cArr, int i2, int i3) {
            int i4;
            if (i2 < 0 || i3 < 0 || i2 > cArr.length || (i4 = i2 + i3) > cArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            } else if (i3 == 0) {
                return 0;
            } else {
                if (this.pos >= StrBuilder.this.size()) {
                    return -1;
                }
                if (this.pos + i3 > StrBuilder.this.size()) {
                    i3 = StrBuilder.this.size() - this.pos;
                }
                StrBuilder strBuilder = StrBuilder.this;
                int i5 = this.pos;
                strBuilder.getChars(i5, i5 + i3, cArr, i2);
                this.pos += i3;
                return i3;
            }
        }
    }

    class StrBuilderTokenizer extends StrTokenizer {
        StrBuilderTokenizer() {
        }

        public String getContent() {
            String content = super.getContent();
            return content == null ? StrBuilder.this.toString() : content;
        }

        /* access modifiers changed from: protected */
        public List<String> tokenize(char[] cArr, int i2, int i3) {
            if (cArr != null) {
                return super.tokenize(cArr, i2, i3);
            }
            StrBuilder strBuilder = StrBuilder.this;
            return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
        }
    }

    class StrBuilderWriter extends Writer {
        StrBuilderWriter() {
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i2) {
            StrBuilder.this.append((char) i2);
        }

        public void write(String str) {
            StrBuilder.this.append(str);
        }

        public void write(String str, int i2, int i3) {
            StrBuilder.this.append(str, i2, i3);
        }

        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        public void write(char[] cArr, int i2, int i3) {
            StrBuilder.this.append(cArr, i2, i3);
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i2, int i3, int i4) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i3, cArr, i2, this.size - i3);
        this.size -= i4;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i2, int i3, int i4) {
        if (!(strMatcher == null || this.size == 0)) {
            int length = str == null ? 0 : str.length();
            char[] cArr = this.buffer;
            int i5 = i2;
            while (i5 < i3 && i4 != 0) {
                int isMatch = strMatcher.isMatch(cArr, i5, i2, i3);
                if (isMatch > 0) {
                    replaceImpl(i5, i5 + isMatch, isMatch, str, length);
                    i3 = (i3 - isMatch) + length;
                    i5 = (i5 + length) - 1;
                    if (i4 > 0) {
                        i4--;
                    }
                }
                i5++;
            }
        }
        return this;
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            for (Object append : iterable) {
                append((Object) append);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(int i2, int i3, char c2) {
        return appendFixedWidthPadLeft((Object) String.valueOf(i2), i3, c2);
    }

    public StrBuilder appendFixedWidthPadRight(int i2, int i3, char c2) {
        return appendFixedWidthPadRight((Object) String.valueOf(i2), i3, c2);
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str != null) {
            return append(str);
        }
        append(SystemUtils.LINE_SEPARATOR);
        return this;
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public StrBuilder appendPadding(int i2, char c2) {
        if (i2 >= 0) {
            ensureCapacity(this.size + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                char[] cArr = this.buffer;
                int i4 = this.size;
                this.size = i4 + 1;
                cArr[i4] = c2;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2) {
        if (size() > 0) {
            append(c2);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String objectUtils = ObjectUtils.toString(str);
            Iterator<?> it2 = iterable.iterator();
            while (it2.hasNext()) {
                append((Object) it2.next());
                if (it2.hasNext()) {
                    append(objectUtils);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(char c2) {
        return append(c2).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public char charAt(int i2) {
        if (i2 >= 0 && i2 < length()) {
            return this.buffer[i2];
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c2) {
        char[] cArr = this.buffer;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (cArr[i2] == c2) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i2, int i3) {
        int validateRange = validateRange(i2, i3);
        int i4 = validateRange - i2;
        if (i4 > 0) {
            deleteImpl(i2, validateRange, i4);
        }
        return this;
    }

    public StrBuilder deleteAll(char c2) {
        int i2 = 0;
        while (i2 < this.size) {
            if (this.buffer[i2] == c2) {
                int i3 = i2;
                do {
                    i3++;
                    if (i3 >= this.size || this.buffer[i3] != c2) {
                        int i4 = i3 - i2;
                        deleteImpl(i2, i3, i4);
                        i2 = i3 - i4;
                    }
                    i3++;
                    break;
                } while (this.buffer[i3] != c2);
                int i42 = i3 - i2;
                deleteImpl(i2, i3, i42);
                i2 = i3 - i42;
            }
            i2++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        deleteImpl(i2, i2 + 1, 1);
        return this;
    }

    public StrBuilder deleteFirst(char c2) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.size) {
                break;
            } else if (this.buffer[i2] == c2) {
                deleteImpl(i2, i2 + 1, 1);
                break;
            } else {
                i2++;
            }
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i2 = this.size;
        if (length > i2) {
            return false;
        }
        int i3 = i2 - length;
        int i4 = 0;
        while (i4 < length) {
            if (this.buffer[i3] != str.charAt(i4)) {
                return false;
            }
            i4++;
            i3++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i2) {
        char[] cArr = this.buffer;
        if (i2 > cArr.length) {
            char[] cArr2 = new char[(i2 * 2)];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrBuilder) {
            return equals((StrBuilder) obj);
        }
        return false;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i2 = this.size;
        if (i2 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            char c2 = cArr[i3];
            char c3 = cArr2[i3];
            if (c2 != c3 && Character.toUpperCase(c2) != Character.toUpperCase(c3)) {
                return false;
            }
        }
        return true;
    }

    public void getChars(int i2, int i3, char[] cArr, int i4) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        } else if (i3 < 0 || i3 > length()) {
            throw new StringIndexOutOfBoundsException(i3);
        } else if (i2 <= i3) {
            System.arraycopy(this.buffer, i2, cArr, i4, i3 - i2);
        } else {
            throw new StringIndexOutOfBoundsException("end < start");
        }
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i2 = 0;
        for (int i3 = this.size - 1; i3 >= 0; i3--) {
            i2 = (i2 * 31) + cArr[i3];
        }
        return i2;
    }

    public int indexOf(char c2) {
        return indexOf(c2, 0);
    }

    public StrBuilder insert(int i2, char c2) {
        validateIndex(i2);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i2 + 1, this.size - i2);
        this.buffer[i2] = c2;
        this.size++;
        return this;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(char c2) {
        return lastIndexOf(c2, this.size - 1);
    }

    public String leftString(int i2) {
        if (i2 <= 0) {
            return "";
        }
        int i3 = this.size;
        return i2 >= i3 ? new String(this.buffer, 0, i3) : new String(this.buffer, 0, i2);
    }

    public int length() {
        return this.size;
    }

    public String midString(int i2, int i3) {
        int i4;
        if (i2 < 0) {
            i2 = 0;
        }
        return (i3 <= 0 || i2 >= (i4 = this.size)) ? "" : i4 <= i2 + i3 ? new String(this.buffer, i2, i4 - i2) : new String(this.buffer, i2, i3);
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public StrBuilder replace(int i2, int i3, String str) {
        int validateRange = validateRange(i2, i3);
        replaceImpl(i2, validateRange, validateRange - i2, str, str == null ? 0 : str.length());
        return this;
    }

    public StrBuilder replaceAll(char c2, char c3) {
        if (c2 != c3) {
            for (int i2 = 0; i2 < this.size; i2++) {
                char[] cArr = this.buffer;
                if (cArr[i2] == c2) {
                    cArr[i2] = c3;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c2, char c3) {
        if (c2 != c3) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i2] == c2) {
                    cArr[i2] = c3;
                    break;
                }
                i2++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i2 = this.size;
        if (i2 == 0) {
            return this;
        }
        int i3 = i2 / 2;
        char[] cArr = this.buffer;
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 < i3) {
            char c2 = cArr[i5];
            cArr[i5] = cArr[i4];
            cArr[i4] = c2;
            i5++;
            i4--;
        }
        return this;
    }

    public String rightString(int i2) {
        if (i2 <= 0) {
            return "";
        }
        int i3 = this.size;
        return i2 >= i3 ? new String(this.buffer, 0, i3) : new String(this.buffer, i3 - i2, i2);
    }

    public StrBuilder setCharAt(int i2, char c2) {
        if (i2 < 0 || i2 >= length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        this.buffer[i2] = c2;
        return this;
    }

    public StrBuilder setLength(int i2) {
        if (i2 >= 0) {
            int i3 = this.size;
            if (i2 < i3) {
                this.size = i2;
            } else if (i2 > i3) {
                ensureCapacity(i2);
                this.size = i2;
                for (int i4 = this.size; i4 < i2; i4++) {
                    this.buffer[i4] = 0;
                }
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.buffer[i2] != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public CharSequence subSequence(int i2, int i3) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        } else if (i3 > this.size) {
            throw new StringIndexOutOfBoundsException(i3);
        } else if (i2 <= i3) {
            return substring(i2, i3);
        } else {
            throw new StringIndexOutOfBoundsException(i3 - i2);
        }
    }

    public String substring(int i2) {
        return substring(i2, this.size);
    }

    public char[] toCharArray() {
        int i2 = this.size;
        if (i2 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i2];
        System.arraycopy(this.buffer, 0, cArr, 0, i2);
        return cArr;
    }

    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(this.size);
        sb.append(this.buffer, 0, this.size);
        return sb;
    }

    public StrBuilder trim() {
        int i2 = this.size;
        if (i2 == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i3 = 0;
        while (i3 < i2 && cArr[i3] <= ' ') {
            i3++;
        }
        while (i3 < i2 && cArr[i2 - 1] <= ' ') {
            i2--;
        }
        int i4 = this.size;
        if (i2 < i4) {
            delete(i2, i4);
        }
        if (i3 > 0) {
            delete(0, i3);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void validateIndex(int i2) {
        if (i2 < 0 || i2 > this.size) {
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    /* access modifiers changed from: protected */
    public int validateRange(int i2, int i3) {
        if (i2 >= 0) {
            int i4 = this.size;
            if (i3 > i4) {
                i3 = i4;
            }
            if (i2 <= i3) {
                return i3;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    public StrBuilder(int i2) {
        this.buffer = new char[(i2 <= 0 ? 32 : i2)];
    }

    private void replaceImpl(int i2, int i3, int i4, String str, int i5) {
        int i6 = (this.size - i4) + i5;
        if (i5 != i4) {
            ensureCapacity(i6);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i3, cArr, i2 + i5, this.size - i3);
            this.size = i6;
        }
        if (i5 > 0) {
            str.getChars(0, i5, this.buffer, i2);
        }
    }

    public StrBuilder appendAll(Iterator<?> it2) {
        if (it2 != null) {
            while (it2.hasNext()) {
                append((Object) it2.next());
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i2, char c2) {
        if (i2 > 0) {
            ensureCapacity(this.size + i2);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i2) {
                nullText2.getChars(length - i2, length, this.buffer, this.size);
            } else {
                int i3 = i2 - length;
                for (int i4 = 0; i4 < i3; i4++) {
                    this.buffer[this.size + i4] = c2;
                }
                nullText2.getChars(0, length, this.buffer, this.size + i3);
            }
            this.size += i2;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i2, char c2) {
        if (i2 > 0) {
            ensureCapacity(this.size + i2);
            String nullText2 = obj == null ? getNullText() : obj.toString();
            if (nullText2 == null) {
                nullText2 = "";
            }
            int length = nullText2.length();
            if (length >= i2) {
                nullText2.getChars(0, i2, this.buffer, this.size);
            } else {
                int i3 = i2 - length;
                nullText2.getChars(0, length, this.buffer, this.size);
                for (int i4 = 0; i4 < i3; i4++) {
                    this.buffer[this.size + length + i4] = c2;
                }
            }
            this.size += i2;
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2, char c3) {
        if (size() > 0) {
            append(c2);
        } else {
            append(c3);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Iterator<?> it2, String str) {
        if (it2 != null) {
            String objectUtils = ObjectUtils.toString(str);
            while (it2.hasNext()) {
                append((Object) it2.next());
                if (it2.hasNext()) {
                    append(objectUtils);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(double d2) {
        return append(d2).appendNewLine();
    }

    public String build() {
        return toString();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteAll(String str) {
        int i2 = 0;
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            while (true) {
                i2 = indexOf(str, i2);
                if (i2 < 0) {
                    break;
                }
                deleteImpl(i2, i2 + length, length);
            }
        }
        return this;
    }

    public StrBuilder deleteFirst(String str) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(indexOf, indexOf + length, length);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i2 = this.size;
        if (i2 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (cArr[i3] != cArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public int indexOf(char c2, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i2 < this.size) {
            if (cArr[i2] == c2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public StrBuilder insert(int i2, double d2) {
        return insert(i2, String.valueOf(d2));
    }

    public int lastIndexOf(char c2, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            i2 = i3 - 1;
        }
        if (i2 < 0) {
            return -1;
        }
        while (i2 >= 0) {
            if (this.buffer[i2] == c2) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i2, int i3, int i4) {
        return replaceImpl(strMatcher, str, i2, validateRange(i2, i3), i4);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int i2 = 0;
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            while (true) {
                int indexOf = indexOf(str, i2);
                if (indexOf < 0) {
                    break;
                }
                replaceImpl(indexOf, indexOf + length, length, str2, length2);
                i2 = indexOf + length2;
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(indexOf, indexOf + length, length, str2, str2 == null ? 0 : str2.length());
        }
        return this;
    }

    public String substring(int i2, int i3) {
        return new String(this.buffer, i2, validateRange(i2, i3) - i2);
    }

    public char[] toCharArray(int i2, int i3) {
        int validateRange = validateRange(i2, i3) - i2;
        if (validateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[validateRange];
        System.arraycopy(this.buffer, i2, cArr, 0, validateRange);
        return cArr;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
            return;
        }
        this.buffer = new char[(str.length() + 32)];
        append(str);
    }

    public <T> StrBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T append : tArr) {
                append((Object) append);
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c2, int i2) {
        if (i2 > 0) {
            append(c2);
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String objectUtils = ObjectUtils.toString(str);
            append(objArr[0]);
            for (int i2 = 1; i2 < objArr.length; i2++) {
                append(objectUtils);
                append(objArr[i2]);
            }
        }
        return this;
    }

    public StrBuilder appendln(float f2) {
        return append(f2).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, (String) null, 0, this.size, -1);
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, (String) null, 0, this.size, 1);
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder insert(int i2, float f2) {
        return insert(i2, String.valueOf(f2));
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder append(char c2) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i2 = this.size;
        this.size = i2 + 1;
        cArr[i2] = c2;
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public StrBuilder appendln(int i2) {
        return append(i2).appendNewLine();
    }

    public int indexOf(String str, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (str != null && i2 < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), i2);
            }
            if (length == 0) {
                return i2;
            }
            int i3 = this.size;
            if (length > i3) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i4 = (i3 - length) + 1;
            while (i2 < i4) {
                int i5 = 0;
                while (i5 < length) {
                    if (str.charAt(i5) != cArr[i2 + i5]) {
                        i2++;
                    } else {
                        i5++;
                    }
                }
                return i2;
            }
        }
        return -1;
    }

    public StrBuilder insert(int i2, int i3) {
        return insert(i2, String.valueOf(i3));
    }

    public int lastIndexOf(String str, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            i2 = i3 - 1;
        }
        if (str != null && i2 >= 0) {
            int length = str.length();
            if (length <= 0 || length > this.size) {
                if (length == 0) {
                    return i2;
                }
            } else if (length == 1) {
                return lastIndexOf(str.charAt(0), i2);
            } else {
                int i4 = (i2 - length) + 1;
                while (i4 >= 0) {
                    int i5 = 0;
                    while (i5 < length) {
                        if (str.charAt(i5) != this.buffer[i4 + i5]) {
                            i4--;
                        } else {
                            i5++;
                        }
                    }
                    return i4;
                }
            }
        }
        return -1;
    }

    public StrBuilder append(double d2) {
        return append(String.valueOf(d2));
    }

    public StrBuilder appendSeparator(String str, int i2) {
        if (str != null && i2 > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(long j2) {
        return append(j2).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder insert(int i2, long j2) {
        return insert(i2, String.valueOf(j2));
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder append(float f2) {
        return append(String.valueOf(f2));
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i2) {
        int i3;
        if (i2 < 0) {
            i2 = 0;
        }
        if (strMatcher != null && i2 < (i3 = this.size)) {
            char[] cArr = this.buffer;
            for (int i4 = i2; i4 < i3; i4++) {
                if (strMatcher.isMatch(cArr, i4, i2, i3) > 0) {
                    return i4;
                }
            }
        }
        return -1;
    }

    public StrBuilder insert(int i2, Object obj) {
        return insert(i2, obj == null ? this.nullText : obj.toString());
    }

    public int lastIndexOf(StrMatcher strMatcher, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            i2 = i3 - 1;
        }
        if (strMatcher != null && i2 >= 0) {
            char[] cArr = this.buffer;
            int i4 = i2 + 1;
            while (i2 >= 0) {
                if (strMatcher.isMatch(cArr, i2, 0, i4) > 0) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    public StrBuilder append(int i2) {
        return append(String.valueOf(i2));
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public StrBuilder insert(int i2, String str) {
        int length;
        validateIndex(i2);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i3 = this.size + length;
            ensureCapacity(i3);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i2 + length, this.size - i2);
            this.size = i3;
            str.getChars(0, length, this.buffer, i2);
        }
        return this;
    }

    public StrBuilder append(long j2) {
        return append(String.valueOf(j2));
    }

    public StrBuilder appendln(String str, int i2, int i3) {
        return append(str, i2, i3).appendNewLine();
    }

    public StrBuilder insert(int i2, boolean z) {
        int i3;
        validateIndex(i2);
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i2 + 4, this.size - i2);
            char[] cArr2 = this.buffer;
            cArr2[i2] = 't';
            cArr2[i2 + 1] = 'r';
            cArr2[i2 + 2] = 'u';
            cArr2[i2 + 3] = Barcode128.H;
            i3 = this.size + 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i2, cArr3, i2 + 5, this.size - i2);
            char[] cArr4 = this.buffer;
            cArr4[i2] = Barcode128.I;
            cArr4[i2 + 1] = 'a';
            cArr4[i2 + 2] = 'l';
            cArr4[i2 + 3] = 's';
            cArr4[i2 + 4] = Barcode128.H;
            i3 = this.size + 5;
        }
        this.size = i3;
        return this;
    }

    public StrBuilder append(CharSequence charSequence) {
        return charSequence == null ? appendNull() : append(charSequence.toString());
    }

    public StrBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public StrBuilder insert(int i2, char[] cArr) {
        validateIndex(i2);
        if (cArr == null) {
            return insert(i2, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i2, cArr2, i2 + length, this.size - i2);
            System.arraycopy(cArr, 0, this.buffer, i2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(CharSequence charSequence, int i2, int i3) {
        return charSequence == null ? appendNull() : append(charSequence.toString(), i2, i3);
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public StrBuilder insert(int i2, char[] cArr, int i3, int i4) {
        validateIndex(i2);
        if (cArr == null) {
            return insert(i2, this.nullText);
        }
        if (i3 < 0 || i3 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + i3);
        } else if (i4 < 0 || i3 + i4 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i4);
        } else {
            if (i4 > 0) {
                ensureCapacity(this.size + i4);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i2, cArr2, i2 + i4, this.size - i2);
                System.arraycopy(cArr, i3, this.buffer, i2, i4);
                this.size += i4;
            }
            return this;
        }
    }

    public StrBuilder append(Object obj) {
        return obj == null ? appendNull() : append(obj.toString());
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i2, int i3) {
        return append(stringBuffer, i2, i3).appendNewLine();
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb) {
        return append(sb).appendNewLine();
    }

    public StrBuilder append(String str, int i2, int i3) {
        int i4;
        if (str == null) {
            return appendNull();
        }
        if (i2 < 0 || i2 > str.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i3 < 0 || (i4 = i2 + i3) > str.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i3 > 0) {
                int length = length();
                ensureCapacity(length + i3);
                str.getChars(i2, i4, this.buffer, length);
                this.size += i3;
            }
            return this;
        }
    }

    public StrBuilder appendln(StringBuilder sb, int i2, int i3) {
        return append(sb, i2, i3).appendNewLine();
    }

    public StrBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i2, int i3) {
        return append(strBuilder, i2, i3).appendNewLine();
    }

    public StrBuilder append(StringBuffer stringBuffer, int i2, int i3) {
        int i4;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i2 < 0 || i2 > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i3 < 0 || (i4 = i2 + i3) > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i3 > 0) {
                int length = length();
                ensureCapacity(length + i3);
                stringBuffer.getChars(i2, i4, this.buffer, length);
                this.size += i3;
            }
            return this;
        }
    }

    public StrBuilder appendln(boolean z) {
        return append(z).appendNewLine();
    }

    public StrBuilder append(StringBuilder sb) {
        if (sb == null) {
            return appendNull();
        }
        int length = sb.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            sb.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder append(StringBuilder sb, int i2, int i3) {
        int i4;
        if (sb == null) {
            return appendNull();
        }
        if (i2 < 0 || i2 > sb.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i3 < 0 || (i4 = i2 + i3) > sb.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i3 > 0) {
                int length = length();
                ensureCapacity(length + i3);
                sb.getChars(i2, i4, this.buffer, length);
                this.size += i3;
            }
            return this;
        }
    }

    public StrBuilder appendln(char[] cArr, int i2, int i3) {
        return append(cArr, i2, i3).appendNewLine();
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i2, int i3) {
        int i4;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i2 < 0 || i2 > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        } else if (i3 < 0 || (i4 = i2 + i3) > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        } else {
            if (i3 > 0) {
                int length = length();
                ensureCapacity(length + i3);
                strBuilder.getChars(i2, i4, this.buffer, length);
                this.size += i3;
            }
            return this;
        }
    }

    public StrBuilder append(boolean z) {
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i2 = this.size;
            int i3 = i2 + 1;
            this.size = i3;
            cArr[i2] = 't';
            int i4 = i2 + 2;
            this.size = i4;
            cArr[i3] = 'r';
            int i5 = i2 + 3;
            this.size = i5;
            cArr[i4] = 'u';
            this.size = i2 + 4;
            cArr[i5] = Barcode128.H;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i6 = this.size;
            int i7 = i6 + 1;
            this.size = i7;
            cArr2[i6] = Barcode128.I;
            int i8 = i6 + 2;
            this.size = i8;
            cArr2[i7] = 'a';
            int i9 = i6 + 3;
            this.size = i9;
            cArr2[i8] = 'l';
            int i10 = i6 + 4;
            this.size = i10;
            cArr2[i9] = 's';
            this.size = i6 + 5;
            cArr2[i10] = Barcode128.H;
        }
        return this;
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(char[] cArr, int i2, int i3) {
        if (cArr == null) {
            return appendNull();
        }
        if (i2 < 0 || i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i3);
        } else if (i3 < 0 || i2 + i3 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i3);
        } else {
            if (i3 > 0) {
                int length = length();
                ensureCapacity(length + i3);
                System.arraycopy(cArr, i2, this.buffer, length, i3);
                this.size += i3;
            }
            return this;
        }
    }
}
