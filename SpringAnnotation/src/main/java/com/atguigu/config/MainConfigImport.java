package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.Red;
import com.atguigu.config.importSelector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//默认快速导入组件，id默认是组件的全类名com.atguigu.bean.Color
@Import({Color.class, Red.class, MyImportSelector.class})
public class MainConfigImport {

}
