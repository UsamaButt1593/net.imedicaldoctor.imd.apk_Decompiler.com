package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

interface ViewTypeStorage {

    public static class IsolatedViewTypeStorage implements ViewTypeStorage {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<NestedAdapterWrapper> f15695a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f15696b = 0;

        class WrapperViewTypeLookup implements ViewTypeLookup {

            /* renamed from: a  reason: collision with root package name */
            private SparseIntArray f15697a = new SparseIntArray(1);

            /* renamed from: b  reason: collision with root package name */
            private SparseIntArray f15698b = new SparseIntArray(1);

            /* renamed from: c  reason: collision with root package name */
            final NestedAdapterWrapper f15699c;

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.f15699c = nestedAdapterWrapper;
            }

            public void m() {
                IsolatedViewTypeStorage.this.d(this.f15699c);
            }

            public int n(int i2) {
                int indexOfKey = this.f15698b.indexOfKey(i2);
                if (indexOfKey >= 0) {
                    return this.f15698b.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i2 + " does not belong to the adapter:" + this.f15699c.f15471c);
            }

            public int o(int i2) {
                int indexOfKey = this.f15697a.indexOfKey(i2);
                if (indexOfKey > -1) {
                    return this.f15697a.valueAt(indexOfKey);
                }
                int c2 = IsolatedViewTypeStorage.this.c(this.f15699c);
                this.f15697a.put(i2, c2);
                this.f15698b.put(c2, i2);
                return c2;
            }
        }

        @NonNull
        public NestedAdapterWrapper a(int i2) {
            NestedAdapterWrapper nestedAdapterWrapper = this.f15695a.get(i2);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i2);
        }

        @NonNull
        public ViewTypeLookup b(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        /* access modifiers changed from: package-private */
        public int c(NestedAdapterWrapper nestedAdapterWrapper) {
            int i2 = this.f15696b;
            this.f15696b = i2 + 1;
            this.f15695a.put(i2, nestedAdapterWrapper);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.f15695a.size() - 1; size >= 0; size--) {
                if (this.f15695a.valueAt(size) == nestedAdapterWrapper) {
                    this.f15695a.removeAt(size);
                }
            }
        }
    }

    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<List<NestedAdapterWrapper>> f15701a = new SparseArray<>();

        class WrapperViewTypeLookup implements ViewTypeLookup {

            /* renamed from: a  reason: collision with root package name */
            final NestedAdapterWrapper f15702a;

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.f15702a = nestedAdapterWrapper;
            }

            public void m() {
                SharedIdRangeViewTypeStorage.this.c(this.f15702a);
            }

            public int n(int i2) {
                return i2;
            }

            public int o(int i2) {
                List list = SharedIdRangeViewTypeStorage.this.f15701a.get(i2);
                if (list == null) {
                    list = new ArrayList();
                    SharedIdRangeViewTypeStorage.this.f15701a.put(i2, list);
                }
                if (!list.contains(this.f15702a)) {
                    list.add(this.f15702a);
                }
                return i2;
            }
        }

        @NonNull
        public NestedAdapterWrapper a(int i2) {
            List list = this.f15701a.get(i2);
            if (list != null && !list.isEmpty()) {
                return (NestedAdapterWrapper) list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i2);
        }

        @NonNull
        public ViewTypeLookup b(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.f15701a.size() - 1; size >= 0; size--) {
                List valueAt = this.f15701a.valueAt(size);
                if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                    this.f15701a.removeAt(size);
                }
            }
        }
    }

    public interface ViewTypeLookup {
        void m();

        int n(int i2);

        int o(int i2);
    }

    @NonNull
    NestedAdapterWrapper a(int i2);

    @NonNull
    ViewTypeLookup b(@NonNull NestedAdapterWrapper nestedAdapterWrapper);
}
