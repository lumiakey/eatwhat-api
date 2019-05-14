package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.entity.RedisFoodListKey;
import com.what2e.eatwhat.entity.RedisFoodValue;
import com.what2e.eatwhat.service.FoodListService;
import com.what2e.eatwhat.service.LoadToRedisService;
import com.what2e.eatwhat.service.RedisService;
import com.what2e.eatwhat.util.DateUtils;
import com.what2e.eatwhat.util.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author lumike
 * @version v1.0
 * @title LoadToRedisServiceImpl
 * @date 19-5-6 上午2:48
 * @Description 处理系统启动立即加载的Quartz job
 **/

@Service
public class LoadToRedisServiceImpl implements LoadToRedisService {

    private final static Logger logger = LoggerFactory.getLogger(LoadToRedisServiceImpl.class);

    @Autowired
    FoodListService foodListService;

    @Autowired
    RedisService redisService;


    @Override
    public void loadFoodListToRedisFromDB(String putTime) {
        List<Food> foodListFromPut = foodListService.getFoodListFromPut(putTime);
        logger.info("loadFoodListToRedisFromDB :");
        for (Food food : foodListFromPut) {
            logger.info("loadFoodListToRedisFromDB : "+redisService.creatRedisFoodListKey(food) + food.getFoodId());
            RedisFoodValue redisFoodValue = new RedisFoodValue(food.getInventory());
            redisService.write(redisService.creatRedisFoodListKey(food).getBytes(), SerializeUtil.serialize(food));
            redisService.write(food.getFoodId().toString().getBytes(),SerializeUtil.serialize(redisFoodValue));
            logger.info("loadFoodListToRedisFromDB:"+redisService.creatRedisFoodListKey(food)+" "+redisService.creatRedisFoodListKey(food).getBytes());
        }
    }

    public void updateBuyCountJob() {
        logger.info("Quartz : 1min updateBuyCount");
        StringBuilder putTime = new StringBuilder();
        try {
            putTime.append(DateUtils.dateFormat(new Date(), DateUtils.DATE_PATTERN));
            putTime.append(" ");
            putTime.append(DateUtils.PUT_TIME);
            logger.info("Quartz : Select FoodList of " + putTime.toString());
           /* List<Food> foodListFromPut = foodListService.getFoodListFromPut(putTime.toString());*/
            List<Food> foodListFromPut = foodListService.getFoodListFromPut("2019-05-10 09:00:01");
            for (Food food : foodListFromPut) {
                byte[] bytes = redisService.read(food.getFoodId().toString().getBytes());
                if (bytes != null) {
                    RedisFoodValue redisFoodValue = (RedisFoodValue) SerializeUtil.unserialize(bytes);
                    redisFoodValue.setBuyCount(0);
                    redisService.write(food.getFoodId().toString().getBytes(), SerializeUtil.serialize(redisFoodValue));
                }
            }
        } catch (ParseException exception) {
            logger.info("quartz updateBuyCountJob fail : dateFormat ParseException");
        }
    }

    public void loadJob() {
        logger.info("Quartz : EveryDay And StartUp 00:00:01 LoadTask");
        StringBuilder putTime = new StringBuilder();
        try {
            putTime.append(DateUtils.dateFormat(new Date(), DateUtils.DATE_PATTERN));
            putTime.append(" ");
            putTime.append(DateUtils.PUT_TIME);
            logger.info("Quartz : Select FoodList of "+putTime.toString());
            /*loadFoodListToRedisFromDB(putTime.toString());*/
            loadFoodListToRedisFromDB("2019-05-10 00:00:01");
        } catch (ParseException exception) {
            logger.info("quartz reLoadFoodListToRedisFromDB fail : dateFormat ParseException");
        }
    }



}
