package com.example.demo.Controllers;

import com.example.demo.Dto.GameServerInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index");
    }

    @PostMapping("/start")
    public String Start(@RequestBody String gameServerInfo){
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {

            HttpPost request = new HttpPost("http://37.151.106.142:8585/create");
            StringEntity params = new StringEntity(gameServerInfo);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            return responseString;
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

    }
}
