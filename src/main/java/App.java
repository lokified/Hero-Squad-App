import models.Hero;
import static spark.Spark.*;

import models.Squad;
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


        //view heroes

        get("/heroes", (request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
            List<Hero> myHero= Hero.getAll();
            model.put("heroes",myHero);

            return new ModelAndView(model,"hero.hbs");
        }, new HandlebarsTemplateEngine());

        //show form to add hero
        get("/form",(request, response) -> {
            Map<String,Object> model = new HashMap<String,Object>();
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
            model.put("heroes",newHero);

            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());


        //details of individual hero
        get("heroes/:id" ,(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            int idHero = Integer.parseInt(request.params(":id"));
            Hero heroStats = Hero.findById(idHero);
            model.put("hero",heroStats);

            return new ModelAndView(model,"hero-detail.hbs");
        }, new HandlebarsTemplateEngine());


        //delete hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Hero deleteHero = Hero.findById(idOfHeroToDelete); //use it to find post
            deleteHero.deleteHero();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //show squad
        get("/squad",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Squad> mySquad = Squad.getAllSquad();
            model.put("squad",mySquad);
            return new ModelAndView(model,"squad.hbs");
        }, new HandlebarsTemplateEngine());


        //show form to add squad
        get("/form-squad",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            return new ModelAndView(model,"squad-form.hbs");
        }, new HandlebarsTemplateEngine());



        //process squad form
        post("/form-squad/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();

            String nameSquad= request.queryParams("name-squad");
            int number = Integer.parseInt(request.queryParams("number"));
            String mission = request.queryParams("mission");

            Squad newSquad = new Squad(nameSquad,number,mission);
            model.put("squad",newSquad);

            return new ModelAndView(model,"success-squad.hbs");
        }, new HandlebarsTemplateEngine());

    }
}