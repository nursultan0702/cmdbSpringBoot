package com.example.demo.Controllers;

import com.example.demo.Dto.GameServerInfo;
import com.example.demo.Dto.User;
import com.example.demo.Repositories.GameServerInfoRepository;
import com.example.demo.Repositories.UserService;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Random;

@Controller
public class IndexController {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    GameServerInfoRepository gameServerInfoRepository;

    @Autowired
    UserService userService;

    final String STEAM_API_KEY = "C733122E422C2C55CD2903C2760BAB2C";


    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index","steamId","default");
    }

    @PostMapping("/start")
    public String Start(@RequestBody GameServerInfo gameServerInfo){
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {

            HttpPost request = new HttpPost("http://37.151.106.142:8585/create");
            StringEntity params = new StringEntity(gameServerInfo.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            gameServerInfoRepository.save(gameServerInfo);
            return responseString;
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

    }

    @PostMapping("/registration")
    public String Registration(@RequestBody User user){
        String password = RegistrationEmail(user);
        user.setPassword(password);
        userService.save(user);
        return "";
    }

    @RequestMapping("/registrationMail")
    @ResponseBody
    public String RegistrationEmail(@RequestBody User user) {
        try {
            String password = sendEmail(user);
            return password;
        } catch (Exception ex) {
            return "Error in sending email: " + ex;
        }
    }

    private String sendEmail(User user) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(user.getEmail());
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        helper.setText("<html><body>Here is a your password : "+generatedString+"</html>", true);
        helper.setSubject("Registration Cyber.kz");
        sender.send(message);
        return generatedString;
    }

    @RequestMapping("/steamid")
    public ModelAndView RegSteam(String steamid){
        if(steamid==null){
            return new ModelAndView("redirect:"+"http://localhost:4567/trade");
        }
        return new ModelAndView("lobby.html");
    }

    @RequestMapping("/getfriends")
    public String GetFrinds(String steamid){
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key="+STEAM_API_KEY+"&steamid="+steamid+"&relationship=friend");
            request.addHeader("content-type", "application/json");
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(responseString);
            return responseString;
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }


}
