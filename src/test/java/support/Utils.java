package support;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;


public class Utils extends RunBase {



    public static void esperarElementoClicavel(By element, Duration tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void esperarElementoVisivel(By element, Duration tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
    public static String getFileContent(String filePath) {
        BufferedReader br=null;
        StringBuilder sb=null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            br.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
