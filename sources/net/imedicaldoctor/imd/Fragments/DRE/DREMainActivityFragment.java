package net.imedicaldoctor.imd.Fragments.DRE;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleSearchContentViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import org.apache.commons.lang3.StringUtils;

public class DREMainActivityFragment extends SearchHelperFragment {
    public ArrayList<String> A4;
    public ArrayList<Bundle> B4;
    public ArrayList<Bundle> C4;
    public ArrayList<Bundle> D4;
    public ArrayList<Bundle> E4;
    public ArrayList<Bundle> F4;
    public ArrayList<Bundle> G4;
    public ArrayList<Bundle> H4;
    public ArrayList<Bundle> I4;
    public ArrayList<Bundle> J4;
    public int K4 = 0;
    public int L4 = 0;
    public int M4 = 0;
    public int N4 = 0;
    public int O4 = 0;
    public int P4 = 0;
    public int Q4 = 40;
    public int R4 = 0;
    public int S4 = 0;
    public int T4 = 0;
    public boolean U4;
    private final String V4 = "سوالات";
    private final String W4 = "ساخت آزمون";
    private final String X4 = "آزمون های قبلی";
    private final String Y4 = "تنظیمات";
    private final String Z4 = "subject";
    private final String a5 = "system";
    private final String b5 = "type";
    private final String c5 = "year";
    private final String d5 = "area";
    private final String e5 = "numberquestion";
    private final String f5 = "testMode";
    private final String g5 = "filter";
    private final String h5 = "hardness";

    public class AccountTextViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout J;

        public AccountTextViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class UWAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        private final int f29672d = 0;

        /* renamed from: e  reason: collision with root package name */
        private final int f29673e = 4;

        /* renamed from: f  reason: collision with root package name */
        private final int f29674f = 1;

        /* renamed from: g  reason: collision with root package name */
        private final int f29675g = 2;

        /* renamed from: h  reason: collision with root package name */
        private final int f29676h = 3;

        public UWAdapter() {
        }

