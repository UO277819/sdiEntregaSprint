package com.uniovi.sdientrega173.pageobjects;

import com.uniovi.sdientrega173.entities.Relationship;
import com.uniovi.sdientrega173.entities.User;
import com.uniovi.sdientrega173.repositories.UsersRepository;
import com.uniovi.sdientrega173.util.SeleniumUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddPublication(WebDriver driver, String titlep, String textp) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Rellenemos el campo de título y texto
        WebElement description = driver.findElement(By.name("title"));
        description.clear();
        description.sendKeys(titlep);
        WebElement score = driver.findElement(By.name("text"));
        score.click();
        score.clear();
        score.sendKeys(textp);
        By boton = By.id("add");
        driver.findElement(boton).click();
    }

    static public void signup(WebDriver driver, String email, String name, String lastname, String pass,
                              String passConfirm, String checkText) {
        // ir a registrarse
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        // rellenar el formulario
        PO_SignUpView.fillForm(driver, email, name, lastname, pass, passConfirm);
        // comprobaciones
        List<WebElement> result = checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    static public void login(WebDriver driver, String email, String pass, String checkText) {
        // ir al formulario de login
        clickOption(driver, "login", "class", "btn btn-primary");
        // rellenar el formuario
        PO_LoginView.fillLoginForm(driver, email, pass);
        // comprobaciones
        List<WebElement> result = checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    static public List<WebElement> waitLoadElementsDontExistByXpath(WebDriver driver, String xpath, int timeout)
    {
        Boolean result =
                (new WebDriverWait(driver, timeout)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        Assertions.assertTrue(result);
        return driver.findElements(By.xpath(xpath));
    }
    static public List<WebElement> waitLoadElementsDontExistBy(WebDriver driver, String criterio, String text, int timeout)
    {
        String searchCriterio;
        switch (criterio) {
            case "id":
                searchCriterio = "//*[contains(@id,'" + text + "')]";
                break;
            case "class":
                searchCriterio = "//*[contains(@class,'" + text + "')]";
                break;
            case "text":
                searchCriterio = "//*[contains(text(),'" + text + "')]";
                break;
            case "free":
                searchCriterio = text;
                break;
            default:
                searchCriterio = "//*[contains(" + criterio + ",'" + text + "')]";
                break;
        }

        return waitLoadElementsDontExistByXpath(driver, searchCriterio, timeout);
    }

    static public void logout(WebDriver driver) {
        //Ahora nos desconectamos y comprobamos que aparece el menú de registro
        String loginText = getP()
                .getString("signup.message", PO_Properties.getSPANISH());
        clickOption(driver, "logout", "class", "btn btn-primary");
    }

    static public void goToOwnPublications(WebDriver driver) {
        By menu_pub = By.id("publication-menu");
        driver.findElement(menu_pub).click();
        By own_pubs = By.id("own-publications");
        driver.findElement(own_pubs).click();
    }

    static public void goToFriendPublications(WebDriver driver, String idSearch){
        By menu_friends = By.id("friends-menu");
        driver.findElement(menu_friends).click();
        By my_friends = By.id("my-friends");
        driver.findElement(my_friends).click();

        By friend_name = By.id(idSearch);
        driver.findElement(friend_name).click();
    }

    static public void goToUsersList(WebDriver driver) {
        By listUsers = By.id("list users");
        driver.findElement(listUsers).click();
    }

    static public void changeLanguage(WebDriver driver, String lang) {
        By langBtn = By.id("btnLanguage");
        driver.findElement(langBtn).click();
        if (lang.equals("es")) {
            By spanish = By.id("btnSpanish");
            driver.findElement(spanish).click();
        } else if (lang.equals("en")) {
            By english = By.id("btnEnglish");
            driver.findElement(english).click();
        }
    }

    static public void goToLastPage(WebDriver driver) {
        By last = By.id("last-page");
        driver.findElement(last).click();
    }

    static public void goToFirstPage(WebDriver driver){
        By first = By.id("first-page");
        driver.findElement(first).click();
    }

    static public void goToNextPage(WebDriver driver) {
        List<WebElement> elements = checkElementBy(driver, "free", "//li[contains(@id,'pag')]/a");
        elements.get(0).click();
    }

    static public void addPublication(WebDriver driver, String title, String text) {
        List<WebElement> elements;
        // Pinchamos en la opción de menú de Publicaciones: //li[contains(@id, 'publication-menu')]/a
        By menu_pub = By.id("publication-menu");
        driver.findElement(menu_pub).click();
        //Esperamos a que aparezca la opción de añadir publicación: //a[contains(@href, 'publication/add')]
        By add_pub = By.id("add-publication");
        driver.findElement(add_pub).click();
        // agregamos los datos de los parámetros y pulsamos el botón de añadir
        fillFormAddPublication(driver, title, text);
    }
}
