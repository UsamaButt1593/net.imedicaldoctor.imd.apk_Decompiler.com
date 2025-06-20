package net.imedicaldoctor.imd.Fragments.Micromedex;

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

public class MMIVSelectActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public ArrayList<Bundle> B4;
    public Button C4;
    public ArrayList<String> D4;
    public ArrayList<Bundle> E4;

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1227fragment_epointeract, viewGroup, false);
        this.B4 = new ArrayList<>();
        this.D4 = new ArrayList<>();
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
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
        button.setText("Please Add Drug");
        this.C4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MMIVSelectActivityFragment.this.B4.size() > 0) {
                    new Bundle().putParcelableArrayList("Items", MMIVSelectActivityFragment.this.B4);
                    ArrayList arrayList = new ArrayList();
                    Iterator<Bundle> it2 = MMIVSelectActivityFragment.this.B4.iterator();
                    while (it2.hasNext()) {
                        Bundle next = it2.next();
                        String string = next.getString("text");
                        String j3 = MMIVSelectActivityFragment.this.j3(next.getString("contentId"));
                        arrayList.add(j3 + ",,,,," + string + ",,,,," + next.getString("typeText"));
                    }
                    new Bundle();
                    MMIVSelectActivityFragment mMIVSelectActivityFragment = MMIVSelectActivityFragment.this;
                    CompressHelper compressHelper = mMIVSelectActivityFragment.k4;
                    Bundle bundle = mMIVSelectActivityFragment.h4;
                    compressHelper.A1(bundle, "interactresult-" + StringUtils.join((Iterable<?>) arrayList, ";;;;;"), (String[]) null, (String) null);
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
                final String j3 = MMIVSelectActivityFragment.this.j3(bundle.getString("contentId"));
                rippleTextFullDeleteViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MMIVSelectActivityFragment.this.V2();
                        ArrayList arrayList = new ArrayList();
                        String string = bundle.getString("text");
                        String j3 = MMIVSelectActivityFragment.this.j3(bundle.getString("contentId"));
                        arrayList.add(j3 + ",,,,," + string + ",,,,," + bundle.getString("typeText"));
                        new Bundle();
                        MMIVSelectActivityFragment mMIVSelectActivityFragment = MMIVSelectActivityFragment.this;
                        CompressHelper compressHelper = mMIVSelectActivityFragment.k4;
                        Bundle bundle = mMIVSelectActivityFragment.h4;
                        compressHelper.A1(bundle, "interactresult-" + StringUtils.join((Iterable<?>) arrayList, ";;;;;"), (String[]) null, (String) null);
                    }
                });
                rippleTextFullDeleteViewHolder.N.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MMIVSelectActivityFragment.this.B4.remove(bundle);
                        MMIVSelectActivityFragment.this.D4.remove(j3);
                        MMIVSelectActivityFragment mMIVSelectActivityFragment = MMIVSelectActivityFragment.this;
                        ((ChaptersAdapter) mMIVSelectActivityFragment.l4).g0(mMIVSelectActivityFragment.B4);
                        MMIVSelectActivityFragment.this.i3();
                        MMIVSelectActivityFragment.this.l4.G();
                        MMIVSelectActivityFragment mMIVSelectActivityFragment2 = MMIVSelectActivityFragment.this;
                        mMIVSelectActivityFragment2.w4.setAdapter(mMIVSelectActivityFragment2.l4);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                RippleTextFullDeleteViewHolder rippleTextFullDeleteViewHolder = new RippleTextFullDeleteViewHolder(view);
                rippleTextFullDeleteViewHolder.K.setVisibility(8);
                return rippleTextFullDeleteViewHolder;
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
                final String j3 = MMIVSelectActivityFragment.this.j3(bundle.getString("contentId"));
                if (MMIVSelectActivityFragment.this.D4.contains(j3)) {
                    rippleTextFullViewHolder.I.setTextColor(Color.rgb(TsExtractor.L, TsExtractor.L, TsExtractor.L));
                    return;
                }
                rippleTextFullViewHolder.I.setTextColor(Color.rgb(0, 0, 0));
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MMIVSelectActivityFragment.this.V2();
                        MMIVSelectActivityFragment.this.B4.add(bundle);
                        MMIVSelectActivityFragment.this.D4.add(j3);
                        MMIVSelectActivityFragment.this.i3();
                        MMIVSelectActivityFragment.this.s4.k0("", false);
                        MMIVSelectActivityFragment mMIVSelectActivityFragment = MMIVSelectActivityFragment.this;
                        ((ChaptersAdapter) mMIVSelectActivityFragment.l4).g0(mMIVSelectActivityFragment.B4);
                        MMIVSelectActivityFragment.this.l4.G();
                        MMIVSelectActivityFragment mMIVSelectActivityFragment2 = MMIVSelectActivityFragment.this;
                        mMIVSelectActivityFragment2.w4.setAdapter(mMIVSelectActivityFragment2.l4);
                    }
                });
            }

            public void h0(Bundle bundle) {
                MMIVSelectActivityFragment.this.V2();
                MMIVSelectActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                rippleTextFullViewHolder.K.setVisibility(8);
                return rippleTextFullViewHolder;
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
        return compressHelper.W(bundle, "Select * from search where search match 'text:" + str + "* NOT (type:5)'", "fsearch.sqlite");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.W(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'", "fsearch.sqlite");
    }

    public void i3() {
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                observableEmitter.onNext("asdf");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                ArrayList<Bundle> arrayList = MMIVSelectActivityFragment.this.B4;
                if (arrayList == null || arrayList.size() == 0) {
                    MMIVSelectActivityFragment.this.C4.setEnabled(false);
                    MMIVSelectActivityFragment.this.C4.setBackgroundColor(Color.rgb(100, 100, 100));
                    MMIVSelectActivityFragment.this.C4.setText("Please Add Drug");
                    return;
                }
                MMIVSelectActivityFragment.this.C4.setText("Check Compatibility");
                MMIVSelectActivityFragment.this.C4.setEnabled(true);
                MMIVSelectActivityFragment.this.C4.setBackgroundColor(Color.rgb(64, 140, 83));
            }
        });
    }

    public String j3(String str) {
        return str.contains("-") ? str.split("-")[1] : str;
    }
}
