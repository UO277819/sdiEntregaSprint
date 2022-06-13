package com.uniovi.sdientrega173.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_SearchView extends PO_NavView {
	static public void fillForm(WebDriver driver, String searchTextp) {
		
		WebElement searchText = driver.findElement(By.name("searchText"));
		searchText.click();
		searchText.clear();
		searchText.sendKeys(searchTextp);

		// Pulsar el boton de Buscar.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}