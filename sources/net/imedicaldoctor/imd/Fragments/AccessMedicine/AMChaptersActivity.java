package net.imedicaldoctor.imd.Fragments.AccessMedicine;

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
import net.imedicaldoctor.imd.iMDActivity;

public class AMChaptersActivity extends iMDActivity {

    public static class AMChaptersFragment extends SearchHelperFragment {
        private CursorAdapter A4;
        private CursorAdapter B4;
        private String C4;

        public class AMChaptersAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29615d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29616e;

            /* renamed from: f  reason: collision with root package name */
            public String f29617f;

            public AMChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
                this.f29615d = context;
                this.f29616e = arrayList;
                this.f29617f = str;
            }

            public int C(int i2) {
                return this.f29616e.get(i2).getString("leaf").equals(IcyHeaders.a3) ? 0 : 1;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                final Bundle bundle = this.f29616e.get(i2);
                rippleTextViewHolder.I.setText(bundle.getString(this.f29617f));
                rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AMChaptersAdapter.this.d0(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29615d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
                }
                if (i2 == 1) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29615d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                }
                return null;
            }

            public int b() {
                return this.f29616e.size();
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
                    AMChaptersFragment.this.V2();
                    String string = bundle.getString("leaf");
                    String string2 = bundle.getString("docId");
                    if (string.equals(IcyHeaders.a3)) {
                        AMChaptersFragment aMChaptersFragment = AMChaptersFragment.this;
                        aMChaptersFragment.k4.A1(aMChaptersFragment.h4, string2, (String[]) null, (String) null);
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", AMChaptersFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("id"));
                    AMChaptersFragment.this.k4.N(AMChaptersActivity.class, AMChaptersFragment.class, bundle2);
                }
            };
            this.m4 = new ContentSearchAdapter(r(), this.o4, "text", "subText") {
                public void e0(Bundle bundle, int i2) {
                    Bundle n1;
                    AMChaptersFragment.this.V2();
                    String string = bundle.getString("type");
                    String string2 = bundle.getString("contentId");
                    if (string.equals("0")) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putBundle("DB", AMChaptersFragment.this.h4);
                        bundle2.putString("ParentId", string2);
                        AMChaptersFragment.this.k4.N(AMChaptersActivity.class, AMChaptersFragment.class, bundle2);
                    } else if (string.equals(IcyHeaders.a3)) {
                        AMChaptersFragment aMChaptersFragment = AMChaptersFragment.this;
                        aMChaptersFragment.k4.A1(aMChaptersFragment.h4, string2, (String[]) null, (String) null);
                    } else {
                        if (string.equals(ExifInterface.Y4)) {
                            AMChaptersFragment aMChaptersFragment2 = AMChaptersFragment.this;
                            CompressHelper compressHelper = aMChaptersFragment2.k4;
                            Bundle bundle3 = aMChaptersFragment2.h4;
                            n1 = compressHelper.n1(compressHelper.V(bundle3, "select * from videos where id=" + string2));
                            if (n1 == null) {
                                return;
                            }
                        } else if (string.equals(ExifInterface.Z4)) {
                            AMChaptersFragment aMChaptersFragment3 = AMChaptersFragment.this;
                            CompressHelper compressHelper2 = aMChaptersFragment3.k4;
                            Bundle bundle4 = aMChaptersFragment3.h4;
                            n1 = compressHelper2.n1(compressHelper2.V(bundle4, "select * from images where id=" + string2));
                            if (n1 == null) {
                                return;
                            }
                        } else if (string.equals("4")) {
                            AMChaptersFragment aMChaptersFragment4 = AMChaptersFragment.this;
                            CompressHelper compressHelper3 = aMChaptersFragment4.k4;
                            Bundle bundle5 = aMChaptersFragment4.h4;
                            n1 = compressHelper3.n1(compressHelper3.V(bundle5, "select * from tables where id=" + string2));
                            if (n1 == null) {
                                return;
                            }
                        } else if (string.equals("5")) {
                            AMChaptersFragment aMChaptersFragment5 = AMChaptersFragment.this;
                            aMChaptersFragment5.k4.A1(aMChaptersFragment5.h4, string2, aMChaptersFragment5.T2(bundle.getString("subText")), (String) null);
                            return;
                        } else {
                            return;
                        }
                        String string3 = n1.getString("sectionId");
                        String string4 = n1.getString("goto");
                        AMChaptersFragment aMChaptersFragment6 = AMChaptersFragment.this;
                        aMChaptersFragment6.k4.A1(aMChaptersFragment6.h4, string3, (String[]) null, string4);
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new AMChaptersFragment());
    }
}
