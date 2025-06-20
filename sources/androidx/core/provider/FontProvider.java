package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<byte[]> f6088a = new a();

    private interface ContentQueryWrapper {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final ContentProviderClient f6089a;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.f6089a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f6089a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e2) {
                Log.w("FontsProvider", "Unable to query the content provider", e2);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f6089a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    @RequiresApi(24)
    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final ContentProviderClient f6090a;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.f6090a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f6090a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e2) {
                Log.w("FontsProvider", "Unable to query the content provider", e2);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f6090a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private FontProvider() {
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(FontRequest fontRequest, Resources resources) {
        return fontRequest.b() != null ? fontRequest.b() : FontResourcesParserCompat.c(resources, fontRequest.c());
    }

    @NonNull
    static FontsContractCompat.FontFamilyResult e(@NonNull Context context, @NonNull FontRequest fontRequest, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo f2 = f(context.getPackageManager(), fontRequest, context.getResources());
        return f2 == null ? FontsContractCompat.FontFamilyResult.a(1, (FontsContractCompat.FontInfo[]) null) : FontsContractCompat.FontFamilyResult.a(0, h(context, fontRequest, f2.authority, cancellationSignal));
    }

    @VisibleForTesting
    @Nullable
    static ProviderInfo f(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String f2 = fontRequest.f();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(f2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + f2);
        } else if (resolveContentProvider.packageName.equals(fontRequest.g())) {
            List<byte[]> b2 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b2, f6088a);
            List<List<byte[]>> d2 = d(fontRequest, resources);
            for (int i2 = 0; i2 < d2.size(); i2++) {
                ArrayList arrayList = new ArrayList(d2.get(i2));
                Collections.sort(arrayList, f6088a);
                if (c(b2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + f2 + ", but package was not " + fontRequest.g());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            byte b3 = bArr2[i2];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    @VisibleForTesting
    @NonNull
    static FontsContractCompat.FontInfo[] h(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        boolean z;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme(Annotation.i3).authority(str2).build();
        Uri build2 = new Uri.Builder().scheme(Annotation.i3).authority(str2).appendPath(Annotation.k3).build();
        ContentQueryWrapper a2 = b.a(context, build);
        Cursor cursor = null;
        try {
            Cursor a3 = a2.a(build, new String[]{"_id", FontsContractCompat.Columns.f6106a, FontsContractCompat.Columns.f6107b, FontsContractCompat.Columns.f6108c, FontsContractCompat.Columns.f6109d, FontsContractCompat.Columns.f6110e, FontsContractCompat.Columns.f6111f}, "query = ?", new String[]{fontRequest.h()}, (String) null, cancellationSignal);
            if (a3 != null && a3.getCount() > 0) {
                int columnIndex = a3.getColumnIndex(FontsContractCompat.Columns.f6111f);
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = a3.getColumnIndex("_id");
                int columnIndex3 = a3.getColumnIndex(FontsContractCompat.Columns.f6106a);
                int columnIndex4 = a3.getColumnIndex(FontsContractCompat.Columns.f6107b);
                int columnIndex5 = a3.getColumnIndex(FontsContractCompat.Columns.f6109d);
                int columnIndex6 = a3.getColumnIndex(FontsContractCompat.Columns.f6110e);
                while (a3.moveToNext()) {
                    int i2 = columnIndex != -1 ? a3.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? a3.getInt(columnIndex4) : 0;
                    ArrayList arrayList3 = arrayList2;
                    Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, a3.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, a3.getLong(columnIndex3));
                    int i4 = columnIndex5 != -1 ? a3.getInt(columnIndex5) : 400;
                    if (columnIndex6 != -1) {
                        z = true;
                        if (a3.getInt(columnIndex6) == 1) {
                            FontsContractCompat.FontInfo a4 = FontsContractCompat.FontInfo.a(withAppendedId, i3, i4, z, i2);
                            arrayList2 = arrayList3;
                            arrayList2.add(a4);
                        }
                    }
                    z = false;
                    FontsContractCompat.FontInfo a42 = FontsContractCompat.FontInfo.a(withAppendedId, i3, i4, z, i2);
                    arrayList2 = arrayList3;
                    arrayList2.add(a42);
                }
                arrayList = arrayList2;
            }
            if (a3 != null) {
                a3.close();
            }
            a2.close();
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            a2.close();
            throw th;
        }
    }
}
