package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Response;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.Map;

public class BaseController extends Controller {

    protected  <T> Result formJsonResponse(T data, String name){
        Map<String,T> dataObj = new HashMap<>();
        dataObj.put(name, data);
        Response response = new Response();
        response.setData(dataObj);
        Gson gson = new GsonBuilder().serializeNulls().create();
        return ok(gson.toJson(response)).as("application/json");
    }

    protected <T> T getRequestData(Class<T> clazz){
        Gson gson = new Gson();
        return gson.fromJson(request().body().asJson().toString(), clazz);
    }
}
