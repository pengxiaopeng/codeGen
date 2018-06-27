package com.codegen.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-06-19 14:14
 **/
public class EmailUtils {
    protected final Log logger = LogFactory.getLog(this.getClass());
    private String title;
    private String text;
    private boolean isHtml;
    private String[] emailPassword;
    private String[] emailServer;
    private String[] emailUserName;
    private String[] fromEmailName;

    public EmailUtils(String title, boolean isHtml, String[] emailPassword, String[] emailServer, String[] emailUserName, String[] fromEmailName) {
        this.title = title;
        this.isHtml = isHtml;
        this.emailPassword = emailPassword;
        this.emailServer = emailServer;
        this.emailUserName = emailUserName;
        this.fromEmailName = fromEmailName;
    }

    public void sendEmail(String to, String text) throws Exception {
        sendEmail(to, text, 0);
    }

    public void sendEmail(String to, String text, int index) throws Exception {
        sendEmail(to, this.title, text, this.isHtml, index);
    }

    public void sendEmail(String to, String title, String text, boolean isHtml, int index) throws Exception {
        JavaMailSender mailSender = getMailSender(index);
        // 建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage message = mailSender.createMimeMessage();
        // 为防止乱码，添加编码集设置
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        //helper.setFrom("gxkscg1@163.com");//发件人
        helper.setFrom(fromEmailName[index]);//发件人
        helper.setTo(to);//收件人
        helper.setSubject(title);//主题
        helper.setText(text, isHtml);//正文
        logger.info("开始发送邮件：to=" + to + "\nfrom=" + fromEmailName[index] + "\ntitle=" + title);
        mailSender.send(message);
    }

    private JavaMailSender getMailSender(int index) throws Exception {
       /* String emailP = "gxkscgemail1";
        String emailServer = "smtp.163.com";
        String emailUserName = "gxkscg1";*/

        String emailPassword = this.emailPassword[index];
        String emailServer = this.emailServer[index];
        String emailUserName = this.emailUserName[index];

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailServer);//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(465);//默认端口，标准的SMTP端口
        mailSender.setUsername(emailUserName);//用户名
        mailSender.setPassword(emailPassword);//密码

        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtp.socketFactory.port", "465");
        p.setProperty("mail.smtp.socketFactory.fallback", "false");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        p.put("mail.smtp.socketFactory", sf);

        mailSender.setJavaMailProperties(p);
        return mailSender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }


    public String[] getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String[] emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String[] getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String[] emailServer) {
        this.emailServer = emailServer;
    }

    public String[] getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String[] emailUserName) {
        this.emailUserName = emailUserName;
    }

    public String[] getFromEmailName() {
        return fromEmailName;
    }

    public void setFromEmailName(String[] fromEmailName) {
        this.fromEmailName = fromEmailName;
    }
}
