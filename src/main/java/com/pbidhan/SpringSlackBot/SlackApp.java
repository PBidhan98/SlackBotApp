package com.pbidhan.SpringSlackBot;

import com.slack.api.bolt.App;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
  @Bean
  public App initSlackApp() {
    App app = new App();
    app.command("/hello", (req, ctx) -> {
      return ctx.ack("What's up?");
    });
    
    app.command("/echo", (req, ctx) -> {
    	  String commandArgText = req.getPayload().getText();
    	  String channelId = req.getPayload().getChannelId();
    	  String channelName = req.getPayload().getChannelName();
    	  String text = "You said " + commandArgText + " at <#" + channelId + "|" + channelName + ">";
    	  System.out.println(text);
    	  return ctx.ack(text); // respond with 200 OK
    	});
    
    return app;
  }
}