        public int C(int i2) {
            DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
            Bundle i3 = dREMainActivityFragment.i3(i2, dREMainActivityFragment.A4);
            if (!i3.getString("Type").equals("Header") && i3.getString("Type").equals("Item")) {
                String string = i3.getString("Section");
                int i4 = i3.getInt("Index");
                if (string.equals("سوالات")) {
                    return 1;
                }
                if (string.equals("ساخت آزمون")) {
                    if (!DREMainActivityFragment.this.U4) {
                        if (i4 == 10) {
                            return 4;
                        }
                        return i4 == 9 ? 3 : 2;
                    } else if (i4 == 8) {
                        return 4;
                    } else {
                        return i4 == 7 ? 3 : 2;
                    }
                } else if (string.equals("آزمون های قبلی")) {
                    return 1;
                } else {
                    if (string.equals("تنظیمات")) {
                        return 3;
                    }
                }
            }
            return 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            View.OnClickListener onClickListener;
            MaterialRippleLayout materialRippleLayout;
            AccountTextViewHolder accountTextViewHolder;
            HeaderCellViewHolder headerCellViewHolder;
            TextView textView;
            StringBuilder sb;
            DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
            Bundle i3 = dREMainActivityFragment.i3(i2, dREMainActivityFragment.A4);
            if (i3.getString("Type").equals("Header")) {
                HeaderCellViewHolder headerCellViewHolder2 = (HeaderCellViewHolder) viewHolder;
                headerCellViewHolder2.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                headerCellViewHolder2.I.setText(i3.getString("Text"));
            }
            if (i3.getString("Type").equals("Item")) {
                String string = i3.getString("Section");
                int i4 = i3.getInt("Index");
                if (string.equals("سوالات")) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    rippleTextViewHolder.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                    if (i4 == 0) {
                        rippleTextViewHolder.I.setText("تمام سوالات");
                        materialRippleLayout = rippleTextViewHolder.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                dREMainActivityFragment.k4.N(DRETocActivity.class, DRETocActivityFragment.class, dREMainActivityFragment.l3("0"));
                            }
                        };
                    } else if (i4 == 1) {
                        rippleTextViewHolder.I.setText("سوالات دلخواه");
                        materialRippleLayout = rippleTextViewHolder.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                dREMainActivityFragment.k4.N(DRETocActivity.class, DRETocActivityFragment.class, dREMainActivityFragment.l3(ExifInterface.Z4));
                            }
                        };
                    } else {
                        return;
                    }
                } else if (string.equals("ساخت آزمون")) {
                    DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                    if (dREMainActivityFragment2.U4) {
                        if (i4 == 8) {
                            headerCellViewHolder = (HeaderCellViewHolder) viewHolder;
                            textView = headerCellViewHolder.I;
                            sb = new StringBuilder();
                        } else if (i4 == 7) {
                            accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                            accountTextViewHolder.I.setTextColor(DREMainActivityFragment.this.b0().getColor(R.color.f469white));
                            accountTextViewHolder.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                            if (DREMainActivityFragment.this.K4 > 0) {
                                accountTextViewHolder.J.setBackgroundColor(DREMainActivityFragment.this.b0().getColor(R.color.f168green_dark));
                                accountTextViewHolder.I.setText("ساخت امتحان");
                                materialRippleLayout = accountTextViewHolder.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        String str = StringUtils.splitByWholeSeparator(dREMainActivityFragment.G4.get(dREMainActivityFragment.Q4).getString("title"), StringUtils.SPACE)[0];
                                        String k3 = DREMainActivityFragment.this.k3(new Date());
                                        DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                                        String string = dREMainActivityFragment2.B4.get(dREMainActivityFragment2.L4).getString("name");
                                        String p3 = DREMainActivityFragment.this.p3();
                                        DREMainActivityFragment dREMainActivityFragment3 = DREMainActivityFragment.this;
                                        CompressHelper compressHelper = dREMainActivityFragment3.k4;
                                        Bundle bundle = dREMainActivityFragment3.h4;
                                        ArrayList<Bundle> V = compressHelper.V(bundle, "Select id from questions where " + p3 + " order by random() limit " + str);
                                        ArrayList arrayList = new ArrayList();
                                        Iterator<Bundle> it2 = V.iterator();
                                        while (it2.hasNext()) {
                                            arrayList.add(it2.next().getString("id"));
                                        }
                                        String join = StringUtils.join((Iterable<?>) arrayList, ",");
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add("Reading");
                                        arrayList2.add("Testing");
                                        DREMainActivityFragment dREMainActivityFragment4 = DREMainActivityFragment.this;
                                        CompressHelper compressHelper2 = dREMainActivityFragment4.k4;
                                        Bundle bundle2 = dREMainActivityFragment4.h4;
                                        compressHelper2.m(bundle2, "Insert into Tests (id, qIds, createdDate, qIndex, done, mode, right, wrong, subject, system, hard) values (null, '" + join + "', '" + k3 + "', 0, 0, '" + ((String) arrayList2.get(DREMainActivityFragment.this.R4)) + "', 0, 0, '" + string + "', '', '')");
                                        DREMainActivityFragment dREMainActivityFragment5 = DREMainActivityFragment.this;
                                        CompressHelper compressHelper3 = dREMainActivityFragment5.k4;
                                        String string2 = compressHelper3.s1(compressHelper3.V(dREMainActivityFragment5.h4, "SELECT id FROM Tests ORDER BY id DESC LIMIT 1")).getString("id");
                                        DREMainActivityFragment dREMainActivityFragment6 = DREMainActivityFragment.this;
                                        CompressHelper compressHelper4 = dREMainActivityFragment6.k4;
                                        Bundle bundle3 = dREMainActivityFragment6.h4;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("test-");
                                        sb.append(string2);
                                        compressHelper4.A1(bundle3, sb.toString(), (String[]) null, (String) null);
                                    }
                                };
                            }
                            accountTextViewHolder.J.setBackgroundColor(DREMainActivityFragment.this.b0().getColor(R.color.f279material_grey_700));
                            accountTextViewHolder.I.setText("سوالی وجود ندارد");
                            return;
                        } else {
                            RippleTextViewHolder rippleTextViewHolder2 = (RippleTextViewHolder) viewHolder;
                            rippleTextViewHolder2.I.setTypeface(ResourcesCompat.j(dREMainActivityFragment2.r(), R.font.f782iransans));
                            if (i4 == 0) {
                                TextView textView2 = rippleTextViewHolder2.I;
                                DREMainActivityFragment dREMainActivityFragment3 = DREMainActivityFragment.this;
                                textView2.setText(dREMainActivityFragment3.G4.get(dREMainActivityFragment3.Q4).getString("title"));
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("numberquestion", dREMainActivityFragment.G4, "title", dREMainActivityFragment.Q4);
                                    }
                                };
                            } else if (i4 == 1) {
                                TextView textView3 = rippleTextViewHolder2.I;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("حالت آزمون : ");
                                DREMainActivityFragment dREMainActivityFragment4 = DREMainActivityFragment.this;
                                sb2.append(dREMainActivityFragment4.H4.get(dREMainActivityFragment4.R4).getString("title"));
                                textView3.setText(sb2.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("testMode", dREMainActivityFragment.H4, "title", dREMainActivityFragment.R4);
                                    }
                                };
                            } else if (i4 == 2) {
                                TextView textView4 = rippleTextViewHolder2.I;
                                DREMainActivityFragment dREMainActivityFragment5 = DREMainActivityFragment.this;
                                textView4.setText(dREMainActivityFragment5.B4.get(dREMainActivityFragment5.L4).getString("name"));
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("subject", dREMainActivityFragment.B4, "name", dREMainActivityFragment.L4);
                                    }
                                };
                            } else if (i4 == 3) {
                                TextView textView5 = rippleTextViewHolder2.I;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("نوع سوالات : ");
                                DREMainActivityFragment dREMainActivityFragment6 = DREMainActivityFragment.this;
                                sb3.append(dREMainActivityFragment6.D4.get(dREMainActivityFragment6.O4).getString("name"));
                                textView5.setText(sb3.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("type", dREMainActivityFragment.D4, "name", dREMainActivityFragment.O4);
                                    }
                                };
                            } else if (i4 == 4) {
                                TextView textView6 = rippleTextViewHolder2.I;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("منطقه : ");
                                DREMainActivityFragment dREMainActivityFragment7 = DREMainActivityFragment.this;
                                sb4.append(dREMainActivityFragment7.F4.get(dREMainActivityFragment7.P4).getString("name"));
                                textView6.setText(sb4.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("area", dREMainActivityFragment.F4, "name", dREMainActivityFragment.P4);
                                    }
                                };
                            } else if (i4 == 5) {
                                TextView textView7 = rippleTextViewHolder2.I;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("زمان : ");
                                DREMainActivityFragment dREMainActivityFragment8 = DREMainActivityFragment.this;
                                sb5.append(dREMainActivityFragment8.E4.get(dREMainActivityFragment8.N4).getString("name"));
                                textView7.setText(sb5.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("year", dREMainActivityFragment.E4, "name", dREMainActivityFragment.N4);
                                    }
                                };
                            } else if (i4 == 6) {
                                TextView textView8 = rippleTextViewHolder2.I;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("محدود کردن : ");
                                DREMainActivityFragment dREMainActivityFragment9 = DREMainActivityFragment.this;
                                sb6.append(dREMainActivityFragment9.I4.get(dREMainActivityFragment9.T4).getString("title"));
                                textView8.setText(sb6.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                        dREMainActivityFragment.s3("filter", dREMainActivityFragment.I4, "title", dREMainActivityFragment.T4);
                                    }
                                };
                            } else {
                                return;
                            }
                        }
                    } else if (i4 == 10) {
                        headerCellViewHolder = (HeaderCellViewHolder) viewHolder;
                        textView = headerCellViewHolder.I;
                        sb = new StringBuilder();
                    } else if (i4 == 9) {
                        accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder.I.setTextColor(DREMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                        if (DREMainActivityFragment.this.K4 > 0) {
                            accountTextViewHolder.J.setBackgroundColor(DREMainActivityFragment.this.b0().getColor(R.color.f168green_dark));
                            accountTextViewHolder.I.setText("ساخت امتحان");
                            materialRippleLayout = accountTextViewHolder.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    String str = StringUtils.splitByWholeSeparator(dREMainActivityFragment.G4.get(dREMainActivityFragment.Q4).getString("title"), StringUtils.SPACE)[0];
                                    String k3 = DREMainActivityFragment.this.k3(new Date());
                                    DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                                    String string = dREMainActivityFragment2.B4.get(dREMainActivityFragment2.L4).getString("name");
                                    DREMainActivityFragment dREMainActivityFragment3 = DREMainActivityFragment.this;
                                    String string2 = dREMainActivityFragment3.C4.get(dREMainActivityFragment3.M4).getString("name");
                                    DREMainActivityFragment dREMainActivityFragment4 = DREMainActivityFragment.this;
                                    String string3 = dREMainActivityFragment4.J4.get(dREMainActivityFragment4.S4).getString("title");
                                    String p3 = DREMainActivityFragment.this.p3();
                                    DREMainActivityFragment dREMainActivityFragment5 = DREMainActivityFragment.this;
                                    CompressHelper compressHelper = dREMainActivityFragment5.k4;
                                    Bundle bundle = dREMainActivityFragment5.h4;
                                    ArrayList<Bundle> V = compressHelper.V(bundle, "Select id from questions where " + p3 + " order by random() limit " + str);
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<Bundle> it2 = V.iterator();
                                    while (it2.hasNext()) {
                                        arrayList.add(it2.next().getString("id"));
                                    }
                                    String join = StringUtils.join((Iterable<?>) arrayList, ",");
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add("Reading");
                                    arrayList2.add("Testing");
                                    DREMainActivityFragment dREMainActivityFragment6 = DREMainActivityFragment.this;
                                    CompressHelper compressHelper2 = dREMainActivityFragment6.k4;
                                    Bundle bundle2 = dREMainActivityFragment6.h4;
                                    compressHelper2.m(bundle2, "Insert into Tests (id, qIds, createdDate, qIndex, done, mode, right, wrong, subject, system, hard) values (null, '" + join + "', '" + k3 + "', 0, 0, '" + ((String) arrayList2.get(DREMainActivityFragment.this.R4)) + "', 0, 0, '" + string + "', '" + string2 + "', '" + string3 + "')");
                                    DREMainActivityFragment dREMainActivityFragment7 = DREMainActivityFragment.this;
                                    CompressHelper compressHelper3 = dREMainActivityFragment7.k4;
                                    String string4 = compressHelper3.s1(compressHelper3.V(dREMainActivityFragment7.h4, "SELECT id FROM Tests ORDER BY id DESC LIMIT 1")).getString("id");
                                    DREMainActivityFragment dREMainActivityFragment8 = DREMainActivityFragment.this;
                                    CompressHelper compressHelper4 = dREMainActivityFragment8.k4;
                                    Bundle bundle3 = dREMainActivityFragment8.h4;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("test-");
                                    sb.append(string4);
                                    compressHelper4.A1(bundle3, sb.toString(), (String[]) null, (String) null);
                                }
                            };
                        }
                        accountTextViewHolder.J.setBackgroundColor(DREMainActivityFragment.this.b0().getColor(R.color.f279material_grey_700));
                        accountTextViewHolder.I.setText("سوالی وجود ندارد");
                        return;
                    } else {
                        RippleTextViewHolder rippleTextViewHolder3 = (RippleTextViewHolder) viewHolder;
                        rippleTextViewHolder3.I.setTypeface(ResourcesCompat.j(dREMainActivityFragment2.r(), R.font.f782iransans));
                        if (i4 == 0) {
                            TextView textView9 = rippleTextViewHolder3.I;
                            DREMainActivityFragment dREMainActivityFragment10 = DREMainActivityFragment.this;
                            textView9.setText(dREMainActivityFragment10.G4.get(dREMainActivityFragment10.Q4).getString("title"));
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("numberquestion", dREMainActivityFragment.G4, "title", dREMainActivityFragment.Q4);
                                }
                            };
                        } else if (i4 == 1) {
                            TextView textView10 = rippleTextViewHolder3.I;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("حالت آزمون : ");
                            DREMainActivityFragment dREMainActivityFragment11 = DREMainActivityFragment.this;
                            sb7.append(dREMainActivityFragment11.H4.get(dREMainActivityFragment11.R4).getString("title"));
                            textView10.setText(sb7.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("testMode", dREMainActivityFragment.H4, "title", dREMainActivityFragment.R4);
                                }
                            };
                        } else if (i4 == 2) {
                            TextView textView11 = rippleTextViewHolder3.I;
                            DREMainActivityFragment dREMainActivityFragment12 = DREMainActivityFragment.this;
                            textView11.setText(dREMainActivityFragment12.B4.get(dREMainActivityFragment12.L4).getString("name"));
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("subject", dREMainActivityFragment.B4, "name", dREMainActivityFragment.L4);
                                }
                            };
                        } else if (i4 == 3) {
                            TextView textView12 = rippleTextViewHolder3.I;
                            DREMainActivityFragment dREMainActivityFragment13 = DREMainActivityFragment.this;
                            textView12.setText(dREMainActivityFragment13.C4.get(dREMainActivityFragment13.M4).getString("name"));
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("system", dREMainActivityFragment.C4, "name", dREMainActivityFragment.M4);
                                }
                            };
                        } else if (i4 == 4) {
                            TextView textView13 = rippleTextViewHolder3.I;
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("نوع سوالات : ");
                            DREMainActivityFragment dREMainActivityFragment14 = DREMainActivityFragment.this;
                            sb8.append(dREMainActivityFragment14.D4.get(dREMainActivityFragment14.O4).getString("name"));
                            textView13.setText(sb8.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("type", dREMainActivityFragment.D4, "name", dREMainActivityFragment.O4);
                                }
                            };
                        } else if (i4 == 5) {
                            TextView textView14 = rippleTextViewHolder3.I;
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("منطقه : ");
                            DREMainActivityFragment dREMainActivityFragment15 = DREMainActivityFragment.this;
                            sb9.append(dREMainActivityFragment15.F4.get(dREMainActivityFragment15.P4).getString("name"));
                            textView14.setText(sb9.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("area", dREMainActivityFragment.F4, "name", dREMainActivityFragment.P4);
                                }
                            };
                        } else if (i4 == 6) {
                            TextView textView15 = rippleTextViewHolder3.I;
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("زمان : ");
                            DREMainActivityFragment dREMainActivityFragment16 = DREMainActivityFragment.this;
                            sb10.append(dREMainActivityFragment16.E4.get(dREMainActivityFragment16.N4).getString("name"));
                            textView15.setText(sb10.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("year", dREMainActivityFragment.E4, "name", dREMainActivityFragment.N4);
                                }
                            };
                        } else if (i4 == 7) {
                            TextView textView16 = rippleTextViewHolder3.I;
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append("محدود کردن : ");
                            DREMainActivityFragment dREMainActivityFragment17 = DREMainActivityFragment.this;
                            sb11.append(dREMainActivityFragment17.I4.get(dREMainActivityFragment17.T4).getString("title"));
                            textView16.setText(sb11.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("filter", dREMainActivityFragment.I4, "title", dREMainActivityFragment.T4);
                                }
                            };
                        } else if (i4 == 8) {
                            TextView textView17 = rippleTextViewHolder3.I;
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append("سختی : ");
                            DREMainActivityFragment dREMainActivityFragment18 = DREMainActivityFragment.this;
                            sb12.append(dREMainActivityFragment18.J4.get(dREMainActivityFragment18.S4).getString("title"));
                            textView17.setText(sb12.toString());
                            materialRippleLayout = rippleTextViewHolder3.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.s3("hardness", dREMainActivityFragment.J4, "title", dREMainActivityFragment.S4);
                                }
                            };
                        } else {
                            return;
                        }
                    }
                    sb.append(DREMainActivityFragment.this.K4);
                    sb.append(" سوال ");
                    textView.setText(sb.toString());
                    headerCellViewHolder.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                    return;
                } else if (string.equals("آزمون های قبلی")) {
                    RippleTextViewHolder rippleTextViewHolder4 = (RippleTextViewHolder) viewHolder;
                    rippleTextViewHolder4.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                    if (i4 == 0) {
                        rippleTextViewHolder4.I.setText("آخرین آزمون");
                        materialRippleLayout = rippleTextViewHolder4.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                CompressHelper compressHelper;
                                Bundle bundle;
                                StringBuilder sb;
                                String str;
                                DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                CompressHelper compressHelper2 = dREMainActivityFragment.k4;
                                Bundle s1 = compressHelper2.s1(compressHelper2.V(dREMainActivityFragment.h4, "Select * from tests order by id desc limit 1"));
                                if (s1 == null) {
                                    CompressHelper.x2(DREMainActivityFragment.this.r(), "تا الان آزمونی نساختید", 0);
                                    return;
                                }
                                if (s1.getString("done").equals(IcyHeaders.a3)) {
                                    DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                                    compressHelper = dREMainActivityFragment2.k4;
                                    bundle = dREMainActivityFragment2.h4;
                                    sb = new StringBuilder();
                                    str = "testresult-";
                                } else {
                                    DREMainActivityFragment dREMainActivityFragment3 = DREMainActivityFragment.this;
                                    compressHelper = dREMainActivityFragment3.k4;
                                    bundle = dREMainActivityFragment3.h4;
                                    sb = new StringBuilder();
                                    str = "test-";
                                }
                                sb.append(str);
                                sb.append(s1.getString("id"));
                                compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                            }
                        };
                    } else if (i4 == 1) {
                        rippleTextViewHolder4.I.setText("آزمون های پیشین");
                        materialRippleLayout = rippleTextViewHolder4.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                dREMainActivityFragment.k4.N(DRETestsListActivity.class, DRETestsListActivityFragment.class, dREMainActivityFragment.l3("0"));
                            }
                        };
                    } else {
                        return;
                    }
                } else if (string.equals("تنظیمات")) {
                    AccountTextViewHolder accountTextViewHolder2 = (AccountTextViewHolder) viewHolder;
                    accountTextViewHolder2.I.setTypeface(ResourcesCompat.j(DREMainActivityFragment.this.r(), R.font.f782iransans));
                    accountTextViewHolder2.I.setTextColor(DREMainActivityFragment.this.b0().getColor(R.color.f469white));
                    accountTextViewHolder2.I.setText("پاک کردن تاریخچه");
                    accountTextViewHolder2.J.setBackgroundColor(DREMainActivityFragment.this.b0().getColor(R.color.f453red));
                    materialRippleLayout = accountTextViewHolder2.J;
                    onClickListener = new View.OnClickListener() {
                        public void onClick(View view) {
                            new AlertDialog.Builder(DREMainActivityFragment.this.r(), R.style.f2185alertDialogTheme).l("This will delete all tests and history").y("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                    dREMainActivityFragment.k4.m(dREMainActivityFragment.h4, "delete from logs");
                                    DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                                    dREMainActivityFragment2.k4.m(dREMainActivityFragment2.h4, "delete from tests");
                                    DREMainActivityFragment dREMainActivityFragment3 = DREMainActivityFragment.this;
                                    dREMainActivityFragment3.k4.m(dREMainActivityFragment3.h4, "delete from flags");
                                }
                            }).p("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }).I();
                        }
                    };
                } else {
                    return;
                }
                materialRippleLayout.setOnClickListener(onClickListener);
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new HeaderCellViewHolder(LayoutInflater.from(DREMainActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 1) {
                return new RippleTextViewHolder(LayoutInflater.from(DREMainActivityFragment.this.r()).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            if (i2 == 2) {
                return new RippleTextViewHolder(LayoutInflater.from(DREMainActivityFragment.this.r()).inflate(R.layout.f1351list_view_item_ripple_text_list, viewGroup, false));
            }
            if (i2 == 3) {
                return new AccountTextViewHolder(LayoutInflater.from(DREMainActivityFragment.this.r()).inflate(R.layout.f1298list_view_item_account_text, viewGroup, false));
            } else if (i2 != 4) {
                return null;
            } else {
                return new HeaderCellViewHolder(LayoutInflater.from(DREMainActivityFragment.this.r()).inflate(R.layout.f1321list_view_item_footer, viewGroup, false));
            }
        }

        public int b() {
            DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
            return dREMainActivityFragment.t3(dREMainActivityFragment.A4);
        }
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        O2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        boolean z = true;
        ((AppBarLayout) this.q4.findViewById(R.id.f825appbar)).D(true, false);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        this.B4 = this.k4.V(this.h4, "select 0 as id,'تمام دروس' as name , sum(count) as count,0 o from lessons union select id, name,count, 1 o from lessons order by o,name");
        ArrayList<Bundle> V = this.k4.V(this.h4, "select 0 as id, 'تمام بخش ها' as name , sum(count) as count,0 o from divisions union select id, name,count,1 o from divisions order by o,name");
        this.C4 = V;
        if (V != null) {
            z = false;
        }
        this.U4 = z;
        this.D4 = this.k4.V(this.h4, "select 'تمام امتحان ها' as name,0 o from questions union select distinct(type) as name,1 o from questions order by o asc,name desc");
        this.E4 = this.k4.V(this.h4, "select 'تمام سال ها' as name,0 o from questions union select distinct(year) as name,1 o from questions order by o,name");
        this.F4 = this.k4.V(this.h4, "select 'تمام مناطق' as name,0 o from questions union select distinct(area) as name,1 o from questions order by o,name");
        this.G4 = new ArrayList<>();
        for (int i2 = 0; i2 < 101; i2++) {
            ArrayList<Bundle> arrayList = this.G4;
            arrayList.add(m3(i2 + " سوال "));
        }
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        this.H4 = arrayList2;
        arrayList2.add(m3("مطالعه"));
        this.H4.add(m3("امتحان"));
        if (!this.U4) {
            ArrayList<Bundle> arrayList3 = new ArrayList<>();
            this.J4 = arrayList3;
            arrayList3.add(o3("تمام سوالات", "0", "100"));
            this.J4.add(o3("آسان", "75", "100"));
            this.J4.add(o3("متوسط", "50", "75"));
            this.J4.add(o3("سخت", "25", "50"));
            this.J4.add(o3("خیلی سخت", "0", "25"));
        }
        ArrayList<Bundle> arrayList4 = new ArrayList<>();
        this.I4 = arrayList4;
        arrayList4.add(n3("تمام سوالات", ""));
        this.I4.add(n3("زده نشده", "not (id in (select distinct qid from logs))"));
        this.I4.add(n3("نادرست", "id in (select qid from (select qid,max(rowid),selectedanswer<>corrAnswer as res from logs group by qid) where res=1) "));
        this.I4.add(n3("انتخاب شده", "id in (select qid from flags)"));
        o2(false);
        ArrayList<String> arrayList5 = new ArrayList<>();
        this.A4 = arrayList5;
        arrayList5.add("سوالات");
        this.A4.add("ساخت آزمون");
        this.A4.add("آزمون های قبلی");
        this.A4.add("تنظیمات");
        this.m4 = new ContentSearchAdapter(r(), this.o4, "text", "subText") {
            public void d0(RecyclerView.ViewHolder viewHolder, int i2, Bundle bundle) {
                String str;
                StringBuilder sb;
                String str2;
                RippleSearchContentViewHolder rippleSearchContentViewHolder = (RippleSearchContentViewHolder) viewHolder;
                rippleSearchContentViewHolder.I.setText(bundle.getString("text"));
                final String string = bundle.getString("type");
                final String string2 = bundle.getString("contentId");
                if (string.equals("0")) {
                    rippleSearchContentViewHolder.J.setVisibility(8);
                    rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                            CompressHelper compressHelper = dREMainActivityFragment.k4;
                            Bundle bundle = dREMainActivityFragment.h4;
                            compressHelper.A1(bundle, "question-" + string2, (String[]) null, (String) null);
                        }
                    });
                    return;
                }
                if (string.equals(IcyHeaders.a3)) {
                    sb = new StringBuilder();
                    sb.append("<font color=\"red\">");
                    str2 = "Question";
                } else if (string.equals(ExifInterface.Y4)) {
                    sb = new StringBuilder();
                    sb.append("<font color=\"red\">");
                    str2 = "Explanation";
                } else if (string.equals(ExifInterface.Z4)) {
                    sb = new StringBuilder();
                    sb.append("<font color=\"red\">");
                    str2 = "Answer";
                } else {
                    str = "";
                    final String str3 = str + StringUtils.SPACE + bundle.getString("subText");
                    rippleSearchContentViewHolder.J.setText(Html.fromHtml(str3));
                    rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (string.equals(ExifInterface.Y4)) {
                                DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                                CompressHelper compressHelper = dREMainActivityFragment.k4;
                                Bundle bundle = dREMainActivityFragment.h4;
                                compressHelper.A1(bundle, "answer-" + string2, DREMainActivityFragment.this.T2(str3), (String) null);
                                return;
                            }
                            DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                            CompressHelper compressHelper2 = dREMainActivityFragment2.k4;
                            Bundle bundle2 = dREMainActivityFragment2.h4;
                            compressHelper2.A1(bundle2, "question-" + string2, DREMainActivityFragment.this.T2(str3), (String) null);
                        }
                    });
                }
                sb.append(str2);
                sb.append("</font>");
                str = sb.toString();
                final String str32 = str + StringUtils.SPACE + bundle.getString("subText");
                rippleSearchContentViewHolder.J.setText(Html.fromHtml(str32));
                rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (string.equals(ExifInterface.Y4)) {
                            DREMainActivityFragment dREMainActivityFragment = DREMainActivityFragment.this;
                            CompressHelper compressHelper = dREMainActivityFragment.k4;
                            Bundle bundle = dREMainActivityFragment.h4;
                            compressHelper.A1(bundle, "answer-" + string2, DREMainActivityFragment.this.T2(str32), (String) null);
                            return;
                        }
                        DREMainActivityFragment dREMainActivityFragment2 = DREMainActivityFragment.this;
                        CompressHelper compressHelper2 = dREMainActivityFragment2.k4;
                        Bundle bundle2 = dREMainActivityFragment2.h4;
                        compressHelper2.A1(bundle2, "question-" + string2, DREMainActivityFragment.this.T2(str32), (String) null);
                    }
                });
            }
        };
        j3();
        UWAdapter uWAdapter = new UWAdapter();
        this.l4 = uWAdapter;
        this.w4.setAdapter(uWAdapter);
        N2();
        return this.q4;
    }

    public void X2() {
        this.m4.f0(this.o4);
        this.w4.setAdapter(this.m4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public Bundle i3(int i2, ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Text", next);
                bundle.putString("Type", "Header");
                return bundle;
            }
            int q3 = i3 + q3(next);
            if (i2 <= q3) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("Section", next);
                bundle2.putInt("Index", (i2 - (q3 - q3(next))) - 1);
                bundle2.putString("Type", "Item");
                return bundle2;
            }
            i3 = q3 + 1;
        }
        return null;
    }

    public void j3() {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "select count(*) as c from questions where " + p3()));
        this.K4 = s1 == null ? 0 : Integer.valueOf(s1.getString("c")).intValue();
    }

    public String k3(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ").format(date);
    }

    public Bundle l3(String str) {
        Bundle bundle = new Bundle();
        bundle.putBundle("DB", this.h4);
        bundle.putString("ParentId", str);
        return bundle;
    }

    public Bundle m3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        return bundle;
    }

    public Bundle n3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("sql", str2);
        return bundle;
    }

    public Bundle o3(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("Min", str2);
        bundle.putString("Max", str3);
        return bundle;
    }

    public String p3() {
        ArrayList arrayList = new ArrayList();
        String string = this.B4.get(this.L4).getString("id");
        String string2 = !this.U4 ? this.C4.get(this.M4).getString("id") : "";
        String string3 = this.D4.get(this.O4).getString("name");
        String string4 = this.E4.get(this.N4).getString("name");
        String string5 = this.F4.get(this.P4).getString("name");
        if (!this.U4) {
            String string6 = this.J4.get(this.S4).getString("Min");
            String string7 = this.J4.get(this.S4).getString("Max");
            arrayList.add("CorrPerc > " + string6);
            arrayList.add("CorrPerc < " + string7);
        }
        String string8 = this.I4.get(this.T4).getString("sql");
        if (!string.equals("0")) {
            arrayList.add("lessonId = " + string);
        }
        if (!this.U4 && !string2.equals("0")) {
            arrayList.add("divId = " + string2);
        }
        if (!string3.equals("تمام امتحان ها")) {
            arrayList.add("type = '" + string3 + "'");
        }
        if (!string4.equals("تمام سال ها")) {
            arrayList.add("Year = '" + string4 + "'");
        }
        if (!string5.equals("تمام مناطق")) {
            arrayList.add("area = '" + string5 + "'");
        }
        if (string8.length() > 0) {
            arrayList.add(string8);
        }
        if (arrayList.size() == 0) {
            arrayList.add("1=1");
        }
        return StringUtils.join((Iterable<?>) arrayList, " AND ");
    }

    public int q3(String str) {
        if (str.equals("سوالات")) {
            return 2;
        }
        if (str.equals("ساخت آزمون")) {
            return this.U4 ? 9 : 11;
        }
        if (str.equals("آزمون های قبلی")) {
            return 2;
        }
        return str.equals("تنظیمات") ? 1 : 0;
    }

    public void r3(String str, Bundle bundle, int i2) {
        if (str.equals("filter")) {
            this.T4 = i2;
        } else if (str.equals("hardness")) {
            this.S4 = i2;
        } else if (str.equals("testMode")) {
            this.R4 = i2;
        } else if (str.equals("numberquestion")) {
            this.Q4 = i2;
        } else if (str.equals("system")) {
            this.M4 = i2;
        } else if (str.equals("subject")) {
            this.L4 = i2;
        } else if (str.equals("year")) {
            this.N4 = i2;
        } else if (str.equals("area")) {
            this.P4 = i2;
        } else if (str.equals("type")) {
            this.O4 = i2;
        }
        j3();
        this.l4.G();
    }

    public void s3(String str, ArrayList<Bundle> arrayList, String str2, int i2) {
        DRESelectDialog dRESelectDialog = new DRESelectDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Items", arrayList);
        bundle.putString("TitleProperty", str2);
        bundle.putInt("Position", i2);
        bundle.putString("Type", str);
        dRESelectDialog.A2(this, 0);
        dRESelectDialog.i2(bundle);
        dRESelectDialog.Z2(true);
        dRESelectDialog.e3(M(), "asdfasdfasdf");
    }

    public int t3(ArrayList<String> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + q3(it2.next()) + 1;
        }
        return i2;
    }
}
