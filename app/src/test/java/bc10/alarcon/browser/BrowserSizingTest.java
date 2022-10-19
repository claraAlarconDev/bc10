package bc10.alarcon.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSizingTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.com.ar");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.manage().window().fullscreen();
    }

    @Test
    void browserSize(){


        //largo y ancho de la ventana o browser

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().getHeight();
        //System.out.println(width);
        //System.out.println(height);

        //Dimension
        Dimension dm = driver.manage().window().getSize();
        int width2 = dm.getWidth();
        int height2 = dm.getHeight();

        // Cambiar el size en timepo de ejecucion
        driver.manage().window().setSize(new Dimension(600, 400));

    }
    @Test
    void browserPosition(){
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();

        //Point(Position)
        Point position = driver.manage().window().getPosition();
        int x1 = position.getX();
        int y1 = position.getY();


        //Change Position
        driver.manage().window().setPosition(new Point (0, 0));
    }
    @AfterEach
    void close(){
        driver.quit();
    }
}
