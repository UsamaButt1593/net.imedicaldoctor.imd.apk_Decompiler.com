package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import androidx.core.util.ObjectsCompat;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    private static final String[] X2 = {"_display_name", "_size"};
    private static final String Y2 = "android.support.FILE_PROVIDER_PATHS";
    private static final String Z2 = "root-path";
    private static final String a3 = "files-path";
    private static final String b3 = "cache-path";
    private static final String c3 = "external-path";
    private static final String d3 = "external-files-path";
    private static final String e3 = "external-cache-path";
    private static final String f3 = "external-media-path";
    private static final String g3 = "name";
    private static final String h3 = "path";
    private static final String i3 = "displayName";
    private static final File j3 = new File("/");
    @GuardedBy("sCache")
    private static final HashMap<String, PathStrategy> k3 = new HashMap<>();
    @GuardedBy("mLock")
    private String X;
    @GuardedBy("mLock")
    @Nullable
    private PathStrategy Y;
    private final int Z;
    @NonNull
    private final Object s;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        File a(Uri uri);

        Uri b(File file);
    }

    static class SimplePathStrategy implements PathStrategy {

        /* renamed from: a  reason: collision with root package name */
        private final String f5639a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, File> f5640b = new HashMap<>();

        SimplePathStrategy(String str) {
            this.f5639a = str;
        }

        private boolean d(@NonNull String str, @NonNull String str2) {
            String a2 = FileProvider.l(str);
            String a3 = FileProvider.l(str2);
            if (!a2.equals(a3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(a3);
                sb.append('/');
                return a2.startsWith(sb.toString());
            }
        }

        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f5640b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (d(canonicalFile.getPath(), file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }

        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry next : this.f5640b.entrySet()) {
                    String path = ((File) next.getValue()).getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = next;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    boolean endsWith = path2.endsWith("/");
                    int length = path2.length();
                    if (!endsWith) {
                        length++;
                    }
                    String substring = canonicalPath.substring(length);
                    return new Uri.Builder().scheme(Annotation.i3).authority(this.f5639a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f5640b.put(str, file.getCanonicalFile());
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e2);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }
    }

    public FileProvider() {
        this(0);
    }

    private static File b(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] c(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }

    private static String[] d(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    @VisibleForTesting
    static XmlResourceParser e(Context context, String str, @Nullable ProviderInfo providerInfo, int i2) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i2 != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt(Y2, i2);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), Y2);
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    @NonNull
    private PathStrategy f() {
        PathStrategy pathStrategy;
        synchronized (this.s) {
            try {
                ObjectsCompat.e(this.X, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.Y == null) {
                    this.Y = g(getContext(), this.X, this.Z);
                }
                pathStrategy = this.Y;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    private static PathStrategy g(Context context, String str, int i2) {
        PathStrategy pathStrategy;
        HashMap<String, PathStrategy> hashMap = k3;
        synchronized (hashMap) {
            try {
                pathStrategy = hashMap.get(str);
                if (pathStrategy == null) {
                    pathStrategy = k(context, str, i2);
                    hashMap.put(str, pathStrategy);
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
            } catch (XmlPullParserException e4) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    public static Uri h(@NonNull Context context, @NonNull String str, @NonNull File file) {
        return g(context, str, 0).b(file);
    }

    @SuppressLint({"StreamFiles"})
    @NonNull
    public static Uri i(@NonNull Context context, @NonNull String str, @NonNull File file, @NonNull String str2) {
        return h(context, str, file).buildUpon().appendQueryParameter(i3, str2).build();
    }

    private static int j(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static PathStrategy k(Context context, String str, int i2) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser e2 = e(context, str, context.getPackageManager().resolveContentProvider(str, 128), i2);
        while (true) {
            int next = e2.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = e2.getName();
                File file = null;
                String attributeValue = e2.getAttributeValue((String) null, "name");
                String attributeValue2 = e2.getAttributeValue((String) null, "path");
                if (Z2.equals(name)) {
                    file = j3;
                } else if (a3.equals(name)) {
                    file = context.getFilesDir();
                } else if (b3.equals(name)) {
                    file = context.getCacheDir();
                } else if (c3.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if (d3.equals(name)) {
                    File[] n2 = ContextCompat.n(context, (String) null);
                    if (n2.length > 0) {
                        file = n2[0];
                    }
                } else if (e3.equals(name)) {
                    File[] m2 = ContextCompat.m(context);
                    if (m2.length > 0) {
                        file = m2[0];
                    }
                } else if (f3.equals(name)) {
                    File[] a2 = Api21Impl.a(context);
                    if (a2.length > 0) {
                        file = a2[0];
                    }
                }
                if (file != null) {
                    simplePathStrategy.c(attributeValue, b(file, attributeValue2));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public static String l(@NonNull String str) {
        return (str.length() <= 0 || str.charAt(str.length() + -1) != '/') ? str : str.substring(0, str.length() - 1);
    }

    @CallSuper
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            String str = providerInfo.authority.split(";")[0];
            synchronized (this.s) {
                this.X = str;
            }
            HashMap<String, PathStrategy> hashMap = k3;
            synchronized (hashMap) {
                hashMap.remove(str);
            }
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return f().a(uri).delete() ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri r3) {
        /*
            r2 = this;
            androidx.core.content.FileProvider$PathStrategy r0 = r2.f()
            java.io.File r3 = r0.a(r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0029
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0029
            return r3
        L_0x0029:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.FileProvider.getType(android.net.Uri):java.lang.String");
    }

    @Nullable
    public String getTypeAnonymous(@NonNull Uri uri) {
        return FilePart.DEFAULT_CONTENT_TYPE;
    }

    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(f().a(uri), j(str));
    }

    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i2;
        File a2 = f().a(uri);
        String queryParameter = uri.getQueryParameter(i3);
        if (strArr == null) {
            strArr = X2;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i4 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i4] = "_display_name";
                i2 = i4 + 1;
                objArr[i4] = queryParameter == null ? a2.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i4] = "_size";
                i2 = i4 + 1;
                objArr[i4] = Long.valueOf(a2.length());
            }
            i4 = i2;
        }
        String[] d2 = d(strArr3, i4);
        Object[] c2 = c(objArr, i4);
        MatrixCursor matrixCursor = new MatrixCursor(d2, 1);
        matrixCursor.addRow(c2);
        return matrixCursor;
    }

    public int update(@NonNull Uri uri, @NonNull ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    protected FileProvider(@XmlRes int i2) {
        this.s = new Object();
        this.Z = i2;
    }
}
