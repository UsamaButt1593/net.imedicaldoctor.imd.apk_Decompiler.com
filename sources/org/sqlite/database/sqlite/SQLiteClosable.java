package org.sqlite.database.sqlite;

import java.io.Closeable;

public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    public void acquireReference() {
        synchronized (this) {
            try {
                int i2 = this.mReferenceCount;
                if (i2 > 0) {
                    this.mReferenceCount = i2 + 1;
                } else {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        releaseReference();
    }

    /* access modifiers changed from: protected */
    public abstract void onAllReferencesReleased();

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void releaseReference() {
        boolean z;
        synchronized (this) {
            z = true;
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        boolean z;
        synchronized (this) {
            z = true;
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            onAllReferencesReleasedFromContainer();
        }
    }
}
