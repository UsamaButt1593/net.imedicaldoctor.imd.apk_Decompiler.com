package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;

@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int X;
    private final int Y;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void c(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public final void s(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.v(this.X, this.Y)) {
            sizeReadyCallback.e(this.X, this.Y);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.X + " and height: " + this.Y + ", either provide dimensions in the constructor or call override()");
    }

    public SimpleTarget(int i2, int i3) {
        this.X = i2;
        this.Y = i3;
    }
}
