package com.amarena.rss.amarena_brawl.screens;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.Toast;

import com.amarena.rss.amarena_brawl.R;
import com.amarena.rss.amarena_brawl.models.Action;
import com.amarena.rss.amarena_brawl.models.Character;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class CustomisationActivity extends Activity {
    ImageView imag;
    boolean imageOn = false;
    TabHost tabHost;
    static Action selectedSpell;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customisation);

        // Mise en place du fragment des attaques
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAction, new ActionFragment());
        fragmentTransaction.commit();

        initTabHost();
        initSpells();
        initSpellsButtons();
    }

    public void initSpellsButtons(){
        imag = new ImageView(this);
        // -- Tables
        final TableLayout tableWizard = (TableLayout) findViewById( R.id.wizardSpellGridView );
        final TableLayout tableWarrior = (TableLayout) findViewById( R.id.warriorSpellGridView );
        final TableLayout tableArcher = (TableLayout) findViewById( R.id.archerSpellGridView );
        // --

        // -- Buttons config
        int buttonsInRow = 6;
        int numRows=6;

        int rowcount=0;
        // --

        // -- Layout
        LinearLayout[] tableRowLayoutWizard = new LinearLayout[numRows];
        LinearLayout[] tableRowLayoutWarrior = new LinearLayout[numRows];
        LinearLayout[] tableRowLayoutArcher = new LinearLayout[numRows];
        tableRowLayoutWizard[0] = new LinearLayout(tableWizard.getContext());
        tableRowLayoutWarrior[0] = new LinearLayout(tableWarrior.getContext());
        tableRowLayoutArcher[0] = new LinearLayout(tableArcher.getContext());
        // --


        ArrayList<Button> actionButtons = new ArrayList<>();
        List<Action> attacks = SugarRecord.listAll(Action.class);


        ArrayList<String> jobs = new ArrayList<>();
        for(Action action : attacks){
            if(!jobs.contains(action.getProfession().name())){
                jobs.add(action.getProfession().name());
            }
        }
        System.out.println("JOBS : ");
        for(String job : jobs){
            if(job.equals("WIZARD")){
                for(Action action : attacks){
                    if(action.getProfession().name().equals(job)){
                        addButtons(numRows,buttonsInRow,action,tableWizard,tableRowLayoutWizard);
                    }

                }
                if(rowcount<numRows)
                    tableWizard.addView(tableRowLayoutWizard[rowcount]);
            }else if(job.equals("WARRIOR")){
                for(Action action : attacks){
                    if(action.getProfession().name().equals(job)){
                        addButtons(numRows,buttonsInRow,action,tableWarrior,tableRowLayoutWarrior);
                    }

                }
                if(rowcount<numRows)
                    tableWarrior.addView(tableRowLayoutWarrior[rowcount]);
            }
            else if(job.equals("ARCHER")){
                for(Action action : attacks){
                    if(action.getProfession().name().equals(job)){
                        addButtons(numRows,buttonsInRow,action,tableWarrior,tableRowLayoutArcher);
                    }

                }
                if(rowcount<numRows)
                    tableArcher.addView(tableRowLayoutArcher[rowcount]);
            }
        }
        // --



        // --
    }

    public void addButtons(int numRows,int buttonsInRow,final Action action,TableLayout table,LinearLayout[] tableRowLayout){
        int rowcount=0;
        int cpt = 0;
        ImageButton[] buttons = new ImageButton[numRows*buttonsInRow];
        final String s = "ATTAQUE :"+action.getProfession()+"-"+action.getName();
        buttons[cpt] = new ImageButton(table.getContext(), null, android.R.attr.buttonStyleSmall);
        String spellName = "icon";
        int resID = getResources().getIdentifier(spellName , "drawable", getPackageName());
        buttons[cpt].setImageDrawable(ContextCompat.getDrawable(this,resID));
        buttons[cpt].setId(cpt);
        buttons[cpt].setVisibility(View.VISIBLE); 
        buttons[cpt].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text = s;
                int duration = Toast.LENGTH_SHORT;
                selectedSpell = action;
                System.out.println("Selected spell is : "+selectedSpell.getName());
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tableRowLayout[rowcount].addView(buttons[cpt], buttonLayoutParams);
        if (((cpt+1)%buttonsInRow==0)&&(cpt!=0)){

            table.addView(tableRowLayout[rowcount++]);
            if(rowcount<numRows)
                tableRowLayout[rowcount] = new LinearLayout(table.getContext());
        }
        cpt++;
    }


    public void initButtons(){
        imag = new ImageView(this);
        final TableLayout table = (TableLayout) findViewById( R.id.wizardSpellGridView );
        int buttonsInRow = 7;
        int numRows=6;
        Button[] buttons = new Button[7*6];

        LinearLayout[] tablerowLayout = new LinearLayout[numRows];
        tablerowLayout[0] = new LinearLayout(table.getContext());
        int rowcount=0;

        for (int i=0; i<(7*6) ;i++){
            buttons[i]= new Button(table.getContext(), null, android.R.attr.buttonStyleSmall);
            buttons[i].setText("ded");
            buttons[i].setId(i);
            buttons[i].setTextColor(Color.BLACK);
            buttons[i].setVisibility(View.VISIBLE);
            buttons[i].setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    Context context = getApplicationContext();
                    CharSequence text = "Hello toast!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }});
            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            tablerowLayout[rowcount].addView(buttons[i], buttonLayoutParams);

            if (((i+1)%buttonsInRow==0)&&(i!=0)){

                table.addView(tablerowLayout[rowcount++]);
                if(rowcount<numRows)
                    tablerowLayout[rowcount] = new LinearLayout(table.getContext());
            }
        }
        if(rowcount<numRows)
            table.addView(tablerowLayout[rowcount]);
    }
    public void initTabHost(){
        // General tab host
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Wizard tab
        TabHost.TabSpec spec = host.newTabSpec("Wizard");
        spec.setContent(R.id.wizardLayout);
        spec.setIndicator("Wizard");
        host.addTab(spec);

        //Warrior tab
        spec = host.newTabSpec("Warrior");
        spec.setContent(R.id.warriorLayout);
        spec.setIndicator("Warrior");
        host.addTab(spec);

        //Archer tab
        spec = host.newTabSpec("Archer");
        spec.setContent(R.id.archerLayout);
        spec.setIndicator("Archer");
        host.addTab(spec);
    }
    public void initSpells(){
        ImageButton spell = new ImageButton(this);
        spell.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.fireball));
        //GridView wizardGridView = (GridView) findViewById(R.id.wizardSpellGridView);
        //wizardGridView.addView(spell);
    }

    public static Action getSelectedSpell() {
        return selectedSpell;
    }

    public static void setSelectedSpell(Action selectedSpell) {
        selectedSpell = selectedSpell;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}