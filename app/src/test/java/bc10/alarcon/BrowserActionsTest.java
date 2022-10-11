package bc10.alarcon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserActionsTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();

    }
    @Test
    void browserActionTest(){
        String titulo;
        driver = new EdgeDriver();
        //abrir url web 1
        driver.get("https://www.google.com");
        titulo = driver.getTitle();
        System.out.println("El titulo de la url abierta es: " + titulo);
        //abrir url web 2
        driver.navigate().to("https://selenium.dev");
        titulo = driver.getTitle();
        System.out.println("El titulo de la url abierta es: " + titulo);
        //Back : volver atras
        driver.navigate().back();
        titulo = driver.getTitle();
        System.out.println("El titulo de la url abierta es: " + titulo);
        //Forward
        driver.navigate().forward();
        titulo = driver.getTitle();
        System.out.println("El titulo de la url abierta es: " + titulo);

        //dRefresh
        driver.navigate().refresh();


    }
    @AfterEach
    void close(){
        driver.quit();
    }
}
