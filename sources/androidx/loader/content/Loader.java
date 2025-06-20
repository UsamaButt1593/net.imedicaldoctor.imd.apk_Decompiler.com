package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {

    /* renamed from: a  reason: collision with root package name */
    int f8822a;

    /* renamed from: b  reason: collision with root package name */
    OnLoadCompleteListener<D> f8823b;

    /* renamed from: c  reason: collision with root package name */
    OnLoadCanceledListener<D> f8824c;

    /* renamed from: d  reason: collision with root package name */
    Context f8825d;

    /* renamed from: e  reason: collision with root package name */
    boolean f8826e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f8827f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f8828g = true;

    /* renamed from: h  reason: collision with root package name */
    boolean f8829h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f8830i = false;

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Loader.this.p();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void a(@NonNull Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void a(@NonNull Loader<D> loader, @Nullable D d2);
    }

    public Loader(@NonNull Context context) {
        this.f8825d = context.getApplicationContext();
    }

    public boolean A() {
        boolean z = this.f8829h;
        this.f8829h = false;
        this.f8830i |= z;
        return z;
    }

    @MainThread
    public void B(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.f8823b;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCompleteListener2 == onLoadCompleteListener) {
            this.f8823b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @MainThread
    public void C(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.f8824c;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCanceledListener2 == onLoadCanceledListener) {
            this.f8824c = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @MainThread
    public void a() {
        this.f8827f = true;
        n();
    }

    @MainThread
    public boolean b() {
        return o();
    }

    public void c() {
        this.f8830i = false;
    }

    @NonNull
    public String d(@Nullable D d2) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void e() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.f8824c;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.a(this);
        }
    }

    @MainThread
    public void f(@Nullable D d2) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.f8823b;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.a(this, d2);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f8822a);
        printWriter.print(" mListener=");
        printWriter.println(this.f8823b);
        if (this.f8826e || this.f8829h || this.f8830i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f8826e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f8829h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f8830i);
        }
        if (this.f8827f || this.f8828g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f8827f);
            printWriter.print(" mReset=");
            printWriter.println(this.f8828g);
        }
    }

    @MainThread
    public void h() {
        q();
    }

    @NonNull
    public Context i() {
        return this.f8825d;
    }

    public int j() {
        return this.f8822a;
    }

    public boolean k() {
        return this.f8827f;
    }

    public boolean l() {
        return this.f8828g;
    }

    public boolean m() {
        return this.f8826e;
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void n() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public boolean o() {
        return false;
    }

    @MainThread
    public void p() {
        if (this.f8826e) {
            h();
        } else {
            this.f8829h = true;
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void q() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void r() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void s() {
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void t() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.a(this, sb);
        sb.append(" id=");
        sb.append(this.f8822a);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void u(int i2, @NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.f8823b == null) {
            this.f8823b = onLoadCompleteListener;
            this.f8822a = i2;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void v(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.f8824c == null) {
            this.f8824c = onLoadCanceledListener;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void w() {
        r();
        this.f8828g = true;
        this.f8826e = false;
        this.f8827f = false;
        this.f8829h = false;
        this.f8830i = false;
    }

    public void x() {
        if (this.f8830i) {
            p();
        }
    }

    @MainThread
    public final void y() {
        this.f8826e = true;
        this.f8828g = false;
        this.f8827f = false;
        s();
    }

    @MainThread
    public void z() {
        this.f8826e = false;
        t();
    }
}
