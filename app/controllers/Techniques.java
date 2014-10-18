package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Techniques extends Controller {

    public static Result all() {
        return ok("{'juho': {}, 'goho':{}}");
    }

}
