package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsApplier() {
    }

    private WindowInsetsCompat b(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.f6562c;
        return windowInsetsCompat2.J() != null ? windowInsetsCompat2 : windowInsetsCompat.c().b();
    }

    public static boolean c(@NonNull ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && applicationInfo.targetSdkVersion >= 30) {
            return false;
        }
        ViewCompat.k2(viewPager2, new WindowInsetsApplier());
        return true;
    }

    @NonNull
    public WindowInsetsCompat a(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat k1 = ViewCompat.k1(viewPager2, windowInsetsCompat);
        if (k1.A()) {
            return k1;
        }
        RecyclerView recyclerView = viewPager2.f3;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewCompat.p(recyclerView.getChildAt(i2), new WindowInsetsCompat(k1));
        }
        return b(k1);
    }
}
