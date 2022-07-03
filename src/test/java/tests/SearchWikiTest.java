package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchWikiTest extends TestBase{
    @Test
    void searchWikiTest() {
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Grand Theft Auto");
        });
        step("Verify content found", () -> {
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
        step("Open article", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
                $(AppiumBy.className("android.widget.TextView")).shouldHave(Condition.text("GTA"));
        });
    }
}
