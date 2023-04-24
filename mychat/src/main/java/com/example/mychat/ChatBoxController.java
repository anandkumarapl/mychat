package com.example.mychat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/")

public class ChatBoxController {
    @Autowired
    ChatBoxRepository chatBoxRepository;
    @CrossOrigin("*")
    @PostMapping("/addchat")
    public @ResponseBody ChatBox add(@RequestParam(name = "receiver")String receiver,@RequestParam(name = "sender")String sender,@RequestParam(name="message")String message){
    try {
        ChatBox chat = new ChatBox();
        chat.setSender(sender);
        chat.setReceiver(receiver);
        chat.setMessage(message);
        chatBoxRepository.save(chat);
        return chat;
    }
    catch (Exception ex){
        return new ChatBox();
    }
    }
   @CrossOrigin( "*")
    @GetMapping("/getchat")
    public @ResponseBody List<ChatBox> get(@RequestParam(name = "user1")String user1,@RequestParam(name = "user2")String user2) {
        try {
            List<ChatBox> box = chatBoxRepository.findAll();
            List<ChatBox> mychat = new ArrayList<>();
            for (ChatBox chat : box) {
                if ((chat.getReceiver().equals(user1) && chat.getSender().equals(user2)) || (chat.getReceiver().equals(user2) && chat.getSender().equals(user1)))
                    mychat.add(chat);
            }
            return mychat;
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }
}
