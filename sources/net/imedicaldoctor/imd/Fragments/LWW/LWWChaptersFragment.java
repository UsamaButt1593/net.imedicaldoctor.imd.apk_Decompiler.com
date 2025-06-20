package net.imedicaldoctor.imd.Fragments.LWW;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;

public class LWWChaptersFragment extends SearchHelperFragment {
    private CursorAdapter A4;
    private CursorAdapter B4;
    private String C4;

    public class AMChaptersAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public Context f29782d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<Bundle> f29783e;

        /* renamed from: f  reason: collision with root package name */
        public String f29784f;

        public AMChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
            this.f29782d = context;
            this.f29783e = arrayList;
            this.f29784f = str;
        }

        public int C(int i2) {
            return this.f29783e.get(i2).getString("leaf").equals(IcyHeaders.a3) ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
            final Bundle bundle = this.f29783e.get(i2);
            rippleTextViewHolder.I.setText(bundle.getString(this.f29784f));
            rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AMChaptersAdapter.this.d0(bundle, i2);
                }
            });
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29782d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
            }
            if (i2 == 1) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29782d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return this.f29783e.size();
        }

        public void d0(Bundle bundle, int i2) {
        }
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1494search, menu);
        this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        O2();
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        this.q4 = inflate;
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        O2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        if (y() == null || !y().containsKey("ParentId")) {
            appBarLayout.D(true, false);
            relativeLayout.setVisibility(0);
            str = null;
        } else {
            if (y().getString("ParentId").equals("0")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
            } else {
                appBarLayout.D(false, false);
                appBarLayout.postDelayed(new Runnable() {
                    public void run() {
                        relativeLayout.setVisibility(0);
                    }
                }, 800);
            }
            str = y().getString("ParentId");
        }
        this.C4 = str;
        CompressHelper compressHelper = this.k4;
        Bundle bundle2 = this.h4;
        ArrayList<Bundle> V = compressHelper.V(bundle2, "Select id as _id,* from toc where parentId = " + this.C4);
        this.n4 = V;
        if (V == null) {
            this.n4 = new ArrayList<>();
        }
        this.l4 = new AMChaptersAdapter(r(), this.n4, "name") {
            public void d0(Bundle bundle, int i2) {
                LWWChaptersFragment.this.V2();
                String string = bundle.getString("leaf");
                String string2 = bundle.getString("docId");
                if (string.equals(IcyHeaders.a3)) {
                    LWWChaptersFragment lWWChaptersFragment = LWWChaptersFragment.this;
                    lWWChaptersFragment.k4.A1(lWWChaptersFragment.h4, string2, (String[]) null, (String) null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("DB", LWWChaptersFragment.this.h4);
                bundle2.putString("ParentId", bundle.getString("id"));
                LWWChaptersFragment.this.k4.N(LWWChapters.class, LWWChaptersFragment.class, bundle2);
            }
        };
        this.m4 = new ContentSearchAdapter(r(), this.o4, "text", "subText") {
            public void e0(Bundle bundle, int i2) {
                LWWChaptersFragment.this.V2();
                String string = bundle.getString("type");
                String string2 = bundle.getString("contentId");
                if (string.equals("0")) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", LWWChaptersFragment.this.h4);
                    bundle2.putString("ParentId", string2);
                    LWWChaptersFragment.this.k4.N(LWWChapters.class, LWWChaptersFragment.class, bundle2);
                } else if (string.equals(IcyHeaders.a3) || string.equals(ExifInterface.Y4) || string.equals(ExifInterface.Z4) || string.equals("4")) {
                    LWWChaptersFragment lWWChaptersFragment = LWWChaptersFragment.this;
                    lWWChaptersFragment.k4.A1(lWWChaptersFragment.h4, string2, (String[]) null, (String) null);
                } else if (string.equals("5")) {
                    LWWChaptersFragment lWWChaptersFragment2 = LWWChaptersFragment.this;
                    lWWChaptersFragment2.k4.A1(lWWChaptersFragment2.h4, string2, lWWChaptersFragment2.T2(bundle.getString("subText")), (String) null);
                }
            }
        };
        this.w4.setAdapter(this.l4);
        N2();
        o2(false);
        return inflate;
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id, Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }
}
