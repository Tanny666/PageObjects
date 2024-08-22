package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.data.dataHelper;

import static com.codeborne.selenide.Selenide.$;

public class loginPage {
    private final SelenideElement loginField = $("[data-test-id='login'] input");
    private final SelenideElement passwordField = $("[data-test-id='password'] input");
    private final SelenideElement loginButton = $("[data-test-id='action-login']");

    public verificationPage validLogin(dataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new verificationPage();
    }
}