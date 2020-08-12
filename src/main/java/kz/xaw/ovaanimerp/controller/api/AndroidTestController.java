package kz.xaw.ovaanimerp.controller.api;

import kz.xaw.ovaanimerp.data.constant.ApiConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_PREFIX + "/test")
public class AndroidTestController {

    @GetMapping
    public ResponseEntity<?> getSimpleResponse() {
        return ResponseEntity.ok("all good");
    }
}
