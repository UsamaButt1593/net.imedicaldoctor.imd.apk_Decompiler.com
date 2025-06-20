package io.requery.android.database.sqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public final class SQLiteDatabaseConfiguration {
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    public static final String MEMORY_DB_PATH = ":memory:";
    public final List<SQLiteCustomExtension> customExtensions;
    @Deprecated
    public final List<SQLiteCustomFunction> customFunctions;
    public boolean foreignKeyConstraintsEnabled;
    public final List<SQLiteFunction> functions;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public final String path;

    SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.customFunctions = new ArrayList();
        this.functions = new ArrayList();
        this.customExtensions = new ArrayList();
        if (sQLiteDatabaseConfiguration != null) {
            this.path = sQLiteDatabaseConfiguration.path;
            this.label = sQLiteDatabaseConfiguration.label;
            updateParametersFrom(sQLiteDatabaseConfiguration);
            return;
        }
        throw new IllegalArgumentException("other must not be null.");
    }

    private static String stripPathForLogs(String str) {
        return str.indexOf(64) == -1 ? str : EMAIL_IN_DB_PATTERN.matcher(str).replaceAll("XX@YY");
    }

    public boolean isInMemoryDb() {
        return this.path.equalsIgnoreCase(":memory:");
    }

    /* access modifiers changed from: package-private */
    public void updateParametersFrom(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("other must not be null.");
        } else if (this.path.equals(sQLiteDatabaseConfiguration.path)) {
            this.openFlags = sQLiteDatabaseConfiguration.openFlags;
            this.maxSqlCacheSize = sQLiteDatabaseConfiguration.maxSqlCacheSize;
            this.locale = sQLiteDatabaseConfiguration.locale;
            this.foreignKeyConstraintsEnabled = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
            this.customFunctions.clear();
            this.customFunctions.addAll(sQLiteDatabaseConfiguration.customFunctions);
            this.customExtensions.clear();
            this.customExtensions.addAll(sQLiteDatabaseConfiguration.customExtensions);
            this.functions.clear();
            this.functions.addAll(sQLiteDatabaseConfiguration.functions);
        } else {
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        }
    }

    public SQLiteDatabaseConfiguration(String str, int i2) {
        this.customFunctions = new ArrayList();
        this.functions = new ArrayList();
        this.customExtensions = new ArrayList();
        if (str != null) {
            this.path = str;
            this.label = stripPathForLogs(str);
            this.openFlags = i2;
            this.maxSqlCacheSize = 25;
            this.locale = Locale.getDefault();
            return;
        }
        throw new IllegalArgumentException("path must not be null.");
    }

    public SQLiteDatabaseConfiguration(String str, int i2, List<SQLiteCustomFunction> list, List<SQLiteFunction> list2, List<SQLiteCustomExtension> list3) {
        this(str, i2);
        this.customFunctions.addAll(list);
        this.customExtensions.addAll(list3);
        this.functions.addAll(list2);
    }
}
