package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

abstract class FormatCache<F extends Format> {
    static final int NONE = -1;
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    private static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        public MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int i2 = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i2 = (i2 * 7) + obj.hashCode();
                    }
                }
                this.hashCode = i2;
            }
            return this.hashCode;
        }
    }

    FormatCache() {
    }

    static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        DateFormat dateFormat;
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        ConcurrentMap<MultipartKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(multipartKey);
        if (str != null) {
            return str;
        }
        if (num == null) {
            try {
                dateFormat = DateFormat.getTimeInstance(num2.intValue(), locale);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        } else {
            dateFormat = num2 == null ? DateFormat.getDateInstance(num.intValue(), locale) : DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
        }
        String pattern = ((SimpleDateFormat) dateFormat).toPattern();
        String putIfAbsent = concurrentMap.putIfAbsent(multipartKey, pattern);
        return putIfAbsent != null ? putIfAbsent : pattern;
    }

    /* access modifiers changed from: protected */
    public abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    /* access modifiers changed from: package-private */
    public F getDateInstance(int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i2), (Integer) null, timeZone, locale);
    }

    /* access modifiers changed from: package-private */
    public F getDateTimeInstance(int i2, int i3, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale);
    }

    public F getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    /* access modifiers changed from: package-private */
    public F getTimeInstance(int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i2), timeZone, locale);
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        if (str != null) {
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
            F f2 = (Format) this.cInstanceCache.get(multipartKey);
            if (f2 != null) {
                return f2;
            }
            F createInstance = createInstance(str, timeZone, locale);
            F f3 = (Format) this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
            return f3 != null ? f3 : createInstance;
        }
        throw new NullPointerException("pattern must not be null");
    }
}
