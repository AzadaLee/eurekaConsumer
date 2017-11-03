package person.txm.eurekaConsumer.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/testConsume")
	public Object testConsume(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("req1", "val1");
		params.put("req2", "val2");
		Map<String, Object> result = restTemplate.postForObject("http://producter/test/hello", params, Map.class);
		return result;
	}
}
