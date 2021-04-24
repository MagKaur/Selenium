import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;


public class Selenium_Test {

    /*WebDriver driver = new ChromeDriver(new ChromeDriverService(C:\\Users\\Mango\\Desktop\\Instalki\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe));

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mango\\Desktop\\Instalki\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        */


    @Test
    public void ifClickButton() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mango\\Desktop\\Instalki\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://eve.ii.pw.edu.pl:9007");

        WebElement help = driver.findElement(By.id("showHelpWindowButton"));
        Thread.sleep(2000);
        help.click();
        Thread.sleep(2000);

        String h1Text = driver.findElement(By.xpath("//*[@class='ng-binding ng-scope']")).getAttribute("innerHTML");
        Assert.assertEquals("DnaAssembler - Help", h1Text);

        String url = driver.findElement(By.id("file_formats_href")).getAttribute("innerHTML");
        Assert.assertEquals("Input and output file formats", url);

        String url2 = driver.findElement(By.id("algorithms_href")).getAttribute("innerHTML");
        Assert.assertEquals("Parameters and algorithms used in application", url2);


        String h4 = driver.findElement(By.xpath("//h4[@class = 'ng-binding']")).getAttribute("innerHTML");
        String a = h4.split("<br>") [0];
        String b = h4.split("<br>") [1];
        Assert.assertEquals("For more information send an email:", a);
        Assert.assertEquals("r.m.nowak@elka.pw.edu.pl", b);

        String h3 = driver.findElement(By.xpath("//h3[@class = 'ng-binding']")).getAttribute("innerHTML");
        Assert.assertEquals("Authors", h3);

        String span = driver.findElement(By.xpath("//span[@id = 'authors']")).getAttribute("innerHTML");
        System.out.println(span);
        List<String> spans = Arrays.asList(span.split("<br>"));
        System.out.println(spans);
        spans.removeIf(n -> (n == "" ));
        System.out.println(spans);
        List<String> properSpans = Arrays.asList("Robert Nowak - r.m.nowak@elka.pw.edu.pl","Wiktor Kuśmirek, ",
                "Warsaw University of Technology,","Faculty of Electronics and Information Technology,","Warsaw 2015");


        }



    }

