package ir.maktab.web.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("external")
public class ExternalApiController {
    private final RestTemplate restTemplate;

    public ExternalApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOnlinePayment() {
        ResponseEntity<String> result
                = restTemplate.exchange("https://api.paypal.com/",
                HttpMethod.POST, null,
                new ParameterizedTypeReference() {

                });
        return new ResponseEntity<String>(result.getBody(), HttpStatus.ACCEPTED);
    }
}
