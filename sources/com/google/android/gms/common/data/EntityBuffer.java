package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean X = false;
    private ArrayList<Integer> Y;

    @KeepForSdk
    protected EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void k() {
        synchronized (this) {
            try {
                if (!this.X) {
                    int count = ((DataHolder) Preconditions.r(this.s)).getCount();
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    this.Y = arrayList;
                    if (count > 0) {
                        arrayList.add(0);
                        String d2 = d();
                        String R = this.s.R(d2, 0, this.s.S(0));
                        int i2 = 1;
                        while (i2 < count) {
                            int S = this.s.S(i2);
                            String R2 = this.s.R(d2, i2, S);
                            if (R2 != null) {
                                if (!R2.equals(R)) {
                                    this.Y.add(Integer.valueOf(i2));
                                    R = R2;
                                }
                                i2++;
                            } else {
                                StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 78);
                                sb.append("Missing value for markerColumn: ");
                                sb.append(d2);
                                sb.append(", at row: ");
                                sb.append(i2);
                                sb.append(", for window: ");
                                sb.append(S);
                                throw new NullPointerException(sb.toString());
                            }
                        }
                    }
                    this.X = true;
                }
            } finally {
            }
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public String b() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract T c(int i2, int i3);

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String d();

    @NonNull
    @KeepForSdk
    public final T get(int i2) {
        k();
        int h2 = h(i2);
        int i3 = 0;
        if (i2 >= 0 && i2 != this.Y.size()) {
            int count = (i2 == this.Y.size() + -1 ? ((DataHolder) Preconditions.r(this.s)).getCount() : this.Y.get(i2 + 1).intValue()) - this.Y.get(i2).intValue();
            if (count == 1) {
                int h3 = h(i2);
                int S = ((DataHolder) Preconditions.r(this.s)).S(h3);
                String b2 = b();
                if (b2 == null || this.s.R(b2, h3, S) != null) {
                    i3 = 1;
                }
            } else {
                i3 = count;
            }
        }
        return c(h2, i3);
    }

    @KeepForSdk
    public int getCount() {
        k();
        return this.Y.size();
    }

    /* access modifiers changed from: package-private */
    public final int h(int i2) {
        if (i2 >= 0 && i2 < this.Y.size()) {
            return this.Y.get(i2).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i2);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }
}
