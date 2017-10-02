package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TillActivity extends Activity implements OnClickListener {

    protected PowerManager.WakeLock mWakeLock;


    Button regular;
    Button regularc;
    Button large;
    Button largec;
    Button footlong;
    Button footlongc;
    Button special;
    Button specialc;
    Button drink;
    Button staff;
    Button saver;
    Button waste;
    Button cancel;
    Button send;
    Button extracheese;
    Button nobun;
    TextView display;
    TextView regularcount;
    TextView regularhalfcount;
    TextView regularfullcount;
    TextView regularccount;
    TextView regularchalfcount;
    TextView regularcfullcount;
    TextView largecount;
    TextView largehalfcount;
    TextView largefullcount;
    TextView largeccount;
    TextView largechalfcount;
    TextView largecfullcount;
    TextView footlongcount;
    TextView footlonghalfcount;
    TextView footlongfullcount;
    TextView footlongccount;
    TextView footlongchalfcount;
    TextView footlongcfullcount;
    TextView specialcount;
    TextView specialhalfcount;
    TextView specialfullcount;
    TextView specialccount;
    TextView specialchalfcount;
    TextView specialcfullcount;
    TextView drinkcount;
    TextView drinkhalfcount;
    TextView drinkfullcount;
    TextView staffcount;
    TextView extracheesecount;
    TextView nobuncount;
    TextView regularstaffcount;
    TextView regularcstaffcount;
    TextView largestaffcount;
    TextView largecstaffcount;
    TextView footlongstaffcount;
    TextView footlongcstaffcount;
    TextView specialstaffcount;
    TextView specialcstaffcount;
    TextView drinkstaffcount;
    TextView regularwastecount;
    TextView largewastecount;
    TextView footlongwastecount;
    TextView specialwastecount;
    TextView smallbunwastecount;
    TextView largebunwastecount;
    TextView lastsale;

    double number = 0.00;
    int counter_regular = 0;
    int counter_regularhalf = 0;
    int counter_regularfull = 0;
    int counter_regularc = 0;
    int counter_regularchalf = 0;
    int counter_regularcfull = 0;
    int counter_large = 0;
    int counter_largehalf = 0;
    int counter_largefull = 0;
    int counter_largec = 0;
    int counter_largechalf = 0;
    int counter_largecfull = 0;
    int counter_footlong = 0;
    int counter_footlonghalf = 0;
    int counter_footlongfull = 0;
    int counter_footlongc = 0;
    int counter_footlongchalf = 0;
    int counter_footlongcfull = 0;
    int counter_special = 0;
    int counter_specialhalf = 0;
    int counter_specialfull = 0;
    int counter_specialc = 0;
    int counter_specialchalf = 0;
    int counter_specialcfull = 0;
    int counter_drink = 0;
    int counter_drinkhalf = 0;
    int counter_drinkfull = 0;
    int counter_extracheese = 0;
    int counter_nobun = 0;
    int counter_regularstaff = 0;
    int counter_regularcstaff = 0;
    int counter_largestaff = 0;
    int counter_largecstaff = 0;
    int counter_footlongstaff = 0;
    int counter_footlongcstaff = 0;
    int counter_specialstaff = 0;
    int counter_specialcstaff = 0;
    int counter_drinkstaff = 0;
    int counter_regularwaste = 0;
    int counter_largewaste = 0;
    int counter_footlongwaste = 0;
    int counter_specialwaste = 0;
    int counter_smallbunwaste = 0;
    int counter_largebunwaste = 0;

    String getRegular;
    String getRegularhalf;
    String getRegularfull;
    String getRegularc;
    String getRegularchalf;
    String getRegularcfull;
    String getLarge;
    String getLargehalf;
    String getLargefull;
    String getLargec;
    String getLargechalf;
    String getLargecfull;
    String getFootlong;
    String getFootlonghalf;
    String getFootlongfull;
    String getFootlongc;
    String getFootlongchalf;
    String getFootlongcfull;
    String getSpecial;
    String getSpecialhalf;
    String getSpecialfull;
    String getSpecialC;
    String getSpecialchalf;
    String getSpecialcfull;
    String getDrink;
    String getDrinkhalf;
    String getDrinkfull;
    String getExtracheese;
    String getNobun;
    String getRegularstaff;
    String getRegularcstaff;
    String getLargestaff;
    String getLargecstaff;
    String getFootlongstaff;
    String getFootlongcstaff;
    String getSpecialstaff;
    String getSpecialCstaff;
    String getDrinkstaff;
    String getRegularwaste;
    String getLargewaste;
    String getFootlongwaste;
    String getSpecialwaste;
    String getSmallbunwaste;
    String getLargebunwaste;
    String getLastsale;
    Calendar c;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String timestamp;
    SimpleDateFormat stf = new SimpleDateFormat("HHmmss");
    String time;
    SimpleDateFormat stf2 = new SimpleDateFormat("HH:mm");
    String time2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_till);

         /* This code together with the one in onDestroy()
         * will make the screen be always on until this Activity gets destroyed. */
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();

        final Bundle b0 = getIntent().getExtras();
        final String sitename = b0.getString("sitename");

        final Bundle b01 = getIntent().getExtras();
        final String thelastsale = b01.getString("lastsale");

        // This is scheduler for auto upload of data //
        /*ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        Integer delayInHour = hour < 6 ? 6 - hour : 24 - (hour - 6);

        System.out.println("Current Hour: "+hour);
        System.out.println("Comuted Delay for next 5 AM: " + delayInHour);

        scheduler.scheduleAtFixedRate(new ftpHandler("sitename"), delayInHour, 24, TimeUnit.HOURS);
        */
        // End auto upload of data


        ImageButton next = (ImageButton) findViewById(R.id.banner);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }

        });
        next.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                getLastsale = lastsale.getText().toString();
                Intent myIntent = new Intent(v.getContext(), Menu.class);
                b0.putString("sitename", sitename);
                b01.putString("lastsale", getLastsale);
                myIntent.putExtras(b0);
                myIntent.putExtras(b01);
                startActivityForResult(myIntent, 0);
                return true;
            }
        });


        // find the elements
        regular = (Button) findViewById(R.id.regular);
        regularc = (Button) findViewById(R.id.regularc);
        large = (Button) findViewById(R.id.large);
        largec = (Button) findViewById(R.id.largec);
        footlong = (Button) findViewById(R.id.footlong);
        footlongc = (Button) findViewById(R.id.footlongc);
        special = (Button) findViewById(R.id.special);
        specialc = (Button) findViewById(R.id.specialc);
        drink = (Button) findViewById(R.id.drink);
        staff = (Button) findViewById(R.id.staff);
        saver = (Button) findViewById(R.id.saver);
        waste = (Button) findViewById(R.id.waste);
        cancel = (Button) findViewById(R.id.cancel);
        send = (Button) findViewById(R.id.send);
        extracheese = (Button) findViewById(R.id.extracheese);
        nobun = (Button) findViewById(R.id.nobun);
        display = (TextView) findViewById(R.id.display);
        regularcount = (TextView) findViewById(R.id.regularcount);
        regularhalfcount = (TextView) findViewById(R.id.regularhalfcount);
        regularfullcount = (TextView) findViewById(R.id.regularfullcount);
        regularccount = (TextView) findViewById(R.id.regularccount);
        regularchalfcount = (TextView) findViewById(R.id.regularchalfcount);
        regularcfullcount = (TextView) findViewById(R.id.regularcfullcount);
        largecount = (TextView) findViewById(R.id.largecount);
        largehalfcount = (TextView) findViewById(R.id.largehalfcount);
        largefullcount = (TextView) findViewById(R.id.largefullcount);
        largeccount = (TextView) findViewById(R.id.largeccount);
        largechalfcount = (TextView) findViewById(R.id.largechalfcount);
        largecfullcount = (TextView) findViewById(R.id.largecfullcount);
        footlongcount = (TextView) findViewById(R.id.footlongcount);
        footlonghalfcount = (TextView) findViewById(R.id.footlonghalfcount);
        footlongfullcount = (TextView) findViewById(R.id.footlongfullcount);
        footlongccount = (TextView) findViewById(R.id.footlongccount);
        footlongchalfcount = (TextView) findViewById(R.id.footlongchalfcount);
        footlongcfullcount = (TextView) findViewById(R.id.footlongcfullcount);
        specialcount = (TextView) findViewById(R.id.specialcount);
        specialhalfcount = (TextView) findViewById(R.id.specialhalfcount);
        specialfullcount = (TextView) findViewById(R.id.specialfullcount);
        specialccount = (TextView) findViewById(R.id.specialccount);
        specialchalfcount = (TextView) findViewById(R.id.specialchalfcount);
        specialcfullcount = (TextView) findViewById(R.id.specialcfullcount);
        drinkcount = (TextView) findViewById(R.id.drinkcount);
        drinkhalfcount = (TextView) findViewById(R.id.drinkhalfcount);
        drinkfullcount = (TextView) findViewById(R.id.drinkfullcount);
        staffcount = (TextView) findViewById(R.id.staffcount);
        extracheesecount = (TextView) findViewById(R.id.extracheesecount);
        nobuncount = (TextView) findViewById(R.id.nobuncount);
        regularstaffcount = (TextView) findViewById(R.id.regularstaffcount);
        regularcstaffcount = (TextView) findViewById(R.id.regularcstaffcount);
        largestaffcount = (TextView) findViewById(R.id.largestaffcount);
        largecstaffcount = (TextView) findViewById(R.id.largecstaffcount);
        footlongstaffcount = (TextView) findViewById(R.id.footlongstaffcount);
        footlongcstaffcount = (TextView) findViewById(R.id.footlongcstaffcount);
        specialstaffcount = (TextView) findViewById(R.id.specialstaffcount);
        specialcstaffcount = (TextView) findViewById(R.id.specialcstaffcount);
        drinkstaffcount = (TextView) findViewById(R.id.drinkstaffcount);
        regularwastecount = (TextView) findViewById(R.id.regularwastecount);
        largewastecount = (TextView) findViewById(R.id.largewastecount);
        footlongwastecount = (TextView) findViewById(R.id.footlongwastecount);
        specialwastecount = (TextView) findViewById(R.id.specialwastecount);
        smallbunwastecount = (TextView) findViewById(R.id.smallbunwastecount);
        largebunwastecount = (TextView) findViewById(R.id.largebunwastecount);
        lastsale = (TextView) findViewById(R.id.lastsale);



        regular.setText("Regular");
        regularc.setText("Reg + C");
        large.setText("Large");
        largec.setText("Lar + C");
        footlong.setText("Footlong");
        footlongc.setText("Foot + C");
        special.setText("Special");
        specialc.setText("Spec + C");
        drink.setText("Drink");
        extracheese.setText("Ex Cheese");
        nobun.setText("No Bun");
        lastsale.setText(""+thelastsale);

        // set a listener
        regular.setOnClickListener(this);
        regularc.setOnClickListener(this);
        large.setOnClickListener(this);
        largec.setOnClickListener(this);
        footlong.setOnClickListener(this);
        footlongc.setOnClickListener(this);
        special.setOnClickListener(this);
        specialc.setOnClickListener(this);
        drink.setOnClickListener(this);
        staff.setOnClickListener(this);
        saver.setOnClickListener(this);
        waste.setOnClickListener(this);
        cancel.setOnClickListener(this);
        send.setOnClickListener(this);
        extracheese.setOnClickListener(this);
        nobun.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        // get sitename from login screen and set as string variables
        Bundle b2 = getIntent().getExtras();
        String sitename = b2.getString("sitename");
        // end of get sitename

        switch (v.getId()) {
            case R.id.regular:
                String regularText = regular.getText().toString();
                if (regularText == "Reg Half") {
                    if (counter_regular < 1){
                        number +=110;
                    }
                    else {
                        number -=110;
                        counter_regular--;
                        regularcount.setText("" + counter_regular);
                    }
                    counter_regularhalf++;
                    regularhalfcount.setText("" + counter_regularhalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (regularText == "Reg Full"){
                    if (counter_regular < 1){
                        number +=0;
                    }
                    else {
                        number -=220;
                        counter_regular--;
                        regularcount.setText("" + counter_regular);
                    }
                    counter_regularfull++;
                    regularfullcount.setText("" + counter_regularfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (regularText == "Regular"){
                    number +=220;
                    counter_regular++;
                    regularcount.setText("" + counter_regular);
                }
                else if (regularText == "Reg Staff"){
                    number +=0;
                    counter_regularstaff++;
                    regularstaffcount.setText("" + counter_regularstaff);
                }
                else if (regularText == "Reg Waste"){
                    number +=0;
                    counter_regularwaste++;
                    regularwastecount.setText("" + counter_regularwaste);
                }
                break;

            case R.id.regularc:
                String regularcText = regularc.getText().toString();
                if (regularcText == "Reg C Half") {
                    if (counter_regularc < 1){
                        number +=120;
                    }
                    else {
                        number -=120;
                        counter_regularc--;
                        regularccount.setText("" + counter_regularc);
                    }
                    counter_regularchalf++;
                    regularchalfcount.setText("" + counter_regularchalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (regularcText == "Reg C Full"){
                    if (counter_regularc < 1){
                        number +=0;
                    }
                    else {
                        number -=240;
                        counter_regularc--;
                        regularccount.setText("" + counter_regularc);
                    }
                    counter_regularcfull++;
                    regularcfullcount.setText("" + counter_regularcfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (regularcText == "Reg + C"){
                    number +=240;
                    counter_regularc++;
                    regularccount.setText("" + counter_regularc);
                }
                else if (regularcText == "Reg C Staff"){
                    number +=0;
                    counter_regularcstaff++;
                    regularcstaffcount.setText("" + counter_regularcstaff);
                }
                else if (regularcText == ""){
                }
                break;

            case R.id.large:
                String largeText = large.getText().toString();
                if (largeText == "Lar Half") {
                    if (counter_large < 1){
                        number +=165;
                    }
                    else {
                        number -=165;
                        counter_large--;
                        largecount.setText("" + counter_large);
                    }
                    counter_largehalf++;
                    largehalfcount.setText("" + counter_largehalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (largeText == "Lar Full"){
                    if (counter_large < 1){
                        number +=0;
                    }
                    else {
                        number -=330;
                        counter_large--;
                        largecount.setText("" + counter_large);
                    }
                    counter_largefull++;
                    largefullcount.setText("" + counter_largefull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (largeText == "Large"){
                    number +=330;
                    counter_large++;
                    largecount.setText("" + counter_large);
                }
                else if (largeText == "Lar Staff"){
                    number +=0;
                    counter_largestaff++;
                    largestaffcount.setText("" + counter_largestaff);
                }
                else if (largeText == "Lar Waste"){
                    number +=0;
                    counter_largewaste++;
                    largewastecount.setText("" + counter_largewaste);
                }
                break;

            case R.id.largec:
                String largecText = largec.getText().toString();
                if (largecText == "Lar C Half") {
                    if (counter_largec < 1){
                        number +=185;
                    }
                    else {
                        number -=185;
                        counter_largec--;
                        largeccount.setText("" + counter_largec);
                    }
                    counter_largechalf++;
                    largechalfcount.setText("" + counter_largechalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (largecText == "Lar C Full"){
                    if (counter_largec < 1){
                        number +=0;
                    }
                    else {
                        number -=370;
                        counter_largec--;
                        largeccount.setText("" + counter_largec);
                    }
                    counter_largecfull++;
                    largecfullcount.setText("" + counter_largecfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (largecText == "Lar + C"){
                    number +=370;
                    counter_largec++;
                    largeccount.setText("" + counter_largec);
                }
                else if (largecText == "Lar C Staff"){
                    number +=0;
                    counter_largecstaff++;
                    largecstaffcount.setText("" + counter_largecstaff);
                }
                else if (largecText == ""){
                }
                break;
            case R.id.footlong:
                String footlongText = footlong.getText().toString();
                if (footlongText == "Foot Half") {
                    if (counter_footlong < 1){
                        number +=195;
                    }
                    else {
                        number -=195;
                        counter_footlong--;
                        footlongcount.setText("" + counter_footlong);
                    }
                    counter_footlonghalf++;
                    footlonghalfcount.setText("" + counter_footlonghalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (footlongText == "Foot Full"){
                    if (counter_footlong < 1){
                        number +=0;
                    }
                    else {
                        number -=390;
                        counter_footlong--;
                        footlongcount.setText("" + counter_footlong);
                    }
                    counter_footlongfull++;
                    footlongfullcount.setText("" + counter_footlongfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (footlongText == "Footlong"){
                    number +=390;
                    counter_footlong++;
                    footlongcount.setText("" + counter_footlong);
                }
                else if (footlongText == "Foot Staff"){
                    number +=0;
                    counter_footlongstaff++;
                    footlongstaffcount.setText("" + counter_footlongstaff);
                }
                else if (footlongText == "Foot Waste"){
                    number +=0;
                    counter_footlongwaste++;
                    footlongwastecount.setText("" + counter_footlongwaste);
                }
                break;
            case R.id.footlongc:
                String footlongcText = footlongc.getText().toString();
                if (footlongcText == "Foot C Half") {
                    if (counter_footlongc < 1){
                        number +=215;
                    }
                    else {
                        number -=215;
                        counter_footlongc--;
                        footlongccount.setText("" + counter_footlongc);
                    }
                    counter_footlongchalf++;
                    footlongchalfcount.setText("" + counter_footlongchalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (footlongcText == "Foot C Full"){
                    if (counter_footlongc < 1){
                        number +=0;
                    }
                    else {
                        number -=430;
                        counter_footlongc--;
                        footlongccount.setText("" + counter_footlongc);
                    }
                    counter_footlongcfull++;
                    footlongcfullcount.setText("" + counter_footlongcfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (footlongcText == "Foot + C"){
                    number +=430;
                    counter_footlongc++;
                    footlongccount.setText("" + counter_footlongc);
                }
                else if (footlongcText == "Foot C Staff"){
                    number +=0;
                    counter_footlongcstaff++;
                    footlongcstaffcount.setText("" + counter_footlongcstaff);
                }
                else if (footlongcText == ""){
                }
                break;
            case R.id.special:
                String specialText = special.getText().toString();
                if (specialText == "Spec Half") {
                    if (counter_special < 1){
                        number +=165;
                    }
                    else {
                        number -=165;
                        counter_special--;
                        specialcount.setText("" + counter_special);
                    }
                    counter_specialhalf++;
                    specialhalfcount.setText("" + counter_specialhalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (specialText == "Spec Full"){
                    if (counter_special < 1){
                        number +=0;
                    }
                    else {
                        number -=330;
                        counter_special--;
                        specialcount.setText("" + counter_special);
                    }
                    counter_specialfull++;
                    specialfullcount.setText("" + counter_specialfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (specialText == "Special"){
                    number +=330;
                    counter_special++;
                    specialcount.setText("" + counter_special);
                }
                else if (specialText == "Spec Staff"){
                    number +=0;
                    counter_specialstaff++;
                    specialstaffcount.setText("" + counter_specialstaff);
                }
                else if (specialText == "Spec Waste"){
                    number +=0;
                    counter_specialwaste++;
                    specialwastecount.setText("" + counter_specialwaste);
                }
                break;
            case R.id.specialc:
                String specialcText = specialc.getText().toString();
                if (specialcText == "Spec C Half") {
                    if (counter_specialc < 1){
                        number +=185;
                    }
                    else {
                        number -=185;
                        counter_specialc--;
                        specialccount.setText("" + counter_specialc);
                    }
                    counter_specialchalf++;
                    specialchalfcount.setText("" + counter_specialchalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (specialcText == "Spec C Full"){
                    if (counter_specialc < 1){
                        number +=0;
                    }
                    else {
                        number -=370;
                        counter_specialc--;
                        specialccount.setText("" + counter_specialc);
                    }
                    counter_specialcfull++;
                    specialcfullcount.setText("" + counter_specialcfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (specialcText == "Spec + C"){
                    number +=370;
                    counter_specialc++;
                    specialccount.setText("" + counter_specialc);
                }
                else if (specialcText == "Spec C Staff"){
                    number +=0;
                    counter_specialcstaff++;
                    specialcstaffcount.setText("" + counter_specialcstaff);
                }
                else if (specialcText == ""){
                }
                break;
            case R.id.extracheese:
                String extracheeseText = extracheese.getText().toString();
                if (extracheeseText == "Ex Cheese") {
                    number += 20;
                    counter_extracheese++;
                    extracheesecount.setText("" + counter_extracheese);
                }
                else if (extracheeseText == "Sml Bun Waste"){
                    number +=0;
                    counter_smallbunwaste++;
                    smallbunwastecount.setText("" + counter_smallbunwaste);
                }
                break;
            case R.id.drink:
                String drinkText = drink.getText().toString();
                if (drinkText == "Drink Half") {
                    if (counter_drink < 1){
                        number +=50;
                    }
                    else {
                        number -=50;
                        counter_drink--;
                        drinkcount.setText("" + counter_drink);
                    }
                    counter_drinkhalf++;
                    drinkhalfcount.setText("" + counter_drinkhalf);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (drinkText == "Drink Full"){
                    if (counter_drink < 1){
                        number +=0;
                    }
                    else {
                        number -=100;
                        counter_drink--;
                        drinkcount.setText("" + counter_drink);
                    }
                    number +=0;
                    counter_drinkfull++;
                    drinkfullcount.setText("" + counter_drinkfull);
                    regular.setText("Regular");
                    regularc.setText("Reg + C");
                    large.setText("Large");
                    largec.setText("Lar + C");
                    footlong.setText("Footlong");
                    footlongc.setText("Foot + C");
                    special.setText("Special");
                    specialc.setText("Spec + C");
                    drink.setText("Drink");
                }
                else if (drinkText == "Drink") {
                    number += 100;
                    counter_drink++;
                    drinkcount.setText("" + counter_drink);
                }
                else if (drinkText == "Drink Staff"){
                    number +=0;
                    counter_drinkstaff++;
                    drinkstaffcount.setText("" + counter_drinkstaff);
                }
                else if (drinkText == "Lar Bun Waste"){
                    number +=0;
                    counter_largebunwaste++;
                    largebunwastecount.setText("" + counter_largebunwaste);
                }
                break;
            case R.id.staff:
                regular.setText("Reg Staff");
                regularc.setText("Reg C Staff");
                large.setText("Lar Staff");
                largec.setText("Lar C Staff");
                footlong.setText("Foot Staff");
                footlongc.setText("Foot C Staff");
                special.setText("Spec Staff");
                specialc.setText("Spec C Staff");
                drink.setText("Drink Staff");
                break;

            case R.id.nobun:
                String nobunText = nobun.getText().toString();
                if (nobunText == "No Bun") {
                    number-=30;
                    counter_nobun++;
                    nobuncount.setText("" + counter_nobun);
                }
                else if (nobunText == ""){
                }

                break;
            case R.id.saver:
                regularText = regular.getText().toString();
                if (regularText == "Regular") {
                    regular.setText("Reg Half");
                }
                else if (regularText == "Reg Half"){
                    regular.setText("Reg Full");
                }
                else if (regularText == "Reg Full") {
                    regular.setText("Regular");
                }
                regularcText = regularc.getText().toString();
                if (regularcText == "Reg + C") {
                    regularc.setText("Reg C Half");
                }
                else if (regularcText == "Reg C Half"){
                    regularc.setText("Reg C Full");
                }
                else if (regularcText == "Reg C Full"){
                    regularc.setText("Reg + C");
                }

                largeText = large.getText().toString();
                if (largeText == "Large") {
                    large.setText("Lar Half");
                }
                else if (largeText == "Lar Half"){
                    large.setText("Lar Full");
                }
                else if (largeText == "Lar Full"){
                    large.setText("Large");
                }
                largecText = largec.getText().toString();
                if (largecText == "Lar + C") {
                    largec.setText("Lar C Half");
                }
                else if (largecText == "Lar C Half"){
                    largec.setText("Lar C Full");
                }
                else if (largecText == "Lar C Full"){
                    largec.setText("Lar + C");
                }

                footlongText = footlong.getText().toString();
                if (footlongText == "Footlong") {
                    footlong.setText("Foot Half");
                }
                else if (footlongText == "Foot Half"){
                    footlong.setText("Foot Full");
                }
                else if (footlongText == "Foot Full") {
                    footlong.setText("Footlong");
                }
                footlongcText = footlongc.getText().toString();
                if (footlongcText == "Foot + C") {
                    footlongc.setText("Foot C Half");
                }
                else if (footlongcText == "Foot C Half"){
                    footlongc.setText("Foot C Full");
                }
                else if (footlongcText == "Foot C Full"){
                    footlongc.setText("Foot + C");
                }

                specialText = special.getText().toString();
                if (specialText == "Special") {
                    special.setText("Spec Half");
                }
                else if (specialText == "Spec Half"){
                    special.setText("Spec Full");
                }
                else if (specialText == "Spec Full") {
                    special.setText("Special");
                }
                specialcText = specialc.getText().toString();
                if (specialcText == "Spec + C") {
                    specialc.setText("Spec C Half");
                }
                else if (specialcText == "Spec C Half"){
                    specialc.setText("Spec C Full");
                }
                else if (specialcText == "Spec C Full"){
                    specialc.setText("Spec + C");
                }

                drinkText = drink.getText().toString();
                if (drinkText == "Drink") {
                    drink.setText("Drink Half");
                }
                else if (drinkText == "Drink Half"){
                    drink.setText("Drink Full");
                }
                else if (drinkText == "Drink Full") {
                    drink.setText("Drink");
                }
                break;
            case R.id.waste:
                regular.setText("Reg Waste");
                regularc.setText("");
                large.setText("Lar Waste");
                largec.setText("");
                footlong.setText("Foot Waste");
                footlongc.setText("");
                special.setText("Spec Waste");
                specialc.setText("");
                extracheese.setText("Sml Bun Waste");
                nobun.setText("");
                drink.setText("Lar Bun Waste");
                break;
            case R.id.cancel:
                number=0;
                counter_regular=0;
                regularcount.setText("");
                counter_regularhalf=0;
                regularhalfcount.setText("");
                counter_regularfull=0;
                regularfullcount.setText("");
                counter_regularc=0;
                regularccount.setText("");
                counter_regularchalf=0;
                regularchalfcount.setText("");
                counter_regularcfull=0;
                regularcfullcount.setText("");
                counter_large=0;
                largecount.setText("");
                counter_largehalf=0;
                largehalfcount.setText("");
                counter_largefull=0;
                largefullcount.setText("");
                counter_largec=0;
                largeccount.setText("");
                counter_largechalf=0;
                largechalfcount.setText("");
                counter_largecfull=0;
                largecfullcount.setText("");
                counter_footlong=0;
                footlongcount.setText("");
                counter_footlonghalf=0;
                footlonghalfcount.setText("");
                counter_footlongfull=0;
                footlongfullcount.setText("");
                counter_footlongc=0;
                footlongccount.setText("");
                counter_footlongchalf=0;
                footlongchalfcount.setText("");
                counter_footlongcfull=0;
                footlongcfullcount.setText("");
                counter_special=0;
                specialcount.setText("");
                counter_specialhalf=0;
                specialhalfcount.setText("");
                counter_specialfull=0;
                specialfullcount.setText("");
                counter_specialc=0;
                specialccount.setText("");
                counter_specialchalf=0;
                specialchalfcount.setText("");
                counter_specialcfull=0;
                specialcfullcount.setText("");
                counter_drink=0;
                drinkcount.setText("");
                counter_drinkhalf=0;
                drinkhalfcount.setText("");
                counter_drinkfull=0;
                drinkfullcount.setText("");
                counter_regularstaff=0;
                regularstaffcount.setText("");
                counter_regularcstaff=0;
                regularcstaffcount.setText("");
                counter_largestaff=0;
                largestaffcount.setText("");
                counter_largecstaff=0;
                largecstaffcount.setText("");
                counter_footlongstaff=0;
                footlongstaffcount.setText("");
                counter_footlongcstaff=0;
                footlongcstaffcount.setText("");
                counter_specialstaff=0;
                specialstaffcount.setText("");
                counter_specialcstaff=0;
                specialcstaffcount.setText("");
                counter_drinkstaff=0;
                drinkstaffcount.setText("");
                counter_extracheese=0;
                extracheesecount.setText("");
                counter_nobun=0;
                nobuncount.setText("");
                counter_regularwaste=0;
                regularwastecount.setText("");
                counter_largewaste=0;
                largewastecount.setText("");
                counter_footlongwaste=0;
                footlongwastecount.setText("");
                counter_specialwaste=0;
                specialwastecount.setText("");
                counter_smallbunwaste=0;
                smallbunwastecount.setText("");
                counter_largebunwaste=0;
                largebunwastecount.setText("");
                regular.setText("Regular");
                regularc.setText("Reg + C");
                large.setText("Large");
                largec.setText("Lar + C");
                footlong.setText("Footlong");
                footlongc.setText("Foot + C");
                special.setText("Special");
                specialc.setText("Spec + C");
                extracheese.setText("Ex Cheese");
                nobun.setText("No Bun");
                drink.setText("Drink");
                break;
            case R.id.send:
                getRegular = regularcount.getText().toString();
                getRegularhalf = regularhalfcount.getText().toString();
                getRegularfull = regularfullcount.getText().toString();
                getRegularc = regularccount.getText().toString();
                getRegularchalf = regularchalfcount.getText().toString();
                getRegularcfull = regularcfullcount.getText().toString();
                getLarge = largecount.getText().toString();
                getLargehalf = largehalfcount.getText().toString();
                getLargefull = largefullcount.getText().toString();
                getLargec = largeccount.getText().toString();
                getLargechalf = largechalfcount.getText().toString();
                getLargecfull = largecfullcount.getText().toString();
                getFootlong = footlongcount.getText().toString();
                getFootlonghalf = footlonghalfcount.getText().toString();
                getFootlongfull = footlongfullcount.getText().toString();
                getFootlongc = footlongccount.getText().toString();
                getFootlongchalf = footlongchalfcount.getText().toString();
                getFootlongcfull = footlongcfullcount.getText().toString();
                getSpecial = specialcount.getText().toString();
                getSpecialhalf = specialhalfcount.getText().toString();
                getSpecialfull = specialfullcount.getText().toString();
                getSpecialC = specialccount.getText().toString();
                getSpecialchalf = specialchalfcount.getText().toString();
                getSpecialcfull = specialcfullcount.getText().toString();
                getDrink = drinkcount.getText().toString();
                getDrinkhalf = drinkhalfcount.getText().toString();
                getDrinkfull = drinkfullcount.getText().toString();
                getRegularstaff = regularstaffcount.getText().toString();
                getRegularcstaff = regularcstaffcount.getText().toString();
                getLargestaff = largestaffcount.getText().toString();
                getLargecstaff = largecstaffcount.getText().toString();
                getFootlongstaff = footlongstaffcount.getText().toString();
                getFootlongcstaff = footlongcstaffcount.getText().toString();
                getSpecialstaff = specialstaffcount.getText().toString();
                getSpecialCstaff = specialcstaffcount.getText().toString();
                getDrinkstaff = drinkstaffcount.getText().toString();
                getExtracheese = extracheesecount.getText().toString();
                getNobun = nobuncount.getText().toString();
                getRegularwaste = regularwastecount.getText().toString();
                getLargewaste = largewastecount.getText().toString();
                getFootlongwaste = footlongwastecount.getText().toString();
                getSpecialwaste = specialwastecount.getText().toString();
                getSmallbunwaste = smallbunwastecount.getText().toString();
                getLargebunwaste = largebunwastecount.getText().toString();


                c = Calendar.getInstance();
                timestamp = sdf.format(c.getTimeInMillis());
                time = stf.format(c.getTimeInMillis());
                time2 = stf2.format(c.getTimeInMillis());

                try{

                    File file = new File(getBaseContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), timestamp+"SalesData.txt");
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("INSERT INTO SalesData (datecol,timecol,site,regular,regular_and_cheese,large,large_and_cheese,footlong,footlong_and_cheese,special,special_and_cheese,drink,extra_cheese,no_bun,half_regular,half_regular_and_cheese,half_large,half_large_and_cheese,half_footlong,half_footlong_and_cheese,half_special,half_special_and_cheese,half_drink,full_regular,full_regular_and_cheese,full_large,full_large_and_cheese,full_footlong,full_footlong_and_cheese,full_special,full_special_and_cheese,full_drink,staff_regular,staff_regular_and_cheese,staff_large,staff_large_and_cheese,staff_footlong,staff_footlong_and_cheese,staff_special,staff_special_and_cheese,staff_drink,regular_waste,large_waste,footlong_waste,special_waste,small_bun_waste,large_bun_waste,total) VALUES ('"+timestamp+"', '"+time+"', '"+sitename+"', '"+getRegular+"', '"+getRegularc+"', '"+getLarge+"', '"+getLargec+"', '"+getFootlong+"', '"+getFootlongc+"', '"+getSpecial+"', '"+getSpecialC+"', '"+getDrink+"', '"+getExtracheese+"', '"+getNobun+"', '"+getRegularhalf+"', '"+getRegularchalf+"', '"+getLargehalf+"', '"+getLargechalf+"', '"+getFootlonghalf+"', '"+getFootlongchalf+"', '"+getSpecialhalf+"', '"+getSpecialchalf+"', '"+getDrinkhalf+"', '"+getRegularfull+"', '"+getRegularcfull+"', '"+getLargefull+"', '"+getLargecfull+"', '"+getFootlongfull+"', '"+getFootlongcfull+"', '"+getSpecialfull+"', '"+getSpecialcfull+"', '"+getDrinkfull+"', '"+getRegularstaff+"', '"+getRegularcstaff+"', '"+getLargestaff+"', '"+getLargecstaff+"', '"+getFootlongstaff+"', '"+getFootlongcstaff+"', '"+getSpecialstaff+"', '"+getSpecialCstaff+"', '"+getDrinkstaff+"', '"+getRegularwaste+"', '"+getLargewaste+"', '"+getFootlongwaste+"', '"+getSpecialwaste+"', '"+getSmallbunwaste+"', '"+getLargebunwaste+"', '"+number/100+"'); ");
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    Toast.makeText(getBaseContext(), "Data Sent", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    e.printStackTrace();
                }
//Running total  file writer//
                try{

                    File text = new File(getBaseContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), timestamp+"total.txt");
                    FileWriter fwtext = new FileWriter(text, true);
                    BufferedWriter bw = new BufferedWriter(fwtext);
                    bw.write(""+number);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                number=0;
                counter_regular=0;
                regularcount.setText("");
                counter_regularhalf=0;
                regularhalfcount.setText("");
                counter_regularfull=0;
                regularfullcount.setText("");
                counter_regularc=0;
                regularccount.setText("");
                counter_regularchalf=0;
                regularchalfcount.setText("");
                counter_regularcfull=0;
                regularcfullcount.setText("");
                counter_large=0;
                largecount.setText("");
                counter_largehalf=0;
                largehalfcount.setText("");
                counter_largefull=0;
                largefullcount.setText("");
                counter_largec=0;
                largeccount.setText("");
                counter_largechalf=0;
                largechalfcount.setText("");
                counter_largecfull=0;
                largecfullcount.setText("");
                counter_footlong=0;
                footlongcount.setText("");
                counter_footlonghalf=0;
                footlonghalfcount.setText("");
                counter_footlongfull=0;
                footlongfullcount.setText("");
                counter_footlongc=0;
                footlongccount.setText("");
                counter_footlongchalf=0;
                footlongchalfcount.setText("");
                counter_footlongcfull=0;
                footlongcfullcount.setText("");
                counter_special=0;
                specialcount.setText("");
                counter_specialhalf=0;
                specialhalfcount.setText("");
                counter_specialfull=0;
                specialfullcount.setText("");
                counter_specialc=0;
                specialccount.setText("");
                counter_specialchalf=0;
                specialchalfcount.setText("");
                counter_specialcfull=0;
                specialcfullcount.setText("");
                counter_drink=0;
                drinkcount.setText("");
                counter_drinkhalf=0;
                drinkhalfcount.setText("");
                counter_drinkfull=0;
                drinkfullcount.setText("");
                counter_regularstaff=0;
                regularstaffcount.setText("");
                counter_regularcstaff=0;
                regularcstaffcount.setText("");
                counter_largestaff=0;
                largestaffcount.setText("");
                counter_largecstaff=0;
                largecstaffcount.setText("");
                counter_footlongstaff=0;
                footlongstaffcount.setText("");
                counter_footlongcstaff=0;
                footlongcstaffcount.setText("");
                counter_specialstaff=0;
                specialstaffcount.setText("");
                counter_specialcstaff=0;
                specialcstaffcount.setText("");
                counter_drinkstaff=0;
                drinkstaffcount.setText("");
                counter_extracheese=0;
                extracheesecount.setText("");
                counter_nobun=0;
                nobuncount.setText("");
                counter_regularwaste=0;
                regularwastecount.setText("");
                counter_largewaste=0;
                largewastecount.setText("");
                counter_footlongwaste=0;
                footlongwastecount.setText("");
                counter_specialwaste=0;
                specialwastecount.setText("");
                counter_smallbunwaste=0;
                smallbunwastecount.setText("");
                counter_largebunwaste=0;
                largebunwastecount.setText("");
                regular.setText("Regular");
                regularc.setText("Reg + C");
                large.setText("Large");
                largec.setText("Lar + C");
                footlong.setText("Footlong");
                footlongc.setText("Foot + C");
                special.setText("Special");
                specialc.setText("Spec + C");
                extracheese.setText("Ex Cheese");
                nobun.setText("No Bun");
                drink.setText("Drink");
                lastsale.setText("Last transaction: "+time2);
                break;

            default:
                break;
        }

        display.setText("£" + number/100);



    }

    @Override
    public void onDestroy() {
        this.mWakeLock.release();
        super.onDestroy();
    }
}
