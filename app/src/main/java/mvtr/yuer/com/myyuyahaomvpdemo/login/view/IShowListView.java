package mvtr.yuer.com.myyuyahaomvpdemo.login.view;

import java.util.List;

import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.ListBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.Login;
import mvtr.yuer.com.myyuyahaomvpdemo.login.model.IListViewModel;

/**
 *所有的UI逻辑层
 * 1、接收Presenter层的数据信息
 * 2、显示和隐藏进度条
 */

public interface IShowListView {
    void showListView(List<ListBean> list);

    void login(Login login,boolean isSueecss,String msg);

    void showDialog();

    void dismissDialog();
}
