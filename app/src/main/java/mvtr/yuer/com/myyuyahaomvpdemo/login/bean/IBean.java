package mvtr.yuer.com.myyuyahaomvpdemo.login.bean;

import java.io.Serializable;

/**
 * Created by yuer on 2018/6/5.
 */

public abstract class IBean<T> implements Serializable{
       abstract IBean<T>  parse(String obj);
}
