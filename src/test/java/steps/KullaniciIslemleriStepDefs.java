package steps;

import base.ReadConfigFile;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class KullaniciIslemleriStepDefs {

    ReadConfigFile readConfigFile=new ReadConfigFile();
    Response response;

    Logger logger= Logger.getLogger(KullaniciIslemleriStepDefs.class.getName());
    @Getter
    @Setter
    String requestIcerik;
    @Given("body icerigini {string} olarak ayarla")
    public void body_icerigini_olarak_ayarla(String bodyIcerigi) {
        setRequestIcerik(bodyIcerigi.replace("'","\"").replace("++","\n"));
        logger.info(getRequestIcerik());
    }
    @Given("{string} {string} {string} urline {string} methoduyla istek at")
    public void urline_methoduyla_istek_at(String domain, String urlUzantisi,String id, String istekTipi) {
        String fullURL;
        if (!id.isEmpty()) {
            fullURL = readConfigFile.readToProperties(domain) + urlUzantisi + readConfigFile.readToProperties(id);
        }
        else{
            fullURL = readConfigFile.readToProperties(domain)+urlUzantisi;
        }

        logger.info(fullURL);

        switch (istekTipi){
            case "get","GET","Get"->
                response=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(getRequestIcerik()).get(fullURL);
            case "post","POST","Post"->
                response=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(getRequestIcerik()).post(fullURL);
            case "delete","del","DEL","DELETE"->
                response=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(getRequestIcerik()).delete(fullURL);
            case "put","PUT","Put"->
                response=given().accept(ContentType.JSON).contentType(ContentType.JSON).body(getRequestIcerik()).put(fullURL);
        }

        System.out.println("\n-----------------------------------------\n");
        response.prettyPrint();
        System.out.println(istekTipi+" methodu ile istek atildi.");
        System.out.println("Status Code: "+response.statusCode());
        System.out.println("\n-----------------------------------------\n");
        logger.info(istekTipi+" methodu ile istek atildi.");
        logger.info("Status Code: "+response.statusCode());
        logger.info("Pretty Print:\n"+response.prettyPrint());
    }
    @Given("Status kod degerinin {int} oldugunu dogrula")
    public void status_kod_degerinin_oldugunu_dogrula(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(),statusCode);
        logger.info("Assert succes");
    }

}
