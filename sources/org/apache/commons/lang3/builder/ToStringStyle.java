package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;

public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = new ThreadLocal<>();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    private static final long serialVersionUID = -2587890625525655916L;
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private String arraySeparator = ",";
    private String arrayStart = "{";
    private String contentEnd = "]";
    private String contentStart = "[";
    private boolean defaultFullDetail = true;
    private String fieldNameValueSeparator = "=";
    private String fieldSeparator = ",";
    private boolean fieldSeparatorAtEnd = false;
    private boolean fieldSeparatorAtStart = false;
    private String nullText = "<null>";
    private String sizeEndText = ">";
    private String sizeStartText = "<size=";
    private String summaryObjectEndText = ">";
    private String summaryObjectStartText = "<";
    private boolean useClassName = true;
    private boolean useFieldNames = true;
    private boolean useIdentityHashCode = true;
    private boolean useShortClassName = false;

    private static final class DefaultToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        DefaultToStringStyle() {
        }

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    private static final class MultiLineToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        MultiLineToStringStyle() {
            setContentStart("[");
            StringBuilder sb = new StringBuilder();
            String str = SystemUtils.LINE_SEPARATOR;
            sb.append(str);
            sb.append("  ");
            setFieldSeparator(sb.toString());
            setFieldSeparatorAtStart(true);
            setContentEnd(str + "]");
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }

    private static final class NoFieldNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    private static final class ShortPrefixToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        ShortPrefixToStringStyle() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }
    }

    private static final class SimpleToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    protected ToStringStyle() {
    }

    static Map<Object, Object> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Map<Object, Object> registry = getRegistry();
        return registry != null && registry.containsKey(obj);
    }

    static void register(Object obj) {
        if (obj != null) {
            if (getRegistry() == null) {
                REGISTRY.set(new WeakHashMap());
            }
            getRegistry().put(obj, (Object) null);
        }
    }

    static void unregister(Object obj) {
        Map<Object, Object> registry;
        if (obj != null && (registry = getRegistry()) != null) {
            registry.remove(obj);
            if (registry.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    public void append(StringBuffer stringBuffer, String str, byte b2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (this.useClassName && obj != null) {
            register(obj);
            boolean z = this.useShortClassName;
            Class<?> cls = obj.getClass();
            stringBuffer.append(z ? getShortClassName(cls) : cls.getName());
        }
    }

    /* access modifiers changed from: protected */
    public void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    /* access modifiers changed from: protected */
    public void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    /* access modifiers changed from: protected */
    public void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.identityToString(stringBuffer, obj);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, byte b2) {
        stringBuffer.append(b2);
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        unregister(obj);
    }

    /* access modifiers changed from: protected */
    public void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    /* access modifiers changed from: protected */
    public void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    /* access modifiers changed from: protected */
    public void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    /* access modifiers changed from: protected */
    public void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (isUseIdentityHashCode() && obj != null) {
            register(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    /* access modifiers changed from: protected */
    public void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        int size;
        if (!isRegistered(obj) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character)) {
            register(obj);
            try {
                if (!(obj instanceof Collection)) {
                    if (obj instanceof Map) {
                        if (z) {
                            appendDetail(stringBuffer, str, (Map<?, ?>) (Map) obj);
                        } else {
                            size = ((Map) obj).size();
                        }
                    } else if (obj instanceof long[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (long[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (long[]) obj);
                        }
                    } else if (obj instanceof int[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (int[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (int[]) obj);
                        }
                    } else if (obj instanceof short[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (short[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (short[]) obj);
                        }
                    } else if (obj instanceof byte[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (byte[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (byte[]) obj);
                        }
                    } else if (obj instanceof char[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (char[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (char[]) obj);
                        }
                    } else if (obj instanceof double[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (double[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (double[]) obj);
                        }
                    } else if (obj instanceof float[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (float[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (float[]) obj);
                        }
                    } else if (obj instanceof boolean[]) {
                        if (z) {
                            appendDetail(stringBuffer, str, (boolean[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (boolean[]) obj);
                        }
                    } else if (obj.getClass().isArray()) {
                        if (z) {
                            appendDetail(stringBuffer, str, (Object[]) obj);
                        } else {
                            appendSummary(stringBuffer, str, (Object[]) obj);
                        }
                    } else if (z) {
                        appendDetail(stringBuffer, str, obj);
                    } else {
                        appendSummary(stringBuffer, str, obj);
                    }
                } else if (z) {
                    appendDetail(stringBuffer, str, (Collection<?>) (Collection) obj);
                } else {
                    size = ((Collection) obj).size();
                }
                appendSummarySize(stringBuffer, str, size);
            } finally {
                unregister(obj);
            }
        } else {
            appendCyclicObject(stringBuffer, str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    /* access modifiers changed from: protected */
    public void appendSummarySize(StringBuffer stringBuffer, String str, int i2) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i2);
        stringBuffer.append(this.sizeEndText);
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        int indexOf;
        int lastIndexOf;
        if (str != null && (indexOf = str.indexOf(this.contentStart) + this.contentStart.length()) != (lastIndexOf = str.lastIndexOf(this.contentEnd)) && indexOf >= 0 && lastIndexOf >= 0) {
            String substring = str.substring(indexOf, lastIndexOf);
            if (this.fieldSeparatorAtStart) {
                removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append(substring);
            appendFieldSeparator(stringBuffer);
        }
    }

    /* access modifiers changed from: protected */
    public String getArrayEnd() {
        return this.arrayEnd;
    }

    /* access modifiers changed from: protected */
    public String getArraySeparator() {
        return this.arraySeparator;
    }

    /* access modifiers changed from: protected */
    public String getArrayStart() {
        return this.arrayStart;
    }

    /* access modifiers changed from: protected */
    public String getContentEnd() {
        return this.contentEnd;
    }

    /* access modifiers changed from: protected */
    public String getContentStart() {
        return this.contentStart;
    }

    /* access modifiers changed from: protected */
    public String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    /* access modifiers changed from: protected */
    public String getFieldSeparator() {
        return this.fieldSeparator;
    }

    /* access modifiers changed from: protected */
    public String getNullText() {
        return this.nullText;
    }

    /* access modifiers changed from: protected */
    public String getShortClassName(Class<?> cls) {
        return ClassUtils.getShortClassName(cls);
    }

    /* access modifiers changed from: protected */
    public String getSizeEndText() {
        return this.sizeEndText;
    }

    /* access modifiers changed from: protected */
    public String getSizeStartText() {
        return this.sizeStartText;
    }

    /* access modifiers changed from: protected */
    public String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    /* access modifiers changed from: protected */
    public String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    /* access modifiers changed from: protected */
    public boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    /* access modifiers changed from: protected */
    public boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    /* access modifiers changed from: protected */
    public boolean isFullDetail(Boolean bool) {
        return bool == null ? this.defaultFullDetail : bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean isUseClassName() {
        return this.useClassName;
    }

    /* access modifiers changed from: protected */
    public boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    /* access modifiers changed from: protected */
    public boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    /* access modifiers changed from: protected */
    public boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    /* access modifiers changed from: protected */
    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = Array.get(obj, i2);
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    /* access modifiers changed from: protected */
    public void removeLastFieldSeparator(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            int i2 = 0;
            while (i2 < length2) {
                if (stringBuffer.charAt((length - 1) - i2) == this.fieldSeparator.charAt((length2 - 1) - i2)) {
                    i2++;
                } else {
                    return;
                }
            }
            stringBuffer.setLength(length - length2);
        }
    }

    /* access modifiers changed from: protected */
    public void setArrayContentDetail(boolean z) {
        this.arrayContentDetail = z;
    }

    /* access modifiers changed from: protected */
    public void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    /* access modifiers changed from: protected */
    public void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.arraySeparator = str;
    }

    /* access modifiers changed from: protected */
    public void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    /* access modifiers changed from: protected */
    public void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    /* access modifiers changed from: protected */
    public void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    /* access modifiers changed from: protected */
    public void setDefaultFullDetail(boolean z) {
        this.defaultFullDetail = z;
    }

    /* access modifiers changed from: protected */
    public void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    /* access modifiers changed from: protected */
    public void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    /* access modifiers changed from: protected */
    public void setFieldSeparatorAtEnd(boolean z) {
        this.fieldSeparatorAtEnd = z;
    }

    /* access modifiers changed from: protected */
    public void setFieldSeparatorAtStart(boolean z) {
        this.fieldSeparatorAtStart = z;
    }

    /* access modifiers changed from: protected */
    public void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    /* access modifiers changed from: protected */
    public void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    /* access modifiers changed from: protected */
    public void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    /* access modifiers changed from: protected */
    public void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    /* access modifiers changed from: protected */
    public void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    /* access modifiers changed from: protected */
    public void setUseClassName(boolean z) {
        this.useClassName = z;
    }

    /* access modifiers changed from: protected */
    public void setUseFieldNames(boolean z) {
        this.useFieldNames = z;
    }

    /* access modifiers changed from: protected */
    public void setUseIdentityHashCode(boolean z) {
        this.useIdentityHashCode = z;
    }

    /* access modifiers changed from: protected */
    public void setUseShortClassName(boolean z) {
        this.useShortClassName = z;
    }

    public void append(StringBuffer stringBuffer, String str, char c2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, char c2) {
        stringBuffer.append(c2);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, double d2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, double d2) {
        stringBuffer.append(d2);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, float f2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, float f2) {
        stringBuffer.append(f2);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int i2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, int i2) {
        stringBuffer.append(i2);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long j2) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j2);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, long j2) {
        stringBuffer.append(j2);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short s) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append(s);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i2 = 0; i2 < zArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i2]);
        }
        stringBuffer.append(this.arrayEnd);
    }
}
