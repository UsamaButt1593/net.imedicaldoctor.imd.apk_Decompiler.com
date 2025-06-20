package org.sqlite.database.sqlite;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    private static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool != null) {
            this.mConnectionPool = sQLiteConnectionPool;
            return;
        }
        throw new IllegalArgumentException("connectionPool must not be null");
    }

    private void acquireConnection(String str, int i2, CancellationSignal cancellationSignal) {
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i2, cancellationSignal);
            this.mConnectionFlags = i2;
        }
        this.mConnectionUseCount++;
    }

    private void beginTransactionUnchecked(int i2, SQLiteTransactionListener sQLiteTransactionListener, int i3, CancellationSignal cancellationSignal) {
        SQLiteConnection sQLiteConnection;
        String str;
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.mTransactionStack == null) {
            acquireConnection((String) null, i3, cancellationSignal);
        }
        try {
            if (this.mTransactionStack == null) {
                if (i2 == 1) {
                    sQLiteConnection = this.mConnection;
                    str = "BEGIN IMMEDIATE;";
                } else if (i2 != 2) {
                    sQLiteConnection = this.mConnection;
                    str = "BEGIN;";
                } else {
                    sQLiteConnection = this.mConnection;
                    str = "BEGIN EXCLUSIVE;";
                }
                sQLiteConnection.execute(str, (Object[]) null, cancellationSignal);
            }
            if (sQLiteTransactionListener != null) {
                sQLiteTransactionListener.onBegin();
            }
            Transaction obtainTransaction = obtainTransaction(i2, sQLiteTransactionListener);
            obtainTransaction.mParent = this.mTransactionStack;
            this.mTransactionStack = obtainTransaction;
        } catch (RuntimeException e2) {
            if (this.mTransactionStack == null) {
                this.mConnection.execute("ROLLBACK;", (Object[]) null, cancellationSignal);
            }
            throw e2;
        } catch (Throwable th) {
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
            throw th;
        }
    }

    private void endTransactionUnchecked(CancellationSignal cancellationSignal, boolean z) {
        RuntimeException e2;
        SQLiteConnection sQLiteConnection;
        String str;
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z2 = false;
        boolean z3 = (transaction.mMarkedSuccessful || z) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener != null) {
            if (z3) {
                try {
                    sQLiteTransactionListener.onCommit();
                } catch (RuntimeException e3) {
                    e2 = e3;
                }
            } else {
                sQLiteTransactionListener.onRollback();
            }
        }
        z2 = z3;
        e2 = null;
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        Transaction transaction2 = this.mTransactionStack;
        if (transaction2 == null) {
            if (z2) {
                try {
                    sQLiteConnection = this.mConnection;
                    str = "COMMIT;";
                } catch (Throwable th) {
                    releaseConnection();
                    throw th;
                }
            } else {
                sQLiteConnection = this.mConnection;
                str = "ROLLBACK;";
            }
            sQLiteConnection.execute(str, (Object[]) null, cancellationSignal);
            releaseConnection();
        } else if (!z2) {
            transaction2.mChildFailed = true;
        }
        if (e2 != null) {
            throw e2;
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
        if (sqlStatementType == 4) {
            beginTransaction(2, (SQLiteTransactionListener) null, i2, cancellationSignal);
            return true;
        } else if (sqlStatementType == 5) {
            setTransactionSuccessful();
            endTransaction(cancellationSignal);
            return true;
        } else if (sqlStatementType != 6) {
            return false;
        } else {
            endTransaction(cancellationSignal);
            return true;
        }
    }

    private Transaction obtainTransaction(int i2, SQLiteTransactionListener sQLiteTransactionListener) {
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i2;
        transaction.mListener = sQLiteTransactionListener;
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }

    private void releaseConnection() {
        int i2 = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i2;
        if (i2 == 0) {
            try {
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
            }
        }
    }

    private void throwIfNestedTransaction() {
        if (hasNestedTransaction()) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
    }

    private void throwIfNoTransaction() {
        if (this.mTransactionStack == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
    }

    private void throwIfTransactionMarkedSuccessful() {
        Transaction transaction = this.mTransactionStack;
        if (transaction != null && transaction.mMarkedSuccessful) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    private boolean yieldTransactionUnchecked(long j2, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            return false;
        }
        Transaction transaction = this.mTransactionStack;
        int i2 = transaction.mMode;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        int i3 = this.mConnectionFlags;
        endTransactionUnchecked(cancellationSignal, true);
        if (j2 > 0) {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException unused) {
            }
        }
        beginTransactionUnchecked(i2, sQLiteTransactionListener, i3, cancellationSignal);
        return true;
    }

    public void beginTransaction(int i2, SQLiteTransactionListener sQLiteTransactionListener, int i3, CancellationSignal cancellationSignal) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i2, sQLiteTransactionListener, i3, cancellationSignal);
    }

    public void endTransaction(CancellationSignal cancellationSignal) {
        throwIfNoTransaction();
        endTransactionUnchecked(cancellationSignal, false);
    }

    public void execute(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (!executeSpecial(str, objArr, i2, cancellationSignal)) {
            acquireConnection(str, i2, cancellationSignal);
            try {
                this.mConnection.execute(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            return null;
        } else {
            acquireConnection(str, i2, cancellationSignal);
            try {
                return this.mConnection.executeForBlobFileDescriptor(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i2, cancellationSignal);
            try {
                return this.mConnection.executeForChangedRowCount(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i2, int i3, boolean z, int i4, CancellationSignal cancellationSignal) {
        int i5 = i4;
        CancellationSignal cancellationSignal2 = cancellationSignal;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (cursorWindow != null) {
            Object[] objArr2 = objArr;
            if (executeSpecial(str, objArr, i5, cancellationSignal2)) {
                cursorWindow.clear();
                return 0;
            }
            acquireConnection(str, i5, cancellationSignal2);
            try {
                return this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i2, i3, z, cancellationSignal);
            } finally {
                releaseConnection();
            }
        } else {
            throw new IllegalArgumentException("window must not be null.");
        }
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i2, cancellationSignal);
            try {
                return this.mConnection.executeForLastInsertedRowId(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public long executeForLong(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i2, cancellationSignal);
            try {
                return this.mConnection.executeForLong(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public String executeForString(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            return null;
        } else {
            acquireConnection(str, i2, cancellationSignal);
            try {
                return this.mConnection.executeForString(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public boolean hasConnection() {
        return this.mConnection != null;
    }

    public boolean hasNestedTransaction() {
        Transaction transaction = this.mTransactionStack;
        return (transaction == null || transaction.mParent == null) ? false : true;
    }

    public boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public void prepare(String str, int i2, CancellationSignal cancellationSignal, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str != null) {
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            acquireConnection(str, i2, cancellationSignal);
            try {
                this.mConnection.prepare(str, sQLiteStatementInfo);
            } finally {
                releaseConnection();
            }
        } else {
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    public void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
    }

    public boolean yieldTransaction(long j2, boolean z, CancellationSignal cancellationSignal) {
        if (z) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else {
            Transaction transaction = this.mTransactionStack;
            if (transaction == null || transaction.mMarkedSuccessful || transaction.mParent != null) {
                return false;
            }
        }
        if (this.mTransactionStack.mChildFailed) {
            return false;
        }
        return yieldTransactionUnchecked(j2, cancellationSignal);
    }
}
