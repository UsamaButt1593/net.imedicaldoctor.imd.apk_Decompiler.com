package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3305a;

        /* renamed from: b  reason: collision with root package name */
        private final LayoutInflater f3306b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutInflater f3307c;

        public Helper(@NonNull Context context) {
            this.f3305a = context;
            this.f3306b = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater a() {
            LayoutInflater layoutInflater = this.f3307c;
            return layoutInflater != null ? layoutInflater : this.f3306b;
        }

        @Nullable
        public Resources.Theme b() {
            LayoutInflater layoutInflater = this.f3307c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void c(@Nullable Resources.Theme theme) {
            this.f3307c = theme == null ? null : theme.equals(this.f3305a.getTheme()) ? this.f3306b : LayoutInflater.from(new ContextThemeWrapper(this.f3305a, theme));
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}
