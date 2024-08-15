package dev.joemoser.jmdevbackend;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoeInfoService
{
    @Autowired
    private JoeInfoRepo JIRepo;

    public List<JoeInfo> allInfo()
    {
        return JIRepo.findAll();
    }

    public Optional<JoeInfo> singleInfo(ObjectId id)
    {
        return JIRepo.findById(id);
    }
}