package com.pratic.exercising.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pratic.exercising.entities.Category;
import com.pratic.exercising.entities.Order;
import com.pratic.exercising.entities.OrderItem;
import com.pratic.exercising.entities.Payment;
import com.pratic.exercising.entities.Product;
import com.pratic.exercising.entities.User;
import com.pratic.exercising.entities.enums.OrderStatus;
import com.pratic.exercising.repositories.CategoryRepository;
import com.pratic.exercising.repositories.OrderItemRepository;
import com.pratic.exercising.repositories.OrderRepository;
import com.pratic.exercising.repositories.ProductRepository;
import com.pratic.exercising.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);
		
		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");		
		
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		OrderItem oi1 = new OrderItem(order1, product1, 2, product1.getPrice());
		OrderItem oi2 = new OrderItem(order1, product3, 1, product3.getPrice());
		OrderItem oi3 = new OrderItem(order1, product3, 2, product3.getPrice());
		OrderItem oi4 = new OrderItem(order1, product3, 2, product5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(pay1);
		orderRepository.saveAll(Arrays.asList(order1));
	}
	
	
}
