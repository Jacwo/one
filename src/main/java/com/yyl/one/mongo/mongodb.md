### mongodb是什么
 是一个开源文档数据库，提供高性能、高可用性和自动扩展的功能
### 特性
面向集合存储，易于存储对象类型数据，模式自由，支持动态查询，支持完全索引
支持复制和故障恢复
### 存储结构

    mongodb文档存储结构分为四个层次，从小到大依次是：键值对、文档、集合、数据库
    mysql       mongodb
    database     database
    table        collection
    row          document
    column       field
    table join   不支持
    primary key   primary 
键值对

    文档数据库存储结构的基本单位是键值对，具体包含具体键和值，键一般为字符串，值得
    格式可以包含字符串，数组，数值，文档等类型
    
文档
    
    文档时monfodb的核心概念，是数据的基本单元，与关系数据库的行十分类似，但是比行还要复杂
    文档是一组有序的键值对集合，文档的数据结构和json基本相同，所有存储zai集合中的数据
    大都是bjson
集合

    mongodb将文档存储在集合中，一个集合就是一些文档构成的对象
    集合存在于数据库中，没有固定的结构，这意味着用户可以插入不同格式和类型的数据
    但通常情况插入集合的数据都会有一定的关联性，即一个集合中的文档应该具有关联性
数据库
 
    在mongodb中数据库由集合组成一个mongodb实例可以承载多个数据库，互相之间可以彼此
    独立，在开发过程中，通常一个应用的所有数据存储到同一个数据库中，mongofb将不同数据库存放
    在不同文件中
### 常用命令
    
    show dbs；
    use test
    db.test.insert({item:"card",qty:15})
    db.test.find()
    db.test.update({item:"card"},{$set:{qty:35}})
    db.createCollection ("person", {collation: {locale: "zh" }})    //创建集合并指定语言
    db.person.insert ({name: ”张三”}）
    db.person.insert ({name:"李四”}）
    db.person.insert ({name: ”王五"}）
    db.person.insert ({name: ”马六”}）
    db.person.insert ({name:"张七"})
    db.person.find().sort({name: 1}) //查询并排序
    db.collection.save ( obj )
        
    db.test.remove({'title':'mongodb'})
    第一条语句删除集合下所有的文档，第二条语句删除 status 等于 A 的全部文档，第三条语句删除 status 等于 D 的一个文档。
    db.collection.deleteMany ({})
    db.collection.deleteMany ({ status : "A" })
    db.collection.delete.One ({ status : "D" })
    查询
    db.test.find( {price : 24} )     ===》》where price = 24
    db.test.find( {price : {$gt : 24}} )  ===》》where price > 24
    db.test.find( {price : {$lt : 24}} )  ===》》where price < 24
    db.test.find( {price : {$gte : 24}} )  ===》》where price >= 24
    db.test.find( {price : {$lte : 24}} ) ===》》where price <= 24
    db.test.find( {price : {$ne : 24}} ) ===》》 where price != 24
    db.test.find( {$or:[{name : "2"},{price : 24}]} ) where name = "2" or price = 24