package com.hotsausagecompany.app.hotsausagecompanytillcalculator;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class StockCheck extends Activity implements View.OnClickListener {

        protected PowerManager.WakeLock mWakeLock;

        Button save;
        Button clear;
        Button send;

        Calendar c;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String timestamp;
        SimpleDateFormat stf = new SimpleDateFormat("HHmmss");
        String time;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_stockcheck);

         /* This code together with the one in onDestroy()
         * will make the screen be always on until this Activity gets destroyed. */
            final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
            this.mWakeLock.acquire();

            //Closes the keyboard when actions are complete
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            //end of hide keyboard

            save = (Button) findViewById(R.id.save);
            clear = (Button) findViewById(R.id.clear);
            send = (Button) findViewById(R.id.send);

            // set a listener
            save.setOnClickListener(this);
            clear.setOnClickListener(this);
            send.setOnClickListener(this);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                    INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            return true;
        }


        @Override
        public void onClick(View v) {
            // get sitename from login screen and set as string variables
            Bundle b2 = getIntent().getExtras();
            String sitename = b2.getString("sitename");
            // end of get sitename

            // find the elements
            EditText regularstock = (EditText) findViewById(R.id.regularstock);
            EditText largestock = (EditText) findViewById(R.id.largestock);
            EditText specialstock = (EditText) findViewById(R.id.specialstock);
            EditText footlongstock = (EditText) findViewById(R.id.footlongstock);
            EditText smallbunstock = (EditText) findViewById(R.id.smallbunstock);
            EditText largebunstock = (EditText) findViewById(R.id.largebunstock);
            EditText tomatorelishstock = (EditText) findViewById(R.id.tomatorelishstock);
            EditText onionrelishstock = (EditText) findViewById(R.id.onionrelishstock);
            EditText chillirelishstock = (EditText) findViewById(R.id.chillirelishstock);
            EditText tomatoketchupstock = (EditText) findViewById(R.id.tomatoketchupstock);
            EditText hpstock = (EditText) findViewById(R.id.hpstock);
            EditText greenstock = (EditText) findViewById(R.id.greenstock);
            EditText redstock = (EditText) findViewById(R.id.redstock);
            EditText englishmustardstock = (EditText) findViewById(R.id.englishmustardstock);
            EditText frenchsmustardstock = (EditText) findViewById(R.id.frenchsmustardstock);
            EditText sitatchustock = (EditText) findViewById(R.id.sitatchustock);
            EditText enconastock = (EditText) findViewById(R.id.enconastock);
            EditText mayoboxstock = (EditText) findViewById(R.id.mayoboxstock);
            EditText cokestock = (EditText) findViewById(R.id.cokestock);
            EditText dietcokestock = (EditText) findViewById(R.id.dietcokestock);
            EditText fantastock = (EditText) findViewById(R.id.fantastock);
            EditText sevenupstock = (EditText) findViewById(R.id.sevenupstock);
            EditText drpepperstock = (EditText) findViewById(R.id.drpepperstock);
            EditText waterstock = (EditText) findViewById(R.id.waterstock);
            EditText cheesestock = (EditText) findViewById(R.id.cheesestock);
            EditText napkinsstock = (EditText) findViewById(R.id.napkinsstock);
            EditText screensstock = (EditText) findViewById(R.id.screensstock);
            EditText padsstock = (EditText) findViewById(R.id.padsstock);
            EditText handwipesstock = (EditText) findViewById(R.id.handwipesstock);
            EditText wiperrollsstock = (EditText) findViewById(R.id.wiperrollsstock);
            EditText antibacspraystock = (EditText) findViewById(R.id.antibacspraystock);
            EditText fairyliquidstock = (EditText) findViewById(R.id.fairyliquidstock);
            EditText oilstock = (EditText) findViewById(R.id.oilstock);
            EditText foilbagsstock = (EditText) findViewById(R.id.foilbagsstock);
            EditText kibbledonionsstock = (EditText) findViewById(R.id.kibbledonionsstock);
            EditText griddlecleanerstock = (EditText) findViewById(R.id.griddlecleanerstock);
            EditText bigketchupstock = (EditText) findViewById(R.id.bigketchupstock);

            String getregularstock = regularstock.getText().toString();
            String getlargestock = largestock.getText().toString();
            String getspecialstock = specialstock.getText().toString();
            String getfootlongstock = footlongstock.getText().toString();
            String getsmallbunstock = smallbunstock.getText().toString();
            String getlargebunstock = largebunstock.getText().toString();
            String gettomatorelishstock = tomatorelishstock.getText().toString();
            String getonionrelishstock = onionrelishstock.getText().toString();
            String getchillirelishstock = chillirelishstock.getText().toString();
            String gettomatoketchupstock = tomatoketchupstock.getText().toString();
            String gethpstock = hpstock.getText().toString();
            String getgreenstock = greenstock.getText().toString();
            String getredstock = redstock.getText().toString();
            String getenglishmustardstock = englishmustardstock.getText().toString();
            String getfrenchsmustardstock = frenchsmustardstock.getText().toString();
            String getsitatchustock = sitatchustock.getText().toString();
            String getenconastock = enconastock.getText().toString();
            String getmayoboxstock = mayoboxstock.getText().toString();
            String getcokestock = cokestock.getText().toString();
            String getdietcokestock = dietcokestock.getText().toString();
            String getfantastock = fantastock.getText().toString();
            String getsevenupstock = sevenupstock.getText().toString();
            String getdrpepperstock = drpepperstock.getText().toString();
            String getwaterstock = waterstock.getText().toString();
            String getcheesestock = cheesestock.getText().toString();
            String getnapkinsstock = napkinsstock.getText().toString();
            String getscreensstock = screensstock.getText().toString();
            String getpadsstock = padsstock.getText().toString();
            String gethandwipesstock = handwipesstock.getText().toString();
            String getwiperrollsstock = wiperrollsstock.getText().toString();
            String getantibacspraystock = antibacspraystock.getText().toString();
            String getfairyliquidstock = fairyliquidstock.getText().toString();
            String getoilstock = oilstock.getText().toString();
            String getfoilbagsstock = foilbagsstock.getText().toString();
            String getkibbledonionsstock = kibbledonionsstock.getText().toString();
            String getgriddlecleanerstock = griddlecleanerstock.getText().toString();
            String getbigketchupstock = bigketchupstock.getText().toString();



            switch (v.getId()) {

                case R.id.clear:
                    regularstock.setText("");
                    largestock.setText("");
                    specialstock.setText("");
                    footlongstock.setText("");
                    smallbunstock.setText("");
                    largebunstock.setText("");
                    tomatorelishstock.setText("");
                    onionrelishstock.setText("");
                    chillirelishstock.setText("");
                    tomatoketchupstock.setText("");
                    hpstock.setText("");
                    greenstock.setText("");
                    redstock.setText("");
                    englishmustardstock.setText("");
                    frenchsmustardstock.setText("");
                    sitatchustock.setText("");
                    enconastock.setText("");
                    mayoboxstock.setText("");
                    cokestock.setText("");
                    dietcokestock.setText("");
                    fantastock.setText("");
                    sevenupstock.setText("");
                    drpepperstock.setText("");
                    waterstock.setText("");
                    cheesestock.setText("");
                    napkinsstock.setText("");
                    screensstock.setText("");
                    padsstock.setText("");
                    handwipesstock.setText("");
                    wiperrollsstock.setText("");
                    antibacspraystock.setText("");
                    fairyliquidstock.setText("");
                    oilstock.setText("");
                    foilbagsstock.setText("");
                    kibbledonionsstock.setText("");
                    griddlecleanerstock.setText("");
                    bigketchupstock.setText("");
                    break;
                case R.id.save:
                    c = Calendar.getInstance();
                    timestamp = sdf.format(c.getTimeInMillis());
                    time = stf.format(c.getTimeInMillis());
                    try{

                        File file = new File(getBaseContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), timestamp+"StockCheck.txt");
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("INSERT INTO StockCheck (datecol, timecol, site, regular, large, special, footlong, small_bun, large_bun, tomato_relish, onion_relish, chilli_relish, tomato_ketchup, hp, green, red, english_mustard, frenchs_mustard, sitatchu, encona_bottles, mayo_boxes, coke, diet_coke, fanta, seven_up, dr_pepper, water, cheese_1400g, napkins, screens_20, pads_6, handwipes, wiper_rolls, antibac_spray, fairy_liquid, oil, foil_bags_500, kibbled_onions, griddle_cleaner, big_ketchup) VALUES ('"+timestamp+"', '"+time+"', '"+sitename+"', '"+getregularstock+"', '"+getlargestock+"', '"+getspecialstock+"', '"+getfootlongstock+"', '"+getsmallbunstock+"', '"+getlargebunstock+"', '"+gettomatorelishstock+"', '"+getonionrelishstock+"', '"+getchillirelishstock+"', '"+gettomatoketchupstock+"', '"+gethpstock+"', '"+getgreenstock+"', '"+getredstock+"', '"+getenglishmustardstock+"', '"+getfrenchsmustardstock+"', '"+getsitatchustock+"', '"+getenconastock+"', '"+getmayoboxstock+"', '"+getcokestock+"', '"+getdietcokestock+"', '"+getfantastock+"', '"+getsevenupstock+"', '"+getdrpepperstock+"', '"+getwaterstock+"', '"+getcheesestock+"', '"+getnapkinsstock+"', '"+getscreensstock+"', '"+getpadsstock+"', '"+gethandwipesstock+"', '"+getwiperrollsstock+"', '"+getantibacspraystock+"', '"+getfairyliquidstock+"', '"+getoilstock+"', '"+getfoilbagsstock+"', '"+getkibbledonionsstock+"', '"+getgriddlecleanerstock+"', '"+getbigketchupstock+"');");
                        bw.newLine();
                        bw.flush();
                        bw.close();
                        Toast.makeText(getBaseContext(), "STOCK CHECK HAS BEEN SAVED", Toast.LENGTH_LONG).show();
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    break;
                case R.id.send:
                    ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                    NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    if (mWifi.isConnected()) {

                        //this is the execute for the ftp.class
                        Toast.makeText(getBaseContext(), "SYNCRONISING WITH DATABASE PLEASE WAIT!", Toast.LENGTH_LONG).show();
                        FtpHandlerStock ftpHandlerStock = new FtpHandlerStock();
                        ftpHandlerStock.setSitename(getIntent().getExtras().getString("sitename"));
                        ftpHandlerStock.execute();
                        System.out.println("Site name is:" + getIntent().getExtras().getString("sitename"));
                        //this is the execute for the ftp.class

                    }
                    else{
                        Toast.makeText(getBaseContext(), "NO WIFI CONNECTION PLEASE CHECK AND RETRY!", Toast.LENGTH_LONG).show();
                    }


                        Intent stockIntent = new Intent(v.getContext(), Menu.class);
                        Bundle b4 = new Bundle();
                        b4.putString("sitename", sitename);
                        stockIntent.putExtras(b4);
                        startActivityForResult(stockIntent, 0);

                default:
                    break;
            }


        }

        @Override
        public void onDestroy() {
            this.mWakeLock.release();
            super.onDestroy();
        }
    }
