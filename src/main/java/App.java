import models.Hero;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        //shows homepage
        get("/",(request,response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


        //show form to add hero
        get("/form",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process new form
        post("/form/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String powers = request.queryParams("powers");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,powers,weakness);
            model.put("heros",newHero);

            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        //view heroes

        get("/heroes", (request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Hero> myHero= Hero.getAll();
            model.put("hero",myHero);

            return new ModelAndView(model,"hero.hbs");
        }, new HandlebarsTemplateEngine());
    }
}