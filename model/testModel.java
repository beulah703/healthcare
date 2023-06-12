package spring.mail.orm.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tests1")
public class testModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int testId;

    @Column(name = "test_name", length = 100)
    private String testName;

    @Column(name = "test_catg_id", length = 6)
    private String testCategoryId;

    @Column(name = "test_price")
    private double testPrice;
    @Column(name = "test_method", length = 100)
    private String testMethod;

    @Column(name = "test_normalrangefrom", length = 100)
    private String testNormalRangeFrom;

    @Column(name = "test_normalrangeto", length = 100)
    private String testNormalRangeTo;

    public testModel() {
    	super();
    }

    public testModel(String testName, String testCategoryId, double testPrice, String testMethod,
                     String testNormalRangeFrom, String testNormalRangeTo) {
        this.testName = testName;
        this.testCategoryId = testCategoryId;
        this.testPrice = testPrice;
        this.testMethod = testMethod;
        this.testNormalRangeFrom = testNormalRangeFrom;
        this.testNormalRangeTo = testNormalRangeTo;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestCategoryId() {
        return testCategoryId;
    }

    public void setTestCategoryId(String testCategoryId) {
        this.testCategoryId = testCategoryId;
    }

    public double getTestPrice() {
        return testPrice;
    }

    public void setTestPrice(double testPrice) {
        this.testPrice = testPrice;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getTestNormalRangeFrom() {
        return testNormalRangeFrom;
    }

    public void setTestNormalRangeFrom(String testNormalRangeFrom) {
        this.testNormalRangeFrom = testNormalRangeFrom;
    }

    public String getTestNormalRangeTo() {
        return testNormalRangeTo;
    }

    public void setTestNormalRangeTo(String testNormalRangeTo) {
        this.testNormalRangeTo = testNormalRangeTo;
    }
}

