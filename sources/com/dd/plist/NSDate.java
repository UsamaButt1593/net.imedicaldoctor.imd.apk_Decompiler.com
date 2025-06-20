package com.dd.plist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NSDate extends NSObject {
    private static final long X2 = 978307200000L;
    private static final SimpleDateFormat Y2;
    private static final SimpleDateFormat Z2;
    private Date Z;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Y2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Z2 = simpleDateFormat2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public NSDate(String str) throws ParseException {
        this.Z = C(str);
    }

    private static synchronized String A(Date date) {
        String format;
        synchronized (NSDate.class) {
            format = Z2.format(date);
        }
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = Z2.parse(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.util.Date C(java.lang.String r2) throws java.text.ParseException {
        /*
            java.lang.Class<com.dd.plist.NSDate> r0 = com.dd.plist.NSDate.class
            monitor-enter(r0)
            java.text.SimpleDateFormat r1 = Y2     // Catch:{ ParseException -> 0x000d }
            java.util.Date r2 = r1.parse(r2)     // Catch:{ ParseException -> 0x000d }
            monitor-exit(r0)
            return r2
        L_0x000b:
            r2 = move-exception
            goto L_0x0015
        L_0x000d:
            java.text.SimpleDateFormat r1 = Z2     // Catch:{ all -> 0x000b }
            java.util.Date r2 = r1.parse(r2)     // Catch:{ all -> 0x000b }
            monitor-exit(r0)
            return r2
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.NSDate.C(java.lang.String):java.util.Date");
    }

    private static synchronized String z(Date date) {
        String format;
        synchronized (NSDate.class) {
            format = Y2.format(date);
        }
        return format;
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("\"");
        sb.append(z(this.Z));
        sb.append("\"");
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<*D");
        sb.append(A(this.Z));
        sb.append(">");
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && this.Z.equals(((NSDate) obj).y());
    }

    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        binaryPropertyListWriter.f(51);
        binaryPropertyListWriter.l(((double) (this.Z.getTime() - X2)) / 1000.0d);
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<date>");
        sb.append(z(this.Z));
        sb.append("</date>");
    }

    public int hashCode() {
        return this.Z.hashCode();
    }

    public String toString() {
        return this.Z.toString();
    }

    public Date y() {
        return this.Z;
    }

    public NSDate(Date date) {
        if (date != null) {
            this.Z = date;
            return;
        }
        throw new IllegalArgumentException("Date cannot be null");
    }

    public NSDate(byte[] bArr) {
        this.Z = new Date(((long) (BinaryPropertyListParser.f(bArr) * 1000.0d)) + X2);
    }
}
