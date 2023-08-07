package cn.saglow.java.exercise.day5;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 还钱
 * Author: HW
 * Date: 2023/7/23
 */
public class Loan {
    public static List<RepaymentPlan> calculate2(BigDecimal loanAmount, BigDecimal annualInterestRate, Integer loanYears, LocalDate loanStartTime) {
        BigDecimal lunarInterestRate =  annualInterestRate.divide(new BigDecimal(12),12, BigDecimal.ROUND_HALF_UP);
        BigDecimal loanTerm = new BigDecimal(loanYears * 12);
        BigDecimal monthlyPayment = loanAmount.multiply(lunarInterestRate)
                .multiply(lunarInterestRate.add(BigDecimal.ONE).pow(loanTerm.intValue()))
                .divide(lunarInterestRate.add(BigDecimal.ONE).pow(loanTerm.intValue()).subtract(BigDecimal.ONE), 2, BigDecimal.ROUND_HALF_UP);
//        BigDecimal totalInterest = loanTerm.multiply(monthlyPayment);
        List<RepaymentPlan> list = new ArrayList<>();
        RepaymentPlan plan = new RepaymentPlan();
        RepaymentPlan lastPlan = new RepaymentPlan();
        lastPlan.remainingAmount = loanAmount;
        for (int i = 0; i < loanTerm.intValue(); i++) {
            plan = new RepaymentPlan();
            plan.paymentDate = loanStartTime.plusMonths(i + 1);
            plan.paymentAmount = monthlyPayment;
            plan.interestAmount = lastPlan.remainingAmount.multiply(lunarInterestRate).setScale(2,BigDecimal.ROUND_HALF_UP);
            plan.principalAmount = plan.paymentAmount.subtract(plan.interestAmount);
            plan.remainingAmount = lastPlan.remainingAmount.subtract(plan.principalAmount);
            if (i == loanTerm.intValue() - 1) {
                plan.paymentAmount.add(plan.remainingAmount);
                plan.principalAmount.add(plan.remainingAmount);
                plan.remainingAmount=BigDecimal.ZERO;
            }
            list.add(plan);
            lastPlan.remainingAmount = plan.remainingAmount;
        }
        return list;
    }

    public static void main(String[] args) {
        BigDecimal loanAmount = new BigDecimal("2000000.00");
        BigDecimal annualInterestRate = new BigDecimal("0.0550");
        Integer loanYears = 30;
        LocalDate loanStartTime = LocalDate.of(2023,7,31);
        List<RepaymentPlan> list = calculate2(loanAmount,annualInterestRate,loanYears,loanStartTime);
        list.forEach(System.out::println);
    }
    @Data
    private static class RepaymentPlan{
        private LocalDate paymentDate;
        private BigDecimal paymentAmount;
        private BigDecimal principalAmount;
        private BigDecimal interestAmount;
        private BigDecimal remainingAmount;
    }
    @Data
    private static class A {
        private RepaymentPlan repaymentPlan;
        private String name;
        private Integer age;
        private String alias;
    }
    public static String a = """
            {
                "name":"cango",
                "age":"12",
                "alias":"mongo",
                "repaymentPlan":{
                   "paymentDate":"2023-12-1",
                   "paymentAmount":"2023.12",
                   "principalAmount":"2023.12",
                   "interestAmount":"2023.3",
                   "remainingAmount":"2023.12"
               }
            }
            """;

    public static String loanString = """
           [
           {
               "paymentDate":"2023-12-1",
               "paymentAmount":"2023.12",
               "principalAmount":"2023.12",
               "interestAmount":"2023.3",
               "remainingAmount":"2023.12"
           },
           {
               "paymentDate":"2023-12-2",
               "paymentAmount":"2023.1",
               "principalAmount":"2023.1",
               "interestAmount":"2023.3",
               "remainingAmount":"2023.12"
           }
           ]
           """; // List<RepaymentPlan> RepaymentPlan[]
          // List<Map>
}

