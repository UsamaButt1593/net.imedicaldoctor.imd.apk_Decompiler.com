package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final Loader<Cursor>.ForceLoadContentObserver r = new Loader.ForceLoadContentObserver();
    Uri s;
    String[] t;
    String u;
    String[] v;
    String w;
    Cursor x;
    CancellationSignal y;

    public CursorLoader(@NonNull Context context) {
        super(context);
    }

    public void D() {
        super.D();
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = this.y;
                if (cancellationSignal != null) {
                    cancellationSignal.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: N */
    public void f(Cursor cursor) {
        if (!l()) {
            Cursor cursor2 = this.x;
            this.x = cursor;
            if (m()) {
                super.f(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Nullable
    public String[] O() {
        return this.t;
    }

    @Nullable
    public String P() {
        return this.u;
    }

    @Nullable
    public String[] Q() {
        return this.v;
    }

    @Nullable
    public String R() {
        return this.w;
    }

    @NonNull
    public Uri S() {
        return this.s;
    }

    /* renamed from: T */
    public Cursor I() {
        Cursor b2;
        synchronized (this) {
            if (!H()) {
                this.y = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            b2 = ContentResolverCompat.b(i().getContentResolver(), this.s, this.t, this.u, this.v, this.w, this.y);
            if (b2 != null) {
                b2.getCount();
                b2.registerContentObserver(this.r);
            }
            synchronized (this) {
                this.y = null;
            }
            return b2;
        } catch (RuntimeException e2) {
            b2.close();
            throw e2;
        } catch (Throwable th) {
            synchronized (this) {
                this.y = null;
                throw th;
            }
        }
    }

    /* renamed from: U */
    public void J(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void V(@Nullable String[] strArr) {
        this.t = strArr;
    }

    public void W(@Nullable String str) {
        this.u = str;
    }

    public void X(@Nullable String[] strArr) {
        this.v = strArr;
    }

    public void Y(@Nullable String str) {
        this.w = str;
    }

    public void Z(@NonNull Uri uri) {
        this.s = uri;
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.t));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.v));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f8829h);
    }

    /* access modifiers changed from: protected */
    public void r() {
        super.r();
        t();
        Cursor cursor = this.x;
        if (cursor != null && !cursor.isClosed()) {
            this.x.close();
        }
        this.x = null;
    }

    /* access modifiers changed from: protected */
    public void s() {
        Cursor cursor = this.x;
        if (cursor != null) {
            f(cursor);
        }
        if (A() || this.x == null) {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        b();
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.s = uri;
        this.t = strArr;
        this.u = str;
        this.v = strArr2;
        this.w = str2;
    }
}
