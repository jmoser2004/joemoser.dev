package dev.joemoser.jmdevbackend.ChatGPT_Models;

import java.util.List;

public class RequestModel
{
    private String model;
    private Message[] messages;
    private int max_tokens;
    private int temperature;

    public RequestModel()
    {
        model = "gpt-3.5-turbo";
        messages = new Message[]{new Message()};
        max_tokens = 1000;
        temperature = 1;
    }

    public RequestModel(List<Message> input)
    {
        model = "gpt-3.5-turbo";
        messages = input.toArray(new Message[0]);
        max_tokens = 1000;
        temperature = 1;
    }

    public RequestModel(String model, Message[] messages, int max_tokens, int temperature)
    {
        this.model = model;
        this.messages = messages;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
    }

    public String getModel(){return model;}
    public Message[] getMessages(){return messages;}
    public int getMax_tokens(){return max_tokens;}
    public int getTemperature(){return temperature;}

    public void setModel(String model){this.model = model;}
    public void setMessages(Message[] messages){this.messages = messages;}
    public void setMax_tokens(int max_tokens){this.max_tokens = max_tokens;}
    public void setTemperature(int temperature){this.temperature = temperature;}
}