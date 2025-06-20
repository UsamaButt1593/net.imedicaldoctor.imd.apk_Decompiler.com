package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.Loader;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

@UnstableApi
public final class SntpClient {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12701a = "time.android.com";

    /* renamed from: b  reason: collision with root package name */
    private static final int f12702b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12703c = 24;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12704d = 32;

    /* renamed from: e  reason: collision with root package name */
    private static final int f12705e = 40;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12706f = 48;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12707g = 123;

    /* renamed from: h  reason: collision with root package name */
    private static final int f12708h = 3;

    /* renamed from: i  reason: collision with root package name */
    private static final int f12709i = 4;

    /* renamed from: j  reason: collision with root package name */
    private static final int f12710j = 5;

    /* renamed from: k  reason: collision with root package name */
    private static final int f12711k = 3;

    /* renamed from: l  reason: collision with root package name */
    private static final int f12712l = 3;

    /* renamed from: m  reason: collision with root package name */
    private static final int f12713m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f12714n = 15;
    private static final long o = 2208988800L;
    /* access modifiers changed from: private */
    public static final Object p = new Object();
    /* access modifiers changed from: private */
    public static final Object q = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("valueLock")
    public static boolean r = false;
    /* access modifiers changed from: private */
    @GuardedBy("valueLock")
    public static long s = 0;
    @GuardedBy("valueLock")
    private static String t = "time.android.com";

    public interface InitializationCallback {
        void a(IOException iOException);

        void b();
    }

    private static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {
        @Nullable
        private final InitializationCallback s;

        public NtpTimeCallback(@Nullable InitializationCallback initializationCallback) {
            this.s = initializationCallback;
        }

        public void N(Loader.Loadable loadable, long j2, long j3) {
            if (this.s == null) {
                return;
            }
            if (!SntpClient.k()) {
                this.s.a(new IOException(new ConcurrentModificationException()));
            } else {
                this.s.b();
            }
        }

        public void Z(Loader.Loadable loadable, long j2, long j3, boolean z) {
        }

        public Loader.LoadErrorAction p(Loader.Loadable loadable, long j2, long j3, IOException iOException, int i2) {
            InitializationCallback initializationCallback = this.s;
            if (initializationCallback != null) {
                initializationCallback.a(iOException);
            }
            return Loader.f12576k;
        }
    }

    private static final class NtpTimeLoadable implements Loader.Loadable {
        private NtpTimeLoadable() {
        }

        public void a() throws IOException {
            synchronized (SntpClient.p) {
                synchronized (SntpClient.q) {
                    if (!SntpClient.r) {
                        long e2 = SntpClient.l();
                        synchronized (SntpClient.q) {
                            long unused = SntpClient.s = e2;
                            boolean unused2 = SntpClient.r = true;
                        }
                    }
                }
            }
        }

        public void c() {
        }
    }

    private SntpClient() {
    }

    private static void g(byte b2, byte b3, int i2, long j2) throws IOException {
        if (b2 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        } else if (b3 != 4 && b3 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + b3);
        } else if (i2 == 0 || i2 > 15) {
            throw new IOException("SNTP: Untrusted stratum: " + i2);
        } else if (j2 == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static long h() {
        long j2;
        synchronized (q) {
            try {
                j2 = r ? s : C.f9084b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public static String i() {
        String str;
        synchronized (q) {
            str = t;
        }
        return str;
    }

    public static void j(@Nullable Loader loader, @Nullable InitializationCallback initializationCallback) {
        if (!k()) {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.n(new NtpTimeLoadable(), new NtpTimeCallback(initializationCallback), 1);
        } else if (initializationCallback != null) {
            initializationCallback.b();
        }
    }

    public static boolean k() {
        boolean z;
        synchronized (q) {
            z = r;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.E;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            p(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j2 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b2 = bArr[0];
            long n2 = n(bArr, 24);
            long n3 = n(bArr, 32);
            long n4 = n(bArr, 40);
            g((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), bArr[1] & 255, n4);
            long j3 = (j2 + (((n3 - n2) + (n4 - j2)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j3;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static long m(byte[] bArr, int i2) {
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        byte b5 = bArr[i2 + 3];
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + 128;
        }
        byte b9 = b5 & true;
        int i6 = b5;
        if (b9 == true) {
            i6 = (b5 & Byte.MAX_VALUE) + 128;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }

    private static long n(byte[] bArr, int i2) {
        long m2 = m(bArr, i2);
        long m3 = m(bArr, i2 + 4);
        if (m2 == 0 && m3 == 0) {
            return 0;
        }
        return ((m2 - o) * 1000) + ((m3 * 1000) / 4294967296L);
    }

    public static void o(String str) {
        synchronized (q) {
            try {
                if (!t.equals(str)) {
                    t = str;
                    r = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void p(byte[] bArr, int i2, long j2) {
        if (j2 == 0) {
            Arrays.fill(bArr, i2, i2 + 8, (byte) 0);
            return;
        }
        long j3 = j2 / 1000;
        long j4 = j2 - (j3 * 1000);
        long j5 = j3 + o;
        bArr[i2] = (byte) ((int) (j5 >> 24));
        bArr[i2 + 1] = (byte) ((int) (j5 >> 16));
        bArr[i2 + 2] = (byte) ((int) (j5 >> 8));
        bArr[i2 + 3] = (byte) ((int) j5);
        long j6 = (j4 * 4294967296L) / 1000;
        bArr[i2 + 4] = (byte) ((int) (j6 >> 24));
        bArr[i2 + 5] = (byte) ((int) (j6 >> 16));
        bArr[i2 + 6] = (byte) ((int) (j6 >> 8));
        bArr[i2 + 7] = (byte) ((int) (Math.random() * 255.0d));
    }
}
