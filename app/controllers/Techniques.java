package controllers;

import static play.libs.Json.toJson;
import models.Technique;
import play.data.Form;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class Techniques extends Controller {
	static Form<Technique> taskForm = Form.form(Technique.class); 
	 
    public static Result all() {
        return ok(toJson(models.Technique.all()));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result add() {
    	System.err.println("body:" + request().body().asJson().toString());
    	Technique.create(Json.fromJson(request().body().asJson(), Technique.class));
        return ok(toJson(models.Technique.all()));
    }

}
