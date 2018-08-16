package controllers;

import Services.UserService;
import com.google.inject.Inject;
import models.User;
import play.mvc.BodyParser;
import play.mvc.Result;
public class UserController extends BaseController {

    @Inject
    UserService userService;

    @BodyParser.Of(BodyParser.Json.class)
    public Result createUser(){
        User user = getRequestData(User.class);
        return formJsonResponse(userService.createUser(user),"user");
    }


    public Result getUserById(String id){
        return formJsonResponse(userService.getUserById(id),"user");

    }

    public Result getAllUsers() {
        return formJsonResponse(userService.getAllUsers(),"users");
    }
}
