package cn.itcast.microservice.order.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="itcast") //以itcast开头的配置被匹配到
public class OrderProerties {
	
	private ItemProperties item = new ItemProperties();

	public ItemProperties getItem() {
		return item;
	}

	public void setItem(ItemProperties item) {
		this.item = item;
	}
	
}
