package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static final int f16509c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16510d = -2;

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f16511a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f16512b;

    @Deprecated
    public void a(@NonNull View view, int i2, @NonNull Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void b(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        a(viewGroup, i2, obj);
    }

    @Deprecated
    public void c(@NonNull View view) {
    }

    public void d(@NonNull ViewGroup viewGroup) {
        c(viewGroup);
    }

    public abstract int e();

    public int f(@NonNull Object obj) {
        return -1;
    }

    @Nullable
    public CharSequence g(int i2) {
        return null;
    }

    public float h(int i2) {
        return 1.0f;
    }

    @NonNull
    @Deprecated
    public Object i(@NonNull View view, int i2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @NonNull
    public Object j(@NonNull ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }

    public abstract boolean k(@NonNull View view, @NonNull Object obj);

    public void l() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f16512b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f16511a.notifyChanged();
    }

    public void m(@NonNull DataSetObserver dataSetObserver) {
        this.f16511a.registerObserver(dataSetObserver);
    }

    public void n(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable o() {
        return null;
    }

    @Deprecated
    public void p(@NonNull View view, int i2, @NonNull Object obj) {
    }

    public void q(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        p(viewGroup, i2, obj);
    }

    /* access modifiers changed from: package-private */
    public void r(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f16512b = dataSetObserver;
        }
    }

    @Deprecated
    public void s(@NonNull View view) {
    }

    public void t(@NonNull ViewGroup viewGroup) {
        s(viewGroup);
    }

    public void u(@NonNull DataSetObserver dataSetObserver) {
        this.f16511a.unregisterObserver(dataSetObserver);
    }
}
