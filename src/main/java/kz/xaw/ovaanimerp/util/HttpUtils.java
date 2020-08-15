package kz.xaw.ovaanimerp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriUtils;

public final class HttpUtils {

    private HttpUtils() {
    }

    public static final String DEFAULT_ENCODING = "UTF-8";

    public static ResponseEntity<byte[]> fileDownload(String fileName, byte[] data) {
        return new ResponseEntity<>(data, headers(fileName, "attachment"), HttpStatus.OK);
    }

    public static ResponseEntity<byte[]> fileView(String fileName, byte[] data) {
        return new ResponseEntity<>(data, headers(fileName, "inline"), HttpStatus.OK);
    }

    private static HttpHeaders headers(String fileName, String actionType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, actionType + ";fileName=\"" + UriUtils.encodePath(fileName, DEFAULT_ENCODING) + "\"");
        return headers;
    }

//                return ResponseEntity.ok()
//                        .contentType(MediaType.parseMediaType(documentForm.getFileType()))
//            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentForm.getFileName() + "\"")
//            .body(new ByteArrayResource(documentForm.getData()));
}
