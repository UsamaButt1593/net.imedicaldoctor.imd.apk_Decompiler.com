package net.imedicaldoctor.imd.Fragments.UWorld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.Fragments.UWorld.BackupCodesDialog;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleSearchContentViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class UWMainActivityFragment extends SearchHelperFragment {
    public ArrayList<String> A4;
    public ArrayList<Bundle> B4;
    public ArrayList<Bundle> C4;
    public ArrayList<Bundle> D4;
    public ArrayList<Bundle> E4;
    public ArrayList<Bundle> F4;
    public ArrayList<Bundle> G4;
    public ArrayList<Bundle> H4;
    public int I4 = 0;
    public String J4;
    public int K4 = 40;
    public int L4 = 0;
    public int M4 = 0;
    public int N4 = 0;
    public ArrayList<Integer> O4;
    public ArrayList<Integer> P4;
    public ArrayList<Integer> Q4;
    private final String R4 = "Questions";
    private final String S4 = "Create A Test";
    private final String T4 = "Previous Tests";
    private final String U4 = "Settings";
    private final String V4 = "subject";
    private final String W4 = "system";
    private final String X4 = "numberquestion";
    private final String Y4 = "testMode";
    private final String Z4 = "filter";
    private final String a5 = "hardness";
    private final String b5 = "sort";
    private final String c5 = "uwfilters.dat";
    private final String d5 = "unusedsince.dat";
    private final String e5 = "backupstate.dat";
    private ArrayList<String> f5;
    public String g5;
    /* access modifiers changed from: private */
    public Boolean h5;
    /* access modifiers changed from: private */
    public Boolean i5;
    /* access modifiers changed from: private */
    public Boolean j5;
    /* access modifiers changed from: private */
    public EditText k5;
    /* access modifiers changed from: private */
    public String l5 = "";

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

    public class NumberInputFilter implements InputFilter {
        public NumberInputFilter() {
        }

        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuilder sb = new StringBuilder();
            while (i2 < i3) {
                if (String.valueOf(charSequence.charAt(i2)).matches("[0-9,]*")) {
                    sb.append(charSequence.charAt(i2));
                }
                i2++;
            }
            return sb.toString();
        }
    }

    public class QIDsViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final EditText I;

        public QIDsViewHolder(View view) {
            super(view);
            this.I = (EditText) view.findViewById(R.id.f1047qids_edit_text);
        }
    }

    public class UWAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        private final int f29963d = 0;

        /* renamed from: e  reason: collision with root package name */
        private final int f29964e = 4;

        /* renamed from: f  reason: collision with root package name */
        private final int f29965f = 1;

        /* renamed from: g  reason: collision with root package name */
        private final int f29966g = 2;

        /* renamed from: h  reason: collision with root package name */
        private final int f29967h = 3;

        /* renamed from: i  reason: collision with root package name */
        private final int f29968i = 5;

        public UWAdapter() {
        }

        public int C(int i2) {
            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
            Bundle j3 = uWMainActivityFragment.j3(i2, uWMainActivityFragment.A4);
            if (!j3.getString("Type").equals("Header") && j3.getString("Type").equals("Item")) {
                String string = j3.getString("Section");
                int i3 = j3.getInt("Index");
                if (string.equals("Questions")) {
                    return 1;
                }
                if (string.equals("Create A Test")) {
                    if (i3 == 9) {
                        return 4;
                    }
                    if (i3 == 8) {
                        return 3;
                    }
                    return i3 == 7 ? 5 : 2;
                } else if (string.equals("Previous Tests")) {
                    return 1;
                } else {
                    if (string.equals("Settings")) {
                        return 3;
                    }
                }
            }
            return 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            View.OnClickListener onClickListener;
            MaterialRippleLayout materialRippleLayout;
            TextView i0;
            TextView i02;
            String str;
            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
            Bundle j3 = uWMainActivityFragment.j3(i2, uWMainActivityFragment.A4);
            if (j3.getString("Type").equals("Header")) {
                ((HeaderCellViewHolder) viewHolder).I.setText(j3.getString("Text"));
            }
            if (j3.getString("Type").equals("Item")) {
                String string = j3.getString("Section");
                int i3 = j3.getInt("Index");
                if (string.equals("Questions")) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    if (i3 == 0) {
                        rippleTextViewHolder.I.setText("Browse Questions");
                        materialRippleLayout = rippleTextViewHolder.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                uWMainActivityFragment.k4.N(UWTocActivity.class, UWTocActivityFragment.class, uWMainActivityFragment.z3("0"));
                            }
                        };
                    } else if (i3 == 1) {
                        rippleTextViewHolder.I.setText("Favorite Questions");
                        materialRippleLayout = rippleTextViewHolder.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                uWMainActivityFragment.k4.N(UWTocActivity.class, UWTocActivityFragment.class, uWMainActivityFragment.z3(ExifInterface.Z4));
                            }
                        };
                    } else {
                        return;
                    }
                } else if (string.equals("Create A Test")) {
                    if (i3 == 9) {
                        i02 = ((HeaderCellViewHolder) viewHolder).I;
                        str = UWMainActivityFragment.this.I4 + " Questions Found";
                    } else if (i3 == 8) {
                        AccountTextViewHolder accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        if (UWMainActivityFragment.this.I4 > 0) {
                            accountTextViewHolder.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f168green_dark));
                            accountTextViewHolder.I.setText(UWMainActivityFragment.this.g5);
                            materialRippleLayout = accountTextViewHolder.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    UWMainActivityFragment.this.v3();
                                }
                            };
                        } else {
                            accountTextViewHolder.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f279material_grey_700));
                            i02 = accountTextViewHolder.I;
                            str = "No Question Available";
                        }
                    } else if (i3 == 7) {
                        QIDsViewHolder qIDsViewHolder = (QIDsViewHolder) viewHolder;
                        EditText unused = UWMainActivityFragment.this.k5 = qIDsViewHolder.I;
                        qIDsViewHolder.I.setFilters(new InputFilter[]{new NumberInputFilter()});
                        qIDsViewHolder.I.addTextChangedListener(new TextWatcher() {
                            public void afterTextChanged(Editable editable) {
                                UWMainActivityFragment.this.s3();
                                UWMainActivityFragment.this.l4.H(13);
                                UWMainActivityFragment.this.l4.H(12);
                            }

                            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                            }

                            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                String unused = UWMainActivityFragment.this.l5 = charSequence.toString();
                            }
                        });
                        return;
                    } else {
                        RippleTextViewHolder rippleTextViewHolder2 = (RippleTextViewHolder) viewHolder;
                        rippleTextViewHolder2.f15587a.getLayoutParams().height = -2;
                        rippleTextViewHolder2.f15587a.setVisibility(0);
                        if (i3 == 0) {
                            TextView textView = rippleTextViewHolder2.I;
                            UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                            textView.setText(uWMainActivityFragment2.D4.get(uWMainActivityFragment2.K4).getString("title"));
                            materialRippleLayout = rippleTextViewHolder2.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                    uWMainActivityFragment.S3("numberquestion", uWMainActivityFragment.D4, "title", uWMainActivityFragment.K4);
                                }
                            };
                        } else if (i3 == 1) {
                            TextView textView2 = rippleTextViewHolder2.I;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Test Mode : ");
                            UWMainActivityFragment uWMainActivityFragment3 = UWMainActivityFragment.this;
                            sb.append(uWMainActivityFragment3.E4.get(uWMainActivityFragment3.L4).getString("title"));
                            textView2.setText(sb.toString());
                            materialRippleLayout = rippleTextViewHolder2.J;
                            onClickListener = new View.OnClickListener() {
                                public void onClick(View view) {
                                    UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                    uWMainActivityFragment.S3("testMode", uWMainActivityFragment.E4, "title", uWMainActivityFragment.L4);
                                }
                            };
                        } else {
                            if (i3 == 2) {
                                if (UWMainActivityFragment.this.i5.booleanValue()) {
                                    TextView textView3 = rippleTextViewHolder2.I;
                                    UWMainActivityFragment uWMainActivityFragment4 = UWMainActivityFragment.this;
                                    textView3.setText(CompressHelper.O1(uWMainActivityFragment4.L3(uWMainActivityFragment4.B4, uWMainActivityFragment4.O4, "name"), 300));
                                    materialRippleLayout = rippleTextViewHolder2.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                            uWMainActivityFragment.R3("subject", uWMainActivityFragment.B4, "name", uWMainActivityFragment.O4);
                                        }
                                    };
                                }
                            } else if (i3 == 3) {
                                if (UWMainActivityFragment.this.j5.booleanValue()) {
                                    TextView textView4 = rippleTextViewHolder2.I;
                                    UWMainActivityFragment uWMainActivityFragment5 = UWMainActivityFragment.this;
                                    textView4.setText(CompressHelper.O1(uWMainActivityFragment5.L3(uWMainActivityFragment5.C4, uWMainActivityFragment5.P4, "name"), 300));
                                    materialRippleLayout = rippleTextViewHolder2.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                            uWMainActivityFragment.R3("system", uWMainActivityFragment.C4, "name", uWMainActivityFragment.P4);
                                        }
                                    };
                                }
                            } else if (i3 == 4) {
                                TextView textView5 = rippleTextViewHolder2.I;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Filter : ");
                                UWMainActivityFragment uWMainActivityFragment6 = UWMainActivityFragment.this;
                                sb2.append(uWMainActivityFragment6.L3(uWMainActivityFragment6.F4, uWMainActivityFragment6.Q4, "title"));
                                textView5.setText(sb2.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                        uWMainActivityFragment.R3("filter", uWMainActivityFragment.F4, "title", uWMainActivityFragment.Q4);
                                    }
                                };
                            } else if (i3 == 5) {
                                if (UWMainActivityFragment.this.h5.booleanValue()) {
                                    TextView textView6 = rippleTextViewHolder2.I;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Difficulty: ");
                                    UWMainActivityFragment uWMainActivityFragment7 = UWMainActivityFragment.this;
                                    sb3.append(uWMainActivityFragment7.G4.get(uWMainActivityFragment7.M4).getString("title"));
                                    textView6.setText(sb3.toString());
                                    materialRippleLayout = rippleTextViewHolder2.J;
                                    onClickListener = new View.OnClickListener() {
                                        public void onClick(View view) {
                                            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                            uWMainActivityFragment.S3("hardness", uWMainActivityFragment.G4, "title", uWMainActivityFragment.M4);
                                        }
                                    };
                                }
                            } else if (i3 == 6) {
                                TextView textView7 = rippleTextViewHolder2.I;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Sort By: ");
                                UWMainActivityFragment uWMainActivityFragment8 = UWMainActivityFragment.this;
                                sb4.append(uWMainActivityFragment8.H4.get(uWMainActivityFragment8.N4).getString("title"));
                                textView7.setText(sb4.toString());
                                materialRippleLayout = rippleTextViewHolder2.J;
                                onClickListener = new View.OnClickListener() {
                                    public void onClick(View view) {
                                        UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                        uWMainActivityFragment.S3("sort", uWMainActivityFragment.H4, "title", uWMainActivityFragment.N4);
                                    }
                                };
                            } else {
                                return;
                            }
                            rippleTextViewHolder2.f15587a.getLayoutParams().height = 0;
                            rippleTextViewHolder2.f15587a.setVisibility(8);
                            rippleTextViewHolder2.f15587a.requestLayout();
                            return;
                        }
                    }
                    i02.setText(str);
                    return;
                } else if (string.equals("Previous Tests")) {
                    RippleTextViewHolder rippleTextViewHolder3 = (RippleTextViewHolder) viewHolder;
                    if (i3 == 0) {
                        rippleTextViewHolder3.I.setText("Last Test");
                        materialRippleLayout = rippleTextViewHolder3.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                CompressHelper compressHelper;
                                Bundle bundle;
                                StringBuilder sb;
                                String str;
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                CompressHelper compressHelper2 = uWMainActivityFragment.k4;
                                Bundle s1 = compressHelper2.s1(compressHelper2.V(uWMainActivityFragment.h4, "Select * from tests order by id desc limit 1"));
                                if (s1 == null) {
                                    CompressHelper.x2(UWMainActivityFragment.this.r(), "You haven't created any test yet", 0);
                                    return;
                                }
                                if (s1.getString("done").equals(IcyHeaders.a3)) {
                                    UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                                    compressHelper = uWMainActivityFragment2.k4;
                                    bundle = uWMainActivityFragment2.h4;
                                    sb = new StringBuilder();
                                    str = "testresult-";
                                } else {
                                    UWMainActivityFragment uWMainActivityFragment3 = UWMainActivityFragment.this;
                                    compressHelper = uWMainActivityFragment3.k4;
                                    bundle = uWMainActivityFragment3.h4;
                                    sb = new StringBuilder();
                                    str = "test-";
                                }
                                sb.append(str);
                                sb.append(s1.getString("id"));
                                compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                            }
                        };
                    } else if (i3 == 1) {
                        rippleTextViewHolder3.I.setText("Previous Tests");
                        materialRippleLayout = rippleTextViewHolder3.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                uWMainActivityFragment.k4.N(UWTestsListActivity.class, UWTestsListActivityFragment.class, uWMainActivityFragment.z3("0"));
                            }
                        };
                    } else if (i3 == 2) {
                        rippleTextViewHolder3.I.setText("Your Progress");
                        materialRippleLayout = rippleTextViewHolder3.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                uWMainActivityFragment.k4.A1(uWMainActivityFragment.h4, "progress", (String[]) null, (String) null);
                            }
                        };
                    } else {
                        return;
                    }
                } else if (!string.equals("Settings")) {
                    return;
                } else {
                    if (i3 == 0) {
                        AccountTextViewHolder accountTextViewHolder2 = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder2.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder2.I.setText("Reset History");
                        accountTextViewHolder2.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f453red));
                        materialRippleLayout = accountTextViewHolder2.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                new AlertDialog.Builder(UWMainActivityFragment.this.r(), R.style.f2185alertDialogTheme).l("This will delete all tests and history").y("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                        uWMainActivityFragment.k4.m(uWMainActivityFragment.h4, "delete from logs");
                                        UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                                        uWMainActivityFragment2.k4.m(uWMainActivityFragment2.h4, "delete from tests");
                                        UWMainActivityFragment uWMainActivityFragment3 = UWMainActivityFragment.this;
                                        uWMainActivityFragment3.k4.m(uWMainActivityFragment3.h4, "delete from flags");
                                        UWMainActivityFragment.this.s3();
                                        UWMainActivityFragment.this.V3(11);
                                    }
                                }).p("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        };
                    } else if (i3 == 1) {
                        AccountTextViewHolder accountTextViewHolder3 = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder3.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder3.I.setText("Delete Favorites & Highlights");
                        accountTextViewHolder3.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f364material_orange_800));
                        materialRippleLayout = accountTextViewHolder3.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                new AlertDialog.Builder(UWMainActivityFragment.this.r(), R.style.f2185alertDialogTheme).l("This will delete all favorites and highlights of this database.").y("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        CompressHelper compressHelper = UWMainActivityFragment.this.k4;
                                        String X0 = compressHelper.X0();
                                        compressHelper.q(X0, "delete from favorites where dbName='" + UWMainActivityFragment.this.h4.getString("Name").replace("'", "''") + "'");
                                        UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                        CompressHelper compressHelper2 = uWMainActivityFragment.k4;
                                        String E3 = uWMainActivityFragment.E3();
                                        compressHelper2.q(E3, "delete from highlight where dbName='" + UWMainActivityFragment.this.h4.getString("Name").replace("'", "''") + "'");
                                        CompressHelper.x2(UWMainActivityFragment.this.r(), "Favorites & Highlights Deleted.", 1);
                                    }
                                }).p("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        };
                    } else if (i3 == 2) {
                        AccountTextViewHolder accountTextViewHolder4 = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder4.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder4.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f167green));
                        String str2 = "Backup Data";
                        accountTextViewHolder4.I.setText(str2);
                        if (UWMainActivityFragment.this.J4.length() == 0) {
                            i0 = accountTextViewHolder4.I;
                        } else {
                            i0 = accountTextViewHolder4.I;
                            str2 = UWMainActivityFragment.this.J4;
                        }
                        i0.setText(str2);
                        materialRippleLayout = accountTextViewHolder4.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                if (UWMainActivityFragment.this.J4.length() <= 0) {
                                    new AlertDialog.Builder(UWMainActivityFragment.this.r(), R.style.f2185alertDialogTheme).l("This will backup your test history, favorites and highlights to the iMD Server and will give you a identifier to restore it later.").y("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                            final ProgressDialog show = ProgressDialog.show(UWMainActivityFragment.this.r(), "Backing up", "Please wait...", true);
                                            UWMainActivityFragment.this.i3(new Consumer<String>() {
                                                /* renamed from: a */
                                                public void accept(String str) throws Throwable {
                                                    show.dismiss();
                                                    UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                                    uWMainActivityFragment.J4 = "Backup identifier : " + str;
                                                    UWMainActivityFragment.this.M3();
                                                    UWMainActivityFragment.this.V3(11);
                                                }
                                            }, new Consumer<String>() {
                                                /* renamed from: a */
                                                public void accept(String str) throws Throwable {
                                                    show.dismiss();
                                                    CompressHelper.x2(UWMainActivityFragment.this.r(), str, 1);
                                                }
                                            });
                                        }
                                    }).p("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).I();
                                }
                            }
                        };
                    } else if (i3 == 3) {
                        AccountTextViewHolder accountTextViewHolder5 = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder5.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder5.I.setText("Restore With Code");
                        accountTextViewHolder5.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f160dark_blue));
                        materialRippleLayout = accountTextViewHolder5.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                final EditText editText = new EditText(UWMainActivityFragment.this.r());
                                editText.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f140black));
                                new AlertDialog.Builder(UWMainActivityFragment.this.r(), R.style.f2185alertDialogTheme).l("Enter Backup Identifier. This will delete test history, favorites and highlights of this database from this device").setView(editText).y("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        String obj = editText.getText().toString();
                                        if (obj.length() == 0) {
                                            CompressHelper.x2(UWMainActivityFragment.this.r(), "You must enter a backup identifier", 1);
                                        } else {
                                            UWMainActivityFragment.this.k3(obj);
                                        }
                                    }
                                }).p("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }).I();
                            }
                        };
                    } else if (i3 == 4) {
                        AccountTextViewHolder accountTextViewHolder6 = (AccountTextViewHolder) viewHolder;
                        accountTextViewHolder6.I.setTextColor(UWMainActivityFragment.this.b0().getColor(R.color.f469white));
                        accountTextViewHolder6.I.setText("List of Backups");
                        accountTextViewHolder6.J.setBackgroundColor(UWMainActivityFragment.this.b0().getColor(R.color.f253material_deep_purple_900));
                        materialRippleLayout = accountTextViewHolder6.J;
                        onClickListener = new View.OnClickListener() {
                            public void onClick(View view) {
                                final ProgressDialog show = ProgressDialog.show(UWMainActivityFragment.this.r(), "Loading Backup Codes", "Please wait...", true);
                                UWMainActivityFragment.this.k4.o0("LoadBackupCodesZip|||||" + UWMainActivityFragment.this.k4.y1()).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                                    /* renamed from: a */
                                    public void accept(String str) throws Throwable {
                                        String M0 = CompressHelper.M0(str);
                                        if (M0.length() == 0) {
                                            show.dismiss();
                                            CompressHelper.x2(UWMainActivityFragment.this.r(), "No backup codes found", 1);
                                            return;
                                        }
                                        String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(M0, "|||");
                                        if (splitByWholeSeparatorPreserveAllTokens == null || splitByWholeSeparatorPreserveAllTokens.length == 0) {
                                            show.dismiss();
                                            CompressHelper.x2(UWMainActivityFragment.this.r(), "No backup codes found", 1);
                                            return;
                                        }
                                        ArrayList arrayList = new ArrayList();
                                        for (String splitByWholeSeparatorPreserveAllTokens2 : splitByWholeSeparatorPreserveAllTokens) {
                                            String[] splitByWholeSeparatorPreserveAllTokens3 = StringUtils.splitByWholeSeparatorPreserveAllTokens(splitByWholeSeparatorPreserveAllTokens2, ",,,");
                                            Bundle bundle = new Bundle();
                                            bundle.putString(DublinCoreProperties.f27398d, splitByWholeSeparatorPreserveAllTokens3[0]);
                                            bundle.putString(HTML.Tag.g0, splitByWholeSeparatorPreserveAllTokens3[1]);
                                            bundle.putString("title", splitByWholeSeparatorPreserveAllTokens3[2]);
                                            arrayList.add(bundle);
                                        }
                                        show.dismiss();
                                        BackupCodesDialog.a(UWMainActivityFragment.this.r(), arrayList, new BackupCodesDialog.BackupCodeSelectedListener() {
                                            public void a(final String str) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(UWMainActivityFragment.this.r(), R.style.f2185alertDialogTheme);
                                                builder.l("Are you sure you want to restore code '" + str + "'. This will delete test history, favorites and highlights of this database from this device").y("Yes", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                                        String str = str;
                                                        if (str.length() == 0) {
                                                            CompressHelper.x2(UWMainActivityFragment.this.r(), "You must enter a backup identifier", 1);
                                                        } else {
                                                            UWMainActivityFragment.this.k3(str);
                                                        }
                                                    }
                                                }).p("No", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                                    }
                                                }).I();
                                            }
                                        });
                                    }
                                }, new Consumer<Throwable>() {
                                    /* renamed from: a */
                                    public void accept(Throwable th) throws Throwable {
                                        show.dismiss();
                                        CompressHelper.x2(UWMainActivityFragment.this.r(), "Error in contacting server", 1);
                                    }
                                });
                            }
                        };
                    } else {
                        return;
                    }
                }
                materialRippleLayout.setOnClickListener(onClickListener);
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new HeaderCellViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 1) {
                return new RippleTextViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            if (i2 == 2) {
                return new RippleTextViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1351list_view_item_ripple_text_list, viewGroup, false));
            }
            if (i2 == 3) {
                return new AccountTextViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1298list_view_item_account_text, viewGroup, false));
            } else if (i2 == 4) {
                return new HeaderCellViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1321list_view_item_footer, viewGroup, false));
            } else {
                if (i2 != 5) {
                    return null;
                }
                return new QIDsViewHolder(LayoutInflater.from(UWMainActivityFragment.this.r()).inflate(R.layout.f1333list_view_item_qids, viewGroup, false));
            }
        }

        public int b() {
            UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
            return uWMainActivityFragment.T3(uWMainActivityFragment.A4);
        }

        public void d0(int i2) {
            for (int i3 = 0; i3 < b(); i3++) {
                if (i3 != i2) {
                    H(i3);
                }
            }
        }
    }

    private String F3() {
        try {
            File file = new File(CompressHelper.u1(this.h4, "backupstate.dat"));
            if (!file.exists()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            String str = (String) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void G3() {
        try {
            File file = new File(CompressHelper.u1(this.h4, "uwfilters.dat"));
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                this.M4 = objectInputStream.readInt();
                this.L4 = objectInputStream.readInt();
                this.K4 = objectInputStream.readInt();
                this.O4 = (ArrayList) objectInputStream.readObject();
                this.P4 = (ArrayList) objectInputStream.readObject();
                this.Q4 = (ArrayList) objectInputStream.readObject();
                this.N4 = objectInputStream.readInt();
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void H3() {
        try {
            File file = new File(CompressHelper.u1(this.h4, "unusedsince.dat"));
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                this.f5 = (ArrayList) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void M3() {
        try {
            File file = new File(CompressHelper.u1(this.h4, "backupstate.dat"));
            String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "|" + this.k4.V(this.h4, "select count(*) c from logs").get(0).getString("c");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(str);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void N3() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(CompressHelper.u1(this.h4, "uwfilters.dat")));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(this.M4);
            objectOutputStream.writeInt(this.L4);
            objectOutputStream.writeInt(this.K4);
            objectOutputStream.writeObject(this.O4);
            objectOutputStream.writeObject(this.P4);
            objectOutputStream.writeObject(this.Q4);
            objectOutputStream.writeInt(this.N4);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O3() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(CompressHelper.u1(this.h4, "unusedsince.dat")));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.f5);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean Q3() {
        try {
            if (!V1().getSharedPreferences("default_preferences", 0).getBoolean("qbankbackup", true)) {
                return false;
            }
            String F3 = F3();
            if (F3.length() == 0) {
                return true;
            }
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(F3, "|");
            return !new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(splitByWholeSeparator[0]) && !this.k4.V(this.h4, "select count(*) c from logs").get(0).getString("c").equals(splitByWholeSeparator[1]);
        } catch (Exception unused) {
        }
    }

    private void r3() {
        if (Q3()) {
            this.k4.R0(new Runnable() {
                public void run() {
                    UWMainActivityFragment.this.i3(new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                            UWMainActivityFragment.this.M3();
                        }
                    }, new Consumer<String>() {
                        /* renamed from: a */
                        public void accept(String str) throws Throwable {
                        }
                    });
                }
            }, new Runnable() {
                public void run() {
                }
            });
        }
    }

    public Bundle A3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        return bundle;
    }

    public Bundle B3(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("sql", str2);
        return bundle;
    }

    public Bundle C3(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("Min", str2);
        bundle.putString("Max", str3);
        return bundle;
    }

    public String D3() {
        String string = this.G4.get(this.M4).getString("Min");
        String string2 = this.G4.get(this.M4).getString("Max");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Integer> it2 = this.O4.iterator();
        while (it2.hasNext()) {
            String string3 = this.B4.get(it2.next().intValue()).getString("id");
            if (!string3.equals("0")) {
                arrayList2.add("(subId = " + string3 + ")");
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add("(" + StringUtils.join((Iterable<?>) arrayList2, " OR ") + ")");
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<Integer> it3 = this.P4.iterator();
        while (it3.hasNext()) {
            String string4 = this.C4.get(it3.next().intValue()).getString("id");
            if (!string4.equals("0")) {
                arrayList3.add("(sysId = " + string4 + ")");
            }
        }
        if (arrayList3.size() > 0) {
            arrayList.add("(" + StringUtils.join((Iterable<?>) arrayList3, " OR ") + ")");
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator<Integer> it4 = this.Q4.iterator();
        while (it4.hasNext()) {
            String string5 = this.F4.get(it4.next().intValue()).getString("sql");
            if (string5.equals("UnusedNow")) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                this.f5.add(format);
                O3();
                u3();
                string5 = "not (id in (select distinct qid from logs where length(answerDate)>10 and answerDate > '" + format + "'))";
            }
            if (string5.length() > 0) {
                arrayList4.add("(" + string5 + ")");
            }
        }
        if (arrayList4.size() > 0) {
            arrayList.add("(" + StringUtils.join((Iterable<?>) arrayList4, " AND ") + ")");
        }
        arrayList.add("(corrTaken / pplTaken)*100 >= " + string);
        arrayList.add("(corrTaken / pplTaken)*100 <= " + string2);
        if (!this.l5.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.add("(id in (" + x3(this.l5) + "))");
        }
        String join = StringUtils.join((Iterable<?>) arrayList, " AND ");
        Log.d("UW", "Final Query : " + join);
        return join;
    }

    public String E3() {
        String str = this.k4.M1() + "/highlights.db";
        if (!new File(str).exists()) {
            SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null).execSQL("create virtual table highlight using fts4 (dbName, dbTitle, dbAddress, dbDate, dbDocName, type, text, note, save)");
        }
        return str;
    }

    public int I3(String str) {
        if (str.equals("Questions")) {
            return 2;
        }
        if (str.equals("Create A Test")) {
            return 10;
        }
        if (str.equals("Previous Tests")) {
            return 3;
        }
        return str.equals("Settings") ? 5 : 0;
    }

    public void J3(String str, ArrayList<Integer> arrayList) {
        if (str.equals("filter")) {
            this.Q4 = arrayList;
        } else if (!str.equals("hardness") && !str.equals("testMode") && !str.equals("numberquestion")) {
            if (str.equals("system")) {
                this.P4 = arrayList;
            } else if (str.equals("subject")) {
                this.O4 = arrayList;
            }
        }
        s3();
        V3(11);
    }

    public void K3(String str, Bundle bundle, int i2) {
        if (!str.equals("filter")) {
            if (str.equals("hardness")) {
                this.M4 = i2;
            } else if (str.equals("testMode")) {
                this.L4 = i2;
            } else if (str.equals("numberquestion")) {
                this.K4 = i2;
            } else if (!str.equals("system") && !str.equals("subject") && str.equals("sort")) {
                this.N4 = i2;
            }
        }
        s3();
        V3(11);
    }

    public String L3(ArrayList<Bundle> arrayList, ArrayList<Integer> arrayList2, String str) {
        ArrayList arrayList3 = new ArrayList();
        Iterator<Integer> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(arrayList.get(it2.next().intValue()).getString(str));
        }
        return StringUtils.join((Iterable<?>) arrayList3, " | ");
    }

    public void P3() {
        iMDLogger.d("sendFavorite", "Sending FavoriteChanged message");
        Intent intent = new Intent("net.imedicaldoctor.imd.favorite");
        intent.putExtra("Test", "Random data for test");
        LocalBroadcastManager.b(r()).d(intent);
    }

    public void R3(String str, ArrayList<Bundle> arrayList, String str2, ArrayList<Integer> arrayList2) {
        CheckDialog checkDialog = new CheckDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Items", arrayList);
        bundle.putString("TitleProperty", str2);
        bundle.putIntegerArrayList("Positions", arrayList2);
        bundle.putString("Type", str);
        checkDialog.A2(this, 0);
        checkDialog.i2(bundle);
        checkDialog.Z2(true);
        checkDialog.e3(M(), "asdfasdfasdf");
    }

    public void S3(String str, ArrayList<Bundle> arrayList, String str2, int i2) {
        SelectDialog selectDialog = new SelectDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Items", arrayList);
        bundle.putString("TitleProperty", str2);
        bundle.putInt("Position", i2);
        bundle.putString("Type", str);
        selectDialog.A2(this, 0);
        selectDialog.i2(bundle);
        selectDialog.Z2(true);
        selectDialog.e3(M(), "asdfasdfasdf");
    }

    public int T3(ArrayList<String> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + I3(it2.next()) + 1;
        }
        return i2;
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        this.g5 = "Let's Go";
        this.J4 = "";
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        O2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.O4 = new ArrayList<>();
        this.P4 = new ArrayList<>();
        this.Q4 = new ArrayList<>();
        this.O4.add(0);
        this.P4.add(0);
        this.Q4.add(0);
        ((AppBarLayout) this.q4.findViewById(R.id.f825appbar)).D(true, false);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        try {
            this.h5 = Boolean.valueOf(!this.k4.V(this.h4, "select count(distinct  corrTaken) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3));
            this.i5 = Boolean.valueOf(!this.k4.V(this.h4, "select count(distinct  subId) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3));
            this.j5 = Boolean.valueOf(!this.k4.V(this.h4, "select count(distinct  sysId) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3));
            this.B4 = this.k4.V(this.h4, "select 0 as id,'All Subjects' as name , sum(count) as count from subjects union select id, name,count from subjects");
            this.C4 = this.k4.V(this.h4, "select 0 as id, 'All Systems' as name , sum(count) as count from systems union select id, name,count from systems");
            this.D4 = new ArrayList<>();
            for (int i2 = 0; i2 < 1001; i2++) {
                ArrayList<Bundle> arrayList = this.D4;
                arrayList.add(A3(i2 + " Questions"));
            }
            H3();
            if (this.f5 == null) {
                this.f5 = new ArrayList<>();
            }
            u3();
            ArrayList<Bundle> arrayList2 = new ArrayList<>();
            this.E4 = arrayList2;
            arrayList2.add(A3("Reading"));
            this.E4.add(A3("Testing (Timed)"));
            ArrayList<Bundle> arrayList3 = new ArrayList<>();
            this.G4 = arrayList3;
            arrayList3.add(C3("All", "0", "100"));
            this.G4.add(C3("Easy", "75", "100"));
            this.G4.add(C3("Fair", "50", "75"));
            this.G4.add(C3("Hard", "25", "50"));
            this.G4.add(C3("Extreme !", "0", "25"));
            ArrayList<Bundle> arrayList4 = new ArrayList<>();
            this.H4 = arrayList4;
            arrayList4.add(A3("Random"));
            this.H4.add(A3("QID"));
            o2(false);
            ArrayList<String> arrayList5 = new ArrayList<>();
            this.A4 = arrayList5;
            arrayList5.add("Questions");
            this.A4.add("Create A Test");
            this.A4.add("Previous Tests");
            this.A4.add("Settings");
            G3();
            if (this.O4 == null) {
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                this.O4 = arrayList6;
                arrayList6.add(0);
            }
            if (this.P4 == null) {
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                this.P4 = arrayList7;
                arrayList7.add(0);
            }
            if (this.Q4 == null) {
                ArrayList<Integer> arrayList8 = new ArrayList<>();
                this.Q4 = arrayList8;
                arrayList8.add(0);
            }
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
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                CompressHelper compressHelper = uWMainActivityFragment.k4;
                                Bundle bundle = uWMainActivityFragment.h4;
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
                                    UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                    CompressHelper compressHelper = uWMainActivityFragment.k4;
                                    Bundle bundle = uWMainActivityFragment.h4;
                                    compressHelper.A1(bundle, "answer-" + string2, UWMainActivityFragment.this.T2(str3), (String) null);
                                    return;
                                }
                                UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                                CompressHelper compressHelper2 = uWMainActivityFragment2.k4;
                                Bundle bundle2 = uWMainActivityFragment2.h4;
                                compressHelper2.A1(bundle2, "question-" + string2, UWMainActivityFragment.this.T2(str3), (String) null);
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
                                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                                CompressHelper compressHelper = uWMainActivityFragment.k4;
                                Bundle bundle = uWMainActivityFragment.h4;
                                compressHelper.A1(bundle, "answer-" + string2, UWMainActivityFragment.this.T2(str32), (String) null);
                                return;
                            }
                            UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                            CompressHelper compressHelper2 = uWMainActivityFragment2.k4;
                            Bundle bundle2 = uWMainActivityFragment2.h4;
                            compressHelper2.A1(bundle2, "question-" + string2, UWMainActivityFragment.this.T2(str32), (String) null);
                        }
                    });
                }
            };
            s3();
            UWAdapter uWAdapter = new UWAdapter();
            this.l4 = uWAdapter;
            this.w4.setAdapter(uWAdapter);
            N2();
            y3();
            r3();
        } catch (Exception unused) {
            this.k4.w2("Main database can't be found. you must delete and redownload the database.", new Runnable() {
                public void run() {
                    UWMainActivityFragment.this.k4.Z1(true);
                    UWMainActivityFragment.this.k4.Z1(false);
                }
            });
        }
        return this.q4;
    }

    public ArrayList<String> U3(ArrayList<String> arrayList, int i2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            i3 += next.split(",").length;
            if (i3 > i2) {
                break;
            }
            arrayList2.add(next);
        }
        return arrayList2;
    }

    public void V3(int i2) {
        ((UWAdapter) this.l4).d0(i2);
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

    public void g1() {
        super.g1();
        N3();
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public void i3(final Consumer<String> consumer, final Consumer<String> consumer2) {
        String s0 = this.k4.s0(CompressHelper.f1(this.h4), "select qid, selectedAnswer, corrAnswer, answerDate, time, testId from logs", "qid,selectedAnswer,corrAnswer,answerDate,time,testId", (Bundle) null);
        String s02 = this.k4.s0(CompressHelper.f1(this.h4), "select id,qIds, createdDate, qIndex, done, mode, right, wrong, subject, system, hard from tests", "id,qIds,createdDate,qIndex,done,mode,right,wrong,subject,system,hard", (Bundle) null);
        CompressHelper compressHelper = this.k4;
        String X0 = compressHelper.X0();
        String s03 = compressHelper.s0(X0, "select dbName,dbTitle,dbAddress,dbDate,dbDocName from favorites where dbName='" + this.h4.getString("Name").replace("'", "''") + "'", "dbName,dbTitle,dbAddress,dbDate,dbDocName", (Bundle) null);
        Bundle bundle = new Bundle();
        bundle.putString("text", "");
        CompressHelper compressHelper2 = this.k4;
        String E3 = E3();
        String s04 = compressHelper2.s0(E3, "select dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save from highlight where dbName = '" + this.h4.getString("Name").replace("'", "''") + "'", "dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save", bundle);
        try {
            String G0 = CompressHelper.G0(s0 + "###" + s02 + "###" + s03 + "###" + s04);
            this.k4.o0("SaveToFileZip|||||" + G0 + "|||||" + this.k4.y1() + "|||||" + this.h4.getString("Title")).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
                /* renamed from: a */
                public void accept(String str) throws Throwable {
                    consumer.accept(str);
                }
            }, new Consumer<Throwable>() {
                /* renamed from: a */
                public void accept(Throwable th) throws Throwable {
                    consumer2.accept("Error in contacting server");
                }
            });
        } catch (Exception e2) {
            FragmentActivity r = r();
            CompressHelper.x2(r, "Error in compressing data. " + e2.getMessage(), 1);
        }
    }

    public Bundle j3(int i2, ArrayList<String> arrayList) {
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
            int I3 = i3 + I3(next);
            if (i2 <= I3) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("Section", next);
                bundle2.putInt("Index", (i2 - (I3 - I3(next))) - 1);
                bundle2.putString("Type", "Item");
                return bundle2;
            }
            i3 = I3 + 1;
        }
        return null;
    }

    public void k3(String str) {
        final ProgressDialog show = ProgressDialog.show(r(), "Restoring", "Please wait...", true);
        this.k4.o0("LoadFromFileZip|||||" + str).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                CompressHelper compressHelper;
                String str2;
                String f1;
                String str3;
                String M0 = CompressHelper.M0(str);
                if (M0.length() == 0) {
                    show.dismiss();
                    CompressHelper.x2(UWMainActivityFragment.this.r(), "Identifier not found", 1);
                    return;
                }
                String[] splitByWholeSeparatorPreserveAllTokens = StringUtils.splitByWholeSeparatorPreserveAllTokens(M0, "###");
                if (UWMainActivityFragment.this.k4.t(splitByWholeSeparatorPreserveAllTokens[0]) != 6) {
                    show.dismiss();
                    CompressHelper.x2(UWMainActivityFragment.this.r(), "This backup code is not created here.", 1);
                    return;
                }
                UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                uWMainActivityFragment.k4.m(uWMainActivityFragment.h4, "Delete from logs");
                UWMainActivityFragment uWMainActivityFragment2 = UWMainActivityFragment.this;
                uWMainActivityFragment2.k4.m(uWMainActivityFragment2.h4, "Delete from tests");
                CompressHelper compressHelper2 = UWMainActivityFragment.this.k4;
                String X0 = compressHelper2.X0();
                compressHelper2.q(X0, "delete from favorites where dbName='" + UWMainActivityFragment.this.h4.getString("Name").replace("'", "''") + "'");
                UWMainActivityFragment uWMainActivityFragment3 = UWMainActivityFragment.this;
                CompressHelper compressHelper3 = uWMainActivityFragment3.k4;
                String E3 = uWMainActivityFragment3.E3();
                compressHelper3.q(E3, "delete from highlight where dbName='" + UWMainActivityFragment.this.h4.getString("Name").replace("'", "''") + "'");
                UWMainActivityFragment uWMainActivityFragment4 = UWMainActivityFragment.this;
                uWMainActivityFragment4.k4.m0(splitByWholeSeparatorPreserveAllTokens[0], CompressHelper.f1(uWMainActivityFragment4.h4), "logs", "qid,selectedAnswer,corrAnswer,answerDate,time,testId", (Bundle) null);
                int t = UWMainActivityFragment.this.k4.t(splitByWholeSeparatorPreserveAllTokens[1]);
                if (t == 11) {
                    UWMainActivityFragment uWMainActivityFragment5 = UWMainActivityFragment.this;
                    compressHelper = uWMainActivityFragment5.k4;
                    str2 = splitByWholeSeparatorPreserveAllTokens[1];
                    f1 = CompressHelper.f1(uWMainActivityFragment5.h4);
                    str3 = "id,qIds,createdDate,qIndex,done,mode,right,wrong,subject,system,hard";
                } else {
                    if (t == 10) {
                        UWMainActivityFragment uWMainActivityFragment6 = UWMainActivityFragment.this;
                        compressHelper = uWMainActivityFragment6.k4;
                        str2 = splitByWholeSeparatorPreserveAllTokens[1];
                        f1 = CompressHelper.f1(uWMainActivityFragment6.h4);
                        str3 = "qIds,createdDate,qIndex,done,mode,right,wrong,subject,system,hard";
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("dbName", UWMainActivityFragment.this.h4.getString("Name"));
                    bundle.putString("dbTitle", UWMainActivityFragment.this.h4.getString("Title"));
                    CompressHelper compressHelper4 = UWMainActivityFragment.this.k4;
                    Bundle bundle2 = bundle;
                    compressHelper4.m0(splitByWholeSeparatorPreserveAllTokens[2], compressHelper4.X0(), "favorites", "dbName,dbTitle,dbAddress,dbDate,dbDocName", bundle2);
                    UWMainActivityFragment uWMainActivityFragment7 = UWMainActivityFragment.this;
                    uWMainActivityFragment7.k4.m0(splitByWholeSeparatorPreserveAllTokens[3], uWMainActivityFragment7.E3(), "highlight", "dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save", bundle2);
                    UWMainActivityFragment.this.y3();
                    show.dismiss();
                    CompressHelper.x2(UWMainActivityFragment.this.r(), "Restore was successful", 1);
                    UWMainActivityFragment.this.s3();
                    UWMainActivityFragment.this.V3(11);
                    UWMainActivityFragment.this.P3();
                }
                compressHelper.m0(str2, f1, "tests", str3, (Bundle) null);
                Bundle bundle3 = new Bundle();
                bundle3.putString("dbName", UWMainActivityFragment.this.h4.getString("Name"));
                bundle3.putString("dbTitle", UWMainActivityFragment.this.h4.getString("Title"));
                CompressHelper compressHelper42 = UWMainActivityFragment.this.k4;
                Bundle bundle22 = bundle3;
                compressHelper42.m0(splitByWholeSeparatorPreserveAllTokens[2], compressHelper42.X0(), "favorites", "dbName,dbTitle,dbAddress,dbDate,dbDocName", bundle22);
                UWMainActivityFragment uWMainActivityFragment72 = UWMainActivityFragment.this;
                uWMainActivityFragment72.k4.m0(splitByWholeSeparatorPreserveAllTokens[3], uWMainActivityFragment72.E3(), "highlight", "dbName,dbTitle,dbAddress,dbDate,dbDocName,type,text,note,save", bundle22);
                UWMainActivityFragment.this.y3();
                show.dismiss();
                CompressHelper.x2(UWMainActivityFragment.this.r(), "Restore was successful", 1);
                UWMainActivityFragment.this.s3();
                UWMainActivityFragment.this.V3(11);
                UWMainActivityFragment.this.P3();
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                show.dismiss();
                CompressHelper.x2(UWMainActivityFragment.this.r(), "Error in contacting server", 1);
            }
        });
    }

    public void s3() {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "select count(*) as c from questions where " + D3()));
        this.I4 = s1 == null ? 0 : Integer.valueOf(s1.getString("c")).intValue();
    }

    public String t3(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ").format(date);
    }

    public void u3() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        this.F4 = arrayList;
        arrayList.add(B3("All Questions", ""));
        this.F4.add(B3("Unused", "not (id in (select distinct qid from logs))"));
        this.F4.add(B3("Incorrect", "id in (select qid from (select qid,max(rowid),selectedanswer<>corrAnswer as res from logs group by qid) where res=1) "));
        this.F4.add(B3("Correct", "id in (select qid from (select qid,max(rowid),selectedanswer=corrAnswer as res from logs group by qid) where res=1) "));
        this.F4.add(B3("Favorites", "id in (" + this.k4.j0("select group_concat(\"'\" || dbAddress || \"'\") as s from favorites where dbName = '" + this.h4.getString("Name") + "' and dbAddress NOT LIKE '%html-%'").get(0).getString("s").replace("question-", "").replace("answer-", "") + ")"));
        Iterator<String> it2 = this.f5.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            this.F4.add(B3("Unused Since " + next, "not (id in (select distinct qid from logs where length(answerDate)>10 and answerDate > '" + next + "'))"));
        }
        this.F4.add(B3("Unused Since Now", "UnusedNow"));
    }

    public void v3() {
        String str;
        CompressHelper compressHelper;
        Bundle bundle;
        StringBuilder sb;
        String str2;
        Iterator<Bundle> it2;
        if (this.g5.equals("Let's Go")) {
            N3();
            if (this.I4 == 0) {
                CompressHelper.x2(r(), "There is no questions matching your criteria", 0);
                return;
            }
            this.g5 = "Generating";
            this.l4.H(12);
            String str3 = StringUtils.splitByWholeSeparator(this.D4.get(this.K4).getString("title"), StringUtils.SPACE)[0];
            String t3 = t3(new Date());
            String L3 = L3(this.B4, this.O4, "name");
            String L32 = L3(this.C4, this.P4, "name");
            String string = this.G4.get(this.M4).getString("title");
            if (this.l5.isEmpty()) {
                String D3 = D3();
                if (this.N4 == 0) {
                    compressHelper = this.k4;
                    bundle = this.h4;
                    sb = new StringBuilder();
                    sb.append("Select id, parentqid as parentQId from questions where ");
                    sb.append(D3);
                    str2 = " order by random() limit ";
                } else {
                    compressHelper = this.k4;
                    bundle = this.h4;
                    sb = new StringBuilder();
                    sb.append("Select id, parentqid as parentQId from questions where ");
                    sb.append(D3);
                    str2 = " order by id limit ";
                }
                sb.append(str2);
                sb.append(str3);
                ArrayList<Bundle> V = compressHelper.V(bundle, sb.toString());
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                Iterator<Bundle> it3 = V.iterator();
                int i2 = 0;
                while (it3.hasNext()) {
                    Bundle next = it3.next();
                    String string2 = next.getString("parentQId");
                    if (string2.equals("0")) {
                        it2 = it3;
                        arrayList.add(next.getString("id"));
                        i2++;
                    } else if (!arrayList2.contains(string2)) {
                        CompressHelper compressHelper2 = this.k4;
                        Bundle bundle2 = this.h4;
                        StringBuilder sb2 = new StringBuilder();
                        it2 = it3;
                        sb2.append("SELECT count(*) as c, group_concat(id) as g FROM (SELECT id FROM questions WHERE parentqid =");
                        sb2.append(string2);
                        sb2.append(" ORDER BY CASE WHEN id =");
                        sb2.append(string2);
                        sb2.append(" THEN 0 ELSE 1 END, id);");
                        Bundle bundle3 = compressHelper2.V(bundle2, sb2.toString()).get(0);
                        i2 += Integer.valueOf(bundle3.getString("c")).intValue();
                        arrayList.add(bundle3.getString("g"));
                        arrayList2.add(string2);
                    } else {
                        it2 = it3;
                    }
                    it3 = it2;
                }
                if (i2 > Integer.valueOf(str3).intValue()) {
                    int intValue = i2 - Integer.valueOf(str3).intValue();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        String next2 = it4.next();
                        if (next2 != null && !next2.contains(",")) {
                            arrayList3.add(next2);
                        }
                    }
                    Collections.shuffle(arrayList3);
                    for (int i3 = 0; i3 < intValue && !arrayList3.isEmpty(); i3++) {
                        arrayList.remove(arrayList3.get(0));
                        arrayList3.remove(0);
                    }
                }
                if (this.N4 == 0) {
                    Collections.shuffle(arrayList);
                }
                if (i2 > Integer.valueOf(str3).intValue()) {
                    arrayList = U3(arrayList, Integer.valueOf(str3).intValue());
                }
                str = h.a(",", arrayList);
            } else {
                str = x3(this.l5);
            }
            CompressHelper compressHelper3 = this.k4;
            Bundle bundle4 = this.h4;
            compressHelper3.m(bundle4, "Insert into Tests (id, qIds, createdDate, qIndex, done, mode, right, wrong, subject, system, hard) values (null, '" + str + "', '" + t3 + "', 0, 0, '" + this.E4.get(this.L4).getString("title") + "', 0, 0, '" + w3(L3) + "', '" + w3(L32) + "', '" + w3(string) + "')");
            CompressHelper compressHelper4 = this.k4;
            String string3 = compressHelper4.s1(compressHelper4.V(this.h4, "SELECT id FROM Tests ORDER BY id DESC LIMIT 1")).getString("id");
            CompressHelper compressHelper5 = this.k4;
            Bundle bundle5 = this.h4;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("test-");
            sb3.append(string3);
            compressHelper5.A1(bundle5, sb3.toString(), (String[]) null, (String) null);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    UWMainActivityFragment uWMainActivityFragment = UWMainActivityFragment.this;
                    uWMainActivityFragment.g5 = "Let's Go";
                    uWMainActivityFragment.l4.H(12);
                }
            }, 1000);
        }
    }

    public String w3(String str) {
        return str.replace("'", "''");
    }

    public String x3(String str) {
        return str.replace(StringUtils.SPACE, "").replace(".", ",").replace("-", ",");
    }

    public void y3() {
        CompressHelper compressHelper = this.k4;
        String X0 = compressHelper.X0();
        compressHelper.q(X0, "delete from favorites where dbName='" + this.h4.getString("Name").replace("'", "''") + "' AND dbAddress like 'html-%'");
        ArrayList<Bundle> V = this.k4.V(this.h4, "select id,qIds from tests where score is null");
        if (V != null) {
            Iterator<Bundle> it2 = V.iterator();
            while (it2.hasNext()) {
                Bundle next = it2.next();
                String string = next.getString("id");
                String string2 = next.getString("qIds");
                CompressHelper compressHelper2 = this.k4;
                Bundle bundle = this.h4;
                int doubleValue = (int) ((Double.valueOf(compressHelper2.s1(compressHelper2.V(bundle, "select count(*) as c from logs where testId='" + string + "' and selectedAnswer=corrAnswer")).getString("c")).doubleValue() / ((double) StringUtils.splitByWholeSeparatorPreserveAllTokens(string2, ",").length)) * 100.0d);
                CompressHelper compressHelper3 = this.k4;
                Bundle bundle2 = this.h4;
                compressHelper3.m(bundle2, "Update tests set score='" + doubleValue + "' where id=" + string);
            }
        }
    }

    public Bundle z3(String str) {
        Bundle bundle = new Bundle();
        bundle.putBundle("DB", this.h4);
        bundle.putString("ParentId", str);
        return bundle;
    }
}
