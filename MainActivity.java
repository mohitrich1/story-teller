package com.example.offlinestoryteller;

import android.app.*;
import android.os.*;
import android.speech.tts.TextToSpeech;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    TextToSpeech tts;
    TextView story;
    String current;
    String[] titles = {"The Lantern in the Rain", "The Clever Sparrow", "The Hidden Garden"};
    String[] stories = {
      "One rainy evening, Aarav found a tiny lantern glowing beneath an old tree. The lantern seemed to brighten whenever he helped someone. He followed its warm light through the village and discovered a forgotten garden. Inside, he found no treasure of gold, but a place where everyone could plant a seed. Aarav understood that the best treasures are the ones that grow when shared. The next morning, the whole village began planting together.",
      "A little sparrow lived near a busy market. Every day, she watched people hurry past without noticing the small things around them. One afternoon, a strong wind scattered a farmer's seeds. The sparrow called her friends, and together they gathered the seeds before the rain came. The farmer was grateful. From that day, he left a small bowl of grain for every bird. The sparrow learned that even a tiny voice can start a big change.",
      "Mira discovered a locked gate behind her grandmother's house. Instead of forcing it open, she searched for the old key. After days of looking, she found it inside a book about flowers. Behind the gate was a beautiful garden that had been waiting for years. Mira cleaned the paths, planted new flowers, and invited the neighborhood children. Soon the forgotten garden became the happiest place in the street."
    };

    public void onCreate(Bundle b){
      super.onCreate(b);
      LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(32,40,32,24);
      TextView h=new TextView(this); h.setText("Offline Storyteller"); h.setTextSize(30); h.setTextColor(Color.rgb(50,35,80)); h.setGravity(Gravity.CENTER);
      root.addView(h,new LinearLayout.LayoutParams(-1,70));
      TextView sub=new TextView(this); sub.setText("Stories and narration without internet"); sub.setGravity(Gravity.CENTER); root.addView(sub,new LinearLayout.LayoutParams(-1,55));
      Spinner sp=new Spinner(this); ArrayAdapter<String> ad=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,titles); sp.setAdapter(ad); root.addView(sp);
      story=new TextView(this); story.setTextSize(18); story.setPadding(8,30,8,20); story.setText(stories[0]); ScrollView sv=new ScrollView(this); sv.addView(story); root.addView(sv,new LinearLayout.LayoutParams(-1,0,1));
      LinearLayout buttons=new LinearLayout(this); buttons.setGravity(Gravity.CENTER);
      Button read=new Button(this); read.setText("▶ Read Aloud"); Button stop=new Button(this); stop.setText("■ Stop");
      buttons.addView(read); buttons.addView(stop); root.addView(buttons);
      sp.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(){ public void onNothingSelected(android.widget.AdapterView<?> p){} public void onItemSelected(android.widget.AdapterView<?> p,View v,int pos,long id){ current=stories[pos]; story.setText(current); }});
      tts=new TextToSpeech(this,status->{});
      read.setOnClickListener(v->{ if(tts!=null){ tts.setLanguage(Locale.US); tts.speak(current,TextToSpeech.QUEUE_FLUSH,null,"story"); }});
      stop.setOnClickListener(v->{if(tts!=null)tts.stop();});
      setContentView(root);
    }
    protected void onDestroy(){ if(tts!=null){tts.stop();tts.shutdown();} super.onDestroy(); }
}