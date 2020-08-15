package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.DocumentTemplate;
import kz.xaw.ovaanimerp.data.forms.PdfDocumentForm;
import kz.xaw.ovaanimerp.repository.DocumentTemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class PdfGeneratorService {

    private static final String UTF_8 = "UTF-8";
    private static final Logger log = LoggerFactory.getLogger(PdfGeneratorService.class);

    private final PebbleConstructorService pebbleConstructorService;
    private final DocumentTemplateRepository documentTemplateRepository;

    @Autowired
    public PdfGeneratorService(PebbleConstructorService pebbleConstructorService, DocumentTemplateRepository documentTemplateRepository) {
        this.pebbleConstructorService = pebbleConstructorService;
        this.documentTemplateRepository = documentTemplateRepository;
    }

    @Transactional
    public PdfDocumentForm generatePdfFile(String templateKey, Map<String, Object> params) {
        DocumentTemplate template = documentTemplateRepository.findByDocKey(templateKey).orElseThrow();
        String renderedHtmlContent = buildRenderedHtmlContent(template, params);
        String xHtml = convertToXhtml(renderedHtmlContent);
        byte[] dataArray = constructPdfFile(xHtml);

        PdfDocumentForm form = new PdfDocumentForm();
        form.setFileName(template.getFilename() + template.getType().getExtension());
        form.setData(dataArray);
        form.setFileType(template.getType().getType());

        return form;
    }

    private String buildRenderedHtmlContent(DocumentTemplate template, Map<String, Object> params) {
        return pebbleConstructorService.createCompleteMessage(params, template.getOriginalText());
    }

    private byte[] constructPdfFile(String renderedDocument) {
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            ITextRenderer renderer = new ITextRenderer();
//        renderer.getFontResolver().addFont("Code39.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            // FlyingSaucer has a working directory. If you run this test, the working directory
            // will be the root folder of your project. However, all files (HTML, CSS, etc.) are
            // located under "/src/test/resources". So we want to use this folder as the working
            // directory.
//            String baseUrl = FileSystems
//                    .getDefault()
//                    .getPath("src", "test", "resources")
//                    .toUri()
//                    .toURL()
//                    .toString();
//        renderer.setDocumentFromString(xHtml, baseUrl);
            renderer.setDocumentFromString(renderedDocument);
            renderer.layout();
            renderer.createPDF(outputStream);
            renderer.finishPDF();
            return outputStream.toByteArray();
        } catch (Exception e) {
            log.error("Return empty array! Something went wrong! ", e);
            return new byte[0];
        }
    }

    private String convertToXhtml(String html) {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(StandardCharsets.UTF_8);
    }
}
