
package Utilities;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;


public class JamaAPIUtilities {
    
    private static final Logger log = LogManager.getLogger(JamaAPIUtilities.class.getName());
    private static String jamaUrl = "https://reflexionhealth.jamacloud.com/rest/latest/testruns/";
    private static JSONObject jamaBody = new JSONObject();
    private static JSONObject fields = new JSONObject();
    private static JSONObject status = new JSONObject();
    private static JSONObject jamaRes = new JSONObject();
    private static int apiId;
    
    public static void testCaseJamaApiPass(int apiId) throws UnirestException {
        status.put("status", "PASSED");
        jamaBody.put("fields", fields);
        fields.put("testRunSteps", new JSONObject[] { status });
        fields.put("actualResults", "Automation Test Tool Results");
        HttpResponse<JsonNode> jamaReq = Unirest.put(jamaUrl + apiId)
                .header("content-type", "application/json")
                .header("authorization", "Basic YW5kcmVzLmdvbWV6Ojg4QWd6Xl9e")
                .body(jamaBody)
                .asJson();
        jamaRes = jamaReq.getBody().getObject();
        log.info("REST API PUT Test Results - " + jamaRes.getJSONObject("meta").getString("status"));
    }
    
    public static void testCaseJamaApiFail(int apiId) throws UnirestException {
        status.put("status", "FAILED");
        jamaBody.put("fields", fields);
        fields.put("testRunSteps", new JSONObject[] { status });
        HttpResponse<JsonNode> jamaReq = Unirest.put(jamaUrl + apiId)
                .header("content-type", "application/json")
                .header("authorization", "Basic YW5kcmVzLmdvbWV6Ojg4QWd6Xl9e")
                .body(jamaBody)
                .asJson();
        jamaRes = jamaReq.getBody().getObject();
        log.info("REST API PUT Test Result - " + jamaRes.getJSONObject("meta").getString("status"));
    }

    public static void setApiId(int ID) {
        apiId = ID;
    }

    public static int getIncApiId() {
        return apiId++;
    }
}
