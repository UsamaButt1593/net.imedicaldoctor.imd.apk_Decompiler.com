package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

class ViewInfoStore {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f15681c = false;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> f15682a = new SimpleArrayMap<>();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final LongSparseArray<RecyclerView.ViewHolder> f15683b = new LongSparseArray<>();

    static class InfoRecord {

        /* renamed from: d  reason: collision with root package name */
        static final int f15684d = 1;

        /* renamed from: e  reason: collision with root package name */
        static final int f15685e = 2;

        /* renamed from: f  reason: collision with root package name */
        static final int f15686f = 4;

        /* renamed from: g  reason: collision with root package name */
        static final int f15687g = 8;

        /* renamed from: h  reason: collision with root package name */
        static final int f15688h = 3;

        /* renamed from: i  reason: collision with root package name */
        static final int f15689i = 12;

        /* renamed from: j  reason: collision with root package name */
        static final int f15690j = 14;

        /* renamed from: k  reason: collision with root package name */
        static Pools.Pool<InfoRecord> f15691k = new Pools.SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f15692a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f15693b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f15694c;

        private InfoRecord() {
        }

        static void a() {
            do {
            } while (f15691k.b() != null);
        }

        static InfoRecord b() {
            InfoRecord b2 = f15691k.b();
            return b2 == null ? new InfoRecord() : b2;
        }

        static void c(InfoRecord infoRecord) {
            infoRecord.f15692a = 0;
            infoRecord.f15693b = null;
            infoRecord.f15694c = null;
            f15691k.c(infoRecord);
        }
    }

    interface ProcessCallback {
        void a(RecyclerView.ViewHolder viewHolder);

        void b(RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void c(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i2) {
        InfoRecord m2;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int f2 = this.f15682a.f(viewHolder);
        if (f2 >= 0 && (m2 = this.f15682a.m(f2)) != null) {
            int i3 = m2.f15692a;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                m2.f15692a = i4;
                if (i2 == 4) {
                    itemHolderInfo = m2.f15693b;
                } else if (i2 == 8) {
                    itemHolderInfo = m2.f15694c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.f15682a.k(f2);
                    InfoRecord.c(m2);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f15682a.put(viewHolder, infoRecord);
        }
        infoRecord.f15692a |= 2;
        infoRecord.f15693b = itemHolderInfo;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f15682a.put(viewHolder, infoRecord);
        }
        infoRecord.f15692a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j2, RecyclerView.ViewHolder viewHolder) {
        this.f15683b.p(j2, viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f15682a.put(viewHolder, infoRecord);
        }
        infoRecord.f15694c = itemHolderInfo;
        infoRecord.f15692a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f15682a.put(viewHolder, infoRecord);
        }
        infoRecord.f15693b = itemHolderInfo;
        infoRecord.f15692a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f15682a.clear();
        this.f15683b.b();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ViewHolder g(long j2) {
        return this.f15683b.h(j2);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f15692a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f15692a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        InfoRecord.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(ProcessCallback processCallback) {
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2;
        for (int size = this.f15682a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder i2 = this.f15682a.i(size);
            InfoRecord k2 = this.f15682a.k(size);
            int i3 = k2.f15692a;
            if ((i3 & 3) != 3) {
                if ((i3 & 1) != 0) {
                    itemHolderInfo = k2.f15693b;
                    if (itemHolderInfo != null) {
                        itemHolderInfo2 = k2.f15694c;
                    }
                } else {
                    if ((i3 & 14) != 14) {
                        if ((i3 & 12) == 12) {
                            processCallback.d(i2, k2.f15693b, k2.f15694c);
                        } else if ((i3 & 4) != 0) {
                            itemHolderInfo = k2.f15693b;
                            itemHolderInfo2 = null;
                        } else if ((i3 & 8) == 0) {
                        }
                        InfoRecord.c(k2);
                    }
                    processCallback.b(i2, k2.f15693b, k2.f15694c);
                    InfoRecord.c(k2);
                }
                processCallback.c(i2, itemHolderInfo, itemHolderInfo2);
                InfoRecord.c(k2);
            }
            processCallback.a(i2);
            InfoRecord.c(k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f15682a.get(viewHolder);
        if (infoRecord != null) {
            infoRecord.f15692a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.ViewHolder viewHolder) {
        int y = this.f15683b.y() - 1;
        while (true) {
            if (y < 0) {
                break;
            } else if (viewHolder == this.f15683b.z(y)) {
                this.f15683b.u(y);
                break;
            } else {
                y--;
            }
        }
        InfoRecord remove = this.f15682a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.c(remove);
        }
    }
}
