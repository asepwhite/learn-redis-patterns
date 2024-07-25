package learn.kvstore.cacheaside.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import learn.kvstore.cacheaside.model.Product;
import learn.kvstore.cacheaside.repository.ProductRepository;
import learn.kvstore.cacheaside.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(ProductService.class.getName());
    private ObjectMapper mapper = new ObjectMapper();


    public List<Product> searchProductsByDisplayName(String displayName) {
        //Get entry from redis
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        String key = RedisUtil.generateHashSHA256(displayName);
        String redisEntry = (String) ops.get(key);

        //cache hit
        if (redisEntry != null) {
            try {
                return mapper.readValue(redisEntry, new TypeReference<List<Product>>() {});
            } catch (JsonProcessingException e) {
                log.atError()
                    .addKeyValue("redis_entry", redisEntry)
                    .setMessage("Failed to convert redisEntry into List<Product>")
                    .log();
                throw new InternalError();
            }
        } 
        //cache miss
        else {
            List<Product> products = productRepository.findProductByProductDisplayNameContainingIgnoreCase(displayName); 
            try {
                ops.set(key, mapper.writeValueAsString(products));
            } catch (JsonProcessingException e) {
                log.atError()
                    .setMessage("Failed to convert List<Product> into String")
                    .log();
                throw new InternalError();
            }
            return productRepository.findProductByProductDisplayNameContainingIgnoreCase(displayName); 
        }
    }
}
