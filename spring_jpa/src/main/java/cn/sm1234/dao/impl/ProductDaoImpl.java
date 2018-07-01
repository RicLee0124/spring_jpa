package cn.sm1234.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	//获取EntityManager
	//name：从哪个EntityMangerFactory获取EntityManager
	@PersistenceContext(name="entityManagerFactory")
	private EntityManager em;
	
	@Override
	public void save(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("from Product").getResultList();
	}

}
