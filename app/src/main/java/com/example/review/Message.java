package com.example.review;

public class Message {
    private String message;
    private MessageType type;

   public Message(String message, MessageType type){
       this.message=message;
       this.type=type;
   }

    public String getMessage() {
        return message;
    }

    public MessageType getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
