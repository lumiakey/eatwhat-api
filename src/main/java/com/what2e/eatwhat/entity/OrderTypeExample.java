package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderTypeExample() {
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

        public Criteria andOrderTypeNameIsNull() {
            addCriterion("order_type_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameIsNotNull() {
            addCriterion("order_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameEqualTo(String value) {
            addCriterion("order_type_name =", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotEqualTo(String value) {
            addCriterion("order_type_name <>", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameGreaterThan(String value) {
            addCriterion("order_type_name >", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_type_name >=", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLessThan(String value) {
            addCriterion("order_type_name <", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLessThanOrEqualTo(String value) {
            addCriterion("order_type_name <=", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameLike(String value) {
            addCriterion("order_type_name like", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotLike(String value) {
            addCriterion("order_type_name not like", value, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameIn(List<String> values) {
            addCriterion("order_type_name in", values, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotIn(List<String> values) {
            addCriterion("order_type_name not in", values, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameBetween(String value1, String value2) {
            addCriterion("order_type_name between", value1, value2, "orderTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNameNotBetween(String value1, String value2) {
            addCriterion("order_type_name not between", value1, value2, "orderTypeName");
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