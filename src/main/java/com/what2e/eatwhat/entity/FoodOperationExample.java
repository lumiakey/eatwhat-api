package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.List;

public class FoodOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodOperationExample() {
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

        public Criteria andFoodOperationIdIsNull() {
            addCriterion("food_operation_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdIsNotNull() {
            addCriterion("food_operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdEqualTo(Integer value) {
            addCriterion("food_operation_id =", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdNotEqualTo(Integer value) {
            addCriterion("food_operation_id <>", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdGreaterThan(Integer value) {
            addCriterion("food_operation_id >", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_operation_id >=", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdLessThan(Integer value) {
            addCriterion("food_operation_id <", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdLessThanOrEqualTo(Integer value) {
            addCriterion("food_operation_id <=", value, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdIn(List<Integer> values) {
            addCriterion("food_operation_id in", values, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdNotIn(List<Integer> values) {
            addCriterion("food_operation_id not in", values, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdBetween(Integer value1, Integer value2) {
            addCriterion("food_operation_id between", value1, value2, "foodOperationId");
            return (Criteria) this;
        }

        public Criteria andFoodOperationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("food_operation_id not between", value1, value2, "foodOperationId");
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

        public Criteria andOperIsNull() {
            addCriterion("oper is null");
            return (Criteria) this;
        }

        public Criteria andOperIsNotNull() {
            addCriterion("oper is not null");
            return (Criteria) this;
        }

        public Criteria andOperEqualTo(String value) {
            addCriterion("oper =", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotEqualTo(String value) {
            addCriterion("oper <>", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThan(String value) {
            addCriterion("oper >", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThanOrEqualTo(String value) {
            addCriterion("oper >=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThan(String value) {
            addCriterion("oper <", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThanOrEqualTo(String value) {
            addCriterion("oper <=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLike(String value) {
            addCriterion("oper like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotLike(String value) {
            addCriterion("oper not like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperIn(List<String> values) {
            addCriterion("oper in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotIn(List<String> values) {
            addCriterion("oper not in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperBetween(String value1, String value2) {
            addCriterion("oper between", value1, value2, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotBetween(String value1, String value2) {
            addCriterion("oper not between", value1, value2, "oper");
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