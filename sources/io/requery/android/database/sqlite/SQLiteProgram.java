package io.requery.android.database.sqlite;

import androidx.core.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.Arrays;

public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Object[] mBindArgs;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

    SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        String trim = str.trim();
        this.mSql = trim;
        int sqlStatementType = SQLiteStatementType.getSqlStatementType(trim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.mReadOnly = false;
            this.mColumnNames = EMPTY_STRING_ARRAY;
            this.mNumParameters = 0;
        } else {
            boolean z = sqlStatementType != 1 ? false : true;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            sQLiteDatabase.getThreadSession().prepare(trim, sQLiteDatabase.getThreadDefaultConnectionFlags(z), cancellationSignal, sQLiteStatementInfo);
            this.mReadOnly = sQLiteStatementInfo.readOnly;
            this.mColumnNames = sQLiteStatementInfo.columnNames;
            this.mNumParameters = sQLiteStatementInfo.numParameters;
        }
        if (objArr == null || objArr.length <= this.mNumParameters) {
            int i2 = this.mNumParameters;
            if (i2 != 0) {
                Object[] objArr2 = new Object[i2];
                this.mBindArgs = objArr2;
                if (objArr != null) {
                    System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                    return;
                }
                return;
            }
            this.mBindArgs = null;
            return;
        }
        throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
    }

    private void bind(int i2, Object obj) {
        if (i2 < 1 || i2 > this.mNumParameters) {
            throw new IllegalArgumentException("Cannot bind argument at index " + i2 + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
        }
        this.mBindArgs[i2 - 1] = obj;
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    public void bindBlob(int i2, byte[] bArr) {
        if (bArr != null) {
            bind(i2, bArr);
            return;
        }
        throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
    }

    public void bindDouble(int i2, double d2) {
        bind(i2, Double.valueOf(d2));
    }

    public void bindLong(int i2, long j2) {
        bind(i2, Long.valueOf(j2));
    }

    public void bindNull(int i2) {
        bind(i2, (Object) null);
    }

    public void bindObject(int i2, Object obj) {
        long j2;
        if (obj == null) {
            bindNull(i2);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            bindDouble(i2, ((Number) obj).doubleValue());
        } else {
            if (obj instanceof Number) {
                j2 = ((Number) obj).longValue();
            } else if (obj instanceof Boolean) {
                j2 = ((Boolean) obj).booleanValue() ? 1 : 0;
            } else if (obj instanceof byte[]) {
                bindBlob(i2, (byte[]) obj);
                return;
            } else {
                bindString(i2, obj.toString());
                return;
            }
            bindLong(i2, j2);
        }
    }

    public void bindString(int i2, String str) {
        if (str != null) {
            bind(i2, str);
            return;
        }
        throw new IllegalArgumentException("the bind value at index " + i2 + " is null");
    }

    public void clearBindings() {
        Object[] objArr = this.mBindArgs;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    /* access modifiers changed from: package-private */
    public final String[] getColumnNames() {
        return this.mColumnNames;
    }

    /* access modifiers changed from: protected */
    public final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    /* access modifiers changed from: protected */
    public final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    /* access modifiers changed from: package-private */
    public final String getSql() {
        return this.mSql;
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        clearBindings();
    }

    /* access modifiers changed from: protected */
    public final void onCorruption() {
        this.mDatabase.onCorruption();
    }
}
