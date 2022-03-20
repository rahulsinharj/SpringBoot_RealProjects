package productcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import productcrud.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {


	
}
