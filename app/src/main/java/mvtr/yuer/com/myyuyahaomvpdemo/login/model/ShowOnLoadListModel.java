package mvtr.yuer.com.myyuyahaomvpdemo.login.model;

import android.os.SystemClock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mvtr.yuer.com.myyuyahaomvpdemo.impl.user.retorfit.ApiService;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.ListBean;
import mvtr.yuer.com.myyuyahaomvpdemo.login.bean.Login;
import mvtr.yuer.com.myyuyahaomvpdemo.utils.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *这一程主要是向数据源（一般为服务器，数据库）发起数据请求，把获取到的数据或者是错误信息传递给持有的presenter
 * 除了发起请求之外还有，取消请求
 *  1、向数据源发起请求
 *  2、取消发起的请求
 *  3、通知presenter去处理结果
 */

public class ShowOnLoadListModel implements IListViewModel{




    @Override
    public void loadListData(final OnLoadListData onLoadListData) {
//        try {
//         /*   Thread.sleep(2000);*/
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        SystemClock.sleep(1000);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //https://www.apiopen.top/login?key=00d91e8e0cca2b76f515926a36db68f5&phone=13594347817&passwd=123456
        HashMap hashMap = new HashMap();
        hashMap.put("page","1");
        apiService.getBeautifulQuestList(hashMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    int code = jsonObject.optInt("code");
                    if(code == 200){
                        String success = jsonObject.optString("data");
                        Gson gson = new Gson();
                        List<ListBean> list =   gson.fromJson(success.toString(),new TypeToken< List<ListBean>>(){}.getType());
                        onLoadListData.onloadData(list);
                    }else{
                        String error =  jsonObject.optString("msg");
                        onLoadListData.questError(error);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onLoadListData.questError(t.toString());
            }
        });
        //这来可以进行网络请求
        //模拟假数据了
//        List<ListBean> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            ListBean listBean = new  ListBean();
//            listBean.setName("战斗值：  "+i);
//            list.add(listBean);
//        }
//        onLoadListData.onloadData(list);
    }

    @Override
    public void loginIn(String name, String password, final OnLoginInListener onLoginInListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //https://www.apiopen.top/login?key=00d91e8e0cca2b76f515926a36db68f5&phone=13594347817&passwd=123456
        HashMap hashMap = new HashMap();
        hashMap.put("key","00d91e8e0cca2b76f515926a36db68f5");
        hashMap.put("phone",name);
        hashMap.put("passwd",password);
        apiService.loginQuest(hashMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogUtils.e("yyh",response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    int code = jsonObject.optInt("code");
                    if(code == 200){
                        String success = jsonObject.optString("data");
                        Gson gson = new Gson();
                        Login login =   gson.fromJson(success.toString(),Login.class);
                        onLoginInListener.loginCallSuccess(login);
                    }else{
                        String error =  jsonObject.optString("msg");
                        onLoginInListener.loginErroe(error);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onLoginInListener.loginErroe(t.toString());
            }
        });
    }

//    @Override
//    public void loginIn(String name, String password) {
//        if(name.equals("111") && password.equals("2111")){
//
//        }
//    }



//    @Override
//    public void loginIn(OnLoginInListener onLoginInListener) {
//        if(onLoginInListener !=null){
//            onLoginInListener.login();
//        }
//    }
}
