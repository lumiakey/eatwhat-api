package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFoodIdIsNull() {
            addCriterion("food_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodIdIsNotNull() {
            addCriterion("food_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodIdEqualTo(Integer value) {
            addCriterion("food_id =", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotEqualTo(Integer value) {
            addCriterion("food_id <>", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThan(Integer value) {
            addCriterion("food_id >", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_id >=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThan(Integer value) {
            addCriterion("food_id <", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("food_id <=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdIn(List<Integer> values) {
            addCriterion("food_id in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotIn(List<Integer> values) {
            addCriterion("food_id not in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdBetween(Integer value1, Integer value2) {
            addCriterion("food_id between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("food_id not between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNull() {
            addCriterion("food_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNotNull() {
            addCriterion("food_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNameEqualTo(String value) {
            addCriterion("food_name =", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotEqualTo(String value) {
            addCriterion("food_name <>", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThan(String value) {
            addCriterion("food_name >", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("food_name >=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThan(String value) {
            addCriterion("food_name <", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThanOrEqualTo(String value) {
            addCriterion("food_name <=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLike(String value) {
            addCriterion("food_name like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotLike(String value) {
            addCriterion("food_name not like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameIn(List<String> values) {
            addCriterion("food_name in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotIn(List<String> values) {
            addCriterion("food_name not in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameBetween(String value1, String value2) {
            addCriterion("food_name between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotBetween(String value1, String value2) {
            addCriterion("food_name not between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNull() {
            addCriterion("food_price is null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNotNull() {
            addCriterion("food_price is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceEqualTo(String value) {
            addCriterion("food_price =", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotEqualTo(String value) {
            addCriterion("food_price <>", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThan(String value) {
            addCriterion("food_price >", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThanOrEqualTo(String value) {
            addCriterion("food_price >=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThan(String value) {
            addCriterion("food_price <", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThanOrEqualTo(String value) {
            addCriterion("food_price <=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLike(String value) {
            addCriterion("food_price like", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotLike(String value) {
            addCriterion("food_price not like", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIn(List<String> values) {
            addCriterion("food_price in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotIn(List<String> values) {
            addCriterion("food_price not in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceBetween(String value1, String value2) {
            addCriterion("food_price between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotBetween(String value1, String value2) {
            addCriterion("food_price not between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPictureIsNull() {
            addCriterion("food_picture is null");
            return (Criteria) this;
        }

        public Criteria andFoodPictureIsNotNull() {
            addCriterion("food_picture is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPictureEqualTo(String value) {
            addCriterion("food_picture =", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureNotEqualTo(String value) {
            addCriterion("food_picture <>", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureGreaterThan(String value) {
            addCriterion("food_picture >", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureGreaterThanOrEqualTo(String value) {
            addCriterion("food_picture >=", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureLessThan(String value) {
            addCriterion("food_picture <", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureLessThanOrEqualTo(String value) {
            addCriterion("food_picture <=", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureLike(String value) {
            addCriterion("food_picture like", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureNotLike(String value) {
            addCriterion("food_picture not like", value, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureIn(List<String> values) {
            addCriterion("food_picture in", values, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureNotIn(List<String> values) {
            addCriterion("food_picture not in", values, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureBetween(String value1, String value2) {
            addCriterion("food_picture between", value1, value2, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andFoodPictureNotBetween(String value1, String value2) {
            addCriterion("food_picture not between", value1, value2, "foodPicture");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Integer> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Integer> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andFoodLocationIsNull() {
            addCriterion("food_location is null");
            return (Criteria) this;
        }

        public Criteria andFoodLocationIsNotNull() {
            addCriterion("food_location is not null");
            return (Criteria) this;
        }

        public Criteria andFoodLocationEqualTo(String value) {
            addCriterion("food_location =", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationNotEqualTo(String value) {
            addCriterion("food_location <>", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationGreaterThan(String value) {
            addCriterion("food_location >", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationGreaterThanOrEqualTo(String value) {
            addCriterion("food_location >=", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationLessThan(String value) {
            addCriterion("food_location <", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationLessThanOrEqualTo(String value) {
            addCriterion("food_location <=", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationLike(String value) {
            addCriterion("food_location like", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationNotLike(String value) {
            addCriterion("food_location not like", value, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationIn(List<String> values) {
            addCriterion("food_location in", values, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationNotIn(List<String> values) {
            addCriterion("food_location not in", values, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationBetween(String value1, String value2) {
            addCriterion("food_location between", value1, value2, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andFoodLocationNotBetween(String value1, String value2) {
            addCriterion("food_location not between", value1, value2, "foodLocation");
            return (Criteria) this;
        }

        public Criteria andTimeTipsIsNull() {
            addCriterion("time_tips is null");
            return (Criteria) this;
        }

        public Criteria andTimeTipsIsNotNull() {
            addCriterion("time_tips is not null");
            return (Criteria) this;
        }

        public Criteria andTimeTipsEqualTo(String value) {
            addCriterion("time_tips =", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsNotEqualTo(String value) {
            addCriterion("time_tips <>", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsGreaterThan(String value) {
            addCriterion("time_tips >", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsGreaterThanOrEqualTo(String value) {
            addCriterion("time_tips >=", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsLessThan(String value) {
            addCriterion("time_tips <", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsLessThanOrEqualTo(String value) {
            addCriterion("time_tips <=", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsLike(String value) {
            addCriterion("time_tips like", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsNotLike(String value) {
            addCriterion("time_tips not like", value, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsIn(List<String> values) {
            addCriterion("time_tips in", values, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsNotIn(List<String> values) {
            addCriterion("time_tips not in", values, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsBetween(String value1, String value2) {
            addCriterion("time_tips between", value1, value2, "timeTips");
            return (Criteria) this;
        }

        public Criteria andTimeTipsNotBetween(String value1, String value2) {
            addCriterion("time_tips not between", value1, value2, "timeTips");
            return (Criteria) this;
        }

        public Criteria andFoodDescIsNull() {
            addCriterion("food_desc is null");
            return (Criteria) this;
        }

        public Criteria andFoodDescIsNotNull() {
            addCriterion("food_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFoodDescEqualTo(String value) {
            addCriterion("food_desc =", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescNotEqualTo(String value) {
            addCriterion("food_desc <>", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescGreaterThan(String value) {
            addCriterion("food_desc >", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescGreaterThanOrEqualTo(String value) {
            addCriterion("food_desc >=", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescLessThan(String value) {
            addCriterion("food_desc <", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescLessThanOrEqualTo(String value) {
            addCriterion("food_desc <=", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescLike(String value) {
            addCriterion("food_desc like", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescNotLike(String value) {
            addCriterion("food_desc not like", value, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescIn(List<String> values) {
            addCriterion("food_desc in", values, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescNotIn(List<String> values) {
            addCriterion("food_desc not in", values, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescBetween(String value1, String value2) {
            addCriterion("food_desc between", value1, value2, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodDescNotBetween(String value1, String value2) {
            addCriterion("food_desc not between", value1, value2, "foodDesc");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagIsNull() {
            addCriterion("food_state_flag is null");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagIsNotNull() {
            addCriterion("food_state_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagEqualTo(Integer value) {
            addCriterion("food_state_flag =", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagNotEqualTo(Integer value) {
            addCriterion("food_state_flag <>", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagGreaterThan(Integer value) {
            addCriterion("food_state_flag >", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_state_flag >=", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagLessThan(Integer value) {
            addCriterion("food_state_flag <", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagLessThanOrEqualTo(Integer value) {
            addCriterion("food_state_flag <=", value, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagIn(List<Integer> values) {
            addCriterion("food_state_flag in", values, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagNotIn(List<Integer> values) {
            addCriterion("food_state_flag not in", values, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagBetween(Integer value1, Integer value2) {
            addCriterion("food_state_flag between", value1, value2, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andFoodStateFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("food_state_flag not between", value1, value2, "foodStateFlag");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeIsNull() {
            addCriterion("put_time is null");
            return (Criteria) this;
        }

        public Criteria andPutTimeIsNotNull() {
            addCriterion("put_time is not null");
            return (Criteria) this;
        }

        public Criteria andPutTimeEqualTo(Date value) {
            addCriterion("put_time =", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotEqualTo(Date value) {
            addCriterion("put_time <>", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeGreaterThan(Date value) {
            addCriterion("put_time >", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("put_time >=", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeLessThan(Date value) {
            addCriterion("put_time <", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeLessThanOrEqualTo(Date value) {
            addCriterion("put_time <=", value, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeIn(List<Date> values) {
            addCriterion("put_time in", values, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotIn(List<Date> values) {
            addCriterion("put_time not in", values, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeBetween(Date value1, Date value2) {
            addCriterion("put_time between", value1, value2, "putTime");
            return (Criteria) this;
        }

        public Criteria andPutTimeNotBetween(Date value1, Date value2) {
            addCriterion("put_time not between", value1, value2, "putTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNull() {
            addCriterion("down_time is null");
            return (Criteria) this;
        }

        public Criteria andDownTimeIsNotNull() {
            addCriterion("down_time is not null");
            return (Criteria) this;
        }

        public Criteria andDownTimeEqualTo(Date value) {
            addCriterion("down_time =", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotEqualTo(Date value) {
            addCriterion("down_time <>", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThan(Date value) {
            addCriterion("down_time >", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("down_time >=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThan(Date value) {
            addCriterion("down_time <", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeLessThanOrEqualTo(Date value) {
            addCriterion("down_time <=", value, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeIn(List<Date> values) {
            addCriterion("down_time in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotIn(List<Date> values) {
            addCriterion("down_time not in", values, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeBetween(Date value1, Date value2) {
            addCriterion("down_time between", value1, value2, "downTime");
            return (Criteria) this;
        }

        public Criteria andDownTimeNotBetween(Date value1, Date value2) {
            addCriterion("down_time not between", value1, value2, "downTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}