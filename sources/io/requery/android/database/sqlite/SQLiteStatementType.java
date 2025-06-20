package io.requery.android.database.sqlite;

class SQLiteStatementType {
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;

    private SQLiteStatementType() {
    }

    public static int getSqlStatementType(String str) {
        String trim = str.trim();
        if (trim.length() < 3) {
            return 99;
        }
        String substring = trim.substring(0, 3);
        if (substring.equalsIgnoreCase("SEL") || substring.equalsIgnoreCase("WIT")) {
            return 1;
        }
        if (substring.equalsIgnoreCase("INS") || substring.equalsIgnoreCase("UPD") || substring.equalsIgnoreCase("REP") || substring.equalsIgnoreCase("DEL")) {
            return 2;
        }
        if (substring.equalsIgnoreCase("ATT")) {
            return 3;
        }
        if (substring.equalsIgnoreCase("COM") || substring.equalsIgnoreCase("END")) {
            return 5;
        }
        if (substring.equalsIgnoreCase("ROL")) {
            return 6;
        }
        if (substring.equalsIgnoreCase("BEG")) {
            return 4;
        }
        if (substring.equalsIgnoreCase("PRA")) {
            return 7;
        }
        if (substring.equalsIgnoreCase("CRE") || substring.equalsIgnoreCase("DRO") || substring.equalsIgnoreCase("ALT")) {
            return 8;
        }
        return (substring.equalsIgnoreCase("ANA") || substring.equalsIgnoreCase("DET")) ? 9 : 99;
    }
}
