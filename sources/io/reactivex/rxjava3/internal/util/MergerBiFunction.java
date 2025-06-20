package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.BiFunction;
import java.util.Comparator;
import java.util.List;

public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> s;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.s = comparator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r3 = r7.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r0 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r3 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r5.s.compare(r0, r3) >= 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r1.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r6.hasNext() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        r0 = r6.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r7.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r0 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r1.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r6.hasNext() == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        r1.add(r6.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r7.hasNext() == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        r1.add(r7.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (r7.hasNext() != false) goto L_0x0031;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> apply(java.util.List<T> r6, java.util.List<T> r7) {
        /*
            r5 = this;
            int r0 = r6.size()
            int r1 = r7.size()
            int r0 = r0 + r1
            if (r0 != 0) goto L_0x0011
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        L_0x0011:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r6.hasNext()
            r2 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r6.next()
            goto L_0x002b
        L_0x002a:
            r0 = r2
        L_0x002b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0036
        L_0x0031:
            java.lang.Object r3 = r7.next()
            goto L_0x0037
        L_0x0036:
            r3 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x005d
            if (r3 == 0) goto L_0x005d
            java.util.Comparator<? super T> r4 = r5.s
            int r4 = r4.compare(r0, r3)
            if (r4 >= 0) goto L_0x0053
            r1.add(r0)
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0051
            java.lang.Object r0 = r6.next()
            goto L_0x0037
        L_0x0051:
            r0 = r2
            goto L_0x0037
        L_0x0053:
            r1.add(r3)
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0036
            goto L_0x0031
        L_0x005d:
            if (r0 == 0) goto L_0x0070
            r1.add(r0)
        L_0x0062:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0081
            java.lang.Object r7 = r6.next()
            r1.add(r7)
            goto L_0x0062
        L_0x0070:
            r1.add(r3)
        L_0x0073:
            boolean r6 = r7.hasNext()
            if (r6 == 0) goto L_0x0081
            java.lang.Object r6 = r7.next()
            r1.add(r6)
            goto L_0x0073
        L_0x0081:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.MergerBiFunction.apply(java.util.List, java.util.List):java.util.List");
    }
}
