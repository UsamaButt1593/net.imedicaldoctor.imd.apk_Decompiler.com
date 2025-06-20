package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextImageViewHolder;

public class EPOPillResultActivityFragment extends ViewerHelperFragment {
    public ArrayList<Bundle> X4;
    public RecyclerView Y4;
    public ArrayList<Bundle> Z4;
    public ChaptersAdapter a5;

    /* access modifiers changed from: private */
    public void K4(int i2) {
        ArrayList<Bundle> arrayList = this.Z4;
        if (arrayList == null || arrayList.size() == 0) {
            CompressHelper.x2(r(), "There is no images in this document", 1);
            return;
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", this.Z4);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public void J4() {
        this.Y4.setItemAnimator(new DefaultItemAnimator());
        this.Y4.setItemDecoration(new CustomItemDecoration(r()));
        this.Y4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.Y4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        String string = y().getString("Query");
        CompressHelper compressHelper = this.Q4;
        Bundle bundle2 = this.D4;
        this.X4 = compressHelper.X(bundle2, "select drug.name as drugName, genericname_strings.string_text as genericName, formulation_strings.string_text,pill_pictures.filename from (( pill_pictures inner join genericname_strings on genericname_strings.id=pill_pictures.genericname_string_id) inner join drug on drug.id=pill_pictures.drug_id) inner join formulation_strings on formulation_strings.id=pill_pictures.formulation_string_id where " + string + " order by drugName collate nocase asc", "RX.sqlite", true);
        this.F4 = "Found " + this.X4.size() + " Drugs";
        this.Z4 = new ArrayList<>();
        Iterator<Bundle> it2 = this.X4.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            Bundle bundle3 = new Bundle();
            bundle3.putString("ImagePath", "http://www.epocrates.com/pillimages/" + next.getString("FILENAME") + ".jpg");
            bundle3.putString("DescriptionHTML", "<font color=\"#000099\"><b>" + next.getString("drugName") + "</b></font><br/>" + next.getString("genericName") + "<br/>" + next.getString("STRING_TEXT"));
            this.Z4.add(bundle3);
        }
        AnonymousClass1 r2 = new ChaptersAdapter(r(), this.X4, "", R.layout.f1332list_view_item_pill_image) {
            public void e0(RecyclerView.ViewHolder viewHolder, Bundle bundle, final int i2) {
                RippleTextImageViewHolder rippleTextImageViewHolder = (RippleTextImageViewHolder) viewHolder;
                Bundle bundle2 = EPOPillResultActivityFragment.this.X4.get(i2);
                rippleTextImageViewHolder.I.setText(Html.fromHtml("<font color=\"#000099\"><b>" + bundle2.getString("drugName") + "</b></font><br/>" + bundle2.getString("genericName") + "<br/>" + bundle2.getString("STRING_TEXT")));
                RequestManager G = Glide.G(EPOPillResultActivityFragment.this.r());
                StringBuilder sb = new StringBuilder();
                sb.append("http://www.epocrates.com/pillimages/");
                sb.append(bundle2.getString("FILENAME"));
                sb.append("_thumb.jpg");
                G.t(sb.toString()).B2(rippleTextImageViewHolder.J);
                rippleTextImageViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOPillResultActivityFragment.this.K4(i2);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new RippleTextImageViewHolder(view);
            }
        };
        this.a5 = r2;
        this.Y4.setAdapter(r2);
        J4();
        f3(R.menu.f1412empty);
        o2(false);
        G3();
        return this.C4;
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.X4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.X4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }
}
