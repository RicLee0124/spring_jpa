package cn.sm1234.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

	@Resource
	private IProductDao productDao;
	
	/**
	 * save操作
	 */
	@Test
	@Transactional  //现在是更新操作，必须在测试方法中加入事务注解
	@Rollback(false) //取消测试方法中事务的自动回滚
	public void test1(){
		Product product = new Product();
		product.setName("Mi phone");
		product.setPrice(2000D);
		product.setBrand("xiaomi");
		product.setStore(500);
		
		productDao.save(product);
	}
	
	
	/**
	 * findAll操作
	 */
	@Test
	public void test2(){
		List<Product> list = productDao.findAll();
		for (Product product : list) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getBrand());
		}
	}
	
}
