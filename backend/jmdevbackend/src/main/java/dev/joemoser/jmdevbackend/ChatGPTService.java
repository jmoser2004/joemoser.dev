package dev.joemoser.jmdevbackend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.joemoser.jmdevbackend.ChatGPT_Models.*;

@Service
public class ChatGPTService
{
    @Autowired
    JoeInfoService JIService;

    @Value("${CHATGPT_API_URL}")
    private String CHATGPT_API_URL;
    
    @Value("${CHATGPT_API_KEY}")
    private String CHATGPT_API_KEY;

    public HashMap<String, String> getInfoMapper()
    {
        HashMap<String, String> infoMapper = new HashMap<String, String>();

        infoMapper.put("INTERESTS", "66a5a9c3c630be8f3fdbde32");
        infoMapper.put("SKILLS", "66a90be6c630be8f3fdbde35");
        infoMapper.put("WORK_EXPERIENCE", "66a90d79c630be8f3fdbde36");
        infoMapper.put("EDUCATION", "66a9107bc630be8f3fdbde37");
        infoMapper.put("NOT_RELATED", "66a91382c630be8f3fdbde38");

        return infoMapper;
    }

    public String sendMessage(List<Message> input)
    {
        try
        {

            RequestModel reqMod = new RequestModel(input);
            ObjectMapper objectMapper = new ObjectMapper();
            String reqBody = objectMapper.writeValueAsString(reqMod);

            HttpRequest request = HttpRequest.newBuilder()
                                .POST(HttpRequest.BodyPublishers.ofString(reqBody))
                                .uri(URI.create(CHATGPT_API_URL))
                                .header("Content-Type", "application/json")
                                .header("Authorization", "Bearer " + CHATGPT_API_KEY)
                                .build();
            
            HttpResponse<String> response = HttpClient.newHttpClient()
                                            .send(request, HttpResponse.BodyHandlers.ofString());
            
            JsonNode node = objectMapper.readTree(response.body());
            String choices = node.get("choices").toString();
            choices = choices.substring(1, choices.length() - 1);
            
            JsonNode choiceNode = objectMapper.readTree(choices);
            String choice = choiceNode.get("message").toString();

            JsonNode messageNode = objectMapper.readTree(choice);
            String message = messageNode.get("content").toString();
            
            return message.substring(1, message.length() - 1);
        }
        catch(Exception e)
        {
            return e.toString();
        }
    }

    public String sendFullChatGPTCycle(String input)
    {
        HashMap<String, String> infoMapper = getInfoMapper();
        String result;
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Message> messages = new ArrayList<>(Arrays.asList(new Message(), new Message("user", input)));
        String type = sendMessage(messages);

        ArrayList<String> types = new ArrayList<>(Arrays.asList(type.split(",")));
        messages = new ArrayList<>(Arrays.asList(new Message("system", "You are going to recieve some JSON containing data about Joe Moser, unless the input is not related. Use it to respond to the question")));

        for(String i : types)
        {
            i = i.strip();
            Optional<JoeInfo> infoOptional = JIService.singleInfo(new ObjectId(infoMapper.get(i)));
            if(i == "NOT_RELATED") messages.add(new Message("system", "Ignore previous message. Redirect the user towards asking about Joe Moser, without being rude"));
            else
            {
                if(infoOptional.isPresent())
                {
                    JoeInfo info = infoOptional.get();
                    try
                    {
                        String infoString = objectMapper.writeValueAsString(info);
                        messages.add(new Message("system", infoString));
                    }
                    catch(Exception e)
                    {
                       System.out.println(e);
                    }
                }
            }
        }

        messages.add(new Message("user", input));
        result = sendMessage(messages);
        return result;
        /*

        switch(type)
        {
            case "NOT_RELATED":
                messages = Arrays.asList(new Message("system", "Redirect the user towards asking about Joe Moser, without being rude"),
                                         new Message("user", input));
                result = sendMessage(messages);
                break;
            case "INTERESTS":
                if(infoOptional.isPresent())
                {
                    JoeInfo info = infoOptional.get();
                    try
                    {
                        String infoString = objectMapper.writeValueAsString(info);
                        messages = Arrays.asList(new Message("system", "You are going to recieve some JSON about Joe Moser's interests. Use this to answer the input, in any order"),
                                                new Message("system", infoString),
                                                new Message("user", input));
                        result = sendMessage(messages);
                    }
                    catch(Exception e)
                    {
                        return "oops";
                    }
                }
                else
                {
                    return "Error!";
                }
                break;
            case "SKILLS":
                if(infoOptional.isPresent())
                {
                    JoeInfo info = infoOptional.get();
                    try
                    {
                        String infoString = objectMapper.writeValueAsString(info);
                        messages = Arrays.asList(new Message("system", "You are going to recieve some JSON about Joe Moser's skills. Use this to answer the input, in any order"),
                                                new Message("system", infoString),
                                                new Message("user", input));
                        result = sendMessage(messages);
                    }
                    catch(Exception e)
                    {
                        return "oops";
                    }
                }
                else
                {
                    return "Error!";
                }
                break;
            case "WORK_EXPERIENCE":
                if(infoOptional.isPresent())
                {
                    JoeInfo info = infoOptional.get();
                    try
                    {
                        String infoString = objectMapper.writeValueAsString(info);
                        messages = Arrays.asList(new Message("system", "You are going to recieve some JSON about Joe Moser's work experience. Use this to answer the input, in any order"),
                                                new Message("system", infoString),
                                                new Message("user", input));
                        result = sendMessage(messages);
                    }
                    catch(Exception e)
                    {
                        return "oops";
                    }
                }
                else
                {
                    return "Error!";
                }
                break;
            case "EDUCATION":
                if(infoOptional.isPresent())
                    {
                        JoeInfo info = infoOptional.get();
                        try
                        {
                            String infoString = objectMapper.writeValueAsString(info);
                            messages = Arrays.asList(new Message("system", "You are going to recieve some JSON about Joe Moser's education. Use this to answer the input, in any order"),
                                                    new Message("system", infoString),
                                                    new Message("user", input));
                            result = sendMessage(messages);
                        }
                        catch(Exception e)
                        {
                            return "oops";
                        }
                    }
                    else
                    {
                        return "Error!";
                    }
                    break;
            default:
                return "Error!";
        }

        return result;
        */
    }
}