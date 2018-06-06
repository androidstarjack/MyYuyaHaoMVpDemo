package mvtr.yuer.com.myyuyahaomvpdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvtr.yuer.com.myyuyahaomvpdemo.R;
import mvtr.yuer.com.myyuyahaomvpdemo.login.adapter.ShowListAdapter;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.ListBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.Login;
import mvtr.yuer.com.myyuyahaomvpdemo.login.presenter.ListLoginDataPresenter;
import mvtr.yuer.com.myyuyahaomvpdemo.login.view.IShowListView;
import mvtr.yuer.com.myyuyahaomvpdemo.utils.GetToast;
import mvtr.yuer.com.myyuyahaomvpdemo.weight.ProgressBarVShowDialog;

/**
 * Created by yuer on 2018/6/5.
 */

public class LoginActivity extends BaseActivity implements IShowListView {
    private ListView lv_list;
    private ListLoginDataPresenter presenter;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.et_account)
    EditText et_account;
    @Bind(R.id.btn_cancle)
    Button btn_cancle;
    @Bind(R.id.btn_ok)
    Button btn_ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_simple);
        ButterKnife.bind(this);
        lv_list = findViewById(R.id.lv_list);
        presenter =  new ListLoginDataPresenter<>(this);
    }

    @Override
    public void showListView(List<ListBean> list) {
            if(list !=null){
                lv_list.setAdapter(new ShowListAdapter(this,list));
            }
    }

    @Override
    public void login(Login login, boolean isSueecss, String msg) {
        try{
            if(isSueecss){
                GetToast.useString("登录成功");
                presenter.fecthDataView();
            }else{
                GetToast.useString(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void showDialog() {
        showLoading();
    }

    @Override
    public void dismissDialog() {
        dismissLoading();
    }

    @OnClick({R.id.btn_cancle,R.id.btn_ok})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_cancle:
                et_account.setText("13594347817");
                et_password.setText("123456");
                break;
            case R.id.btn_ok:
                String name = et_account .getText().toString();
                String pass = et_password .getText().toString();
                presenter.login(name,pass);
                break;
        }
    }

}
