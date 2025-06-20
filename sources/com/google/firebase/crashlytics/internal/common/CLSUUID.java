package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class CLSUUID {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f23553a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static String f23554b;

    CLSUUID(IdManager idManager) {
        byte[] bArr = new byte[10];
        e(bArr);
        d(bArr);
        c(bArr);
        String C = CommonUtils.C(idManager.a().c());
        String u = CommonUtils.u(bArr);
        Locale locale = Locale.US;
        f23554b = String.format(locale, "%s%s%s%s", new Object[]{u.substring(0, 12), u.substring(12, 16), u.subSequence(16, 20), C.substring(0, 12)}).toUpperCase(locale);
    }

    private static byte[] a(long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j2);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j2));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void c(byte[] bArr) {
        byte[] b2 = b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b2[0];
        bArr[9] = b2[1];
    }

    private void d(byte[] bArr) {
        byte[] b2 = b(f23553a.incrementAndGet());
        bArr[6] = b2[0];
        bArr[7] = b2[1];
    }

    private void e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a2 = a(time / 1000);
        bArr[0] = a2[0];
        bArr[1] = a2[1];
        bArr[2] = a2[2];
        bArr[3] = a2[3];
        byte[] b2 = b(time % 1000);
        bArr[4] = b2[0];
        bArr[5] = b2[1];
    }

    public String toString() {
        return f23554b;
    }
}
