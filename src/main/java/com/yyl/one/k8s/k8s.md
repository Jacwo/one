查询所有命名空间上的pod
kubectl get pod -o wide --all-namespaces
查询podIp
kubecl get services
查看日志
kubectl logs xxx -n namespace
eg:
kubectl logs rg-linkid-65bd7b5f5f-9dvnv -n ruijie-sourceid 
查看pod描述
kubectl describe pod xxx -n namespace
eg
kubectl describe pod rg-sso-6fbc76488b-rkdjp -n ruijie-sourceid
通过yaml文件删除
kubectl delete -f xxx.ymal
删除应用
kubectl delete deployment xxx -n namespace
Deployment StatefulSet DaemonSet ReplicaSet
StatefulSet用于管理有状态应用的工作负载对象，与ReplicaSet和Deployment
这两个对象不同，StatefulSet不仅能管理Pod的对象，他还能保存Pod的顺序性和唯一性
与Deployment一样，StatefulSet也使用规格说明中声明的template模板来创建Pod资源，但是这些Pod相互之间不能替换
除此之外StatefulSet会为每个pod设置一个单独的持久符，这些标识符发生调度时候也不会丢失


