# AopAspectjSample
Aop结合AspectJ 实现 静态插莊的功能

## 1、前言

最初的做法：
在 aspectjlib中定义切面，实现插莊逻辑。在 app 模块中依赖 aspectjlib,  能够实现插莊功能。但是，在将aspectjlib 打包成aar,提供给app 引用时，插莊失败。  
通过对两种方式的编译过程发现，二者是不同的。  目前我的猜测是，作为aar使用时，先编译的是app的代码然后再编译aar的代码 ， 使得AspectJ程序未能与目标程序关联成功。  

改进后的做法：
在实际项目中，例如做埋点统计的项目中，我们不得不将AspectJ程序作为sdk，提供给多个app使用，那我们该如何解决上面的问题呢？  
我们可以通过自定义gradle插件来实现。

具体的做法：  
将上述 app 和 library 中 aspectj相关的配置写到插件中，需要的切面作为独立的库也写到 插件中，那具体的插莊逻辑通过工具类在sdk 中实现即可。



