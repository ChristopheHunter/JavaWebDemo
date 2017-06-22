/**
 * Created by zy_git on 2017/6/22.
 */
document.writeln("Hello,wolrd!")
document.writeln("你好，世界！")

var p1 = {
    name : "Tony",
    age : "24",
    friends :{
        f1 : "zhangsan1",
        f1 : "zhangsan2",
        f1 : {
            name: "zhangsan3"
        }
    },
    fun1:function () {
        document.writeln("函数调用成功")
        document.writeln(this.name)
        document.writeln(this.age)
    }
}

var Quo = function (string) {
  this.a = string;
};

Quo.prototype.get

document.writeln(p1.friends.f1.name)
p1.fun1()
// alert("你好世界！")

