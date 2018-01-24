package edu.picturedlsys.test;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.regex.Pattern;

public class ImgSrcTest extends TestCase{

    @Test
    public void test(){
        String imgSrc = "http://img1.gtimg.com/ninja/2/2018/01/ninja151632848838076.jpg";
        if(imgSrc.contains(".jpg")||imgSrc.contains(".png")||imgSrc.contains(".jpeg")){
            System.out.println("ok");
        }

    }

}
