package net.imedicaldoctor.imd.Gallery;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class GalleryActivity extends iMDActivity {
    private static final String z3 = "STATE_POSITION";
    private ViewPager y3;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1173activity_gallery);
        ImagePagerFragment imagePagerFragment = new ImagePagerFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("Images", getIntent().getParcelableArrayListExtra("Images"));
        bundle2.putInt("Start", getIntent().getIntExtra("Start", 0));
        if (getIntent().getParcelableArrayListExtra("Images").size() == 0) {
            CompressHelper.x2(this, "There is no image in this document", 1);
            finish();
        }
        imagePagerFragment.i2(bundle2);
        k0().u().C(R.id.f906detail_container, imagePagerFragment).r();
    }
}
