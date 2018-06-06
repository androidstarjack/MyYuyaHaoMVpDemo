package mvtr.yuer.com.myyuyahaomvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvtr.yuer.com.myyuyahaomvpdemo.weight.ProgressBarVShowDialog;

/**
 * Created by yuer on 2018/6/5.
 */

public  class BaseActivity  extends AppCompatActivity{
    private ProgressBarVShowDialog progressBarVShowDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   public void showLoading(){
        if(progressBarVShowDialog == null){
            progressBarVShowDialog = new ProgressBarVShowDialog(this).setLoadingTip("正在加载数据...").showDialog();
        }else{
            progressBarVShowDialog.showDialog();
        }
    }

    public void dismissLoading(){
       if(progressBarVShowDialog != null){
           progressBarVShowDialog.dismissDialog();
       }
    }
}
