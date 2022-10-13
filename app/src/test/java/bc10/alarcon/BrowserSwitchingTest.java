package bc10.alarcon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSwitchingTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
    //driver.manage().window().fullscreen();
    }
    @Test
    void browserSwitchingTest() {
        driver = new EdgeDriver();
        //numero de ventana del driver
        String originalWindow = driver.getWindowHandle();
        driver.navigate().to("https://www.google.com.ar");
        //creamos new Window y nos cambiamos a esa ventana
        driver.switchTo().newWindow(WindowType.WINDOW);
        String window2 = driver.getWindowHandle();

        driver.navigate().to("https:www.google.cl");

        //Cambio a ventana 1
        driver.switchTo().window(originalWindow);
        //tab es nueva pestaña y window es nueva ventana
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https:selenium.dev");

        //cambio a la ventana 2
        //validar lo del tab, osea que debe quede en la segunda ventana
        driver.close();
        driver.switchTo().window(originalWindow);
        driver.close();
        driver.switchTo().window(window2);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https:selenium.dev");

    }
    /*@AfterEach
    void close(){
        driver.quit();
    }*/
}
