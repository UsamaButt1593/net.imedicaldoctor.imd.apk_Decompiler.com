package net.imedicaldoctor.imd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

public class iMDActivity extends AppCompatActivity {
    public void Y0(Fragment fragment, Bundle bundle) {
        fragment.i2(getIntent().getExtras());
        if (getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
            getWindow().setFlags(67108864, 67108864);
            View findViewById = findViewById(R.id.f906detail_container);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(0, -Z0(), 0, 0);
            findViewById.setLayoutParams(layoutParams);
        }
        E0().d0(false);
        k0().u().C(R.id.f906detail_container, fragment).r();
    }

    public int Z0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void a1(Bundle bundle, Fragment fragment) {
        setContentView((int) R.layout.f1174activity_general_list);
        if (bundle == null) {
            fragment.i2(getIntent().getExtras());
            if (getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
                getWindow().setFlags(67108864, 67108864);
                View findViewById = findViewById(R.id.container);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.setMargins(0, -Z0(), 0, 0);
                findViewById.setLayoutParams(layoutParams);
            }
            k0().u().f(R.id.container, fragment).r();
        }
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getSharedPreferences("default_preferences", 0).getBoolean("dark", false)) {
            AppCompatDelegate.c0(2);
        } else {
            AppCompatDelegate.c0(1);
        }
        if (getSharedPreferences("default_preferences", 0).getBoolean("wakelock", true)) {
            getWindow().addFlags(128);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.f15from_fade_in, R.anim.f16from_fade_out);
    }
}
