package com.kimdi.ai;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.content.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout box; TextView chat;
    int cyan=Color.rgb(0,217,255), white=Color.WHITE, gray=Color.rgb(170,180,195);
    public void onCreate(Bundle b){super.onCreate(b); showLogin();}
    TextView t(String s,int size){ TextView v=new TextView(this); v.setText(s); v.setTextColor(white); v.setTextSize(size); v.setPadding(18,12,18,12); return v; }
    Button btn(String s){ Button x=new Button(this); x.setText(s); x.setTextColor(white); x.setTextSize(15); return x; }
    void base(){ box=new LinearLayout(this); box.setOrientation(LinearLayout.VERTICAL); box.setPadding(22,30,22,20); box.setBackgroundColor(Color.rgb(5,7,11)); ScrollView sc=new ScrollView(this); sc.addView(box); setContentView(sc);}
    void showLogin(){base(); TextView logo=t("◉  KIMDI AI",30); logo.setTextColor(cyan); box.addView(logo); box.addView(t("YOUR AI ASSISTANT",14)); box.addView(t("\nورود به KIMDI AI\nبا حساب Google وارد شوید",22));
      Button g=btn("🔵  ورود با Google"); box.addView(g); g.setOnClickListener(v->showHome());
    }
    void showHome(){base(); TextView h=t("KIMDI AI",28);h.setTextColor(cyan);box.addView(h);box.addView(t("دستیار هوش مصنوعی شما",15));
      Button c=btn("💬  چت با AI"); Button im=btn("🎨  ساخت تصویر"); Button vo=btn("🎙️  حالت صدا"); Button st=btn("📚  کمک در درس‌ها"); Button tools=btn("🛠️  ابزارهای AI");
      box.addView(c);box.addView(im);box.addView(vo);box.addView(st);box.addView(tools);
      c.setOnClickListener(v->showChat()); im.setOnClickListener(v->showImage()); vo.setOnClickListener(v->showVoice()); st.setOnClickListener(v->showStudy()); tools.setOnClickListener(v->showTools());
    }
    void showChat(){base();box.addView(t("💬 چت KIMDI AI",25)); chat=t("سلام! من KIMDI AI هستم. سوالت رو بنویس 👋",17);box.addView(chat); EditText e=new EditText(this);e.setHint("پیامت را بنویس...");e.setTextColor(white);e.setHintTextColor(gray);box.addView(e);Button send=btn("ارسال");box.addView(send);send.setOnClickListener(v->{chat.setText("👤 "+e.getText()+"\n\n🤖 پاسخ آزمایشی KIMDI AI: برای پاسخ واقعی باید سرویس AI به برنامه متصل شود.");e.setText("");});Button back=btn("← بازگشت");box.addView(back);back.setOnClickListener(v->showHome());}
    void showImage(){base();box.addView(t("🎨 ساخت تصویر با AI",25));EditText e=new EditText(this);e.setHint("مثلاً: یک فوتبالیست در استادیوم آینده");e.setTextColor(white);e.setHintTextColor(gray);box.addView(e);Button b=btn("✨ تولید تصویر");box.addView(b);b.setOnClickListener(v->Toast.makeText(this,"برای تولید واقعی تصویر، API تصویر باید متصل شود.",Toast.LENGTH_LONG).show());Button back=btn("← بازگشت");box.addView(back);back.setOnClickListener(v->showHome());}
    void showVoice(){base();box.addView(t("🎙️ حالت صدا",25));box.addView(t("میکروفون و خواندن پاسخ با صدای دستگاه در نسخه کامل فعال می‌شود.",17));Button b=btn("🎤 فعال‌سازی میکروفون");box.addView(b);b.setOnClickListener(v->requestPermissions(new String[]{"android.permission.RECORD_AUDIO"},5));Button back=btn("← بازگشت");box.addView(back);back.setOnClickListener(v->showHome());}
    void showStudy(){base();box.addView(t("📚 دستیار درس",25));box.addView(t("موضوع را انتخاب کن:",17));for(String s:new String[]{"🇬🇧 انگلیسی","➗ ریاضی","🔬 علوم","📜 تاریخ"}){Button b=btn(s);box.addView(b);b.setOnClickListener(v->showChat());}Button back=btn("← بازگشت");box.addView(back);back.setOnClickListener(v->showHome());}
    void showTools(){base();box.addView(t("🛠️ ابزارهای AI",25));for(String s:new String[]{"ترجمه","خلاصه‌سازی","حل ریاضی","گرامر انگلیسی","ایده‌پردازی","بازنویسی متن"})box.addView(btn("✨ "+s));Button back=btn("← بازگشت");box.addView(back);back.setOnClickListener(v->showHome());}
}
