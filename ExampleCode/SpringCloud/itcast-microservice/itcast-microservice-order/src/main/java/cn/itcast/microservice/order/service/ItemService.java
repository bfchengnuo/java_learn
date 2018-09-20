package cn.itcast.microservice.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.itcast.microservice.order.feign.ItemFeignClient;
import cn.itcast.microservice.order.pojo.Item;
import cn.itcast.microservice.order.properties.OrderProerties;

@Service
public class ItemService {
	
	// Spring框架对RESTful方式的http请求做了封装，来简化操作
	@Autowired
	private RestTemplate restTemplate;
	
//	@Value("${itcast.item.url}")
//	private String itcastItemUrl;
	
	@Autowired
	private OrderProerties orderProerties;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private ItemFeignClient itemFeignClient;


	/**
	 * 调用商品的微服务提供的接口进行查询数据
	 * 
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Item queryItemById(Long id) {
		return this.itemFeignClient.queryItemById(id);
	}
	
	
//	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
//	public Item queryItemById(Long id) {
//		String serviceId = "itcast-microservice-item";
//		return this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);
//	}
//	
	public Item queryItemByIdFallbackMethod(Long id){ // 请求失败执行的方法
		return new Item(id, "查询商品信息出错!", null, null, null);
	}


//	public Item queryItemById(Long id) {
//		String serviceId = "itcast-microservice-item";
//		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//		if(instances.isEmpty()){
//			return null;
//		}
//		// 为了演示，在这里只获取一个实例
//		ServiceInstance serviceInstance = instances.get(0);
//		String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//		return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
//	}
	
//	public Item queryItemById(Long id) {
//		String url = this.orderProerties.getItem().getUrl() + id;
//		return this.restTemplate.getForObject(url, Item.class);
//	}

}
