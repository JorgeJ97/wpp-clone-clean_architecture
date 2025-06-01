package com.api.chat_app.infrastructure.controller;


import com.api.chat_app.application.dto.request.messaging.SendMessageRequest;
import com.api.chat_app.application.use_cases.messaging.SendMessageUseCase;
import com.api.chat_app.domain.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final SendMessageUseCase sendMessageUseCase;


    @PostMapping("/send")
    public ResponseEntity<Message> SendMessage(@RequestBody SendMessageRequest request){
        try{
            Message message = sendMessageUseCase.run(request);
            return ResponseEntity.ok(message);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
