package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public enum RemovalCause {
    EXPLICIT {
        /* access modifiers changed from: package-private */
        public boolean b() {
            return false;
        }
    },
    REPLACED {
        /* access modifiers changed from: package-private */
        public boolean b() {
            return false;
        }
    },
    COLLECTED {
        /* access modifiers changed from: package-private */
        public boolean b() {
            return true;
        }
    },
    EXPIRED {
        /* access modifiers changed from: package-private */
        public boolean b() {
            return true;
        }
    },
    SIZE {
        /* access modifiers changed from: package-private */
        public boolean b() {
            return true;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean b();
}
