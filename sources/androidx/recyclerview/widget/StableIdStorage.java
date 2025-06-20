package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {

        /* renamed from: a  reason: collision with root package name */
        long f15628a = 0;

        class WrapperStableIdLookup implements StableIdLookup {

            /* renamed from: a  reason: collision with root package name */
            private final LongSparseArray<Long> f15629a = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            public long a(long j2) {
                Long h2 = this.f15629a.h(j2);
                if (h2 == null) {
                    h2 = Long.valueOf(IsolatedStableIdStorage.this.b());
                    this.f15629a.p(j2, h2);
                }
                return h2.longValue();
            }
        }

        @NonNull
        public StableIdLookup a() {
            return new WrapperStableIdLookup();
        }

        /* access modifiers changed from: package-private */
        public long b() {
            long j2 = this.f15628a;
            this.f15628a = 1 + j2;
            return j2;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {

        /* renamed from: a  reason: collision with root package name */
        private final StableIdLookup f15631a = new StableIdLookup() {
            public long a(long j2) {
                return -1;
            }
        };

        @NonNull
        public StableIdLookup a() {
            return this.f15631a;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {

        /* renamed from: a  reason: collision with root package name */
        private final StableIdLookup f15633a = new StableIdLookup() {
            public long a(long j2) {
                return j2;
            }
        };

        @NonNull
        public StableIdLookup a() {
            return this.f15633a;
        }
    }

    public interface StableIdLookup {
        long a(long j2);
    }

    @NonNull
    StableIdLookup a();
}
