# coding
学习数据结构和算法
coding with java
## AlgorithmsBook包下是普林斯顿算法课大作业和课后题（暂时停更）
## Important是一些重要的基础算法，各种排序算法，KMP，Mnacher等等
## Interview是做过的面试题
## Offer是剑指offer上的题

# 4月22日-周一
## 工作完成情况
1. **~~~~**

---
## 技能学习
1. **学习了VLAN的知识，交换机的访问链接和汇聚链接**

---
## 算法学习
无

---

## 知识点学习
### Go的Gin框架
&emsp;&emsp;Gin是用Golang写的Web框架。它的API与Martini十分相似，但拥有好得多的性能，由于有httprouter的帮助，快将近40倍。
- [安装](#install)
- [前提](#前提)
- [API示例](#API示例)  
    - [使用GET，POST，PUT，PATCH，DELETE和OPTIONS](#使用GET，POST，PUT，PATCH，DELETE和OPTIONS)
    - [Path中的参数](#Path中的参数)

<a name="install"></a>  
## 安装
首先需要安装Golang并设置Go的workspace。
1. 下载并安装Gin
```sh
$ go get -u github.com/gin-gonic/gin
```
2. 在代码中引入它
```go
import "github.com/gin-gonic/gin"
```
3. (可选)引入net/http包，例如使用http.StatusOK这样的常量会需要
```go
import "net/http"
```

## 前提
Gin需要Go 1.7及以上版本，建议使用Go 1.8以上。

## 用[jsoniter](https://github.com/json-iterator/go)构建
Gin使用`encoding/json`作为默认的json包，不过你可以使用build参数来将他改成[jsoniter](https://github.com/json-iterator/go)。
```sh
$ go build -tags=jsoniter .
```
