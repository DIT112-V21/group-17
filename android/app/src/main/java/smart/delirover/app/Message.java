package smart.delirover.app;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private String ID;
    private String title;
    private String content;
    private String senderID;
    private String senderName;
    private String messageStatus;
    private LocalDateTime time;


    public Message(String title, String content, String senderID, String senderName,LocalDateTime time) {
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.title=title;
        this.content = content;
        this.senderID=senderID;
        this.senderName = senderName;
        this.messageStatus="";
        this.time=time;
    }

    public String getID() {
        return ID;
    }

    public String getContent() {
        return content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    @Override
    public String toString() {
        return "Received: " +time+
                "\nMessage from: " + senderName +
                "\n\n" + content;
    }



}
