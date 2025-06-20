package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Arrays;

@UnstableApi
public final class DefaultAllocator implements Allocator {

    /* renamed from: h  reason: collision with root package name */
    private static final int f12523h = 100;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12524a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12525b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f12526c;

    /* renamed from: d  reason: collision with root package name */
    private int f12527d;

    /* renamed from: e  reason: collision with root package name */
    private int f12528e;

    /* renamed from: f  reason: collision with root package name */
    private int f12529f;

    /* renamed from: g  reason: collision with root package name */
    private Allocation[] f12530g;

    public DefaultAllocator(boolean z, int i2) {
        this(z, i2, 0);
    }

    public synchronized void a(@Nullable Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            try {
                Allocation[] allocationArr = this.f12530g;
                int i2 = this.f12529f;
                this.f12529f = i2 + 1;
                allocationArr[i2] = allocationNode.a();
                this.f12528e--;
                allocationNode = allocationNode.next();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        notifyAll();
    }

    public synchronized Allocation b() {
        Allocation allocation;
        try {
            this.f12528e++;
            int i2 = this.f12529f;
            if (i2 > 0) {
                Allocation[] allocationArr = this.f12530g;
                int i3 = i2 - 1;
                this.f12529f = i3;
                allocation = (Allocation) Assertions.g(allocationArr[i3]);
                this.f12530g[this.f12529f] = null;
            } else {
                allocation = new Allocation(new byte[this.f12525b], 0);
                int i4 = this.f12528e;
                Allocation[] allocationArr2 = this.f12530g;
                if (i4 > allocationArr2.length) {
                    this.f12530g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return allocation;
    }

    public synchronized void c(Allocation allocation) {
        Allocation[] allocationArr = this.f12530g;
        int i2 = this.f12529f;
        this.f12529f = i2 + 1;
        allocationArr[i2] = allocation;
        this.f12528e--;
        notifyAll();
    }

    public synchronized void d() {
        try {
            int i2 = 0;
            int max = Math.max(0, Util.q(this.f12527d, this.f12525b) - this.f12528e);
            int i3 = this.f12529f;
            if (max < i3) {
                if (this.f12526c != null) {
                    int i4 = i3 - 1;
                    while (i2 <= i4) {
                        Allocation allocation = (Allocation) Assertions.g(this.f12530g[i2]);
                        if (allocation.f12431a == this.f12526c) {
                            i2++;
                        } else {
                            Allocation allocation2 = (Allocation) Assertions.g(this.f12530g[i4]);
                            if (allocation2.f12431a != this.f12526c) {
                                i4--;
                            } else {
                                Allocation[] allocationArr = this.f12530g;
                                allocationArr[i2] = allocation2;
                                allocationArr[i4] = allocation;
                                i4--;
                                i2++;
                            }
                        }
                    }
                    max = Math.max(max, i2);
                    if (max >= this.f12529f) {
                        return;
                    }
                }
                Arrays.fill(this.f12530g, max, this.f12529f, (Object) null);
                this.f12529f = max;
            }
        } finally {
            while (true) {
            }
        }
    }

    public synchronized int e() {
        return this.f12528e * this.f12525b;
    }

    public int f() {
        return this.f12525b;
    }

    public synchronized void g() {
        if (this.f12524a) {
            h(0);
        }
    }

    public synchronized void h(int i2) {
        boolean z = i2 < this.f12527d;
        this.f12527d = i2;
        if (z) {
            d();
        }
    }

    public DefaultAllocator(boolean z, int i2, int i3) {
        boolean z2 = true;
        Assertions.a(i2 > 0);
        Assertions.a(i3 < 0 ? false : z2);
        this.f12524a = z;
        this.f12525b = i2;
        this.f12529f = i3;
        this.f12530g = new Allocation[(i3 + 100)];
        if (i3 > 0) {
            this.f12526c = new byte[(i3 * i2)];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f12530g[i4] = new Allocation(this.f12526c, i4 * i2);
            }
            return;
        }
        this.f12526c = null;
    }
}
