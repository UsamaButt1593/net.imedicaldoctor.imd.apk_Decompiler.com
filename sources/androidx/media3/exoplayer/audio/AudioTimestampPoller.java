package androidx.media3.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.util.Util;

final class AudioTimestampPoller {

    /* renamed from: g  reason: collision with root package name */
    private static final int f10792g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f10793h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f10794i = 2;

    /* renamed from: j  reason: collision with root package name */
    private static final int f10795j = 3;

    /* renamed from: k  reason: collision with root package name */
    private static final int f10796k = 4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f10797l = 10000;

    /* renamed from: m  reason: collision with root package name */
    private static final int f10798m = 10000000;

    /* renamed from: n  reason: collision with root package name */
    private static final int f10799n = 500000;
    private static final int o = 500000;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final AudioTimestampV19 f10800a;

    /* renamed from: b  reason: collision with root package name */
    private int f10801b;

    /* renamed from: c  reason: collision with root package name */
    private long f10802c;

    /* renamed from: d  reason: collision with root package name */
    private long f10803d;

    /* renamed from: e  reason: collision with root package name */
    private long f10804e;

    /* renamed from: f  reason: collision with root package name */
    private long f10805f;

    @RequiresApi(19)
    private static final class AudioTimestampV19 {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f10806a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioTimestamp f10807b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f10808c;

        /* renamed from: d  reason: collision with root package name */
        private long f10809d;

        /* renamed from: e  reason: collision with root package name */
        private long f10810e;

        public AudioTimestampV19(AudioTrack audioTrack) {
            this.f10806a = audioTrack;
        }

        public long a() {
            return this.f10810e;
        }

        public long b() {
            return this.f10807b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f10806a.getTimestamp(this.f10807b);
            if (timestamp) {
                long j2 = this.f10807b.framePosition;
                if (this.f10809d > j2) {
                    this.f10808c++;
                }
                this.f10809d = j2;
                this.f10810e = j2 + (this.f10808c << 32);
            }
            return timestamp;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.f9646a >= 19) {
            this.f10800a = new AudioTimestampV19(audioTrack);
            h();
            return;
        }
        this.f10800a = null;
        i(3);
    }

    private void i(int i2) {
        this.f10801b = i2;
        long j2 = 10000;
        if (i2 == 0) {
            this.f10804e = 0;
            this.f10805f = -1;
            this.f10802c = System.nanoTime() / 1000;
        } else if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                j2 = 10000000;
            } else if (i2 == 4) {
                j2 = 500000;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f10803d = j2;
    }

    public void a() {
        if (this.f10801b == 4) {
            h();
        }
    }

    @TargetApi(19)
    public long b() {
        AudioTimestampV19 audioTimestampV19 = this.f10800a;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.a();
        }
        return -1;
    }

    @TargetApi(19)
    public long c() {
        AudioTimestampV19 audioTimestampV19 = this.f10800a;
        return audioTimestampV19 != null ? audioTimestampV19.b() : C.f9084b;
    }

    public boolean d() {
        return this.f10801b == 2;
    }

    public boolean e() {
        int i2 = this.f10801b;
        return i2 == 1 || i2 == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0 != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r0 == false) goto L_0x002f;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(long r8) {
        /*
            r7 = this;
            androidx.media3.exoplayer.audio.AudioTimestampPoller$AudioTimestampV19 r0 = r7.f10800a
            r1 = 0
            if (r0 == 0) goto L_0x0070
            long r2 = r7.f10804e
            long r2 = r8 - r2
            long r4 = r7.f10803d
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0010
            goto L_0x0070
        L_0x0010:
            r7.f10804e = r8
            boolean r0 = r0.c()
            int r2 = r7.f10801b
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L_0x0048
            r8 = 2
            if (r2 == r4) goto L_0x0036
            if (r2 == r8) goto L_0x0033
            if (r2 == r3) goto L_0x002d
            r8 = 4
            if (r2 != r8) goto L_0x0027
            goto L_0x006f
        L_0x0027:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x002d:
            if (r0 == 0) goto L_0x006f
        L_0x002f:
            r7.h()
            goto L_0x006f
        L_0x0033:
            if (r0 != 0) goto L_0x006f
            goto L_0x002f
        L_0x0036:
            if (r0 == 0) goto L_0x002f
            androidx.media3.exoplayer.audio.AudioTimestampPoller$AudioTimestampV19 r9 = r7.f10800a
            long r1 = r9.a()
            long r3 = r7.f10805f
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x006f
            r7.i(r8)
            goto L_0x006f
        L_0x0048:
            if (r0 == 0) goto L_0x0062
            androidx.media3.exoplayer.audio.AudioTimestampPoller$AudioTimestampV19 r8 = r7.f10800a
            long r8 = r8.b()
            long r2 = r7.f10802c
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0070
            androidx.media3.exoplayer.audio.AudioTimestampPoller$AudioTimestampV19 r8 = r7.f10800a
            long r8 = r8.a()
            r7.f10805f = r8
            r7.i(r4)
            goto L_0x006f
        L_0x0062:
            long r1 = r7.f10802c
            long r8 = r8 - r1
            r1 = 500000(0x7a120, double:2.47033E-318)
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x006f
            r7.i(r3)
        L_0x006f:
            r1 = r0
        L_0x0070:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioTimestampPoller.f(long):boolean");
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f10800a != null) {
            i(0);
        }
    }
}
