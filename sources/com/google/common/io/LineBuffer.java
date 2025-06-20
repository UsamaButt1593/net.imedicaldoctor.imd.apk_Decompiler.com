package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
abstract class LineBuffer {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f22787a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private boolean f22788b;

    LineBuffer() {
    }

    @CanIgnoreReturnValue
    private boolean c(boolean z) throws IOException {
        d(this.f22787a.toString(), this.f22788b ? z ? "\r\n" : StringUtils.CR : z ? StringUtils.LF : "");
        this.f22787a = new StringBuilder();
        this.f22788b = false;
        return z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.f22788b
            r1 = 0
            r2 = 10
            r3 = 1
            if (r0 == 0) goto L_0x001a
            if (r9 <= 0) goto L_0x001a
            char r0 = r7[r8]
            if (r0 != r2) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            boolean r0 = r6.c(r0)
            if (r0 == 0) goto L_0x001a
            int r0 = r8 + 1
            goto L_0x001b
        L_0x001a:
            r0 = r8
        L_0x001b:
            int r8 = r8 + r9
            r9 = r0
        L_0x001d:
            if (r0 >= r8) goto L_0x0053
            char r4 = r7[r0]
            if (r4 == r2) goto L_0x0046
            r5 = 13
            if (r4 == r5) goto L_0x0028
            goto L_0x0051
        L_0x0028:
            java.lang.StringBuilder r4 = r6.f22787a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.f22788b = r3
            int r9 = r0 + 1
            if (r9 >= r8) goto L_0x0043
            char r4 = r7[r9]
            if (r4 != r2) goto L_0x003b
            r4 = 1
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            boolean r4 = r6.c(r4)
            if (r4 == 0) goto L_0x0043
            r0 = r9
        L_0x0043:
            int r9 = r0 + 1
            goto L_0x0051
        L_0x0046:
            java.lang.StringBuilder r4 = r6.f22787a
            int r5 = r0 - r9
            r4.append(r7, r9, r5)
            r6.c(r3)
            goto L_0x0043
        L_0x0051:
            int r0 = r0 + r3
            goto L_0x001d
        L_0x0053:
            java.lang.StringBuilder r0 = r6.f22787a
            int r8 = r8 - r9
            r0.append(r7, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.LineBuffer.a(char[], int, int):void");
    }

    /* access modifiers changed from: protected */
    public void b() throws IOException {
        if (this.f22788b || this.f22787a.length() > 0) {
            c(false);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(String str, String str2) throws IOException;
}
