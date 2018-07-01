package cn.sm1234.dao;

import java.util.List;

import cn.sm1234.domain.Product;

public interface IProductDao {

	public void save(Product product);
	
	public List<Product> findAll();
}
