package com.darksouls.tool;


import java.util.Date;

public class idea implements Comparable{
    public static void main(String[] args) {

        /**
         * 100.for
         */
        int t = 100;
        for (int i = 0; i < t; i++) {
            new Date();
        }
        test();
        /**
         * new date().sout
         */ System.out.println(new Date());
        System.out.println(new Date());

        /**
         * ctrl + alt + ]
         * ctrl + alt + [
         * 跳转到上一个或者下一个项目窗口
         */

        /**‘
         * ctrl + e 切换当前文件
         * ctril +shift + e 切换修改过得文件
         */

        /**
         * ctrl + shift + a 查找帮助
         */
        /**
         * ctrl+ alt + <-
         */

        /**
         * 例如书签进行跳转
         * f11
         * ctrl + f11代表书签选择位置
         */

        /**
         * 收藏功能
         * alt + shift + f
         */

        /**
         * 文件区和编辑区得的跳转
         *alt + 1 从编辑区跳转到文件去
         * esc可以从文件区域跳转到编辑区
         */

        /**
         * 利用VIM进行编程
         * ctrl + w 跳转到另外一个窗口
         */
        /**
         * 在文件区按CTRL +N 可以搜索一个包的类
         */

        /**
         *
         * 找寻文件
         * CTRL + shift + N
         */
        /**
         *找寻函数名
         * ctrl + alt + shift + N
         */

        /**
         * live template
         * 自定义方法缩略
         * ps
         * pi
         */

        /**
         * postfix
         * 100.for
         * .filed创建get、set方法的时候同时把对象创建出来
         * user.r
         * nn
         * .sout
         * .for
         * user.nn = if(user != null)
         */

        /**
         * alter + enter
         * 自动纠错
         */

    }

    /**
     * 重构代码中重构变量
     * @param ppp
     * 例如参数ppp为学生的姓名
     * 可以使用shift + f6 对代码进行重构
     * ctrl + f6 对函数进行重构
     * @param addParam1
     */
    public void pirnt(int ppp, int addParam1){
        int param1 = getOut(addParam1);
        int param;
        param = ppp;
        System.out.println(param1);
    }

    /**
     * 使用快捷键ctrl + alt + m对语句进行函数的封装
     * @param addParam1
     * @return
     */
    private int getOut(int addParam1) {
        int param1 = addParam1;
        int param = param1;
        return param1;
    }
    /**
     * local history 使用本地的记录来查看文件修改的情况
     * 存储在本地的类似git的版本控制和local history一个标签底下的
     * 可以手动创建一个存档
     */

    /**
     * spring的关联功能
     */

    /**
     * 数据库的关联，使用Database的集成
     */

    /**
     * 关于断点
     * 条件断点例如当i == 50的时候再断
     */
    public static void test(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }


    public  int compareTo(Object o) {
        return 0;
    }
    /**
     * 在debug中使用表达式求值
     * alt + f8
     */
    /**
     * debug中跳转到指定位置
     * alt + f9
     */
    /**
     * set value
     * debug中在debug的窗口按f8
     * 就是设置值
     */
    /**
     * 其他操作
     * 文件操作
     * ctrl + a 全选操作
     *f5 可以复制当前文件
     * f6可以移动文件
     * 对着文件ctrl + c 复制的是文件的名字 note.md
     * ctrl+shift+c代表复制的绝对路径
     * ctrl +shift + v 可以打开剪切板
     */

    /**
     * 结构图
     * ctrl  + f12
     */

    /**
     * 查看maven类图和依赖
     * 右键点击maven然后点击查看即可
     */

    /**
     *查看继承关系
     * alt + shift + ctrl + u
     * 查看ctrl+h查看结构
     * ctrl + alt + h查看函数被调用情况
     */


}
