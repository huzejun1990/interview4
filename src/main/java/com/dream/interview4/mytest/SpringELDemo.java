package com.dream.interview4.mytest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Auther: huzejun
 * @Date: 2024/9/23 14:02
 */
@Slf4j
public class SpringELDemo {

    public static void main(String[] args) {

        //1 log日志点位符{}替换
        log.info("log:{}","abcd");
        System.out.println();

        //2 String.format 点位符替换
        String result = String.format("%s,java", "爱自由 study");
        System.out.println(result);
        System.out.println();

        //3 SpringELExpress表达式 #号后面的内容可以被具体替换
        String var = "#userid";

        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(var);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("userid", "2");

        String s = expression.getValue(context).toString();

        System.out.println(s);

    }
}
