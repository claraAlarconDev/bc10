package bc10.alarcon.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WebElementsTest {
    WebDriver driver;
    //de esta forma buscamos y declaramos en un solo paso
    @FindBy(xpath = "//input[contains(@name, 'q')]")
    WebElement barraBusqueda;
    @FindBy(name = "btnK")
    WebElement btnBuscarGoogle;


    //Localizators Ej 1
    @FindBy(xpath="//input[@class='Fractal-SearchBar--searchbar ']")
    WebElement searchBar;
    @FindBy(className = "Fractal-SearchBar--button")
    WebElement btn;
    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[4]/section[16]/div/div[1]/span/span[2]/ul/li[3]/a")
    WebElement spLab;
   @FindBy(xpath = "//span[contains(a, 'Pagos')]")
    WebElement payment;
    @FindBy(xpath ="//a[contains(span, 'Quiénes somos')]" )
       WebElement whoAreWe;
    @FindBy(xpath = "//div[@class = 'Fractal-Header__logo--wrapper']")
    WebElement btnHome;


        //MercadoLibre using XPATH

    @FindBy(xpath = "//a[@class = 'nav-menu-cp nav-menu-cp-logged']")
    WebElement geoCode;
    By iframeLocalizador = By.cssSelector(".andes-modal-dialog > iframe:nth-child(1)");
    //By iframeSearchBarLocalizator = By.xpath("//input[@name = 'zipcode']");
    @FindBy(xpath = "//input[@name = 'zipcode']")
    WebElement iframeSearchBar;
    @FindBy(xpath = "//button[@class = 'andes-button zip-code__use-button andes-button--medium andes-button--loud']")
    WebElement iframeSearchBtn;

    @FindBy(xpath = "//a[@id = 'view_more']")
    WebElement benefitsBtn;
    @FindBy(xpath = "//a[@class = 'nav-logo']")
    WebElement homeBtn;
    @FindBy(xpath = "//*[@id='nav-header-menu']/a[1]")
    WebElement createAccount;
    @FindBy(xpath ="//input[@id= 'terms-and-conds']" )
    WebElement createAccountAuthorizeBtn;
    @FindBy(xpath = "//a[contains(text(), 'Trabajá con nosotros')]")
    WebElement workWithUs;
    @FindBy(xpath = "//a[contains(text(), 'Ver oportunidades')]")
    WebElement oportunitiesBtn;


    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    //Google
    @Test
    void searchGoogle() throws InterruptedException {
        driver.get("https://www.google.com.ar");
        barraBusqueda.clear();
        barraBusqueda.sendKeys("Tsoft");
        barraBusqueda.sendKeys(Keys.ESCAPE);
        Thread.sleep(3000);
        btnBuscarGoogle.click();
        Assertions.assertEquals("Tsoft - Buscar con Google", driver.getTitle());
    }

    @Test
    void searchSpDigital() {
        driver.get("https://www.spdigital.cl/");

        searchBar.clear();
        searchBar.sendKeys("Corsair");
        searchBar.sendKeys(Keys.ESCAPE);
        btn.click();
        //btnHome.click();

        whoAreWe.click();
        //btnHome.click();

        //payment.click();
        //btnHome.click();

        spLab.click();
        //btnHome.click();



    }

    @Test
    void whoTest(){
        driver.get("https://www.spdigital.cl/");

        whoAreWe.click();
        homeBtn.click();


    }

    @Test
    void paymentTest(){
        driver.get("https://www.spdigital.cl/");
        driver.findElement(By.xpath("//span[contains(a, 'Pagos')]")).click();
        driver.findElement(By.xpath("//div[@class = 'Fractal-Header__logo--wrapper']")).click();
        //payment.click();
        //driver.navigate().back();



    }

    @Test
    void SPLabs(){
       driver.get("https://www.spdigital.cl/");
        spLab.click();
        driver.navigate().back();


    }





/*
elemento - Enviar a Capital federal

modificar lugar *

elemento - ver todos los beneficios

acceder al link y devolverse a la home

elemento - crea tu cuenta

acceder al link

sacar foto

devolverse al home
elemento - trabaja con nosotros
acceder
presionar boton ver oportunidades
sacar foto
devolverse al Home
 */

    @Test
    void mercadoLibreTest() throws IOException {
        driver.get("https://www.mercadolibre.com.ar/");
        geoCode.click();
        //aca vendria lo del iframe no se como se deberia poner

        driver.findElement(By.xpath("(//li[@class='nav-menu-item']/a)[1]")).click();
        driver.switchTo().frame(driver.findElement(iframeLocalizador));
        driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input")).sendKeys("5300");
        driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/div/button/span")).click();
        /*
        iframeSearchBar.clear();
        iframeSearchBar.sendKeys("1623");
        iframeSearchBtn.click();

         */
        benefitsBtn.click();
        //driver.navigate().back();
        homeBtn.click();
        createAccount.click();
        createAccountAuthorizeBtn.click();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image2.png"));
        //driver.navigate().back();
        homeBtn.click();
        workWithUs.click();
        oportunitiesBtn.click();
        FileUtils.copyFile(scrFile, new File("./image3.png"));
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test
    void inputGeoCodeTest() {
        driver.get("https://www.mercadolibre.com.ar/");
        driver.findElement(By.xpath("(//li[@class='nav-menu-item']/a)[1]")).click();
        driver.switchTo().frame(driver.findElement(iframeLocalizador));
        driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input")).sendKeys("1623");
        driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/div/button/span")).click();
    }
    @AfterEach
    void clean(){
        //driver.close();
    }
}
