package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;


    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public void sendEmail(PessoaDTO pessoa, EnumEmail enumEmail) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());

            switch (enumEmail) {
                case CREATE -> {
                    mimeMessageHelper.setSubject("Bem Vindo - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplate(pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case PUT -> {
                    mimeMessageHelper.setSubject("Atualização - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplatePut(pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
                case DELETE -> {
                    mimeMessageHelper.setSubject("Exclusão - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateDelete(pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
            }
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailEndereco(PessoaDTO pessoa, EnderecoDTO endereco, EnumEmail enumEmail) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());

            switch (enumEmail) {
                case CREATE -> {
                    mimeMessageHelper.setSubject("Registro de Endereço - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateEndereco(endereco, pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }

                case PUT -> {
                    mimeMessageHelper.setSubject("Atualização - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplatePut(pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }

                case DELETE -> {
                    mimeMessageHelper.setSubject("Exclusão de Endereço - VemSer");
                    mimeMessageHelper.setText(geContentFromTemplateEnderecoDelete(endereco, pessoa), true);
                    emailSender.send(mimeMessageHelper.getMimeMessage());
                }
            }
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(PessoaDTO id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", id.getNome());
        dados.put("id", id.getIdPessoa());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("pessoa-post-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplatePut(PessoaDTO nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("put-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateDelete(PessoaDTO nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("pessoa-delete-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateEndereco(EnderecoDTO id, PessoaDTO nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("id", id.getIdEndereco());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("endereco-post-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplateEnderecoDelete(EnderecoDTO id, PessoaDTO nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome.getNome());
        dados.put("id", id.getIdEndereco());
        dados.put("rua", id.getLogradouro());
        dados.put("numero", id.getNumero());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("endereco-delete-email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
