import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();



  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Library for Your CD Collection");
  }

  @Test
  public void collectionIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new CD"));
    fill("#title").with("Mi Tierra");
    fill("#artist").with("GloriaEstefan");
    submit(".btn");
    assertThat(pageSource()).contains("Your collection has been saved.");
  }

  @Test
  public void collectionIsDisplayedTest() {
    goTo("http://localhost:4567/cds/new");
    fill("#title").with("Mi Tierra");
    fill("#artist").with("GloriaEstefan");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Mi Tierra");

  }



}
