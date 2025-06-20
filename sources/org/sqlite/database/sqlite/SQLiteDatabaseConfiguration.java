package org.sqlite.database.sqlite;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class SQLiteDatabaseConfiguration {
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    public static final String MEMORY_DB_PATH = ":memory:";
    public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList<>();
    public boolean foreignKeyConstraintsEnabled;
    public final String label;
    public Locale locale;
    public int maxSqlCacheSize;
    public int openFlags;
    public final String path;

    public SQLiteDatabaseConfiguration(String str, int i2) {
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

    private static String stripPathForLogs(String str) {
        return str.indexOf(64) == -1 ? str : EMAIL_IN_DB_PATTERN.matcher(str).replaceAll("XX@YY");
    }

    public boolean isInMemoryDb() {
        return this.path.equalsIgnoreCase(":memory:");
    }

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
        } else {
            throw new IllegalArgumentException("other configuration must refer to the same database.");
        }
    }

    public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration != null) {
            this.path = sQLiteDatabaseConfiguration.path;
            this.label = sQLiteDatabaseConfiguration.label;
            updateParametersFrom(sQLiteDatabaseConfiguration);
            return;
        }
        throw new IllegalArgumentException("other must not be null.");
    }
}
