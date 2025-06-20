package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;

public final class HttpDate {

    /* renamed from: a  reason: collision with root package name */
    public static final long f31073a = 253402300799999L;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f31074b = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(Util.p);
            return simpleDateFormat;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f31075c;

    /* renamed from: d  reason: collision with root package name */
    private static final DateFormat[] f31076d;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f31075c = strArr;
        f31076d = new DateFormat[strArr.length];
    }

    private HttpDate() {
    }

    public static String a(Date date) {
        return f31074b.get().format(date);
    }

    public static Date b(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f31074b.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f31075c;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    DateFormat[] dateFormatArr = f31076d;
                    DateFormat dateFormat = dateFormatArr[i2];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(f31075c[i2], Locale.US);
                        dateFormat.setTimeZone(Util.p);
                        dateFormatArr[i2] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
