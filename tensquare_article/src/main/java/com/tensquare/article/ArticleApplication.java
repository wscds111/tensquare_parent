package com.tensquare.article;
import com.tensquare.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class ArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

	@Autowired
	private RedisTemplate redisTemplate;


	@Autowired(required = false)
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(jsonRedisSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(jsonRedisSerializer);
		this.redisTemplate = redisTemplate;
	}
}
