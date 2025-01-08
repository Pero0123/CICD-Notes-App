package ie.atu.searchservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@FeignClient(name="Login-Client", url="https://localhost:8080")
public interface LoginClient {


}