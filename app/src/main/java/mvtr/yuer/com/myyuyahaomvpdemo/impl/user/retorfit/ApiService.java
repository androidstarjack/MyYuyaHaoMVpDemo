package mvtr.yuer.com.myyuyahaomvpdemo.impl.user.retorfit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 类功能描述：</br>
 * P层:
 * 特点：MVP+retrofit+Rxjava封装和学习
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public interface ApiService {
    //https://www.apiopen.top/login?key=00d91e8e0cca2b76f515926a36db68f5&phone=13594347817&passwd=123456
    //https://www.apiopen.top/meituApi?page=1
    @GET("/login")
    Call<String> loginQuest(@QueryMap HashMap<String,Object> paramsMap);

    @GET("/meituApi")
    Call<String> getBeautifulQuestList(@QueryMap HashMap<String,Object> paramsMap);
}
