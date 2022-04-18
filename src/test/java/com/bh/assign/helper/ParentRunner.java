package com.bh.assign.helper;
/*
Author : Rahul jain
Updated: Sahil Bansal
*/

//import com.abcfinancial.bdd.helper.email.SimpleMailboxReader;
//import com.abcfinancial.bdd.helper.email.fixtures.Mailbox;
//import com.abcfinancial.bdd.utility.PropertyFileReader;
//import com.abcfinancial.bdd.utility.Utility;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import io.qameta.allure.ConfigurationBuilder;
//import io.qameta.allure.Extension;
//import io.qameta.allure.ReportGenerator;
//import io.qameta.allure.allure1.Allure1Plugin;
//import io.qameta.allure.allure2.Allure2Plugin;
//import io.qameta.allure.category.CategoriesPlugin;
//import io.qameta.allure.category.CategoriesTrendPlugin;
//import io.qameta.allure.context.FreemarkerContext;
//import io.qameta.allure.context.JacksonContext;
//import io.qameta.allure.context.MarkdownContext;
//import io.qameta.allure.context.RandomUidContext;
//import io.qameta.allure.core.*;
//import io.qameta.allure.duration.DurationPlugin;
//import io.qameta.allure.duration.DurationTrendPlugin;
//import io.qameta.allure.environment.Allure1EnvironmentPlugin;
//import io.qameta.allure.executor.ExecutorPlugin;
//import io.qameta.allure.history.HistoryPlugin;
//import io.qameta.allure.history.HistoryTrendPlugin;
//import io.qameta.allure.idea.IdeaLinksPlugin;
//import io.qameta.allure.influxdb.InfluxDbExportPlugin;
//import io.qameta.allure.launch.LaunchPlugin;
//import io.qameta.allure.mail.MailPlugin;
//import io.qameta.allure.owner.OwnerPlugin;
//import io.qameta.allure.prometheus.PrometheusExportPlugin;
//import io.qameta.allure.retry.RetryPlugin;
//import io.qameta.allure.retry.RetryTrendPlugin;
//import io.qameta.allure.severity.SeverityPlugin;
//import io.qameta.allure.status.StatusChartPlugin;
//import io.qameta.allure.suites.SuitesPlugin;
//import io.qameta.allure.summary.SummaryPlugin;
//import io.qameta.allure.tags.TagsPlugin;
//import io.qameta.allure.timeline.TimelinePlugin;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

// import static com.abcfinancial.bdd.helper.CustomJsonFormatter.featureMaps;
// import static com.abcfinancial.bdd.helper.CustomJsonFormatter.gson;

public class ParentRunner extends AbstractTestNGCucumberTests {
  private static final Logger LOGGER = LoggerFactory.getLogger(ParentRunner.class);
  //    PropertyFileReader dataReader = null;

