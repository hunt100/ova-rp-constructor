package kz.xaw.ovaanimerp.controller.api;

import kz.xaw.ovaanimerp.data.constant.ApiConstants;
import kz.xaw.ovaanimerp.data.constant.Constants;
import kz.xaw.ovaanimerp.data.forms.PdfDocumentForm;
import kz.xaw.ovaanimerp.service.PdfGeneratorService;
import kz.xaw.ovaanimerp.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(ApiConstants.API_PREFIX + "/test")
public class AndroidTestController {

    private final PdfGeneratorService pdfGeneratorService;

    @Autowired
    public AndroidTestController(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping
    public ResponseEntity<?> getSimpleResponse() {
        return ResponseEntity.ok("all good");
    }

    @GetMapping(value = "/downloadFile", produces = Constants.PDF_CONTENT_TYPE)
    public ResponseEntity<byte[]> downloadFile() {
        try {
            PdfDocumentForm file = pdfGeneratorService.generatePdfFile(Constants.CHAR_SHEET_TEMPLATE, new HashMap<>());
            return HttpUtils.fileView(file.getFileName(), file.getData());
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}
