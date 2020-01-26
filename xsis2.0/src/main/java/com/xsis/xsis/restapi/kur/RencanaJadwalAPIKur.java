package com.xsis.xsis.restapi.kur;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.xsis.xsis.dto.kur.RencanaJadwalTypeDtoKur;
import com.xsis.xsis.model.kur.RencanaJadwalKur;
import com.xsis.xsis.model.kur.EmailMessageKur;
import com.xsis.xsis.services.kur.RencanaJadwalServiceKur;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/rencana-jadwal-ku", produces = "application/json")
// @PropertySource("classpath:web-server.yml")
public class RencanaJadwalAPIKur {

    @Autowired
    private RencanaJadwalServiceKur rencanaJadwalServiceKur;

    @Autowired
    ModelMapper modelMapper;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    // @GetMapping(value = "/ro")
    // public List<RencanaJadwal> getRoTro(@PathVariable(value = "id") Long id) {
    // return rencanaJadwalService.getBioId(id);
    // }

    @GetMapping
    public List<RencanaJadwalKur> getAllData() {
        return rencanaJadwalServiceKur.getAll();
    }

    @GetMapping("/{id}")
    public RencanaJadwalKur getPengalamanId(@PathVariable(value = "id") Long id) {
        return rencanaJadwalServiceKur.getById(id);
    }

    @GetMapping("/search")
    public List<RencanaJadwalKur> getSearch(@RequestParam(name = "tgl_mulai") String tgl_mulai,
            @RequestParam(name = "tgl_sampai") String tgl_sampai) {
        return rencanaJadwalServiceKur.searchData(tgl_mulai, tgl_sampai);
    }

    @PostMapping
    public RencanaJadwalTypeDtoKur simpanRencanaJadwal(@RequestBody RencanaJadwalTypeDtoKur sumberLoker) {
        RencanaJadwalKur pengalaman = new RencanaJadwalKur();
        pengalaman.setScheduleCode(sumberLoker.getScheduleCode());
        pengalaman.setScheduleDate(sumberLoker.getScheduleDate());
        pengalaman.setTime(sumberLoker.getTime());
        pengalaman.setRo(sumberLoker.getRo());
        pengalaman.setTro(sumberLoker.getTro());
        pengalaman.setScheduleTypeId(sumberLoker.getScheduleTypeId());
        pengalaman.setLocation(sumberLoker.getLocation());
        pengalaman.setOtherRoTro(sumberLoker.getOtherRoTro());
        pengalaman.setNotes(sumberLoker.getNotes());
        pengalaman.setIsAutomaticMail(sumberLoker.isIsAutomaticMail());
        pengalaman.setSentDate(sumberLoker.getSentDate());

        rencanaJadwalServiceKur.save(pengalaman);
        return sumberLoker;
    }

    @PutMapping
    public RencanaJadwalTypeDtoKur editRencanaJadwal(@RequestBody RencanaJadwalTypeDtoKur sumberLoker) {
        RencanaJadwalKur pengalaman = new RencanaJadwalKur();
        pengalaman.setId(sumberLoker.getId());
        pengalaman.setScheduleCode(sumberLoker.getScheduleCode());
        pengalaman.setScheduleDate(sumberLoker.getScheduleDate());
        pengalaman.setTime(sumberLoker.getTime());
        pengalaman.setRo(sumberLoker.getRo());
        pengalaman.setTro(sumberLoker.getTro());
        pengalaman.setScheduleTypeId(sumberLoker.getScheduleTypeId());
        pengalaman.setLocation(sumberLoker.getLocation());
        pengalaman.setOtherRoTro(sumberLoker.getOtherRoTro());
        pengalaman.setNotes(sumberLoker.getNotes());
        pengalaman.setIsAutomaticMail(sumberLoker.isIsAutomaticMail());
        pengalaman.setSentDate(sumberLoker.getSentDate());

        rencanaJadwalServiceKur.update(pengalaman);
        return sumberLoker;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailMessageKur emailmessage)
            throws AddressException, MessagingException, IOException {

        return sendmail(emailmessage);
    }

    private String sendmail(EmailMessageKur emailmessage) throws AddressException, MessagingException, IOException {
        String email_report = "";
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username, false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo()));
            msg.setSubject(emailmessage.getSubject());
            msg.setContent(emailmessage.getText(), "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(emailmessage.getText(), "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // MimeBodyPart attachPart = new MimeBodyPart();

            // attachPart.attachFile("C:\\talk2amareswaran-downloads\\mysql2.png");

            // multipart.addBodyPart(attachPart);
            msg.setContent(multipart);
            // sends the e-mail
            Transport.send(msg);
            email_report = "Email sent Successfully";
        } catch (AddressException e) {
            email_report = "Email Yang dikirim Salah.\n" + e;
            // ...
        } catch (MessagingException e) {
            email_report = "blablablaaa.\n" + e;
            // ...
        }

        return email_report;

    }

}