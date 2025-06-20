package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import org.apache.commons.lang3.StringUtils;

public class MMInteractResultActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public Bundle Z4;
    public ArrayList<String> a5;
    public NotStickySectionAdapter b5;
    public ArrayList<Bundle> c5;
    public ArrayList<Bundle> d5;

    public void I4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.p(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.X4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(this.E4.split("-")[1], ";;;;;");
        this.Q4.m(this.D4, "delete from selected_drugs");
        for (String splitByWholeSeparator2 : splitByWholeSeparator) {
            String[] splitByWholeSeparator3 = StringUtils.splitByWholeSeparator(splitByWholeSeparator2, ",,,,,");
            this.Q4.m(this.D4, "Insert into selected_drugs values (" + splitByWholeSeparator3[0] + ", '" + splitByWholeSeparator3[1] + "', 0)");
        }
        this.c5 = this.Q4.V(this.D4, "SELECT title, doc_id, severity, (SELECT descrip FROM dict_severity WHERE id = severity) severity_descr FROM v_interactions");
        this.F4 = "Found " + this.c5.size() + " Interactions";
        this.d5 = this.Q4.r2(this.c5, "severity_descr");
        AnonymousClass1 r2 = new NotStickySectionAdapter(r(), this.d5, "title", R.layout.f1346list_view_item_ripple_text_full) {
            public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("title"), " : ");
                int i3 = 0;
                String str = splitByWholeSeparator[0];
                String str2 = splitByWholeSeparator[1];
                rippleTextFullViewHolder.I.setText(str);
                rippleTextFullViewHolder.J.setText(str2);
                String string = bundle.getString("severity");
                if (string.equals(IcyHeaders.a3)) {
                    i3 = R.drawable.fb;
                } else if (string.equals(ExifInterface.Y4)) {
                    i3 = R.drawable.G3;
                } else if (string.equals(ExifInterface.Z4)) {
                    i3 = R.drawable.U2;
                } else if (string.equals("4")) {
                    i3 = R.drawable.S1;
                }
                rippleTextFullViewHolder.K.setImageDrawable(MMInteractResultActivityFragment.this.b0().getDrawable(i3));
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MMInteractResultActivityFragment mMInteractResultActivityFragment = MMInteractResultActivityFragment.this;
                        CompressHelper compressHelper = mMInteractResultActivityFragment.Q4;
                        Bundle bundle = mMInteractResultActivityFragment.D4;
                        compressHelper.A1(bundle, "doc-" + bundle.getString("doc_id") + ",,,,," + bundle.getString("title"), (String[]) null, (String) null);
                    }
                });
            }

            public String i0(String str) {
                return str;
            }

            public RecyclerView.ViewHolder k0(View view) {
                return new RippleTextFullViewHolder(view);
            }
        };
        this.b5 = r2;
        this.X4.setAdapter(r2);
        I4();
        f3(R.menu.f1414favorite);
        o2(false);
        G3();
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.Y4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }
}
