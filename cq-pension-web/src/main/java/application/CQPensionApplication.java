package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhd
 * @date 2020/9/24
 */
@SpringBootApplication(scanBasePackages = {"com.cqp.controller", "com.cqp.service.provider"})
@MapperScan("com.cqp.mapper")
public class CQPensionApplication {
    public static void main(String[] args){
      SpringApplication.run(CQPensionApplication.class, args);
    }
}
