package mail;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by 冰封承諾Andy on 2017/5/31.
 * 使用 Java 发送邮件
 */
public class SendMail {
    private static String host = "smtp.163.com";
    private static String email = "abc@163.com";
    private static String username = "abc";
    private static String password = "123456";

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        sendMail();
        System.out.println("发送成功！");
    }


    private static void sendMail() throws MessagingException, UnsupportedEncodingException {
        Properties prop = new Properties();
        // 具体填充参考 Java mail 的 api
        prop.setProperty("mail.host",host);
        prop.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(prop);
        // Message msg = createMsg(session);
        Message msg = createComplexMsg(session);
        Transport ts = session.getTransport();
        ts.connect(username,password); // 建立连接
        // 在 web 应用中的话，发送邮件一般是在多线程中的
        ts.sendMessage(msg,msg.getAllRecipients());
        ts.close();
    }

    // 创建具体的邮件内容
    private static Message createMsg(Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(email));
        // 设置发信方式，以及收信人
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("bbb@gmail.com")});
        // 设置主题
        message.setSubject("XXX测试邮件");

        message.setContent("这是正文部分，发送自 Java","text/html;charset=UTF-8");
        message.saveChanges();

        return message;
    }

    // 创建复杂的邮件，带图片、附件的
    private static Message createComplexMsg(Session session) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(email));
        // 设置发信方式，以及收信人
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("bfcnag@gmail.com")});
        // 设置主题
        message.setSubject("XXX测试邮件");

        // 设置正文部分,用 MimeBodyPart 封装
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是正文部分，发送自 Java, <img src='cid:1.jpg'/>","text/html;charset=UTF-8");

        // 封装图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(new DataHandler(new FileDataSource("src/1.jpg")));
        image.setContentID("1.jpg");

        // 封装附件
        MimeBodyPart file = new MimeBodyPart();
        file.setDataHandler(new DataHandler(new FileDataSource("src/1.jpg")));
        file.setFileName(MimeUtility.encodeText("雷姆.jpg"));  // 使用 getName 也可以，但是用的匿名，所以....

        // 描述数据的关系
        MimeMultipart content = new MimeMultipart();
        content.addBodyPart(text);
        content.addBodyPart(image);
        content.setSubType("related");

        MimeBodyPart mbp = new MimeBodyPart();
        mbp.setContent(content);

        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(mbp);
        mm.addBodyPart(file);
        mm.setSubType("mixed");

        // 保存
        message.setContent(mm);
        message.saveChanges();

        return message;
    }
}
