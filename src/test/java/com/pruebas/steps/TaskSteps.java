package com.pruebas.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class TaskSteps {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Dado("que el usuario navega a la aplicación de tareas en Selenium")
    public void navegarAApp() {
        driver.get("http://localhost:4200");
    }

    @Cuando("escribe la tarea {string} en el campo")
    public void escribirTarea(String tituloTarea) {
        WebElement input = driver.findElement(By.cssSelector("[data-cy='task-input']"));
        input.clear();
        input.sendKeys(tituloTarea);
    }

    @Cuando("hace clic en el botón de agregar tarea")
    public void clicAgregar() {
        driver.findElement(By.cssSelector("[data-cy='add-task-btn']")).click();
    }

    @Entonces("la tarea {string} debe mostrarse en la lista")
    public void verificarTareaAgregada(String tituloTarea) {
        WebElement taskList = driver.findElement(By.cssSelector("[data-cy='task-list']"));
        Assert.assertTrue("La tarea no fue encontrada en la lista", taskList.getText().contains(tituloTarea));
    }

    @Cuando("hace clic sobre la tarea {string}")
    public void hacerClicEnTarea(String tituloTarea) {
        WebElement taskElement = driver.findElement(By.xpath("//span[@data-cy='task-title' and contains(text(), '" + tituloTarea + "')]"));
        taskElement.click();
    }

    @Entonces("la tarea {string} debe marcarse como completada")
    public void verificarTareaCompletada(String tituloTarea) {
        WebElement parentLi = driver.findElement(By.xpath("//li[contains(@class, 'completed') and .//span[contains(text(), '" + tituloTarea + "')]]"));
        Assert.assertNotNull("La tarea no está marcada con la clase completed", parentLi);
    }

    @Cuando("elimina la tarea {string}")
    public void eliminarTarea(String tituloTarea) {
        WebElement deleteBtn = driver.findElement(By.xpath("//li[.//span[contains(text(), '" + tituloTarea + "')]]//button[@data-cy='delete-task-btn']"));
        deleteBtn.click();
    }

    @Entonces("la tarea {string} no debe existir en la lista")
    public void verificarTareaEliminada(String tituloTarea) {
        List<WebElement> elements = driver.findElements(By.xpath("//span[@data-cy='task-title' and contains(text(), '" + tituloTarea + "')]"));
        Assert.assertTrue("La tarea aún existe en la lista", elements.isEmpty());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}