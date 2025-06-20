package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

class OpReorderer {

    /* renamed from: a  reason: collision with root package name */
    final Callback f15476a;

    interface Callback {
        void a(AdapterHelper.UpdateOp updateOp);

        AdapterHelper.UpdateOp b(int i2, int i3, int i4, Object obj);
    }

    OpReorderer(Callback callback) {
        this.f15476a = callback;
    }

    private int a(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f15204a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        int i4 = updateOp.f15207d;
        int i5 = updateOp2.f15205b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = updateOp.f15205b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            updateOp.f15205b = i7 + updateOp2.f15207d;
        }
        int i8 = updateOp2.f15205b;
        if (i8 <= i4) {
            updateOp.f15207d = i4 + updateOp2.f15207d;
        }
        updateOp2.f15205b = i8 + i6;
        list.set(i2, updateOp2);
        list.set(i3, updateOp);
    }

    private void d(List<AdapterHelper.UpdateOp> list, int i2, int i3) {
        AdapterHelper.UpdateOp updateOp = list.get(i2);
        AdapterHelper.UpdateOp updateOp2 = list.get(i3);
        int i4 = updateOp2.f15204a;
        if (i4 == 1) {
            c(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 2) {
            e(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 4) {
            f(list, i2, updateOp, i3, updateOp2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int a2 = a(list);
            if (a2 != -1) {
                d(list, a2, a2 + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009d, code lost:
        if (r0 > r14.f15205b) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cc, code lost:
        if (r0 >= r14.f15205b) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r10, int r11, androidx.recyclerview.widget.AdapterHelper.UpdateOp r12, int r13, androidx.recyclerview.widget.AdapterHelper.UpdateOp r14) {
        /*
            r9 = this;
            int r0 = r12.f15205b
            int r1 = r12.f15207d
            r2 = 1
            r3 = 0
            int r4 = r14.f15205b
            if (r0 >= r1) goto L_0x0017
            if (r4 != r0) goto L_0x0015
            int r4 = r14.f15207d
            int r0 = r1 - r0
            if (r4 != r0) goto L_0x0015
            r0 = 0
        L_0x0013:
            r3 = 1
            goto L_0x0023
        L_0x0015:
            r0 = 0
            goto L_0x0023
        L_0x0017:
            int r5 = r1 + 1
            if (r4 != r5) goto L_0x0022
            int r4 = r14.f15207d
            int r0 = r0 - r1
            if (r4 != r0) goto L_0x0022
            r0 = 1
            goto L_0x0013
        L_0x0022:
            r0 = 1
        L_0x0023:
            int r4 = r14.f15205b
            r5 = 2
            if (r1 >= r4) goto L_0x002c
            int r4 = r4 - r2
            r14.f15205b = r4
            goto L_0x0045
        L_0x002c:
            int r6 = r14.f15207d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x0045
            int r6 = r6 - r2
            r14.f15207d = r6
            r12.f15204a = r5
            r12.f15207d = r2
            int r11 = r14.f15207d
            if (r11 != 0) goto L_0x0044
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.f15476a
            r10.a(r14)
        L_0x0044:
            return
        L_0x0045:
            int r1 = r12.f15205b
            int r4 = r14.f15205b
            r6 = 0
            if (r1 > r4) goto L_0x0050
            int r4 = r4 + r2
            r14.f15205b = r4
            goto L_0x0066
        L_0x0050:
            int r7 = r14.f15207d
            int r8 = r4 + r7
            if (r1 >= r8) goto L_0x0066
            int r4 = r4 + r7
            int r4 = r4 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r7 = r9.f15476a
            int r1 = r1 + r2
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r7.b(r5, r1, r4, r6)
            int r1 = r12.f15205b
            int r2 = r14.f15205b
            int r1 = r1 - r2
            r14.f15207d = r1
        L_0x0066:
            if (r3 == 0) goto L_0x0074
            r10.set(r11, r14)
            r10.remove(r13)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r9.f15476a
            r10.a(r12)
            return
        L_0x0074:
            if (r0 == 0) goto L_0x00a5
            if (r6 == 0) goto L_0x008e
            int r0 = r12.f15205b
            int r1 = r6.f15205b
            if (r0 <= r1) goto L_0x0083
            int r1 = r6.f15207d
            int r0 = r0 - r1
            r12.f15205b = r0
        L_0x0083:
            int r0 = r12.f15207d
            int r1 = r6.f15205b
            if (r0 <= r1) goto L_0x008e
            int r1 = r6.f15207d
            int r0 = r0 - r1
            r12.f15207d = r0
        L_0x008e:
            int r0 = r12.f15205b
            int r1 = r14.f15205b
            if (r0 <= r1) goto L_0x0099
            int r1 = r14.f15207d
            int r0 = r0 - r1
            r12.f15205b = r0
        L_0x0099:
            int r0 = r12.f15207d
            int r1 = r14.f15205b
            if (r0 <= r1) goto L_0x00cf
        L_0x009f:
            int r1 = r14.f15207d
            int r0 = r0 - r1
            r12.f15207d = r0
            goto L_0x00cf
        L_0x00a5:
            if (r6 == 0) goto L_0x00bd
            int r0 = r12.f15205b
            int r1 = r6.f15205b
            if (r0 < r1) goto L_0x00b2
            int r1 = r6.f15207d
            int r0 = r0 - r1
            r12.f15205b = r0
        L_0x00b2:
            int r0 = r12.f15207d
            int r1 = r6.f15205b
            if (r0 < r1) goto L_0x00bd
            int r1 = r6.f15207d
            int r0 = r0 - r1
            r12.f15207d = r0
        L_0x00bd:
            int r0 = r12.f15205b
            int r1 = r14.f15205b
            if (r0 < r1) goto L_0x00c8
            int r1 = r14.f15207d
            int r0 = r0 - r1
            r12.f15205b = r0
        L_0x00c8:
            int r0 = r12.f15207d
            int r1 = r14.f15205b
            if (r0 < r1) goto L_0x00cf
            goto L_0x009f
        L_0x00cf:
            r10.set(r11, r14)
            int r14 = r12.f15205b
            int r0 = r12.f15207d
            if (r14 == r0) goto L_0x00dc
            r10.set(r13, r12)
            goto L_0x00df
        L_0x00dc:
            r10.remove(r13)
        L_0x00df:
            if (r6 == 0) goto L_0x00e4
            r10.add(r11, r6)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.e(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f15207d
            int r1 = r13.f15205b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r3
            r13.f15205b = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.f15207d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r3
            r13.f15207d = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.f15476a
            int r1 = r11.f15205b
            java.lang.Object r5 = r13.f15206c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.b(r2, r1, r3, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r4
        L_0x0021:
            int r1 = r11.f15205b
            int r5 = r13.f15205b
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r3
            r13.f15205b = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.f15207d
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.f15476a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f15206c
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.b(r2, r1, r5, r3)
            int r1 = r13.f15207d
            int r1 = r1 - r5
            r13.f15207d = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.f15207d
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.f15476a
            r11.a(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r9.add(r10, r4)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.f(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
