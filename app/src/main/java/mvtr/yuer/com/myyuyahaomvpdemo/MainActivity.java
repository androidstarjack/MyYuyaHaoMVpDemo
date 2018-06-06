package mvtr.yuer.com.myyuyahaomvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mvtr.yuer.com.myyuyahaomvpdemo.activity.LoginActivity;
import mvtr.yuer.com.myyuyahaomvpdemo.utils.ActivityUtils;
/**
 * 类功能描述：</br>
 * P层:
 * 特点：MVP+retrofit+Rxjava封装和学习
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //登录模块的相关学习
        findViewById(R.id.btn_onclick01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.showActivity(MainActivity.this, LoginActivity.class);
            }
        });
    }
}
