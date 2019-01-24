package service;

import com.alibaba.fastjson.JSONObject;

import javax.jws.WebService;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2019年01月24日 17:56
 */
@WebService
public interface Hello {
    public String sayHello(String str);

    public JSONObject sayJson(String str);

    public String sayJsonStr(String str);
}
