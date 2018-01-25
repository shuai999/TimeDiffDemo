package com.jackchen.timediff;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chronometer);

        SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间

        String nowtime=d.format(new Date());//按以上格式 将当前时间转换成字符串

        System.out.println("当前时间："+nowtime);
        String testtime="2018-01-23 07:48:50";//测试时间
        System.out.println("测试时间："+testtime);

        try {
            long result=(d.parse(nowtime).getTime()-d.parse(testtime).getTime())/1000;//当前时间减去测试时间 这个的除以1000得到秒，相应的60000得到分，3600000得到小时
            System.out.println("当前时间减去测试时间="+result+"秒");
            Log.d("timeDiff", "当前时间减去测试时间="+result+"秒");
            chronometer.setBase(SystemClock.elapsedRealtime()  - result*1000);  //timeDiff*60   result*60*1000
            //启动计时器
            chronometer.start();
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s1 = "2018-01-25 07:48:50" ;
//        String s2 = getStringDate() ;
//
//        try {
//            Date d1 = df.parse(s1);
//            Date d2 = df.parse(s2);
//
//            //Date   d2 = new   Date(System.currentTimeMillis());//你也可以获取当前时间
//            long diff = d2.getTime() - d1.getTime();//这样得到的差值是微秒级别
//            long days = diff / (1000 * 60 * 60 * 24);
//            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
//            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
//
//
//            //时间差
//            int timeDiff = new Long(days).intValue()*24*60 + new Long(hours).intValue()*60 + new Long(minutes).intValue() ;
//            Log.d("timeDiff", timeDiff + "==" + diff+"=="+days+"=="+hours+"=="+minutes);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
