package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.data.dataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class transferPage {
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private final SelenideElement amountInput = $("[data-test-id='amount'] input");
    private final SelenideElement fromInput = $("[data-test-id='from'] input");
    private final SelenideElement transferHead = $(byText("Пополнение карты"));
    private final SelenideElement errorMessage = $("[data-test-id='error-notification'] _notification__content");

    public transferPage() {

        transferHead.shouldBe(visible);
    }

    public dashboardPage makeValidTransfer(String amountToTransfer, dataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new dashboardPage();
    }

    public void makeTransfer(String amountToTransfer, dataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}