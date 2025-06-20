package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

class QueueFileLogStore implements FileLogStore {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f23727d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final File f23728a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23729b;

    /* renamed from: c  reason: collision with root package name */
    private QueueFile f23730c;

    private static class LogBytes {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f23734a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23735b;

        LogBytes(byte[] bArr, int i2) {
            this.f23734a = bArr;
            this.f23735b = i2;
        }
    }

    QueueFileLogStore(File file, int i2) {
        this.f23728a = file;
        this.f23729b = i2;
    }

    private void f(long j2, String str) {
        if (this.f23730c != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i2 = this.f23729b / 4;
                if (str.length() > i2) {
                    str = "..." + str.substring(str.length() - i2);
                }
                this.f23730c.f(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j2), str.replaceAll(StringUtils.CR, StringUtils.SPACE).replaceAll(StringUtils.LF, StringUtils.SPACE)}).getBytes(f23727d));
                while (!this.f23730c.r() && this.f23730c.J() > this.f23729b) {
                    this.f23730c.C();
                }
            } catch (IOException e2) {
                Logger.f().e("There was a problem writing to the Crashlytics log.", e2);
            }
        }
    }

    private LogBytes g() {
        if (!this.f23728a.exists()) {
            return null;
        }
        h();
        QueueFile queueFile = this.f23730c;
        if (queueFile == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[queueFile.J()];
        try {
            this.f23730c.n(new QueueFile.ElementReader() {
                public void e(InputStream inputStream, int i2) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i2);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i2;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e2) {
            Logger.f().e("A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void h() {
        if (this.f23730c == null) {
            try {
                this.f23730c = new QueueFile(this.f23728a);
            } catch (IOException e2) {
                Logger f2 = Logger.f();
                f2.e("Could not open log file: " + this.f23728a, e2);
            }
        }
    }

    public void a() {
        CommonUtils.f(this.f23730c, "There was a problem closing the Crashlytics log file.");
        this.f23730c = null;
    }

    public String b() {
        byte[] c2 = c();
        if (c2 != null) {
            return new String(c2, f23727d);
        }
        return null;
    }

    public byte[] c() {
        LogBytes g2 = g();
        if (g2 == null) {
            return null;
        }
        int i2 = g2.f23735b;
        byte[] bArr = new byte[i2];
        System.arraycopy(g2.f23734a, 0, bArr, 0, i2);
        return bArr;
    }

    public void d() {
        a();
        this.f23728a.delete();
    }

    public void e(long j2, String str) {
        h();
        f(j2, str);
    }
}
