package dev.joemoser.jmdevbackend;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class JoeInfoController
{
    @Autowired
    private JoeInfoService JIService;
    @Autowired
    private ChatGPTService CGPTService;

    @GetMapping
    public ResponseEntity<List<JoeInfo>> getAllInfo()
    {
        return new ResponseEntity<List<JoeInfo>>(JIService.allInfo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JoeInfo>> getSingleInfo(@PathVariable ObjectId id)
    {
        return new ResponseEntity<Optional<JoeInfo>>(JIService.singleInfo(id), HttpStatus.OK);
    }
    
    @PostMapping("/post")
    public ResponseEntity<String> contactChatGpt(@RequestBody String payload)
    {
        return new ResponseEntity<String>(CGPTService.sendFullChatGPTCycle(payload), HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<String> getFirstMessage()
    {
        return new ResponseEntity<String>("Welcome to JoeGPT! Ask me anything about Joe's interests, education, work history, or skills! Please try to keep your questions simple. Remember, I am an AI, and I may get information wrong. Take anything I say with a grain of salt. Ok, ask away!",HttpStatus.OK);
    }
}
