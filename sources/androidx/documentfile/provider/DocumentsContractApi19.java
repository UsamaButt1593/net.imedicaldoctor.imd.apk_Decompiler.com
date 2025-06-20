package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class DocumentsContractApi19 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7318a = "DocumentFile";

    /* renamed from: b  reason: collision with root package name */
    private static final int f7319b = 512;

    private DocumentsContractApi19() {
    }

    public static boolean a(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(g(context, uri));
    }

    public static boolean b(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String g2 = g(context, uri);
        int n2 = n(context, uri, "flags", 0);
        if (TextUtils.isEmpty(g2)) {
            return false;
        }
        if ((n2 & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(g2) || (n2 & 8) == 0) {
            return !TextUtils.isEmpty(g2) && (n2 & 2) != 0;
        }
        return true;
    }

    private static void c(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean d(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            Log.w(f7318a, "Failed query: " + e2);
            return false;
        } finally {
            c(cursor);
        }
    }

    public static long e(Context context, Uri uri) {
        return o(context, uri, "flags", 0);
    }

    @Nullable
    public static String f(Context context, Uri uri) {
        return p(context, uri, "_display_name", (String) null);
    }

    @Nullable
    private static String g(Context context, Uri uri) {
        return p(context, uri, "mime_type", (String) null);
    }

    @Nullable
    public static String h(Context context, Uri uri) {
        String g2 = g(context, uri);
        if ("vnd.android.document/directory".equals(g2)) {
            return null;
        }
        return g2;
    }

    public static boolean i(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(g(context, uri));
    }

    public static boolean j(Context context, Uri uri) {
        String g2 = g(context, uri);
        return !"vnd.android.document/directory".equals(g2) && !TextUtils.isEmpty(g2);
    }

    public static boolean k(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri) && (e(context, uri) & 512) != 0;
    }

    public static long l(Context context, Uri uri) {
        return o(context, uri, "last_modified", 0);
    }

    public static long m(Context context, Uri uri) {
        return o(context, uri, "_size", 0);
    }

    private static int n(Context context, Uri uri, String str, int i2) {
        return (int) o(context, uri, str, (long) i2);
    }

    private static long o(Context context, Uri uri, String str, long j2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            c(cursor);
            return j2;
        } catch (Exception e2) {
            Log.w(f7318a, "Failed query: " + e2);
            return j2;
        } finally {
            c(cursor);
        }
    }

    @Nullable
    private static String p(Context context, Uri uri, String str, @Nullable String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getString(0);
            }
            c(cursor);
            return str2;
        } catch (Exception e2) {
            Log.w(f7318a, "Failed query: " + e2);
            return str2;
        } finally {
            c(cursor);
        }
    }
}
