package dev.joemoser.jmdevbackend.ChatGPT_Models;

public class Message
{
    String role;
    String content;

    public Message()
    {
        role = "system";
        content = "Determine the type of data the following message is trying to receive about Joe Moser. Respond only with INTERESTS, SKILLS, WORK_EXPERIENCE, or EDUCATION, unless the message is blank or completely unrelated to Joe Moser, in that case, respond with NOT_RELATED. If the request is about Joe Moser but does not fit into a category, respond with INTERESTS. If Joe's name is mentioned, do not reply with NOT_RELATED. If there are multiple answers, seperate them with a comma and no space. Your response should be all on one line.";
    }

    public Message(String role, String content)
    {
        this.role = role;
        this.content = content;
    }

    public String getRole(){return role;}
    public String getContent(){return content;}

    public void setRole(String role){this.role = role;}
    public void setContent(String content){this.content = content;}
}