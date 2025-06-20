package net.imedicaldoctor.imd.Fragments;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class fabActivity extends iMDActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1172activity_fab);
        P0((Toolbar) findViewById(R.id.f1139toolbar));
        ((FloatingActionButton) findViewById(R.id.f934fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.E0(view, "Replace with your own action", 0).H0("Action", (View.OnClickListener) null).m0();
            }
        });
    }
}
