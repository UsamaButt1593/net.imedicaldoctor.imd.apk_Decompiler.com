package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {

    /* renamed from: a  reason: collision with root package name */
    final int f28480a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f28481b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f28482c;

    /* renamed from: d  reason: collision with root package name */
    volatile int f28483d;

    /* renamed from: e  reason: collision with root package name */
    int f28484e;

    public LinkedArrayList(int i2) {
        this.f28480a = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f28483d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            int r0 = r4.f28480a
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.f28481b = r0
            r4.f28482c = r0
            r0[r1] = r5
            r4.f28484e = r2
            r4.f28483d = r2
            goto L_0x0038
        L_0x0016:
            int r0 = r4.f28484e
            int r3 = r4.f28480a
            if (r0 != r3) goto L_0x0030
            int r0 = r3 + 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.f28482c
            r5[r3] = r0
            r4.f28482c = r0
            r4.f28484e = r2
        L_0x002a:
            int r5 = r4.f28483d
            int r5 = r5 + r2
            r4.f28483d = r5
            goto L_0x0038
        L_0x0030:
            java.lang.Object[] r1 = r4.f28482c
            r1[r0] = r5
            int r0 = r0 + r2
            r4.f28484e = r0
            goto L_0x002a
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.LinkedArrayList.a(java.lang.Object):void");
    }

    public Object[] b() {
        return this.f28481b;
    }

    public int c() {
        return this.f28483d;
    }

    public String toString() {
        int i2 = this.f28480a;
        int i3 = this.f28483d;
        ArrayList arrayList = new ArrayList(i3 + 1);
        Object[] b2 = b();
        int i4 = 0;
        while (true) {
            int i5 = 0;
            while (i4 < i3) {
                arrayList.add(b2[i5]);
                i4++;
                i5++;
                if (i5 == i2) {
                    b2 = b2[i2];
                }
            }
            return arrayList.toString();
        }
    }
}
