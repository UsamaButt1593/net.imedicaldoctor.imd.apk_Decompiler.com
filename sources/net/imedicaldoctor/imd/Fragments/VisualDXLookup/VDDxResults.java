package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.GridAutoFitLayoutManager;
import net.imedicaldoctor.imd.iMD;
import net.imedicaldoctor.imd.iMDActivity;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class VDDxResults extends iMDActivity {

    public static class VDDxResultsFragment extends ViewerHelperFragment {
        public Bundle X4;
        public String Y4;
        public String Z4;
        public RecyclerView a5;
        /* access modifiers changed from: private */
        public Bundle b5;
        public ArrayList<Bundle> c5;

        public static class HeaderPlaceHolder extends RecyclerView.ViewHolder {
            public TextView I;

            public HeaderPlaceHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public static class PhotoCaptionWarningPlaceHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public ImageView J;
            public ImageView K;
            public MaterialRippleLayout L;

            public PhotoCaptionWarningPlaceHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f866caption);
                this.J = (ImageView) view.findViewById(R.id.f980image_view);
                this.K = (ImageView) view.findViewById(R.id.f1158warning);
                this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            }
        }

        public Bundle I4(int i2, ArrayList<Bundle> arrayList) {
            Iterator<Bundle> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                Bundle next = it2.next();
                if (i2 == i3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Title", next.getString("title"));
                    return bundle;
                }
                int size = i3 + next.getParcelableArrayList("items").size();
                if (i2 <= size) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get((i2 - (size - next.getParcelableArrayList("items").size())) - 1));
                    return bundle2;
                }
                i3 = size + 1;
            }
            return null;
        }

        public int K4(ArrayList<Bundle> arrayList) {
            int i2 = 0;
            if (arrayList == null) {
                return 0;
            }
            Iterator<Bundle> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i2 = i2 + it2.next().getParcelableArrayList("items").size() + 1;
            }
            return i2;
        }

        public int L4(ArrayList<Bundle> arrayList) {
            Iterator<Bundle> it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                i2 += it2.next().getParcelableArrayList("items").size();
            }
            return i2;
        }

        public String R2() {
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(v3(v3(this.c5).getParcelableArrayList("items")).getString("images"), ",");
            Bundle bundle = this.X4;
            return CompressHelper.h1(bundle, splitByWholeSeparator[0] + ".jpg", "Large-Encrypted");
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            String str;
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
            this.Q4 = new CompressHelper(r());
            this.C4 = inflate;
            this.X4 = y().getBundle("DB");
            this.b5 = new Bundle();
            this.Y4 = y().getString("URL").replace("ddx-", "");
            this.Z4 = y().getString("moduleId");
            final CompressHelper compressHelper = new CompressHelper(r());
            if (bundle != null && bundle.containsKey("items")) {
                this.c5 = bundle.getParcelableArrayList("items");
            }
            final int length = StringUtils.splitByWholeSeparator(this.Y4, ",").length;
            final AnonymousClass1 r7 = new RecyclerView.Adapter() {
                public int C(int i2) {
                    VDDxResultsFragment vDDxResultsFragment = VDDxResultsFragment.this;
                    return vDDxResultsFragment.I4(i2, vDDxResultsFragment.c5).containsKey("Title") ? 0 : 1;
                }

                public void R(RecyclerView.ViewHolder viewHolder, int i2) {
                    String str;
                    VDDxResultsFragment vDDxResultsFragment = VDDxResultsFragment.this;
                    Bundle I4 = vDDxResultsFragment.I4(i2, vDDxResultsFragment.c5);
                    if (I4.containsKey("Title")) {
                        boolean equals = I4.getString("Title").equals(String.valueOf(length));
                        TextView textView = ((HeaderPlaceHolder) viewHolder).I;
                        if (equals) {
                            str = "Matched All Findings";
                        } else {
                            str = "Matched " + I4.getString("Title") + " Findings";
                        }
                        textView.setText(str);
                        return;
                    }
                    final PhotoCaptionWarningPlaceHolder photoCaptionWarningPlaceHolder = (PhotoCaptionWarningPlaceHolder) viewHolder;
                    Bundle bundle = I4.getBundle("Item");
                    String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("images"), ",");
                    final String h1 = CompressHelper.h1(VDDxResultsFragment.this.X4, splitByWholeSeparator[0] + ".jpg", "Medium");
                    String string = bundle.getString("diagnosisTitle");
                    if (VDDxResultsFragment.this.b5.containsKey(h1)) {
                        photoCaptionWarningPlaceHolder.L.setRippleColor(VDDxResultsFragment.this.b5.getInt(h1));
                    } else {
                        VDDxResultsFragment.this.q3(new Runnable() {
                            public void run() {
                                Palette.Swatch C = Palette.b(BitmapFactory.decodeFile(h1)).g().C();
                                if (C != null) {
                                    int e2 = C.e();
                                    if (!VDDxResultsFragment.this.b5.containsKey(h1)) {
                                        VDDxResultsFragment.this.b5.putInt(h1, e2);
                                    }
                                }
                            }
                        }, new Runnable() {
                            public void run() {
                                photoCaptionWarningPlaceHolder.L.setRippleColor(VDDxResultsFragment.this.b5.getInt(h1));
                            }
                        });
                    }
                    photoCaptionWarningPlaceHolder.I.setText(string);
                    Glide.G(VDDxResultsFragment.this.r()).i(new File(h1)).B2(photoCaptionWarningPlaceHolder.J);
                    if (bundle.getString("severity").equals(ExifInterface.Y4)) {
                        photoCaptionWarningPlaceHolder.K.setVisibility(0);
                    } else {
                        photoCaptionWarningPlaceHolder.K.setVisibility(4);
                    }
                    final String string2 = bundle.getString("diagnosesModulesId");
                    photoCaptionWarningPlaceHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            String str = string2;
                            String substring = str.substring(0, str.length() - VDDxResultsFragment.this.Z4.length());
                            if (((iMD) VDDxResultsFragment.this.r().getApplicationContext()).s != null) {
                                new CompressHelper(VDDxResultsFragment.this.r()).A1((Bundle) new ArrayList(Collections2.d(((iMD) VDDxResultsFragment.this.r().getApplicationContext()).s, new Predicate<Bundle>() {
                                    /* renamed from: a */
                                    public boolean apply(Bundle bundle) {
                                        return bundle.getString("Type").equals("visualdx");
                                    }
                                })).get(0), substring, (String[]) null, (String) null);
                            }
                        }
                    });
                }

                public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                    return C(i2) == 0 ? new HeaderPlaceHolder(LayoutInflater.from(VDDxResultsFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false)) : new PhotoCaptionWarningPlaceHolder(LayoutInflater.from(VDDxResultsFragment.this.r()).inflate(R.layout.f1289grid_view_item_image_caption_danger, viewGroup, false));
                }

                public int b() {
                    VDDxResultsFragment vDDxResultsFragment = VDDxResultsFragment.this;
                    ArrayList<Bundle> arrayList = vDDxResultsFragment.c5;
                    if (arrayList == null) {
                        return 0;
                    }
                    return vDDxResultsFragment.K4(arrayList);
                }
            };
            final RecyclerView recyclerView = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
            this.a5 = recyclerView;
            if (this.c5 == null) {
                if (this.Y4.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT diagnosesModulesId,count(*) c, diagnosisTitle, images, severity, sort FROM diagnosesmodulesfindings Where moduleId=");
                    sb.append(this.Z4);
                    sb.append(" AND findingId IN(");
                    sb.append(this.Y4);
                    sb.append(") GROUP BY diagnosesModulesId having c > ");
                    sb.append((StringUtils.splitByWholeSeparator(this.Y4, ",").length / 2) - 1);
                    sb.append(" order by c desc, sort asc, diagnosisTitle asc");
                    str = sb.toString();
                } else {
                    str = "SELECT diagnosesModulesId,0 c, diagnosisTitle, images, severity, sort FROM diagnosesmodulesfindings Where moduleId=" + this.Z4 + " GROUP BY diagnosesModulesId order by sort asc, diagnosisTitle asc";
                }
                final String str2 = str;
                final RecyclerView recyclerView2 = recyclerView;
                new AsyncTask() {

                    /* renamed from: a  reason: collision with root package name */
                    private final ProgressDialog f30054a;

                    {
                        this.f30054a = new ProgressDialog(VDDxResultsFragment.this.r());
                    }

                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        VDDxResultsFragment vDDxResultsFragment = VDDxResultsFragment.this;
                        CompressHelper compressHelper = compressHelper;
                        vDDxResultsFragment.c5 = compressHelper.r2(compressHelper.V(vDDxResultsFragment.X4, str2), "c");
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        if (this.f30054a.isShowing()) {
                            this.f30054a.dismiss();
                        }
                        VDDxResultsFragment vDDxResultsFragment = VDDxResultsFragment.this;
                        if (vDDxResultsFragment.c5 == null) {
                            vDDxResultsFragment.r().setTitle("Nothing Found !");
                            VDDxResultsFragment vDDxResultsFragment2 = VDDxResultsFragment.this;
                            vDDxResultsFragment2.F4 = "Nothing Found !";
                            vDDxResultsFragment2.n4("Nothing Found !");
                            VDDxResultsFragment.this.o4();
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        VDDxResultsFragment vDDxResultsFragment3 = VDDxResultsFragment.this;
                        sb.append(vDDxResultsFragment3.L4(vDDxResultsFragment3.c5));
                        sb.append(" Diagnosis Found !");
                        vDDxResultsFragment.F4 = sb.toString();
                        VDDxResultsFragment.this.r().setTitle(VDDxResultsFragment.this.F4);
                        VDDxResultsFragment vDDxResultsFragment4 = VDDxResultsFragment.this;
                        vDDxResultsFragment4.n4(vDDxResultsFragment4.F4);
                        VDDxResultsFragment.this.o4();
                        recyclerView2.setAdapter(r7);
                        VDDxResultsFragment.this.M2();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        this.f30054a.setMessage("Searching");
                        this.f30054a.show();
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            }
            final GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(r(), (int) (b0().getDisplayMetrics().density * 100.0f));
            gridAutoFitLayoutManager.R3(new GridLayoutManager.SpanSizeLookup() {
                public int f(int i2) {
                    if (recyclerView.getAdapter().C(i2) == 0) {
                        return gridAutoFitLayoutManager.b0;
                    }
                    return 1;
                }
            });
            recyclerView.setLayoutManager(gridAutoFitLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            this.C4 = inflate;
            this.L4 = (Toolbar) inflate.findViewById(R.id.f1139toolbar);
            f3(R.menu.f1412empty);
            o2(false);
            G3();
            return inflate;
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public void o4() {
            new AsyncTask() {

                /* renamed from: a  reason: collision with root package name */
                byte[] f30063a;

                /* access modifiers changed from: protected */
                public Object doInBackground(Object[] objArr) {
                    try {
                        File file = new File(VDDxResultsFragment.this.R2());
                        this.f30063a = new CompressHelper(VDDxResultsFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
                        return null;
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        iMDLogger.f("ImageGallery", "Error in decrypting image");
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Object obj) {
                    super.onPostExecute(obj);
                    Glide.G(VDDxResultsFragment.this.r()).h(this.f30063a).B2(VDDxResultsFragment.this.M4);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }

        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.C4.postDelayed(new Runnable() {
                public void run() {
                    VDDxResultsFragment.this.a5.getAdapter().G();
                }
            }, 500);
        }

        public boolean v4() {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new VDDxResultsFragment());
    }
}
