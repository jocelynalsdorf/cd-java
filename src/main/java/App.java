
import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   // get(/) type of route get this url..

    post("/cds", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String artist = request.queryParams("artist");
      String title = request.queryParams("title");
      Collection newCollection = new Collection(artist, title);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/cds", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("collections", Collection.all());
       model.put("template", "templates/cds.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

      // get("tasks/new" means you are starting a form)
      get("cds/new", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/cd-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/cds/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Collection collection = Collection.find(Integer.parseInt(request.params(":id")));
        model.put("collection", collection);
        model.put("template", "templates/cd.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

  }//end of main
}//end of class
