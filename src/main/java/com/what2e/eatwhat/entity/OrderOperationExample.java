package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderOperationExample() {
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

        public Criteria andOrderOperationIdIsNull() {
            addCriterion("order_operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdIsNotNull() {
            addCriterion("order_operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdEqualTo(Integer value) {
            addCriterion("order_operation_id =", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdNotEqualTo(Integer value) {
            addCriterion("order_operation_id <>", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdGreaterThan(Integer value) {
            addCriterion("order_operation_id >", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_operation_id >=", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdLessThan(Integer value) {
            addCriterion("order_operation_id <", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_operation_id <=", value, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdIn(List<Integer> values) {
            addCriterion("order_operation_id in", values, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdNotIn(List<Integer> values) {
            addCriterion("order_operation_id not in", values, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdBetween(Integer value1, Integer value2) {
            addCriterion("order_operation_id between", value1, value2, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderOperationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_operation_id not between", value1, value2, "orderOperationId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdIsNull() {
            addCriterion("order_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdIsNotNull() {
            addCriterion("order_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdEqualTo(Integer value) {
            addCriterion("order_type_id =", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdNotEqualTo(Integer value) {
            addCriterion("order_type_id <>", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdGreaterThan(Integer value) {
            addCriterion("order_type_id >", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type_id >=", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdLessThan(Integer value) {
            addCriterion("order_type_id <", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_type_id <=", value, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdIn(List<Integer> values) {
            addCriterion("order_type_id in", values, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdNotIn(List<Integer> values) {
            addCriterion("order_type_id not in", values, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("order_type_id between", value1, value2, "orderTypeId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type_id not between", value1, value2, "orderTypeId");
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