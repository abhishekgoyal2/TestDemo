package com.bh.assign.stepdef.UI;

import com.bh.assign.base.ui.UITestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.bh.assign.base.ui.UITestBase.setupWebdriverChromeDriver;

public class TestImplementationPagescroll {

    UITestBase testImplementation=new UITestBase();
    @Given("User is on a Page")
    public void user_is_on_a_page() {
        // Write code here that turns the phrase above into concrete actions
        setupWebdriverChromeDriver();
    }
    @Then("User scroll the page with key-press and  JavaScript Executer")
    public void user_scroll_the_page_with_java_script_executer() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
            testImplementation.pageScroll_Keypress_Executor();
        testImplementation.teardown();
        }


    @Then("Handling Frames in Selenium")
    public void handling_frames_in_selenium() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
            testImplementation.page_Handling_iFrame();
            testImplementation.teardown();
    }

    }

