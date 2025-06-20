package io.requery.android.database.sqlite;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import io.requery.android.database.DatabaseErrorHandler;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.Collections;

public final class RequerySQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final Iterable<ConfigurationOptions> configurationOptions;

    private static final class CallbackDatabaseErrorHandler implements DatabaseErrorHandler {
        private final SupportSQLiteOpenHelper.Callback callback;

        CallbackDatabaseErrorHandler(SupportSQLiteOpenHelper.Callback callback2) {
            this.callback = callback2;
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            this.callback.c(sQLiteDatabase);
        }
    }

    private static final class CallbackSQLiteOpenHelper extends SQLiteOpenHelper {
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Iterable<ConfigurationOptions> configurationOptions;

        CallbackSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback2, Iterable<ConfigurationOptions> iterable) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, callback2.f15821a, new CallbackDatabaseErrorHandler(callback2));
            this.callback = callback2;
            this.configurationOptions = iterable;
        }

        /* access modifiers changed from: protected */
        public SQLiteDatabaseConfiguration createConfiguration(String str, int i2) {
            SQLiteDatabaseConfiguration createConfiguration = super.createConfiguration(str, i2);
            for (ConfigurationOptions apply : this.configurationOptions) {
                createConfiguration = apply.apply(createConfiguration);
            }
            return createConfiguration;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.callback.b(sQLiteDatabase);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.callback.d(sQLiteDatabase);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.callback.e(sQLiteDatabase, i2, i3);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            this.callback.f(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.callback.g(sQLiteDatabase, i2, i3);
        }
    }

    public interface ConfigurationOptions {
        SQLiteDatabaseConfiguration apply(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration);
    }

    public RequerySQLiteOpenHelperFactory() {
        this(Collections.emptyList());
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new CallbackSQLiteOpenHelper(configuration.f15823a, configuration.f15824b, configuration.f15825c, this.configurationOptions);
    }

    public RequerySQLiteOpenHelperFactory(Iterable<ConfigurationOptions> iterable) {
        this.configurationOptions = iterable;
    }
}
