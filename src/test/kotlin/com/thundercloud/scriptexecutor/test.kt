package com.thundercloud.scriptexecutor

import org.junit.Test
import javax.servlet.ServletContextListener

class test {
    @Test
    fun blah(){
        System.out.println(ServletContextListener::class.java.getClassLoader().getResource("azureExport.bat").toString().substring(5))
    }
}