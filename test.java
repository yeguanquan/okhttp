```java
package com.test;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    public static void main(String[] args) throws IOException {
        String url = "http://111.230.220.37:4000/auth/token"; //接口地址
        MediaType JSON = MediaType.parse("application/json; charset=utf-8"); //指定body类型为json
        JSONObject json = new JSONObject(); //创建json对象
        json.put("grantType", "password"); //往json添加键值对
        json.put("password", "aha");
        json.put("phone", "18907891588");
        json.put("refreshToken", "elit ad consequat sed");
        json.put("verificationCode", "deserunt sed");
        RequestBody requestBody = RequestBody.create(JSON, String.valueOf(json)); //请求体为JSon
        Request request = new Request.Builder() //建立请求
                .url(url)
                .header("Content-Type", "application/json")
                .addHeader("Authorization", "")
                .post(requestBody)
                .build();
        Response response = okHttpClient.newCall(request).execute(); //获得响应
        if (response.isSuccessful()) { //如果响应成功
            String str = response.body().string(); //获得响应体的字符串
            JSONObject jsonObject = JSONObject.parseObject(str); //将字符串转换成json格式
            String str2 = jsonObject.get("data").toString(); //获得json的data键值对应的value,字符串格式
            JSONObject jsonObject2 = JSONObject.parseObject(str2); //继续将字符串转换成json
            System.out.println(jsonObject2.get("accessToken"));//获得json的accessToken键值对应的字符串
        }
    }
}
```
