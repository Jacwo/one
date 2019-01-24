package service.impl;

import com.alibaba.fastjson.JSONObject;
import service.Hello;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yyl
 * @date 2019年01月24日 17:58
 */
public class HelloImpl implements Hello {

    @Override
    public String sayHello(String str) {
        System.out.println("web services调用成功");
        String result = createXml(str);
        return result;
    }

    private String createXml(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<Result>");
        sb.append("<cinamaName>机械战警</cinamaName>");
        sb.append("</Result>");
        return sb.toString();
    }

    @Override
    public JSONObject sayJson(String str) {
        return createJsonObject(str);
    }

    private JSONObject createJsonObject(String str) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "liqineng");
        String[] likes = new String[] { "music", "movie", "study" };
        jsonObj.put("hobby", likes);
        Map<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("age", "23");
        jsonObj.put("message", ingredients);
        return jsonObj;
    }

    @Override
    public String sayJsonStr(String str) {
        return createJsonObject(str).toString();
    }

    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "liqineng");
        String[] likes = new String[] { "music", "movie", "study" };
        jsonObj.put("hobby", likes);
        Map<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("age", "23");
        jsonObj.put("message", ingredients);
        System.out.println(jsonObj);
    }
}
