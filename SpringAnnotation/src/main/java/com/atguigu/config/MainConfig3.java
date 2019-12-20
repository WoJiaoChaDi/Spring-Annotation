package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.config.condition.LinuxCondition;
import com.atguigu.config.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig3 {

    /*
    * @Conditional({Condition})：按照一定条件进行判断，满足条件给容器中注册bean
    * 如果系统是windows，则注册bill
    * 如果系统是linux，则注册linus
    *
    * */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person_Bill(){
        return new Person("Bill Gates", 40);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person_Linus(){
        return new Person("Linus", 35);
    }
}
