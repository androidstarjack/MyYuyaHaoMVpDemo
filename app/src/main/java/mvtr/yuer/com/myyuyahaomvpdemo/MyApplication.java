package mvtr.yuer.com.myyuyahaomvpdemo;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

import mvtr.yuer.com.myyuyahaomvpdemo.impl.net.config.ProjectInit;
import okhttp3.Interceptor;
/**
 * 类功能描述：</br>
 * P层:
 * 特点：MVP+retrofit+Rxjava封装和学习
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class MyApplication extends Application {
    public  static Context context;
    public static  boolean DEBUG = true;
    @Override
    public void onCreate() {
        super.onCreate();
        context =this;
        ProjectInit.init(this)
                .withApiHost("")
                .withInterceptors(new ArrayList<Interceptor>())
                .configure();
    }
}
