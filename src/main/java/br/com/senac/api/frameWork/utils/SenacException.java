package br.com.senac.api.frameWork.utils;

import java.util.ArrayList;
import java.util.List;

public class SenacException extends Exception {
    private List<String> messages = new ArrayList<>();

    public SenacException(String message) {
        super(message);
    }

    public SenacException(List<String> msg){
        this.messages = msg;
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        if(!this.messages.isEmpty()){
            return this.messages.toString();
        }
        return super.toString();
    }
}
