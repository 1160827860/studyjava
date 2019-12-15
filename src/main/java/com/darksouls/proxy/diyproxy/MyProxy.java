package com.darksouls.proxy.diyproxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
    public static Object newProxyInstance(Class infce ,InvocationHandler h) throws Exception{
        String rt = "\r\n";
        String methodStr = "";

        for(Method m : infce.getMethods()){
            methodStr += " @Override" +rt +
                    "public void "+m.getName() +"() {" + rt  +
//            "System.out.println(\"汽车开始行驶\");"+ rt +
//                    "  long starttime = System.currentTimeMillis();" + rt +
//            "m." +m.getName() + "();" +rt +
//                    "     long endtime =  System.currentTimeMillis();"+ rt +
//                    "          System.out.println(\"汽车运行时间\" + (endtime - starttime));"+ rt +
//                    "               System.out.println(\"汽车结束启动了\" + new Date());"+ rt +
//                    "    }";
                    "try{" +rt +
                    "Method md =" + infce.getName() + ".class.getMethod(\""
                                               + m.getName() +"\");" + rt +
            "h.invoke(this,md);" + rt +
                    "}catch(Exception e){e.printStackTrace();}" + rt +
            "};";

        }

        String str =
         "package com.imooc.mode.com.proxy.diyproxy;"  + rt +
            "import com.imooc.mode.com.proxy.diyproxy.InvocationHandler;" + rt +
            "import com.imooc.mode.com.proxy.Moveable;"+ rt +
                 "import java.lang.reflect.Constructor;" + rt +
                 "import java.lang.reflect.Method;" +rt +
                 "import java.util.Date; "   + rt +
            " import java.util.Random;   "+ rt +


                 "  class $Proxy0 implements "+ infce.getName()+"{"+ rt +
//                 " private "+ infce.getName()+" m ;   " + rt +
                 "private InvocationHandler h;" +rt +
//                 "  public $Proxy0 ("+ infce.getName()+" m){   " + rt +
                 "  public $Proxy0 (InvocationHandler h){   " + rt +
                 "    super();   " + rt +
//                 "   this.m = m;   " + rt +
                 "   this.h = h;   " + rt +
                 "  }"  + rt +

                 methodStr + rt+
        " }";

        String filename = System.getProperty("user.dir") + "/src/main/java/com/imooc/mode/com.proxy/diyproxy/$Proxy.java";
        File file = new File(filename);
        try {
            FileUtils.writeStringToFile(file,str);
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            /**
             * 文件管理者
             */
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            /**
             * 获取文件
             */
            Iterable units = fileManager.getJavaFileObjects(filename);

            /**
             * 编译任务
             */
            JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
            t.call();
            fileManager.close();
            /**
             *load到内存
             */
            ClassLoader cl = ClassLoader.getSystemClassLoader();

            Class c = cl.loadClass("com.imooc.mode.com.proxy.diyproxy.$Proxy0");

//            System.out.println(c.getName());

            Constructor ctr = c.getConstructor(InvocationHandler.class);

            return ctr.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
