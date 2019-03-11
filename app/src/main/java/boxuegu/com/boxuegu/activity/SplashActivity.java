package boxuegu.com.boxuegu.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import boxuegu.com.boxuegu.R;

public class SplashActivity extends AppCompatActivity {

    //定义变量
    TextView tvVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置显示垂直
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

    }

    private void init() {
        tvVersion=(TextView)this.findViewById(R.id.tv_version);

        try {
            //使用PackageManager获取版本
            PackageInfo packageInfo=getPackageManager().getPackageInfo(getPackageName(),0);
            tvVersion.setText("V"+packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        //跳转
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                  Intent intent =new Intent(SplashActivity.this,MainActivity.class);
                  startActivity(intent);
                  SplashActivity.this.finish();
            }
        },3000);

    }
}
