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
