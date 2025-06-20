package net.imedicaldoctor.imd.Fragments.Epocrate;

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
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import org.apache.commons.lang3.StringUtils;

public class EPOInteractResultActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public String Z4;
    public Bundle a5;
    public Bundle b5;
    public ArrayList<String> c5;
    public NotStickySectionAdapter d5;
    public ArrayList<Bundle> e5;
    public ArrayList<Bundle> f5;

    public void I4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
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
        this.a5 = new Bundle();
        this.c5 = new ArrayList<>();
        this.b5 = new Bundle();
        this.Z4 = "RX.sqlite";
        for (String splitByWholeSeparator : StringUtils.splitByWholeSeparator(this.E4.split("-")[1], ";;;;;")) {
            String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(splitByWholeSeparator, ",,,,,");
            this.a5.putString(splitByWholeSeparator2[0], splitByWholeSeparator2[1]);
            this.c5.add(splitByWholeSeparator2[0]);
        }
        String join = StringUtils.join((Iterable<?>) this.c5, ",");
        this.Y4 = this.Q4.X(this.D4, "Select * from pill_pictures where drug_id in (" + join + ")", this.Z4, true);
        ArrayList<Bundle> X = this.Q4.X(this.D4, "SELECT                     ID,                     DRUG_ID AS DRUG_0_ID,                     INTERACTING_DRUG_ID AS DRUG_1_ID,                     DDI_ID,                     GROUP_0_ID,                     GROUP_1_ID                     FROM (                     SELECT DISTINCT                     tDID.ID,                     MIN(d1.ID, d2.ID) AS DRUG_ID,                     MAX(d1.ID, d2.ID) AS INTERACTING_DRUG_ID,                     tDID.DDI_ID,                     DDI.GROUP_0_ID,                     DDI.GROUP_1_ID                     FROM                     DRUG_TO_INTERACTING_DRUG tDID                     JOIN DDI ON tDID.DDI_ID = DDI.ID                     JOIN DRUG d1 ON d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID OR d1.ID = tDID.DRUG_1_ID OR d1.GENERIC_ID = tDID.DRUG_1_ID                     JOIN DRUG d2 ON                     CASE WHEN d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID                     THEN d2.ID = tDID.DRUG_1_ID OR d2.GENERIC_ID = tDID.DRUG_1_ID                     ELSE d2.ID = tDID.DRUG_0_ID OR d2.GENERIC_ID = tDID.DRUG_0_ID                     END                     WHERE                     tDID.DRUG_0_ID IN (" + join + ")                     AND                     tDID.DRUG_1_ID IN (" + join + ")                     AND                     DRUG_0_ID <> DRUG_1_ID                     AND                     d1.ID IN (" + join + ")                     AND                     d2.ID IN (" + join + ")                     ORDER BY CATEGORY_ID, d1.name, d2.name                     )", this.Z4, true);
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it2 = X.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            arrayList.add(next.getString("DDI_ID"));
            String string = next.getString("DRUG_0_ID");
            String string2 = next.getString("DRUG_1_ID");
            String string3 = next.getString("GROUP_0_ID");
            String string4 = next.getString("GROUP_1_ID");
            String str2 = string3 + "-" + string4;
            if (!this.b5.containsKey(str2)) {
                this.b5.putString(str2, string + "-" + string2);
            }
            String str3 = string4 + "-" + string3;
            if (!this.b5.containsKey(str3)) {
                this.b5.putString(str3, string + "-" + string2);
            }
        }
        ArrayList<Bundle> X2 = this.Q4.X(this.D4, "Select * from DDI where id in (" + StringUtils.join((Iterable<?>) arrayList, ",") + ") order by category_id", this.Z4, true);
        this.e5 = X2;
        if (X2.size() == 0) {
            str = "No Interaction Found";
        } else {
            str = "Found " + this.e5.size() + " Interactions";
        }
        this.F4 = str;
        this.f5 = this.Q4.r2(this.e5, "CATEGORY_ID");
        AnonymousClass1 r2 = new NotStickySectionAdapter(r(), this.f5, "title", R.layout.f1346list_view_item_ripple_text_full) {
            public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                Bundle bundle2 = EPOInteractResultActivityFragment.this.b5;
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle2.getString(bundle.getString("GROUP_1_ID") + "-" + bundle.getString("GROUP_0_ID")), "-");
                int i3 = 0;
                String string = EPOInteractResultActivityFragment.this.a5.getString(splitByWholeSeparator[0]);
                String string2 = EPOInteractResultActivityFragment.this.a5.getString(splitByWholeSeparator[1]);
                rippleTextFullViewHolder.I.setText(string);
                rippleTextFullViewHolder.J.setText(string2);
                String string3 = bundle.getString("CATEGORY_ID");
                if (string3.equals(IcyHeaders.a3)) {
                    i3 = R.drawable.fb;
                } else if (string3.equals(ExifInterface.Y4)) {
                    i3 = R.drawable.G3;
                } else if (string3.equals(ExifInterface.Z4)) {
                    i3 = R.drawable.U2;
                } else if (string3.equals("4")) {
                    i3 = R.drawable.S1;
                } else if (string3.equals("5")) {
                    i3 = R.drawable.B0;
                }
                rippleTextFullViewHolder.K.setImageDrawable(EPOInteractResultActivityFragment.this.b0().getDrawable(i3));
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOInteractResultActivityFragment ePOInteractResultActivityFragment = EPOInteractResultActivityFragment.this;
                        CompressHelper compressHelper = ePOInteractResultActivityFragment.Q4;
                        Bundle bundle = ePOInteractResultActivityFragment.D4;
                        compressHelper.A1(bundle, "interactview-" + bundle.getString("ID"), (String[]) null, (String) null);
                    }
                });
            }

            public String i0(String str) {
                if (str.equals("5")) {
                    return "Caution Advised";
                }
                if (str.equals("4")) {
                    return "Therapeutic Advantage";
                }
                if (str.equals(ExifInterface.Z4)) {
                    return "Monitor / Modify Tx";
                }
                if (str.equals(ExifInterface.Y4)) {
                    return "Avoid / Use Alternative";
                }
                return str.equals(IcyHeaders.a3) ? "Contraindicated" : str;
            }

            public RecyclerView.ViewHolder k0(View view) {
                return new RippleTextFullViewHolder(view);
            }
        };
        this.d5 = r2;
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
