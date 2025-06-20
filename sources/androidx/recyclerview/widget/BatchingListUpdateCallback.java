package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int Y2 = 0;
    private static final int Z2 = 1;
    private static final int a3 = 2;
    private static final int b3 = 3;
    int X = 0;
    Object X2 = null;
    int Y = -1;
    int Z = -1;
    final ListUpdateCallback s;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.s = listUpdateCallback;
    }

    public void a(int i2, int i3) {
        e();
        this.s.a(i2, i3);
    }

    public void b(int i2, int i3) {
        int i4;
        if (this.X == 1 && i2 >= (i4 = this.Y)) {
            int i5 = this.Z;
            if (i2 <= i4 + i5) {
                this.Z = i5 + i3;
                this.Y = Math.min(i2, i4);
                return;
            }
        }
        e();
        this.Y = i2;
        this.Z = i3;
        this.X = 1;
    }

    public void c(int i2, int i3) {
        int i4;
        if (this.X != 2 || (i4 = this.Y) < i2 || i4 > i2 + i3) {
            e();
            this.Y = i2;
            this.Z = i3;
            this.X = 2;
            return;
        }
        this.Z += i3;
        this.Y = i2;
    }

    @SuppressLint({"UnknownNullness"})
    public void d(int i2, int i3, Object obj) {
        int i4;
        if (this.X == 3) {
            int i5 = this.Y;
            int i6 = this.Z;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.X2 == obj) {
                this.Y = Math.min(i2, i5);
                this.Z = Math.max(i6 + i5, i4) - this.Y;
                return;
            }
        }
        e();
        this.Y = i2;
        this.Z = i3;
        this.X2 = obj;
        this.X = 3;
    }

    public void e() {
        int i2 = this.X;
        if (i2 != 0) {
            if (i2 == 1) {
                this.s.b(this.Y, this.Z);
            } else if (i2 == 2) {
                this.s.c(this.Y, this.Z);
            } else if (i2 == 3) {
                this.s.d(this.Y, this.Z, this.X2);
            }
            this.X2 = null;
            this.X = 0;
        }
    }
}
