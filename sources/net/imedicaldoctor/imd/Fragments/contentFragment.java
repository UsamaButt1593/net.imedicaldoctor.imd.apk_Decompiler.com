package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.timehop.stickyheadersrecyclerview.ItemVisibilityAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class contentFragment extends SearchHelperFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> A4;
    private SearchAdapter B4;
    /* access modifiers changed from: private */
    public ProgressBar C4;
    /* access modifiers changed from: private */
    public MenuItem D4;
    private AsyncTask E4;
    private boolean F4;
    /* access modifiers changed from: private */
    public String G4;
    /* access modifiers changed from: private */
    public Observable<Bundle> H4;
    /* access modifiers changed from: private */
    public DisposableObserver<Bundle> I4;
    /* access modifiers changed from: private */
    public StickyRecyclerHeadersDecoration J4;
    /* access modifiers changed from: private */
    public ArrayList<String> K4;
    StickyRecyclerHeadersTouchListener L4;
    private LinearLayoutManager M4;
    /* access modifiers changed from: private */
    public RecyclerView N4;
    private boolean O4;
    public CompressHelper P4;

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    public class SearchAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter {

        /* renamed from: d  reason: collision with root package name */
        private final Context f30095d;

        public SearchAdapter(Context context) {
            this.f30095d = context;
        }

        public int C(int i2) {
            contentFragment contentfragment = contentFragment.this;
            return contentfragment.j3(i2, contentfragment.A4).containsKey("Item") ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            if (viewHolder.F() != 1) {
                SearchItemViewHolder searchItemViewHolder = (SearchItemViewHolder) viewHolder;
                contentFragment contentfragment = contentFragment.this;
                Bundle bundle = contentfragment.j3(i2, contentfragment.A4).getBundle("Item");
                searchItemViewHolder.I.setText(bundle.getString("text"));
                if (!bundle.containsKey("subText") || bundle.getString("subText").length() != 0) {
                    searchItemViewHolder.J.setVisibility(0);
                    searchItemViewHolder.J.setText(Html.fromHtml(bundle.getString("subText")));
                } else {
                    searchItemViewHolder.J.setText((CharSequence) null);
                    searchItemViewHolder.J.setVisibility(8);
                }
                searchItemViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String string;
                        String str;
                        Bundle n1;
                        String string2;
                        CompressHelper compressHelper;
                        Bundle bundle;
                        String str2;
                        String str3;
                        StringBuilder sb;
                        String str4;
                        String str5;
                        CompressHelper compressHelper2;
                        Bundle bundle2;
                        StringBuilder sb2;
                        String str6;
                        String string3;
                        CompressHelper compressHelper3;
                        Bundle bundle3;
                        StringBuilder sb3;
                        String string4;
                        Bundle n12;
                        contentFragment contentfragment = contentFragment.this;
                        Bundle j3 = contentfragment.j3(i2, contentfragment.A4);
                        if (j3 != null) {
                            Bundle bundle4 = j3.getBundle("Database");
                            Bundle bundle5 = j3.getBundle("Item");
                            String string5 = bundle4.getString("Type");
                            String string6 = bundle5.getString("id");
                            contentFragment contentfragment2 = contentFragment.this;
                            contentfragment2.h4 = bundle4;
                            String[] T2 = contentfragment2.T2(bundle5.getString("subText"));
                            if (string5.equals("lexi")) {
                                contentFragment.this.P4.A1(bundle4, string6, T2, (String) null);
                            } else if (!string5.equals("skyscape")) {
                                if (!string5.equals("medhand")) {
                                    if (string5.equals("visualdx")) {
                                        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(string6, "-");
                                        Bundle bundle6 = new Bundle();
                                        bundle6.putInt("defaultModule", Integer.valueOf(splitByWholeSeparator[1]).intValue());
                                        contentFragment.this.P4.B1(bundle4, splitByWholeSeparator[0], T2, (String) null, bundle6);
                                        return;
                                    } else if (!string5.equals("uptodate")) {
                                        if (string5.equals("accessmedicine")) {
                                            String string7 = bundle5.getString("type");
                                            string = bundle5.getString("contentId");
                                            if (string7.equals(ExifInterface.Y4)) {
                                                CompressHelper compressHelper4 = contentFragment.this.P4;
                                                n1 = compressHelper4.n1(compressHelper4.V(bundle4, "select * from videos where id=" + string));
                                                if (n1 == null) {
                                                    return;
                                                }
                                            } else if (string7.equals(ExifInterface.Z4)) {
                                                CompressHelper compressHelper5 = contentFragment.this.P4;
                                                n1 = compressHelper5.n1(compressHelper5.V(bundle4, "select * from images where id=" + string));
                                                if (n1 == null) {
                                                    return;
                                                }
                                            } else if (string7.equals("4")) {
                                                CompressHelper compressHelper6 = contentFragment.this.P4;
                                                n1 = compressHelper6.n1(compressHelper6.V(bundle4, "select * from tables where id=" + string));
                                                if (n1 == null) {
                                                    return;
                                                }
                                            } else {
                                                str = null;
                                                if (!string7.equals("5")) {
                                                    return;
                                                }
                                                contentFragment.this.P4.A1(bundle4, string, T2, str);
                                                return;
                                            }
                                            string2 = n1.getString("sectionId");
                                        } else {
                                            if (string5.equals("lww")) {
                                                String string8 = bundle5.getString("type");
                                                string4 = bundle5.getString("contentId");
                                                if (string8.equals(ExifInterface.Y4) || string8.equals(ExifInterface.Z4) || string8.equals("4")) {
                                                    contentFragment.this.P4.A1(bundle4, string4, (String[]) null, (String) null);
                                                    return;
                                                } else if (!string8.equals("5")) {
                                                    return;
                                                }
                                            } else {
                                                String str7 = "sectionId";
                                                if (string5.equals("elsevier") || string5.equals("elseviernew")) {
                                                    String string9 = bundle5.getString("type");
                                                    string = bundle5.getString("contentId");
                                                    if (string9.equals(ExifInterface.Z4)) {
                                                        CompressHelper compressHelper7 = contentFragment.this.P4;
                                                        n1 = compressHelper7.s1(compressHelper7.V(bundle4, "select * from images where id='" + string + "'"));
                                                        if (n1 != null) {
                                                            string2 = n1.getString("docId");
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (string9.equals("4")) {
                                                        CompressHelper compressHelper8 = contentFragment.this.P4;
                                                        n1 = compressHelper8.n1(compressHelper8.V(bundle4, "select * from tables where id=" + string));
                                                        if (n1 != null) {
                                                            string2 = n1.getString(str7);
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        str = null;
                                                        if (!string9.equals("5")) {
                                                            return;
                                                        }
                                                        contentFragment.this.P4.A1(bundle4, string, T2, str);
                                                        return;
                                                    }
                                                } else if (string5.equals("ovid")) {
                                                    String string10 = bundle5.getString("type");
                                                    string = bundle5.getString("contentId");
                                                    if (!string10.equals(ExifInterface.Y4)) {
                                                        if (string10.equals(ExifInterface.Z4)) {
                                                            CompressHelper compressHelper9 = contentFragment.this.P4;
                                                            n12 = compressHelper9.n1(compressHelper9.V(bundle4, "select * from images where imagename='" + string + "'"));
                                                            if (n12 == null) {
                                                                return;
                                                            }
                                                        } else if (string10.equals("4")) {
                                                            CompressHelper compressHelper10 = contentFragment.this.P4;
                                                            n12 = compressHelper10.n1(compressHelper10.V(bundle4, "select * from tables where id=" + string));
                                                            if (n12 == null) {
                                                                return;
                                                            }
                                                        } else {
                                                            str = null;
                                                            if (!string10.equals("5")) {
                                                                return;
                                                            }
                                                            contentFragment.this.P4.A1(bundle4, string, T2, str);
                                                            return;
                                                        }
                                                        string2 = n1.getString("bookId");
                                                    } else {
                                                        return;
                                                    }
                                                } else if (string5.equals("epub")) {
                                                    String string11 = bundle5.getString("type");
                                                    string4 = bundle5.getString("contentId");
                                                    if (!string11.equals("5")) {
                                                        return;
                                                    }
                                                } else if (string5.equals("nejm")) {
                                                    String string12 = bundle5.getString("type");
                                                    string4 = bundle5.getString("contentId");
                                                    if (!string12.equals("5")) {
                                                        return;
                                                    }
                                                } else {
                                                    if (string5.equals("epocrate")) {
                                                        String string13 = bundle5.getString("typeText");
                                                        str4 = bundle5.getString("contentId");
                                                        if (string13.equals("Dx")) {
                                                            contentFragment contentfragment3 = contentFragment.this;
                                                            compressHelper = contentfragment3.P4;
                                                            bundle = contentfragment3.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "dx-";
                                                        } else if (string13.equals("Rx")) {
                                                            contentFragment contentfragment4 = contentFragment.this;
                                                            compressHelper = contentfragment4.P4;
                                                            bundle = contentfragment4.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "rx-";
                                                        } else if (string13.equals("ID")) {
                                                            contentFragment contentfragment5 = contentFragment.this;
                                                            compressHelper = contentfragment5.P4;
                                                            bundle = contentfragment5.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "id-";
                                                        } else if (string13.equals("Lab")) {
                                                            contentFragment contentfragment6 = contentFragment.this;
                                                            compressHelper = contentfragment6.P4;
                                                            bundle = contentfragment6.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "lab-";
                                                        } else if (string13.equals("Guideline")) {
                                                            contentFragment contentfragment7 = contentFragment.this;
                                                            compressHelper = contentfragment7.P4;
                                                            bundle = contentfragment7.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "guideline-";
                                                        } else if (string13.equals("Table")) {
                                                            contentFragment contentfragment8 = contentFragment.this;
                                                            compressHelper = contentfragment8.P4;
                                                            bundle = contentfragment8.h4;
                                                            sb = new StringBuilder();
                                                            str3 = "table-";
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        str3 = "doc,,,";
                                                        if (string5.equals("amirsys")) {
                                                            str4 = bundle5.getString("contentId");
                                                            contentFragment contentfragment9 = contentFragment.this;
                                                            compressHelper = contentfragment9.P4;
                                                            bundle = contentfragment9.h4;
                                                            sb = new StringBuilder();
                                                        } else {
                                                            if (string5.equals("statdx")) {
                                                                String string14 = bundle5.getString("contentId");
                                                                String string15 = bundle5.getString("type");
                                                                if (string15.equals(ExifInterface.Z4) || string15.equals("6")) {
                                                                    sb3 = new StringBuilder();
                                                                    sb3.append("case,,,");
                                                                } else {
                                                                    sb3 = new StringBuilder();
                                                                    sb3.append(str3);
                                                                }
                                                                sb3.append(string14);
                                                                string3 = sb3.toString();
                                                                contentFragment contentfragment10 = contentFragment.this;
                                                                compressHelper3 = contentfragment10.P4;
                                                                bundle3 = contentfragment10.h4;
                                                                str5 = null;
                                                            } else {
                                                                str5 = null;
                                                                if (string5.equals("martindale")) {
                                                                    string3 = bundle5.getString("contentId");
                                                                    contentFragment contentfragment11 = contentFragment.this;
                                                                    compressHelper3 = contentfragment11.P4;
                                                                    bundle3 = contentfragment11.h4;
                                                                } else {
                                                                    if (string5.equals("sanford")) {
                                                                        str2 = contentFragment.this.P4.t1(StringUtils.splitByWholeSeparator(bundle5.getString("contentId"), "/")) + ".html";
                                                                    } else if (string5.equals("micromedex-neofax")) {
                                                                        String string16 = bundle5.getString("contentId");
                                                                        if (bundle5.getString("typeText").equals("Drug")) {
                                                                            contentFragment contentfragment12 = contentFragment.this;
                                                                            compressHelper2 = contentfragment12.P4;
                                                                            bundle2 = contentfragment12.h4;
                                                                            sb2 = new StringBuilder();
                                                                            str6 = "drug-";
                                                                        } else {
                                                                            contentFragment contentfragment13 = contentFragment.this;
                                                                            compressHelper2 = contentfragment13.P4;
                                                                            bundle2 = contentfragment13.h4;
                                                                            sb2 = new StringBuilder();
                                                                            str6 = "formula-";
                                                                        }
                                                                        sb2.append(str6);
                                                                        sb2.append(string16);
                                                                        compressHelper2.A1(bundle2, sb2.toString(), T2, (String) null);
                                                                        return;
                                                                    } else if (string5.equals("mksap")) {
                                                                        String string17 = bundle5.getString("contentId");
                                                                        String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(string17, "_");
                                                                        str2 = "groups/" + splitByWholeSeparator2[2] + "/" + bundle5.getString("typeText").toLowerCase() + "s/" + string17;
                                                                    } else if (string5.equals("highlight") || string5.equals("note")) {
                                                                        contentFragment.this.A3(bundle5);
                                                                        return;
                                                                    } else {
                                                                        str2 = bundle5.getString("contentId");
                                                                    }
                                                                    contentFragment contentfragment14 = contentFragment.this;
                                                                    compressHelper = contentfragment14.P4;
                                                                    bundle = contentfragment14.h4;
                                                                    compressHelper.A1(bundle, str2, T2, (String) null);
                                                                    return;
                                                                }
                                                            }
                                                            compressHelper3.A1(bundle3, string3, T2, str5);
                                                            return;
                                                        }
                                                    }
                                                    sb.append(str3);
                                                    sb.append(str4);
                                                    str2 = sb.toString();
                                                    compressHelper.A1(bundle, str2, T2, (String) null);
                                                    return;
                                                }
                                            }
                                            contentFragment.this.P4.A1(bundle4, string4, T2, (String) null);
                                            return;
                                        }
                                        contentFragment.this.P4.A1(bundle4, string2, (String[]) null, n1.getString("goto"));
                                        return;
                                    }
                                }
                                contentFragment.this.P4.A1(bundle4, bundle5.getString("URL"), T2, (String) null);
                            } else if (string6.contains("|")) {
                                Bundle bundle7 = new Bundle();
                                Bundle bundle8 = new Bundle();
                                bundle8.putString("docId", string6);
                                bundle8.putString("name", bundle5.getString("text"));
                                bundle8.putString(HTML.Tag.V, bundle5.getString(HTML.Tag.V));
                                bundle7.putBundle("SelectedItem", bundle8);
                                bundle7.putBundle("DB", bundle4);
                                bundle7.putInt("Mode", 2);
                                bundle7.putBundle("GotoSections", contentFragment.this.z3(bundle8));
                                contentFragment.this.P4.N(SSSearchActivity.class, SSSearchActivity.SSSearchFragment.class, bundle7);
                            } else {
                                contentFragment.this.P4.A1(bundle4, string6, T2, bundle5.getString(HTML.Tag.V));
                            }
                        }
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new EmptyViewHolder(LayoutInflater.from(this.f30095d).inflate(R.layout.f1325list_view_item_header_keeper, viewGroup, false));
            }
            View inflate = LayoutInflater.from(this.f30095d).inflate(R.layout.f1358list_view_item_search_ripple, viewGroup, false);
            contentFragment contentfragment = contentFragment.this;
            return new SearchItemViewHolder(contentfragment.r(), inflate);
        }

        public int b() {
            contentFragment contentfragment = contentFragment.this;
            return contentfragment.D3(contentfragment.A4);
        }

        public RecyclerView.ViewHolder o(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.f30095d).inflate(R.layout.f1357list_view_item_search_header, viewGroup, false);
            contentFragment contentfragment = contentFragment.this;
            return new SearchHeaderViewHolder(contentfragment.r(), inflate);
        }

        public void p(RecyclerView.ViewHolder viewHolder, int i2) {
            SearchHeaderViewHolder searchHeaderViewHolder = (SearchHeaderViewHolder) viewHolder;
            if (contentFragment.this.A4 != null) {
                contentFragment contentfragment = contentFragment.this;
                Bundle j3 = contentfragment.j3(i2, contentfragment.A4);
                Bundle bundle = j3.getBundle("Database");
                viewHolder.f15587a.setTag(j3);
                searchHeaderViewHolder.J.setText(bundle.getString("Title"));
                String C = CompressHelper.C(bundle);
                if (C.contains("file:///android_asset/")) {
                    try {
                        InputStream open = contentFragment.this.r().getAssets().open(C.replace("file:///android_asset/", ""));
                        searchHeaderViewHolder.I.setImageBitmap(BitmapFactory.decodeStream(open));
                        open.close();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        e2.printStackTrace();
                    }
                } else {
                    searchHeaderViewHolder.I.setImageURI(Uri.parse(C));
                }
            }
        }

        public long r(int i2) {
            contentFragment contentfragment = contentFragment.this;
            return (long) contentfragment.i3(i2, contentfragment.A4);
        }
    }

    public class SearchHeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView I;
        public TextView J;
        public ImageView K;

        public SearchHeaderViewHolder(Context context, View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f896database_title);
            this.I = (ImageView) view.findViewById(R.id.f893database_image);
            this.K = (ImageView) view.findViewById(R.id.icon);
        }
    }

    public class SearchItemViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public MaterialRippleLayout K;

        public SearchItemViewHolder(Context context, View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1136title_text);
            this.J = (TextView) view.findViewById(R.id.f1098subtitle_text);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    /* access modifiers changed from: private */
    public void A3(Bundle bundle) {
        Bundle Y0 = this.P4.Y0("Name", bundle.getString("dbName"));
        if (Y0 == null) {
            CompressHelper.x2(r(), "Database not found", 1);
            return;
        }
        String string = Y0.getString("Type");
        String string2 = bundle.getString("dbAddress");
        String string3 = bundle.getString("save");
        Bundle bundle2 = new Bundle();
        bundle2.putString("gotoHighlight", string3);
        if (!string.equals("lexi") && !string.equals("nejm") && !string.equals("skyscape") && !string.equals("medhand") && !string.equals("irandarou") && !string.equals("uptodateddx") && !string.equals("visualdx") && !string.equals("uptodate") && !string.equals("accessmedicine") && !string.equals("lww") && !string.equals("elsevier") && !string.equals("elseviernew") && !string.equals("ovid") && !string.equals("epub")) {
            boolean equals = string.equals("epocrate");
        }
        this.P4.B1(Y0, string2, (String[]) null, (String) null, bundle2);
        V2();
    }

    /* access modifiers changed from: private */
    public Bundle z3(Bundle bundle) {
        String str;
        String str2;
        Bundle bundle2 = new Bundle();
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("docId"), "|");
        String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(bundle.getString(HTML.Tag.V), "|");
        for (int i2 = 0; i2 < splitByWholeSeparator.length; i2++) {
            if (splitByWholeSeparator2.length > i2) {
                str = splitByWholeSeparator[i2];
                str2 = splitByWholeSeparator2[i2];
            } else {
                str = splitByWholeSeparator[i2];
                str2 = "";
            }
            bundle2.putString(str, str2);
        }
        return bundle2;
    }

    public void B3() {
        if (this.O4) {
            this.N4.A1(this.J4);
            this.O4 = false;
        }
    }

    public void C3() {
        StickyRecyclerHeadersTouchListener stickyRecyclerHeadersTouchListener = new StickyRecyclerHeadersTouchListener(this.N4, this.J4);
        this.L4 = stickyRecyclerHeadersTouchListener;
        stickyRecyclerHeadersTouchListener.h(new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
            public void a(View view, int i2, long j2) {
                String string = ((Bundle) contentFragment.this.A4.get((int) j2)).getBundle("database").getString("Name");
                if (contentFragment.this.K4.contains(string)) {
                    contentFragment.this.K4.remove(string);
                } else {
                    contentFragment.this.K4.add(string);
                }
                contentFragment.this.N4.getAdapter().G();
            }
        });
        this.N4.s(this.L4);
        x3();
        this.N4.setAdapter(this.B4);
        this.B4.Z(new RecyclerView.AdapterDataObserver() {
            public void a() {
                contentFragment.this.J4.n();
            }
        });
    }

    public int D3(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i2 += this.K4.contains(next.getBundle("database").getString("Name")) ? 1 : next.getParcelableArrayList("items").size();
        }
        return i2;
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        try {
            r().setTitle("");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        menuInflater.inflate(R.menu.f1494search, menu);
        final SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        MenuItem findItem = menu.findItem(R.id.f1045progress_menu);
        this.D4 = findItem;
        this.C4 = (ProgressBar) findItem.getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Anything");
        final String str = this.G4;
        this.s4.postDelayed(new Runnable() {
            public void run() {
                contentFragment.this.s4.k0(str, false);
                String str = contentFragment.this.f4;
                if (str != null && str.length() > 0) {
                    if (contentFragment.this.A4 == null || contentFragment.this.A4.size() == 0) {
                        contentFragment contentfragment = contentFragment.this;
                        contentfragment.s4.k0(contentfragment.f4, true);
                    } else {
                        contentFragment contentfragment2 = contentFragment.this;
                        contentfragment2.s4.k0(contentfragment2.f4, false);
                        contentFragment.this.e3();
                    }
                    contentFragment.this.V2();
                }
            }
        }, 10);
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = searchView.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (searchView.getTag(1) != null && ((String) searchView.getTag(1)).length() > 0) {
                    string = searchView.getTag() + StringUtils.SPACE + string;
                }
                searchView.k0(string, true);
                return false;
            }

            public boolean b(int i2) {
                Cursor c2 = searchView.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (searchView.getTag() != null && ((String) searchView.getTag()).length() > 0) {
                    string = searchView.getTag() + StringUtils.SPACE + string;
                }
                searchView.k0(string, true);
                return false;
            }
        });
        ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                searchView.k0("", false);
                searchView.clearFocus();
                contentFragment.this.f3("Search Anything");
                contentFragment.this.V2();
            }
        });
        searchView.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull final ObservableEmitter<String> observableEmitter) throws Throwable {
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    /* renamed from: a  reason: collision with root package name */
                    private DisposableObserver<Bundle> f30088a;

                    public boolean a(String str) {
                        observableEmitter.onNext(str);
                        return true;
                    }

                    public boolean b(final String str) {
                        iMDLogger.j("OnQueryTextSubmit", "OnQueryTextSubmit");
                        String unused = contentFragment.this.G4 = str;
                        contentFragment.this.f4 = str;
                        DisposableObserver<Bundle> disposableObserver = this.f30088a;
                        if (disposableObserver != null) {
                            disposableObserver.onComplete();
                        }
                        observableEmitter.onNext("SoheilvbSoheilvbSoheilvb");
                        contentFragment.this.P4.I(str, "SearchContentAll");
                        iMDLogger.j("OnQueryTextSubmit", "Building search observable");
                        Observable A4 = Observable.w1(new ObservableOnSubscribe<Bundle>() {
                            public void a(@NonNull ObservableEmitter<Bundle> observableEmitter) throws Throwable {
                                ArrayList<Bundle> arrayList;
                                ArrayList arrayList2 = new ArrayList();
                                Iterator<Bundle> it2 = CompressHelper.t.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(it2.next());
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("Path", contentFragment.this.P4.M1());
                                bundle.putString("Name", "highlights.db");
                                bundle.putString("Title", "Highlights");
                                bundle.putString("Type", "highlight");
                                bundle.putString("IconName", "");
                                arrayList2.add(0, bundle);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("Path", contentFragment.this.P4.M1());
                                bundle2.putString("Name", "highlights.db");
                                bundle2.putString("Title", "Notes");
                                bundle2.putString("Type", "note");
                                bundle2.putString("IconName", "");
                                arrayList2.add(0, bundle2);
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    Bundle bundle3 = (Bundle) it3.next();
                                    try {
                                        arrayList = contentFragment.this.k3(bundle3, str);
                                    } catch (Exception e2) {
                                        FirebaseCrashlytics.d().g(e2);
                                        iMDLogger.f("ContentSearch", "Error in querying " + bundle3.getString("Name"));
                                        arrayList = null;
                                    }
                                    if (!(arrayList == null || arrayList.size() == 0)) {
                                        iMDLogger.j("Search", "Result from " + bundle3.getString("Title") + " : " + arrayList.size());
                                        Bundle bundle4 = new Bundle();
                                        bundle4.putBundle("database", bundle3);
                                        bundle4.putParcelableArrayList("items", arrayList);
                                        observableEmitter.onNext(bundle4);
                                    }
                                }
                                observableEmitter.onComplete();
                            }
                        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).A4(new Function<Throwable, Bundle>() {
                            /* renamed from: a */
                            public Bundle apply(Throwable th) throws Throwable {
                                return null;
                            }
                        });
                        Observable unused2 = contentFragment.this.H4 = A4;
                        AnonymousClass3 r0 = new DisposableObserver<Bundle>() {
                            /* access modifiers changed from: protected */
                            public void a() {
                                super.a();
                                contentFragment.this.D4.setVisible(true);
                                contentFragment.this.C4.setIndeterminate(true);
                                iMDLogger.j("SearchSubscriber", "On Start");
                                ArrayList unused = contentFragment.this.A4 = new ArrayList();
                                contentFragment.this.C3();
                                contentFragment.this.V2();
                                searchView.getSuggestionsAdapter().m((Cursor) null);
                                contentFragment.this.f3("Searching");
                            }

                            /* renamed from: c */
                            public void onNext(@NonNull Bundle bundle) {
                                contentFragment.this.e3();
                                contentFragment.this.A4.add(bundle);
                                contentFragment.this.N4.getAdapter().G();
                                StringBuilder sb = new StringBuilder();
                                sb.append("On Next - ");
                                sb.append(bundle.getBundle("database").getString("Title"));
                                sb.append(" - ");
                                contentFragment contentfragment = contentFragment.this;
                                sb.append(contentfragment.D3(contentfragment.A4));
                                sb.append(" - IN Thread :");
                                sb.append(Thread.currentThread());
                                iMDLogger.j("SearchSubscriber", sb.toString());
                            }

                            public void onComplete() {
                                contentFragment.this.D4.setVisible(false);
                                iMDLogger.j("SearchSubscriber", "On Complete");
                                if (contentFragment.this.A4 == null || contentFragment.this.A4.size() == 0) {
                                    contentFragment.this.f3("Nothing Found");
                                }
                                if (contentFragment.this.V1().getSharedPreferences("default_preferences", 0).getBoolean("ContentCollapsed", false)) {
                                    contentFragment.this.y3();
                                }
                            }

                            public void onError(@NonNull Throwable th) {
                                contentFragment.this.D4.setVisible(false);
                                iMDLogger.j("SearchSubscriber", "On Error");
                                iMDLogger.f("onQueryTextSubmit", "Some error on SearchObservable");
                            }
                        };
                        this.f30088a = r0;
                        DisposableObserver unused3 = contentFragment.this.I4 = r0;
                        A4.a(this.f30088a);
                        return true;
                    }
                });
            }
        }).x1(500, TimeUnit.MILLISECONDS).a(new DisposableObserver<String>() {
            /* renamed from: c */
            public void onNext(@NonNull String str) {
                if (str.equals("SoheilvbSoheilvbSoheilvb")) {
                    searchView.getSuggestionsAdapter().m((Cursor) null);
                } else if (str.length() > 1) {
                    String[] split = str.trim().split(StringUtils.SPACE);
                    String str2 = split[split.length - 1];
                    String str3 = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        str3 = str3 + StringUtils.SPACE + split[i2];
                    }
                    searchView.setTag(str3.trim());
                    CompressHelper compressHelper = contentFragment.this.P4;
                    compressHelper.c0(compressHelper.A(), "Select rowid as _id,word from contentspell where word match '" + str2 + "*'").h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<ArrayList<Bundle>>() {
                        /* renamed from: a */
                        public void accept(ArrayList<Bundle> arrayList) throws Throwable {
                            searchView.getSuggestionsAdapter().m(contentFragment.this.P4.h(arrayList));
                        }
                    });
                }
            }

            public void onComplete() {
            }

            public void onError(@NonNull Throwable th) {
            }
        });
        r().setTitle("");
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.q4;
        if (view != null) {
            return view;
        }
        this.K4 = new ArrayList<>();
        View inflate = layoutInflater.inflate(R.layout.f1265fragment_search, viewGroup, false);
        this.q4 = inflate;
        if (bundle != null && bundle.containsKey("Position")) {
            this.e4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.f4 = bundle.getString("Query");
        }
        if (bundle != null && bundle.containsKey("mIsSubmitted")) {
            this.F4 = bundle.getBoolean("mIsSubmitted");
        }
        this.N4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.A4 = new ArrayList<>();
        if (bundle != null && bundle.containsKey("mResults")) {
            this.A4 = bundle.getParcelableArrayList("mResults");
        }
        this.B4 = new SearchAdapter(r());
        this.P4 = new CompressHelper(r());
        this.J4 = new StickyRecyclerHeadersDecoration(this.B4, new ItemVisibilityAdapter() {
            public boolean a(int i2) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) contentFragment.this.N4.getLayoutManager();
                linearLayoutManager.B2();
                linearLayoutManager.E2();
                boolean z = linearLayoutManager.B2() <= i2 && linearLayoutManager.E2() >= i2;
                Boolean valueOf = Boolean.valueOf(z);
                iMDLogger.f(CSS.Property.m0, i2 + " visible + " + valueOf);
                return z;
            }
        });
        this.N4.setLayoutManager(new LinearLayoutManager(r()));
        this.N4.setItemAnimator(new DefaultItemAnimator());
        this.N4.setItemDecoration(new CustomItemDecoration(r()));
        o2(true);
        f3("Search Contents");
        return inflate;
    }

    public void e3() {
        RecyclerView.Adapter adapter = this.N4.getAdapter();
        SearchAdapter searchAdapter = this.B4;
        if (adapter != searchAdapter) {
            this.J4.n();
            this.N4.setAdapter(this.B4);
            return;
        }
        searchAdapter.G();
    }

    public void f3(String str) {
        try {
            if (!str.equals("Searching")) {
                this.J4.n();
                B3();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        this.N4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        this.N4.setAdapter(new StatusAdapter(r(), str));
    }

    public void g1() {
        super.g1();
    }

    public int i3(int i2, ArrayList<Bundle> arrayList) {
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Bundle bundle = arrayList.get(i4);
            i3 += this.K4.contains(bundle.getBundle("database").getString("Name")) ? 1 : bundle.getParcelableArrayList("items").size();
            if (i2 < i3) {
                return i4;
            }
        }
        return 0;
    }

    public Bundle j3(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String string = next.getBundle("database").getString("Name");
            int size = this.K4.contains(string) ? 1 : next.getParcelableArrayList("items").size();
            i3 += size;
            if (i2 < i3) {
                int i4 = i2 - (i3 - size);
                Bundle bundle = new Bundle();
                bundle.putBundle("Database", next.getBundle("database"));
                if (this.K4.contains(string)) {
                    if (i4 == 0) {
                        return bundle;
                    }
                    i4--;
                }
                bundle.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(i4));
                return bundle;
            }
        }
        return null;
    }

    public ArrayList<Bundle> k3(Bundle bundle, String str) {
        CompressHelper compressHelper;
        String str2;
        CompressHelper compressHelper2;
        String str3;
        String str4;
        CompressHelper compressHelper3;
        String str5;
        CompressHelper compressHelper4;
        String str6;
        String replace = str.replace("'", "''");
        String string = bundle.getString("Type");
        try {
            if (!string.equals("lexi")) {
                if (string.equals("skyscape")) {
                    compressHelper2 = this.P4;
                    str3 = "Select URL as id, Text as text,snippet(search) as subText  from search where search match '" + replace + "' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                    str4 = "fcontentSearch.db";
                } else if (string.equals("medhand")) {
                    compressHelper4 = this.P4;
                    str6 = "Select URL, Text as text,snippet(search) as subText  from search where search match '" + replace + "' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                } else if (string.equals("visualdx")) {
                    compressHelper4 = this.P4;
                    str6 = "Select URL as id, Text || ' - ' || SubText as text, snippet(search) as subText  from search where search match '" + replace + "' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                } else if (string.equals("uptodate")) {
                    compressHelper4 = this.P4;
                    str6 = "Select URL, Text || ' - ' || \"table\" as text, snippet(search) as subText, related_topic  from search where search match '" + replace + "' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                } else {
                    if (string.equals("accessmedicine")) {
                        compressHelper = this.P4;
                        str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:2 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                    } else if (string.equals("lww")) {
                        compressHelper = this.P4;
                        str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:2 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                    } else if (string.equals("nejm")) {
                        compressHelper = this.P4;
                        str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " AND (type:5)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                    } else {
                        if (!string.equals("elsevier")) {
                            if (!string.equals("elseviernew")) {
                                if (string.equals("ovid")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:2 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                                } else if (string.equals("highlight")) {
                                    compressHelper = this.P4;
                                    str2 = "select dbTitle || ' - ' || dbDocName as text, snippet(highlight) as subText, dbAddress,dbName, type,note,save from highlight where text match '" + replace + "' ORDER BY rank(matchinfo(highlight)) DESC limit 100";
                                } else if (string.equals("note")) {
                                    compressHelper = this.P4;
                                    str2 = "select dbTitle || ' - ' || dbDocName as text, snippet(highlight) as subText, dbAddress,dbName, type,note,save from highlight where note match '" + replace + "' ORDER BY rank(matchinfo(highlight)) DESC limit 100";
                                } else if (string.equals("epub")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:0 OR type:1)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                                } else if (string.equals("epocrate")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  contentId,type,text || ' - ' || typeText as text,typeText, snippet(search) as subText  from search where search match '" + replace + " NOT (type:0 OR type:1 OR type:2 OR type:3 OR type:4 OR type:6 OR type:7)' ORDER BY rank(matchinfo(search)) DESC limit 100";
                                } else if (string.equals("amirsys")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  contentId,type, text || ' - ' || typeText as text,typeText, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:2)' ORDER BY rank(matchinfo(search)) DESC limit 100";
                                } else if (string.equals("statdx")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  contentId,type, text,typeText, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:3)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                } else if (string.equals("martindale")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  text, contentId,type,typeText, snippet(search) as subText  from search where search match '" + replace + " AND (type:5)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                } else if (string.equals("facts")) {
                                    compressHelper = this.P4;
                                    str2 = "Select  text, contentId,type,typeText, snippet(search) as subText  from search where search match '" + replace + " AND (type:5)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                } else {
                                    if (string.equals("micromedex-drug")) {
                                        compressHelper3 = this.P4;
                                        str5 = "Select  contentId,type, text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                                    } else if (string.equals("micromedex-neofax")) {
                                        compressHelper3 = this.P4;
                                        str5 = "Select  contentId,type, text || ' - ' || typeText as text,typeText, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                                    } else if (string.equals("sanford")) {
                                        compressHelper2 = this.P4;
                                        str3 = "Select path as contentId, title as text, snippet(search_base) as subText  from search_base where search_base match '" + replace + "' ORDER BY rank(matchinfo(search_base)) DESC limit " + 15;
                                        str4 = "fts.db";
                                    } else if (string.equals("noskhe")) {
                                        compressHelper = this.P4;
                                        str2 = "Select  Text as text, contentId,type,typeText, snippet(search) as subText  from search where search match '" + replace + " AND (type:5)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                    } else if (string.equals("stockley")) {
                                        compressHelper = this.P4;
                                        str2 = "Select  text, contentId,type,typeText, snippet(search) as subText  from search where search match '" + replace + " AND (type:5)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                    } else if (!string.equals("mksap")) {
                                        return null;
                                    } else {
                                        compressHelper = this.P4;
                                        str2 = "Select  Text as text, contentId,type,typeText, snippet(search) as subText  from search where search match '" + replace + " AND (type:5) AND  (typeText:Topic OR typeText:Question)' ORDER BY rank(matchinfo(search)) DESC,type asc limit " + 15;
                                    }
                                    return compressHelper3.W(bundle, str5, "fsearch.sqlite");
                                }
                            }
                        }
                        compressHelper = this.P4;
                        str2 = "Select  contentId,type,text || ' - ' || typeText as text, snippet(search) as subText  from search where search match '" + replace + " NOT (type:1 OR type:2 OR type:0)' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
                    }
                    return compressHelper.V(bundle, str2);
                }
                return compressHelper2.W(bundle, str3, str4);
            } else if (!new File(CompressHelper.g1(bundle, "fcontentsearch.db")).exists()) {
                return null;
            } else {
                compressHelper4 = this.P4;
                str6 = "Select URL as id, Text as text,snippet(search) as subText  from search where search match '" + replace + "' ORDER BY rank(matchinfo(search)) DESC limit " + 15;
            }
            return compressHelper4.W(bundle, str6, "fcontentsearch.db");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            iMDLogger.f("SearchInDB", "Error in searching " + bundle.getString("Title") + " : " + e2);
            return null;
        }
    }

    public void l1() {
        super.l1();
        V2();
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void x3() {
        if (!this.O4) {
            this.N4.setItemDecoration(this.J4);
            this.O4 = true;
        }
    }

    public void y3() {
        Bundle bundle;
        this.K4 = new ArrayList<>();
        Iterator<Bundle> it2 = this.A4.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (!(next == null || (bundle = next.getBundle("database")) == null)) {
                this.K4.add(bundle.getString("Name"));
            }
        }
        this.N4.getAdapter().G();
    }
}
