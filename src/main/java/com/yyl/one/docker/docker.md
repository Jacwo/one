### Docker基本概念
- 镜像 Image  类
- 容器 Container  对象
- 仓库 Repository
### Docker容器
镜像和容器的关系就像是面向对象程序设计中的类和实例一样，镜像是静态的定义，容器是镜像运行的实体，容器可以创建、启动、停止、删除、暂停

容器的实质就是进程，但与直接在宿主执行的进程不同，容器进程属于运行于自己独立的命名空间，因此容器可以拥有自己的root文件系统，自己的
网络配置，自己的进程空间，甚至自己的用户iD空间，容器内的进程是运行在一个隔离的环境里，使用起来，就好像是在一个独立与宿主系统下操作一样
这种特性使得容器封装的应用比直接在宿主运行更加安全，也因为这种隔离的特性。

### docker仓库
镜像构建完成后，可以很容易的在当前宿主机上运行，但是如果需要在其他服务器上使用这个镜像，我们就需要一个集中的存储、分发镜像的服务，Docker
Registry就是这样的服务

一个docker registry中可以包含多个仓库，每个仓库可以包含多个标签，每个标签对应一个镜像
### docker离线部署
---执行 docker pull */mgob:1.0
---查看镜像  docker images
 
	---执行 docker save e981a4c3e009 > mgob.tar   image id
---查看打好包的镜像
 
---想办法拷贝下来然后上传到部署的master服务器
---然后进入上传的目录执行 docker load < mgob.tar
 
--- 然后执行docker images发现有个镜像没有tag标识，记录images id
 
---最后执行 docker tag e981a4c3e009 id.ruijie.com.cn:25082/sourceid/mgob:1.0
---然后查看镜像 docker images

