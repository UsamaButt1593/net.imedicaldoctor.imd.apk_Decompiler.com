package net.imedicaldoctor.imd;

import android.os.Looper;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.imedicaldoctor.imd.Data.CompressHelper;

public class iMDLogger {
    private static boolean a() {
        return iMD.d().getSharedPreferences("default_preferences", 0).getBoolean("savelogs", false);
    }

    private static void b(String str, String str2, String str3, Exception exc) {
        try {
            if (str.equals("e")) {
                Log.e(str2, str3);
            } else if (str.equals("d")) {
                Log.d(str2, str3);
            } else if (str.equals("w")) {
                Log.w(str2, str3);
            } else if (str.equals("v")) {
                Log.v(str2, str3);
            } else if (str.equals("i")) {
                Log.i(str2, str3);
            }
            if (a()) {
                String str4 = "";
                if (exc != null) {
                    str4 = exc.getLocalizedMessage();
                }
                n(str, str2, str3, str4);
            }
        } catch (Exception unused) {
        }
    }

    public static String c() {
        try {
            CompressHelper compressHelper = new CompressHelper(iMD.c());
            String str = compressHelper.M1() + "/zlogs.db";
            if (!new File(str).exists()) {
                SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create table logs (id integer primary key autoincrement,cat varchar(10), tag varchar(255), description text, error text, date varchar(50), appsession varchar(20),stacktrace text);");
            }
            return str;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            FirebaseCrashlytics.d().g(e2);
            return null;
        }
    }

    public static void d(String str, String str2) {
        b("d", str, str2, (Exception) null);
    }

    public static void e(String str, String str2, Exception exc) {
        b("d", str, str2, exc);
    }

    public static void f(String str, String str2) {
        b("e", str, str2, (Exception) null);
    }

    public static void g(String str, String str2, Exception exc) {
        b("e", str, str2, exc);
    }

    public static void h(String str, String str2) {
        b("i", str, str2, (Exception) null);
    }

    public static void i(String str, String str2, Exception exc) {
        b("i", str, str2, exc);
    }

    public static void j(String str, String str2) {
        b("v", str, str2, (Exception) null);
    }

    public static void k(String str, String str2, Exception exc) {
        b("v", str, str2, exc);
    }

    public static void l(String str, String str2) {
        b("w", str, str2, (Exception) null);
    }

    public static void m(String str, String str2, Exception exc) {
        b("w", str, str2, exc);
    }

    private static void n(String str, String str2, String str3, String str4) {
        try {
            if (c() != null) {
                CompressHelper compressHelper = new CompressHelper(iMD.d());
                String o = o(str);
                String o2 = o(str2);
                String o3 = o(str4);
                String o4 = o(str3);
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String valueOf = String.valueOf(Looper.getMainLooper().getThread().getId());
                String c2 = c();
                compressHelper.q(c2, "Insert into logs (cat, tag, description,error, date, appsession, stacktrace) values ('" + o + "', '" + o2 + "', '" + o4 + "', '" + o3 + "', '" + format + "', '" + valueOf + "', '" + "" + "')");
            }
        } catch (Exception unused) {
        }
    }

    private static String o(String str) {
        return str.replace("'", "''");
    }
}
