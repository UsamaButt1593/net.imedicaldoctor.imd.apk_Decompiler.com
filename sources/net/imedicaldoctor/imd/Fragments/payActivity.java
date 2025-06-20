package net.imedicaldoctor.imd.Fragments;

import android.os.Bundle;
import android.view.MenuItem;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class payActivity extends iMDActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new payActivityFragment());
        setContentView((int) R.layout.f1184activity_pay);
        if (bundle == null) {
            payActivityFragment payactivityfragment = new payActivityFragment();
            payactivityfragment.i2(getIntent().getExtras());
            k0().u().o("something").f(R.id.container, payactivityfragment).r();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
