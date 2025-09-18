
package ui_automationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginUI_automationTesting {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("UI Automation Testing --->");
       
         String expectedUsername = "Admin";
        String expectedPassword = "admin123";

        
        String[] actualUsernames = {"Admin", "Admin", "admin", "Admin", "Admin", ""};
        String[] actualPasswords = {"admin123", "Admin123", "admin123", "admin123", "admin123#", ""};

        
        for (int i = 0; i < actualUsernames.length; i++) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            try {
                Thread.sleep(3000);

                WebElement usernameField = driver.findElement(By.name("username"));
                WebElement passwordField = driver.findElement(By.name("password"));
                WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

                usernameField.sendKeys(actualUsernames[i]);
                passwordField.sendKeys(actualPasswords[i]);
                loginButton.click();

                Thread.sleep(5000);

              
                if (actualUsernames[i].equals(expectedUsername) && actualPasswords[i].equals(expectedPassword)) {
                   
                            if (driver.getCurrentUrl().contains("/dashboard")){
                              System.out.println("✅ Test case passed - " + (i + 1));  
                            }
                            else {
                            System.out.println("❌ Test case failed - " + (i + 1));
                            }
                    
                } 
                
                else if (driver.getCurrentUrl().contains("/dashboard")) {
                    System.out.println("❌ Test case failed - " + (i + 1));
                }
                
                else {
                    
                    System.out.println("✅ Test case passed - " + (i + 1)); 
                }

            } catch (Exception e) {
                System.out.println("❗ Error during test case " + (i + 1) + ": " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
       
    }
}
