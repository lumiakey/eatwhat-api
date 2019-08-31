
package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.entity.FoodJson;
import com.what2e.eatwhat.entity.RedisFoodListKey;
import com.what2e.eatwhat.service.FoodListService;
import com.what2e.eatwhat.service.RedisService;
import com.what2e.eatwhat.util.DateUtils;
import com.what2e.eatwhat.util.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.net.SocketException;
import java.util.ArrayList;

/**
 * @author lumike
 * @version v1.0
 * @title RedisServiceImpl
 * @date 19-5-5 下午10:45
 * @Description RedisService实现 实现从里面读取菜单 写入订单等
 **/


@Service
public class RedisServiceImpl implements RedisService {

    private final static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    FoodListService foodListService;

    ArrayList<FoodJson> foods;

    final static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(500);
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPool = new JedisPool(jedisPoolConfig,"localhost");
    }

    @Override
    public ArrayList<FoodJson> readFoodListOfOneDay(String putTime, String locationCode) {
        foods = new ArrayList<FoodJson>();
        RedisFoodListKey breakfastKey = new RedisFoodListKey("早餐",putTime,locationCode);
        RedisFoodListKey lunchKey = new RedisFoodListKey("午餐",putTime,locationCode);
        RedisFoodListKey dinnerKey = new RedisFoodListKey("晚餐",putTime,locationCode);
        Food breakfast = readFoodByRedisFoodListKey(breakfastKey);
        Food lunch = readFoodByRedisFoodListKey(lunchKey);
        Food dinner = readFoodByRedisFoodListKey(dinnerKey);
        foods.add(foodToFoodJson(breakfast));
        foods.add(foodToFoodJson(lunch));
        foods.add(foodToFoodJson(dinner));
        return foods;
    }

    @Override
    public ArrayList<FoodJson> readFoodListOfLunchAndDinner(String putTime, String locationCode) {
        foods = new ArrayList<FoodJson>();
        RedisFoodListKey lunchKey = new RedisFoodListKey("午餐",putTime,locationCode);
        RedisFoodListKey dinnerKey = new RedisFoodListKey("晚餐",putTime,locationCode);
        Food lunch = readFoodByRedisFoodListKey(lunchKey);
        Food dinner = readFoodByRedisFoodListKey(dinnerKey);
        foods.add(foodToFoodJson(lunch));
        foods.add(foodToFoodJson(dinner));
        return foods;
    }

    @Override
    public ArrayList<FoodJson> readFoodDinner(String putTime, String locationCode) {
        foods = new ArrayList<FoodJson>();
        RedisFoodListKey dinnerKey = new RedisFoodListKey("晚餐",putTime,locationCode);
        Food dinner = readFoodByRedisFoodListKey(dinnerKey);
        foods.add(foodToFoodJson(dinner));
        return foods;
    }


    @Override
    public Food readFoodByRedisFoodListKey(RedisFoodListKey key) {
        Jedis jedis = jedisPool.getResource();
        byte[] foodByte;
        try {
            foodByte = jedis.get(key.getKey().getBytes());
        } catch (JedisConnectionException e) {
            foodByte = null;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        Food food = byteToFood(foodByte);
        return food;
    }


    @Override
    public byte[] read(byte[] key) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (key != null) {
                return jedis.get(key);
            }
        } catch (JedisConnectionException e) {
            return null;
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public void write(byte[] key, byte[] value) {
        Jedis jedis = jedisPool.getResource();
        if (key != null) {
            jedis.set(key, value);
            jedis.close();
        }
    }

    public Food byteToFood(byte[] foodByte) {
        Food food = new Food();
        if (foodByte != null) {
            food = (Food) SerializeUtil.unserialize(foodByte);
        }
        return food;
    }

    /**
     * 用于将原始food 转换为传输到客户端的foodjson
     * @param food
     * @return
     */
    public FoodJson foodToFoodJson(Food food) {
        if (food == null || food.equals("")) {
            return null;
        }
        FoodJson foodJson = new FoodJson();
        foodJson.setFoodId(food.getFoodId());
        foodJson.setFoodDesc(food.getFoodDesc());
        foodJson.setFoodName(food.getFoodName());
        foodJson.setFoodPicture(food.getFoodPicture());
        foodJson.setTimeTips(food.getTimeTips());
        foodJson.setFoodPrice(food.getFoodPrice());
        return foodJson;
    }

    @Override
    public String creatRedisFoodListKey(Food food) {
        RedisFoodListKey redisFoodListKey;
        String timeTips = food.getTimeTips();
        String locationCode = food.getFoodLocation();
        try {
            String[] putTime = DateUtils.dateFormat(food.getPutTime(), DateUtils.DATE_PATTERN).split(" ");
            redisFoodListKey = new RedisFoodListKey(timeTips, putTime[0], locationCode);
            return redisFoodListKey.getKey();

        } catch (Exception e) {
            logger.info("LoadToRedisService getKet 发生了不可能发生的错误");
            return null;
        }
    }
}

