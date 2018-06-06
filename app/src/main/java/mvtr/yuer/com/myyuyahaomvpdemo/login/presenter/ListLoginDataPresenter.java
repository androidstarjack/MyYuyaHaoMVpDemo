package mvtr.yuer.com.myyuyahaomvpdemo.login.presenter;

import android.os.SystemClock;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.locks.Lock;

import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.IBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.ListBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.Login;
import mvtr.yuer.com.myyuyahaomvpdemo.login.model.IListViewModel;
import mvtr.yuer.com.myyuyahaomvpdemo.login.model.ShowOnLoadListModel;
import mvtr.yuer.com.myyuyahaomvpdemo.login.view.IShowListView;
import mvtr.yuer.com.myyuyahaomvpdemo.utils.GetToast;

/**
 *  p层的作用:
 *   1、通知Model层向服务器发出数据请求
 *  2、接收数据 正确
 *  3、接收model返回的错误信息
 *
 *  通知model取消这次请求
 *  通知View层接收处理后的数据
 */

public class ListLoginDataPresenter<T extends IShowListView> {
    //1、View层的引用
    WeakReference<T> mView = null;

    //2、molde层的引用
    IListViewModel iListViewModel;

    public ListLoginDataPresenter(T mView){
        this.mView = new WeakReference<T>(mView);
        iListViewModel = new ShowOnLoadListModel();
    }

    //3、执行UI罗杰操作
    public void fecthDataView(){

        if(mView.get() != null && iListViewModel != null){
            mView.get().showDialog();
            iListViewModel.loadListData(new IListViewModel.OnLoadListData() {
                @Override
                public void onloadData(List<ListBean> listBeans) {
                    mView.get().showListView(listBeans);
                    mView.get().dismissDialog();
                }

                @Override
                public void questError(Object obj) {
                    mView.get().dismissDialog();
                    GetToast.useString(obj.toString());
                }
            });
        }
    }

    //3、执行登录接口
    public void login(String name,String password){
        mView.get().showDialog();
        if(mView.get() != null && iListViewModel != null){
            iListViewModel.loginIn(name, password, new IListViewModel.OnLoginInListener() {
                @Override
                public void loginCallSuccess(Login iBean) {
                    mView.get().login(iBean,true,"");
                    mView.get().dismissDialog();
                }



                @Override
                public void loginErroe(Object obj) {
                    mView.get().login(null,false,obj.toString());
                    mView.get().dismissDialog();
                }
            });
        }
    }
}
