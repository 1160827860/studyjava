# 发现一个问题：
创建一个分支继承之后，删掉一部分内容，然后让主分支合并这个分支之后，
再将分支回滚到为合并之前，这样再合并，就不会再将删除内容合并上。

原因应该是当时主分支在删除其他内容之前的结点，然后合并system分支同
步了结点，所以仅合并之后的修改。

下面做一个实验：见节点图master再合并system分支
![avatar](https://img-blog.csdnimg.cn/201912151358262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2Rhcmtfc291bHM=,size_16,color_FFFFFF,t_70)

