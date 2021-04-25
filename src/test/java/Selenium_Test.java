import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Selenium_Test {

    WebDriver driver;
    String testWeb = "http://eve.ii.pw.edu.pl:9007";

    @Before
    public void SetUpDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mango\\Desktop\\Instalki\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    @After
    public void QuitDriver() {

        driver.close();
        driver.quit();
    }

    @Test
    public void ifPossibleMoveToHelpPage() {

        driver.navigate().to(testWeb);
        driver.manage().window().maximize();

        WebElement help = driver.findElement(By.id("showHelpWindowButton"));
        help.click();
        Assert.assertEquals("http://eve.ii.pw.edu.pl:9007/#/help", driver.getCurrentUrl());
    }

    @Test
    public void engTest() {

        ifPossibleMoveToHelpPage();
        String h1Text = driver.findElement(By.xpath("//*[@class='ng-binding ng-scope']")).getAttribute("innerHTML");
        Assert.assertEquals("DnaAssembler - Help", h1Text);

        String url = driver.findElement(By.id("file_formats_href")).getAttribute("innerHTML");
        Assert.assertEquals("Input and output file formats", url);

        String url2 = driver.findElement(By.id("algorithms_href")).getAttribute("innerHTML");
        Assert.assertEquals("Parameters and algorithms used in application", url2);


        String h4 = driver.findElement(By.xpath("//h4[@class = 'ng-binding']")).getAttribute("innerHTML");
        String a = h4.split("<br>")[0];
        String b = h4.split("<br>")[1];
        Assert.assertEquals("For more information send an email:", a);
        Assert.assertEquals("r.m.nowak@elka.pw.edu.pl", b);

        String h3 = driver.findElement(By.xpath("//h3[@class = 'ng-binding']")).getAttribute("innerHTML");
        Assert.assertEquals("Authors", h3);

        String span = driver.findElement(By.xpath("//span[@id = 'authors']")).getAttribute("innerHTML");
        System.out.println(span);
        List<String> spans = Arrays.asList(span.split("<br>"));
        System.out.println(spans);
        spans.removeIf(n -> (n == ""));
        System.out.println(spans);
        List<String> properSpans = Arrays.asList("Robert Nowak - r.m.nowak@elka.pw.edu.pl", "Wiktor Kuśmirek, ",
                "Warsaw University of Technology,", "Faculty of Electronics and Information Technology,", "Warsaw 2015");


        WebElement divDown = driver.findElement(By.id("right_col"));
        String divText = divDown.findElement(By.xpath("//h3[@class = 'ng-binding' and text()='Application parameters']")).getAttribute("innerHTML");
        Assert.assertEquals("Application parameters", divText);


        String serv = driver.findElement(By.id("server_time")).getAttribute("innerHTML");
        String c = serv.split("<em id=\"server_time_val\" class=\"ng-binding\">")[0];
        String date2 = serv.split("<em id=\"server_time_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("server time: ", c);
        Assert.assertTrue(date2 != null);

        String db = driver.findElement(By.id("db_version")).getAttribute("innerHTML");
        System.out.println(db);
        String dbver = db.split("<em id=\"db_version_val\" class=\"ng-binding\">")[0];
        String dbText = db.split("<em id=\"db_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("db version: ", dbver);
        Assert.assertEquals("PostgreSQL 9.4.18 on x86_64-unknown-linux-gnu", dbText);


        String server = driver.findElement(By.id("server_version")).getAttribute("innerHTML");
        System.out.println(server);
        String servver = server.split("<em id=\"server_version_val\" class=\"ng-binding\">")[0];
        String servText = server.split("<em id=\"server_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("server version: ", servver);
        Assert.assertEquals("0.07.1635; Python: 3.5.3; Arch: ; Os: Linux #1 SMP Debian 4.9.110-1 (2018-07-05); Django: 2.0.2", servText);

        String client_version = driver.findElement(By.id("client_version")).getAttribute("innerHTML");
        System.out.println(client_version);
        String clientver = client_version.split("<em id=\"client_version_val\" class=\"ng-binding\">")[0];
        String clientText = client_version.split("<em id=\"client_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("client version: ", clientver);
        Assert.assertEquals("0.06.1634", clientText);
    }

        //--------------------------------------------------------------------------

    @Test
        public void ifPossibleChangeLangToPL() throws InterruptedException {

        ifPossibleMoveToHelpPage();
        WebElement pl = driver.findElement(By.id("a_lang_pl"));
        pl.click();
        Thread.sleep(4000);
        String helppl= driver.findElement(By.id("showHelpWindowButton")).getAttribute("innerHTML");
        Assert.assertEquals("Pomoc",helppl);
    }


    @Test
        public void plTest() throws InterruptedException {

        ifPossibleChangeLangToPL();

        String h1Text = driver.findElement(By.xpath("//*[@class='ng-binding ng-scope']")).getAttribute("innerHTML");
        Assert.assertEquals("DnaAssembler - Pomoc", h1Text);

        String url = driver.findElement(By.id("file_formats_href")).getAttribute("innerHTML");
        Assert.assertEquals("Formaty plików wejściowych i wyjściowych", url);

        String url2 = driver.findElement(By.id("algorithms_href")).getAttribute("innerHTML");
        Assert.assertEquals("Parametry i algorytmy wykorzystane w aplikacji", url2);

        String h4 = driver.findElement(By.xpath("//h4[@class = 'ng-binding']")).getAttribute("innerHTML");
        String a = h4.split("<br>")[0];
        String b = h4.split("<br>")[1];
        Assert.assertEquals("Uzyskaj więcej informacji wysyłając wiadomość:", a);
        Assert.assertEquals("r.m.nowak@elka.pw.edu.pl", b);

        String h3 = driver.findElement(By.xpath("//h3[@class = 'ng-binding']")).getAttribute("innerHTML");
        Assert.assertEquals("Autorzy", h3);

        String span = driver.findElement(By.xpath("//span[@id = 'authors']")).getAttribute("innerHTML");
        System.out.println(span);
        List<String> spans = Arrays.asList(span.split("<br>"));
        System.out.println(spans);
        spans.removeIf(n -> (n == ""));
        System.out.println(spans);
        List<String> properSpans = Arrays.asList("Robert Nowak - r.m.nowak@elka.pw.edu.pl", "Wiktor Kuśmirek, ",
                "Politechnika Warszawska,", "Wydział Elektroniki i Technik Informacyjnych,", "Warszawa 2015");


        WebElement divDown = driver.findElement(By.id("right_col"));
        String divText = divDown.findElement(By.xpath("//h3[@class = 'ng-binding' and text()='Parametry aplikacji']")).getAttribute("innerHTML");
        Assert.assertEquals("Parametry aplikacji", divText);

//UTC+2 - Pl // server UTC
        String serv = driver.findElement(By.id("server_time")).getAttribute("innerHTML");
        LocalDateTime localTime = LocalDateTime.now(Clock.systemUTC());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localFormatted = localTime.format(formatter);
        String c = serv.split("<em id=\"server_time_val\" class=\"ng-binding\">")[0];
        String serverTime = serv.split("<em id=\"server_time_val\" class=\"ng-binding\">|</em>")[1];
        System.out.println(serverTime);
        System.out.println(localFormatted);
        Assert.assertEquals(localFormatted, serverTime);
        //Assert.assertTrue(serverTime != null);
        Assert.assertEquals("czas serwera: ", c);

        String db = driver.findElement(By.id("db_version")).getAttribute("innerHTML");
        System.out.println(db);
        String dbver = db.split("<em id=\"db_version_val\" class=\"ng-binding\">")[0];
        String dbText = db.split("<em id=\"db_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("wersja bazy danych: ", dbver);
        Assert.assertEquals("PostgreSQL 9.4.18 on x86_64-unknown-linux-gnu", dbText);


        String server = driver.findElement(By.id("server_version")).getAttribute("innerHTML");
        System.out.println(server);
        String servver = server.split("<em id=\"server_version_val\" class=\"ng-binding\">")[0];
        String servText = server.split("<em id=\"server_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("wersja serwera: ", servver);
        Assert.assertEquals("0.07.1635; Python: 3.5.3; Arch: ; Os: Linux #1 SMP Debian 4.9.110-1 (2018-07-05); Django: 2.0.2", servText);

        String client_version = driver.findElement(By.id("client_version")).getAttribute("innerHTML");
        System.out.println(client_version);
        String clientver = client_version.split("<em id=\"client_version_val\" class=\"ng-binding\">")[0];
        String clientText = client_version.split("<em id=\"client_version_val\" class=\"ng-binding\">|</em>")[1];
        Assert.assertEquals("wersja klienta: ", clientver);
        Assert.assertEquals("0.06.1634", clientText);
    }
}



















