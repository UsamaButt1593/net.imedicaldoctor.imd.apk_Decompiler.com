package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.text.Annotation;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullDeleteViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;

public class EPOInteractActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public ArrayList<Bundle> B4;
    public Button C4;
    public String D4;
    public ArrayList<String> E4;
    public ArrayList<Bundle> F4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1227fragment_epointeract, viewGroup, false);
        this.B4 = new ArrayList<>();
        this.E4 = new ArrayList<>();
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.D4 = "RX.sqlite";
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        appBarLayout.D(false, false);
        appBarLayout.postDelayed(new Runnable() {
            public void run() {
                relativeLayout.setVisibility(0);
            }
        }, 800);
        Button button = (Button) this.q4.findViewById(R.id.f1060result_button);
        this.C4 = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EPOInteractActivityFragment.this.B4.size() > 0) {
                    new Bundle().putParcelableArrayList("Items", EPOInteractActivityFragment.this.B4);
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it2 = EPOInteractActivityFragment.this.B4.iterator();
                    while (it2.hasNext()) {
                        Bundle next = it2.next();
                        String string = next.getString("text");
                        String j3 = EPOInteractActivityFragment.this.j3(next.getString("contentId"));
                        arrayList.add(j3 + ",,,,," + string);
                    }
                    EPOInteractActivityFragment ePOInteractActivityFragment = EPOInteractActivityFragment.this;
                    CompressHelper compressHelper = ePOInteractActivityFragment.k4;
                    Bundle bundle = ePOInteractActivityFragment.h4;
                    compressHelper.A1(bundle, "interactresult-" + StringUtil.g(arrayList, ";;;;;"), (String[]) null, (String) null);
                }
            }
        });
        AnonymousClass3 r2 = new ChaptersAdapter(r(), this.B4, "title", R.layout.f1347list_view_item_ripple_text_full_delete) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullDeleteViewHolder rippleTextFullDeleteViewHolder = (RippleTextFullDeleteViewHolder) viewHolder;
                rippleTextFullDeleteViewHolder.I.setText(bundle.getString("text"));
                rippleTextFullDeleteViewHolder.J.setText(bundle.getString(Annotation.i3));
                rippleTextFullDeleteViewHolder.N.setVisibility(0);
                rippleTextFullDeleteViewHolder.L.setVisibility(0);
                if (bundle.getString(Annotation.i3).length() == 0) {
                    rippleTextFullDeleteViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullDeleteViewHolder.J.setVisibility(0);
                }
                String string = bundle.getString("type");
                rippleTextFullDeleteViewHolder.K.setImageDrawable(EPOInteractActivityFragment.this.r().getResources().getDrawable(string.equals("7") ? R.drawable.p9 : string.equals("6") ? R.drawable.A9 : R.drawable.D9));
                final String j3 = EPOInteractActivityFragment.this.j3(bundle.getString("contentId"));
                rippleTextFullDeleteViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOInteractActivityFragment.this.V2();
                        EPOInteractActivityFragment ePOInteractActivityFragment = EPOInteractActivityFragment.this;
                        CompressHelper compressHelper = ePOInteractActivityFragment.k4;
                        Bundle bundle = ePOInteractActivityFragment.h4;
                        compressHelper.A1(bundle, "interact-" + j3, (String[]) null, (String) null);
                    }
                });
                rippleTextFullDeleteViewHolder.N.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOInteractActivityFragment.this.B4.remove(bundle);
                        EPOInteractActivityFragment.this.E4.remove(j3);
                        EPOInteractActivityFragment ePOInteractActivityFragment = EPOInteractActivityFragment.this;
                        ((ChaptersAdapter) ePOInteractActivityFragment.l4).g0(ePOInteractActivityFragment.B4);
                        EPOInteractActivityFragment.this.i3();
                        EPOInteractActivityFragment.this.l4.G();
                        EPOInteractActivityFragment ePOInteractActivityFragment2 = EPOInteractActivityFragment.this;
                        ePOInteractActivityFragment2.w4.setAdapter(ePOInteractActivityFragment2.l4);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new RippleTextFullDeleteViewHolder(view);
            }
        };
        this.l4 = r2;
        r2.f30463h = "Search To Add Drug";
        this.A4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("text"));
                rippleTextFullViewHolder.J.setText(bundle.getString(Annotation.i3));
                rippleTextFullViewHolder.L.setVisibility(8);
                if (bundle.getString(Annotation.i3).length() == 0) {
                    rippleTextFullViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.J.setVisibility(0);
                }
                String string = bundle.getString("type");
                rippleTextFullViewHolder.K.setImageDrawable(EPOInteractActivityFragment.this.r().getResources().getDrawable(string.equals("7") ? R.drawable.p9 : string.equals("6") ? R.drawable.A9 : R.drawable.D9));
                final String j3 = EPOInteractActivityFragment.this.j3(bundle.getString("contentId"));
                if (EPOInteractActivityFragment.this.E4.contains(j3)) {
                    rippleTextFullViewHolder.I.setTextColor(Color.rgb(TsExtractor.L, TsExtractor.L, TsExtractor.L));
                    return;
                }
                rippleTextFullViewHolder.I.setTextColor(Color.rgb(0, 0, 0));
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        EPOInteractActivityFragment.this.V2();
                        EPOInteractActivityFragment.this.B4.add(bundle);
                        EPOInteractActivityFragment.this.E4.add(j3);
                        EPOInteractActivityFragment.this.i3();
                        EPOInteractActivityFragment.this.s4.k0("", false);
                        EPOInteractActivityFragment ePOInteractActivityFragment = EPOInteractActivityFragment.this;
                        ((ChaptersAdapter) ePOInteractActivityFragment.l4).g0(ePOInteractActivityFragment.B4);
                        EPOInteractActivityFragment.this.l4.G();
                        EPOInteractActivityFragment ePOInteractActivityFragment2 = EPOInteractActivityFragment.this;
                        ePOInteractActivityFragment2.w4.setAdapter(ePOInteractActivityFragment2.l4);
                    }
                });
            }

            public void h0(Bundle bundle) {
                EPOInteractActivityFragment.this.V2();
                EPOInteractActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                return new RippleTextFullViewHolder(view);
            }
        };
        this.w4.setAdapter(this.l4);
        N2();
        o2(false);
        return this.q4;
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match '(text:" + str + "* OR content:" + str + "*) AND typeText:RX NOT (type:5)'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f666interaction_check_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Drug Interactions";
    }

    public void i3() {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                EPOInteractActivityFragment.this.F4 = new ArrayList<>();
                ArrayList<String> arrayList = EPOInteractActivityFragment.this.E4;
                if (arrayList != null && arrayList.size() > 0) {
                    String join = StringUtils.join((Iterable<?>) EPOInteractActivityFragment.this.E4, ",");
                    EPOInteractActivityFragment ePOInteractActivityFragment = EPOInteractActivityFragment.this;
                    CompressHelper compressHelper = ePOInteractActivityFragment.k4;
                    Bundle bundle = ePOInteractActivityFragment.h4;
                    ePOInteractActivityFragment.F4 = compressHelper.X(bundle, "SELECT                     ID,                     DRUG_ID AS DRUG_0_ID,                     INTERACTING_DRUG_ID AS DRUG_1_ID,                     DDI_ID,                     GROUP_0_ID,                     GROUP_1_ID                     FROM (                     SELECT DISTINCT                     tDID.ID,                     MIN(d1.ID, d2.ID) AS DRUG_ID,                     MAX(d1.ID, d2.ID) AS INTERACTING_DRUG_ID,                     tDID.DDI_ID,                     DDI.GROUP_0_ID,                     DDI.GROUP_1_ID                     FROM                     DRUG_TO_INTERACTING_DRUG tDID                     JOIN DDI ON tDID.DDI_ID = DDI.ID                     JOIN DRUG d1 ON d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID OR d1.ID = tDID.DRUG_1_ID OR d1.GENERIC_ID = tDID.DRUG_1_ID                     JOIN DRUG d2 ON                     CASE WHEN d1.ID = tDID.DRUG_0_ID OR d1.GENERIC_ID = tDID.DRUG_0_ID                     THEN d2.ID = tDID.DRUG_1_ID OR d2.GENERIC_ID = tDID.DRUG_1_ID                     ELSE d2.ID = tDID.DRUG_0_ID OR d2.GENERIC_ID = tDID.DRUG_0_ID                     END                     WHERE                     tDID.DRUG_0_ID IN (" + join + ")                     AND                     tDID.DRUG_1_ID IN (" + join + ")                     AND                     DRUG_0_ID <> DRUG_1_ID                     AND                     d1.ID IN (" + join + ")                     AND                     d2.ID IN (" + join + ")                     ORDER BY CATEGORY_ID, d1.name, d2.name                     ) ", EPOInteractActivityFragment.this.D4, true);
                }
                observableEmitter.onNext("asdf");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                if (EPOInteractActivityFragment.this.F4.size() == 0) {
                    EPOInteractActivityFragment.this.C4.setEnabled(false);
                    EPOInteractActivityFragment.this.C4.setBackgroundColor(Color.rgb(100, 100, 100));
                    EPOInteractActivityFragment.this.C4.setText("Nothing Found");
                    return;
                }
                Button button = EPOInteractActivityFragment.this.C4;
                button.setText(EPOInteractActivityFragment.this.F4.size() + " Interactions Found");
                EPOInteractActivityFragment.this.C4.setEnabled(true);
                EPOInteractActivityFragment.this.C4.setBackgroundColor(Color.rgb(64, 140, 83));
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
            }
        });
    }

    public String j3(String str) {
        return str.contains("-") ? str.split("-")[1] : str;
    }
}
