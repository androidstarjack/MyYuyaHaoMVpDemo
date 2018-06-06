package mvtr.yuer.com.myyuyahaomvpdemo.login.model;

import java.util.List;

import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.IBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.ListBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.Login;

/**
 * Created by yuer on 2018/6/5.
 */

public interface IListViewModel {

   void   loadListData(OnLoadListData onLoadListData);



   //设置一个接口回调
    interface  OnLoadListData{
        void onloadData(List<ListBean> listBeans);
       void questError(Object obj);
   }

    void   loginIn(String name,String password,OnLoginInListener onLoginInListener);
    //设置一个接口回调
    interface  OnLoginInListener{
        void loginCallSuccess(Login t);
        void loginErroe(Object obj);
    }
}