  @AfterSuite
  public void onFinishReport() throws IOException {
    //        dataReader = PropertyFileReader.getInstance("application");
    //        try {
    //            FileUtils.deleteDirectory(new File("target/allure-results"));
    //            Utility.loadConfig();
    //
    //        } catch (IOException exception) {
    //            exception.printStackTrace();
    //        }
    //        System.setProperty("allure.results.directory", "target/allure-results");
    //        Runtime.getRuntime().addShutdownHook(new Thread() {
    //            public void run() {
    //                try {
    //                    final List<Extension> extensions = Arrays
    //                            .asList(new JacksonContext(), new MarkdownContext(), new
    // FreemarkerContext(), new RandomUidContext(), new MarkdownDescriptionsPlugin(), new
    // RetryPlugin(),
    //                                    new RetryTrendPlugin(), new TagsPlugin(), new
    // SeverityPlugin(), new OwnerPlugin(), new IdeaLinksPlugin(), new CategoriesPlugin(),
    //                                    new CategoriesTrendPlugin(), new HistoryPlugin(), new
    // HistoryTrendPlugin(), new DurationPlugin(), new DurationTrendPlugin(), new
    // StatusChartPlugin(),
    //                                    new TimelinePlugin(), new SuitesPlugin(), new
    // TestsResultsPlugin(), new AttachmentsPlugin(), new MailPlugin(), new InfluxDbExportPlugin(),
    //                                    new PrometheusExportPlugin(), new SummaryPlugin(), new
    // ExecutorPlugin(), new LaunchPlugin(), new Allure1Plugin(), new Allure1EnvironmentPlugin(),
    //                                    new Allure2Plugin(), new ReportWebPlugin());
    //
    //                    Configuration configuration = (new
    // ConfigurationBuilder()).fromExtensions(extensions).build();
    //                    Path resultDi = Paths.get(dataReader.getValue("resultDiPath"));
    //                    Path outDir = Paths.get(dataReader.getValue("outDirPath"));
    //                    new ReportGenerator(configuration).generate(outDir, resultDi);
    //
    //                    //to generate consolidated json
    //                    CustomJsonFormatter.out.append(gson.toJson(featureMaps));
    //                    CustomJsonFormatter.out.close();
    //
    // test execution on xray
    //                    String client_id = dataReader.getValue("client_id");
    //                    String client_secret = dataReader.getValue("client_secret");
    String client_id = "49DCFA4D27514DABA9DEE20560F30016";
    String client_secret = "8fa25c62a8917ff7abcfe51b4a97790c8b22b6a51dab1ec91c690449ff2e28e9";
    String urlXrayAuthenticate = "http://xray.cloud.xpand-it.com/api/v1/authenticate";
    String urlTargetDestination = "/target/cucumber/Destination/cucumber.json";
    String urlXrayExecution = "https://xray.cloud.xpand-it.com/api/v1/import/execution/cucumber";

    RequestSpecification requestBody =
        RestAssured.given().relaxedHTTPSValidation().header("Content-Type", "application/json");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("client_id", client_id);
    jsonObject.put("client_secret", client_secret);
    requestBody.body(jsonObject.toJSONString());
    System.out.println("getting request body" +requestBody.toString());

    Response response = requestBody.post(urlXrayAuthenticate);
    String authToken = response.asString();
    System.out.println("*****authentication token is *****" + authToken);

    LOGGER.info("*****authentication token is *****" + authToken);

    String finalToken = authToken.replace("\"", "");

    String path = System.getProperty("user.dir") + urlTargetDestination;
    String absolutePath = path.replace("/", "//");
    System.out.println("absolutePath of target" + absolutePath);

    String token = "Bearer " + finalToken;

    System.out.println("*****token for execution is *****" + token);

    // read cucumber json file
    String requestBodyFile = new String(Files.readAllBytes(Paths.get(absolutePath + "")));
    System.out.println("Cucumber json result File is" + requestBodyFile);

    LOGGER.info("File is" + requestBodyFile);

    // post request
    Response requestResponse =
        RestAssured.given()
            .relaxedHTTPSValidation()
            .header("Authorization", token)
            .header("Content-Type", "application/json")
            .relaxedHTTPSValidation()
            .body(requestBodyFile)
            .expect()
            .statusCode(200)
            .when()
            .post(urlXrayExecution)
            .then()
            .extract()
            .response();
    System.out.println("#################" + requestResponse.asString());

    LOGGER.info("#################" + requestResponse.asString());
    //
    //                } catch (Exception exception) {
    //                    exception.printStackTrace();
    //                }
    //            }
    //        });
    //    }
    //
    //
    //    @AfterSuite
    //    public void sendMail() {
    //        PropertyFileReader dataReader1 = PropertyFileReader.getInstance("emailConfig");
    //        String environment = PropertyFileReader.getInstance("env").getValue("env");
    //        if (environment.equalsIgnoreCase("pre")) {
    //            try {
    //
    //                SimpleMailboxReader mailbox = SimpleMailboxReader.withMailbox(new
    // Mailbox(dataReader1.getValue("username"), dataReader1.getValue("password"),
    // dataReader1.getValue("domain"), dataReader1.getValue("host")));
    //                File file = new File("./src/test/resources/temporyOrganization.ini");
    //                mailbox.sendEmailWithAttachment(file, "TEMP-ORG_" + environment, new
    // Mailbox(dataReader1.getValue("username"), dataReader1.getValue("password"),
    // dataReader1.getValue("domain"), dataReader1.getValue("host")));
    //            } catch (Exception exception) {
    //                exception.printStackTrace();
    //            }
    //        } else {
    //            LOGGER.info("current environment:" + environment);
    //        }
    //    }
  }
}





