package tmfm.tomefromme.util.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MailManager {

    private JavaMailSender sender;
    private MimeMessage mail;
    private MimeMessageHelper helper;

    public MailManager(JavaMailSender javaMailSender) throws MessagingException {
        this.sender = javaMailSender;
        this.mail = javaMailSender.createMimeMessage();
        this.helper = new MimeMessageHelper(mail, true, "UTF-8");
    }

    public void setMail(String from, String to, String subject, String body) throws MessagingException {
        helper.setFrom(from); //보내는 사람
        helper.setTo(to); //받는 사람
        helper.setSubject(subject); //제목
        helper.setText(body, true);//내용
    }

    public void setMail(String from, String to, String subject, String body, Boolean useHtml) throws MessagingException {
        helper.setFrom(from); //보내는 사람
        helper.setTo(to); //받는 사람
        helper.setSubject(subject); //제목
        helper.setText(body, useHtml);//내용
    }

    public void setCc(String cc) throws MessagingException {
        helper.setCc(cc);
    }

    public void setSentDate(Date date) throws MessagingException {
        helper.setSentDate(date);
    }

    public void setAttach(String fileShowName, String pathToAttachment) throws MessagingException, IOException{
        File file = new ClassPathResource(pathToAttachment).getFile();
        FileSystemResource fsr = new FileSystemResource(file);

        helper.addAttachment(fileShowName, fsr);
    }

    public void setInlineImg(String contentId, String pathToInlineImg) throws MessagingException, IOException{
        File file = new ClassPathResource(pathToInlineImg).getFile();
        FileSystemResource fsr = new FileSystemResource(file);

        helper.addInline(contentId, fsr);
    }

    public void send(){
        sender.send(mail);
    }
}
